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
 * @param joinEui 
 * @param devEui 
 * @param devNonce 
 */

data class V3JoinRequestPayload (
    @Json(name = "join_eui")
    val joinEui: kotlin.ByteArray? = null,
    @Json(name = "dev_eui")
    val devEui: kotlin.ByteArray? = null,
    @Json(name = "dev_nonce")
    val devNonce: kotlin.ByteArray? = null
)

