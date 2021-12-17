# EndDeviceTemplateConverterApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**endDeviceTemplateConverterConvert**](EndDeviceTemplateConverterApi.md#endDeviceTemplateConverterConvert) | **POST** /edtc/convert | Converts the binary data to a stream of end device templates.
[**endDeviceTemplateConverterListFormats**](EndDeviceTemplateConverterApi.md#endDeviceTemplateConverterListFormats) | **GET** /edtc/formats | Returns the configured formats to convert from.


<a name="endDeviceTemplateConverterConvert"></a>
# **endDeviceTemplateConverterConvert**
> StreamResultOfV3EndDeviceTemplate endDeviceTemplateConverterConvert(body)

Converts the binary data to a stream of end device templates.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceTemplateConverterApi()
val body : V3ConvertEndDeviceTemplateRequest =  // V3ConvertEndDeviceTemplateRequest | 
try {
    val result : StreamResultOfV3EndDeviceTemplate = apiInstance.endDeviceTemplateConverterConvert(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceTemplateConverterApi#endDeviceTemplateConverterConvert")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceTemplateConverterApi#endDeviceTemplateConverterConvert")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3ConvertEndDeviceTemplateRequest**](V3ConvertEndDeviceTemplateRequest.md)|  |

### Return type

[**StreamResultOfV3EndDeviceTemplate**](StreamResultOfV3EndDeviceTemplate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="endDeviceTemplateConverterListFormats"></a>
# **endDeviceTemplateConverterListFormats**
> V3EndDeviceTemplateFormats endDeviceTemplateConverterListFormats()

Returns the configured formats to convert from.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceTemplateConverterApi()
try {
    val result : V3EndDeviceTemplateFormats = apiInstance.endDeviceTemplateConverterListFormats()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceTemplateConverterApi#endDeviceTemplateConverterListFormats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceTemplateConverterApi#endDeviceTemplateConverterListFormats")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3EndDeviceTemplateFormats**](V3EndDeviceTemplateFormats.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

