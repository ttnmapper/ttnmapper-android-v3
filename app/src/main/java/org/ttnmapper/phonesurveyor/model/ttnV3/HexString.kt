package org.ttnmapper.phonesurveyor.model.ttnV3

import android.util.Base64
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object TtsByteArrayAdapter {
    @ToJson
    fun toJson(data: ByteArray): String {
        return data.joinToString(separator = "") { "%02X".format(it) }.padStart(16, '0')
    }

    @FromJson
    fun fromJson(data: String): ByteArray {
        print(data)
        // Check if base64
        // ^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$
        val b64Regex = """^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$""".toRegex()
        val hexRegex = """^[0-9a-fA-F]+${'$'}""".toRegex()
        when {
            // Is HEX
            hexRegex.matches(data) && data.length % 2 == 0 -> {
//                println(" Is HEX")
                return data.chunked(2)
                    .map { it.toInt(16).toByte() }
                    .toByteArray()
            }

            // Is base64
            b64Regex.matches(data) -> {
//                println(" Is base64")
                return Base64.decode(data, Base64.DEFAULT)
            }

            // Or we do not know
            else -> {
//                println(" Is unknown")
                return ByteArray(0)
            }
        }
    }
}
