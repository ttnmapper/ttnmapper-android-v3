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
 * @param channelIndex 
 * @param frequency 
 * @param minDataRateIndex 
 * @param maxDataRateIndex 
 */

data class MACCommandNewChannelReq (
    @Json(name = "channel_index")
    val channelIndex: kotlin.Long? = null,
    @Json(name = "frequency")
    val frequency: kotlin.String? = null,
    @Json(name = "min_data_rate_index")
    val minDataRateIndex: V3DataRateIndex? = null,
    @Json(name = "max_data_rate_index")
    val maxDataRateIndex: V3DataRateIndex? = null
)
