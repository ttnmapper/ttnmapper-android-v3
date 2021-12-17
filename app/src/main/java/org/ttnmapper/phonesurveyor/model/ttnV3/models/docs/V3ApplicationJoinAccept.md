
# V3ApplicationJoinAccept

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sessionKeyId** | **kotlin.ByteArray** | Join Server issued identifier for the session keys negotiated in this join. |  [optional]
**appSKey** | [**V3KeyEnvelope**](V3KeyEnvelope.md) |  |  [optional]
**invalidatedDownlinks** | [**kotlin.collections.List&lt;V3ApplicationDownlink&gt;**](V3ApplicationDownlink.md) | Downlink messages in the queue that got invalidated because of the session change. |  [optional]
**pendingSession** | **kotlin.Boolean** | Indicates whether the security context refers to the pending session, i.e. when this join-accept is an answer to a rejoin-request. |  [optional]
**receivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Server time when the Network Server received the message. |  [optional]



