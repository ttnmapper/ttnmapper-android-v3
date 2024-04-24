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

import org.openapitools.client.models.V3DownlinkPath

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param delay The amount of time between the message has been scheduled and it will be transmitted by the gateway.
 * @param downlinkPath 
 * @param rx1 Whether RX1 has been chosen for the downlink message. Both RX1 and RX2 can be used for transmitting the same message by the same gateway.
 * @param rx2 Whether RX2 has been chosen for the downlink message. Both RX1 and RX2 can be used for transmitting the same message by the same gateway.
 */
@JsonClass(generateAdapter = true)
data class V3ScheduleDownlinkResponse (

    /* The amount of time between the message has been scheduled and it will be transmitted by the gateway. */
    @Json(name = "delay")
    val delay: kotlin.String? = null,

    @Json(name = "downlink_path")
    val downlinkPath: V3DownlinkPath? = null,

    /* Whether RX1 has been chosen for the downlink message. Both RX1 and RX2 can be used for transmitting the same message by the same gateway. */
    @Json(name = "rx1")
    val rx1: kotlin.Boolean? = null,

    /* Whether RX2 has been chosen for the downlink message. Both RX1 and RX2 can be used for transmitting the same message by the same gateway. */
    @Json(name = "rx2")
    val rx2: kotlin.Boolean? = null

)
