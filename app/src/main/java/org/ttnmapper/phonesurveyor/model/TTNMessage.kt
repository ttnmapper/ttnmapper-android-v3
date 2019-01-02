package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

data class TTNMessage(
        @field:Json(name = "app_id")
        var appId: String?, // jpm_sodaq_one

        @field:Json(name = "dev_id")
        var devId: String?, // sodaq-one-v3-box

        @field:Json(name = "hardware_serial")
        var hardwareSerial: String?, // 0004A30B00200CA5

        @field:Json(name = "port")
        var fPort: Int?, // 1

        @field:Json(name = "counter")
        var fCnt: Int?, // 347

        @field:Json(name = "confirmed")
        var confirmed: Boolean?,

        @field:Json(name = "is_retry")
        var isRetry: Boolean?,

        @field:Json(name = "payload_raw")
        var payloadRaw: String?, // DDquWngmE6G06xnqNwuaAAwABQUE

        @field:Json(name = "payload_fields")
        var payloadFields: PayloadFields?,

        @field:Json(name = "metadata")
        var metadata: Metadata?,

        @field:Json(name = "attributes")
        var attributes: Map<String, String>,

        @field:Json(name = "mqtt_topic")
        var mqttTopic: String?, // jpm_sodaq_one/devices/sodaq-one-v3-box/up

        @field:Json(name = "phone_lat")
        var phoneLat: Double?, // -34.0484124

        @field:Json(name = "phone_lon")
        var phoneLon: Double?, // 18.8214014

        @field:Json(name = "phone_alt")
        var phoneAlt: Double?, // 184.9958825503345

        @field:Json(name = "phone_loc_acc")
        var phoneLocAcc: Double?, // 10

        @field:Json(name = "phone_loc_provider")
        var phoneLocProvider: String?, // fused

        @field:Json(name = "phone_time")
        var phoneTime: String?, // 2018-03-18T10:05:44Z

        @field:Json(name = "user_agent")
        var userAgent: String?, // Android7.0 App30:2018.03.04

        @field:Json(name = "iid")
        var iid: String?, //some random number

        @field:Json(name = "experiment")
        var experiment: String? // experiment name
)