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

import org.openapitools.client.models.OperatingConditionsLimits

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param temperature 
 * @param relativeHumidity 
 */
@JsonClass(generateAdapter = true)
data class EndDeviceModelOperatingConditions (

    @Json(name = "temperature")
    val temperature: OperatingConditionsLimits? = null,

    @Json(name = "relative_humidity")
    val relativeHumidity: OperatingConditionsLimits? = null

)
