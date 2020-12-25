package org.ttnmapper.phonesurveyor.aggregates

import android.Manifest
import android.app.ActivityManager
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.*
import android.content.pm.PackageManager
import android.location.Location
import android.media.RingtoneManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.IBinder
import android.preference.PreferenceManager
import androidx.core.app.ActivityCompat
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.NetworkAggregate.getGatewayFromTtnMapper
import org.ttnmapper.phonesurveyor.model.GatewayMetadata
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import org.ttnmapper.phonesurveyor.model.TTNMessage
import org.ttnmapper.phonesurveyor.room.AppDatabase
import org.ttnmapper.phonesurveyor.room.Gateway
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.ui.MainActivity
import org.ttnmapper.phonesurveyor.utils.AppConstants
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import org.ttnmapper.phonesurveyor.utils.getBackgroundNotification
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import java.util.*


object AppAggregate {
    private val TAG = AppAggregate::class.java.getName()

    var mainActivity: MainActivity? = null
    var sharedPref: SharedPreferences? = null
    var db: AppDatabase? = null

    var myService: MyService? = null
    var isBound = false

    var currentSessionStart: Date? = null
    var phoneLocation: Location? = null
    var lastTTNMessage: TTNMessage? = null
    var numberOfPacketsRx = 0

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
            currentSessionStart = Date()
            SurveyorApp.instance.startService(serviceIntent)
            SurveyorApp.instance.bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE)
        } else {
            toast("Service already running.")
            SurveyorApp.instance.bindService(serviceIntent, myConnection, Context.BIND_AUTO_CREATE)
        }

        mainActivity!!.updateStartStopButton(true)
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

        mainActivity?.updateStartStopButton(false)
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
        if (isServiceRunning(MyService::class.java)) {
            updateNotificationText(message)
        }
    }

    fun setGPSStatusMessage(message: String) {
        mainActivity?.setGPSStatusMessage(message)
    }

    fun showAlertDialog(title: String, message: String) {
        mainActivity?.showAlertDialog(title, message)
    }

    // Extension function to show toast message
    fun toast(message: String) {
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
                    .setSmallIcon(R.drawable.ic_silhouette)
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
                    .setSmallIcon(R.drawable.ic_silhouette)
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
        //sharedPref = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance) // set in main activity

        if(sharedPref == null) {
            Log.e(TAG, "sharedPref is null at start of processMessage")
            return
        }

        if (!topic.endsWith("up")) {
            //TODO: Not an uplink message
            Log.e(TAG, "Not an uplink message")
            return
        }

        // Play a ringtone if enabled
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_PLAY_SOUND), false)) {
            val defaultNotification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notification = Uri.parse(sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_SOUND_URI), defaultNotification.toString()))
            val r = RingtoneManager.getRingtone(mainActivity, notification)
            r.play()
        }


        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val jsonAdapter = moshi.adapter<TTNMessage>(TTNMessage::class.java)
        val ttnMessage = jsonAdapter.fromJson(data)

        if(ttnMessage == null) {
            Log.e(TAG, "Message not parsed")
            return
        } else {
            Log.d(TAG, "Parsed")
        }

        // We can update the stats directly without adding info to it
        lastTTNMessage = ttnMessage
        numberOfPacketsRx++
        updateStats()

        // Make a copy, otherwise it might change while we process the packet
        val currentLocation = phoneLocation // This is likely not a deep copy, but let's hope the location service creates a new object and doesn't update this one.
        if(currentLocation != null) {
            ttnMessage.phoneLat = currentLocation.latitude
            ttnMessage.phoneLon = currentLocation.longitude
            ttnMessage.phoneAlt = currentLocation.altitude
            ttnMessage.phoneLocAcc = currentLocation.accuracy.toDouble()
            ttnMessage.phoneLocProvider = currentLocation.provider
            ttnMessage.phoneLocTime = CommonFunctions.getISO8601StringForMillis(currentLocation.time)
        }

        Log.e(TAG, "Loc Time: "+currentLocation!!.time.toString()+" == "+ttnMessage.phoneLocTime)

        ttnMessage.phoneTime = CommonFunctions.getISO8601StringForDate(Date())
        val pInfo = SurveyorApp.instance.getPackageManager().getPackageInfo(SurveyorApp.instance.getPackageName(), 0)
        val version = pInfo.versionName
        val verCode = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            pInfo.longVersionCode
        } else {
            pInfo.versionCode
        }
        ttnMessage.userAgent = "Android" + android.os.Build.VERSION.RELEASE + " App" + verCode + ":" + version
        ttnMessage.iid = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_MAPPER_IID), "")

        // Mark as experiment
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_EXPERIMENT), false)) {
            ttnMessage.experiment = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_EXPERIMENT_NAME), "experiment_" + sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_MAPPER_IID), ""))
        }

        // Find the maximum signal level used to draw circle
        var maxLevel: Double? = null
        for (gateway in ttnMessage.metadata?.gateways.orEmpty()) {
            var level: Double = gateway!!.rssi!!
            if (gateway.snr != null) {
                if (gateway.snr!! < 0.0) {
                    level = level + gateway.snr!!
                }
            }
            if (maxLevel == null) maxLevel = level
            if (level > maxLevel) maxLevel = level
        }
        ttnMessage.maxLevel = maxLevel

        Log.v(TAG, ttnMessage.toString())

        // Store all messages also in Room database for export to csv later
        db?.linkDao()?.insertTtnMessage(currentSessionStart!!, ttnMessage)

        // We store the point in the database regardless of the location. But if we do not have a location, we can not draw on the map or send to server.
        if (currentLocation == null) {
            Log.e(TAG, "No location information")
            return
        }

        // Make sure we aren't using a very old gps location. Especially important when moving very fast (highway driving).
        if(System.currentTimeMillis() - currentLocation.time > 10000) {
            Log.e(TAG, "Location older than 10 seconds")
            return
        }

        // Draw gateway line on map
        for (gateway in ttnMessage.metadata?.gateways.orEmpty()) {
            if(gateway == null) continue

            var level: Double = gateway.rssi!!
            if (gateway.snr != null) {
                if (gateway.snr!! < 0.0) {
                    level = level + gateway.snr!!
                }
            }

//            if (gateway.latitude != null && gateway.longitude != null) {
//                drawLineOnMap(gateway.latitude!!, gateway.longitude!!, ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, CommonFunctions.getColorForSignal(level))
//            } else {
                // Try and read the location from our local storage
                val gatewayDb = db?.gatewayDao()?.findGateway(gateway.gtwId!!)
                Log.e(TAG, "Gateway from db: "+gatewayDb.toString())
                if(gatewayDb != null) {
                    if(gatewayDb.latitude != null && gatewayDb.longitude != null) {
                        addGatewayToMap(gatewayDb)
                        drawLineOnMap(gatewayDb.latitude!!, gatewayDb.longitude!!, ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, CommonFunctions.getColorForSignal(level))
                    }
                } else {
                    // Finally try getting the gateway location from ttnmapper.org
                    val gatewayData = getGatewayFromTtnMapper(gateway.gtwId!!)
                    if(gatewayData != null) {
                        val gatewayDbNew = Gateway(gtwId = gateway.gtwId!!)
                        gatewayDbNew.latitude = gatewayData.getDouble("latitude")
                        gatewayDbNew.longitude = gatewayData.getDouble("longitude")
                        gatewayDbNew.channels = gatewayData.getInt("channels")
                        gatewayDbNew.description = gatewayData.getString("description")

                        db?.gatewayDao()?.insertAll(gatewayDbNew)

                        addGatewayToMap(gatewayDbNew)
                        drawLineOnMap(gatewayDbNew.latitude!!, gatewayDbNew.longitude!!, ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, CommonFunctions.getColorForSignal(level))
                    }
                }
//            }
        }

        // Draw point on map
        if (maxLevel != null) {
            drawPointOnMap(ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, CommonFunctions.getColorForSignal(maxLevel))
        } else {
            drawPointOnMap(ttnMessage.phoneLat!!, ttnMessage.phoneLon!!, CommonFunctions.getColorForSignal(0.0))
        }

        // And upload to TTN Mapper
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_UPLOAD), true)) {
            NetworkAggregate.postToTTNMapper(ttnMessage)
        }
        // Always upload to TTN Mapper before custom server, as we might modify the packet for custom servers.
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_CUSTOM_SERVER_ENABLED), false)) {
            var serverUri = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_CUSTOM_SERVER_ADDRESS), "")
            if (serverUri != null) {
                NetworkAggregate.postToCustomServer(ttnMessage, serverUri)
            }
        }
    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        MapAggregate.lineList.add(MapLine(startLat, startLon, endLat, endLon, colour))
        mainActivity!!.drawLineOnMap(startLat, startLon, endLat, endLon, colour)
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long) {
        MapAggregate.pointList.add(MapPoint(lat, lon, colour))
        mainActivity!!.drawPointOnMap(lat, lon, colour)
    }

    fun addGatewayToMap(gateway: Gateway) {
        if (!MapAggregate.seenGateways.containsKey(gateway.gtwId)) {
            if (gateway.latitude != null && gateway.longitude != null) {
                mainActivity!!.addGatewayToMap(gateway)
            }
        }
    }

    fun updateStats() {
        mainActivity!!.updateStats()
    }

}