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
 * @param frequencyAck 
 * @param dataRateAck 
 */

data class MACCommandNewChannelAns (
    @Json(name = "frequency_ack")
    val frequencyAck: kotlin.Boolean? = null,
    @Json(name = "data_rate_ack")
    val dataRateAck: kotlin.Boolean? = null
)

