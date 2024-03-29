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
 * The connection information of an MQTT frontend.
 *
 * @param publicAddress The public listen address of the frontend.
 * @param publicTlsAddress The public listen address of the TLS frontend.
 * @param username The username to be used for authentication.
 */
@JsonClass(generateAdapter = true)
data class V3MQTTConnectionInfo (

    /* The public listen address of the frontend. */
    @Json(name = "public_address")
    val publicAddress: kotlin.String? = null,

    /* The public listen address of the TLS frontend. */
    @Json(name = "public_tls_address")
    val publicTlsAddress: kotlin.String? = null,

    /* The username to be used for authentication. */
    @Json(name = "username")
    val username: kotlin.String? = null

)

