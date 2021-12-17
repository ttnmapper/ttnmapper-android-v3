# JsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**jsGetJoinEUIPrefixes**](JsApi.md#jsGetJoinEUIPrefixes) | **GET** /js/join_eui_prefixes | Request the JoinEUI prefixes that are configured for this Join Server.


<a name="jsGetJoinEUIPrefixes"></a>
# **jsGetJoinEUIPrefixes**
> V3JoinEUIPrefixes jsGetJoinEUIPrefixes()

Request the JoinEUI prefixes that are configured for this Join Server.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = JsApi()
try {
    val result : V3JoinEUIPrefixes = apiInstance.jsGetJoinEUIPrefixes()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JsApi#jsGetJoinEUIPrefixes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JsApi#jsGetJoinEUIPrefixes")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3JoinEUIPrefixes**](V3JoinEUIPrefixes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

