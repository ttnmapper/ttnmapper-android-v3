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


import com.squareup.moshi.Json

/**
 * 
 * @param channelMaskAck 
 * @param dataRateIndexAck 
 * @param txPowerIndexAck 
 */

data class MACCommandLinkADRAns (
    @Json(name = "channel_mask_ack")
    val channelMaskAck: kotlin.Boolean? = null,
    @Json(name = "data_rate_index_ack")
    val dataRateIndexAck: kotlin.Boolean? = null,
    @Json(name = "tx_power_index_ack")
    val txPowerIndexAck: kotlin.Boolean? = null
)
