
# V3TxRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**propertyClass** | [**V3Class**](V3Class.md) |  |  [optional]
**downlinkPaths** | [**kotlin.collections.List&lt;V3DownlinkPath&gt;**](V3DownlinkPath.md) | Downlink paths used to select a gateway for downlink. In class A, the downlink paths are required to only contain uplink tokens. In class B and C, the downlink paths may contain uplink tokens and fixed gateways antenna identifiers. |  [optional]
**rx1Delay** | [**V3RxDelay**](V3RxDelay.md) |  |  [optional]
**rx1DataRate** | [**V3DataRate**](V3DataRate.md) |  |  [optional]
**rx1Frequency** | **kotlin.String** | Frequency (Hz) for Rx1. |  [optional]
**rx2DataRate** | [**V3DataRate**](V3DataRate.md) |  |  [optional]
**rx2Frequency** | **kotlin.String** | Frequency (Hz) for Rx2. |  [optional]
**priority** | [**V3TxSchedulePriority**](V3TxSchedulePriority.md) |  |  [optional]
**absoluteTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time when the downlink message should be transmitted. This value is only valid for class C downlink; class A downlink uses uplink tokens and class B downlink is scheduled on ping slots. This requires the gateway to have GPS time sychronization. If the absolute time is not set, the first available time will be used that does not conflict or violate regional limitations. |  [optional]
**frequencyPlanId** | **kotlin.String** | Frequency plan ID from which the frequencies in this message are retrieved. |  [optional]
**advanced** | [**kotlin.Any**](.md) |  |  [optional]



