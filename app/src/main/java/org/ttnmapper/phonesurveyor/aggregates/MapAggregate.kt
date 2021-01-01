package org.ttnmapper.phonesurveyor.aggregates

import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import org.ttnmapper.phonesurveyor.room.Gateway
import java.util.*
import kotlin.collections.ArrayList

object MapAggregate {
    private val TAG = MapAggregate::class.java.getName()

    var zoom: Double = 6.0
        set(value) {
            field = value
            val editor = AppAggregate.sharedPref?.edit()
            editor!!.putFloat(SurveyorApp.instance.getString(R.string.PREF_MAP_START_ZOOM), value.toFloat())
            editor.apply()
        }

    var latitude: Double = 52.372706
        set(value) {
            field = value
            val editor = AppAggregate.sharedPref?.edit()
            editor!!.putFloat(SurveyorApp.instance.getString(R.string.PREF_MAP_START_LAT), value.toFloat())
            editor.apply()
        }

    var longitude: Double = 4.897312
        set(value) {
            field = value
            val editor = AppAggregate.sharedPref?.edit()
            editor!!.putFloat(SurveyorApp.instance.getString(R.string.PREF_MAP_START_LON), value.toFloat())
            editor.apply()
        }

    var lineList: MutableList<MapLine> = ArrayList()
    var pointList: MutableList<MapPoint> = ArrayList()
    var seenGateways: MutableMap<String, Gateway> = HashMap();

    var gpsStatusMessage: String = "GPS stopped"
    var mqttStatusMessage: String = "MQTT disconnected"
}