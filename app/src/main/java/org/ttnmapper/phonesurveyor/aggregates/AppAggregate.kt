package org.ttnmapper.phonesurveyor.aggregates

import android.app.ActivityManager
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.location.Location
import android.os.AsyncTask
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.model.Gateway
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import org.ttnmapper.phonesurveyor.model.TTNMessage
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.ui.MainActivity
import org.ttnmapper.phonesurveyor.utils.getBackgroundNotification
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


object AppAggregate {
    private val TAG = AppAggregate::class.java.getName()

    var mainActivity: MainActivity? = null
    var myService: MyService? = null
    var isBound = false

    var phoneLocation: Location? = null


    val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    val jsonAdapter = moshi.adapter(TTNMessage::class.java)

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            val binder = service as MyService.MyLocalBinder
            myService = binder.getService()
            isBound = true

            Log.e(TAG, "Adding notification")
            getBackgroundNotification(SurveyorApp.instance.applicationContext, myService).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }

    fun startService() {
        val serviceClass = MyService::class.java
        val serviceIntent = Intent(SurveyorApp.instance.applicationContext, serviceClass)

        // If the service is not running then start it
        if (!isServiceRunning(serviceClass)) {
            // Start the service
            Log.e(TAG, "Starting new service")
            SurveyorApp.instance.startService(serviceIntent)
            SurveyorApp.instance.bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE)
        } else {
            toast("Service already running.")
            SurveyorApp.instance.bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE)
        }
    }

    fun stopService() {
        val serviceClass = MyService::class.java
        val serviceIntent = Intent(SurveyorApp.instance.applicationContext, serviceClass)

        //Unbind Service
        try {
            SurveyorApp.instance.unbindService(myConnection)
        } catch (e: IllegalArgumentException) {
            Log.w("MainActivity", "Error Unbinding Service.")
        }
        // If the service is not running then start it
        if (isServiceRunning(serviceClass)) {
            // Stop the service
            SurveyorApp.instance.stopService(serviceIntent)
        } else {
            toast("Service already stopped.")
        }
    }

    // Custom method to determine whether a service is running
    fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = SurveyorApp.instance.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        // Loop through the running services
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                // If the service is running then return true
                return true
            }
        }
        return false
    }

    fun setMQTTStatusMessage(message: String) {
        mainActivity?.setMQTTStatusMessage(message)
        if(isServiceRunning(MyService::class.java)) {
            updateNotificationText(message)
        }
    }

    fun setGPSStatusMessage(message: String) {
        mainActivity?.setGPSStatusMessage(message)
    }

    // Extension function to show toast message
    fun toast(message:String){
        Toast.makeText(SurveyorApp.instance.applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun updateNotificationText(message: String) {
        var mNotification: Notification
        val notificationManager = SurveyorApp.instance.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notifyIntent = Intent(SurveyorApp.instance, MainActivity::class.java)

        val title = "TTN Mapper running"

        notifyIntent.putExtra("title", title)
        notifyIntent.putExtra("message", message)
        notifyIntent.putExtra("notification", true)

        notifyIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        val pendingIntent = PendingIntent.getActivity(SurveyorApp.instance, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Log.w(TAG, "Building notification for >=O")
            mNotification = Notification.Builder(SurveyorApp.instance, getBackgroundNotification.CHANNEL_ID)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic__ionicons_svg_md_map)
                    .setAutoCancel(true)
                    .setContentTitle(title)
                    .setStyle(Notification.BigTextStyle()
                            .bigText(message))
                    .setContentText(message).build()
        } else {

            Log.w(TAG, "Building notification for <O")
            mNotification = Notification.Builder(SurveyorApp.instance)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic__ionicons_svg_md_map)
                    .setAutoCancel(true)
                    .setContentTitle(title)
                    .setStyle(Notification.BigTextStyle()
                            .bigText(message))
                    .setContentText(message).build()

        }

        notificationManager.notify(1000, mNotification)
    }

    fun processMessage(topic: String, data: String) {
        Log.e(TAG, "Processing new message")

        if(!topic.endsWith("up")) {
            //TODO: Not an uplink message
            Log.e(TAG, "Not an uplink message")
            return
        }

        /*
        val gson = Gson()

        Log.e(TAG, "Created gson")
        val message = gson.fromJson(data, TTNMessageUp::class.java)
        */
//            val ttnMessage = jsonAdapter.fromJson(data)
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<TTNMessage>(TTNMessage::class.java!!)
//        Log.e(TAG, "Just before parsing")
        val ttnMessage = jsonAdapter.fromJson(data)
//        Log.e(TAG, "Just after parsing")

//        if(ttnMessage == null) {
//            Log.e(TAG, "Message not parsed")
//        } else {
//            Log.e(TAG, "Parsed")
//        }

        //TODO: Save to file if saving is enabled - but first add location!
        // "mqtt_topic":"jpm_sodaq_one\/devices\/sodaq-one-v3-box\/up","phone_lat":-34.0480438,"phone_lon":18.8220624,"phone_alt":182.8053986682576,"phone_loc_acc":10,"phone_loc_provider":"fused","phone_time":"2018-03-18T10:04:43Z","user_agent":"Android7.0 App30:2018.03.04"
        ttnMessage!!.mqttTopic = topic
        ttnMessage.phoneLat = phoneLocation?.latitude
        ttnMessage.phoneLon = phoneLocation?.longitude
        ttnMessage.phoneAlt = phoneLocation?.altitude
        ttnMessage.phoneLocAcc = phoneLocation?.accuracy?.toDouble()
        ttnMessage.phoneLocProvider = phoneLocation?.provider
        ttnMessage.phoneTime = getISO8601StringForDate(Date())
        //TODO: message.userAgent = Android7.0 App30:2018.03.04

//        Log.e(TAG, ttnMessage.toString())

        if(phoneLocation == null) {
            //TODO: No location information yet message
            Log.e(TAG, "No location information")
            return
        }

        if(System.currentTimeMillis() - phoneLocation!!.time > 10000) {
            //TODO: Fix older than 10 seconds - notify
            Log.e(TAG, "Location older than 10 seconds")
            return
        }

        if(phoneLocation!!.accuracy > 10) {
            //TODO: too low accuracy
            Log.e(TAG, "Location accuracy too low")
            return
        }


        var maxLevel: Double? = null

        for( gateway in ttnMessage.metadata?.gateways!!) {
            addGatewayToMap(gateway!!)

            var level: Double = gateway.rssi!!
            if(gateway.snr != null) {
                if (gateway.snr!! < 0.0) {
                    level = level + gateway.snr!!
                }
            }
            if(maxLevel == null) maxLevel = level
            if(level>maxLevel) maxLevel = level

            if(gateway.latitude != null && gateway.longitude != null) {
                drawLineOnMap(gateway.latitude!!, gateway.longitude!!, ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, getColorForSignal(level))
            }

        }

        if(maxLevel!=null) {
            drawPointOnMap(ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, getColorForSignal(maxLevel))
        } else {
            drawPointOnMap(ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, getColorForSignal(0.0))
        }

    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        MapAggregate.lineList.add(MapLine(startLat, startLon, endLat, endLon, colour))
        mainActivity?.drawLineOnMap(startLat, startLon, endLat, endLon, colour)
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long) {
        MapAggregate.pointList.add(MapPoint(lat, lon, colour))
        mainActivity?.drawPointOnMap(lat, lon, colour)
    }

    fun addGatewayToMap(gateway: Gateway) {
        if(!MapAggregate.seenGateways.containsKey(gateway.gtwId)) {
            if(gateway.gtwId != null) {
                MapAggregate.seenGateways.put(gateway.gtwId!!, gateway)
                mainActivity?.addGatewayToMap(gateway)
            }
        }
    }

    fun getColorForSignal(level: Double): Long {

        if (level == 0.0) {
            return 0x7f000000
        } else if (level > -100) {
            return 0x7fff0000
        } else if (level > -105) {
            return 0x7fff7f00
        } else if (level > -110) {
            return 0x7fffff00
        } else if (level > -115) {
            return 0x7f00ff00
        } else if (level > -120) {
            return 0x7f00ffff;
        } else if (level > -140) {
            return 0x7f0000ff;
        } else {
            return 0x7f000000
        }

    }

    private fun getISO8601StringForDate(date: Date): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
        return dateFormat.format(date)
    }

//    fun pointmarker() {
//        // wrap them in a theme
//        val pt = SimplePointTheme(points, true)
//
//// create label style
//        val textStyle = Paint()
//        textStyle.setStyle(Paint.Style.FILL)
//        textStyle.setColor(Color.parseColor("#0000ff"))
//        textStyle.setTextAlign(Paint.Align.CENTER)
//        textStyle.setTextSize(24)
//
//// set some visual options for the overlay
//// we use here MAXIMUM_OPTIMIZATION algorithm, which works well with >100k points
//        val opt = SimpleFastPointOverlayOptions.getDefaultStyle()
//                .setAlgorithm(SimpleFastPointOverlayOptions.RenderingAlgorithm.MAXIMUM_OPTIMIZATION)
//                .setRadius(7f).setIsClickable(true).setCellSize(15).setTextStyle(textStyle)
//
//// create the overlay with the theme
//        val sfpo = SimpleFastPointOverlay(pt, opt)
//
//// onClick callback
//        sfpo.setOnClickListener { points, point -> Toast.makeText(mMapView.getContext(), "You clicked " + (points.get(point!!) as LabelledGeoPoint).label, Toast.LENGTH_SHORT).show() }
//    }

}