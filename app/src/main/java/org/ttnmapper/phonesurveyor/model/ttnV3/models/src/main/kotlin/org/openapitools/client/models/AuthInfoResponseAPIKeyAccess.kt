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

import org.openapitools.client.models.V3APIKey
import org.openapitools.client.models.V3EntityIdentifiers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param apiKey 
 * @param entityIds 
 */
@JsonClass(generateAdapter = true)
data class AuthInfoResponseAPIKeyAccess (

    @Json(name = "api_key")
    val apiKey: V3APIKey? = null,

    @Json(name = "entity_ids")
    val entityIds: V3EntityIdentifiers? = null

)

