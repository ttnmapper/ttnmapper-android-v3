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

import org.openapitools.client.models.V3KeyEnvelope

import com.squareup.moshi.Json

/**
 * 
 * @param appSKey 
 */

data class V3AppSKeyResponse (
    @Json(name = "app_s_key")
    val appSKey: V3KeyEnvelope? = null
)

