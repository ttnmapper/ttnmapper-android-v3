# AsEndDeviceRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**asEndDeviceRegistryDelete**](AsEndDeviceRegistryApi.md#asEndDeviceRegistryDelete) | **DELETE** /as/applications/{application_ids.application_id}/devices/{device_id} | Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.
[**asEndDeviceRegistryGet**](AsEndDeviceRegistryApi.md#asEndDeviceRegistryGet) | **GET** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.
[**asEndDeviceRegistrySet**](AsEndDeviceRegistryApi.md#asEndDeviceRegistrySet) | **PUT** /as/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Set creates or updates the device.
[**asEndDeviceRegistrySet2**](AsEndDeviceRegistryApi.md#asEndDeviceRegistrySet2) | **POST** /as/applications/{end_device.ids.application_ids.application_id}/devices | Set creates or updates the device.


<a name="asEndDeviceRegistryDelete"></a>
# **asEndDeviceRegistryDelete**
> kotlin.Any asEndDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)

Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsEndDeviceRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val deviceId : kotlin.String = deviceId_example // kotlin.String | 
val devEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val joinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val devAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : kotlin.Any = apiInstance.asEndDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistryDelete")
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

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="asEndDeviceRegistryGet"></a>
# **asEndDeviceRegistryGet**
> V3EndDevice asEndDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)

Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3EndDevice = apiInstance.asEndDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **endDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **endDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **endDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3EndDevice**](V3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="asEndDeviceRegistrySet"></a>
# **asEndDeviceRegistrySet**
> V3EndDevice asEndDeviceRegistrySet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Set creates or updates the device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3SetEndDeviceRequest =  // V3SetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.asEndDeviceRegistrySet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistrySet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistrySet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3SetEndDeviceRequest**](V3SetEndDeviceRequest.md)|  |

### Return type

[**V3EndDevice**](V3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="asEndDeviceRegistrySet2"></a>
# **asEndDeviceRegistrySet2**
> V3EndDevice asEndDeviceRegistrySet2(endDeviceIdsApplicationIdsApplicationId, body)

Set creates or updates the device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val body : V3SetEndDeviceRequest =  // V3SetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.asEndDeviceRegistrySet2(endDeviceIdsApplicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistrySet2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsEndDeviceRegistryApi#asEndDeviceRegistrySet2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3SetEndDeviceRequest**](V3SetEndDeviceRequest.md)|  |

### Return type

[**V3EndDevice**](V3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

