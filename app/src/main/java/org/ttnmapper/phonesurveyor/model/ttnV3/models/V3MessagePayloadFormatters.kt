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

import org.openapitools.client.models.V3PayloadFormatter

import com.squareup.moshi.Json

/**
 * 
 * @param upFormatter 
 * @param upFormatterParameter Parameter for the up_formatter, must be set together.
 * @param downFormatter 
 * @param downFormatterParameter Parameter for the down_formatter, must be set together.
 */

data class V3MessagePayloadFormatters (
    @Json(name = "up_formatter")
    val upFormatter: V3PayloadFormatter? = null,
    /* Parameter for the up_formatter, must be set together. */
    @Json(name = "up_formatter_parameter")
    val upFormatterParameter: kotlin.String? = null,
    @Json(name = "down_formatter")
    val downFormatter: V3PayloadFormatter? = null,
    /* Parameter for the down_formatter, must be set together. */
    @Json(name = "down_formatter_parameter")
    val downFormatterParameter: kotlin.String? = null
)

