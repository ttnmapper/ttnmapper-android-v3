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
 * @param joinEui 
 * @param devEui 
 * @param devNonce 
 */
@JsonClass(generateAdapter = true)
data class V3JoinRequestPayload (

    @Json(name = "join_eui")
    val joinEui: kotlin.ByteArray? = null,

    @Json(name = "dev_eui")
    val devEui: kotlin.ByteArray? = null,

    @Json(name = "dev_nonce")
    val devNonce: kotlin.ByteArray? = null

)

