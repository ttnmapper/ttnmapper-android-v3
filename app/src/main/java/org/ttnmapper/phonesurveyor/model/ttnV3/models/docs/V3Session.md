
# V3Session

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**devAddr** | **kotlin.ByteArray** | Device Address, issued by the Network Server or chosen by device manufacturer in case of testing range (beginning with 00-03). Known by Network Server, Application Server and Join Server. Owned by Network Server. |  [optional]
**propertyKeys** | [**V3SessionKeys**](V3SessionKeys.md) |  |  [optional]
**lastFCntUp** | **kotlin.Long** | Last uplink frame counter value used. Network Server only. Application Server assumes the Network Server checked it. |  [optional]
**lastNFCntDown** | **kotlin.Long** | Last network downlink frame counter value used. Network Server only. |  [optional]
**lastAFCntDown** | **kotlin.Long** | Last application downlink frame counter value used. Application Server only. |  [optional]
**lastConfFCntDown** | **kotlin.Long** | Frame counter of the last confirmed downlink message sent. Network Server only. |  [optional]
**startedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time when the session started. Network Server only. |  [optional]
**queuedApplicationDownlinks** | [**kotlin.collections.List&lt;V3ApplicationDownlink&gt;**](V3ApplicationDownlink.md) | Queued Application downlink messages. Stored in Application Server and Network Server. |  [optional]



