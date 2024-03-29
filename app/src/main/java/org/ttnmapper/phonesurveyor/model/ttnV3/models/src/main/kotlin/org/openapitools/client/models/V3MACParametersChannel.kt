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

import org.openapitools.client.models.V3DataRateIndex

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param uplinkFrequency Uplink frequency of the channel (Hz).
 * @param downlinkFrequency Downlink frequency of the channel (Hz).
 * @param minDataRateIndex 
 * @param maxDataRateIndex 
 * @param enableUplink Channel can be used by device for uplink.
 */
@JsonClass(generateAdapter = true)
data class V3MACParametersChannel (

    /* Uplink frequency of the channel (Hz). */
    @Json(name = "uplink_frequency")
    val uplinkFrequency: kotlin.String? = null,

    /* Downlink frequency of the channel (Hz). */
    @Json(name = "downlink_frequency")
    val downlinkFrequency: kotlin.String? = null,

    @Json(name = "min_data_rate_index")
    val minDataRateIndex: V3DataRateIndex? = V3DataRateIndex._0,

    @Json(name = "max_data_rate_index")
    val maxDataRateIndex: V3DataRateIndex? = V3DataRateIndex._0,

    /* Channel can be used by device for uplink. */
    @Json(name = "enable_uplink")
    val enableUplink: kotlin.Boolean? = null

)

