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

import org.openapitools.client.models.V3KeyEnvelope

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param fNwkSIntKey 
 * @param sNwkSIntKey 
 * @param nwkSEncKey 
 */
@JsonClass(generateAdapter = true)
data class V3NwkSKeysResponse (

    @Json(name = "f_nwk_s_int_key")
    val fNwkSIntKey: V3KeyEnvelope? = null,

    @Json(name = "s_nwk_s_int_key")
    val sNwkSIntKey: V3KeyEnvelope? = null,

    @Json(name = "nwk_s_enc_key")
    val nwkSEncKey: V3KeyEnvelope? = null

)
