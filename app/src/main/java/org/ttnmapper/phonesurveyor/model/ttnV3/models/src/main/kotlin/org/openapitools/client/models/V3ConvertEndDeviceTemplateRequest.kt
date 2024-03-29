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
 * @param formatId ID of the format.
 * @param `data` Data to convert.
 */
@JsonClass(generateAdapter = true)
data class V3ConvertEndDeviceTemplateRequest (

    /* ID of the format. */
    @Json(name = "format_id")
    val formatId: kotlin.String? = null,

    /* Data to convert. */
    @Json(name = "data")
    val `data`: kotlin.ByteArray? = null

)

