package org.ttnmapper.phonesurveyor.aggregates

import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.simplefastpoint.SimpleFastPointOverlay
import org.ttnmapper.phonesurveyor.model.Gateway
import org.ttnmapper.phonesurveyor.model.MapLine
import org.ttnmapper.phonesurveyor.model.MapPoint
import java.util.HashMap

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
}