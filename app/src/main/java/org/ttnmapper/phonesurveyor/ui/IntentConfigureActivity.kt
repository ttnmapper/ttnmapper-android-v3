package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.NetworkAggregate
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate
import org.ttnmapper.phonesurveyor.databinding.ActivityDeepLinkConfigureBinding
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import kotlin.concurrent.thread


class IntentConfigureActivity : AppCompatActivity() {
    private val TAG = AppCompatActivity::class.java.getName()

    private lateinit var binding: ActivityDeepLinkConfigureBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeepLinkConfigureBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        binding.editTextAppId.setText(TtnLoginAggregate.selectedDevice?.app_id)
        binding.editTextDevId.setText(TtnLoginAggregate.selectedDevice?.dev_id)
        binding.editTextMqttAddress.setText(TtnLoginAggregate.selectedApplication?.mqttAddress)

        // Iterate the keys and use the last one that has the message:up:r right
        TtnLoginAggregate.selectedApplication?.access_keys?.forEach {
            if (it!!.rights!!.contains("messages:up:r")) {
                binding.editTextAccessKey.setText(it.key)
            }
        }


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

            editor.apply()

            goToMainActivity()
        }

        binding.buttonCancel.setOnClickListener {
            goToMainActivity()
        }
    }

    fun lookupAndFillMqtt(handler: String) {
        binding.editTextMqttAddress.isEnabled = false
        binding.buttonLinkDevice.isEnabled = false
        binding.editTextMqttAddress.setText(getString(R.string.obtaining_discovery))
        thread(start = true) {
            val mqttUri = CommonFunctions.sanitiseMqttUri(NetworkAggregate.getMqttUriFromHandler(handler))
            runOnUiThread {
                binding.editTextMqttAddress.setText(mqttUri)
                binding.editTextMqttAddress.isEnabled = true
                binding.buttonLinkDevice.isEnabled = true
            }
        }
    }

    fun goToMainActivity() {
        val i = Intent(this, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
        finish()
    }

}
