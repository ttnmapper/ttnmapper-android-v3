
# V3GatewayConnectionStats

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**connectedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**protocol** | **kotlin.String** |  |  [optional]
**lastStatusReceivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**lastStatus** | [**V3GatewayStatus**](V3GatewayStatus.md) |  |  [optional]
**lastUplinkReceivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**uplinkCount** | **kotlin.String** |  |  [optional]
**lastDownlinkReceivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**downlinkCount** | **kotlin.String** |  |  [optional]
**roundTripTimes** | [**GatewayConnectionStatsRoundTripTimes**](GatewayConnectionStatsRoundTripTimes.md) |  |  [optional]
**subBands** | [**kotlin.collections.List&lt;GatewayConnectionStatsSubBand&gt;**](GatewayConnectionStatsSubBand.md) | Statistics for each sub band. |  [optional]



