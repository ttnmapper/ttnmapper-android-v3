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

import org.openapitools.client.models.V3ApplicationUplink
import org.openapitools.client.models.V3EndDeviceIdentifiers
import org.openapitools.client.models.V3EndDeviceVersionIdentifiers
import org.openapitools.client.models.V3PayloadFormatter

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param endDeviceIds 
 * @param versionIds 
 * @param uplink 
 * @param formatter 
 * @param parameter 
 */
@JsonClass(generateAdapter = true)
data class V3DecodeUplinkRequest (

    @Json(name = "end_device_ids")
    val endDeviceIds: V3EndDeviceIdentifiers? = null,

    @Json(name = "version_ids")
    val versionIds: V3EndDeviceVersionIdentifiers? = null,

    @Json(name = "uplink")
    val uplink: V3ApplicationUplink? = null,

    @Json(name = "formatter")
    val formatter: V3PayloadFormatter? = V3PayloadFormatter.nONE,

    @Json(name = "parameter")
    val parameter: kotlin.String? = null

)
