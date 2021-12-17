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

import org.openapitools.client.models.V3DecodedMessagePayload
import org.openapitools.client.models.V3EncodedMessagePayload

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param description 
 * @param input 
 * @param output 
 */
@JsonClass(generateAdapter = true)
data class V3MessagePayloadDecoderExample (

    @Json(name = "description")
    val description: kotlin.String? = null,

    @Json(name = "input")
    val input: V3EncodedMessagePayload? = null,

    @Json(name = "output")
    val output: V3DecodedMessagePayload? = null

)

