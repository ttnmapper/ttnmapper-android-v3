package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_applications_list.*
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.adapters.ApplicationsAdapter
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate


class ApplicationsListActivity : AppCompatActivity() {
    private val TAG = ApplicationsListActivity::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applications_list)

        val adapter = ApplicationsAdapter(this)
        listViewApplications.adapter = adapter

        listViewApplications.setOnItemClickListener { _, _, position, _ ->
            //            Log.e(TAG, "Tapped item: "+position)
            TtnLoginAggregate.selectedApplication = TtnLoginAggregate.ttnApplications?.get(position)

            val intent = Intent(this, DeviceListActivity::class.java)
            startActivity(intent)
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
}
