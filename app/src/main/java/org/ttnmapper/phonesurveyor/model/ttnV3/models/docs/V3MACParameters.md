
# V3MACParameters

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**maxEirp** | **kotlin.Float** | Maximum EIRP (dBm). |  [optional]
**adrDataRateIndex** | [**V3DataRateIndex**](V3DataRateIndex.md) |  |  [optional]
**adrTxPowerIndex** | **kotlin.Long** | ADR: transmission power index to use. |  [optional]
**adrNbTrans** | **kotlin.Long** | ADR: number of retransmissions. |  [optional]
**adrAckLimit** | **kotlin.Long** | ADR: number of messages to wait before setting ADRAckReq. This field is deprecated, use adr_ack_limit_exponent instead. |  [optional]
**adrAckDelay** | **kotlin.Long** | ADR: number of messages to wait after setting ADRAckReq and before changing TxPower or DataRate. This field is deprecated, use adr_ack_delay_exponent instead. |  [optional]
**rx1Delay** | [**V3RxDelay**](V3RxDelay.md) |  |  [optional]
**rx1DataRateOffset** | [**V3DataRateOffset**](V3DataRateOffset.md) |  |  [optional]
**rx2DataRateIndex** | [**V3DataRateIndex**](V3DataRateIndex.md) |  |  [optional]
**rx2Frequency** | **kotlin.String** | Frequency for Rx2 (Hz). |  [optional]
**maxDutyCycle** | [**V3AggregatedDutyCycle**](V3AggregatedDutyCycle.md) |  |  [optional]
**rejoinTimePeriodicity** | [**V3RejoinTimeExponent**](V3RejoinTimeExponent.md) |  |  [optional]
**rejoinCountPeriodicity** | [**V3RejoinCountExponent**](V3RejoinCountExponent.md) |  |  [optional]
**pingSlotFrequency** | **kotlin.String** | Frequency of the class B ping slot (Hz). |  [optional]
**pingSlotDataRateIndex** | [**V3DataRateIndex**](V3DataRateIndex.md) |  |  [optional]
**beaconFrequency** | **kotlin.String** | Frequency of the class B beacon (Hz). |  [optional]
**channels** | [**kotlin.collections.List&lt;V3MACParametersChannel&gt;**](V3MACParametersChannel.md) | Configured uplink channels and optionally Rx1 frequency. |  [optional]
**uplinkDwellTime** | [**Lorawanv3BoolValue**](Lorawanv3BoolValue.md) |  |  [optional]
**downlinkDwellTime** | [**Lorawanv3BoolValue**](Lorawanv3BoolValue.md) |  |  [optional]
**adrAckLimitExponent** | [**V3ADRAckLimitExponentValue**](V3ADRAckLimitExponentValue.md) |  |  [optional]
**adrAckDelayExponent** | [**V3ADRAckDelayExponentValue**](V3ADRAckDelayExponentValue.md) |  |  [optional]
**pingSlotDataRateIndexValue** | [**V3DataRateIndexValue**](V3DataRateIndexValue.md) |  |  [optional]



