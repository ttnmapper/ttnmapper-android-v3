package org.ttnmapper.phonesurveyor.ui

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.os.StrictMode
import android.provider.Settings.*
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.osmdroid.config.Configuration
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.aggregates.MapAggregate
import org.ttnmapper.phonesurveyor.databinding.ActivityMainBinding
import org.ttnmapper.phonesurveyor.room.AppDatabase
import org.ttnmapper.phonesurveyor.room.Gateway
import org.ttnmapper.phonesurveyor.room.MIGRATION_1_2
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import java.util.*


class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private val TAG = MainActivity::class.java.getName()

    private lateinit var binding: ActivityMainBinding

    val PERMISSIONS = listOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_BACKGROUND_LOCATION, android.Manifest.permission.WAKE_LOCK)

    private val RECORD_REQUEST_CODE = 101
    val PERMISSION_ALL = 1

    val settingsFragment = SettingsFragment()
    val mapFragment = MapFragment()
    val statsFragment = StatsFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_settings -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, settingsFragment, "Settings")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, mapFragment, "Map")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stats -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, statsFragment, "Stats")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

        if (key == getString(R.string.PREF_SCREEN_ON)) {
            setScreenAlwaysOn()
        }

        // Sanitise the handler address
        if (key == getString(R.string.PREF_MQTT_BROKER)) {
            val mqttUri = CommonFunctions.sanitiseMqttUri(sharedPreferences!!.getString(key, "eu.thetings.network")!!)
            val editor = sharedPreferences.edit()
            editor.putString(key, mqttUri)
            editor.apply()
        }

        //Handle any other runtime changeable settings
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.e(TAG, "onCreate")

        // Clear old preferences if we upgraded the app from before v23
        updatePreferences()

        // Initialize osmdroid
        Configuration.getInstance().load(applicationContext, PreferenceManager.getDefaultSharedPreferences(applicationContext))

        binding.fab.setOnClickListener { view ->
            toggleMappingFab()
        }
        initMappingFab()

        // Save a handle to the main activity in the app aggregate singleton
        // Needed to send updates to UI from service
        AppAggregate.mainActivity = this

        // Create database
        AppAggregate.db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "ttnmapper"
        )
            .addMigrations(MIGRATION_1_2)
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()

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

        editor.apply()

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, mapFragment, "Map")
                .commit()

        binding.navigation.menu.getItem(1).isChecked = true;
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setScreenAlwaysOn()
    }

    fun initMappingFab() {

        val serviceClass = MyService::class.java
        if (AppAggregate.isServiceRunning(serviceClass)) {
            binding.fab.setImageResource(android.R.drawable.ic_media_pause)
            binding.fab.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext,
                    R.color.colorAccent))
        } else {
            binding.fab.setImageResource(android.R.drawable.ic_media_play)
            binding.fab.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext,
                    R.color.ttnPrimary))
        }
    }

    fun toggleMappingFab() {
        val serviceClass = MyService::class.java
        if (AppAggregate.isServiceRunning(serviceClass)) {
            AppAggregate.stopService()
            binding.fab.setImageResource(android.R.drawable.ic_media_play)
            binding.fab.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext,
                    R.color.ttnPrimary))
        } else {
            if (!hasPermissions(this, PERMISSIONS)) {
                setupPermissions()
            } else if (!deviceLinked()) {
                AppAggregate.showAlertDialog("No device linked", "Did you link a device for mapping? Please check your settings and try again.")
            } else {
                showBackgroundLocationInfo()
                AppAggregate.startService()
                binding.fab.setImageResource(android.R.drawable.ic_media_pause)
                binding.fab.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext,
                        R.color.colorAccent))
            }
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
            binding.fab.setImageResource(android.R.drawable.ic_media_pause)
            binding.fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.colorAccent)))
        } else {
            binding.fab.setImageResource(android.R.drawable.ic_media_play)
            binding.fab.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.ttnPrimary)))
        }
    }

    fun hasPermissions(context: Context?, permissions: List<String>): Boolean {
        if (context != null) {
            for (permission in permissions) {
                if ( permission == android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) {
                    // ACCESS_BACKGROUND_LOCATION is a nice to have, but not necessity
                    continue
                }
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

    private fun setupPermissions() {
        if (!hasPermissions(this, PERMISSIONS)) {
            for (permission in PERMISSIONS) {
                ActivityCompat.requestPermissions(this, arrayOf(permission), PERMISSION_ALL)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager

            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                alertBuilder.setCancelable(true)
                alertBuilder.setTitle("Run in background")
                alertBuilder.setMessage("TTN Mapper needs permission to run in the background.\n\nThis is required to maintain an MQTT connection with TTN and to receive packets even when the app is in the background or your phone's screen is off.")
                alertBuilder.setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        var intent = Intent()
                        intent.action = ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                        intent.data = Uri.parse("package:" + packageName)
                        startActivity(intent)
                    }
                })
                val alert: AlertDialog = alertBuilder.create()
                alert.show()
            }
        }

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) ||
                    ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                alertBuilder.setCancelable(true)
                alertBuilder.setTitle("Location in background")
                alertBuilder.setMessage("TTN Mapper needs permission to read your location in background.\n\nThis is required to track your location with TTN when the app is in the background or your phone's screen is off.")
                alertBuilder.setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        var intent = Intent()
                        intent.action = ACTION_APPLICATION_DETAILS_SETTINGS
                        intent.data = Uri.parse("package:" + packageName)
                        startActivity(intent)
                    }
                })
                val alert: AlertDialog = alertBuilder.create()
                alert.show()
            }
        }
    }

    private fun showBackgroundLocationInfo() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P &&
                (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            Toast.makeText(this, "Started without background location", Toast.LENGTH_SHORT).show()
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

        // When location permission is granted the first time, we need to redraw the map fragment so that our location is shwon and auto centering works
        supportFragmentManager
                .beginTransaction()
                .detach(mapFragment)
                .attach(mapFragment)
                .commit()
    }

    fun setMQTTStatusMessage(message: String) {
        mapFragment.setMQTTStatusMessage(message)
    }

    fun setGPSStatusMessage(message: String) {
        mapFragment.setGPSStatusMessage(message)
    }

    fun showAlertDialog(title: String, message: String) {
        val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        alertBuilder.setCancelable(true)
        alertBuilder.setTitle(title)
        alertBuilder.setMessage(message)
        alertBuilder.setPositiveButton("OK", null)
        val alert: AlertDialog = alertBuilder.create()
        alert.show()
    }

    fun drawLineOnMap(startLat: Double, startLon: Double, endLat: Double, endLon: Double, colour: Long) {
        runOnUiThread {
            mapFragment.drawLineOnMap(startLat, startLon, endLat, endLon, colour)
        }
    }

    fun drawPointOnMap(lat: Double, lon: Double, colour: Long, packetbroker: Boolean) {
        runOnUiThread {
            mapFragment.drawPointOnMap(lat, lon, colour, packetbroker)
        }
    }

    fun addGatewayToMap(gateway: Gateway) {
        runOnUiThread {
            mapFragment.addGatewayToMap(gateway)
        }
    }

    fun updateStats() {
        runOnUiThread {
            statsFragment.updateStats()
        }
    }

    fun updatePreferences() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        /*
        osmdroid stores it's previously discovered paths in sharedpreferences:
        edit.putString("osmdroid.basePath",discoveredBasePath.getAbsolutePath());
        edit.putString("osmdroid.cachePath",discoveredCachePath.getAbsolutePath());
         */

        // App version
        val currentVersionCode: Long
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            currentVersionCode = packageManager.getPackageInfo(getPackageName(), 0).longVersionCode
        } else {
            currentVersionCode = packageManager.getPackageInfo(getPackageName(), 0).versionCode.toLong()
        }
        val previousVersionCode = prefs.getLong("appVersionCode", 0)


        // Android version
        val currentApiVersion = Build.VERSION.SDK_INT
        val previousApiVersion = prefs.getInt("androidSdkInt", 0)

        val editor = prefs.edit()

        if (currentVersionCode != previousVersionCode) {
            // Before 26 we need to handle osmdroid's wrong storage location
            if(previousVersionCode < 27) {
                Log.e(TAG, "App upgraded from before build 27. Clearing all preferences.")
                editor.clear()
            }
        }

        if(currentApiVersion != previousApiVersion) {
            // API 29 had a transitional storage system. Clear prefs so that we are sure to use the new system.
            if(currentApiVersion == 29 && previousApiVersion < 29) {
                Log.e(TAG, "Android SDK version changed to 29. Clearing all preferences.")
                editor.clear()
            }

            // Before API 30 we need to handle osmdroid's wrong storage location
            if(currentApiVersion == 30 && previousApiVersion < 30) {
                Log.e(TAG, "Android SDK version changed to 30. Clearing all preferences.")
                editor.clear()
            }
        }

        editor.putLong("appVersionCode", currentVersionCode)
        editor.putInt("androidSdkInt", currentApiVersion)
        editor.commit()
    }

    fun deviceLinked(): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        val broker = prefs.getString(getString(R.string.PREF_MQTT_BROKER), "")
        val topic = prefs.getString(getString(R.string.PREF_MQTT_TOPIC), "#")

        // If broker is blank, no device is linked
        if(broker!!.isBlank()) {
            return false
        }
        if(broker.equals("tcp://eu.thethings.network:1883") && topic.equals("#")) {
            return false
        }

        return true
    }
}
