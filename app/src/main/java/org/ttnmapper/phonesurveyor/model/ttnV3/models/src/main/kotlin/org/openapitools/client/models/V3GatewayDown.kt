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

import org.openapitools.client.models.V3DownlinkMessage

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * GatewayDown contains downlink messages for the gateway.
 *
 * @param downlinkMessage 
 */
@JsonClass(generateAdapter = true)
data class V3GatewayDown (

    @Json(name = "downlink_message")
    val downlinkMessage: V3DownlinkMessage? = null

)

