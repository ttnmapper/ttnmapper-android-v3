# JsEndDeviceRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**jsEndDeviceRegistryDelete**](JsEndDeviceRegistryApi.md#jsEndDeviceRegistryDelete) | **DELETE** /js/applications/{application_ids.application_id}/devices/{device_id} | Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.
[**jsEndDeviceRegistryGet**](JsEndDeviceRegistryApi.md#jsEndDeviceRegistryGet) | **GET** /js/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.
[**jsEndDeviceRegistryProvision**](JsEndDeviceRegistryApi.md#jsEndDeviceRegistryProvision) | **PUT** /js/applications/{application_ids.application_id}/provision-devices | This rpc is deprecated; use EndDeviceTemplateConverter service instead. TODO: Remove (https://github.com/TheThingsNetwork/lorawan-stack/issues/999)
[**jsEndDeviceRegistrySet**](JsEndDeviceRegistryApi.md#jsEndDeviceRegistrySet) | **PUT** /js/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Set creates or updates the device.
[**jsEndDeviceRegistrySet2**](JsEndDeviceRegistryApi.md#jsEndDeviceRegistrySet2) | **POST** /js/applications/{end_device.ids.application_ids.application_id}/devices | Set creates or updates the device.


<a name="jsEndDeviceRegistryDelete"></a>
# **jsEndDeviceRegistryDelete**
> kotlin.Any jsEndDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)

Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = JsEndDeviceRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val deviceId : kotlin.String = deviceId_example // kotlin.String | 
val devEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val joinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val devAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : kotlin.Any = apiInstance.jsEndDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistryDelete")
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

<a name="jsEndDeviceRegistryGet"></a>
# **jsEndDeviceRegistryGet**
> V3EndDevice jsEndDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)

Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = JsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3EndDevice = apiInstance.jsEndDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistryGet")
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

<a name="jsEndDeviceRegistryProvision"></a>
# **jsEndDeviceRegistryProvision**
> StreamResultOfV3EndDevice jsEndDeviceRegistryProvision(applicationIdsApplicationId, body)

This rpc is deprecated; use EndDeviceTemplateConverter service instead. TODO: Remove (https://github.com/TheThingsNetwork/lorawan-stack/issues/999)

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = JsEndDeviceRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3ProvisionEndDevicesRequest =  // V3ProvisionEndDevicesRequest | 
try {
    val result : StreamResultOfV3EndDevice = apiInstance.jsEndDeviceRegistryProvision(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistryProvision")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistryProvision")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3ProvisionEndDevicesRequest**](V3ProvisionEndDevicesRequest.md)|  |

### Return type

[**StreamResultOfV3EndDevice**](StreamResultOfV3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jsEndDeviceRegistrySet"></a>
# **jsEndDeviceRegistrySet**
> V3EndDevice jsEndDeviceRegistrySet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Set creates or updates the device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = JsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3SetEndDeviceRequest =  // V3SetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.jsEndDeviceRegistrySet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistrySet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistrySet")
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

<a name="jsEndDeviceRegistrySet2"></a>
# **jsEndDeviceRegistrySet2**
> V3EndDevice jsEndDeviceRegistrySet2(endDeviceIdsApplicationIdsApplicationId, body)

Set creates or updates the device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = JsEndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val body : V3SetEndDeviceRequest =  // V3SetEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.jsEndDeviceRegistrySet2(endDeviceIdsApplicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistrySet2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JsEndDeviceRegistryApi#jsEndDeviceRegistrySet2")
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

