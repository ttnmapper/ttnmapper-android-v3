# EntityAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**entityAccessAuthInfo**](EntityAccessApi.md#entityAccessAuthInfo) | **GET** /auth_info | AuthInfo returns information about the authentication that is used on the request.


<a name="entityAccessAuthInfo"></a>
# **entityAccessAuthInfo**
> V3AuthInfoResponse entityAccessAuthInfo()

AuthInfo returns information about the authentication that is used on the request.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EntityAccessApi()
try {
    val result : V3AuthInfoResponse = apiInstance.entityAccessAuthInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityAccessApi#entityAccessAuthInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityAccessApi#entityAccessAuthInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3AuthInfoResponse**](V3AuthInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

