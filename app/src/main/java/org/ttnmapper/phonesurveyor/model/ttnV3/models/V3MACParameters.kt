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

import org.openapitools.client.models.V3ADRAckDelayExponentValue
import org.openapitools.client.models.V3ADRAckLimitExponentValue
import org.openapitools.client.models.V3AggregatedDutyCycle
import org.openapitools.client.models.V3DataRateIndex
import org.openapitools.client.models.V3DataRateIndexValue
import org.openapitools.client.models.V3MACParametersChannel
import org.openapitools.client.models.V3RejoinCountExponent
import org.openapitools.client.models.V3RejoinTimeExponent
import org.openapitools.client.models.V3RxDelay

import com.squareup.moshi.Json

/**
 * MACParameters represent the parameters of the device's MAC layer (active or desired). This is used internally by the Network Server.
 * @param maxEirp Maximum EIRP (dBm).
 * @param adrDataRateIndex 
 * @param adrTxPowerIndex ADR: transmission power index to use.
 * @param adrNbTrans ADR: number of retransmissions.
 * @param adrAckLimit ADR: number of messages to wait before setting ADRAckReq. This field is deprecated, use adr_ack_limit_exponent instead.
 * @param adrAckDelay ADR: number of messages to wait after setting ADRAckReq and before changing TxPower or DataRate. This field is deprecated, use adr_ack_delay_exponent instead.
 * @param rx1Delay 
 * @param rx1DataRateOffset Data rate offset for Rx1.
 * @param rx2DataRateIndex 
 * @param rx2Frequency Frequency for Rx2 (Hz).
 * @param maxDutyCycle 
 * @param rejoinTimePeriodicity 
 * @param rejoinCountPeriodicity 
 * @param pingSlotFrequency Frequency of the class B ping slot (Hz).
 * @param pingSlotDataRateIndex 
 * @param beaconFrequency Frequency of the class B beacon (Hz).
 * @param channels Configured uplink channels and optionally Rx1 frequency.
 * @param uplinkDwellTime Whether uplink dwell time is set (400ms). If this field is not set, then the value is either unknown or irrelevant(Network Server cannot modify it).
 * @param downlinkDwellTime Whether downlink dwell time is set (400ms). If this field is not set, then the value is either unknown or irrelevant(Network Server cannot modify it).
 * @param adrAckLimitExponent 
 * @param adrAckDelayExponent 
 * @param pingSlotDataRateIndexValue 
 */

data class V3MACParameters (
    /* Maximum EIRP (dBm). */
    @Json(name = "max_eirp")
    val maxEirp: kotlin.Float? = null,
    @Json(name = "adr_data_rate_index")
    val adrDataRateIndex: V3DataRateIndex? = null,
    /* ADR: transmission power index to use. */
    @Json(name = "adr_tx_power_index")
    val adrTxPowerIndex: kotlin.Long? = null,
    /* ADR: number of retransmissions. */
    @Json(name = "adr_nb_trans")
    val adrNbTrans: kotlin.Long? = null,
    /* ADR: number of messages to wait before setting ADRAckReq. This field is deprecated, use adr_ack_limit_exponent instead. */
    @Json(name = "adr_ack_limit")
    val adrAckLimit: kotlin.Long? = null,
    /* ADR: number of messages to wait after setting ADRAckReq and before changing TxPower or DataRate. This field is deprecated, use adr_ack_delay_exponent instead. */
    @Json(name = "adr_ack_delay")
    val adrAckDelay: kotlin.Long? = null,
    @Json(name = "rx1_delay")
    val rx1Delay: V3RxDelay? = null,
    /* Data rate offset for Rx1. */
    @Json(name = "rx1_data_rate_offset")
    val rx1DataRateOffset: kotlin.Long? = null,
    @Json(name = "rx2_data_rate_index")
    val rx2DataRateIndex: V3DataRateIndex? = null,
    /* Frequency for Rx2 (Hz). */
    @Json(name = "rx2_frequency")
    val rx2Frequency: kotlin.String? = null,
    @Json(name = "max_duty_cycle")
    val maxDutyCycle: V3AggregatedDutyCycle? = null,
    @Json(name = "rejoin_time_periodicity")
    val rejoinTimePeriodicity: V3RejoinTimeExponent? = null,
    @Json(name = "rejoin_count_periodicity")
    val rejoinCountPeriodicity: V3RejoinCountExponent? = null,
    /* Frequency of the class B ping slot (Hz). */
    @Json(name = "ping_slot_frequency")
    val pingSlotFrequency: kotlin.String? = null,
    @Json(name = "ping_slot_data_rate_index")
    val pingSlotDataRateIndex: V3DataRateIndex? = null,
    /* Frequency of the class B beacon (Hz). */
    @Json(name = "beacon_frequency")
    val beaconFrequency: kotlin.String? = null,
    /* Configured uplink channels and optionally Rx1 frequency. */
    @Json(name = "channels")
    val channels: kotlin.collections.List<V3MACParametersChannel>? = null,
    /* Whether uplink dwell time is set (400ms). If this field is not set, then the value is either unknown or irrelevant(Network Server cannot modify it). */
    @Json(name = "uplink_dwell_time")
    val uplinkDwellTime: kotlin.Boolean? = null,
    /* Whether downlink dwell time is set (400ms). If this field is not set, then the value is either unknown or irrelevant(Network Server cannot modify it). */
    @Json(name = "downlink_dwell_time")
    val downlinkDwellTime: kotlin.Boolean? = null,
    @Json(name = "adr_ack_limit_exponent")
    val adrAckLimitExponent: V3ADRAckLimitExponentValue? = null,
    @Json(name = "adr_ack_delay_exponent")
    val adrAckDelayExponent: V3ADRAckDelayExponentValue? = null,
    @Json(name = "ping_slot_data_rate_index_value")
    val pingSlotDataRateIndexValue: V3DataRateIndexValue? = null
)

