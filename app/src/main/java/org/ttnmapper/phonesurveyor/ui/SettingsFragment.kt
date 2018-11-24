package org.ttnmapper.phonesurveyor.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.util.Log
import org.ttnmapper.phonesurveyor.R
import android.preference.PreferenceGroup





class SettingsFragment : PreferenceFragment(), SharedPreferences.OnSharedPreferenceChangeListener {
    private val TAG = SettingsFragment::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        for (i in 0 until preferenceScreen.preferenceCount) {
            val preference = preferenceScreen.getPreference(i)
            if (preference is PreferenceGroup) {
                for (j in 0 until preference.preferenceCount) {
                    val singlePref = preference.getPreference(j)
                    updatePreference(singlePref, singlePref.key)
                }
            } else {
                updatePreference(preference, preference.key)
            }
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        Log.e(TAG, "Preference changed: "+key)

        updatePreference(findPreference(key), key)
    }

    private fun updatePreference(preference: Preference?, key: String?) {
        if (preference == null) return

//        if (preference is ListPreference) {
//            val listPreference = preference as ListPreference?
//            listPreference!!.summary = listPreference.entry
//            return
//        }

        val sharedPrefs = preferenceManager.sharedPreferences

        if(key == getString(R.string.PREF_SAVE_FILE_NAME)) {
            preference.summary = sharedPrefs.getString(key, "")
        }
    }

}
