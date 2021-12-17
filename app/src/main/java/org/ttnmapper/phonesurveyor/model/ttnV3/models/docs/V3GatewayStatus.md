
# V3GatewayStatus

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**bootTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**versions** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |  [optional]
**antennaLocations** | [**kotlin.collections.List&lt;Lorawanv3Location&gt;**](Lorawanv3Location.md) |  |  [optional]
**ip** | **kotlin.collections.List&lt;kotlin.String&gt;** | IP addresses of this gateway. Repeated addresses can be used to communicate addresses of multiple interfaces (LAN, Public IP, ...). |  [optional]
**metrics** | **kotlin.collections.Map&lt;kotlin.String, kotlin.Float&gt;** |  |  [optional]
**advanced** | [**kotlin.Any**](.md) |  |  [optional]



