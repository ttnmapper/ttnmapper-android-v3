package org.ttnmapper.phonesurveyor.aggregates

import android.app.ActivityManager
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.*
import android.location.Location
import android.media.RingtoneManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.openapitools.client.models.V3ApplicationUp
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.NetworkAggregate.getGatewayFromTtnMapper
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import org.ttnmapper.phonesurveyor.model.TtnMapperUplinkMessage
import org.ttnmapper.phonesurveyor.model.chirpstack.UplinkEvent
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import org.ttnmapper.phonesurveyor.model.ttnV3.OffsetDateTimeAdapter
import org.ttnmapper.phonesurveyor.room.AppDatabase
import org.ttnmapper.phonesurveyor.room.Gateway
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.ui.MainActivity
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import org.ttnmapper.phonesurveyor.utils.ObjectCopy.Companion.ChirpStackUplinkToTtnMapperUplink
import org.ttnmapper.phonesurveyor.utils.ObjectCopy.Companion.ttnV2UplinkToTtnMapperUplink
import org.ttnmapper.phonesurveyor.utils.ObjectCopy.Companion.ttnV3UplinkToTtnMapperUplink
import org.ttnmapper.phonesurveyor.utils.getBackgroundNotification
import java.util.*
import kotlin.math.absoluteValue


object AppAggregate {
    private val TAG = AppAggregate::class.java.getName()

    var mainActivity: MainActivity? = null
    var sharedPref: SharedPreferences? = null
    var db: AppDatabase? = null

    var myService: MyService? = null
    var isBound = false

    var currentSessionStart: Date? = null
    var phoneLocation: Location? = null
    var lastTTNMessage: TtnMapperUplinkMessage? = null
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
        currentSessionStart = Date()

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

        mainActivity!!.updateStartStopButton(true)
    }

    fun stopService() {
        val serviceClass = MyService::class.java
        val serviceIntent = Intent(SurveyorApp.instance.applicationContext, serviceClass)

        //Unbind Service
        try {
            SurveyorApp.instance.unbindService(myConnection)
        } catch (e: IllegalArgumentException) {
            Log.e(TAG, "Error Unbinding Service.")
        }
        // If the service is not running then start it
        if (isServiceRunning(serviceClass)) {
            // Stop the service
            SurveyorApp.instance.stopService(serviceIntent)
        } else {
            Log.e(TAG, "Service already stopped.")
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

        if(currentSessionStart == null) {
            Log.e(TAG, "currentSessionStart is null at start of processMessage")
            stopService()
            return
        }

        if(sharedPref == null) { // set in main activity if all is good
            sharedPref = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
            if (sharedPref == null) {
                Log.e(TAG, "sharedPref is null at start of processMessage")
                stopService()
                return
            }
        }


        val ttnMapperUplinkMessage: TtnMapperUplinkMessage?

        val networkServer = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_NETWORK_SERVER), "").toString()

        var networkAddress =
                CommonFunctions.sanitiseMqttUri(
                        sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_MQTT_BROKER), "")!!
                ).removePrefix("tcp://")
        // Remove port
        networkAddress = networkAddress.substringBeforeLast(':')

        // TTI v3
        if(networkServer.equals(SurveyorApp.instance.getString(R.string.NS_TTS_V3))) {
            val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .add(OffsetDateTimeAdapter())
                    .build()
            try {
                val jsonAdapter = moshi.adapter<V3ApplicationUp>(V3ApplicationUp::class.java)
                val ttnMessage = jsonAdapter.fromJson(data)

                if (ttnMessage == null) {
                    Log.e(TAG, "V3 Message not parsed")
                    return
                } else {
                    Log.d(TAG, "V3 Parsed")
                }

                ttnMapperUplinkMessage = ttnV3UplinkToTtnMapperUplink(ttnMessage)

                ttnMapperUplinkMessage.NetworkType = networkServer

                val tenant = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_MQTT_USERNAME), "")?.split("@")
                if(tenant?.size == 2) {
                    ttnMapperUplinkMessage.NetworkAddress = tenant[1] + "." + networkAddress
                } else {
                    ttnMapperUplinkMessage.NetworkAddress = networkAddress
                }

            } catch (e: Exception) {
                Log.e(TAG, "V3 Can't parse received json")
                e.printStackTrace()
                return
            }


        // TTN v2
        } else if(networkServer.equals(SurveyorApp.instance.getString(R.string.NS_TTN_V2))) {
            val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            try {
                val jsonAdapter = moshi.adapter<TtnUplinkMessage>(TtnUplinkMessage::class.java)
                val ttnMessage = jsonAdapter.fromJson(data)

                if (ttnMessage == null) {
                    Log.e(TAG, "V2 Message not parsed")
                    return
                } else {
                    Log.d(TAG, "V2 Parsed")
                }

                ttnMapperUplinkMessage = ttnV2UplinkToTtnMapperUplink(ttnMessage)

                ttnMapperUplinkMessage.NetworkType = networkServer
                ttnMapperUplinkMessage.NetworkAddress = networkAddress
            } catch(e: java.lang.Exception) {
                Log.e(TAG, "V2 Can't parse received json")
                e.printStackTrace()
                return
            }


        // Chirp Stack
        } else if(networkServer.equals(SurveyorApp.instance.getString(R.string.NS_CHIRP))) {
            try {
                val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                val jsonAdapter = moshi.adapter<UplinkEvent>(UplinkEvent::class.java)
                val ttnMessage = jsonAdapter.fromJson(data)

                if (ttnMessage == null) {
                    Log.e(TAG, "Chirp Message not parsed")
                    return
                } else {
                    Log.e(TAG, "Chirp Parsed")
                }

                ttnMapperUplinkMessage = ChirpStackUplinkToTtnMapperUplink(ttnMessage)

                ttnMapperUplinkMessage.NetworkType = networkServer
                ttnMapperUplinkMessage.NetworkAddress = networkAddress

            } catch(e: java.lang.Exception) {
                Log.e(TAG, "Chirp can't parse received json")
                e.printStackTrace()
                return
            }
        } else {
            return
        }


        // Play a ringtone if enabled
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_PLAY_SOUND), false)) {
            val defaultNotification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notification = Uri.parse(sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_SOUND_URI), defaultNotification.toString()))
            val r = RingtoneManager.getRingtone(mainActivity, notification)
            r.play()
        }


        // We can update the stats directly without adding info to it
        lastTTNMessage = ttnMapperUplinkMessage
        numberOfPacketsRx++
        updateStats()

        // Make a copy, otherwise it might change while we process the packet
        val currentLocation = phoneLocation // This is likely not a deep copy, but let's hope the location service creates a new object and doesn't update this one.
        if(currentLocation != null) {
            ttnMapperUplinkMessage.Latitude = currentLocation.latitude
            ttnMapperUplinkMessage.Longitude = currentLocation.longitude
            ttnMapperUplinkMessage.Altitude = currentLocation.altitude
            ttnMapperUplinkMessage.AccuracyMeters = currentLocation.accuracy.toDouble()
            ttnMapperUplinkMessage.AccuracySource = currentLocation.provider
        }

        val pInfo = SurveyorApp.instance.getPackageManager().getPackageInfo(SurveyorApp.instance.getPackageName(), 0)
        val version = pInfo.versionName
        val verCode = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            pInfo.longVersionCode
        } else {
            pInfo.versionCode
        }
        ttnMapperUplinkMessage.UserAgent = "Android" + android.os.Build.VERSION.RELEASE + " App" + verCode + ":" + version
        ttnMapperUplinkMessage.UserId = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_MAPPER_IID), "")

        // Mark as experiment
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_EXPERIMENT), false)) {
            ttnMapperUplinkMessage.Experiment = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_EXPERIMENT_NAME), "experiment_" + sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_MAPPER_IID), ""))
        }

        Log.v(TAG, ttnMapperUplinkMessage.toString())

        // Store all messages also in Room database for export to csv later
        db?.linkDao()?.insertTtnMessage(currentSessionStart!!, ttnMapperUplinkMessage)

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
        // Find the maximum signal level used to draw circle
        var maxLevel: Double? = null
        for (gateway in ttnMapperUplinkMessage.Gateways.orEmpty()) {

            if(gateway.Rssi == null) continue

            var level: Double = gateway.Rssi!!
            if (gateway.Snr != null) {
                if (gateway.Snr!! < 0.0) {
                    level = level + gateway.Snr!!
                }
            }
            if (maxLevel == null) maxLevel = level
            if (level > maxLevel) maxLevel = level


            if(networkServer.equals(SurveyorApp.instance.getString(R.string.NS_TTN_V2))) {
                // For TTN v2 always ignore the gateway location in metadata, and rather fetch from ttnmapper.org
                val gatewayDb = db?.gatewayDao()?.findGateway(gateway.GatewayId!!)
                Log.e(TAG, "Gateway from db: "+gatewayDb.toString())
                if(gatewayDb != null) {
                    if (isGatewayLocationValid(gatewayDb)) {
                        addGatewayToMap(gatewayDb)
                        drawLineOnMap(gatewayDb.latitude!!, gatewayDb.longitude!!, ttnMapperUplinkMessage.Latitude!!, ttnMapperUplinkMessage.Longitude!!, CommonFunctions.getColorForSignal(level))
                    }
                } else {
                    // Finally try getting the gateway location from ttnmapper.org
                    val gatewayData = getGatewayFromTtnMapper(gateway.GatewayId!!)
                    if(gatewayData != null) {
                        val gatewayDbNew = Gateway(gtwId = gateway.GatewayId!!)
                        if(gatewayData.has("latitude")) {
                            gatewayDbNew.latitude = gatewayData.getDouble("latitude")
                        }
                        if(gatewayData.has("longitude")) {
                            gatewayDbNew.longitude = gatewayData.getDouble("longitude")
                        }
                        if(gatewayData.has("channels")) {
                            gatewayDbNew.channels = gatewayData.getInt("channels")
                        }
                        if(gatewayData.has("description")) {
                            gatewayDbNew.description = gatewayData.getString("description")
                        }

                        db?.gatewayDao()?.insertAll(gatewayDbNew)

                        if (isGatewayLocationValid(gatewayDbNew)) {
                            addGatewayToMap(gatewayDbNew)
                            drawLineOnMap(gatewayDbNew.latitude!!, gatewayDbNew.longitude!!, ttnMapperUplinkMessage.Latitude!!, ttnMapperUplinkMessage.Longitude!!, CommonFunctions.getColorForSignal(level))
                        }
                    }
                }

            } else {
                // For TTI v3 and Chirp Stack use gateway locations from metadata
                if (gateway.Latitude != null && gateway.Longitude != null) {
                    val gatewayDbNew = Gateway(gtwId = gateway.GatewayId!!)
                    gatewayDbNew.latitude = gateway.Latitude
                    gatewayDbNew.longitude = gateway.Longitude
                    gatewayDbNew.channels = 0
                    gatewayDbNew.description = gateway.Description

//                    db?.gatewayDao()?.insertAll(gatewayDbNew)

                    if (isGatewayLocationValid(gatewayDbNew)) {
                        addGatewayToMap(gatewayDbNew)
                        drawLineOnMap(gateway.Latitude!!, gateway.Longitude!!, ttnMapperUplinkMessage.Latitude!!, ttnMapperUplinkMessage.Longitude!!, CommonFunctions.getColorForSignal(level))
                    }
                }
            }
        }

        // Draw point on map
        if (maxLevel != null) {
            drawPointOnMap(ttnMapperUplinkMessage.Latitude!!, ttnMapperUplinkMessage.Longitude!!, CommonFunctions.getColorForSignal(maxLevel))
        } else {
            drawPointOnMap(ttnMapperUplinkMessage.Latitude!!, ttnMapperUplinkMessage.Longitude!!, CommonFunctions.getColorForSignal(0.0))
        }

        // And upload to TTN Mapper
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_UPLOAD), true)) {
            NetworkAggregate.postToTTNMapper(ttnMapperUplinkMessage)
        }
        // Always upload to TTN Mapper before custom server, as we might modify the packet for custom servers.
        if (sharedPref!!.getBoolean(SurveyorApp.instance.getString(R.string.PREF_CUSTOM_SERVER_ENABLED), false)) {
            val serverUri = sharedPref!!.getString(SurveyorApp.instance.getString(R.string.PREF_CUSTOM_SERVER_ADDRESS), "")
            if (serverUri != null) {
                NetworkAggregate.postToCustomServer(ttnMapperUplinkMessage, serverUri)
            }
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
        if (!MapAggregate.seenGateways.containsKey(gateway.gtwId)) {
            mainActivity?.addGatewayToMap(gateway)
            MapAggregate.seenGateways.put(gateway.gtwId, gateway)
        }
    }

    fun isGatewayLocationValid(gateway: Gateway): Boolean {

        if (gateway.latitude == null || gateway.longitude == null) {
            return false
        }

        if(gateway.latitude!!.absoluteValue < 1 && gateway.longitude!!.absoluteValue < 1) {
            // NULL island
            return false
        }

        if(gateway.latitude!!.absoluteValue > 90) {
            // Past poles
            return false
        }

        if(gateway.longitude!!.absoluteValue > 180) {
            // Wrap around
            return false
        }

        return true
    }

    fun updateStats() {
        mainActivity?.updateStats()
    }

}