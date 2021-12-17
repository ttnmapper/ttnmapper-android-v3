
# V3ApplicationUp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**endDeviceIds** | [**V3EndDeviceIdentifiers**](V3EndDeviceIdentifiers.md) |  |  [optional]
**correlationIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**receivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Server time when the Application Server received the message. |  [optional]
**uplinkMessage** | [**V3ApplicationUplink**](V3ApplicationUplink.md) |  |  [optional]
**joinAccept** | [**V3ApplicationJoinAccept**](V3ApplicationJoinAccept.md) |  |  [optional]
**downlinkAck** | [**V3ApplicationDownlink**](V3ApplicationDownlink.md) |  |  [optional]
**downlinkNack** | [**V3ApplicationDownlink**](V3ApplicationDownlink.md) |  |  [optional]
**downlinkSent** | [**V3ApplicationDownlink**](V3ApplicationDownlink.md) |  |  [optional]
**downlinkFailed** | [**V3ApplicationDownlinkFailed**](V3ApplicationDownlinkFailed.md) |  |  [optional]
**downlinkQueued** | [**V3ApplicationDownlink**](V3ApplicationDownlink.md) |  |  [optional]
**downlinkQueueInvalidated** | [**V3ApplicationInvalidatedDownlinks**](V3ApplicationInvalidatedDownlinks.md) |  |  [optional]
**locationSolved** | [**V3ApplicationLocation**](V3ApplicationLocation.md) |  |  [optional]
**serviceData** | [**V3ApplicationServiceData**](V3ApplicationServiceData.md) |  |  [optional]
**simulated** | **kotlin.Boolean** | Signals if the message is coming from the Network Server or is simulated. |  [optional]



