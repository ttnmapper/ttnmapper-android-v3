# AsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**asDeleteLink**](AsApi.md#asDeleteLink) | **DELETE** /as/applications/{application_id}/link | Delete the link between the Application Server and Network Server for the specified application.
[**asGetConfiguration**](AsApi.md#asGetConfiguration) | **GET** /as/configuration | 
[**asGetLink**](AsApi.md#asGetLink) | **GET** /as/applications/{application_ids.application_id}/link | Get a link configuration from the Application Server to Network Server. This only contains the configuration. Use GetLinkStats to view statistics and any link errors.
[**asGetLinkStats**](AsApi.md#asGetLinkStats) | **GET** /as/applications/{application_id}/link/stats | GetLinkStats returns the link statistics. This call returns a NotFound error code if there is no link for the given application identifiers. This call returns the error code of the link error if linking to a Network Server failed.
[**asSetLink**](AsApi.md#asSetLink) | **PUT** /as/applications/{application_ids.application_id}/link | Set a link configuration from the Application Server a Network Server. This call returns immediately after setting the link configuration; it does not wait for a link to establish. To get link statistics or errors, use GetLinkStats. Note that there can only be one Application Server instance linked to a Network Server for a given application at a time.


<a name="asDeleteLink"></a>
# **asDeleteLink**
> kotlin.Any asDeleteLink(applicationId)

Delete the link between the Application Server and Network Server for the specified application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.asDeleteLink(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsApi#asDeleteLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsApi#asDeleteLink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="asGetConfiguration"></a>
# **asGetConfiguration**
> V3GetAsConfigurationResponse asGetConfiguration()



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsApi()
try {
    val result : V3GetAsConfigurationResponse = apiInstance.asGetConfiguration()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsApi#asGetConfiguration")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsApi#asGetConfiguration")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3GetAsConfigurationResponse**](V3GetAsConfigurationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="asGetLink"></a>
# **asGetLink**
> V3ApplicationLink asGetLink(applicationIdsApplicationId, fieldMaskPaths)

Get a link configuration from the Application Server to Network Server. This only contains the configuration. Use GetLinkStats to view statistics and any link errors.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationLink = apiInstance.asGetLink(applicationIdsApplicationId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsApi#asGetLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsApi#asGetLink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationLink**](V3ApplicationLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="asGetLinkStats"></a>
# **asGetLinkStats**
> V3ApplicationLinkStats asGetLinkStats(applicationId)

GetLinkStats returns the link statistics. This call returns a NotFound error code if there is no link for the given application identifiers. This call returns the error code of the link error if linking to a Network Server failed.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : V3ApplicationLinkStats = apiInstance.asGetLinkStats(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsApi#asGetLinkStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsApi#asGetLinkStats")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**V3ApplicationLinkStats**](V3ApplicationLinkStats.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="asSetLink"></a>
# **asSetLink**
> V3ApplicationLink asSetLink(applicationIdsApplicationId, body)

Set a link configuration from the Application Server a Network Server. This call returns immediately after setting the link configuration; it does not wait for a link to establish. To get link statistics or errors, use GetLinkStats. Note that there can only be one Application Server instance linked to a Network Server for a given application at a time.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = AsApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3SetApplicationLinkRequest =  // V3SetApplicationLinkRequest | 
try {
    val result : V3ApplicationLink = apiInstance.asSetLink(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AsApi#asSetLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AsApi#asSetLink")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationLinkRequest**](V3SetApplicationLinkRequest.md)|  |

### Return type

[**V3ApplicationLink**](V3ApplicationLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

