package org.ttnmapper.phonesurveyor.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.databinding.ActivityLinkTtsV3Binding

class LinkTtsV3Activity : AppCompatActivity() {
    private val TAG = LinkTtsV3Activity::class.java.getName()

    private lateinit var binding: ActivityLinkTtsV3Binding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinkTtsV3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        // load old values as default values
        binding.editTextUsername.setText(sharedPreferences.getString(getString(R.string.PREF_TTS_V3_USERNAME), ""))
        binding.editTextPassword.setText(sharedPreferences.getString(getString(R.string.PREF_TTS_V3_PASSWORD), ""))
        binding.editTextPublicAddress.setText(sharedPreferences.getString(getString(R.string.PREF_TTS_V3_PUBLIC_ADDRESS), ""))
        binding.editTextEndDeviceId.setText(sharedPreferences.getString(getString(R.string.PREF_TTS_V3_END_DEVICE_ID), ""))

        binding.buttonLinkDevice.setOnClickListener {
            val editor = sharedPreferences.edit()

            // Store specific V3 settings for pre-filling the form next time
            editor.putString(getString(R.string.PREF_TTS_V3_USERNAME), binding.editTextUsername.text.toString())
            editor.putString(getString(R.string.PREF_TTS_V3_PASSWORD), binding.editTextPassword.text.toString())
            editor.putString(getString(R.string.PREF_TTS_V3_PUBLIC_ADDRESS), binding.editTextPublicAddress.text.toString())
            editor.putString(getString(R.string.PREF_TTS_V3_END_DEVICE_ID), binding.editTextEndDeviceId.text.toString())

            // Store generic details used by mqtt library
            editor.putString(getString(R.string.PREF_NETWORK_SERVER), getString(R.string.NS_TTS_V3))
            editor.putString(getString(R.string.PREF_MQTT_USERNAME), binding.editTextUsername.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_PASSWORD), binding.editTextPassword.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_BROKER), binding.editTextPublicAddress.text.toString())
            // v3/test-app@the-box/devices/thingsuno/up
            val mqttTopic = "v3/" + binding.editTextUsername.text.toString() + "/devices/" + binding.editTextEndDeviceId.text.toString() + "/up"
            editor.putString(getString(R.string.PREF_MQTT_TOPIC), mqttTopic)

            editor.apply()
            finish()
        }
    }
}