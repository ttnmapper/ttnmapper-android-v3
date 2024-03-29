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

import org.openapitools.client.models.AWSIoTProviderAccessKey
import org.openapitools.client.models.AWSIoTProviderAssumeRole
import org.openapitools.client.models.AWSIoTProviderDefaultIntegration

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param region The AWS region.
 * @param accessKey 
 * @param assumeRole 
 * @param endpointAddress The endpoint address to connect to. If the endpoint address is left empty, the integration will try to discover it.
 * @param default 
 */
@JsonClass(generateAdapter = true)
data class ApplicationPubSubAWSIoTProvider (

    /* The AWS region. */
    @Json(name = "region")
    val region: kotlin.String? = null,

    @Json(name = "access_key")
    val accessKey: AWSIoTProviderAccessKey? = null,

    @Json(name = "assume_role")
    val assumeRole: AWSIoTProviderAssumeRole? = null,

    /* The endpoint address to connect to. If the endpoint address is left empty, the integration will try to discover it. */
    @Json(name = "endpoint_address")
    val endpointAddress: kotlin.String? = null,

    @Json(name = "default")
    val default: AWSIoTProviderDefaultIntegration? = null

)

