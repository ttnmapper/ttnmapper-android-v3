package org.ttnmapper.phonesurveyor.aggregates

import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.ttnmapper.phonesurveyor.model.TTNMessage
import java.io.IOException
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp


object NetworkAggregate {
    private val TAG = NetworkAggregate::class.java.getName()

    val MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json")

    private val client = OkHttpClient()

    val context = AppAggregate.mainActivity


    fun postPacket(url: String, packet: TTNMessage) {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<TTNMessage>(TTNMessage::class.java)
        val postBody = jsonAdapter.toJson(packet)

        Log.e(TAG, postBody)

        val request = Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                .build()

        client.newCall(request).execute().use { response ->
            Log.e(TAG, response.body()?.string())
        }
    }

    fun postToTTNMapper(packet: TTNMessage) {
        postPacket(SurveyorApp.instance.getString(R.string.TTN_MAPPER_UPLOAD_API), packet)
    }

    fun postToCustomServer(packet: TTNMessage, serverUri: String) {
        postPacket(serverUri, packet)
    }

    fun getMqttUriFromHandler(handler: String): String {
        val request = Request.Builder()
                .url("http://discovery.thethingsnetwork.org:8080/announcements/handler/$handler")
                .build()

        client.newCall(request).execute().use { response ->
            val responseData = response.body()!!.string()
            try {
                val handlerData = JSONObject(responseData)
                if (handlerData.has("mqtt_address")) {
                    val broker = handlerData.getString("mqtt_address")
                    return broker
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return "none"
    }
}