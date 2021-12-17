# ApplicationActivationSettingRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationActivationSettingRegistryDelete**](ApplicationActivationSettingRegistryApi.md#applicationActivationSettingRegistryDelete) | **DELETE** /js/applications/{application_ids.application_id}/settings | Delete deletes application activation settings.
[**applicationActivationSettingRegistryGet**](ApplicationActivationSettingRegistryApi.md#applicationActivationSettingRegistryGet) | **GET** /js/applications/{application_ids.application_id}/settings | Get returns application activation settings.
[**applicationActivationSettingRegistrySet**](ApplicationActivationSettingRegistryApi.md#applicationActivationSettingRegistrySet) | **POST** /js/applications/{application_ids.application_id}/settings | Set creates or updates application activation settings.


<a name="applicationActivationSettingRegistryDelete"></a>
# **applicationActivationSettingRegistryDelete**
> kotlin.Any applicationActivationSettingRegistryDelete(applicationIdsApplicationId)

Delete deletes application activation settings.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationActivationSettingRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.applicationActivationSettingRegistryDelete(applicationIdsApplicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationActivationSettingRegistryApi#applicationActivationSettingRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationActivationSettingRegistryApi#applicationActivationSettingRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationActivationSettingRegistryGet"></a>
# **applicationActivationSettingRegistryGet**
> V3ApplicationActivationSettings applicationActivationSettingRegistryGet(applicationIdsApplicationId, fieldMaskPaths)

Get returns application activation settings.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationActivationSettingRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationActivationSettings = apiInstance.applicationActivationSettingRegistryGet(applicationIdsApplicationId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationActivationSettingRegistryApi#applicationActivationSettingRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationActivationSettingRegistryApi#applicationActivationSettingRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationActivationSettings**](V3ApplicationActivationSettings.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationActivationSettingRegistrySet"></a>
# **applicationActivationSettingRegistrySet**
> V3ApplicationActivationSettings applicationActivationSettingRegistrySet(applicationIdsApplicationId, body)

Set creates or updates application activation settings.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationActivationSettingRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3SetApplicationActivationSettingsRequest =  // V3SetApplicationActivationSettingsRequest | 
try {
    val result : V3ApplicationActivationSettings = apiInstance.applicationActivationSettingRegistrySet(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationActivationSettingRegistryApi#applicationActivationSettingRegistrySet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationActivationSettingRegistryApi#applicationActivationSettingRegistrySet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationActivationSettingsRequest**](V3SetApplicationActivationSettingsRequest.md)|  |

### Return type

[**V3ApplicationActivationSettings**](V3ApplicationActivationSettings.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

