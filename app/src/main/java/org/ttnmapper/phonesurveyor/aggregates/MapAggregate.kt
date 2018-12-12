package org.ttnmapper.phonesurveyor.aggregates

import android.location.Location
import kotlinx.android.synthetic.main.fragment_map.*
import org.osmdroid.util.GeoPoint
import org.ttnmapper.phonesurveyor.model.Gateway
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import java.util.HashMap
import kotlin.collections.ArrayList
import kotlin.collections.MutableList
import kotlin.collections.MutableMap

object MapAggregate {
    private val TAG = MapAggregate::class.java.getName()

    var zoom: Double = 6.0
    var latitude: Double = -34.0
    var longitude: Double = 19.0

    var lineList: MutableList<MapLine> = ArrayList()
    var pointList: MutableList<MapPoint> = ArrayList()
    var seenGateways: MutableMap<String, Gateway> = HashMap();

    var gpsStatusMessage: String = "GPS stopped"
    var mqttStatusMessage: String = "MQTT disconnected"

    fun centerMap(location: Location) {
        latitude = location.latitude
        longitude = location.longitude
        val position = GeoPoint(latitude, longitude)

        val controller = AppAggregate.mainActivity?.mapFragment?.map?.controller
        controller?.animateTo(position)
    }
}