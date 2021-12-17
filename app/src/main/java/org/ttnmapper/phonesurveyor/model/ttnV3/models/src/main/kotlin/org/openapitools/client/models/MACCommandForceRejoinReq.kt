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

import org.openapitools.client.models.V3DataRateIndex
import org.openapitools.client.models.V3RejoinPeriodExponent
import org.openapitools.client.models.V3RejoinRequestType

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param rejoinType 
 * @param dataRateIndex 
 * @param maxRetries 
 * @param periodExponent 
 */
@JsonClass(generateAdapter = true)
data class MACCommandForceRejoinReq (

    @Json(name = "rejoin_type")
    val rejoinType: V3RejoinRequestType? = V3RejoinRequestType.cONTEXT,

    @Json(name = "data_rate_index")
    val dataRateIndex: V3DataRateIndex? = V3DataRateIndex._0,

    @Json(name = "max_retries")
    val maxRetries: kotlin.Long? = null,

    @Json(name = "period_exponent")
    val periodExponent: V3RejoinPeriodExponent? = V3RejoinPeriodExponent._0

)

