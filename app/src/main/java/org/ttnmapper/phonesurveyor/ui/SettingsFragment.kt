package org.ttnmapper.phonesurveyor.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import android.util.Log
import org.ttnmapper.phonesurveyor.R

class SettingsFragment : PreferenceFragment(), SharedPreferences.OnSharedPreferenceChangeListener {
    private val TAG = SettingsFragment::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        Log.e(TAG, "Preference changed: "+key)

        when(key) {
            /*
        android:key="category_general_preference"
            android:key="pref_screen_on"
            android:key="pref_play_sound"
            android:key="pref_sound"
            android:key="pref_save_file"
            android:key="pref_file_name"
        android:key="map_preference_screen"
            android:key="auto_center"
            android:key="auto_zoom"
            android:key="lordrive"
            android:key="coverage"
        android:key="category_upload_preference"
            android:key="pref_upload"
            android:key="pref_experiment"
            android:key="pref_experiment_name"
            android:key="pref_app_id"
            android:key="pref_app_key"
            android:key="pref_dev_id"
             */
            "pref_screen_on" -> {
//                val connectionPref: Preference = findPreference(key)
//                // Set summary to be the user-description for the selected value
//                connectionPref.summary = sharedPreferences!!.getString(key, "")
            }

        }
    }

}
