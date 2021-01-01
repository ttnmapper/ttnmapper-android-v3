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
 * @param rx2DataRateIndex 
 * @param rx1DataRateOffset 
 * @param rx2Frequency 
 */

data class MACCommandRxParamSetupReq (
    @Json(name = "rx2_data_rate_index")
    val rx2DataRateIndex: V3DataRateIndex? = null,
    @Json(name = "rx1_data_rate_offset")
    val rx1DataRateOffset: kotlin.Long? = null,
    @Json(name = "rx2_frequency")
    val rx2Frequency: kotlin.String? = null
)

