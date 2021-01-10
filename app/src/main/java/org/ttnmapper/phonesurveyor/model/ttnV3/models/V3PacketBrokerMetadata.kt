/**
* The Things Stack for LoRaWAN v3 API
* No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
*
* The version of the OpenAPI document: version not set
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package org.openapitools.client.models

import org.openapitools.client.models.V3PacketBrokerRouteHop

import com.squareup.moshi.Json

/**
 * 
 * @param messageId Message identifier generated by Packet Broker Router.
 * @param forwarderNetId LoRa Alliance NetID of the Packet Broker Forwarder Member.
 * @param forwarderTenantId Tenant ID managed by the Packet Broker Forwarder Member.
 * @param forwarderId Forwarder identifier issued by the Packet Broker Forwarder Member.
 * @param homeNetworkNetId LoRa Alliance NetID of the Packet Broker Home Network Member.
 * @param homeNetworkTenantId Tenant ID managed by the Packet Broker Home Network Member. This value is empty if it cannot be determined by the Packet Broker Router.
 * @param hops Hops that the message passed. Each Packet Broker Router service appends an entry.
 */

data class V3PacketBrokerMetadata (
    /* Message identifier generated by Packet Broker Router. */
    @Json(name = "message_id")
    val messageId: kotlin.String? = null,
    /* LoRa Alliance NetID of the Packet Broker Forwarder Member. */
    @Json(name = "forwarder_net_id")
    val forwarderNetId: kotlin.String? = null,
    /* Tenant ID managed by the Packet Broker Forwarder Member. */
    @Json(name = "forwarder_tenant_id")
    val forwarderTenantId: kotlin.String? = null,
    /* Forwarder identifier issued by the Packet Broker Forwarder Member. */
    @Json(name = "forwarder_id")
    val forwarderId: kotlin.String? = null,
    /* LoRa Alliance NetID of the Packet Broker Home Network Member. */
    @Json(name = "home_network_net_id")
    val homeNetworkNetId: kotlin.String? = null,
    /* Tenant ID managed by the Packet Broker Home Network Member. This value is empty if it cannot be determined by the Packet Broker Router. */
    @Json(name = "home_network_tenant_id")
    val homeNetworkTenantId: kotlin.String? = null,
    /* Hops that the message passed. Each Packet Broker Router service appends an entry. */
    @Json(name = "hops")
    val hops: kotlin.collections.List<V3PacketBrokerRouteHop>? = null
)

