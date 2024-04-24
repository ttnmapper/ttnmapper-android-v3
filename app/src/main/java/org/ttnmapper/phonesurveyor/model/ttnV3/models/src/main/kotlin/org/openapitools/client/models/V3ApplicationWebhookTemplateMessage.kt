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
 * @param path Path to append to the base URL. Can contain template fields, in RFC 6570 format.
 */
@JsonClass(generateAdapter = true)
data class V3ApplicationWebhookTemplateMessage (

    /* Path to append to the base URL. Can contain template fields, in RFC 6570 format. */
    @Json(name = "path")
    val path: kotlin.String? = null

)
