package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

data class GatewayMetadata(
        @field:Json(name = "gtw_id")
        var gtwId: String?, // eui-88c255fffe6dfb04
        @field:Json(name = "gtw_trusted")
        var gtwTrusted: Boolean?,
        var timestamp: Long?, // 161373091 = uint32 is too long for Int
        @field:Json(name = "fine_timestamp")
        var fineTimestamp: Long?,
        @field:Json(name = "fine_timestamp_encrypted")
        var fineTimestampEncrypted: String?,
        var time: String?, // 2018-03-18T10:05:45.290479Z
        var antenna: Int?,
        var channel: Int?, // 2
        var rssi: Double?, // -95
        var snr: Double?, // 6.8
        @field:Json(name = "rf_chain")
        var rfChain: Int?, // 1

        // LocationMetadata
        var latitude: Double?,
        var longitude: Double?,
        var altitude: Int?,
        @field:Json(name = "location_accuracy")
        var accuracy: Int?,
        @field:Json(name = "location_source")
        var source: String?
)