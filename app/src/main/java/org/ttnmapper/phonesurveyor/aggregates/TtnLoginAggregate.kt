package org.ttnmapper.phonesurveyor.aggregates

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONException
import org.json.JSONObject
import org.ttnmapper.phonesurveyor.model.ttnV2.Device
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnApplication
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnDevices
import java.io.IOException

object TtnLoginAggregate {
    private val TAG = TtnLoginAggregate::class.java.getName()

    var secretState: String? = null
    var code: String? = null
    var accessToken: String? = null

    var ttnApplications: List<TtnApplication>? = null
    var selectedApplication: TtnApplication? = null
    var selectedDevice: Device? = null

    val redirectURI = "https://ttnmapper.org/authed"
    val authorizationUrl = "https://account.thethingsnetwork.org/users/authorize\n" +
            "?response_type=code\n" +
            "&client_id=ttn-mapper\n" +
            "&redirect_uri=" + redirectURI


    fun exchangeCodeForToken(): Boolean {
        val url = "https://ttnmapper.org/appapi/getTtnOauthTokens.php?code=" + code + "&state=" + secretState
        // Do http call and return string
        val request = Request.Builder()
                .url(url)
                .build()

//        Log.e(TAG, url)
        NetworkAggregate.client.newCall(request).execute().use { response ->

            try {
                val responseString = response.body!!.string()
//            Log.e(TAG, "Token received: " + responseString)
                accessToken = JSONObject(responseString).getString("access_token")
                return true
            } catch (e: JSONException) {
                return false
            }
        }
    }

    fun getListOfApplications(): Boolean {
        val url = "https://account.thethingsnetwork.org/applications?access_token=" + accessToken

        val request = Request.Builder()
                .addHeader("Accept", "application/json")
                .url(url)
                .build()

        try {
            NetworkAggregate.client.newCall(request).execute().use { response ->
                /*
                [
                    {"id":"sodaq_testing",
                     "name":"van alles",
                     "euis":["70B3D57EF0000187"],
                     "created":"2016-11-24T11:09:51.799Z",
                     "rights":["settings","devices","collaborators"],
                     "collaborators":[{"username":"jpmeijers","email":"ttn@jpmeijers.com","rights":["settings","devices","collaborators"]},{"username":"laurens","email":"laurens@thethingsnetwork.org","rights":["settings","devices"]},{"username":"paulb","email":"paulb@dds.nl","rights":["settings","delete","collaborators","devices"]}],
                     "access_keys":[{"name":"default key","rights":["messages:up:r","messages:down:w"],"key":"ttn-account-v2.r4sNAmTRbF-QRRbrS2l6sT-u9U00RtaDo307UmnlGB4"},
                                    {"name":"sesame","rights":["messages:up:r","messages:down:w","settings","devices"],"key":"ttn-account-v2.xp0e7CJgvdsfDjY2U2IjL-CDT4GeFwQqTPIPHylfGIs"}
                                   ]
                    },
                    {"id":"jpm_mapping_nodes","name":"joris binary format mapping nodes","euis":["70B3D57EF0001D09"],"created":"2016-12-23T15:13:33.199Z",
                     "rights":["settings","delete","collaborators","devices"],
                     "collaborators":[{"username":"jpmeijers","email":"ttn@jpmeijers.com","rights":["settings","delete","collaborators","devices"]}],
                     "access_keys":[{"name":"default key","key":"ttn-account-v2.UsPtrxlB7BFjaZoTY8HKPOQxSv8ax3tBnih7hJEZInA","_id":"585d3f1def783e0032f3a904","rights":["messages:up:r","messages:down:w"]}]},
                    {"id":"jpm_testing","name":"general testing nodes","euis":["70B3D57EF0003304"],"created":"2017-01-17T14:47:09.740Z","rights":["settings","delete","collaborators","devices"],"collaborators":[{"username":"jpmeijers","email":"ttn@jpmeijers.com","rights":["settings","delete","collaborators","devices"]}],"access_keys":[{"name":"default key","key":"ttn-account-v2.76hcK6z-BE2aZwjjB9AcotZq2p9JDtN-MmMGB2jZe1w","_id":"587e2e6dbc438d00317f1544","rights":["messages:up:r","messages:down:w"]}]}
                ]
                */
                val responseString = response.body?.string()
//            Log.e(TAG, responseString)

                val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                val listType = Types.newParameterizedType(List::class.java, TtnApplication::class.java)
                val jsonAdapter = moshi.adapter<List<TtnApplication>>(listType)
                try {
                    ttnApplications = jsonAdapter.fromJson(responseString!!)
                    return true
                } catch (e: Exception) {
                    Log.e(TAG, e.message!!)
                    return false
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, e.message!!)
            return false
        }

    }

    fun getHandlers(): Boolean {
        val url = "http://discovery.thethingsnetwork.org:8080/announcements/handler"

        val request = Request.Builder()
                .addHeader("Accept", "application/json")
                .url(url)
                .build()

        try {
        NetworkAggregate.client.newCall(request).execute().use { response ->

            val responseString = response.body!!.string()
//            Log.e(TAG, responseString)

            try {
                val resultData = JSONObject(responseString)
                val handlers = resultData.getJSONArray("services")

                for (i in 0 until handlers.length()) {
                    val currentHandler = handlers.getJSONObject(i)
                    val handlerID = currentHandler.getString("id")
                    Log.d(TAG, "Handler: $handlerID")

                    var mqttAddress: String? = null
                    if (currentHandler.has("mqtt_address")) {
                        mqttAddress = currentHandler.getString("mqtt_address")
                    } else {
                        Log.d(TAG, "Handler=$handlerID does not have a MQTT address")
                    }

                    var netAddress: String? = null
                    if (currentHandler.has("net_address")) {
                        netAddress = currentHandler.getString("net_address")
                    } else {
                        Log.d(TAG, "Handler=$handlerID does not have a Net address")
                    }

                    var apiAddress: String? = null
                    if (currentHandler.has("api_address")) {
                        apiAddress = currentHandler.getString("api_address")
                    } else {
                        Log.d(TAG, "Handler=$handlerID does not have an API address")
                    }

                    if (currentHandler.has("metadata")) {
                        val apps = currentHandler.getJSONArray("metadata")

                        for (j in 0 until apps.length()) {
                            val appID = apps.getJSONObject(j).getString("app_id")

                            ttnApplications?.forEach {
                                if (it.id.equals(appID)) {
                                    it.handlerId = handlerID
                                    it.mqttAddress = mqttAddress
                                    it.netAddress = netAddress
                                    it.apiAddress = apiAddress
                                }
                            }
                        }
                    }
                }

                return true
            } catch (e: Exception) {
                return false
            }
        }
        } catch (e: Exception) {
            Log.e(TAG, e.message!!)
            return false
        }
    }

    fun getListOfDevices(): Boolean {
        var restrictedToken = ""

        //get restricted token
        val body = ("{\"scope\": [ \"apps:" + selectedApplication!!.id + "\" ]}").toRequestBody(
            NetworkAggregate.MEDIA_TYPE_JSON
        )

        val request = Request.Builder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .url("https://account.thethingsnetwork.org/users/restrict-token?access_token=" + accessToken)
                .post(body)
                .build()

        NetworkAggregate.client.newCall(request).execute().use { response ->

            val responseString = response.body!!.string()
//            Log.e(TAG, responseString)
            try {
                restrictedToken = JSONObject(responseString).getString("access_token")
            } catch (e: Exception) {
                return false
            }
        }


        val devicesUrl = selectedApplication!!.apiAddress + "/applications/" + selectedApplication!!.id + "/devices"
//        Log.d(TAG, "Fetching $devicesUrl")

        val requestDevices = Request.Builder()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer $restrictedToken")
                .url(devicesUrl)
                .build()

        try {
            NetworkAggregate.client.newCall(requestDevices).execute().use { response ->
                val responseString = response.body?.string()
    //            Log.e(TAG, responseString)
                /* {"devices":
                       [
                         {"app_id":"jpm_mapping_nodes",
                          "dev_id":"pink_kosblik",
                          "lorawan_device":
                          {
                            "app_eui":"70B3D57EF0001D09",
                            "dev_eui":"00CF85F175DD45CD",
                            "app_id":"jpm_mapping_nodes",
                            "dev_id":"pink_kosblik",
                            "dev_addr":"260110CC",
                            "nwk_s_key":"A998A0E5645663A9AAF58B58B36A9BA1",
                            "app_s_key":"41FA07B9FC5E6367DCDB0ACBC0155776",
                            "app_key":""
                          }
                         },
                         {"app_id":"jpm_mapping_nodes","dev_id":"rfm_teensy3","lorawan_device":{"app_eui":"70B3D57EF0001D09","dev_eui":"00CC186F83CD4492","app_id":"jpm_mapping_nodes","dev_id":"rfm_teensy3","dev_addr":"26011256","nwk_s_key":"F227888F5F74AA2DAC372BA8D53D20FC","app_s_key":"0AF44FB198F7B3DA1204F6A2EC2080D7","app_key":""}},
                         {"app_id":"jpm_mapping_nodes","dev_id":"thingsuno_gpsshield","lorawan_device":{"app_eui":"70B3D57EF0001D09","dev_eui":"006259C6A72A76AA","app_id":"jpm_mapping_nodes","dev_id":"thingsuno_gpsshield","dev_addr":"260115A6","nwk_s_key":"32551FF1817DDDD7BD2FF4307F51D408","app_s_key":"18DAA70AE22D0B9B100140E2766EBE7D","app_key":""}},
                         {"app_id":"jpm_mapping_nodes","dev_id":"tnt_sodaq_one","lorawan_device":{"app_eui":"70B3D57EF0001D09","dev_eui":"007DBBB13067B880","app_id":"jpm_mapping_nodes","dev_id":"tnt_sodaq_one","dev_addr":"260112B2","nwk_s_key":"ADDF9C3BDA818AAD7922F3A2C38FA3ED","app_s_key":"20B8EE18721453C6D04F564D5329FC94","app_key":""}}
                       ]
                       }
                    */
                val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                val jsonAdapter = moshi.adapter(TtnDevices::class.java)
                return try {
                    Log.e(TAG, responseString!!)
                    val devices = jsonAdapter.fromJson(responseString)
                    //                Log.e(TAG, devices.toString())
                    selectedApplication?.devices = devices?.devices
                    true
                } catch (e: Exception) {
                    false
                }
            }

        } catch (e: IOException) {
            Log.e(TAG, "Timeout getting list of devices")
            return false
        }
    }
}