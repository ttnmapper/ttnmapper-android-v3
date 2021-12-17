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
 * Identifies a Network Server.
 *
 * @param netId LoRa Alliance NetID.
 * @param tenantId Optional tenant identifier for multi-tenant deployments.
 * @param clusterId Cluster identifier of the Network Server.
 */
@JsonClass(generateAdapter = true)
data class V3NetworkIdentifiers (

    /* LoRa Alliance NetID. */
    @Json(name = "net_id")
    val netId: kotlin.ByteArray? = null,

    /* Optional tenant identifier for multi-tenant deployments. */
    @Json(name = "tenant_id")
    val tenantId: kotlin.String? = null,

    /* Cluster identifier of the Network Server. */
    @Json(name = "cluster_id")
    val clusterId: kotlin.String? = null

)

