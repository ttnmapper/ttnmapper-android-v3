package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_device_list.*
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.adapters.DevicesAdapter
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate
import kotlin.concurrent.thread

class DeviceListActivity : AppCompatActivity() {
    private val TAG = DeviceListActivity::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_list)

        listViewDevices.visibility = View.GONE

        setStatusMessage("Loading list of devices.")
        thread(start = true) {
            if (TtnLoginAggregate.getListOfDevices() == true) {
                setupList()

            } else {
                setStatusMessage("Unable to load list of devices. Press back and choose another application.")
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_logout -> {
                val intent = Intent(applicationContext, TtnLoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // The flag we wanted
                intent.putExtra("SHOULD_LOGOUT", true) // Example of changing the intent to get something new..
                startActivity(intent)
            }
        }
        return true
    }

    fun setStatusMessage(status: String) {
        runOnUiThread {
            textViewStatus.visibility = View.VISIBLE
            textViewStatus.text = status
            Log.d(TAG, status)
        }
    }

    fun setupList() {
        runOnUiThread {
            progressBar.visibility = View.GONE
            textViewStatus.visibility = View.GONE
            listViewDevices.visibility = View.VISIBLE

            val adapter = DevicesAdapter(this)
            listViewDevices.adapter = adapter

            listViewDevices.setOnItemClickListener { _, _, position, _ ->
                //                Log.e(TAG, "Tapped item: "+position)
                TtnLoginAggregate.selectedDevice = TtnLoginAggregate.selectedApplication?.devices?.get(position)

                val intent = Intent(this, IntentConfigureActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
