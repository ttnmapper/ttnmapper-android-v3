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
 * @param gatewayId 
 * @param eui 
 */
@JsonClass(generateAdapter = true)
data class V3PacketBrokerGatewayGatewayIdentifiers (

    @Json(name = "gateway_id")
    val gatewayId: kotlin.String? = null,

    @Json(name = "eui")
    val eui: kotlin.ByteArray? = null

)

