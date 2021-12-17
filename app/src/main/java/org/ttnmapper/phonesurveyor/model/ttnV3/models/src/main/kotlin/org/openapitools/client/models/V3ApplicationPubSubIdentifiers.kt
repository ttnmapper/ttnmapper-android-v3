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

import org.openapitools.client.models.V3ApplicationIdentifiers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param applicationIds 
 * @param pubSubId 
 */
@JsonClass(generateAdapter = true)
data class V3ApplicationPubSubIdentifiers (

    @Json(name = "application_ids")
    val applicationIds: V3ApplicationIdentifiers? = null,

    @Json(name = "pub_sub_id")
    val pubSubId: kotlin.String? = null

)

