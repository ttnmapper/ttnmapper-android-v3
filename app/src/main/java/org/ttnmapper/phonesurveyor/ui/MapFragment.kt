package org.ttnmapper.phonesurveyor.ui

import android.graphics.*
import android.location.LocationManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import org.osmdroid.events.MapListener
import org.osmdroid.events.ScrollEvent
import org.osmdroid.events.ZoomEvent
import org.osmdroid.tileprovider.MapTileProviderBasic
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.util.GeoPoint
import org.osmdroid.util.MapTileIndex
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
import org.ttnmapper.phonesurveyor.databinding.FragmentMapBinding
import org.ttnmapper.phonesurveyor.room.Gateway
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getBitmapFromVectorDrawable


class MapFragment : Fragment()/*, View.OnTouchListener*/ {

    private val TAG = MapFragment::class.java.getName()

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private lateinit var tmsSource: OnlineTileSourceBase
    private lateinit var tmsProvider: MapTileProviderBasic
    private lateinit var tmsLayer: TilesOverlay
    private lateinit var locationIconBitmap: Bitmap

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

    override fun onPause() {
        Log.e(TAG, "onPause")
        MapAggregate.zoom = binding.map.zoomLevelDouble
        MapAggregate.latitude = binding.map.mapCenter.latitude
        MapAggregate.longitude = binding.map.mapCenter.longitude
        super.onPause()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.e(TAG, "onCreateView")

        // Inflate the layout for this fragment
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val view = binding.root

        locationIconBitmap = getBitmapFromVectorDrawable(requireContext(), R.drawable.ic_arrow)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
        when (sharedPreferences.getString(getString(R.string.PREF_BACKGROUND_MAP), getString(R.string.MAP_STAMEN_TONER_LIGHT))) {
            // Stamen Toner Light
            getString(R.string.MAP_STAMEN_TONER_LIGHT) -> {
                Log.e(TAG, "Stamen toner light")
                binding.map.setTileSource(object : OnlineTileSourceBase("Stamen Toner Light",
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
                                + "@2x"
                                + mImageFilenameEnding)
                    }
                })
            }

            // Terrain
            getString(R.string.MAP_TERRAIN) -> {
                Log.e(TAG, "Map terrain")
                binding.map.setTileSource(object : OnlineTileSourceBase("Arcgis World Shaded Relief",
                        0, 14, 256, "",
                        arrayOf("https://server.arcgisonline.com/ArcGIS/rest/services/World_Shaded_Relief/MapServer/tile/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + "@2x"
                                + mImageFilenameEnding)
                    }
                })
            }

            // Satellite
            getString(R.string.MAP_SATELLITE) -> {
                Log.e(TAG, "Map satellite")
                binding.map.setTileSource(object : OnlineTileSourceBase("Arcgis World Imagery",
                        0, 20, 256, "",
                        arrayOf("https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + "@2x"
                                + mImageFilenameEnding)
                    }
                })
            }

            // OSM Mapnik
            getString(R.string.MAP_OSM_MAPNIK) -> {
                Log.e(TAG, "Map osm mapnik")
                binding.map.setTileSource(object : OnlineTileSourceBase("Open Street Map Mapnik",
                        0, 20, 256, ".png",
                        arrayOf("https://a.tile.openstreetmap.org/",
                                "https://b.tile.openstreetmap.org/",
                                "https://c.tile.openstreetmap.org/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + mImageFilenameEnding)
                    }
                })
            }

            // OSM Mapnik greyscale
            getString(R.string.MAP_OSM_MAPNIK_GREYSCALE) -> {
                Log.e(TAG, "Map osm mapnik greyscale")
                binding.map.setTileSource(object : OnlineTileSourceBase("Open Street Map Mapnik",
                        0, 20, 256, ".png",
                        arrayOf("https://a.tile.openstreetmap.org/",
                                "https://b.tile.openstreetmap.org/",
                                "https://c.tile.openstreetmap.org/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + mImageFilenameEnding)
                    }
                })

                // Apply grayscale filter
                val matrix = ColorMatrix()
                matrix.setSaturation(0.0f)
                val filter = ColorMatrixColorFilter(matrix);
                //map.getOverlayManager().getTilesOverlay().setColorFilter(TilesOverlay.INVERT_COLORS) //night mode
                binding.map.getOverlayManager().getTilesOverlay().setColorFilter(filter);
            }

            // OSM Mapnik night mode
            getString(R.string.MAP_OSM_MAPNIK_NIGHTMODE) -> {
                Log.e(TAG, "Map osm mapnik greyscale")
                binding.map.setTileSource(object : OnlineTileSourceBase("Open Street Map Mapnik",
                        0, 20, 256, ".png",
                        arrayOf("https://a.tile.openstreetmap.org/",
                                "https://b.tile.openstreetmap.org/",
                                "https://c.tile.openstreetmap.org/")) {
                    override fun getTileURLString(pMapTileIndex: Long): String {
                        return (baseUrl
                                + MapTileIndex.getZoom(pMapTileIndex)
                                + "/" + MapTileIndex.getX(pMapTileIndex)
                                + "/" + MapTileIndex.getY(pMapTileIndex)
                                + mImageFilenameEnding)
                    }
                })

                // Apply grayscale filter
                binding.map.getOverlayManager().getTilesOverlay().setColorFilter(TilesOverlay.INVERT_COLORS) //night mode
            }
        }



        binding.map.setTilesScaledToDpi(true)
        binding.map.setMultiTouchControls(true)

        binding.map.addMapListener(object : MapListener {
            override fun onZoom(zoomEvent: ZoomEvent): Boolean {
                MapAggregate.zoom = zoomEvent.zoomLevel
                return false
            }

            override fun onScroll(scrollEvent: ScrollEvent): Boolean {
                if (scrollEvent.x == 0 && scrollEvent.y == 0) {
                    //Ignore onScroll that is called onCreate and on screen rotate
                } else {
                    MapAggregate.latitude = binding.map.mapCenter.latitude
                    MapAggregate.longitude = binding.map.mapCenter.longitude
                }
                return false
            }
        })

        // get map controller
        val controller = binding.map.controller

        Log.e(TAG, "Restoring map location to: " + MapAggregate.latitude + "," + MapAggregate.longitude)
        val position = GeoPoint(MapAggregate.latitude, MapAggregate.longitude)
        controller.setCenter(position)
        controller.setZoom(MapAggregate.zoom)
        //MapUtils.addMarker(activity, map, -34, 19)

        redrawMap()

        binding.textViewGPSStatus.text = MapAggregate.gpsStatusMessage
        binding.textViewMQTTStatus.text = MapAggregate.mqttStatusMessage

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }
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
            binding.map.overlayManager.add(line)
            binding.map.invalidate()
        }
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long) {
        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }
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

        binding.map.getOverlays().add(sfpo)
        binding.map.invalidate()
    }

    fun redrawMap() {
        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }
        if (!isAdded() || activity == null) {
            return
        }

        binding.map.overlays.clear()

        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        // Show own location on map
        val provider = GpsMyLocationProvider(SurveyorApp.instance)
        provider.addLocationSource(LocationManager.NETWORK_PROVIDER) // When we start mapping this provider will also get GPS locations


        var myLocationNewOverlay = MyLocationNewOverlay(provider, binding.map)
        myLocationNewOverlay.enableMyLocation()
        myLocationNewOverlay.setDirectionArrow(locationIconBitmap, locationIconBitmap)
        myLocationNewOverlay.setPersonIcon(locationIconBitmap)
        myLocationNewOverlay.isDrawAccuracyEnabled = true

        myLocationNewOverlay.enableAutoStop = false
        if (sharedPreferences.getBoolean(getString(R.string.PREF_AUTO_CENTER), true)) {
            myLocationNewOverlay.enableFollowLocation()
        } else {
            myLocationNewOverlay.disableFollowLocation()
        }

        // Set anchor position of non-moving person icon
        val mScale = context?.getResources()?.getDisplayMetrics()?.density
        if (mScale != null) {
            // Icon is 24x24, anchor to centre
            val mPersonHotspotX = 12.0f * mScale + 0.5f
            val mPersonHotspotY = 12.0f * mScale + 0.5f
            myLocationNewOverlay.setPersonHotspot(mPersonHotspotX, mPersonHotspotY)
        }

        binding.map.getOverlays().add(myLocationNewOverlay)

        // Add tiles layer with custom tile source
        if (sharedPreferences.getBoolean(getString(R.string.PREF_COVERAGE), false)) {
            binding.map.getOverlays().add(tmsLayer)
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

        binding.map.invalidate()
    }

    fun addGatewayToMap(gateway: Gateway) {
        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }

        if (!isAdded() || activity == null) {
            return
        }

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        val icon = when(sharedPreferences.getString(getString(R.string.PREF_NETWORK_SERVER), "")) {
            getString(R.string.NS_TTN_V2) -> ResourcesCompat.getDrawable(requireActivity().resources, R.drawable.ic_gateway_dot_24dp, null)
            getString(R.string.NS_TTS_V3) -> ResourcesCompat.getDrawable(requireActivity().resources, R.drawable.ic_tts_24dp, null)
            getString(R.string.NS_CHIRP) -> ResourcesCompat.getDrawable(requireActivity().resources, R.drawable.ic_chirp_24dp, null)
            else -> ResourcesCompat.getDrawable(requireActivity().resources, R.drawable.ic_gateway_dot_24dp, null)
        }

        if (sharedPreferences.getBoolean(getString(R.string.PREF_LORDRIVE), true)) {

            if (gateway.latitude != null && gateway.longitude != null) {
                val gatewayMarker = Marker(binding.map)
                gatewayMarker.icon = icon
                gatewayMarker.setPosition(GeoPoint(gateway.latitude!!, gateway.longitude!!))
                gatewayMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
                if(gateway.description.isNullOrBlank()) {
                    gatewayMarker.title = gateway.gtwId
                } else {
                    gatewayMarker.title = gateway.gtwId + "\n" + gateway.description
                }
                binding.map.getOverlays().add(gatewayMarker)
                binding.map.invalidate()

            }
        }
    }

    fun setMQTTStatusMessage(message: String) {
        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }
        MapAggregate.mqttStatusMessage = message
        binding.textViewMQTTStatus.setText(message)
    }

    fun setGPSStatusMessage(message: String) {
        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }
        MapAggregate.gpsStatusMessage = message
        binding.textViewGPSStatus.setText(message)
    }

}
