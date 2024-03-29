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

import org.openapitools.client.models.Lorawanv3GatewayIdentifiers
import org.openapitools.client.models.Lorawanv3Location
import org.openapitools.client.models.V3DownlinkPathConstraint
import org.openapitools.client.models.V3PacketBrokerMetadata

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Contains metadata for a received message. Each antenna that receives a message corresponds to one RxMetadata.
 *
 * @param gatewayIds 
 * @param packetBroker 
 * @param antennaIndex 
 * @param time 
 * @param timestamp Gateway concentrator timestamp when the Rx finished (microseconds).
 * @param fineTimestamp Gateway's internal fine timestamp when the Rx finished (nanoseconds).
 * @param encryptedFineTimestamp Encrypted gateway's internal fine timestamp when the Rx finished (nanoseconds).
 * @param encryptedFineTimestampKeyId 
 * @param rssi Received signal strength indicator (dBm). This value equals `channel_rssi`.
 * @param signalRssi Received signal strength indicator of the signal (dBm).
 * @param channelRssi Received signal strength indicator of the channel (dBm).
 * @param rssiStandardDeviation Standard deviation of the RSSI during preamble.
 * @param snr Signal-to-noise ratio (dB).
 * @param frequencyOffset Frequency offset (Hz).
 * @param location 
 * @param downlinkPathConstraint 
 * @param uplinkToken Uplink token to be included in the Tx request in class A downlink; injected by gateway, Gateway Server or fNS.
 * @param channelIndex Index of the gateway channel that received the message.
 * @param hoppingWidth Hopping width; a number describing the number of steps of the LR-FHSS grid.
 * @param frequencyDrift Frequency drift in Hz between start and end of an LR-FHSS packet (signed).
 * @param advanced 
 */
@JsonClass(generateAdapter = true)
data class V3RxMetadata (

    @Json(name = "gateway_ids")
    val gatewayIds: Lorawanv3GatewayIdentifiers? = null,

    @Json(name = "packet_broker")
    val packetBroker: V3PacketBrokerMetadata? = null,

    @Json(name = "antenna_index")
    val antennaIndex: kotlin.Long? = null,

    @Json(name = "time")
    val time: java.time.OffsetDateTime? = null,

    /* Gateway concentrator timestamp when the Rx finished (microseconds). */
    @Json(name = "timestamp")
    val timestamp: kotlin.Long? = null,

    /* Gateway's internal fine timestamp when the Rx finished (nanoseconds). */
    @Json(name = "fine_timestamp")
    val fineTimestamp: kotlin.String? = null,

    /* Encrypted gateway's internal fine timestamp when the Rx finished (nanoseconds). */
    @Json(name = "encrypted_fine_timestamp")
    val encryptedFineTimestamp: kotlin.ByteArray? = null,

    @Json(name = "encrypted_fine_timestamp_key_id")
    val encryptedFineTimestampKeyId: kotlin.String? = null,

    /* Received signal strength indicator (dBm). This value equals `channel_rssi`. */
    @Json(name = "rssi")
    val rssi: kotlin.Float? = null,

    /* Received signal strength indicator of the signal (dBm). */
    @Json(name = "signal_rssi")
    val signalRssi: kotlin.Float? = null,

    /* Received signal strength indicator of the channel (dBm). */
    @Json(name = "channel_rssi")
    val channelRssi: kotlin.Float? = null,

    /* Standard deviation of the RSSI during preamble. */
    @Json(name = "rssi_standard_deviation")
    val rssiStandardDeviation: kotlin.Float? = null,

    /* Signal-to-noise ratio (dB). */
    @Json(name = "snr")
    val snr: kotlin.Float? = null,

    /* Frequency offset (Hz). */
    @Json(name = "frequency_offset")
    val frequencyOffset: kotlin.String? = null,

    @Json(name = "location")
    val location: Lorawanv3Location? = null,

    @Json(name = "downlink_path_constraint")
    val downlinkPathConstraint: V3DownlinkPathConstraint? = V3DownlinkPathConstraint.nONE,

    /* Uplink token to be included in the Tx request in class A downlink; injected by gateway, Gateway Server or fNS. */
    @Json(name = "uplink_token")
    val uplinkToken: kotlin.ByteArray? = null,

    /* Index of the gateway channel that received the message. */
    @Json(name = "channel_index")
    val channelIndex: kotlin.Long? = null,

    /* Hopping width; a number describing the number of steps of the LR-FHSS grid. */
    @Json(name = "hopping_width")
    val hoppingWidth: kotlin.Long? = null,

    /* Frequency drift in Hz between start and end of an LR-FHSS packet (signed). */
    @Json(name = "frequency_drift")
    val frequencyDrift: kotlin.Int? = null,

    @Json(name = "advanced")
    val advanced: kotlin.Any? = null

)

