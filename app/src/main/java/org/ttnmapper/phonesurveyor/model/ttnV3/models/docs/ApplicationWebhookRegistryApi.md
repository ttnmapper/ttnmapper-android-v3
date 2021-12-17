# ApplicationWebhookRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationWebhookRegistryDelete**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistryDelete) | **DELETE** /as/webhooks/{application_ids.application_id}/{webhook_id} | 
[**applicationWebhookRegistryGet**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistryGet) | **GET** /as/webhooks/{ids.application_ids.application_id}/{ids.webhook_id} | 
[**applicationWebhookRegistryGetFormats**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistryGetFormats) | **GET** /as/webhook-formats | 
[**applicationWebhookRegistryGetTemplate**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistryGetTemplate) | **GET** /as/webhook-templates/{ids.template_id} | 
[**applicationWebhookRegistryList**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistryList) | **GET** /as/webhooks/{application_ids.application_id} | 
[**applicationWebhookRegistryListTemplates**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistryListTemplates) | **GET** /as/webhook-templates | 
[**applicationWebhookRegistrySet**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistrySet) | **PUT** /as/webhooks/{webhook.ids.application_ids.application_id}/{webhook.ids.webhook_id} | 
[**applicationWebhookRegistrySet2**](ApplicationWebhookRegistryApi.md#applicationWebhookRegistrySet2) | **POST** /as/webhooks/{webhook.ids.application_ids.application_id} | 


<a name="applicationWebhookRegistryDelete"></a>
# **applicationWebhookRegistryDelete**
> kotlin.Any applicationWebhookRegistryDelete(applicationIdsApplicationId, webhookId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val webhookId : kotlin.String = webhookId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.applicationWebhookRegistryDelete(applicationIdsApplicationId, webhookId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **webhookId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationWebhookRegistryGet"></a>
# **applicationWebhookRegistryGet**
> V3ApplicationWebhook applicationWebhookRegistryGet(idsApplicationIdsApplicationId, idsWebhookId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val idsApplicationIdsApplicationId : kotlin.String = idsApplicationIdsApplicationId_example // kotlin.String | 
val idsWebhookId : kotlin.String = idsWebhookId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationWebhook = apiInstance.applicationWebhookRegistryGet(idsApplicationIdsApplicationId, idsWebhookId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsApplicationIdsApplicationId** | **kotlin.String**|  |
 **idsWebhookId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationWebhook**](V3ApplicationWebhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationWebhookRegistryGetFormats"></a>
# **applicationWebhookRegistryGetFormats**
> V3ApplicationWebhookFormats applicationWebhookRegistryGetFormats()



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
try {
    val result : V3ApplicationWebhookFormats = apiInstance.applicationWebhookRegistryGetFormats()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryGetFormats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryGetFormats")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3ApplicationWebhookFormats**](V3ApplicationWebhookFormats.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationWebhookRegistryGetTemplate"></a>
# **applicationWebhookRegistryGetTemplate**
> V3ApplicationWebhookTemplate applicationWebhookRegistryGetTemplate(idsTemplateId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val idsTemplateId : kotlin.String = idsTemplateId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationWebhookTemplate = apiInstance.applicationWebhookRegistryGetTemplate(idsTemplateId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryGetTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryGetTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsTemplateId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationWebhookTemplate**](V3ApplicationWebhookTemplate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationWebhookRegistryList"></a>
# **applicationWebhookRegistryList**
> V3ApplicationWebhooks applicationWebhookRegistryList(applicationIdsApplicationId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationWebhooks = apiInstance.applicationWebhookRegistryList(applicationIdsApplicationId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationWebhooks**](V3ApplicationWebhooks.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationWebhookRegistryListTemplates"></a>
# **applicationWebhookRegistryListTemplates**
> V3ApplicationWebhookTemplates applicationWebhookRegistryListTemplates(fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationWebhookTemplates = apiInstance.applicationWebhookRegistryListTemplates(fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryListTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistryListTemplates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationWebhookTemplates**](V3ApplicationWebhookTemplates.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationWebhookRegistrySet"></a>
# **applicationWebhookRegistrySet**
> V3ApplicationWebhook applicationWebhookRegistrySet(webhookIdsApplicationIdsApplicationId, webhookIdsWebhookId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val webhookIdsApplicationIdsApplicationId : kotlin.String = webhookIdsApplicationIdsApplicationId_example // kotlin.String | 
val webhookIdsWebhookId : kotlin.String = webhookIdsWebhookId_example // kotlin.String | 
val body : V3SetApplicationWebhookRequest =  // V3SetApplicationWebhookRequest | 
try {
    val result : V3ApplicationWebhook = apiInstance.applicationWebhookRegistrySet(webhookIdsApplicationIdsApplicationId, webhookIdsWebhookId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistrySet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistrySet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **webhookIdsWebhookId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationWebhookRequest**](V3SetApplicationWebhookRequest.md)|  |

### Return type

[**V3ApplicationWebhook**](V3ApplicationWebhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationWebhookRegistrySet2"></a>
# **applicationWebhookRegistrySet2**
> V3ApplicationWebhook applicationWebhookRegistrySet2(webhookIdsApplicationIdsApplicationId, body)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationWebhookRegistryApi()
val webhookIdsApplicationIdsApplicationId : kotlin.String = webhookIdsApplicationIdsApplicationId_example // kotlin.String | 
val body : V3SetApplicationWebhookRequest =  // V3SetApplicationWebhookRequest | 
try {
    val result : V3ApplicationWebhook = apiInstance.applicationWebhookRegistrySet2(webhookIdsApplicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistrySet2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationWebhookRegistryApi#applicationWebhookRegistrySet2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhookIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationWebhookRequest**](V3SetApplicationWebhookRequest.md)|  |

### Return type

[**V3ApplicationWebhook**](V3ApplicationWebhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

