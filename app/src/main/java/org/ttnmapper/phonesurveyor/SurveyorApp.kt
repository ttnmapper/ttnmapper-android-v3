package org.ttnmapper.phonesurveyor

import android.app.Application

class SurveyorApp: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: SurveyorApp
            private set
    }
}