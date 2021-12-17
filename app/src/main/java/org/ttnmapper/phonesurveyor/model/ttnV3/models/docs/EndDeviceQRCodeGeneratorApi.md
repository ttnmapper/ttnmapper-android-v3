# EndDeviceQRCodeGeneratorApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**endDeviceQRCodeGeneratorGenerate**](EndDeviceQRCodeGeneratorApi.md#endDeviceQRCodeGeneratorGenerate) | **POST** /qr-codes/end-devices | Generates a QR code.
[**endDeviceQRCodeGeneratorGetFormat**](EndDeviceQRCodeGeneratorApi.md#endDeviceQRCodeGeneratorGetFormat) | **GET** /qr-codes/end-devices/formats/{format_id} | Return the QR code format.
[**endDeviceQRCodeGeneratorListFormats**](EndDeviceQRCodeGeneratorApi.md#endDeviceQRCodeGeneratorListFormats) | **GET** /qr-codes/end-devices/formats | Returns the supported formats.


<a name="endDeviceQRCodeGeneratorGenerate"></a>
# **endDeviceQRCodeGeneratorGenerate**
> V3GenerateQRCodeResponse endDeviceQRCodeGeneratorGenerate(body)

Generates a QR code.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceQRCodeGeneratorApi()
val body : V3GenerateEndDeviceQRCodeRequest =  // V3GenerateEndDeviceQRCodeRequest | 
try {
    val result : V3GenerateQRCodeResponse = apiInstance.endDeviceQRCodeGeneratorGenerate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceQRCodeGeneratorApi#endDeviceQRCodeGeneratorGenerate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceQRCodeGeneratorApi#endDeviceQRCodeGeneratorGenerate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3GenerateEndDeviceQRCodeRequest**](V3GenerateEndDeviceQRCodeRequest.md)|  |

### Return type

[**V3GenerateQRCodeResponse**](V3GenerateQRCodeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="endDeviceQRCodeGeneratorGetFormat"></a>
# **endDeviceQRCodeGeneratorGetFormat**
> V3QRCodeFormat endDeviceQRCodeGeneratorGetFormat(formatId)

Return the QR code format.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceQRCodeGeneratorApi()
val formatId : kotlin.String = formatId_example // kotlin.String | QR code format identifier. Enumerate available formats with rpc ListFormats in the EndDeviceQRCodeGenerator service.
try {
    val result : V3QRCodeFormat = apiInstance.endDeviceQRCodeGeneratorGetFormat(formatId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceQRCodeGeneratorApi#endDeviceQRCodeGeneratorGetFormat")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceQRCodeGeneratorApi#endDeviceQRCodeGeneratorGetFormat")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **formatId** | **kotlin.String**| QR code format identifier. Enumerate available formats with rpc ListFormats in the EndDeviceQRCodeGenerator service. |

### Return type

[**V3QRCodeFormat**](V3QRCodeFormat.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="endDeviceQRCodeGeneratorListFormats"></a>
# **endDeviceQRCodeGeneratorListFormats**
> V3QRCodeFormats endDeviceQRCodeGeneratorListFormats()

Returns the supported formats.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceQRCodeGeneratorApi()
try {
    val result : V3QRCodeFormats = apiInstance.endDeviceQRCodeGeneratorListFormats()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceQRCodeGeneratorApi#endDeviceQRCodeGeneratorListFormats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceQRCodeGeneratorApi#endDeviceQRCodeGeneratorListFormats")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3QRCodeFormats**](V3QRCodeFormats.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

