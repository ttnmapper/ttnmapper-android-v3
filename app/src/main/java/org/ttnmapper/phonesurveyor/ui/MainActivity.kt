package org.ttnmapper.phonesurveyor.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.preference.PreferenceManager
import android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*
import org.osmdroid.config.Configuration
import org.ttnmapper.phonesurveyor.BuildConfig
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.aggregates.MapAggregate
import org.ttnmapper.phonesurveyor.model.GatewayMetadata
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private val TAG = MainActivity::class.java.getName()

    private val RECORD_REQUEST_CODE = 101
    val PERMISSION_ALL = 1

    val settingsFragment = SettingsFragment()
    val mapFragment = MapFragment()
    val statsFragment = StatsFragment()

    var startStopButton: MenuItem? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_settings -> {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, settingsFragment, "Settings")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, mapFragment, "Map")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stats -> {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, statsFragment, "Stats")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        Log.e(TAG, "Setting changed")
        setScreenAlwaysOn()
        //TODO: handle any other runtime changable settings

        // Sanitise the handler address
        if (key == getString(R.string.PREF_BROKER)) {
            val mqttUri = CommonFunctions.sanitiseMqttUri(sharedPreferences!!.getString(key, "eu.tehtings.network")!!)
            val editor = sharedPreferences.edit()
            editor.putString(key, mqttUri)
            editor.apply()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e(TAG, "Creating main activity")

        if (BuildConfig.BUILD_TYPE.equals("release")) {
            Fabric.with(this, Crashlytics())
        }

        //handle permissions first, before map is created. not depicted here

        //load/initialize the osmdroid configuration, this can be done
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()))
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string

        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            toggleMappingFab()
        }
        initMappingFab()

        // Save a handle to the main activity in the app aggregate singleton
        // Needed to send updates to UI from service
        AppAggregate.mainActivity = this

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
        AppAggregate.sharedPref = sharedPref
        sharedPref.registerOnSharedPreferenceChangeListener(this)

        // At first run create a new installation instance ID
        val editor = sharedPref.edit()
        if (sharedPref.contains(getString(R.string.PREF_MAPPER_IID)) && !(sharedPref.getString(getString(R.string.PREF_MAPPER_IID), "").equals(""))) {
            // pass
        } else {
            editor.putString(getString(R.string.PREF_MAPPER_IID), UUID.randomUUID().toString())
        }

        // Experiment default name
        if (sharedPref.contains(getString(R.string.PREF_EXPERIMENT_NAME)) && !(sharedPref.getString(getString(R.string.PREF_EXPERIMENT_NAME), "").equals(""))) {
            // pass
        } else {
            editor.putString(getString(R.string.PREF_EXPERIMENT_NAME), "experiment_" + sharedPref.getString(getString(R.string.PREF_MAPPER_IID), ""))
        }

        // Read map start location from preferences
        MapAggregate.latitude = sharedPref.getFloat(getString(R.string.PREF_MAP_START_LAT), 52.372706f).toDouble()
        MapAggregate.longitude = sharedPref.getFloat(getString(R.string.PREF_MAP_START_LON), 4.897312f).toDouble()
        MapAggregate.zoom = sharedPref.getFloat(getString(R.string.PREF_MAP_START_ZOOM), 6f).toDouble()

        // At startup set the logfile and experiment names to the current time
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH) // Quoted "Z" to indicate UTC, no timezone offset
        df.timeZone = tz
        val nowAsISO = df.format(Date())
        val fileName = "ttnmapper-$nowAsISO.log"
        editor.putString(getString(R.string.PREF_SAVE_FILE_NAME), fileName)

        editor.apply()

        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, mapFragment, "Map")
                .commit();

        navigation.getMenu().getItem(1).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setupPermissions()
        setScreenAlwaysOn()
    }

    override fun onDestroy() {
        //AppAggregate.stopService()
        super.onDestroy()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu items for use in the action bar
//        val inflater = menuInflater
//        inflater.inflate(R.menu.action_bar_options, menu)
//        startStopButton = menu.findItem(R.id.action_start_stop)
//
//        val serviceClass = MyService::class.java
//        if (AppAggregate.isServiceRunning(serviceClass)) {
//            startStopButton?.setTitle("Stop")
//        } else {
//            startStopButton?.setTitle("Start")
//        }
//
//        return super.onCreateOptionsMenu(menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//        R.id.action_start_stop -> {
//            val serviceClass = MyService::class.java
//            if (AppAggregate.isServiceRunning(serviceClass)) {
//                AppAggregate.stopService()
//                item.setTitle("Start")
//            } else {
//                AppAggregate.startService()
//                item.setTitle("Stop")
//            }
//            true
//        }
//
//        else -> {
//            // If we got here, the user's action was not recognized.
//            // Invoke the superclass to handle it.
//            super.onOptionsItemSelected(item)
//        }
//    }

    fun initMappingFab() {
        val fab: FloatingActionButton = findViewById(R.id.fab)

        val serviceClass = MyService::class.java
        if (AppAggregate.isServiceRunning(serviceClass)) {
            fab.setImageResource(android.R.drawable.ic_media_pause)
            fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.colorAccent)))
        } else {
            fab.setImageResource(android.R.drawable.ic_media_play)
            fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.ttnPrimary)))
        }
    }

    fun toggleMappingFab() {
        val fab: FloatingActionButton = findViewById(R.id.fab)

        val serviceClass = MyService::class.java
        if (AppAggregate.isServiceRunning(serviceClass)) {
            AppAggregate.stopService()
            fab.setImageResource(android.R.drawable.ic_media_play)
            fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.ttnPrimary)))
        } else {
            AppAggregate.startService()
            fab.setImageResource(android.R.drawable.ic_media_pause)
            fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.colorAccent)))
        }
    }

    fun setScreenAlwaysOn() {
        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)
        if (sharedPreferences.getBoolean(getString(R.string.PREF_SCREEN_ON), true)) {
            Log.e(TAG, "Screen always on")
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        } else {
            Log.e(TAG, "Screen NOT always on")
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }

    /*
    If the service stops itself, first trigger an update of the buttons.
    running is the new state after the service stops = false
     */
    fun updateStartStopButton(running: Boolean) {
        if (running) {
//            startStopButton?.setTitle("Stop")
            fab.setImageResource(android.R.drawable.ic_media_pause)
            fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.colorAccent)))
        } else {
//            startStopButton?.setTitle("Start")
            fab.setImageResource(android.R.drawable.ic_media_play)
            fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.ttnPrimary)))
        }
    }

    fun hasPermissions(context: Context?, permissions: List<String>): Boolean {
        if (context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

    private fun setupPermissions() {
        val PERMISSIONS = listOf(android.Manifest.permission.WAKE_LOCK, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.ACCESS_FINE_LOCATION)

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS.toTypedArray(), PERMISSION_ALL)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            var packageName = packageName;

            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager

            if (pm.isIgnoringBatteryOptimizations(packageName))
            //intent.setAction(ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
            else {
                var intent = Intent()
                intent.setAction(ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);
            }
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                }
            }

            PERMISSION_ALL -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                }
            }
        }
    }

    fun setMQTTStatusMessage(message: String) {
        mapFragment.setMQTTStatusMessage(message)
    }

    fun setGPSStatusMessage(message: String) {
        mapFragment.setGPSStatusMessage(message)
    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        runOnUiThread(
                {
                    mapFragment.drawLineOnMap(startLat, startLon, endLat, endLon, colour)
                }
        )
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long) {
        runOnUiThread({
            mapFragment.drawPointOnMap(lat, lon, colour)
        })
    }

    fun addGatewayToMap(gateway: GatewayMetadata) {
        runOnUiThread({
            mapFragment.addGatewayToMap(gateway)
        })
    }

    fun updateStats() {
        runOnUiThread({
            statsFragment.updateStats()
        })
    }
}
