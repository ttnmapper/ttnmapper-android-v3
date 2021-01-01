package org.ttnmapper.phonesurveyor.model.ttnV3

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.format.DateTimeFormatter

class OffsetDateTimeAdapter {
    @ToJson
    fun toJson(value: java.time.OffsetDateTime): String {
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value)
    }

    @FromJson
    fun fromJson(value: String): java.time.OffsetDateTime {
        return java.time.OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

}