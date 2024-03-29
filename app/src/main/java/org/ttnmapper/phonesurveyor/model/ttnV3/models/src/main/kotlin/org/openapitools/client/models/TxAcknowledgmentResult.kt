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
 * Values: sUCCESS,uNKNOWNERROR,tOOLATE,tOOEARLY,cOLLISIONPACKET,cOLLISIONBEACON,tXFREQ,tXPOWER,gPSUNLOCKED
 */

enum class TxAcknowledgmentResult(val value: kotlin.String) {

    @Json(name = "SUCCESS")
    sUCCESS("SUCCESS"),

    @Json(name = "UNKNOWN_ERROR")
    uNKNOWNERROR("UNKNOWN_ERROR"),

    @Json(name = "TOO_LATE")
    tOOLATE("TOO_LATE"),

    @Json(name = "TOO_EARLY")
    tOOEARLY("TOO_EARLY"),

    @Json(name = "COLLISION_PACKET")
    cOLLISIONPACKET("COLLISION_PACKET"),

    @Json(name = "COLLISION_BEACON")
    cOLLISIONBEACON("COLLISION_BEACON"),

    @Json(name = "TX_FREQ")
    tXFREQ("TX_FREQ"),

    @Json(name = "TX_POWER")
    tXPOWER("TX_POWER"),

    @Json(name = "GPS_UNLOCKED")
    gPSUNLOCKED("GPS_UNLOCKED");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is TxAcknowledgmentResult) "$data" else null

        /**
         * Returns a valid [TxAcknowledgmentResult] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): TxAcknowledgmentResult? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

