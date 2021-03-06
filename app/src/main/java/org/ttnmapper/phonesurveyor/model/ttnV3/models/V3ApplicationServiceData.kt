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
import com.squareup.moshi.JsonClass

/**
 * 
 * @param service 
 * @param data 
 */

@JsonClass(generateAdapter = true)
data class V3ApplicationServiceData (
    @Json(name = "service")
    val service: kotlin.String? = null,
    @Json(name = "data")
    val data: kotlin.Any? = null
)

