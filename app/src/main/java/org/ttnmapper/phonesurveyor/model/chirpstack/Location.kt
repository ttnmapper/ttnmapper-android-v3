package org.ttnmapper.phonesurveyor.model.chirpstack

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Location {
    var latitude: Double? = null
    var longitude: Double? = null
    var altitude: Double? = null
    var source: String? = null
    var accuracy: Int? = null
}