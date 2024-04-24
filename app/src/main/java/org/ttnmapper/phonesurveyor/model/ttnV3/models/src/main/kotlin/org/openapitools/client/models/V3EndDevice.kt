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
import org.openapitools.client.models.V3ApplicationDownlink
import org.openapitools.client.models.V3EndDeviceAuthenticationCode
import org.openapitools.client.models.V3EndDeviceIdentifiers
import org.openapitools.client.models.V3EndDeviceVersionIdentifiers
import org.openapitools.client.models.V3MACSettings
import org.openapitools.client.models.V3MACState
import org.openapitools.client.models.V3MACVersion
import org.openapitools.client.models.V3MessagePayloadFormatters
import org.openapitools.client.models.V3PHYVersion
import org.openapitools.client.models.V3Picture
import org.openapitools.client.models.V3PowerState
import org.openapitools.client.models.V3RootKeys
import org.openapitools.client.models.V3Session

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Defines an End Device registration and its state on the network. The persistence of the EndDevice is divided between the Network Server, Application Server and Join Server. SDKs are responsible for combining (if desired) the three.
 *
 * @param ids 
 * @param createdAt 
 * @param updatedAt 
 * @param name Friendly name of the device. Stored in Entity Registry.
 * @param description Description of the device. Stored in Entity Registry.
 * @param attributes Key-value attributes for this end device. Typically used for organizing end devices or for storing integration-specific data. Stored in Entity Registry.
 * @param versionIds 
 * @param serviceProfileId Default service profile. Stored in Entity Registry.
 * @param networkServerAddress The address of the Network Server where this device is supposed to be registered. Stored in Entity Registry and Join Server. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band.
 * @param networkServerKekLabel The KEK label of the Network Server to use for wrapping network session keys. Stored in Join Server.
 * @param applicationServerAddress The address of the Application Server where this device is supposed to be registered. Stored in Entity Registry and Join Server. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band.
 * @param applicationServerKekLabel The KEK label of the Application Server to use for wrapping the application session key. Stored in Join Server.
 * @param applicationServerId The AS-ID of the Application Server to use. Stored in Join Server.
 * @param joinServerAddress The address of the Join Server where this device is supposed to be registered. Stored in Entity Registry. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band.
 * @param locations Location of the device. Stored in Entity Registry.
 * @param picture 
 * @param supportsClassB Whether the device supports class B. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param supportsClassC Whether the device supports class C. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param lorawanVersion 
 * @param lorawanPhyVersion 
 * @param frequencyPlanId ID of the frequency plan used by this device. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param minFrequency Minimum frequency the device is capable of using (Hz). Stored in Network Server. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param maxFrequency Maximum frequency the device is capable of using (Hz). Stored in Network Server. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param supportsJoin The device supports join (it's OTAA). Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param resetsJoinNonces Whether the device resets the join and dev nonces (not LoRaWAN compliant). Stored in Join Server. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any.
 * @param rootKeys 
 * @param netId Home NetID. Stored in Join Server.
 * @param macSettings 
 * @param macState 
 * @param pendingMacState 
 * @param session 
 * @param pendingSession 
 * @param lastDevNonce Last DevNonce used. This field is only used for devices using LoRaWAN version 1.1 and later. Stored in Join Server.
 * @param usedDevNonces Used DevNonces sorted in ascending order. This field is only used for devices using LoRaWAN versions preceding 1.1. Stored in Join Server.
 * @param lastJoinNonce Last JoinNonce/AppNonce(for devices using LoRaWAN versions preceding 1.1) used. Stored in Join Server.
 * @param lastRjCount0 Last Rejoin counter value used (type 0/2). Stored in Join Server.
 * @param lastRjCount1 Last Rejoin counter value used (type 1). Stored in Join Server.
 * @param lastDevStatusReceivedAt Time when last DevStatus MAC command was received. Stored in Network Server.
 * @param powerState 
 * @param batteryPercentage Latest-known battery percentage of the device. Received via the DevStatus MAC command at last_dev_status_received_at or earlier. Stored in Network Server.
 * @param downlinkMargin Demodulation signal-to-noise ratio (dB). Received via the DevStatus MAC command at last_dev_status_received_at. Stored in Network Server.
 * @param queuedApplicationDownlinks Queued Application downlink messages. Stored in Application Server, which sets them on the Network Server. This field is deprecated and is always set equal to session.queued_application_downlinks.
 * @param formatters 
 * @param provisionerId ID of the provisioner. Stored in Join Server.
 * @param provisioningData Vendor-specific provisioning data. Stored in Join Server.
 * @param multicast Indicates whether this device represents a multicast group.
 * @param claimAuthenticationCode 
 * @param skipPayloadCrypto Skip decryption of uplink payloads and encryption of downlink payloads. This field is deprecated, use skip_payload_crypto_override instead.
 * @param skipPayloadCryptoOverride Skip decryption of uplink payloads and encryption of downlink payloads. This field overrides the application-level setting.
 * @param activatedAt Timestamp when the device has been activated. Stored in the Entity Registry. This field is set by the Application Server when an end device sends its first uplink. The Application Server will use the field in order to avoid repeated calls to the Entity Registry. The field cannot be unset once set.
 */
@JsonClass(generateAdapter = true)
data class V3EndDevice (

    @Json(name = "ids")
    val ids: V3EndDeviceIdentifiers? = null,

    @Json(name = "created_at")
    val createdAt: java.time.OffsetDateTime? = null,

    @Json(name = "updated_at")
    val updatedAt: java.time.OffsetDateTime? = null,

    /* Friendly name of the device. Stored in Entity Registry. */
    @Json(name = "name")
    val name: kotlin.String? = null,

    /* Description of the device. Stored in Entity Registry. */
    @Json(name = "description")
    val description: kotlin.String? = null,

    /* Key-value attributes for this end device. Typically used for organizing end devices or for storing integration-specific data. Stored in Entity Registry. */
    @Json(name = "attributes")
    val attributes: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    @Json(name = "version_ids")
    val versionIds: V3EndDeviceVersionIdentifiers? = null,

    /* Default service profile. Stored in Entity Registry. */
    @Json(name = "service_profile_id")
    val serviceProfileId: kotlin.String? = null,

    /* The address of the Network Server where this device is supposed to be registered. Stored in Entity Registry and Join Server. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band. */
    @Json(name = "network_server_address")
    val networkServerAddress: kotlin.String? = null,

    /* The KEK label of the Network Server to use for wrapping network session keys. Stored in Join Server. */
    @Json(name = "network_server_kek_label")
    val networkServerKekLabel: kotlin.String? = null,

    /* The address of the Application Server where this device is supposed to be registered. Stored in Entity Registry and Join Server. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band. */
    @Json(name = "application_server_address")
    val applicationServerAddress: kotlin.String? = null,

    /* The KEK label of the Application Server to use for wrapping the application session key. Stored in Join Server. */
    @Json(name = "application_server_kek_label")
    val applicationServerKekLabel: kotlin.String? = null,

    /* The AS-ID of the Application Server to use. Stored in Join Server. */
    @Json(name = "application_server_id")
    val applicationServerId: kotlin.String? = null,

    /* The address of the Join Server where this device is supposed to be registered. Stored in Entity Registry. The typical format of the address is \"host:port\". If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band. */
    @Json(name = "join_server_address")
    val joinServerAddress: kotlin.String? = null,

    /* Location of the device. Stored in Entity Registry. */
    @Json(name = "locations")
    val locations: kotlin.collections.Map<kotlin.String, Lorawanv3Location>? = null,

    @Json(name = "picture")
    val picture: V3Picture? = null,

    /* Whether the device supports class B. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "supports_class_b")
    val supportsClassB: kotlin.Boolean? = null,

    /* Whether the device supports class C. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "supports_class_c")
    val supportsClassC: kotlin.Boolean? = null,

    @Json(name = "lorawan_version")
    val lorawanVersion: V3MACVersion? = V3MACVersion.uNKNOWN,

    @Json(name = "lorawan_phy_version")
    val lorawanPhyVersion: V3PHYVersion? = V3PHYVersion.pHYUNKNOWN,

    /* ID of the frequency plan used by this device. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "frequency_plan_id")
    val frequencyPlanId: kotlin.String? = null,

    /* Minimum frequency the device is capable of using (Hz). Stored in Network Server. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "min_frequency")
    val minFrequency: kotlin.String? = null,

    /* Maximum frequency the device is capable of using (Hz). Stored in Network Server. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "max_frequency")
    val maxFrequency: kotlin.String? = null,

    /* The device supports join (it's OTAA). Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "supports_join")
    val supportsJoin: kotlin.Boolean? = null,

    /* Whether the device resets the join and dev nonces (not LoRaWAN compliant). Stored in Join Server. Copied on creation from template identified by version_ids, if any or from the home Network Server device profile, if any. */
    @Json(name = "resets_join_nonces")
    val resetsJoinNonces: kotlin.Boolean? = null,

    @Json(name = "root_keys")
    val rootKeys: V3RootKeys? = null,

    /* Home NetID. Stored in Join Server. */
    @Json(name = "net_id")
    val netId: kotlin.ByteArray? = null,

    @Json(name = "mac_settings")
    val macSettings: V3MACSettings? = null,

    @Json(name = "mac_state")
    val macState: V3MACState? = null,

    @Json(name = "pending_mac_state")
    val pendingMacState: V3MACState? = null,

    @Json(name = "session")
    val session: V3Session? = null,

    @Json(name = "pending_session")
    val pendingSession: V3Session? = null,

    /* Last DevNonce used. This field is only used for devices using LoRaWAN version 1.1 and later. Stored in Join Server. */
    @Json(name = "last_dev_nonce")
    val lastDevNonce: kotlin.Long? = null,

    /* Used DevNonces sorted in ascending order. This field is only used for devices using LoRaWAN versions preceding 1.1. Stored in Join Server. */
    @Json(name = "used_dev_nonces")
    val usedDevNonces: kotlin.collections.List<kotlin.Long>? = null,

    /* Last JoinNonce/AppNonce(for devices using LoRaWAN versions preceding 1.1) used. Stored in Join Server. */
    @Json(name = "last_join_nonce")
    val lastJoinNonce: kotlin.Long? = null,

    /* Last Rejoin counter value used (type 0/2). Stored in Join Server. */
    @Json(name = "last_rj_count_0")
    val lastRjCount0: kotlin.Long? = null,

    /* Last Rejoin counter value used (type 1). Stored in Join Server. */
    @Json(name = "last_rj_count_1")
    val lastRjCount1: kotlin.Long? = null,

    /* Time when last DevStatus MAC command was received. Stored in Network Server. */
    @Json(name = "last_dev_status_received_at")
    val lastDevStatusReceivedAt: java.time.OffsetDateTime? = null,

    @Json(name = "power_state")
    val powerState: V3PowerState? = V3PowerState.uNKNOWN,

    /* Latest-known battery percentage of the device. Received via the DevStatus MAC command at last_dev_status_received_at or earlier. Stored in Network Server. */
    @Json(name = "battery_percentage")
    val batteryPercentage: kotlin.Float? = null,

    /* Demodulation signal-to-noise ratio (dB). Received via the DevStatus MAC command at last_dev_status_received_at. Stored in Network Server. */
    @Json(name = "downlink_margin")
    val downlinkMargin: kotlin.Int? = null,

    /* Queued Application downlink messages. Stored in Application Server, which sets them on the Network Server. This field is deprecated and is always set equal to session.queued_application_downlinks. */
    @Json(name = "queued_application_downlinks")
    val queuedApplicationDownlinks: kotlin.collections.List<V3ApplicationDownlink>? = null,

    @Json(name = "formatters")
    val formatters: V3MessagePayloadFormatters? = null,

    /* ID of the provisioner. Stored in Join Server. */
    @Json(name = "provisioner_id")
    val provisionerId: kotlin.String? = null,

    /* Vendor-specific provisioning data. Stored in Join Server. */
    @Json(name = "provisioning_data")
    val provisioningData: kotlin.Any? = null,

    /* Indicates whether this device represents a multicast group. */
    @Json(name = "multicast")
    val multicast: kotlin.Boolean? = null,

    @Json(name = "claim_authentication_code")
    val claimAuthenticationCode: V3EndDeviceAuthenticationCode? = null,

    /* Skip decryption of uplink payloads and encryption of downlink payloads. This field is deprecated, use skip_payload_crypto_override instead. */
    @Json(name = "skip_payload_crypto")
    val skipPayloadCrypto: kotlin.Boolean? = null,

    /* Skip decryption of uplink payloads and encryption of downlink payloads. This field overrides the application-level setting. */
    @Json(name = "skip_payload_crypto_override")
    val skipPayloadCryptoOverride: kotlin.Boolean? = null,

    /* Timestamp when the device has been activated. Stored in the Entity Registry. This field is set by the Application Server when an end device sends its first uplink. The Application Server will use the field in order to avoid repeated calls to the Entity Registry. The field cannot be unset once set. */
    @Json(name = "activated_at")
    val activatedAt: java.time.OffsetDateTime? = null

)
