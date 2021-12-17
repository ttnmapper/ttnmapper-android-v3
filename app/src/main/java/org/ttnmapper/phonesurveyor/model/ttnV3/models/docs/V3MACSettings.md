
# V3MACSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**classBTimeout** | **kotlin.String** | Maximum delay for the device to answer a MAC request or a confirmed downlink frame. If unset, the default value from Network Server configuration will be used. |  [optional]
**pingSlotPeriodicity** | [**V3PingSlotPeriodValue**](V3PingSlotPeriodValue.md) |  |  [optional]
**pingSlotDataRateIndex** | [**V3DataRateIndexValue**](V3DataRateIndexValue.md) |  |  [optional]
**pingSlotFrequency** | [**V3FrequencyValue**](V3FrequencyValue.md) |  |  [optional]
**beaconFrequency** | [**V3FrequencyValue**](V3FrequencyValue.md) |  |  [optional]
**classCTimeout** | **kotlin.String** | Maximum delay for the device to answer a MAC request or a confirmed downlink frame. If unset, the default value from Network Server configuration will be used. |  [optional]
**rx1Delay** | [**V3RxDelayValue**](V3RxDelayValue.md) |  |  [optional]
**rx1DataRateOffset** | [**V3DataRateOffsetValue**](V3DataRateOffsetValue.md) |  |  [optional]
**rx2DataRateIndex** | [**V3DataRateIndexValue**](V3DataRateIndexValue.md) |  |  [optional]
**rx2Frequency** | [**V3FrequencyValue**](V3FrequencyValue.md) |  |  [optional]
**factoryPresetFrequencies** | **kotlin.collections.List&lt;kotlin.String&gt;** | List of factory-preset frequencies. If unset, the default value from Network Server configuration or regional parameters specification will be used. |  [optional]
**maxDutyCycle** | [**V3AggregatedDutyCycleValue**](V3AggregatedDutyCycleValue.md) |  |  [optional]
**supports32BitFCnt** | [**Lorawanv3BoolValue**](Lorawanv3BoolValue.md) |  |  [optional]
**useAdr** | [**Lorawanv3BoolValue**](Lorawanv3BoolValue.md) |  |  [optional]
**adrMargin** | **kotlin.Float** | The ADR margin tells the network server how much margin it should add in ADR requests. A bigger margin is less efficient, but gives a better chance of successful reception. If unset, the default value from Network Server configuration will be used. |  [optional]
**resetsFCnt** | [**Lorawanv3BoolValue**](Lorawanv3BoolValue.md) |  |  [optional]
**statusTimePeriodicity** | **kotlin.String** | The interval after which a DevStatusReq MACCommand shall be sent. If unset, the default value from Network Server configuration will be used. |  [optional]
**statusCountPeriodicity** | **kotlin.Long** | Number of uplink messages after which a DevStatusReq MACCommand shall be sent. If unset, the default value from Network Server configuration will be used. |  [optional]
**desiredRx1Delay** | [**V3RxDelayValue**](V3RxDelayValue.md) |  |  [optional]
**desiredRx1DataRateOffset** | [**V3DataRateOffsetValue**](V3DataRateOffsetValue.md) |  |  [optional]
**desiredRx2DataRateIndex** | [**V3DataRateIndexValue**](V3DataRateIndexValue.md) |  |  [optional]
**desiredRx2Frequency** | [**V3FrequencyValue**](V3FrequencyValue.md) |  |  [optional]
**desiredMaxDutyCycle** | [**V3AggregatedDutyCycleValue**](V3AggregatedDutyCycleValue.md) |  |  [optional]
**desiredAdrAckLimitExponent** | [**V3ADRAckLimitExponentValue**](V3ADRAckLimitExponentValue.md) |  |  [optional]
**desiredAdrAckDelayExponent** | [**V3ADRAckDelayExponentValue**](V3ADRAckDelayExponentValue.md) |  |  [optional]
**desiredPingSlotDataRateIndex** | [**V3DataRateIndexValue**](V3DataRateIndexValue.md) |  |  [optional]
**desiredPingSlotFrequency** | [**V3FrequencyValue**](V3FrequencyValue.md) |  |  [optional]
**desiredBeaconFrequency** | [**V3FrequencyValue**](V3FrequencyValue.md) |  |  [optional]
**desiredMaxEirp** | [**V3DeviceEIRPValue**](V3DeviceEIRPValue.md) |  |  [optional]
**classBCDownlinkInterval** | **kotlin.String** | The minimum duration passed before a network-initiated(e.g. Class B or C) downlink following an arbitrary downlink. |  [optional]



