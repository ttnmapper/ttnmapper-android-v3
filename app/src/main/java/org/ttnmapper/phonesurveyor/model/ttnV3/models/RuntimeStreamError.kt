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

import org.openapitools.client.models.ProtobufAny

import com.squareup.moshi.Json

/**
 * 
 * @param grpcCode 
 * @param httpCode 
 * @param message 
 * @param httpStatus 
 * @param details 
 */

data class RuntimeStreamError (
    @Json(name = "grpc_code")
    val grpcCode: kotlin.Int? = null,
    @Json(name = "http_code")
    val httpCode: kotlin.Int? = null,
    @Json(name = "message")
    val message: kotlin.String? = null,
    @Json(name = "http_status")
    val httpStatus: kotlin.String? = null,
    @Json(name = "details")
    val details: kotlin.collections.List<ProtobufAny>? = null
)

