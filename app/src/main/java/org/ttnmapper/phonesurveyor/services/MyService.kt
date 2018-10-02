package org.ttnmapper.phonesurveyor.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import java.text.SimpleDateFormat
import java.util.*


class MyService: Service() {

    private val myBinder = MyLocalBinder()

    var mqttAndroidClient: MqttAndroidClient? = null

    val serverUri = "tcp://eu.thethings.network:1883"

    val clientId = "ExampleAndroidClient"
    val subscriptionTopic = "#"

    val username = "jpm_ttgo"
    val password = "ttn-account-v2.zFhflrXwHYwAY2Tqb1KkRyx0xWz8M_f6p2lm7zzl87A"


    override fun onBind(intent: Intent): IBinder? {
        return myBinder
    }

    override fun onCreate() {
        super.onCreate()
        startMQTTConnection()
    }

    override fun onDestroy() {
        stopMQTTConnection()
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
                Log.w("Mqtt", mqttMessage.toString())
                val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
                val currentDateandTime = sdf.format(Date())
                setMQTTStatusMessage("Message received at "+currentDateandTime)
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
        AppAggregate.setMQTTConnectionMessage(message)
    }

    inner class MyLocalBinder : Binder() {
        fun getService() : MyService {
            return this@MyService
        }
    }
}