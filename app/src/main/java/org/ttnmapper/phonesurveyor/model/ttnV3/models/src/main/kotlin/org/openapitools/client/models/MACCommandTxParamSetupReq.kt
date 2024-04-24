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

import org.openapitools.client.models.V3DeviceEIRP

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param maxEirpIndex 
 * @param uplinkDwellTime 
 * @param downlinkDwellTime 
 */
@JsonClass(generateAdapter = true)
data class MACCommandTxParamSetupReq (

    @Json(name = "max_eirp_index")
    val maxEirpIndex: V3DeviceEIRP? = V3DeviceEIRP._8,

    @Json(name = "uplink_dwell_time")
    val uplinkDwellTime: kotlin.Boolean? = null,

    @Json(name = "downlink_dwell_time")
    val downlinkDwellTime: kotlin.Boolean? = null

)
