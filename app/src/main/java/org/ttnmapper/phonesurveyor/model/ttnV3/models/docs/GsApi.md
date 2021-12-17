# GsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gsGetGatewayConnectionStats**](GsApi.md#gsGetGatewayConnectionStats) | **GET** /gs/gateways/{gateway_id}/connection/stats | Get statistics about the current gateway connection to the Gateway Server. This is not persisted between reconnects.


<a name="gsGetGatewayConnectionStats"></a>
# **gsGetGatewayConnectionStats**
> V3GatewayConnectionStats gsGetGatewayConnectionStats(gatewayId, eui)

Get statistics about the current gateway connection to the Gateway Server. This is not persisted between reconnects.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GsApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GatewayConnectionStats = apiInstance.gsGetGatewayConnectionStats(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GsApi#gsGetGatewayConnectionStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GsApi#gsGetGatewayConnectionStats")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3GatewayConnectionStats**](V3GatewayConnectionStats.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

