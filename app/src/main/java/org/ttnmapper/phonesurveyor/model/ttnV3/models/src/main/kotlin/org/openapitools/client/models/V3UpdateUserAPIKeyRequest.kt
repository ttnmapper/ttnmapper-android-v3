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

import org.openapitools.client.models.ProtobufFieldMask
import org.openapitools.client.models.V3APIKey
import org.openapitools.client.models.V3UserIdentifiers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param userIds 
 * @param apiKey 
 * @param fieldMask 
 */
@JsonClass(generateAdapter = true)
data class V3UpdateUserAPIKeyRequest (

    @Json(name = "user_ids")
    val userIds: V3UserIdentifiers? = null,

    @Json(name = "api_key")
    val apiKey: V3APIKey? = null,

    @Json(name = "field_mask")
    val fieldMask: ProtobufFieldMask? = null

)

