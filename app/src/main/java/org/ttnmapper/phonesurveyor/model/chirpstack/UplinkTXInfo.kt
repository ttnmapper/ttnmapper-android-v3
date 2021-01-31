package org.ttnmapper.phonesurveyor.model.chirpstack

import com.squareup.moshi.JsonClass

// "txInfo":{"frequency":868100000,"dr":5}
@JsonClass(generateAdapter = true)
class UplinkTXInfo {
    var frequency: Int? = null
    var dr: Int? = null
}