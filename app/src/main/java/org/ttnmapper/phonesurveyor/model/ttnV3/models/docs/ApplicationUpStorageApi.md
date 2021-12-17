# ApplicationUpStorageApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationUpStorageGetStoredApplicationUp**](ApplicationUpStorageApi.md#applicationUpStorageGetStoredApplicationUp) | **GET** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/packages/storage/{type} | Returns a stream of application messages that have been stored in the database.
[**applicationUpStorageGetStoredApplicationUp2**](ApplicationUpStorageApi.md#applicationUpStorageGetStoredApplicationUp2) | **GET** /as/applications/{application_ids.application_id}/packages/storage/{type} | Returns a stream of application messages that have been stored in the database.
[**applicationUpStorageGetStoredApplicationUpCount**](ApplicationUpStorageApi.md#applicationUpStorageGetStoredApplicationUpCount) | **GET** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/packages/storage/{type}/count | Returns how many application messages have been stored in the database for an application or end device.
[**applicationUpStorageGetStoredApplicationUpCount2**](ApplicationUpStorageApi.md#applicationUpStorageGetStoredApplicationUpCount2) | **GET** /as/applications/{application_ids.application_id}/packages/storage/{type}/count | Returns how many application messages have been stored in the database for an application or end device.


<a name="applicationUpStorageGetStoredApplicationUp"></a>
# **applicationUpStorageGetStoredApplicationUp**
> StreamResultOfV3ApplicationUp applicationUpStorageGetStoredApplicationUp(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, type, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, limit, after, before, fPort, order, fieldMaskPaths, last)

Returns a stream of application messages that have been stored in the database.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationUpStorageApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | Query upstream messages of a specific type. If not set, then all upstream messages are returned.
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val limit : kotlin.Long = 789 // kotlin.Long | Limit number of results.
val after : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Query upstream messages after this timestamp only. Cannot be used in conjunction with last.
val before : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Query upstream messages before this timestamp only. Cannot be used in conjunction with last.
val fPort : kotlin.Long = 789 // kotlin.Long | Query uplinks on a specific FPort only.
val order : kotlin.String = order_example // kotlin.String | Order results.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val last : kotlin.String = last_example // kotlin.String | Query upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before.
try {
    val result : StreamResultOfV3ApplicationUp = apiInstance.applicationUpStorageGetStoredApplicationUp(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, type, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, limit, after, before, fPort, order, fieldMaskPaths, last)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUp")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUp")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **type** | **kotlin.String**| Query upstream messages of a specific type. If not set, then all upstream messages are returned. |
 **endDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **endDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **endDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **limit** | **kotlin.Long**| Limit number of results. | [optional]
 **after** | **java.time.OffsetDateTime**| Query upstream messages after this timestamp only. Cannot be used in conjunction with last. | [optional]
 **before** | **java.time.OffsetDateTime**| Query upstream messages before this timestamp only. Cannot be used in conjunction with last. | [optional]
 **fPort** | **kotlin.Long**| Query uplinks on a specific FPort only. | [optional]
 **order** | **kotlin.String**| Order results. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **last** | **kotlin.String**| Query upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before. | [optional]

### Return type

[**StreamResultOfV3ApplicationUp**](StreamResultOfV3ApplicationUp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationUpStorageGetStoredApplicationUp2"></a>
# **applicationUpStorageGetStoredApplicationUp2**
> StreamResultOfV3ApplicationUp applicationUpStorageGetStoredApplicationUp2(applicationIdsApplicationId, type, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, limit, after, before, fPort, order, fieldMaskPaths, last)

Returns a stream of application messages that have been stored in the database.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationUpStorageApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | Query upstream messages of a specific type. If not set, then all upstream messages are returned.
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val limit : kotlin.Long = 789 // kotlin.Long | Limit number of results.
val after : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Query upstream messages after this timestamp only. Cannot be used in conjunction with last.
val before : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Query upstream messages before this timestamp only. Cannot be used in conjunction with last.
val fPort : kotlin.Long = 789 // kotlin.Long | Query uplinks on a specific FPort only.
val order : kotlin.String = order_example // kotlin.String | Order results.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val last : kotlin.String = last_example // kotlin.String | Query upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before.
try {
    val result : StreamResultOfV3ApplicationUp = apiInstance.applicationUpStorageGetStoredApplicationUp2(applicationIdsApplicationId, type, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, limit, after, before, fPort, order, fieldMaskPaths, last)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUp2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUp2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **type** | **kotlin.String**| Query upstream messages of a specific type. If not set, then all upstream messages are returned. |
 **endDeviceIdsDeviceId** | **kotlin.String**|  | [optional]
 **endDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **endDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **endDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **limit** | **kotlin.Long**| Limit number of results. | [optional]
 **after** | **java.time.OffsetDateTime**| Query upstream messages after this timestamp only. Cannot be used in conjunction with last. | [optional]
 **before** | **java.time.OffsetDateTime**| Query upstream messages before this timestamp only. Cannot be used in conjunction with last. | [optional]
 **fPort** | **kotlin.Long**| Query uplinks on a specific FPort only. | [optional]
 **order** | **kotlin.String**| Order results. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **last** | **kotlin.String**| Query upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before. | [optional]

### Return type

[**StreamResultOfV3ApplicationUp**](StreamResultOfV3ApplicationUp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationUpStorageGetStoredApplicationUpCount"></a>
# **applicationUpStorageGetStoredApplicationUpCount**
> V3GetStoredApplicationUpCountResponse applicationUpStorageGetStoredApplicationUpCount(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, type, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, after, before, fPort, last)

Returns how many application messages have been stored in the database for an application or end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationUpStorageApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | Count upstream messages of a specific type. If not set, then all upstream messages are returned.
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val after : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Count upstream messages after this timestamp only. Cannot be used in conjunction with last.
val before : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Count upstream messages before this timestamp only. Cannot be used in conjunction with last.
val fPort : kotlin.Long = 789 // kotlin.Long | Count uplinks on a specific FPort only.
val last : kotlin.String = last_example // kotlin.String | Count upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before.
try {
    val result : V3GetStoredApplicationUpCountResponse = apiInstance.applicationUpStorageGetStoredApplicationUpCount(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, type, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, after, before, fPort, last)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUpCount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUpCount")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **type** | **kotlin.String**| Count upstream messages of a specific type. If not set, then all upstream messages are returned. |
 **endDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **endDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **endDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **after** | **java.time.OffsetDateTime**| Count upstream messages after this timestamp only. Cannot be used in conjunction with last. | [optional]
 **before** | **java.time.OffsetDateTime**| Count upstream messages before this timestamp only. Cannot be used in conjunction with last. | [optional]
 **fPort** | **kotlin.Long**| Count uplinks on a specific FPort only. | [optional]
 **last** | **kotlin.String**| Count upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before. | [optional]

### Return type

[**V3GetStoredApplicationUpCountResponse**](V3GetStoredApplicationUpCountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationUpStorageGetStoredApplicationUpCount2"></a>
# **applicationUpStorageGetStoredApplicationUpCount2**
> V3GetStoredApplicationUpCountResponse applicationUpStorageGetStoredApplicationUpCount2(applicationIdsApplicationId, type, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, after, before, fPort, last)

Returns how many application messages have been stored in the database for an application or end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationUpStorageApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | Count upstream messages of a specific type. If not set, then all upstream messages are returned.
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val after : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Count upstream messages after this timestamp only. Cannot be used in conjunction with last.
val before : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | Count upstream messages before this timestamp only. Cannot be used in conjunction with last.
val fPort : kotlin.Long = 789 // kotlin.Long | Count uplinks on a specific FPort only.
val last : kotlin.String = last_example // kotlin.String | Count upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before.
try {
    val result : V3GetStoredApplicationUpCountResponse = apiInstance.applicationUpStorageGetStoredApplicationUpCount2(applicationIdsApplicationId, type, endDeviceIdsDeviceId, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr, after, before, fPort, last)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUpCount2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationUpStorageApi#applicationUpStorageGetStoredApplicationUpCount2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **type** | **kotlin.String**| Count upstream messages of a specific type. If not set, then all upstream messages are returned. |
 **endDeviceIdsDeviceId** | **kotlin.String**|  | [optional]
 **endDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **endDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **endDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **after** | **java.time.OffsetDateTime**| Count upstream messages after this timestamp only. Cannot be used in conjunction with last. | [optional]
 **before** | **java.time.OffsetDateTime**| Count upstream messages before this timestamp only. Cannot be used in conjunction with last. | [optional]
 **fPort** | **kotlin.Long**| Count uplinks on a specific FPort only. | [optional]
 **last** | **kotlin.String**| Count upstream messages that have arrived in the last minutes or hours. Cannot be used in conjunction with after and before. | [optional]

### Return type

[**V3GetStoredApplicationUpCountResponse**](V3GetStoredApplicationUpCountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

