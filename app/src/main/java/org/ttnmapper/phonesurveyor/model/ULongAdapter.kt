package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

@ExperimentalUnsignedTypes
object ULongAdapter {
    @FromJson
    fun fromJson(string: String) = string.toULong()

    @ToJson
    fun toJson(value: ULong) = value.toString()
}