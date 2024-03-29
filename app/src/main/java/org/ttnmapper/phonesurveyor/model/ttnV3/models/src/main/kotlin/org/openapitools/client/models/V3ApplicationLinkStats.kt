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
 * Link stats as monitored by the Application Server.
 *
 * @param linkedAt 
 * @param networkServerAddress 
 * @param lastUpReceivedAt Timestamp when the last upstream message has been received from a Network Server. This can be a join-accept, uplink message or downlink message event.
 * @param upCount Number of upstream messages received.
 * @param lastDownlinkForwardedAt Timestamp when the last downlink message has been forwarded to a Network Server.
 * @param downlinkCount Number of downlink messages forwarded.
 */
@JsonClass(generateAdapter = true)
data class V3ApplicationLinkStats (

    @Json(name = "linked_at")
    val linkedAt: java.time.OffsetDateTime? = null,

    @Json(name = "network_server_address")
    val networkServerAddress: kotlin.String? = null,

    /* Timestamp when the last upstream message has been received from a Network Server. This can be a join-accept, uplink message or downlink message event. */
    @Json(name = "last_up_received_at")
    val lastUpReceivedAt: java.time.OffsetDateTime? = null,

    /* Number of upstream messages received. */
    @Json(name = "up_count")
    val upCount: kotlin.String? = null,

    /* Timestamp when the last downlink message has been forwarded to a Network Server. */
    @Json(name = "last_downlink_forwarded_at")
    val lastDownlinkForwardedAt: java.time.OffsetDateTime? = null,

    /* Number of downlink messages forwarded. */
    @Json(name = "downlink_count")
    val downlinkCount: kotlin.String? = null

)

