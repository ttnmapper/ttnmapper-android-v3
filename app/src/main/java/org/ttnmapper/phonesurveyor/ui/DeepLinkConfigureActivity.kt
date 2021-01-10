package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.NetworkAggregate
import org.ttnmapper.phonesurveyor.databinding.ActivityDeepLinkConfigureBinding
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import kotlin.concurrent.thread


class DeepLinkConfigureActivity : AppCompatActivity() {
    private val TAG = DeepLinkConfigureActivity::class.java.getName()

    private lateinit var binding: ActivityDeepLinkConfigureBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeepLinkConfigureBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        val intent = intent
        val data = intent.data

        if (data != null && data.host == "app.ttnmapper.org") {
            val appId = data.getQueryParameter("appid")!!
            val devId = data.getQueryParameter("devid")!!
            val accessKey = data.getQueryParameter("accesskey")!!
            val handler = data.getQueryParameter("handler")!!

            binding.editTextAppId.setText(appId)
            binding.editTextDevId.setText(devId)
            binding.editTextAccessKey.setText(accessKey)
            lookupAndFillMqtt(handler)
        } else {
            goToMainActivity()
        }

        binding.buttonLinkDevice.setOnClickListener {
            val editor = sharedPreferences.edit()

            editor.putString(getString(R.string.PREF_NETWORK_SERVER), getString(R.string.NS_TTN_V2))

            editor.putString(getString(R.string.PREF_MQTT_USERNAME), binding.editTextAppId.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_PASSWORD), binding.editTextAccessKey.text.toString())
            editor.putString(getString(R.string.PREF_MQTT_BROKER), binding.editTextMqttAddress.text.toString())

            val mqttTopic = binding.editTextAppId.text.toString() + "/devices/" + binding.editTextDevId.text.toString() + "/up"
            editor.putString(getString(R.string.PREF_MQTT_TOPIC), mqttTopic)

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
        finish()
        startActivity(i)
    }

}
