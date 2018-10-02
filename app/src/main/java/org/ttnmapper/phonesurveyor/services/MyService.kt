package org.ttnmapper.phonesurveyor.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService: Service() {

    private val myBinder = MyLocalBinder()

    override fun onBind(intent: Intent): IBinder? {
        return myBinder
    }

    fun getCurrentTime(): String {
        return "Returns some time string"
    }

    inner class MyLocalBinder : Binder() {
        fun getService() : MyService {
            return this@MyService
        }
    }
}