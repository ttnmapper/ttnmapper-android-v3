/**
 * The Things Stack for LoRaWAN v3 API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: version not set
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models

import org.openapitools.client.models.RuntimeStreamError
import org.openapitools.client.models.V3Event

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param result 
 * @param error 
 */
@JsonClass(generateAdapter = true)
data class StreamResultOfV3Event (

    @Json(name = "result")
    val result: V3Event? = null,

    @Json(name = "error")
    val error: RuntimeStreamError? = null

)

