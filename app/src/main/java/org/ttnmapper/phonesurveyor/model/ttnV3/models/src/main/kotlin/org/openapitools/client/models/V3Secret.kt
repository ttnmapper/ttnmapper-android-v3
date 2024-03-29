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
 * Secret contains a secret value. It also contains the ID of the Encryption key used to encrypt it.
 *
 * @param keyId ID of the Key used to encrypt the secret.
 * @param `value` 
 */
@JsonClass(generateAdapter = true)
data class V3Secret (

    /* ID of the Key used to encrypt the secret. */
    @Json(name = "key_id")
    val keyId: kotlin.String? = null,

    @Json(name = "value")
    val `value`: kotlin.ByteArray? = null

)

