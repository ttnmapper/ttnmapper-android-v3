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

import org.openapitools.client.models.V3RejoinType

import com.squareup.moshi.Json

/**
 * 
 * @param rejoinType 
 * @param netId 
 * @param joinEui 
 * @param devEui 
 * @param rejoinCnt 
 */

data class V3RejoinRequestPayload (
    @Json(name = "rejoin_type")
    val rejoinType: V3RejoinType? = null,
    @Json(name = "net_id")
    val netId: kotlin.ByteArray? = null,
    @Json(name = "join_eui")
    val joinEui: kotlin.ByteArray? = null,
    @Json(name = "dev_eui")
    val devEui: kotlin.ByteArray? = null,
    @Json(name = "rejoin_cnt")
    val rejoinCnt: kotlin.Long? = null
)

