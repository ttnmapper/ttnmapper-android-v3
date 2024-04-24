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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param baseId The ID of the frequency that the current frequency plan is based on.
 * @param name 
 * @param baseFrequency 
 */
@JsonClass(generateAdapter = true)
data class V3FrequencyPlanDescription (

    @Json(name = "id")
    val id: kotlin.String? = null,

    /* The ID of the frequency that the current frequency plan is based on. */
    @Json(name = "base_id")
    val baseId: kotlin.String? = null,

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "base_frequency")
    val baseFrequency: kotlin.Long? = null

)
