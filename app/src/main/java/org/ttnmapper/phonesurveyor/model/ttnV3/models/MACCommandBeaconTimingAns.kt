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
 * @param delay 
 * @param channelIndex 
 */

data class MACCommandBeaconTimingAns (
    @Json(name = "delay")
    val delay: kotlin.Long? = null,
    @Json(name = "channel_index")
    val channelIndex: kotlin.Long? = null
)

