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

import org.openapitools.client.models.V3ApplicationIdentifiers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param deviceId 
 * @param applicationIds 
 * @param devEui The LoRaWAN DevEUI.
 * @param joinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
 * @param devAddr The LoRaWAN DevAddr.
 */
@JsonClass(generateAdapter = true)
data class V3EndDeviceIdentifiers (

    @Json(name = "device_id")
    val deviceId: kotlin.String? = null,

    @Json(name = "application_ids")
    val applicationIds: V3ApplicationIdentifiers? = null,

    /* The LoRaWAN DevEUI. */
    @Json(name = "dev_eui")
    val devEui: kotlin.ByteArray? = null,

    /* The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). */
    @Json(name = "join_eui")
    val joinEui: kotlin.ByteArray? = null,

    /* The LoRaWAN DevAddr. */
    @Json(name = "dev_addr")
    val devAddr: kotlin.ByteArray? = null

)
