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
 * Authentication code for end devices.
 *
 * @param `value` 
 * @param validFrom 
 * @param validTo 
 */
@JsonClass(generateAdapter = true)
data class V3EndDeviceAuthenticationCode (

    @Json(name = "value")
    val `value`: kotlin.String? = null,

    @Json(name = "valid_from")
    val validFrom: java.time.OffsetDateTime? = null,

    @Json(name = "valid_to")
    val validTo: java.time.OffsetDateTime? = null

)

