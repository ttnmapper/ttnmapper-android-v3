
# V3ErrorDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **kotlin.String** | Namespace of the error (typically the package name in The Things Stack). |  [optional]
**name** | **kotlin.String** | Name of the error. |  [optional]
**messageFormat** | **kotlin.String** | The default (fallback) message format that should be used for the error. This is also used if the client does not have a translation for the error. |  [optional]
**attributes** | [**kotlin.Any**](.md) | Attributes that should be filled into the message format. Any extra attributes can be displayed as error details. |  [optional]
**correlationId** | **kotlin.String** | The correlation ID of the error can be used to correlate the error to stack traces the network may (or may not) store about recent errors. |  [optional]
**cause** | [**V3ErrorDetails**](V3ErrorDetails.md) |  |  [optional]
**code** | **kotlin.Long** | The status code of the error. |  [optional]
**details** | [**kotlin.collections.List&lt;ProtobufAny&gt;**](ProtobufAny.md) | The details of the error. |  [optional]



