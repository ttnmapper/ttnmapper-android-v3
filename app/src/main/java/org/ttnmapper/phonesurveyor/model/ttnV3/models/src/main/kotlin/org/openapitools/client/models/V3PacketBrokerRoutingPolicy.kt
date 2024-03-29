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

import org.openapitools.client.models.V3PacketBrokerNetworkIdentifier
import org.openapitools.client.models.V3PacketBrokerRoutingPolicyDownlink
import org.openapitools.client.models.V3PacketBrokerRoutingPolicyUplink

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param forwarderId 
 * @param homeNetworkId 
 * @param updatedAt Timestamp when the policy got last updated.
 * @param uplink 
 * @param downlink 
 */
@JsonClass(generateAdapter = true)
data class V3PacketBrokerRoutingPolicy (

    @Json(name = "forwarder_id")
    val forwarderId: V3PacketBrokerNetworkIdentifier? = null,

    @Json(name = "home_network_id")
    val homeNetworkId: V3PacketBrokerNetworkIdentifier? = null,

    /* Timestamp when the policy got last updated. */
    @Json(name = "updated_at")
    val updatedAt: java.time.OffsetDateTime? = null,

    @Json(name = "uplink")
    val uplink: V3PacketBrokerRoutingPolicyUplink? = null,

    @Json(name = "downlink")
    val downlink: V3PacketBrokerRoutingPolicyDownlink? = null

)

