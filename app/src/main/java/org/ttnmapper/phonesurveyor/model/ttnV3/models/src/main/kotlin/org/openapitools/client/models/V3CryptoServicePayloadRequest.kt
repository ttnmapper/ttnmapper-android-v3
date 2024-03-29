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

import org.openapitools.client.models.V3EndDeviceIdentifiers
import org.openapitools.client.models.V3MACVersion

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param ids 
 * @param lorawanVersion 
 * @param payload Raw input payload.
 * @param provisionerId Provisioner that provisioned the end device.
 * @param provisioningData Provisioning data for the provisioner.
 */
@JsonClass(generateAdapter = true)
data class V3CryptoServicePayloadRequest (

    @Json(name = "ids")
    val ids: V3EndDeviceIdentifiers? = null,

    @Json(name = "lorawan_version")
    val lorawanVersion: V3MACVersion? = V3MACVersion.uNKNOWN,

    /* Raw input payload. */
    @Json(name = "payload")
    val payload: kotlin.ByteArray? = null,

    /* Provisioner that provisioned the end device. */
    @Json(name = "provisioner_id")
    val provisionerId: kotlin.String? = null,

    /* Provisioning data for the provisioner. */
    @Json(name = "provisioning_data")
    val provisioningData: kotlin.Any? = null

)

