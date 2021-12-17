package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TtnMapperUplinkMessage(
        @Json(name = "network_id")
        var NetworkId: String? = null,

        @Json(name = "app_id")
        var AppID: String? = null,
        @Json(name = "dev_id")
        var DevID: String? = null,
        @Json(name = "dev_eui")
        var DevEui: String? = null,

        @Json(name = "time")
        var Time: Long? = null,

        @Json(name = "port")
        var FPort: Int? = null,
        @Json(name = "counter")
        var FCnt: Long? = null,

        @Json(name = "frequency")
        var Frequency: Long? = null,
        @Json(name = "modulation")
        var Modulation: String? = null,
        @Json(name = "bandwidth")
        var Bandwidth: Long? = null,
        @Json(name = "spreading_factor")
        var SpreadingFactor: Int? = null,
        @Json(name = "bit_rate")
        var Bitrate: Long? = null,
        @Json(name = "coding_rate")
        var CodingRate: String? = null,

        @Json(name = "gateways")
        var Gateways: List<TtnMapperGateway>? = null,

        @Json(name = "latitude")
        var Latitude: Double? = null,
        @Json(name = "longitude")
        var Longitude: Double? = null,
        @Json(name = "altitude")
        var Altitude: Double? = null,
        @Json(name = "accuracy_meters")
        var AccuracyMeters: Double? = null,
        @Json(name = "satellites")
        var Satellites: Int? = null,
        @Json(name = "hdop")
        var Hdop: Double? = null,
        @Json(name = "accuracy_source")
        var AccuracySource: String? = null,

        @Json(name = "experiment")
        var Experiment: String? = null,
        @Json(name = "userid")
        var UserId: String? = null,
        @Json(name = "useragent")
        var UserAgent: String? = null,
)
