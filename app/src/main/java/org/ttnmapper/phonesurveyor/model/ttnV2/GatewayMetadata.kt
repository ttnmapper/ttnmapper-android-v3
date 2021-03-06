package org.ttnmapper.phonesurveyor.model.ttnV2

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GatewayMetadata(
        @Json(name = "gtw_id")
        var gtwId: String?, // eui-88c255fffe6dfb04
        @Json(name = "gtw_trusted")
        var gtwTrusted: Boolean?,
        var timestamp: Long?, // 161373091 = uint32 is too long for Int
        @Json(name = "fine_timestamp")
        var fineTimestamp: Long?,
        @Json(name = "fine_timestamp_encrypted")
        var fineTimestampEncrypted: String?,
        var time: String?, // 2018-03-18T10:05:45.290479Z
        var antenna: Int?,
        var channel: Int?, // 2
        var rssi: Double?, // -95
        var snr: Double?, // 6.8
        @Json(name = "rf_chain")
        var rfChain: Int?, // 1

        // LocationMetadata
        var latitude: Double?,
        var longitude: Double?,
        var altitude: Int?,
        @Json(name = "location_accuracy")
        var accuracy: Int?,
        @Json(name = "location_source")
        var source: String?
)