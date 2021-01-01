package org.ttnmapper.phonesurveyor.model.ttnV2

import com.squareup.moshi.Json

data class Metadata(
        var time: String?, // 2018-03-18T10:05:45.391032906Z
        var frequency: Double?, // 868.5
        var modulation: String?, // LORA
        @Json(name = "data_rate")
        var dataRate: String?, // SF7BW125
        @Json(name = "bit_rate")
        var bitrate: Int?,
        var airtime: Int?, // 77056000
        @Json(name = "coding_rate")
        var codingRate: String?, // 4/5
        var gateways: List<GatewayMetadata?>?,

        // LocationMetadata
        var latitude: Double?,
        var longitude: Double?,
        var altitude: Int?,
        @Json(name = "location_accuracy")
        var accuracy: Int?,
        @Json(name = "location_source")
        var source: String?
)