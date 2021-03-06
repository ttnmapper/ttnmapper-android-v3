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

import org.openapitools.client.models.TxAcknowledgmentResult

import com.squareup.moshi.Json

/**
 * 
 * @param correlationIds 
 * @param result 
 */

data class V3TxAcknowledgment (
    @Json(name = "correlation_ids")
    val correlationIds: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "result")
    val result: TxAcknowledgmentResult? = null
)

