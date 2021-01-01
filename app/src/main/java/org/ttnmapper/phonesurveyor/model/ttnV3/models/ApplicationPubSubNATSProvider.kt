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
 * The NATS provider settings.
 * @param serverUrl The server connection URL.
 */

data class ApplicationPubSubNATSProvider (
    /* The server connection URL. */
    @Json(name = "server_url")
    val serverUrl: kotlin.String? = null
)
