/**
 * The Things Stack for LoRaWAN v3 API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: version not set
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models


import com.squareup.moshi.Json

/**
 * 
 *
 * Values: rFU0,_1,rFU2,rFU3,rFU4,rFU5,rFU6,rFU7,rFU8,rFU9,rFU10,rFU11,rFU12,rFU13,rFU14,rFU15
 */

enum class V3Minor(val value: kotlin.String) {

    @Json(name = "MINOR_RFU_0")
    rFU0("MINOR_RFU_0"),

    @Json(name = "MINOR_1")
    _1("MINOR_1"),

    @Json(name = "MINOR_RFU_2")
    rFU2("MINOR_RFU_2"),

    @Json(name = "MINOR_RFU_3")
    rFU3("MINOR_RFU_3"),

    @Json(name = "MINOR_RFU_4")
    rFU4("MINOR_RFU_4"),

    @Json(name = "MINOR_RFU_5")
    rFU5("MINOR_RFU_5"),

    @Json(name = "MINOR_RFU_6")
    rFU6("MINOR_RFU_6"),

    @Json(name = "MINOR_RFU_7")
    rFU7("MINOR_RFU_7"),

    @Json(name = "MINOR_RFU_8")
    rFU8("MINOR_RFU_8"),

    @Json(name = "MINOR_RFU_9")
    rFU9("MINOR_RFU_9"),

    @Json(name = "MINOR_RFU_10")
    rFU10("MINOR_RFU_10"),

    @Json(name = "MINOR_RFU_11")
    rFU11("MINOR_RFU_11"),

    @Json(name = "MINOR_RFU_12")
    rFU12("MINOR_RFU_12"),

    @Json(name = "MINOR_RFU_13")
    rFU13("MINOR_RFU_13"),

    @Json(name = "MINOR_RFU_14")
    rFU14("MINOR_RFU_14"),

    @Json(name = "MINOR_RFU_15")
    rFU15("MINOR_RFU_15");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is V3Minor) "$data" else null

        /**
         * Returns a valid [V3Minor] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): V3Minor? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}
