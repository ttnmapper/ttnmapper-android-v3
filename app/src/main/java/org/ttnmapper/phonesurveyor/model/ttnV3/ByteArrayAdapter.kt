package org.ttnmapper.phonesurveyor.model.ttnV3

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.format.DateTimeFormatter

class ByteArrayAdapter {
    @ToJson
    fun toJson(value: ByteArray): String {
        return android.util.Base64.encodeToString(value, android.util.Base64.DEFAULT)
    }

    @FromJson
    fun fromJson(value: String): ByteArray {
        return android.util.Base64.decode(value, android.util.Base64.DEFAULT)
    }

}