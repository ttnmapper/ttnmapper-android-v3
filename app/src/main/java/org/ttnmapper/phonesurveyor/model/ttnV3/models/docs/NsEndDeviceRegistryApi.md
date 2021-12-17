# NsEndDeviceRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**nsEndDeviceRegistryDelete**](NsEndDeviceRegistryApi.md#nsEndDeviceRegistryDelete) | **DELETE** /ns/applications/{application_ids.application_id}/devices/{device_id} | Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.
[**nsEndDeviceRegistryGet**](NsEndDeviceRegistryApi.md#nsEndDeviceRegistryGet) | **GET** /ns/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.
[**nsEndDeviceRegistryResetFactoryDefaults**](NsEndDeviceRegistryApi.md#nsEndDeviceRegistryResetFactoryDefaults) | **PATCH** /ns/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | ResetFactoryDefaults resets device state to factory defaults.
[**nsEndDeviceRegistrySet**](NsEndDeviceRegistryApi.md#nsEndDeviceRegistrySet) | **PUT** /ns/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Set creates or updates the device.
[**nsEndDeviceRegistrySet2**](NsEndDeviceRegistryApi.md#nsEndDeviceRegistrySet2) | **POST** /ns/applications/{end_device.ids.application_ids.application_id}/devices | Set creates or updates the device.


<a name="nsEndDeviceRegistryDelete"></a>
# **nsEndDeviceRegistryDelete**
> kotlin.Any nsEndDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)

Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsEndDeviceRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val deviceId : kotlin.String = deviceId_example // kotlin.String | 
val devEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val joinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val devAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : kotlin.Any = apiInstance.nsEndDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistryDelete")
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

<a name="nsEndDeviceRegistryGet"></a>
# **nsEndDeviceRegistryGet**
> V3EndDevice nsEndDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)

Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3EndDevice = apiInstance.nsEndDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistryGet")
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

<a name="nsEndDeviceRegistryResetFactoryDefaults"></a>
# **nsEndDeviceRegistryResetFactoryDefaults**
> V3EndDevice nsEndDeviceRegistryResetFactoryDefaults(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

ResetFactoryDefaults resets device state to factory defaults.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3ResetAndGetEndDeviceRequest =  // V3ResetAndGetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.nsEndDeviceRegistryResetFactoryDefaults(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistryResetFactoryDefaults")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistryResetFactoryDefaults")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3ResetAndGetEndDeviceRequest**](V3ResetAndGetEndDeviceRequest.md)|  |

### Return type

[**V3EndDevice**](V3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="nsEndDeviceRegistrySet"></a>
# **nsEndDeviceRegistrySet**
> V3EndDevice nsEndDeviceRegistrySet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Set creates or updates the device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3SetEndDeviceRequest =  // V3SetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.nsEndDeviceRegistrySet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistrySet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistrySet")
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

<a name="nsEndDeviceRegistrySet2"></a>
# **nsEndDeviceRegistrySet2**
> V3EndDevice nsEndDeviceRegistrySet2(endDeviceIdsApplicationIdsApplicationId, body)

Set creates or updates the device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val body : V3SetEndDeviceRequest =  // V3SetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.nsEndDeviceRegistrySet2(endDeviceIdsApplicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistrySet2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsEndDeviceRegistryApi#nsEndDeviceRegistrySet2")
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

