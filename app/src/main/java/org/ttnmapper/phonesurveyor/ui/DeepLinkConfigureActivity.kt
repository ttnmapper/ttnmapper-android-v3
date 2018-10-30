package org.ttnmapper.phonesurveyor.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deep_link_configure.*
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.aggregates.NetworkAggregate
import org.ttnmapper.phonesurveyor.utils.CommonFunctions
import kotlin.concurrent.thread
import android.content.Intent
import android.util.Log


class DeepLinkConfigureActivity : AppCompatActivity() {
    private val TAG = AppCompatActivity::class.java.getName()

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link_configure)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SurveyorApp.instance)

        val intent = intent
        val data = intent.data

        if (data != null && data.host == "app.ttnmapper.org") {
            val appId = data.getQueryParameter("appid")!!
            val devId = data.getQueryParameter("devid")!!
            val accessKey = data.getQueryParameter("accesskey")!!
            val handler = data.getQueryParameter("handler")!!

            if(appId.equals(sharedPreferences.getString(getString(R.string.PREF_APP_ID), ""))
                    && devId.equals(sharedPreferences.getString(getString(R.string.PREF_DEV_ID), ""))
                    && accessKey.equals(sharedPreferences.getString(getString(R.string.PREF_APP_KEY), ""))) {

                goToMainActivity()

            } else {
                editTextAppId.setText(appId)
                editTextDevId.setText(devId)
                editTextAccessKey.setText(accessKey)
                lookupAndFillMqtt(handler)
            }
        } else {
            goToMainActivity()
        }

        buttonLinkDevice.setOnClickListener{
            val editor = sharedPreferences.edit()

            editor.putString(getString(R.string.PREF_APP_ID), editTextAppId.text.toString())
            editor.putString(getString(R.string.PREF_DEV_ID), editTextDevId.text.toString())
            editor.putString(getString(R.string.PREF_APP_KEY), editTextAccessKey.text.toString())
            editor.putString(getString(R.string.PREF_BROKER), editTextMqttAddress.text.toString())

            editor.apply()

            goToMainActivity()
        }

        buttonCancel.setOnClickListener{
            goToMainActivity()
        }
    }

    fun lookupAndFillMqtt(handler: String) {
        editTextMqttAddress.isEnabled = false
        buttonLinkDevice.isEnabled = false
        editTextMqttAddress.setText(getString(R.string.obtaining_discovery))
        thread(start = true) {
            val mqttUri = CommonFunctions.sanitiseMqttUri(NetworkAggregate.getMqttUriFromHandler(handler))
            runOnUiThread {
                editTextMqttAddress.setText(mqttUri)
                editTextMqttAddress.isEnabled = true
                buttonLinkDevice.isEnabled = true
            }
        }
    }

    fun goToMainActivity() {
        val i = Intent(this, MainActivity::class.java)
        finish()
        startActivity(i)
    }

}
