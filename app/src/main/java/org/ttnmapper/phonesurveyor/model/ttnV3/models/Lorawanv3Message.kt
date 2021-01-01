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

import org.openapitools.client.models.V3JoinAcceptPayload
import org.openapitools.client.models.V3JoinRequestPayload
import org.openapitools.client.models.V3MACPayload
import org.openapitools.client.models.V3MHDR
import org.openapitools.client.models.V3RejoinRequestPayload

import com.squareup.moshi.Json

/**
 * 
 * @param mHdr 
 * @param mic 
 * @param macPayload 
 * @param joinRequestPayload 
 * @param joinAcceptPayload 
 * @param rejoinRequestPayload 
 */

data class Lorawanv3Message (
    @Json(name = "m_hdr")
    val mHdr: V3MHDR? = null,
    @Json(name = "mic")
    val mic: kotlin.ByteArray? = null,
    @Json(name = "mac_payload")
    val macPayload: V3MACPayload? = null,
    @Json(name = "join_request_payload")
    val joinRequestPayload: V3JoinRequestPayload? = null,
    @Json(name = "join_accept_payload")
    val joinAcceptPayload: V3JoinAcceptPayload? = null,
    @Json(name = "rejoin_request_payload")
    val rejoinRequestPayload: V3RejoinRequestPayload? = null
)
