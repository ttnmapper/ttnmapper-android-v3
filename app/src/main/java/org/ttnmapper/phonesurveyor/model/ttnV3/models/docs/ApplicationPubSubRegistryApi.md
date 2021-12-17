# ApplicationPubSubRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationPubSubRegistryDelete**](ApplicationPubSubRegistryApi.md#applicationPubSubRegistryDelete) | **DELETE** /as/pubsub/{application_ids.application_id}/{pub_sub_id} | 
[**applicationPubSubRegistryGet**](ApplicationPubSubRegistryApi.md#applicationPubSubRegistryGet) | **GET** /as/pubsub/{ids.application_ids.application_id}/{ids.pub_sub_id} | 
[**applicationPubSubRegistryGetFormats**](ApplicationPubSubRegistryApi.md#applicationPubSubRegistryGetFormats) | **GET** /as/pubsub-formats | 
[**applicationPubSubRegistryList**](ApplicationPubSubRegistryApi.md#applicationPubSubRegistryList) | **GET** /as/pubsub/{application_ids.application_id} | 
[**applicationPubSubRegistrySet**](ApplicationPubSubRegistryApi.md#applicationPubSubRegistrySet) | **PUT** /as/pubsub/{pubsub.ids.application_ids.application_id}/{pubsub.ids.pub_sub_id} | 
[**applicationPubSubRegistrySet2**](ApplicationPubSubRegistryApi.md#applicationPubSubRegistrySet2) | **POST** /as/pubsub/{pubsub.ids.application_ids.application_id} | 


<a name="applicationPubSubRegistryDelete"></a>
# **applicationPubSubRegistryDelete**
> kotlin.Any applicationPubSubRegistryDelete(applicationIdsApplicationId, pubSubId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPubSubRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val pubSubId : kotlin.String = pubSubId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.applicationPubSubRegistryDelete(applicationIdsApplicationId, pubSubId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **pubSubId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPubSubRegistryGet"></a>
# **applicationPubSubRegistryGet**
> V3ApplicationPubSub applicationPubSubRegistryGet(idsApplicationIdsApplicationId, idsPubSubId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPubSubRegistryApi()
val idsApplicationIdsApplicationId : kotlin.String = idsApplicationIdsApplicationId_example // kotlin.String | 
val idsPubSubId : kotlin.String = idsPubSubId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationPubSub = apiInstance.applicationPubSubRegistryGet(idsApplicationIdsApplicationId, idsPubSubId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsApplicationIdsApplicationId** | **kotlin.String**|  |
 **idsPubSubId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationPubSub**](V3ApplicationPubSub.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPubSubRegistryGetFormats"></a>
# **applicationPubSubRegistryGetFormats**
> V3ApplicationPubSubFormats applicationPubSubRegistryGetFormats()



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPubSubRegistryApi()
try {
    val result : V3ApplicationPubSubFormats = apiInstance.applicationPubSubRegistryGetFormats()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryGetFormats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryGetFormats")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3ApplicationPubSubFormats**](V3ApplicationPubSubFormats.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPubSubRegistryList"></a>
# **applicationPubSubRegistryList**
> V3ApplicationPubSubs applicationPubSubRegistryList(applicationIdsApplicationId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPubSubRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationPubSubs = apiInstance.applicationPubSubRegistryList(applicationIdsApplicationId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationPubSubs**](V3ApplicationPubSubs.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPubSubRegistrySet"></a>
# **applicationPubSubRegistrySet**
> V3ApplicationPubSub applicationPubSubRegistrySet(pubsubIdsApplicationIdsApplicationId, pubsubIdsPubSubId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPubSubRegistryApi()
val pubsubIdsApplicationIdsApplicationId : kotlin.String = pubsubIdsApplicationIdsApplicationId_example // kotlin.String | 
val pubsubIdsPubSubId : kotlin.String = pubsubIdsPubSubId_example // kotlin.String | 
val body : V3SetApplicationPubSubRequest =  // V3SetApplicationPubSubRequest | 
try {
    val result : V3ApplicationPubSub = apiInstance.applicationPubSubRegistrySet(pubsubIdsApplicationIdsApplicationId, pubsubIdsPubSubId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistrySet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistrySet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pubsubIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **pubsubIdsPubSubId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationPubSubRequest**](V3SetApplicationPubSubRequest.md)|  |

### Return type

[**V3ApplicationPubSub**](V3ApplicationPubSub.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationPubSubRegistrySet2"></a>
# **applicationPubSubRegistrySet2**
> V3ApplicationPubSub applicationPubSubRegistrySet2(pubsubIdsApplicationIdsApplicationId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPubSubRegistryApi()
val pubsubIdsApplicationIdsApplicationId : kotlin.String = pubsubIdsApplicationIdsApplicationId_example // kotlin.String | 
val body : V3SetApplicationPubSubRequest =  // V3SetApplicationPubSubRequest | 
try {
    val result : V3ApplicationPubSub = apiInstance.applicationPubSubRegistrySet2(pubsubIdsApplicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistrySet2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPubSubRegistryApi#applicationPubSubRegistrySet2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pubsubIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationPubSubRequest**](V3SetApplicationPubSubRequest.md)|  |

### Return type

[**V3ApplicationPubSub**](V3ApplicationPubSub.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

