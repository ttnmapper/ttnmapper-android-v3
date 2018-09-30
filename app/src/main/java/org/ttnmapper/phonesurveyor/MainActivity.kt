package org.ttnmapper.phonesurveyor

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SettingsFragment.OnFragmentInteractionListener, StatsFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener, AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_settings -> {
                val fragment = SettingsFragment.newInstance("one", "two");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, fragment, "Settings")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                val fragment = MapFragment.newInstance("one", "two");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, fragment, "Map")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stats -> {
                val fragment = StatsFragment.newInstance("one", "two");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_fragmentholder, fragment, "Stats")
                        .commit();
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MapFragment.newInstance("one", "two");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragment, "Map")
                .commit();

        navigation.getMenu().getItem(1).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onFragmentInteraction(uri: Uri) {
        // save some data from the fragment...
        // other business logic...
    }
}
