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

import org.openapitools.client.models.V3Picture

import com.squareup.moshi.Json

/**
 * 
 * @param text 
 * @param image 
 */

data class V3GenerateQRCodeResponse (
    @Json(name = "text")
    val text: kotlin.String? = null,
    @Json(name = "image")
    val image: V3Picture? = null
)

