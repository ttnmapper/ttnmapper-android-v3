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
 * @param arn 
 * @param externalId 
 * @param sessionDuration 
 */
@JsonClass(generateAdapter = true)
data class AWSIoTProviderAssumeRole (

    @Json(name = "arn")
    val arn: kotlin.String? = null,

    @Json(name = "external_id")
    val externalId: kotlin.String? = null,

    @Json(name = "session_duration")
    val sessionDuration: kotlin.String? = null

)

