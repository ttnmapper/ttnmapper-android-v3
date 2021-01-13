package org.ttnmapper.phonesurveyor.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import org.ttnmapper.phonesurveyor.R
import java.io.BufferedReader
import java.io.InputStreamReader


class SettingsFragment : PreferenceFragmentCompat() {
    private val TAG = SettingsFragment::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()

        val sharedPreferences = preferenceManager.sharedPreferences

        val editTextMqttUsername = findPreference<EditTextPreference>(activity?.getString(R.string.PREF_MQTT_USERNAME).toString())
        editTextMqttUsername!!.summary = sharedPreferences.getString(editTextMqttUsername.key, "<not set>")

        val editTextMqttPassword = findPreference<EditTextPreference>(activity?.getString(R.string.PREF_MQTT_PASSWORD).toString())
        editTextMqttPassword!!.summary = sharedPreferences.getString(editTextMqttPassword.key, "<not set>")

        val editTextMqttTopic = findPreference<EditTextPreference>(activity?.getString(R.string.PREF_MQTT_TOPIC).toString())
        editTextMqttTopic!!.summary = sharedPreferences.getString(editTextMqttTopic.key, "<not set>")

        val editTextMqttBroker = findPreference<EditTextPreference>(activity?.getString(R.string.PREF_MQTT_BROKER).toString())
        editTextMqttBroker!!.summary = sharedPreferences.getString(editTextMqttBroker.key, "<not set>")

        val listNetwork = findPreference<ListPreference>(activity?.getString(R.string.PREF_NETWORK_SERVER).toString())
        listNetwork!!.summary = sharedPreferences.getString(listNetwork.key, "<not set>")

        val prefBugReport = findPreference("bugreport") as Preference?
        prefBugReport!!.onPreferenceClickListener = Preference.OnPreferenceClickListener { //open browser or intent here

            val log = StringBuilder()

            log.appendLine("Manufacturer: " + Build.MANUFACTURER)
            log.appendLine("Board: " + Build.BOARD)
            log.appendLine("Display: " + Build.DISPLAY)

            log.appendLine("MODEL: " + Build.MODEL)
            log.appendLine("BRAND: " + Build.BRAND)
            log.appendLine("HOST: " + Build.HOST)

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                log.appendLine("BASE_OS: "+Build.VERSION.BASE_OS)
                log.appendLine("PREVIEW_SDK_INT: "+Build.VERSION.PREVIEW_SDK_INT)
                log.appendLine("SECURITY_PATCH: "+Build.VERSION.SECURITY_PATCH)
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                log.appendLine("RELEASE_OR_CODENAME: "+Build.VERSION.RELEASE_OR_CODENAME)
            }
            log.appendLine("CODENAME: "+Build.VERSION.CODENAME)
            log.appendLine("INCREMENTAL: "+Build.VERSION.INCREMENTAL)
            log.appendLine("RELEASE: "+Build.VERSION.RELEASE)
            log.appendLine("SDK_INT: "+Build.VERSION.SDK_INT)
            log.appendLine()
            log.appendLine()

            val process = Runtime.getRuntime().exec("logcat -d")
            val bufferedReader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String? = ""
            while (bufferedReader.readLine().also { line = it } != null) {
                log.appendLine(line)
            }


            val pInfo = requireActivity().packageManager.getPackageInfo(requireActivity().packageName, 0)

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("android@ttnmapper.org"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Bug report " + pInfo.versionName + " (build " + pInfo.versionCode + ")")
            intent.putExtra(Intent.EXTRA_TEXT, log.toString())
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(intent)
            }


            val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("TTN Mapper Logcat", log)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(activity, "Log output copied to the clipboard", Toast.LENGTH_SHORT).show()

            true
        }
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // Nothing to do
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
