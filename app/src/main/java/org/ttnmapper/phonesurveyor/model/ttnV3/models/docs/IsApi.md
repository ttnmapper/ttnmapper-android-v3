# IsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**isGetConfiguration**](IsApi.md#isGetConfiguration) | **GET** /is/configuration | Get the configuration of the Identity Server. The response is typically used to enable or disable features in a user interface.


<a name="isGetConfiguration"></a>
# **isGetConfiguration**
> V3GetIsConfigurationResponse isGetConfiguration()

Get the configuration of the Identity Server. The response is typically used to enable or disable features in a user interface.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IsApi()
try {
    val result : V3GetIsConfigurationResponse = apiInstance.isGetConfiguration()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IsApi#isGetConfiguration")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IsApi#isGetConfiguration")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3GetIsConfigurationResponse**](V3GetIsConfigurationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

