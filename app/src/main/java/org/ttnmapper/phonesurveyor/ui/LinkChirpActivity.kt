package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.databinding.ActivityLinkChirpBinding
import org.ttnmapper.phonesurveyor.databinding.ActivityLinkTtnV2Binding
import java.util.*

class LinkChirpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLinkChirpBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinkChirpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        binding.buttonLinkDevice.setOnClickListener {
            val editor = sharedPreferences.edit()

            editor.putString(getString(R.string.PREF_NETWORK_SERVER), getString(R.string.NS_CHIRP))

            editor.putString(getString(R.string.PREF_MQTT_USERNAME), binding.editTextMqttUsername.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_PASSWORD), binding.editTextMqttPassword.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_BROKER), binding.editTextMqttAddress.text.toString())

            // application id
            val appId = binding.editTextAppId.text.toString()
            // device eui
            val devEui = binding.editTextDeviceEui.text.toString().toLowerCase(Locale.ROOT)

            // application/1/device/0004a30b001c684f/event/up
            val mqttTopic = "application/" + appId + "/device/" + devEui + "/event/up"
            editor.putString(getString(R.string.PREF_MQTT_TOPIC), mqttTopic)

            editor.apply()
            finish()
        }
    }
}