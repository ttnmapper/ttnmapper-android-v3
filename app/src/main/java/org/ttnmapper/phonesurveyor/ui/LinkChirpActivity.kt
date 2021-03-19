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

        // load old values as default values
        if (sharedPreferences.getString(getString(R.string.PREF_NETWORK_SERVER),"").equals(getString(R.string.NS_CHIRP))) {
            binding.editTextMqttUsername.setText(sharedPreferences.getString(getString(R.string.PREF_MQTT_USERNAME), ""))
            binding.editTextMqttPassword.setText(sharedPreferences.getString(getString(R.string.PREF_MQTT_PASSWORD), ""))
            binding.editTextMqttAddress.setText(sharedPreferences.getString(getString(R.string.PREF_MQTT_BROKER), ""))

            var deviceEui: String = sharedPreferences.getString(getString(R.string.PREF_MQTT_TOPIC), "")!!
            if (!deviceEui.equals("")) {
                deviceEui = deviceEui.substring(0, deviceEui.length - 9)
                deviceEui = deviceEui.substring(deviceEui.lastIndexOf('/') + 1)
            }
            binding.editTextDeviceEui.setText(deviceEui)

            var appId: String = sharedPreferences.getString(getString(R.string.PREF_MQTT_TOPIC), "")!!
            if (!appId.equals("")) {
                appId = appId.substring(12)
                appId = appId.substring(0, appId.indexOf('/'))
            }
            binding.editTextAppId.setText(appId)
        }

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