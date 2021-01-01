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

import org.openapitools.client.models.V3DataRateIndex

import com.squareup.moshi.Json

/**
 * 
 * @param uplinkFrequency Uplink frequency of the channel (Hz).
 * @param downlinkFrequency Downlink frequency of the channel (Hz).
 * @param minDataRateIndex 
 * @param maxDataRateIndex 
 * @param enableUplink Channel can be used by device for uplink.
 */

data class V3MACParametersChannel (
    /* Uplink frequency of the channel (Hz). */
    @Json(name = "uplink_frequency")
    val uplinkFrequency: kotlin.String? = null,
    /* Downlink frequency of the channel (Hz). */
    @Json(name = "downlink_frequency")
    val downlinkFrequency: kotlin.String? = null,
    @Json(name = "min_data_rate_index")
    val minDataRateIndex: V3DataRateIndex? = null,
    @Json(name = "max_data_rate_index")
    val maxDataRateIndex: V3DataRateIndex? = null,
    /* Channel can be used by device for uplink. */
    @Json(name = "enable_uplink")
    val enableUplink: kotlin.Boolean? = null
)
