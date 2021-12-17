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

import org.openapitools.client.models.V3ApplicationWebhookTemplateField
import org.openapitools.client.models.V3ApplicationWebhookTemplateIdentifiers
import org.openapitools.client.models.V3ApplicationWebhookTemplateMessage

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param ids 
 * @param name 
 * @param description 
 * @param logoUrl 
 * @param infoUrl 
 * @param documentationUrl 
 * @param baseUrl The base URL of the template. Can contain template fields, in RFC 6570 format.
 * @param headers The HTTP headers used by the template. Both the key and the value can contain template fields.
 * @param format 
 * @param fields 
 * @param createDownlinkApiKey Control the creation of the downlink queue operations API key.
 * @param uplinkMessage 
 * @param joinAccept 
 * @param downlinkAck 
 * @param downlinkNack 
 * @param downlinkSent 
 * @param downlinkFailed 
 * @param downlinkQueued 
 * @param downlinkQueueInvalidated 
 * @param locationSolved 
 * @param serviceData 
 */
@JsonClass(generateAdapter = true)
data class V3ApplicationWebhookTemplate (

    @Json(name = "ids")
    val ids: V3ApplicationWebhookTemplateIdentifiers? = null,

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "description")
    val description: kotlin.String? = null,

    @Json(name = "logo_url")
    val logoUrl: kotlin.String? = null,

    @Json(name = "info_url")
    val infoUrl: kotlin.String? = null,

    @Json(name = "documentation_url")
    val documentationUrl: kotlin.String? = null,

    /* The base URL of the template. Can contain template fields, in RFC 6570 format. */
    @Json(name = "base_url")
    val baseUrl: kotlin.String? = null,

    /* The HTTP headers used by the template. Both the key and the value can contain template fields. */
    @Json(name = "headers")
    val headers: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    @Json(name = "format")
    val format: kotlin.String? = null,

    @Json(name = "fields")
    val fields: kotlin.collections.List<V3ApplicationWebhookTemplateField>? = null,

    /* Control the creation of the downlink queue operations API key. */
    @Json(name = "create_downlink_api_key")
    val createDownlinkApiKey: kotlin.Boolean? = null,

    @Json(name = "uplink_message")
    val uplinkMessage: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "join_accept")
    val joinAccept: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "downlink_ack")
    val downlinkAck: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "downlink_nack")
    val downlinkNack: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "downlink_sent")
    val downlinkSent: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "downlink_failed")
    val downlinkFailed: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "downlink_queued")
    val downlinkQueued: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "downlink_queue_invalidated")
    val downlinkQueueInvalidated: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "location_solved")
    val locationSolved: V3ApplicationWebhookTemplateMessage? = null,

    @Json(name = "service_data")
    val serviceData: V3ApplicationWebhookTemplateMessage? = null

)

