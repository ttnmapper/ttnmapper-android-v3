# AppAsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**appAsDecodeDownlink**](AppAsApi.md#appAsDecodeDownlink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/decode | 
[**appAsDecodeUplink**](AppAsApi.md#appAsDecodeUplink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/up/decode | 
[**appAsDownlinkQueueList**](AppAsApi.md#appAsDownlinkQueueList) | **GET** /as/applications/{application_ids.application_id}/devices/{device_id}/down | List the items currently in the downlink queue.
[**appAsDownlinkQueuePush**](AppAsApi.md#appAsDownlinkQueuePush) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/push | Push downlink messages to the end of the downlink queue.
[**appAsDownlinkQueueReplace**](AppAsApi.md#appAsDownlinkQueueReplace) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/replace | Replace the entire downlink queue with the specified messages. This can also be used to empty the queue by specifying no messages.
[**appAsEncodeDownlink**](AppAsApi.md#appAsEncodeDownlink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/encode | 
[**appAsGetMQTTConnectionInfo**](AppAsApi.md#appAsGetMQTTConnectionInfo) | **GET** /as/applications/{application_id}/mqtt-connection-info | Get connection information to connect an MQTT client.
[**appAsSimulateUplink**](AppAsApi.md#appAsSimulateUplink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/up/simulate | Simulate an upstream message. This can be used to test integrations.


<a name="appAsDecodeDownlink"></a>
# **appAsDecodeDownlink**
> V3DecodeDownlinkResponse appAsDecodeDownlink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3DecodeDownlinkRequest =  // V3DecodeDownlinkRequest | 
try {
    val result : V3DecodeDownlinkResponse = apiInstance.appAsDecodeDownlink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsDecodeDownlink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsDecodeDownlink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3DecodeDownlinkRequest**](V3DecodeDownlinkRequest.md)|  |

### Return type

[**V3DecodeDownlinkResponse**](V3DecodeDownlinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="appAsDecodeUplink"></a>
# **appAsDecodeUplink**
> V3DecodeUplinkResponse appAsDecodeUplink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3DecodeUplinkRequest =  // V3DecodeUplinkRequest | 
try {
    val result : V3DecodeUplinkResponse = apiInstance.appAsDecodeUplink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsDecodeUplink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsDecodeUplink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3DecodeUplinkRequest**](V3DecodeUplinkRequest.md)|  |

### Return type

[**V3DecodeUplinkResponse**](V3DecodeUplinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="appAsDownlinkQueueList"></a>
# **appAsDownlinkQueueList**
> V3ApplicationDownlinks appAsDownlinkQueueList(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)

List the items currently in the downlink queue.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val deviceId : kotlin.String = deviceId_example // kotlin.String | 
val devEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val joinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val devAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : V3ApplicationDownlinks = apiInstance.appAsDownlinkQueueList(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsDownlinkQueueList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsDownlinkQueueList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **deviceId** | **kotlin.String**|  |
 **devEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **joinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **devAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]

### Return type

[**V3ApplicationDownlinks**](V3ApplicationDownlinks.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="appAsDownlinkQueuePush"></a>
# **appAsDownlinkQueuePush**
> kotlin.Any appAsDownlinkQueuePush(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Push downlink messages to the end of the downlink queue.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3DownlinkQueueRequest =  // V3DownlinkQueueRequest | 
try {
    val result : kotlin.Any = apiInstance.appAsDownlinkQueuePush(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsDownlinkQueuePush")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsDownlinkQueuePush")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3DownlinkQueueRequest**](V3DownlinkQueueRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="appAsDownlinkQueueReplace"></a>
# **appAsDownlinkQueueReplace**
> kotlin.Any appAsDownlinkQueueReplace(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Replace the entire downlink queue with the specified messages. This can also be used to empty the queue by specifying no messages.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3DownlinkQueueRequest =  // V3DownlinkQueueRequest | 
try {
    val result : kotlin.Any = apiInstance.appAsDownlinkQueueReplace(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsDownlinkQueueReplace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsDownlinkQueueReplace")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3DownlinkQueueRequest**](V3DownlinkQueueRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="appAsEncodeDownlink"></a>
# **appAsEncodeDownlink**
> V3EncodeDownlinkResponse appAsEncodeDownlink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3EncodeDownlinkRequest =  // V3EncodeDownlinkRequest | 
try {
    val result : V3EncodeDownlinkResponse = apiInstance.appAsEncodeDownlink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsEncodeDownlink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsEncodeDownlink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3EncodeDownlinkRequest**](V3EncodeDownlinkRequest.md)|  |

### Return type

[**V3EncodeDownlinkResponse**](V3EncodeDownlinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="appAsGetMQTTConnectionInfo"></a>
# **appAsGetMQTTConnectionInfo**
> V3MQTTConnectionInfo appAsGetMQTTConnectionInfo(applicationId)

Get connection information to connect an MQTT client.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : V3MQTTConnectionInfo = apiInstance.appAsGetMQTTConnectionInfo(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsGetMQTTConnectionInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsGetMQTTConnectionInfo")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**V3MQTTConnectionInfo**](V3MQTTConnectionInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="appAsSimulateUplink"></a>
# **appAsSimulateUplink**
> kotlin.Any appAsSimulateUplink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Simulate an upstream message. This can be used to test integrations.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AppAsApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3ApplicationUp =  // V3ApplicationUp | 
try {
    val result : kotlin.Any = apiInstance.appAsSimulateUplink(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AppAsApi#appAsSimulateUplink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AppAsApi#appAsSimulateUplink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3ApplicationUp**](V3ApplicationUp.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

