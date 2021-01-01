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
 * @param id 
 * @param baseId The ID of the frequency that the current frequency plan is based on.
 * @param name 
 * @param baseFrequency 
 */

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
