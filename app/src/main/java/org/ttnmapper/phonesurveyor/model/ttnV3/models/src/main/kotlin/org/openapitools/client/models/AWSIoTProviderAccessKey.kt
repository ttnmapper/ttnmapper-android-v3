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
 * @param accessKeyId 
 * @param secretAccessKey 
 * @param sessionToken 
 */
@JsonClass(generateAdapter = true)
data class AWSIoTProviderAccessKey (

    @Json(name = "access_key_id")
    val accessKeyId: kotlin.String? = null,

    @Json(name = "secret_access_key")
    val secretAccessKey: kotlin.String? = null,

    @Json(name = "session_token")
    val sessionToken: kotlin.String? = null

)

