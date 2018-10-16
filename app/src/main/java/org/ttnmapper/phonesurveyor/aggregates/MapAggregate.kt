package org.ttnmapper.phonesurveyor.aggregates

import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.simplefastpoint.SimpleFastPointOverlay

object MapAggregate {
    private val TAG = MapAggregate::class.java.getName()

    var zoom: Double = 6.0
    var latitude: Double = -34.0
    var longitude: Double = 19.0

    var lineList: MutableList<Polyline> = ArrayList()
    var pointList: MutableList<SimpleFastPointOverlay> = ArrayList()

    var gpsStatusMessage: String = "GPS stopped"
    var mqttStatusMessage: String = "MQTT disconnected"
}