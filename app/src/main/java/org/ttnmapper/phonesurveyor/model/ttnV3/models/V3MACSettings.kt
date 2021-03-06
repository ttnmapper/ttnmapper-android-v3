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
import org.openapitools.client.models.V3AggregatedDutyCycleValue
import org.openapitools.client.models.V3DataRateIndexValue
import org.openapitools.client.models.V3PingSlotPeriodValue
import org.openapitools.client.models.V3RxDelayValue

import com.squareup.moshi.Json

/**
 * 
 * @param classBTimeout Maximum delay for the device to answer a MAC request or a confirmed downlink frame. If unset, the default value from Network Server configuration will be used.
 * @param pingSlotPeriodicity 
 * @param pingSlotDataRateIndex 
 * @param pingSlotFrequency Frequency of the class B ping slot (Hz). If unset, the default value from Network Server configuration will be used.
 * @param beaconFrequency Frequency of the class B beacon (Hz). If unset, the default value from Network Server configuration will be used.
 * @param classCTimeout Maximum delay for the device to answer a MAC request or a confirmed downlink frame. If unset, the default value from Network Server configuration will be used.
 * @param rx1Delay 
 * @param rx1DataRateOffset Rx1 data rate offset. If unset, the default value from Network Server configuration will be used.
 * @param rx2DataRateIndex 
 * @param rx2Frequency Frequency for Rx2 (Hz). If unset, the default value from Network Server configuration or regional parameters specification will be used.
 * @param factoryPresetFrequencies List of factory-preset frequencies. If unset, the default value from Network Server configuration or regional parameters specification will be used.
 * @param maxDutyCycle 
 * @param supports32BitFCnt Whether the device supports 32-bit frame counters. If unset, the default value from Network Server configuration will be used.
 * @param useAdr Whether the Network Server should use ADR for the device. If unset, the default value from Network Server configuration will be used.
 * @param adrMargin The ADR margin tells the network server how much margin it should add in ADR requests. A bigger margin is less efficient, but gives a better chance of successful reception. If unset, the default value from Network Server configuration will be used.
 * @param resetsFCnt Whether the device resets the frame counters (not LoRaWAN compliant). If unset, the default value from Network Server configuration will be used.
 * @param statusTimePeriodicity The interval after which a DevStatusReq MACCommand shall be sent. If unset, the default value from Network Server configuration will be used.
 * @param statusCountPeriodicity Number of uplink messages after which a DevStatusReq MACCommand shall be sent. If unset, the default value from Network Server configuration will be used.
 * @param desiredRx1Delay 
 * @param desiredRx1DataRateOffset The Rx1 data rate offset Network Server should configure device to use via MAC commands or Join-Accept. If unset, the default value from Network Server configuration will be used.
 * @param desiredRx2DataRateIndex 
 * @param desiredRx2Frequency The Rx2 frequency index Network Server should configure device to use via MAC commands. If unset, the default value from frequency plan, Network Server configuration or regional parameters specification will be used.
 * @param desiredMaxDutyCycle 
 * @param desiredAdrAckLimitExponent 
 * @param desiredAdrAckDelayExponent 
 * @param desiredPingSlotDataRateIndex 
 * @param desiredPingSlotFrequency The frequency of the class B ping slot (Hz) Network Server should configure device to use via MAC commands. If unset, the default value from Network Server configuration or regional parameters specification will be used.
 * @param desiredBeaconFrequency The frequency of the class B beacon (Hz) Network Server should configure device to use via MAC commands. If unset, the default value from Network Server configuration will be used.
 */

data class V3MACSettings (
    /* Maximum delay for the device to answer a MAC request or a confirmed downlink frame. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "class_b_timeout")
    val classBTimeout: kotlin.String? = null,
    @Json(name = "ping_slot_periodicity")
    val pingSlotPeriodicity: V3PingSlotPeriodValue? = null,
    @Json(name = "ping_slot_data_rate_index")
    val pingSlotDataRateIndex: V3DataRateIndexValue? = null,
    /* Frequency of the class B ping slot (Hz). If unset, the default value from Network Server configuration will be used. */
    @Json(name = "ping_slot_frequency")
    val pingSlotFrequency: kotlin.String? = null,
    /* Frequency of the class B beacon (Hz). If unset, the default value from Network Server configuration will be used. */
    @Json(name = "beacon_frequency")
    val beaconFrequency: kotlin.String? = null,
    /* Maximum delay for the device to answer a MAC request or a confirmed downlink frame. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "class_c_timeout")
    val classCTimeout: kotlin.String? = null,
    @Json(name = "rx1_delay")
    val rx1Delay: V3RxDelayValue? = null,
    /* Rx1 data rate offset. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "rx1_data_rate_offset")
    val rx1DataRateOffset: kotlin.Long? = null,
    @Json(name = "rx2_data_rate_index")
    val rx2DataRateIndex: V3DataRateIndexValue? = null,
    /* Frequency for Rx2 (Hz). If unset, the default value from Network Server configuration or regional parameters specification will be used. */
    @Json(name = "rx2_frequency")
    val rx2Frequency: kotlin.String? = null,
    /* List of factory-preset frequencies. If unset, the default value from Network Server configuration or regional parameters specification will be used. */
    @Json(name = "factory_preset_frequencies")
    val factoryPresetFrequencies: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "max_duty_cycle")
    val maxDutyCycle: V3AggregatedDutyCycleValue? = null,
    /* Whether the device supports 32-bit frame counters. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "supports_32_bit_f_cnt")
    val supports32BitFCnt: kotlin.Boolean? = null,
    /* Whether the Network Server should use ADR for the device. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "use_adr")
    val useAdr: kotlin.Boolean? = null,
    /* The ADR margin tells the network server how much margin it should add in ADR requests. A bigger margin is less efficient, but gives a better chance of successful reception. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "adr_margin")
    val adrMargin: kotlin.Float? = null,
    /* Whether the device resets the frame counters (not LoRaWAN compliant). If unset, the default value from Network Server configuration will be used. */
    @Json(name = "resets_f_cnt")
    val resetsFCnt: kotlin.Boolean? = null,
    /* The interval after which a DevStatusReq MACCommand shall be sent. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "status_time_periodicity")
    val statusTimePeriodicity: kotlin.String? = null,
    /* Number of uplink messages after which a DevStatusReq MACCommand shall be sent. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "status_count_periodicity")
    val statusCountPeriodicity: kotlin.Long? = null,
    @Json(name = "desired_rx1_delay")
    val desiredRx1Delay: V3RxDelayValue? = null,
    /* The Rx1 data rate offset Network Server should configure device to use via MAC commands or Join-Accept. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "desired_rx1_data_rate_offset")
    val desiredRx1DataRateOffset: kotlin.Long? = null,
    @Json(name = "desired_rx2_data_rate_index")
    val desiredRx2DataRateIndex: V3DataRateIndexValue? = null,
    /* The Rx2 frequency index Network Server should configure device to use via MAC commands. If unset, the default value from frequency plan, Network Server configuration or regional parameters specification will be used. */
    @Json(name = "desired_rx2_frequency")
    val desiredRx2Frequency: kotlin.String? = null,
    @Json(name = "desired_max_duty_cycle")
    val desiredMaxDutyCycle: V3AggregatedDutyCycleValue? = null,
    @Json(name = "desired_adr_ack_limit_exponent")
    val desiredAdrAckLimitExponent: V3ADRAckLimitExponentValue? = null,
    @Json(name = "desired_adr_ack_delay_exponent")
    val desiredAdrAckDelayExponent: V3ADRAckDelayExponentValue? = null,
    @Json(name = "desired_ping_slot_data_rate_index")
    val desiredPingSlotDataRateIndex: V3DataRateIndexValue? = null,
    /* The frequency of the class B ping slot (Hz) Network Server should configure device to use via MAC commands. If unset, the default value from Network Server configuration or regional parameters specification will be used. */
    @Json(name = "desired_ping_slot_frequency")
    val desiredPingSlotFrequency: kotlin.String? = null,
    /* The frequency of the class B beacon (Hz) Network Server should configure device to use via MAC commands. If unset, the default value from Network Server configuration will be used. */
    @Json(name = "desired_beacon_frequency")
    val desiredBeaconFrequency: kotlin.String? = null
)

