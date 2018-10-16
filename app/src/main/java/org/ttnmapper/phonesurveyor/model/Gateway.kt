package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

data class Gateway(
        @field:Json(name = "gtw_id")
        var gtwId: String?, // eui-88c255fffe6dfb04
        var timestamp: Long?, // 161373091
        var time: String?, // 2018-03-18T10:05:45.290479Z
        var channel: Int?, // 2
        var rssi: Double?, // -95
        var snr: Double?, // 6.8
        @field:Json(name = "rf_chain")
        var rfChain: Int?, // 1
        var latitude: Double?, // -34.046288
        var longitude: Double?, // 18.829735
        var altitude: Double?, // 212
        @field:Json(name = "location_source")
        var locationSource: String? // registry
)