# EndDeviceClaimingServerApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**endDeviceClaimingServerAuthorizeApplication**](EndDeviceClaimingServerApi.md#endDeviceClaimingServerAuthorizeApplication) | **POST** /edcs/applications/{application_ids.application_id}/authorize | Authorize the End Device Claiming Server to claim devices registered in the given application. The application identifiers are the source application, where the devices are registered before they are claimed. The API key is used to access the application, find the device, verify the claim request and delete the end device from the source application.
[**endDeviceClaimingServerClaim**](EndDeviceClaimingServerApi.md#endDeviceClaimingServerClaim) | **POST** /edcs/claim | Claims the end device by claim authentication code or QR code and transfers the device to the target application.
[**endDeviceClaimingServerUnauthorizeApplication**](EndDeviceClaimingServerApi.md#endDeviceClaimingServerUnauthorizeApplication) | **DELETE** /edcs/applications/{application_id}/authorize | Unauthorize the End Device Claiming Server to claim devices in the given application. This reverts the authorization given with rpc AuthorizeApplication.


<a name="endDeviceClaimingServerAuthorizeApplication"></a>
# **endDeviceClaimingServerAuthorizeApplication**
> kotlin.Any endDeviceClaimingServerAuthorizeApplication(applicationIdsApplicationId, body)

Authorize the End Device Claiming Server to claim devices registered in the given application. The application identifiers are the source application, where the devices are registered before they are claimed. The API key is used to access the application, find the device, verify the claim request and delete the end device from the source application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceClaimingServerApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3AuthorizeApplicationRequest =  // V3AuthorizeApplicationRequest | 
try {
    val result : kotlin.Any = apiInstance.endDeviceClaimingServerAuthorizeApplication(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceClaimingServerApi#endDeviceClaimingServerAuthorizeApplication")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceClaimingServerApi#endDeviceClaimingServerAuthorizeApplication")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3AuthorizeApplicationRequest**](V3AuthorizeApplicationRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="endDeviceClaimingServerClaim"></a>
# **endDeviceClaimingServerClaim**
> V3EndDeviceIdentifiers endDeviceClaimingServerClaim(body)

Claims the end device by claim authentication code or QR code and transfers the device to the target application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceClaimingServerApi()
val body : V3ClaimEndDeviceRequest =  // V3ClaimEndDeviceRequest | 
try {
    val result : V3EndDeviceIdentifiers = apiInstance.endDeviceClaimingServerClaim(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceClaimingServerApi#endDeviceClaimingServerClaim")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceClaimingServerApi#endDeviceClaimingServerClaim")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3ClaimEndDeviceRequest**](V3ClaimEndDeviceRequest.md)|  |

### Return type

[**V3EndDeviceIdentifiers**](V3EndDeviceIdentifiers.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="endDeviceClaimingServerUnauthorizeApplication"></a>
# **endDeviceClaimingServerUnauthorizeApplication**
> kotlin.Any endDeviceClaimingServerUnauthorizeApplication(applicationId)

Unauthorize the End Device Claiming Server to claim devices in the given application. This reverts the authorization given with rpc AuthorizeApplication.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceClaimingServerApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.endDeviceClaimingServerUnauthorizeApplication(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceClaimingServerApi#endDeviceClaimingServerUnauthorizeApplication")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceClaimingServerApi#endDeviceClaimingServerUnauthorizeApplication")
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

