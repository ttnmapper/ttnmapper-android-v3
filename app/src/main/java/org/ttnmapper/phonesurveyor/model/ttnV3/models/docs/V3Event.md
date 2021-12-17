
# V3Event

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **kotlin.String** | Name of the event. This can be used to find the (localized) event description. |  [optional]
**time** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time at which the event was triggered. |  [optional]
**identifiers** | [**kotlin.collections.List&lt;V3EntityIdentifiers&gt;**](V3EntityIdentifiers.md) | Identifiers of the entity (or entities) involved. |  [optional]
**&#x60;data&#x60;** | [**ProtobufAny**](ProtobufAny.md) |  |  [optional]
**correlationIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Correlation IDs can be used to find related events and actions such as API calls. |  [optional]
**origin** | **kotlin.String** | The origin of the event. Typically the hostname of the server that created it. |  [optional]
**context** | **kotlin.collections.Map&lt;kotlin.String, kotlin.ByteArray&gt;** | Event context, internal use only. |  [optional]
**visibility** | [**V3Rights**](V3Rights.md) |  |  [optional]
**authentication** | [**EventAuthentication**](EventAuthentication.md) |  |  [optional]
**remoteIp** | **kotlin.String** | The IP address of the caller that triggered this event. |  [optional]
**userAgent** | **kotlin.String** | The IP address of the caller that triggered this event. |  [optional]
**uniqueId** | **kotlin.String** | The unique identifier of the event, assigned on creation. |  [optional]



