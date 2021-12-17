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
 * Values: rFU0,rESET,lINKCHECK,lINKADR,dUTYCYCLE,rXPARAMSETUP,dEVSTATUS,nEWCHANNEL,rXTIMINGSETUP,tXPARAMSETUP,dLCHANNEL,rEKEY,aDRPARAMSETUP,dEVICETIME,fORCEREJOIN,rEJOINPARAMSETUP,pINGSLOTINFO,pINGSLOTCHANNEL,bEACONTIMING,bEACONFREQ,dEVICEMODE
 */

enum class V3MACCommandIdentifier(val value: kotlin.String) {

    @Json(name = "CID_RFU_0")
    rFU0("CID_RFU_0"),

    @Json(name = "CID_RESET")
    rESET("CID_RESET"),

    @Json(name = "CID_LINK_CHECK")
    lINKCHECK("CID_LINK_CHECK"),

    @Json(name = "CID_LINK_ADR")
    lINKADR("CID_LINK_ADR"),

    @Json(name = "CID_DUTY_CYCLE")
    dUTYCYCLE("CID_DUTY_CYCLE"),

    @Json(name = "CID_RX_PARAM_SETUP")
    rXPARAMSETUP("CID_RX_PARAM_SETUP"),

    @Json(name = "CID_DEV_STATUS")
    dEVSTATUS("CID_DEV_STATUS"),

    @Json(name = "CID_NEW_CHANNEL")
    nEWCHANNEL("CID_NEW_CHANNEL"),

    @Json(name = "CID_RX_TIMING_SETUP")
    rXTIMINGSETUP("CID_RX_TIMING_SETUP"),

    @Json(name = "CID_TX_PARAM_SETUP")
    tXPARAMSETUP("CID_TX_PARAM_SETUP"),

    @Json(name = "CID_DL_CHANNEL")
    dLCHANNEL("CID_DL_CHANNEL"),

    @Json(name = "CID_REKEY")
    rEKEY("CID_REKEY"),

    @Json(name = "CID_ADR_PARAM_SETUP")
    aDRPARAMSETUP("CID_ADR_PARAM_SETUP"),

    @Json(name = "CID_DEVICE_TIME")
    dEVICETIME("CID_DEVICE_TIME"),

    @Json(name = "CID_FORCE_REJOIN")
    fORCEREJOIN("CID_FORCE_REJOIN"),

    @Json(name = "CID_REJOIN_PARAM_SETUP")
    rEJOINPARAMSETUP("CID_REJOIN_PARAM_SETUP"),

    @Json(name = "CID_PING_SLOT_INFO")
    pINGSLOTINFO("CID_PING_SLOT_INFO"),

    @Json(name = "CID_PING_SLOT_CHANNEL")
    pINGSLOTCHANNEL("CID_PING_SLOT_CHANNEL"),

    @Json(name = "CID_BEACON_TIMING")
    bEACONTIMING("CID_BEACON_TIMING"),

    @Json(name = "CID_BEACON_FREQ")
    bEACONFREQ("CID_BEACON_FREQ"),

    @Json(name = "CID_DEVICE_MODE")
    dEVICEMODE("CID_DEVICE_MODE");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is V3MACCommandIdentifier) "$data" else null

        /**
         * Returns a valid [V3MACCommandIdentifier] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): V3MACCommandIdentifier? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

