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

import org.openapitools.client.models.Lorawanv3Location
import org.openapitools.client.models.V3EndDeviceVersionIdentifiers
import org.openapitools.client.models.V3KeyEnvelope
import org.openapitools.client.models.V3NetworkIdentifiers
import org.openapitools.client.models.V3RxMetadata
import org.openapitools.client.models.V3TxSettings

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param sessionKeyId Join Server issued identifier for the session keys used by this uplink.
 * @param fPort 
 * @param fCnt 
 * @param frmPayload The frame payload of the uplink message. The payload is still encrypted if the skip_payload_crypto field of the EndDevice is true, which is indicated by the presence of the app_s_key field.
 * @param decodedPayload The decoded frame payload of the uplink message. This field is set by the message processor that is configured for the end device (see formatters) or application (see default_formatters).
 * @param decodedPayloadWarnings Warnings generated by the message processor while decoding the frm_payload.
 * @param rxMetadata A list of metadata for each antenna of each gateway that received this message.
 * @param settings 
 * @param receivedAt Server time when the Network Server received the message.
 * @param appSKey 
 * @param lastAFCntDown The last AFCntDown of the current session. This field is only present if the skip_payload_crypto field of the EndDevice is true. Can be used with app_s_key to encrypt downlink payloads.
 * @param confirmed 
 * @param consumedAirtime Consumed airtime for the transmission of the uplink message. Calculated by Network Server using the RawPayload size and the transmission settings.
 * @param locations End device location metadata, set by the Application Server while handling the message.
 * @param versionIds 
 * @param networkIds 
 */
@JsonClass(generateAdapter = true)
data class V3ApplicationUplink (

    /* Join Server issued identifier for the session keys used by this uplink. */
    @Json(name = "session_key_id")
    val sessionKeyId: kotlin.ByteArray? = null,

    @Json(name = "f_port")
    val fPort: kotlin.Long? = null,

    @Json(name = "f_cnt")
    val fCnt: kotlin.Long? = null,

    /* The frame payload of the uplink message. The payload is still encrypted if the skip_payload_crypto field of the EndDevice is true, which is indicated by the presence of the app_s_key field. */
    @Json(name = "frm_payload")
    val frmPayload: kotlin.ByteArray? = null,

    /* The decoded frame payload of the uplink message. This field is set by the message processor that is configured for the end device (see formatters) or application (see default_formatters). */
    @Json(name = "decoded_payload")
    val decodedPayload: kotlin.Any? = null,

    /* Warnings generated by the message processor while decoding the frm_payload. */
    @Json(name = "decoded_payload_warnings")
    val decodedPayloadWarnings: kotlin.collections.List<kotlin.String>? = null,

    /* A list of metadata for each antenna of each gateway that received this message. */
    @Json(name = "rx_metadata")
    val rxMetadata: kotlin.collections.List<V3RxMetadata>? = null,

    @Json(name = "settings")
    val settings: V3TxSettings? = null,

    /* Server time when the Network Server received the message. */
    @Json(name = "received_at")
    val receivedAt: java.time.OffsetDateTime? = null,

    @Json(name = "app_s_key")
    val appSKey: V3KeyEnvelope? = null,

    /* The last AFCntDown of the current session. This field is only present if the skip_payload_crypto field of the EndDevice is true. Can be used with app_s_key to encrypt downlink payloads. */
    @Json(name = "last_a_f_cnt_down")
    val lastAFCntDown: kotlin.Long? = null,

    @Json(name = "confirmed")
    val confirmed: kotlin.Boolean? = null,

    /* Consumed airtime for the transmission of the uplink message. Calculated by Network Server using the RawPayload size and the transmission settings. */
    @Json(name = "consumed_airtime")
    val consumedAirtime: kotlin.String? = null,

    /* End device location metadata, set by the Application Server while handling the message. */
    @Json(name = "locations")
    val locations: kotlin.collections.Map<kotlin.String, Lorawanv3Location>? = null,

    @Json(name = "version_ids")
    val versionIds: V3EndDeviceVersionIdentifiers? = null,

    @Json(name = "network_ids")
    val networkIds: V3NetworkIdentifiers? = null

)
