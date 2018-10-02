package org.ttnmapper.phonesurveyor.ui

import android.Manifest
import android.app.ActivityManager
import android.app.AlertDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.IBinder
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.services.MyService
import org.ttnmapper.phonesurveyor.utils.getBackgroundNotification
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.fragment_map.*


class MainActivity : SettingsFragment.OnFragmentInteractionListener, StatsFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener, AppCompatActivity() {

    private val TAG = MainActivity::class.java.getName()

    private val RECORD_REQUEST_CODE = 101

    val settingsFragment: SettingsFragment = SettingsFragment.newInstance("one", "two");
    val mapFragment: MapFragment = MapFragment.newInstance("one", "two");
    val statsFragment: StatsFragment = StatsFragment.newInstance("one", "two");

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_settings -> {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, settingsFragment, "Settings")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, mapFragment, "Map")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stats -> {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, statsFragment, "Stats")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Save a handle to the main activity in the app aggregate singleton
        // Needed to send updates to UI from service
        AppAggregate.mainActivity = this

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, mapFragment, "Map")
                .commit();

        navigation.getMenu().getItem(1).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setupPermissions()
    }

    override fun onDestroy() {
        AppAggregate.stopService()
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu items for use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.action_bar_options, menu)

        val serviceClass = MyService::class.java
        if(AppAggregate.isServiceRunning(serviceClass)) {
            menu.findItem(R.id.action_start_stop).setTitle("Stop")
        } else {
            menu.findItem(R.id.action_start_stop).setTitle("Start")
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onFragmentInteraction(uri: Uri) {
        // save some data from the fragment...
        // other business logic...
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_start_stop -> {
            val serviceClass = MyService::class.java
            if(AppAggregate.isServiceRunning(serviceClass)) {
                AppAggregate.stopService()
                item.setTitle("Start")
            } else {
                AppAggregate.startService()
                item.setTitle("Stop")
            }
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WAKE_LOCK)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to phone state denied")
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            android.Manifest.permission.WAKE_LOCK)) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Permission to read phone state is required to make a background MQTT connection.")
                        .setTitle("Permission required")

                builder.setPositiveButton("OK"
                ) { dialog, id ->
                    Log.i(TAG, "Clicked")
                    makeRequest()
                }

                val dialog = builder.create()
                dialog.show()
            } else {
                makeRequest()
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.WAKE_LOCK),
                RECORD_REQUEST_CODE)
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
        }
    }

    fun setMQTTConnectionMessage(message: String) {
        textViewMQTTStatus.setText(message)
    }
}
