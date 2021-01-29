package org.ttnmapper.phonesurveyor.model.ttnV2

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PayloadFields(
        var alt: Int?, // 154
        var batvolt: Int?, // 120
        var boardtemp: Int?, // 38
        var course: Int?, // 5
        var epoch: Int?, // 1521367564
        var fix: Int?, // 4
        var lat: Double?, // -34.0483821
        var long: Double?, // 18.8213785
        var numsat: Int?, // 5
        var speed: Int? // 12
)