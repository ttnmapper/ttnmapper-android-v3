package org.ttnmapper.phonesurveyor.aggregates

import android.location.Location
import kotlinx.android.synthetic.main.fragment_map.*
import org.osmdroid.util.GeoPoint
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate.sharedPref
import org.ttnmapper.phonesurveyor.model.GatewayMetadata
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import java.lang.NullPointerException
import java.util.HashMap
import kotlin.collections.ArrayList

object MapAggregate {
    private val TAG = MapAggregate::class.java.getName()

    var zoom: Double = 6.0
        set(value) {
            field = value
            val editor = sharedPref?.edit()
            editor?.putFloat(SurveyorApp.instance.getString(R.string.PREF_MAP_START_ZOOM), value.toFloat())
            editor?.apply()
        }

    var latitude: Double = 52.372706
        set(value) {
            field = value
            val editor = sharedPref?.edit()
            editor?.putFloat(SurveyorApp.instance.getString(R.string.PREF_MAP_START_LAT), value.toFloat())
            editor?.apply()
        }

    var longitude: Double = 4.897312
        set(value) {
            field = value
            val editor = sharedPref?.edit()
            editor?.putFloat(SurveyorApp.instance.getString(R.string.PREF_MAP_START_LON), value.toFloat())
            editor?.apply()
        }

    var lineList: MutableList<MapLine> = ArrayList()
    var pointList: MutableList<MapPoint> = ArrayList()
    var seenGateways: MutableMap<String, GatewayMetadata> = HashMap();

    var gpsStatusMessage: String = "GPS stopped"
    var mqttStatusMessage: String = "MQTT disconnected"

    fun centerMap(location: Location) {
        try {
            AppAggregate.mainActivity?.mapFragment?.centerMapTo(location)
        } catch (e: NullPointerException) {
            // The UI might not exist at this point
        }
    }
}