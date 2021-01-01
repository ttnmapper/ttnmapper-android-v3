package org.ttnmapper.phonesurveyor.aggregates

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONException
import org.json.JSONObject
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.model.TtnMapperUplinkMessage
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import java.io.IOException
import java.lang.NullPointerException


object NetworkAggregate {
    private val TAG = NetworkAggregate::class.java.getName()

    val MEDIA_TYPE_JSON = "application/json".toMediaTypeOrNull()

    val client = OkHttpClient()

    val context = AppAggregate.mainActivity

    fun exchangeTtnCodeForToken(code: String) {
        val request = Request.Builder()
                .url("https://ttnmapper.org/authed/getTokens.php?code=" + code)
                .build()

        client.newCall(request).execute().use { response ->
            val body = response.body
            if (body != null) {
                Log.e(TAG, body.string())
            }
        }
    }

    fun postPacket(url: String, packet: TtnMapperUplinkMessage) {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val jsonAdapter = moshi.adapter<TtnMapperUplinkMessage>(TtnMapperUplinkMessage::class.java)
        val postBody = jsonAdapter.toJson(packet)

        Log.e(TAG, postBody)

        val request = Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_JSON, postBody))
                .build()

        try {
            client.newCall(request).execute().use { response ->
                val body = response.body
                if (body != null) {
                    Log.e(TAG, body.string())
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "Timeout posting to server " + url)
        }
    }

    fun postToTTNMapper(packet: TtnMapperUplinkMessage) {
        postPacket(SurveyorApp.instance.getString(R.string.TTN_MAPPER_UPLOAD_API), packet)
    }

    fun postToCustomServer(packet: TtnMapperUplinkMessage, serverUri: String) {
        postPacket(serverUri, packet)
    }

    fun getMqttUriFromHandler(handler: String): String {
        val request = Request.Builder()
                .url("http://discovery.thethingsnetwork.org:8080/announcements/handler/$handler")
                .build()

        client.newCall(request).execute().use { response ->
            try {
                val responseData = response.body!!.string()
                val handlerData = JSONObject(responseData)
                if (handlerData.has("mqtt_address")) {
                    val broker = handlerData.getString("mqtt_address")
                    return broker
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        }
        return "none"
    }

    fun getGatewayFromTtnMapper(gateway: String): JSONObject? {
        val request = Request.Builder()
                .url("https://ttnmapper.org/appapi/v3/gwdetails.php?gtwId=$gateway")
                .build()

        client.newCall(request).execute().use { response ->
            try {
                val responseData = response.body!!.string()
                val responseJson = JSONObject(responseData)
                val gatewayData = responseJson.getJSONObject("details")

                return gatewayData
            } catch (e: JSONException) {
                e.printStackTrace()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        }
        return null
    }
}