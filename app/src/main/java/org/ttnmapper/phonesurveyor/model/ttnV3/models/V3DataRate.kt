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

import org.openapitools.client.models.V3FSKDataRate
import org.openapitools.client.models.V3LoRaDataRate

import com.squareup.moshi.Json

/**
 * 
 * @param lora 
 * @param fsk 
 */

data class V3DataRate (
    @Json(name = "lora")
    val lora: V3LoRaDataRate? = null,
    @Json(name = "fsk")
    val fsk: V3FSKDataRate? = null
)
