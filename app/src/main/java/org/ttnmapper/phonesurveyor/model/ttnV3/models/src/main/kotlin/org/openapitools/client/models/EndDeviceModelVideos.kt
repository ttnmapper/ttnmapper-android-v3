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
 * @param main Link to main device video.
 * @param other Links to other device videos.
 */
@JsonClass(generateAdapter = true)
data class EndDeviceModelVideos (

    /* Link to main device video. */
    @Json(name = "main")
    val main: kotlin.String? = null,

    /* Links to other device videos. */
    @Json(name = "other")
    val other: kotlin.collections.List<kotlin.String>? = null

)

