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

import org.openapitools.client.models.V3MessagePayloadFormatters

import com.squareup.moshi.Json

/**
 * 
 * @param networkServerAddress The address of the external Network Server where to link to. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. Leave empty when linking to a cluster Network Server.
 * @param apiKey The API key to use to link the Application Server to Network Server. This API key needs to have RIGHT_APPLICATION_LINK.
 * @param defaultFormatters 
 * @param tls Enable TLS for linking to the external Network Server. For cluster-local Network Servers, the cluster's TLS setting is used.
 * @param skipPayloadCrypto Skip decryption of uplink payloads and encryption of downlink payloads. Leave empty for the using the Application Server's default setting.
 */

data class V3ApplicationLink (
    /* The address of the external Network Server where to link to. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. Leave empty when linking to a cluster Network Server. */
    @Json(name = "network_server_address")
    val networkServerAddress: kotlin.String? = null,
    /* The API key to use to link the Application Server to Network Server. This API key needs to have RIGHT_APPLICATION_LINK. */
    @Json(name = "api_key")
    val apiKey: kotlin.String? = null,
    @Json(name = "default_formatters")
    val defaultFormatters: V3MessagePayloadFormatters? = null,
    /* Enable TLS for linking to the external Network Server. For cluster-local Network Servers, the cluster's TLS setting is used. */
    @Json(name = "tls")
    val tls: kotlin.Boolean? = null,
    /* Skip decryption of uplink payloads and encryption of downlink payloads. Leave empty for the using the Application Server's default setting. */
    @Json(name = "skip_payload_crypto")
    val skipPayloadCrypto: kotlin.Boolean? = null
)

