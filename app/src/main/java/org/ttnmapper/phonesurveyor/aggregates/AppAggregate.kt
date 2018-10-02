package org.ttnmapper.phonesurveyor.aggregates

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.AsyncTask
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.ui.MainActivity
import org.ttnmapper.phonesurveyor.utils.getBackgroundNotification

object AppAggregate {
    private val TAG = AppAggregate::class.java.getName()

    var mainActivity: MainActivity? = null
    var myService: MyService? = null
    var isBound = false

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

    fun setMQTTConnectionMessage(message: String) {
        mainActivity?.setMQTTConnectionMessage(message)
    }

    // Extension function to show toast message
    fun toast(message:String){
        Toast.makeText(SurveyorApp.instance.applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}