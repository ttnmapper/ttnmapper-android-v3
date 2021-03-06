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
 * GatewayAntenna is the message that defines a gateway antenna.
 * @param gain gain is the antenna gain relative to this gateway, in dBi.
 * @param location 
 * @param attributes 
 */

data class V3GatewayAntenna (
    /* gain is the antenna gain relative to this gateway, in dBi. */
    @Json(name = "gain")
    val gain: kotlin.Float? = null,
    @Json(name = "location")
    val location: Lorawanv3Location? = null,
    @Json(name = "attributes")
    val attributes: kotlin.collections.Map<kotlin.String, kotlin.String>? = null
)

