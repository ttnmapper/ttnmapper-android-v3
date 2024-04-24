package org.ttnmapper.phonesurveyor.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Binder
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import info.mqtt.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.utils.AppConstants
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.sanitiseMqttUri
import java.util.Date
import kotlin.concurrent.thread


class MyService : Service() {
    private val TAG = MyService::class.java.getName()

    private val myBinder = MyLocalBinder()

    var mqttAndroidClient: MqttAndroidClient? = null

    lateinit var sharedPref: SharedPreferences

    var serverUri = "tcp://eu.thethings.network:1883"
    var clientId = ""
    var mqttUsername = ""
    var mqttPassword = ""

    var handlerMqttStatus = Handler()
    var handlerGpsStatus = Handler()

    var locationManager: LocationManager? = null
//    var locationListener: LocationListener? = null

    var selfStop = false

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    override fun onCreate() {
        super.onCreate()

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        if(startLocationTracking()) {
            startMQTTConnection()
        } else {
            selfStop = true
            AppAggregate.stopService()
        }
    }

    override fun onDestroy() {
        stopMQTTConnection()
        stopLocationTracking()
        super.onDestroy()
    }

    fun startMQTTConnection() {
        setMQTTStatusMessage("MQTT connecting")

        serverUri = sanitiseMqttUri(sharedPref.getString(getString(R.string.PREF_MQTT_BROKER), serverUri) ?: "")
        clientId = MqttClient.generateClientId()

        mqttAndroidClient = MqttAndroidClient(SurveyorApp.instance, serverUri, clientId).apply {
//            mNotification?.let { setForegroundService(it, 1000) }
        }
        mqttAndroidClient?.setCallback(object : MqttCallbackExtended {
            override fun connectComplete(b: Boolean, s: String) {
                Log.w("mqtt", s)

                val disconnectedBufferOptions = DisconnectedBufferOptions()
                disconnectedBufferOptions.isBufferEnabled = true
                disconnectedBufferOptions.bufferSize = 100
                disconnectedBufferOptions.isPersistBuffer = false
                disconnectedBufferOptions.isDeleteOldestMessages = false
                mqttAndroidClient?.setBufferOpts(disconnectedBufferOptions)
                subscribeToTopic()
            }

            override fun connectionLost(throwable: Throwable?) {
                Log.w("mqtt", "Connection lost")
                setMQTTStatusMessage("MQTT connection lost - reconnecting")
            }

            override fun messageArrived(topic: String, mqttMessage: MqttMessage) {
                Log.d("Mqtt", topic + ": " + mqttMessage.toString())
                setMQTTCountupMessage(Date())

                thread(start = true) {
                    AppAggregate.processMessage(mqttMessage.toString())
                }
            }

            override fun deliveryComplete(iMqttDeliveryToken: IMqttDeliveryToken) {

            }
        })
        connect()
    }

    fun stopMQTTConnection() {
        mqttAndroidClient?.setCallback(object : MqttCallbackExtended {
            override fun connectComplete(reconnect: Boolean, serverURI: String?) {
                Log.w("mqtt", "connectComplete")
            }

            override fun messageArrived(topic: String?, message: MqttMessage?) {
                Log.w("mqtt", "messageArrived")
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                Log.w("mqtt", "deliveryComplete")
            }

            override fun connectionLost(throwable: Throwable?) {
                if (!selfStop) {
                    Log.w("mqtt", "Connection lost")
                    setMQTTStatusMessage("MQTT disconnected - mapping stopped")
                }
            }
        })
        mqttAndroidClient?.disconnect()
    }

    fun setCallback(callback: MqttCallbackExtended) {
        mqttAndroidClient?.setCallback(callback)
    }

    private fun connect() {
        mqttUsername = sharedPref.getString(getString(R.string.PREF_MQTT_USERNAME), mqttUsername).toString()
        mqttPassword = sharedPref.getString(getString(R.string.PREF_MQTT_PASSWORD), mqttPassword).toString()

        Log.e(TAG, "Using MQTT username: " + mqttUsername)
        Log.e(TAG, "Using MQTT password: " + mqttPassword)

        val mqttConnectOptions = MqttConnectOptions()
        mqttConnectOptions.isAutomaticReconnect = true
        mqttConnectOptions.isCleanSession = true
        mqttConnectOptions.userName = mqttUsername
        mqttConnectOptions.password = mqttPassword.toCharArray()

        try {

            mqttAndroidClient?.connect(mqttConnectOptions, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    Log.w("Mqtt", "MQTT connect success")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    Log.w("Mqtt", "Failed to connect: " + exception.toString())

                    if (asyncActionToken.exception != null) {
                        val errorReason: Short = asyncActionToken.exception.reasonCode.toShort()
                        when (errorReason) {
                            MqttException.REASON_CODE_CLIENT_EXCEPTION -> {
                                setMQTTStatusMessage("MQTT failed to connect - client exception")
                            }
                            MqttException.REASON_CODE_INVALID_PROTOCOL_VERSION -> {
                                setMQTTStatusMessage("MQTT failed to connect - invalid protocol version")
                            }
                            MqttException.REASON_CODE_INVALID_CLIENT_ID -> {
                                setMQTTStatusMessage("MQTT failed to connect - invalid client id")
                            }
                            MqttException.REASON_CODE_BROKER_UNAVAILABLE -> {
                                setMQTTStatusMessage("MQTT failed to connect - broker unavailable")
                            }
                            MqttException.REASON_CODE_FAILED_AUTHENTICATION -> {
                                setMQTTStatusMessage("MQTT failed to connect - authentication failed")
                                AppAggregate.showAlertDialog("MQTT Failed", "Did you link a device for mapping? Please check your settings and try again.")
                            }
                            MqttException.REASON_CODE_NOT_AUTHORIZED -> {
                                setMQTTStatusMessage("MQTT failed to connect - not authorised")
                                AppAggregate.showAlertDialog("MQTT Failed", "Did you link a device for mapping? Please check your settings and try again.")
                            }
                            MqttException.REASON_CODE_CLIENT_CONNECTED -> {
                                setMQTTStatusMessage("MQTT client connected")
                                return
                            }
                            MqttException.REASON_CODE_CONNECT_IN_PROGRESS -> {
                                Log.e(TAG, "Connect in progress, ignoring error")
                                return
                            }
                            else -> {
                                setMQTTStatusMessage("MQTT failed to connect - unexpected error: " + errorReason)
                            }
                        }
                    } else {
                        setMQTTStatusMessage("MQTT failed to connect - " + exception.toString())
                    }

                    selfStop = true
                    stopLocationTracking()
                    AppAggregate.stopService()
                }
            })


        } catch (ex: MqttException) {
            ex.printStackTrace()
        }

    }

    private fun subscribeToTopic() {
        val subscriptionTopic = sharedPref.getString(getString(R.string.PREF_MQTT_TOPIC), "#").toString()

        try {
            mqttAndroidClient?.subscribe(subscriptionTopic, 0, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    Log.w("Mqtt", "Subscribed!")
                    setMQTTStatusMessage("MQTT connected")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    Log.w("Mqtt", "Subscribed fail!")
                    setMQTTStatusMessage("MQTT subscribe failed - check your keys")

                    selfStop = true
                    stopLocationTracking()
                    AppAggregate.stopService()
                }
            })

        } catch (ex: MqttException) {
            ex.printStackTrace()

            setMQTTStatusMessage("MQTT subscribe failed - mqtt exception")

            selfStop = true
            stopLocationTracking()
            AppAggregate.stopService()
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()

            setMQTTStatusMessage("MQTT subscribe failed - illegal argument")

            selfStop = true
            stopLocationTracking()
            AppAggregate.stopService()
        }

    }

    fun setMQTTStatusMessage(message: String) {
        handlerMqttStatus.removeCallbacksAndMessages(null);
        AppAggregate.setMQTTStatusMessage(message)
    }

    fun setMQTTCountupMessage(date: Date) {
        handlerMqttStatus.removeCallbacksAndMessages(null);
        AppAggregate.setMQTTStatusMessage("Packet received now")
        val r = object : Runnable {
            override fun run() {
                AppAggregate.setMQTTStatusMessage("Packet received " + datesToDurationString(date, Date()))
                handlerMqttStatus.postDelayed(this, 1000) //ms
            }
        }
        handlerMqttStatus.postDelayed(r, 1000);
    }

    fun setGPSStatusMessage(message: String) {
        handlerGpsStatus.removeCallbacksAndMessages(null)
        AppAggregate.setGPSStatusMessage(message)
    }

    fun setGPSCountupStatus(date: Date, accuracy: Float) {
        if ((Date().time - date.time) > 5000) {
            setGPSStatusMessage("GPS location too old. Obtained " + datesToDurationString(date, Date()))
        } else if (accuracy > AppConstants.LOCATION_ACCURACY) {
            setGPSStatusMessage("GPS accuracy low (>10m)")
        } else {
            setGPSStatusMessage("GPS location valid")
        }

        val r = object : Runnable {
            override fun run() {
                setGPSCountupStatus(date, accuracy)
            }
        }
        handlerGpsStatus.postDelayed(r, 1000);
    }

    fun datesToDurationString(first: Date, second: Date): String {
        var diff = (second.time - first.time) / 1000

        if (diff < 60) {
            return diff.toString() + " seconds ago"
        }

        diff = diff / 60

        if (diff < 60) {
            return diff.toString() + " minutes ago"
        }

        diff = diff / 60

        return diff.toString() + " hours ago"
    }

    private fun startLocationTracking(): Boolean {
        setGPSStatusMessage("GPS finding fix")

        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "Location permission not granted by user")
            setGPSStatusMessage("Location permission not granted by user")
            return false
        }

        Log.e(TAG, "startLocationTracking()")


        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Register the listener with the Location Manager to receive location updates
        if (locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER) ) {
            locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
        } else {
            Log.e(TAG, "GPS is not enabled")
            setGPSStatusMessage("GPS is not enabled")

            AppAggregate.showAlertDialog("No GPS", "It seems like your phone does not have a GPS receiver, or the GPS receiver is not enabled. Mapping is not possible without GPS-based location.")

            return false
        }
        if (locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
        }

        return true
    }


    private fun stopLocationTracking() {
        Log.e(TAG, "stopLocationTracking()")
        if (locationManager != null) {
            locationManager!!.removeUpdates(locationListener)
//            setGPSStatusMessage("GPS stopped")
        } else {
            Log.e(TAG, "locationManager or locationListener is null")
        }
        setGPSStatusMessage("GPS stopped")
    }

    inner class MyLocalBinder : Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }

    val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
//                Log.e(TAG, "New location")
            setGPSCountupStatus(Date(), location.accuracy)

            // The app should show and log packets regardless of accuracy. We filter only main map data on the website.
//            if (location.accuracy < AppConstants.LOCATION_ACCURACY) {
                // Only store a valid location for use by packet processing
                AppAggregate.phoneLocation = location
//            }
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
}