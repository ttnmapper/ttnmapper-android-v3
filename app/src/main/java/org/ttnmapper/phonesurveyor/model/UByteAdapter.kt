package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

@ExperimentalUnsignedTypes
object UByteAdapter {
    @FromJson
    fun fromJson(string: String) = string.toUByte()

    @ToJson
    fun toJson(value: UByte) = value.toString()
}