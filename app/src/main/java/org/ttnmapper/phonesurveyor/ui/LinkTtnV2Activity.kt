package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.databinding.ActivityLinkTtnV2Binding

class LinkTtnV2Activity : AppCompatActivity() {
    private val TAG = LinkTtnV2Activity::class.java.getName()

    private lateinit var binding: ActivityLinkTtnV2Binding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinkTtnV2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        // load old values as default values
        binding.editTextAppId.setText(sharedPreferences.getString(getString(R.string.PREF_TTN_V2_APP_ID), ""))
        binding.editTextAccessKey.setText(sharedPreferences.getString(getString(R.string.PREF_TTN_V2_ACCESS_KEY), "ttn-account-v2..."))
        binding.editTextMqttAddress.setText(sharedPreferences.getString(getString(R.string.PREF_TTN_V2_MQTT_ADDRESS), "tcp://eu.thethings.network:1883"))
        binding.editTextDevId.setText(sharedPreferences.getString(getString(R.string.PREF_TTN_V2_DEV_ID), ""))

        binding.buttonLinkDevice.setOnClickListener {
            val editor = sharedPreferences.edit()

            // Store specific V2 settings for pre-filling the form next time
            editor.putString(getString(R.string.PREF_TTN_V2_APP_ID), binding.editTextAppId.text.toString())
            editor.putString(getString(R.string.PREF_TTN_V2_ACCESS_KEY), binding.editTextAccessKey.text.toString())
            editor.putString(getString(R.string.PREF_TTN_V2_MQTT_ADDRESS), binding.editTextMqttAddress.text.toString())
            editor.putString(getString(R.string.PREF_TTN_V2_DEV_ID), binding.editTextDevId.text.toString())

            // Store generic details used by mqtt library
            editor.putString(getString(R.string.PREF_NETWORK_SERVER), getString(R.string.NS_TTN_V2))
            editor.putString(getString(R.string.PREF_MQTT_USERNAME), binding.editTextAppId.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_PASSWORD), binding.editTextAccessKey.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_BROKER), binding.editTextMqttAddress.text.toString())
            val mqttTopic = binding.editTextAppId.text.toString() + "/devices/" + binding.editTextDevId.text.toString() + "/up"
            editor.putString(getString(R.string.PREF_MQTT_TOPIC), mqttTopic)

            editor.apply()
            finish()
        }
        binding.buttonTtnLogin.setOnClickListener {
            val i = Intent(this, TtnLoginActivity::class.java)
            startActivity(i)
        }
    }
}