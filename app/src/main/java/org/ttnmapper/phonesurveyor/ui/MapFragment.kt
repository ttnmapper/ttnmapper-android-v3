package org.ttnmapper.phonesurveyor.ui

import android.app.Fragment
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.simplefastpoint.SimpleFastPointOverlay
import org.osmdroid.views.overlay.simplefastpoint.SimpleFastPointOverlayOptions
import org.osmdroid.views.overlay.simplefastpoint.SimplePointTheme
import org.ttnmapper.phonesurveyor.R
import org.osmdroid.events.ScrollEvent
import org.osmdroid.events.ZoomEvent
import org.osmdroid.events.MapListener
import org.ttnmapper.phonesurveyor.aggregates.MapAggregate


class MapFragment : Fragment() {
    private val TAG = MapFragment::class.java.getName()

    private lateinit var map: MapView
    private lateinit var textViewMQTTStatus: TextView
    private lateinit var textViewGPSStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.e(TAG, "onCreateView")

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        map = view.findViewById(R.id.map)
        textViewMQTTStatus = view.findViewById(R.id.textViewMQTTStatus)
        textViewGPSStatus = view.findViewById(R.id.textViewGPSStatus)


        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setTilesScaledToDpi(true)
        map.setMultiTouchControls(true)

        map.addMapListener(object : MapListener {
            override fun onZoom(zoomEvent: ZoomEvent): Boolean {
                MapAggregate.zoom = zoomEvent.zoomLevel
                return false
            }

            override fun onScroll(scrollEvent: ScrollEvent): Boolean {
                if(scrollEvent.x == 0 && scrollEvent.y == 0) {
                    //Ignore onScroll that is called onCreate and on screen rotate
                } else {
                    MapAggregate.latitude = map.mapCenter.latitude
                    MapAggregate.longitude = map.mapCenter.longitude
                }
                return false
            }
        })

        // get map controller
        val controller = map.controller

        Log.e(TAG, "Restoring map location to: "+MapAggregate.latitude+","+MapAggregate.longitude)
        val position = GeoPoint(MapAggregate.latitude, MapAggregate.longitude)
        controller.setCenter(position)
        controller.setZoom(MapAggregate.zoom)
        //MapUtils.addMarker(activity, map, -34, 19)

        redrawMap()

        textViewGPSStatus.setText(MapAggregate.gpsStatusMessage)
        textViewMQTTStatus.setText(MapAggregate.mqttStatusMessage)

        return view;
    }

    fun addGateway() {

    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        val geoPoints: List<GeoPoint> = listOf(GeoPoint(startLat, startLon), GeoPoint(endLat, endLon))
        val line = Polyline()
        line.setPoints(geoPoints)
//        line.setOnClickListener { polyline, mapView, eventPos ->
//            Toast.makeText(mapView.context, "polyline with " + polyline.points.size + "pts was tapped", Toast.LENGTH_LONG).show()
//            false
//        }
        MapAggregate.lineList.add(line)
        map.overlayManager.add(line)
        map.invalidate()
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long) {
        val points: List<GeoPoint> = listOf(GeoPoint(lat, lon))
        val pt = SimplePointTheme(points, false)

        var mPointStyle = Paint()
        mPointStyle.setStyle(Paint.Style.FILL)
        mPointStyle.setColor(colour.toInt())

// set some visual options for the overlay
// we use here MAXIMUM_OPTIMIZATION algorithm, which works well with >100k points
        val opt = SimpleFastPointOverlayOptions.getDefaultStyle()
                .setPointStyle(mPointStyle)
                .setAlgorithm(SimpleFastPointOverlayOptions.RenderingAlgorithm.MAXIMUM_OPTIMIZATION)
                .setRadius(7f).setIsClickable(true).setCellSize(15)

        val sfpo = SimpleFastPointOverlay(pt, opt)

        //sfpo.setOnClickListener { points, point -> Toast.makeText(map.getContext(), "You clicked " + (points.get(point!!) as LabelledGeoPoint).label, Toast.LENGTH_SHORT).show() }

        MapAggregate.pointList.add(sfpo)
        map.getOverlays().add(sfpo)
        map.invalidate()
    }

    fun redrawMap() {
        map.overlays.clear()

        map.overlays.addAll(MapAggregate.pointList)
        map.overlays.addAll(MapAggregate.lineList)
        map.invalidate()
    }

    fun refreshGatewaysOnMap() {
        map.invalidate()
    }

    fun setMQTTStatusMessage(message: String) {
        MapAggregate.mqttStatusMessage = message
        textViewMQTTStatus.setText(message)
    }

    fun setGPSStatusMessage(message: String) {
        MapAggregate.gpsStatusMessage = message
        textViewGPSStatus.setText(message)
    }
}
