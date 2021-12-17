# GatewayClaimingServerApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gatewayClaimingServerAuthorizeGateway**](GatewayClaimingServerApi.md#gatewayClaimingServerAuthorizeGateway) | **POST** /gcls/gateways/{gateway_ids.gateway_id}/authorize | AuthorizeGateway allows a gateway to be claimed.
[**gatewayClaimingServerClaim**](GatewayClaimingServerApi.md#gatewayClaimingServerClaim) | **POST** /gcls/claim | Claims a gateway by claim authentication code or QR code and transfers the gateway to the target user.
[**gatewayClaimingServerUnauthorizeGateway**](GatewayClaimingServerApi.md#gatewayClaimingServerUnauthorizeGateway) | **DELETE** /gcls/gateways/{gateway_id}/authorize | UnauthorizeGateway prevents a gateway from being claimed.


<a name="gatewayClaimingServerAuthorizeGateway"></a>
# **gatewayClaimingServerAuthorizeGateway**
> kotlin.Any gatewayClaimingServerAuthorizeGateway(gatewayIdsGatewayId, body)

AuthorizeGateway allows a gateway to be claimed.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayClaimingServerApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val body : V3AuthorizeGatewayRequest =  // V3AuthorizeGatewayRequest | 
try {
    val result : kotlin.Any = apiInstance.gatewayClaimingServerAuthorizeGateway(gatewayIdsGatewayId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayClaimingServerApi#gatewayClaimingServerAuthorizeGateway")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayClaimingServerApi#gatewayClaimingServerAuthorizeGateway")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **body** | [**V3AuthorizeGatewayRequest**](V3AuthorizeGatewayRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gatewayClaimingServerClaim"></a>
# **gatewayClaimingServerClaim**
> Lorawanv3GatewayIdentifiers gatewayClaimingServerClaim(body)

Claims a gateway by claim authentication code or QR code and transfers the gateway to the target user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayClaimingServerApi()
val body : V3ClaimGatewayRequest =  // V3ClaimGatewayRequest | 
try {
    val result : Lorawanv3GatewayIdentifiers = apiInstance.gatewayClaimingServerClaim(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayClaimingServerApi#gatewayClaimingServerClaim")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayClaimingServerApi#gatewayClaimingServerClaim")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3ClaimGatewayRequest**](V3ClaimGatewayRequest.md)|  |

### Return type

[**Lorawanv3GatewayIdentifiers**](Lorawanv3GatewayIdentifiers.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gatewayClaimingServerUnauthorizeGateway"></a>
# **gatewayClaimingServerUnauthorizeGateway**
> kotlin.Any gatewayClaimingServerUnauthorizeGateway(gatewayId, eui)

UnauthorizeGateway prevents a gateway from being claimed.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayClaimingServerApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.gatewayClaimingServerUnauthorizeGateway(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayClaimingServerApi#gatewayClaimingServerUnauthorizeGateway")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayClaimingServerApi#gatewayClaimingServerUnauthorizeGateway")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

