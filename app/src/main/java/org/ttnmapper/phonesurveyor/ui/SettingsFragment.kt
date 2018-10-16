package org.ttnmapper.phonesurveyor.ui

import android.os.Bundle
import android.preference.PreferenceFragment
import org.ttnmapper.phonesurveyor.R

class SettingsFragment : PreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settings_main)
    }


}
