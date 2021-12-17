
# V3UplinkMessage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rawPayload** | **kotlin.ByteArray** |  |  [optional]
**payload** | [**Lorawanv3Message**](Lorawanv3Message.md) |  |  [optional]
**settings** | [**V3TxSettings**](V3TxSettings.md) |  |  [optional]
**rxMetadata** | [**kotlin.collections.List&lt;V3RxMetadata&gt;**](V3RxMetadata.md) |  |  [optional]
**receivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Server time when a component received the message. The Gateway Server and Network Server set this value to their local server time of reception. |  [optional]
**correlationIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**deviceChannelIndex** | **kotlin.Long** | Index of the device channel that received the message. Set by Network Server. |  [optional]
**consumedAirtime** | **kotlin.String** | Consumed airtime for the transmission of the uplink message. Calculated by Network Server using the RawPayload size and the transmission settings. |  [optional]



