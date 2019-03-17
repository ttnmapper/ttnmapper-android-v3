package org.ttnmapper.phonesurveyor.ui

import android.app.Fragment
import android.graphics.*
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.osmdroid.events.MapListener
import org.osmdroid.events.ScrollEvent
import org.osmdroid.events.ZoomEvent
import org.osmdroid.tileprovider.MapTileProviderBasic
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.util.GeoPoint
import org.osmdroid.util.MapTileIndex
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.TilesOverlay
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import org.osmdroid.views.overlay.simplefastpoint.SimpleFastPointOverlay
import org.osmdroid.views.overlay.simplefastpoint.SimpleFastPointOverlayOptions
import org.osmdroid.views.overlay.simplefastpoint.SimplePointTheme
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.MapAggregate
import org.ttnmapper.phonesurveyor.model.GatewayMetadata
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getBitmapFromVectorDrawable


class MapFragment : Fragment(), View.OnTouchListener {

    private val TAG = MapFragment::class.java.getName()

    private lateinit var map: MapView
    private lateinit var textViewMQTTStatus: TextView
    private lateinit var textViewGPSStatus: TextView
    private lateinit var tmsSource: OnlineTileSourceBase
    private lateinit var tmsProvider: MapTileProviderBasic
    private lateinit var tmsLayer: TilesOverlay
    private lateinit var locationIconBitmap: Bitmap
    private var fingerIsDown: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e(TAG, "onCreate")

        tmsSource = object : OnlineTileSourceBase("TTN Mapper TMS", 3, 15, 256, "png", arrayOf("")) {
            override fun getTileURLString(pMapTileIndex: Long): String {
                return "https://ttnmapper.org/tms/?tile=" + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + ""
            }
        }
        tmsProvider = MapTileProviderBasic(activity, tmsSource)
        tmsLayer = TilesOverlay(tmsProvider, activity)
        tmsLayer.setLoadingBackgroundColor(Color.TRANSPARENT)
        tmsLayer.setLoadingLineColor(Color.TRANSPARENT)
        tmsLayer.setColorFilter(
                ColorMatrixColorFilter(
                        floatArrayOf(
                                1f, 0f, 0f, 0f, 0f,
                                0f, 1f, 0f, 0f, 0f,
                                0f, 0f, 1f, 0f, 0f,
                                0f, 0f, 0f, 1f, -127f
                        )
                )
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.e(TAG, "onCreateView")

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        map = view.findViewById(R.id.map)
        textViewMQTTStatus = view.findViewById(R.id.textViewMQTTStatus)
        textViewGPSStatus = view.findViewById(R.id.textViewGPSStatus)

        locationIconBitmap = getBitmapFromVectorDrawable(activity, R.drawable.ic_arrow)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
        when (sharedPreferences.getString(getString(R.string.PREF_BACKGROUND_MAP), getString(R.string.MAP_STAMEN_TONER_LIGHT))) {
            // Stamen Toner Light
            getString(R.string.MAP_STAMEN_TONER_LIGHT) -> {
                Log.e(TAG, "Stamen toner light")
                map.setTileSource(object : OnlineTileSourceBase("Stamen Toner Light",
                        0, 20, 256, ".png",
                        arrayOf("https://stamen-tiles-a.a.ssl.fastly.net/toner-lite/",
                                "https://stamen-tiles-b.a.ssl.fastly.net/toner-lite/",
                                "https://stamen-tiles-c.a.ssl.fastly.net/toner-lite/",
                                "https://stamen-tiles-d.a.ssl.fastly.net/toner-lite/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + mImageFilenameEnding)
                    }
                })
            }

            // Terrain
            getString(R.string.MAP_TERRAIN) -> {
                Log.e(TAG, "Map terrain")
                map.setTileSource(object : OnlineTileSourceBase("Arcgis World Shaded Relief",
                        0, 14, 256, "",
                        arrayOf("https://server.arcgisonline.com/ArcGIS/rest/services/World_Shaded_Relief/MapServer/tile/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        val url = baseUrl + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + mImageFilenameEnding
//                        Log.e(TAG, url)
                        return (url)
                    }
                })
            }

            // Satellite
            getString(R.string.MAP_SATELLITE) -> {
                Log.e(TAG, "Map satellite")
                map.setTileSource(object : OnlineTileSourceBase("Arcgis World Imagery",
                        0, 20, 256, "",
                        arrayOf("https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + mImageFilenameEnding)
                    }
                })
            }

            // OSM Mapnik
            getString(R.string.MAP_OSM_MAPNIK) -> {
                Log.e(TAG, "Map osm mapnik")
                map.setTileSource(object : OnlineTileSourceBase("Open Street Map Mapnik",
                        0, 20, 256, ".png",
                        arrayOf("https://a.tile.openstreetmap.org/",
                                "https://b.tile.openstreetmap.org/",
                                "https://c.tile.openstreetmap.org/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        val url = baseUrl + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + mImageFilenameEnding
//                        Log.e(TAG, url)
                        return (url)
                    }
                })
            }

            // OSM Mapnik greyscale
            getString(R.string.MAP_OSM_MAPNIK_GREYSCALE) -> {
                Log.e(TAG, "Map osm mapnik greyscale")
                map.setTileSource(object : OnlineTileSourceBase("Open Street Map Mapnik",
                        0, 20, 256, ".png",
                        arrayOf("https://a.tile.openstreetmap.org/",
                                "https://b.tile.openstreetmap.org/",
                                "https://c.tile.openstreetmap.org/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        val url = baseUrl + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + mImageFilenameEnding
//                        Log.e(TAG, url)
                        return (url)
                    }
                })

                // Apply grayscale filter
                val matrix = ColorMatrix()
                matrix.setSaturation(0.0f)
                val filter = ColorMatrixColorFilter(matrix);
                //map.getOverlayManager().getTilesOverlay().setColorFilter(TilesOverlay.INVERT_COLORS) //night mode
                map.getOverlayManager().getTilesOverlay().setColorFilter(filter);
            }

            // OSM Mapnik night mode
            getString(R.string.MAP_OSM_MAPNIK_NIGHTMODE) -> {
                Log.e(TAG, "Map osm mapnik greyscale")
                map.setTileSource(object : OnlineTileSourceBase("Open Street Map Mapnik",
                        0, 20, 256, ".png",
                        arrayOf("https://a.tile.openstreetmap.org/",
                                "https://b.tile.openstreetmap.org/",
                                "https://c.tile.openstreetmap.org/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        val url = baseUrl + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + mImageFilenameEnding
//                        Log.e(TAG, url)
                        return (url)
                    }
                })

                // Apply grayscale filter
                map.getOverlayManager().getTilesOverlay().setColorFilter(TilesOverlay.INVERT_COLORS) //night mode
            }
        }



        map.setTilesScaledToDpi(false)
        map.setMultiTouchControls(true)

        map.addMapListener(object : MapListener {
            override fun onZoom(zoomEvent: ZoomEvent): Boolean {
                MapAggregate.zoom = zoomEvent.zoomLevel
                return false
            }

            override fun onScroll(scrollEvent: ScrollEvent): Boolean {
                if (scrollEvent.x == 0 && scrollEvent.y == 0) {
                    //Ignore onScroll that is called onCreate and on screen rotate
                } else {
                    MapAggregate.latitude = map.mapCenter.latitude
                    MapAggregate.longitude = map.mapCenter.longitude
                }
                return false
            }
        })

        map.setOnTouchListener(this)

        // get map controller
        val controller = map.controller

        Log.e(TAG, "Restoring map location to: " + MapAggregate.latitude + "," + MapAggregate.longitude)
        val position = GeoPoint(MapAggregate.latitude, MapAggregate.longitude)
        controller.setCenter(position)
        controller.setZoom(MapAggregate.zoom)
        //MapUtils.addMarker(activity, map, -34, 19)

        redrawMap()

        textViewGPSStatus.setText(MapAggregate.gpsStatusMessage)
        textViewMQTTStatus.setText(MapAggregate.mqttStatusMessage)

        return view;
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
//                Log.e(TAG, "Finger down")
                fingerIsDown = true
            }
            MotionEvent.ACTION_UP -> {
//                Log.e(TAG, "Finger up")
                fingerIsDown = false
            }
        }

        return false
    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        if (!isAdded() || activity == null) {
            return
        }

        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
        if (sharedPreferences.getBoolean(getString(R.string.PREF_LORDRIVE), true)) {

            val geoPoints: List<GeoPoint> = listOf(GeoPoint(startLat, startLon), GeoPoint(endLat, endLon))
            val line = Polyline()
            line.color = colour.toInt()
            line.width = 2.0f
            line.setPoints(geoPoints)
            map.overlayManager.add(line)
            map.invalidate()
        }
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long) {
        if (!isAdded() || activity == null) {
            return
        }

        val points: List<GeoPoint> = listOf(GeoPoint(lat, lon))
        val pt = SimplePointTheme(points, false)

        var mPointStyle = Paint()
        mPointStyle.setStyle(Paint.Style.FILL)
        mPointStyle.setColor(colour.toInt())

        val opt = SimpleFastPointOverlayOptions.getDefaultStyle()
                .setSymbol(SimpleFastPointOverlayOptions.Shape.CIRCLE) //square is faster than circle
                .setPointStyle(mPointStyle)
                .setAlgorithm(SimpleFastPointOverlayOptions.RenderingAlgorithm.MAXIMUM_OPTIMIZATION)
                .setRadius(15f).setIsClickable(false).setCellSize(15)

        val sfpo = SimpleFastPointOverlay(pt, opt)

        map.getOverlays().add(sfpo)
        map.invalidate()
    }

    fun redrawMap() {
        if (!isAdded() || activity == null) {
            return
        }

        map.overlays.clear()

        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        // Show own location on map
        val provider = GpsMyLocationProvider(SurveyorApp.instance)
        provider.addLocationSource(LocationManager.NETWORK_PROVIDER) // When we start mapping this provider will also get GPS locations
        var myLocationNewOverlay = MyLocationNewOverlay(provider, map)
        myLocationNewOverlay.enableMyLocation()
        myLocationNewOverlay.setPersonIcon(locationIconBitmap)
        myLocationNewOverlay.setDirectionArrow(locationIconBitmap, locationIconBitmap)
        myLocationNewOverlay.setPersonHotspot(0f, 0f)
        myLocationNewOverlay.isDrawAccuracyEnabled = false
        map.getOverlays().add(myLocationNewOverlay)

        // Add tiles layer with custom tile source
        if (sharedPreferences.getBoolean(getString(R.string.PREF_COVERAGE), false)) {
            map.getOverlays().add(tmsLayer)
        }


        if (sharedPreferences.getBoolean(getString(R.string.PREF_LORDRIVE), true)) {

            for (gateway in MapAggregate.seenGateways) {
                addGatewayToMap(gateway.value)
            }

            // Workaround as map.overlays.addAll(Polyline) didn't work
            for (line in MapAggregate.lineList) {
                drawLineOnMap(line.startLatitude, line.startLongitude, line.endLatitude, line.endLongitude, line.colour)
            }
        }

        for (point in MapAggregate.pointList) {
            drawPointOnMap(point.lat, point.lon, point.colour)
        }

        map.invalidate()
    }

    fun addGatewayToMap(gateway: GatewayMetadata) {
        if (!isAdded() || activity == null) {
            return
        }

        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
        if (sharedPreferences.getBoolean(getString(R.string.PREF_LORDRIVE), true)) {

            if (gateway.latitude != null && gateway.longitude != null) {
                var startMarker = Marker(map);
                startMarker.icon = SurveyorApp.instance.getDrawable(R.drawable.ic_gateway_dot_vector)
                startMarker.setPosition(GeoPoint(gateway.latitude!!, gateway.longitude!!))
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
                startMarker.title = gateway.gtwId
                map.getOverlays().add(startMarker)
                map.invalidate()
            }
        }
    }

    fun setMQTTStatusMessage(message: String) {
        MapAggregate.mqttStatusMessage = message
        textViewMQTTStatus.setText(message)
    }

    fun setGPSStatusMessage(message: String) {
        MapAggregate.gpsStatusMessage = message
        textViewGPSStatus.setText(message)
    }

    fun centerMapTo(location: Location) {
        if(!fingerIsDown) {
            MapAggregate.latitude = location.latitude
            MapAggregate.longitude = location.longitude
            val position = GeoPoint(MapAggregate.latitude, MapAggregate.longitude)
            map.controller.animateTo(position)
        }
    }

}
