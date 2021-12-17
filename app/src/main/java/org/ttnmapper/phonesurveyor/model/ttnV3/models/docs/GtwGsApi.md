# GtwGsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gtwGsGetMQTTConnectionInfo**](GtwGsApi.md#gtwGsGetMQTTConnectionInfo) | **GET** /gs/gateways/{gateway_id}/mqtt-connection-info | Get connection information to connect an MQTT gateway.
[**gtwGsGetMQTTV2ConnectionInfo**](GtwGsApi.md#gtwGsGetMQTTV2ConnectionInfo) | **GET** /gs/gateways/{gateway_id}/mqttv2-connection-info | Get legacy connection information to connect a The Things Network Stack V2 MQTT gateway.


<a name="gtwGsGetMQTTConnectionInfo"></a>
# **gtwGsGetMQTTConnectionInfo**
> V3MQTTConnectionInfo gtwGsGetMQTTConnectionInfo(gatewayId, eui)

Get connection information to connect an MQTT gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GtwGsApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3MQTTConnectionInfo = apiInstance.gtwGsGetMQTTConnectionInfo(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GtwGsApi#gtwGsGetMQTTConnectionInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GtwGsApi#gtwGsGetMQTTConnectionInfo")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3MQTTConnectionInfo**](V3MQTTConnectionInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gtwGsGetMQTTV2ConnectionInfo"></a>
# **gtwGsGetMQTTV2ConnectionInfo**
> V3MQTTConnectionInfo gtwGsGetMQTTV2ConnectionInfo(gatewayId, eui)

Get legacy connection information to connect a The Things Network Stack V2 MQTT gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GtwGsApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3MQTTConnectionInfo = apiInstance.gtwGsGetMQTTV2ConnectionInfo(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GtwGsApi#gtwGsGetMQTTV2ConnectionInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GtwGsApi#gtwGsGetMQTTV2ConnectionInfo")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3MQTTConnectionInfo**](V3MQTTConnectionInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

