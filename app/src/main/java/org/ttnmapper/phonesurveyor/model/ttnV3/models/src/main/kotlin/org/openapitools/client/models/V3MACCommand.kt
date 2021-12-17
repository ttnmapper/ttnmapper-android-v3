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

import org.openapitools.client.models.MACCommandADRParamSetupReq
import org.openapitools.client.models.MACCommandBeaconFreqAns
import org.openapitools.client.models.MACCommandBeaconFreqReq
import org.openapitools.client.models.MACCommandBeaconTimingAns
import org.openapitools.client.models.MACCommandDLChannelAns
import org.openapitools.client.models.MACCommandDLChannelReq
import org.openapitools.client.models.MACCommandDevStatusAns
import org.openapitools.client.models.MACCommandDeviceModeConf
import org.openapitools.client.models.MACCommandDeviceModeInd
import org.openapitools.client.models.MACCommandDeviceTimeAns
import org.openapitools.client.models.MACCommandDutyCycleReq
import org.openapitools.client.models.MACCommandForceRejoinReq
import org.openapitools.client.models.MACCommandLinkADRAns
import org.openapitools.client.models.MACCommandLinkADRReq
import org.openapitools.client.models.MACCommandLinkCheckAns
import org.openapitools.client.models.MACCommandNewChannelAns
import org.openapitools.client.models.MACCommandNewChannelReq
import org.openapitools.client.models.MACCommandPingSlotChannelAns
import org.openapitools.client.models.MACCommandPingSlotChannelReq
import org.openapitools.client.models.MACCommandPingSlotInfoReq
import org.openapitools.client.models.MACCommandRejoinParamSetupAns
import org.openapitools.client.models.MACCommandRejoinParamSetupReq
import org.openapitools.client.models.MACCommandRekeyConf
import org.openapitools.client.models.MACCommandRekeyInd
import org.openapitools.client.models.MACCommandResetConf
import org.openapitools.client.models.MACCommandResetInd
import org.openapitools.client.models.MACCommandRxParamSetupAns
import org.openapitools.client.models.MACCommandRxParamSetupReq
import org.openapitools.client.models.MACCommandRxTimingSetupReq
import org.openapitools.client.models.MACCommandTxParamSetupReq
import org.openapitools.client.models.V3MACCommandIdentifier

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param cid 
 * @param rawPayload 
 * @param resetInd 
 * @param resetConf 
 * @param linkCheckAns 
 * @param linkAdrReq 
 * @param linkAdrAns 
 * @param dutyCycleReq 
 * @param rxParamSetupReq 
 * @param rxParamSetupAns 
 * @param devStatusAns 
 * @param newChannelReq 
 * @param newChannelAns 
 * @param dlChannelReq 
 * @param dlChannelAns 
 * @param rxTimingSetupReq 
 * @param txParamSetupReq 
 * @param rekeyInd 
 * @param rekeyConf 
 * @param adrParamSetupReq 
 * @param deviceTimeAns 
 * @param forceRejoinReq 
 * @param rejoinParamSetupReq 
 * @param rejoinParamSetupAns 
 * @param pingSlotInfoReq 
 * @param pingSlotChannelReq 
 * @param pingSlotChannelAns 
 * @param beaconTimingAns 
 * @param beaconFreqReq 
 * @param beaconFreqAns 
 * @param deviceModeInd 
 * @param deviceModeConf 
 */
@JsonClass(generateAdapter = true)
data class V3MACCommand (

    @Json(name = "cid")
    val cid: V3MACCommandIdentifier? = V3MACCommandIdentifier.rFU0,

    @Json(name = "raw_payload")
    val rawPayload: kotlin.ByteArray? = null,

    @Json(name = "reset_ind")
    val resetInd: MACCommandResetInd? = null,

    @Json(name = "reset_conf")
    val resetConf: MACCommandResetConf? = null,

    @Json(name = "link_check_ans")
    val linkCheckAns: MACCommandLinkCheckAns? = null,

    @Json(name = "link_adr_req")
    val linkAdrReq: MACCommandLinkADRReq? = null,

    @Json(name = "link_adr_ans")
    val linkAdrAns: MACCommandLinkADRAns? = null,

    @Json(name = "duty_cycle_req")
    val dutyCycleReq: MACCommandDutyCycleReq? = null,

    @Json(name = "rx_param_setup_req")
    val rxParamSetupReq: MACCommandRxParamSetupReq? = null,

    @Json(name = "rx_param_setup_ans")
    val rxParamSetupAns: MACCommandRxParamSetupAns? = null,

    @Json(name = "dev_status_ans")
    val devStatusAns: MACCommandDevStatusAns? = null,

    @Json(name = "new_channel_req")
    val newChannelReq: MACCommandNewChannelReq? = null,

    @Json(name = "new_channel_ans")
    val newChannelAns: MACCommandNewChannelAns? = null,

    @Json(name = "dl_channel_req")
    val dlChannelReq: MACCommandDLChannelReq? = null,

    @Json(name = "dl_channel_ans")
    val dlChannelAns: MACCommandDLChannelAns? = null,

    @Json(name = "rx_timing_setup_req")
    val rxTimingSetupReq: MACCommandRxTimingSetupReq? = null,

    @Json(name = "tx_param_setup_req")
    val txParamSetupReq: MACCommandTxParamSetupReq? = null,

    @Json(name = "rekey_ind")
    val rekeyInd: MACCommandRekeyInd? = null,

    @Json(name = "rekey_conf")
    val rekeyConf: MACCommandRekeyConf? = null,

    @Json(name = "adr_param_setup_req")
    val adrParamSetupReq: MACCommandADRParamSetupReq? = null,

    @Json(name = "device_time_ans")
    val deviceTimeAns: MACCommandDeviceTimeAns? = null,

    @Json(name = "force_rejoin_req")
    val forceRejoinReq: MACCommandForceRejoinReq? = null,

    @Json(name = "rejoin_param_setup_req")
    val rejoinParamSetupReq: MACCommandRejoinParamSetupReq? = null,

    @Json(name = "rejoin_param_setup_ans")
    val rejoinParamSetupAns: MACCommandRejoinParamSetupAns? = null,

    @Json(name = "ping_slot_info_req")
    val pingSlotInfoReq: MACCommandPingSlotInfoReq? = null,

    @Json(name = "ping_slot_channel_req")
    val pingSlotChannelReq: MACCommandPingSlotChannelReq? = null,

    @Json(name = "ping_slot_channel_ans")
    val pingSlotChannelAns: MACCommandPingSlotChannelAns? = null,

    @Json(name = "beacon_timing_ans")
    val beaconTimingAns: MACCommandBeaconTimingAns? = null,

    @Json(name = "beacon_freq_req")
    val beaconFreqReq: MACCommandBeaconFreqReq? = null,

    @Json(name = "beacon_freq_ans")
    val beaconFreqAns: MACCommandBeaconFreqAns? = null,

    @Json(name = "device_mode_ind")
    val deviceModeInd: MACCommandDeviceModeInd? = null,

    @Json(name = "device_mode_conf")
    val deviceModeConf: MACCommandDeviceModeConf? = null

)

