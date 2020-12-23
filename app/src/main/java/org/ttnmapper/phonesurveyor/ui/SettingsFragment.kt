package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.content.SharedPreferences
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceGroup
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import kotlin.concurrent.thread


class SettingsFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {
    private val TAG = SettingsFragment::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        thread(start = true) {
            // Iterating through the preferneces is slow, so we do it in another thread
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
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        //TODO("Not yet implemented")
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if(key != null) {
            updatePreference(findPreference(key), key)
        }
    }

    private fun updatePreference(preference: Preference?, key: String?) {
        if (preference == null) return
        if (key == null) return

        if (key == SurveyorApp.instance.getString(R.string.PREF_MAP_START_LAT)
                || key == SurveyorApp.instance.getString(R.string.PREF_MAP_START_LON)) {
            return
        }

//        Log.e(TAG, "Preference changed: " + key)


//        if (preference is ListPreference) {
//            val listPreference = preference as ListPreference?
//            listPreference!!.summary = listPreference.entry
//            return
//        }

        val sharedPrefs = preferenceManager.sharedPreferences

        // If the filename change update the UI - but only if activity is not null
        if (key == SurveyorApp.instance.getString(R.string.PREF_SAVE_FILE_NAME)) {
            activity?.runOnUiThread {
                preference.summary = sharedPrefs.getString(key, "")
            }
        }
    }



    val REQUEST_CODE_ALERT_RINGTONE = 3

    fun getRingtonePreferenceValue(): String? {
        return preferenceManager.sharedPreferences.getString(getString(R.string.PREF_SOUND_URI), null)
    }

    fun setRingtonPreferenceValue(value: String) {
        Log.d(TAG, "Ringtone uri = " + value)

        val editor = preferenceManager.sharedPreferences.edit()
        editor.putString(getString(R.string.PREF_SOUND_URI), value) //This is just an example, you could also put boolean, long, int or floats
        editor.apply()
    }

    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        return if (preference.key == getString(R.string.PREF_SOUND_URI)) {
            val intent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION)
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true)
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, true)
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI, Settings.System.DEFAULT_NOTIFICATION_URI)
            val existingValue: String? = getRingtonePreferenceValue() // TODO
            if (existingValue != null) {
                if (existingValue.isEmpty()) {
                    // Select "Silent"
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, null as Uri?)
                } else {
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Uri.parse(existingValue))
                }
            } else {
                // No ringtone has been selected, set to the default
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Settings.System.DEFAULT_NOTIFICATION_URI)
            }
            startActivityForResult(intent, REQUEST_CODE_ALERT_RINGTONE)
            true
        } else {
            super.onPreferenceTreeClick(preference)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_ALERT_RINGTONE && data != null) {
            val ringtone: Uri? = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
            if (ringtone != null) {
                setRingtonPreferenceValue(ringtone.toString())
            } else {
                // "Silent" was selected
                setRingtonPreferenceValue("")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
