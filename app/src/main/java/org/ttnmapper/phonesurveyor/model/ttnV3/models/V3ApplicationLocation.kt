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

import org.openapitools.client.models.Lorawanv3Location

import com.squareup.moshi.Json

/**
 * 
 * @param service 
 * @param location 
 * @param attributes 
 */

data class V3ApplicationLocation (
    @Json(name = "service")
    val service: kotlin.String? = null,
    @Json(name = "location")
    val location: Lorawanv3Location? = null,
    @Json(name = "attributes")
    val attributes: kotlin.collections.Map<kotlin.String, kotlin.String>? = null
)
