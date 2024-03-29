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

import org.openapitools.client.models.GatewayRadioTxConfiguration

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param enable 
 * @param chipType 
 * @param frequency 
 * @param rssiOffset 
 * @param txConfiguration 
 */
@JsonClass(generateAdapter = true)
data class V3GatewayRadio (

    @Json(name = "enable")
    val enable: kotlin.Boolean? = null,

    @Json(name = "chip_type")
    val chipType: kotlin.String? = null,

    @Json(name = "frequency")
    val frequency: kotlin.String? = null,

    @Json(name = "rssi_offset")
    val rssiOffset: kotlin.Float? = null,

    @Json(name = "tx_configuration")
    val txConfiguration: GatewayRadioTxConfiguration? = null

)

