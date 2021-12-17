
# V3ApplicationLinkStats

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**linkedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**networkServerAddress** | **kotlin.String** |  |  [optional]
**lastUpReceivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Timestamp when the last upstream message has been received from a Network Server. This can be a join-accept, uplink message or downlink message event. |  [optional]
**upCount** | **kotlin.String** | Number of upstream messages received. |  [optional]
**lastDownlinkForwardedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Timestamp when the last downlink message has been forwarded to a Network Server. |  [optional]
**downlinkCount** | **kotlin.String** | Number of downlink messages forwarded. |  [optional]



