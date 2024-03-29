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
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param rssiTarget Received signal strength (dBm).
 * @param rssiOffset Received signal strength offset (dBm).
 * @param scanTime 
 */
@JsonClass(generateAdapter = true)
data class ConcentratorConfigLBTConfiguration (

    /* Received signal strength (dBm). */
    @Json(name = "rssi_target")
    val rssiTarget: kotlin.Float? = null,

    /* Received signal strength offset (dBm). */
    @Json(name = "rssi_offset")
    val rssiOffset: kotlin.Float? = null,

    @Json(name = "scan_time")
    val scanTime: kotlin.String? = null

)

