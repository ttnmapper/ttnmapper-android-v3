package org.ttnmapper.phonesurveyor.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.*
import android.support.v4.content.ContextCompat
import android.util.Log
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import java.util.*
import kotlin.concurrent.thread


class MyService: Service() {
    private val TAG = MyService::class.java.getName()

    private val myBinder = MyLocalBinder()

    var mqttAndroidClient: MqttAndroidClient? = null

    val serverUri = "tcp://eu.thethings.network:1883"

    val clientId = "ExampleAndroidClient"
    val subscriptionTopic = "#"

    val username = "jpm_ttgo"
    val password = "ttn-account-v2.zFhflrXwHYwAY2Tqb1KkRyx0xWz8M_f6p2lm7zzl87A"

    var handlerMqttStatus = Handler()
    var handlerGpsStatus = Handler()

    var locationManager: LocationManager? = null
    var locationListener: LocationListener? = null

    override fun onBind(intent: Intent): IBinder? {
        return myBinder
    }

    override fun onCreate() {
        super.onCreate()
        startLocationTracking()
        startMQTTConnection()
    }

    override fun onDestroy() {
        stopMQTTConnection()
        stopLocationTracking()
        super.onDestroy()
    }

    fun startMQTTConnection() {
        mqttAndroidClient = MqttAndroidClient(SurveyorApp.instance, serverUri, clientId)
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

            @Throws(Exception::class)
            override fun messageArrived(topic: String, mqttMessage: MqttMessage) {
                Log.w("Mqtt", topic+": "+mqttMessage.toString())
                setMQTTCountupMessage(Date())

                Log.e(TAG, "Processing new message")
                thread(start = true) {
                    AppAggregate.processMessage(topic, mqttMessage.toString())
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
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun messageArrived(topic: String?, message: MqttMessage?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun connectionLost(throwable: Throwable?) {
                Log.w("mqtt", "Connection lost")
                setMQTTStatusMessage("MQTT disconnected - mapping stopped")
            }
        })
        mqttAndroidClient?.disconnect()
    }

    fun setCallback(callback: MqttCallbackExtended) {
        mqttAndroidClient?.setCallback(callback)
    }

    private fun connect() {
        val mqttConnectOptions = MqttConnectOptions()
        mqttConnectOptions.isAutomaticReconnect = true
        mqttConnectOptions.isCleanSession = true
        mqttConnectOptions.userName = username
        mqttConnectOptions.password = password.toCharArray()

        try {

            mqttAndroidClient?.connect(mqttConnectOptions, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    Log.w("Mqtt", "MQTT connect success")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    Log.w("Mqtt", "Failed to connect to: " + serverUri + exception.toString())
                    setMQTTStatusMessage("MQTT failed to connect - check your internet connection")
                }
            })


        } catch (ex: MqttException) {
            ex.printStackTrace()
        }

    }

    private fun subscribeToTopic() {
        try {
            mqttAndroidClient?.subscribe(subscriptionTopic, 0, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    Log.w("Mqtt", "Subscribed!")
                    setMQTTStatusMessage("MQTT connected")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    Log.w("Mqtt", "Subscribed fail!")
                    setMQTTStatusMessage("MQTT subscribe failed - check your keys")
                }
            })

        } catch (ex: MqttException) {
            ex.printStackTrace()
        }

    }

    fun setMQTTStatusMessage(message: String) {
        handlerMqttStatus.removeCallbacksAndMessages(null);
        AppAggregate.setMQTTStatusMessage(message)
    }

    fun setMQTTCountupMessage(date: Date) {
        handlerMqttStatus.removeCallbacksAndMessages(null);
        AppAggregate.setMQTTStatusMessage("TTN message received now")
        val r = object : Runnable {
            override fun run() {
                AppAggregate.setMQTTStatusMessage("TTN message received "+datesToDurationString(date, Date()))
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
        if((Date().time - date.time) > 5000) {
            setGPSStatusMessage("GPS location too old. Obtained "+datesToDurationString(date, Date()))
        } else if(accuracy > 10.0 ) {
            setGPSStatusMessage("GPS location not accurate enough (>10m)")
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

        if(diff < 60) {
            return diff.toString() + " seconds ago"
        }

        diff = diff / 60

        if(diff < 60) {
            return diff.toString() + " minutes ago"
        }

        diff = diff / 60

        return diff.toString() + " hours ago"
    }

    private fun startLocationTracking() {

        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "Location permission not granted by user")
            setGPSStatusMessage("Location permission not granted by user")
            return
        }

        Log.e(TAG, "startLocationTracking()")


        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                Log.e(TAG, "New location")
                AppAggregate.phoneLocation = location

                setGPSCountupStatus(Date(), location.accuracy)
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        // Register the listener with the Location Manager to receive location updates
        locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
        locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)

    }


    private fun stopLocationTracking() {
        Log.e(TAG, "stopLocationTracking()")
        if (locationManager != null && locationListener != null) {
            locationManager!!.removeUpdates(locationListener)
            setGPSStatusMessage("GPS stopped")
        } else {
            Log.e(TAG, "locationManager or locationListener is null")
        }
    }

    inner class MyLocalBinder : Binder() {
        fun getService() : MyService {
            return this@MyService
        }
    }
}