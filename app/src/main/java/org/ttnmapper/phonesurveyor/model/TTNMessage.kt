package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

/*
{
   "app_id":"jpm_testing",
   "dev_id":"things_uno_jpm",
   "hardware_serial":"0004A30B001C684F",
   "port":1,
   "counter":302,
   "payload_raw":"AA==",
   "metadata":{
      "time":"2020-12-23T06:53:23.023065278Z",
      "frequency":867.7,
      "modulation":"LORA",
      "data_rate":"SF7BW125",
      "airtime":46336000,
      "coding_rate":"4/5",
      "gateways":[
         {
            "gtw_id":"eui-3133303748005c00",
            "timestamp":315768413,
            "time":"2020-12-23T06:53:22.200758Z",
            "channel":6,
            "rssi":-86,
            "snr":9.25,
            "rf_chain":0
         }
      ],
      "latitude":-33.936417,
      "longitude":18.871248,
      "location_source":"registry"
   }
}
 */

data class TTNMessage(
        @Json(name = "app_id")
        var appId: String?, // jpm_sodaq_one

        @Json(name = "dev_id")
        var devId: String?, // sodaq-one-v3-box

        @Json(name = "hardware_serial")
        var hardwareSerial: String?, // 0004A30B00200CA5

        @Json(name = "port")
        var fPort: Int?, // 1

        @Json(name = "counter")
        var fCnt: Int?, // 347

        @Json(name = "confirmed")
        var confirmed: Boolean?,

        @Json(name = "is_retry")
        var isRetry: Boolean?,

        @Json(name = "payload_raw")
        var payloadRaw: String?, // DDquWngmE6G06xnqNwuaAAwABQUE

        @Json(name = "payload_fields")
        var payloadFields: PayloadFields?,

        @Json(name = "metadata")
        var metadata: Metadata?,

        @Json(name = "attributes")
        var attributes: Map<String, String>?,

        // Custom attributes for ttn mapper
        @Json(name = "max_level")
        var maxLevel: Double?, // -120dBm

        @Json(name = "phone_lat")
        var phoneLat: Double?, // -34.0484124

        @Json(name = "phone_lon")
        var phoneLon: Double?, // 18.8214014

        @Json(name = "phone_alt")
        var phoneAlt: Double?, // 184.9958825503345

        @Json(name = "phone_loc_acc")
        var phoneLocAcc: Double?, // 10

        @Json(name = "phone_loc_provider")
        var phoneLocProvider: String?, // fused

        @Json(name = "phone_loc_time")
        var phoneLocTime: String?, // 2018-03-18T10:05:44Z

        @Json(name = "phone_time")
        var phoneTime: String?, // 2018-03-18T10:05:44Z

        @Json(name = "user_agent")
        var userAgent: String?, // Android7.0 App30:2018.03.04

        @Json(name = "iid")
        var iid: String?, //some random number

        @Json(name = "experiment")
        var experiment: String? // experiment name
)