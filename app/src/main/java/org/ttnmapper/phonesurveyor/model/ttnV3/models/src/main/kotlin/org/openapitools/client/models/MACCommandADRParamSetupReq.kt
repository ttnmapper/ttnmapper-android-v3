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

import org.openapitools.client.models.V3ADRAckDelayExponent
import org.openapitools.client.models.V3ADRAckLimitExponent

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param adrAckLimitExponent 
 * @param adrAckDelayExponent 
 */
@JsonClass(generateAdapter = true)
data class MACCommandADRParamSetupReq (

    @Json(name = "adr_ack_limit_exponent")
    val adrAckLimitExponent: V3ADRAckLimitExponent? = V3ADRAckLimitExponent._1,

    @Json(name = "adr_ack_delay_exponent")
    val adrAckDelayExponent: V3ADRAckDelayExponent? = V3ADRAckDelayExponent._1

)
