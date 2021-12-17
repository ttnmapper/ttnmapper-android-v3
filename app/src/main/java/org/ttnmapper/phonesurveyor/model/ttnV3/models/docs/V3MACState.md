
# V3MACState

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currentParameters** | [**V3MACParameters**](V3MACParameters.md) |  |  [optional]
**desiredParameters** | [**V3MACParameters**](V3MACParameters.md) |  |  [optional]
**deviceClass** | [**V3Class**](V3Class.md) |  |  [optional]
**lorawanVersion** | [**V3MACVersion**](V3MACVersion.md) |  |  [optional]
**lastConfirmedDownlinkAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time when the last confirmed downlink message or MAC command was scheduled. |  [optional]
**lastDevStatusFCntUp** | **kotlin.Long** | Frame counter value of last uplink containing DevStatusAns. |  [optional]
**pingSlotPeriodicity** | [**V3PingSlotPeriodValue**](V3PingSlotPeriodValue.md) |  |  [optional]
**pendingApplicationDownlink** | [**V3ApplicationDownlink**](V3ApplicationDownlink.md) |  |  [optional]
**queuedResponses** | [**kotlin.collections.List&lt;V3MACCommand&gt;**](V3MACCommand.md) | Queued MAC responses. Regenerated on each uplink. |  [optional]
**pendingRequests** | [**kotlin.collections.List&lt;V3MACCommand&gt;**](V3MACCommand.md) | Pending MAC requests(i.e. sent requests, for which no response has been received yet). Regenerated on each downlink. |  [optional]
**queuedJoinAccept** | [**MACStateJoinAccept**](MACStateJoinAccept.md) |  |  [optional]
**pendingJoinRequest** | [**V3MACStateJoinRequest**](V3MACStateJoinRequest.md) |  |  [optional]
**rxWindowsAvailable** | **kotlin.Boolean** | Whether or not Rx windows are expected to be open. Set to true every time an uplink is received. Set to false every time a successful downlink scheduling attempt is made. |  [optional]
**recentUplinks** | [**kotlin.collections.List&lt;V3UplinkMessage&gt;**](V3UplinkMessage.md) | Recent data uplink messages sorted by time. The number of messages stored may depend on configuration. |  [optional]
**recentDownlinks** | [**kotlin.collections.List&lt;V3DownlinkMessage&gt;**](V3DownlinkMessage.md) | Recent data downlink messages sorted by time. The number of messages stored may depend on configuration. |  [optional]
**lastNetworkInitiatedDownlinkAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time when the last network-initiated downlink message was scheduled. |  [optional]
**rejectedAdrDataRateIndexes** | [**kotlin.collections.List&lt;V3DataRateIndex&gt;**](V3DataRateIndex.md) | ADR Data rate index values rejected by the device. Reset each time &#x60;current_parameters.channels&#x60; change. Elements are sorted in ascending order. |  [optional]
**rejectedAdrTxPowerIndexes** | **kotlin.collections.List&lt;kotlin.Long&gt;** | ADR TX output power index values rejected by the device. Elements are sorted in ascending order. |  [optional]
**rejectedFrequencies** | **kotlin.collections.List&lt;kotlin.String&gt;** | Frequencies rejected by the device. |  [optional]
**lastDownlinkAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time when the last downlink message was scheduled. |  [optional]
**rejectedDataRateRanges** | [**kotlin.collections.Map&lt;kotlin.String, MACStateDataRateRanges&gt;**](MACStateDataRateRanges.md) | Data rate ranges rejected by the device per frequency. |  [optional]
**lastAdrChangeFCntUp** | **kotlin.Long** | Frame counter of uplink, which confirmed the last ADR parameter change. |  [optional]



