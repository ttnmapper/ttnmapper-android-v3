# EndDeviceRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**endDeviceRegistryCreate**](EndDeviceRegistryApi.md#endDeviceRegistryCreate) | **POST** /applications/{end_device.ids.application_ids.application_id}/devices | Create a new end device within an application.
[**endDeviceRegistryDelete**](EndDeviceRegistryApi.md#endDeviceRegistryDelete) | **DELETE** /applications/{application_ids.application_id}/devices/{device_id} | Delete the end device with the given IDs.
[**endDeviceRegistryGet**](EndDeviceRegistryApi.md#endDeviceRegistryGet) | **GET** /applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get the end device with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**endDeviceRegistryList**](EndDeviceRegistryApi.md#endDeviceRegistryList) | **GET** /applications/{application_ids.application_id}/devices | List end devices in the given application. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**endDeviceRegistryUpdate**](EndDeviceRegistryApi.md#endDeviceRegistryUpdate) | **PUT** /applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Update the end device, changing the fields specified by the field mask to the provided values.


<a name="endDeviceRegistryCreate"></a>
# **endDeviceRegistryCreate**
> V3EndDevice endDeviceRegistryCreate(endDeviceIdsApplicationIdsApplicationId, body)

Create a new end device within an application.

After registering an end device, it also needs to be registered in the NsEndDeviceRegistry that is exposed by the Network Server, the AsEndDeviceRegistry that is exposed by the Application Server, and the JsEndDeviceRegistry that is exposed by the Join Server.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val body : V3CreateEndDeviceRequest =  // V3CreateEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.endDeviceRegistryCreate(endDeviceIdsApplicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceRegistryApi#endDeviceRegistryCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceRegistryApi#endDeviceRegistryCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3CreateEndDeviceRequest**](V3CreateEndDeviceRequest.md)|  |

### Return type

[**V3EndDevice**](V3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="endDeviceRegistryDelete"></a>
# **endDeviceRegistryDelete**
> kotlin.Any endDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)

Delete the end device with the given IDs.

Before deleting an end device it first needs to be deleted from the NsEndDeviceRegistry, the AsEndDeviceRegistry and the JsEndDeviceRegistry. This is NOT done automatically.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val deviceId : kotlin.String = deviceId_example // kotlin.String | 
val devEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val joinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val devAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : kotlin.Any = apiInstance.endDeviceRegistryDelete(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceRegistryApi#endDeviceRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceRegistryApi#endDeviceRegistryDelete")
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

<a name="endDeviceRegistryGet"></a>
# **endDeviceRegistryGet**
> V3EndDevice endDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)

Get the end device with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3EndDevice = apiInstance.endDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceRegistryApi#endDeviceRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceRegistryApi#endDeviceRegistryGet")
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

<a name="endDeviceRegistryList"></a>
# **endDeviceRegistryList**
> V3EndDevices endDeviceRegistryList(applicationIdsApplicationId, fieldMaskPaths, order, limit, page)

List end devices in the given application. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3EndDevices = apiInstance.endDeviceRegistryList(applicationIdsApplicationId, fieldMaskPaths, order, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceRegistryApi#endDeviceRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceRegistryApi#endDeviceRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3EndDevices**](V3EndDevices.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="endDeviceRegistryUpdate"></a>
# **endDeviceRegistryUpdate**
> V3EndDevice endDeviceRegistryUpdate(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)

Update the end device, changing the fields specified by the field mask to the provided values.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val body : V3UpdateEndDeviceRequest =  // V3UpdateEndDeviceRequest | 
try {
    val result : V3EndDevice = apiInstance.endDeviceRegistryUpdate(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceRegistryApi#endDeviceRegistryUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceRegistryApi#endDeviceRegistryUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **body** | [**V3UpdateEndDeviceRequest**](V3UpdateEndDeviceRequest.md)|  |

### Return type

[**V3EndDevice**](V3EndDevice.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

