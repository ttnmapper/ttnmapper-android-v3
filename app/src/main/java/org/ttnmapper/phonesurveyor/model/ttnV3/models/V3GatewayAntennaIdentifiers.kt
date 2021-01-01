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

import org.openapitools.client.models.V3GatewayIdentifiers

import com.squareup.moshi.Json

/**
 * 
 * @param gatewayIds 
 * @param antennaIndex 
 */

data class V3GatewayAntennaIdentifiers (
    @Json(name = "gateway_ids")
    val gatewayIds: V3GatewayIdentifiers? = null,
    @Json(name = "antenna_index")
    val antennaIndex: kotlin.Long? = null
)

