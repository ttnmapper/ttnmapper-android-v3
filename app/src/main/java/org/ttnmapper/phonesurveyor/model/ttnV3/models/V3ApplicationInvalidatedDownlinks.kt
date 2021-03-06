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

import org.openapitools.client.models.V3ApplicationDownlink

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 * @param downlinks 
 * @param lastFCntDown 
 */

@JsonClass(generateAdapter = true)
data class V3ApplicationInvalidatedDownlinks (
    @Json(name = "downlinks")
    val downlinks: kotlin.collections.List<V3ApplicationDownlink>? = null,
    @Json(name = "last_f_cnt_down")
    val lastFCntDown: kotlin.Long? = null
)

