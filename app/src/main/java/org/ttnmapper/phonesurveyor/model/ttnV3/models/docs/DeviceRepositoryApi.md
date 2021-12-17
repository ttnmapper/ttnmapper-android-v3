# DeviceRepositoryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deviceRepositoryGetBrand**](DeviceRepositoryApi.md#deviceRepositoryGetBrand) | **GET** /dr/applications/{application_ids.application_id}/brands/{brand_id} | 
[**deviceRepositoryGetDownlinkDecoder**](DeviceRepositoryApi.md#deviceRepositoryGetDownlinkDecoder) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/formatters/downlink/decoder | 
[**deviceRepositoryGetDownlinkEncoder**](DeviceRepositoryApi.md#deviceRepositoryGetDownlinkEncoder) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/formatters/downlink/encoder | 
[**deviceRepositoryGetModel**](DeviceRepositoryApi.md#deviceRepositoryGetModel) | **GET** /dr/applications/{application_ids.application_id}/brands/{brand_id}/models/{model_id} | 
[**deviceRepositoryGetTemplate**](DeviceRepositoryApi.md#deviceRepositoryGetTemplate) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/template | 
[**deviceRepositoryGetUplinkDecoder**](DeviceRepositoryApi.md#deviceRepositoryGetUplinkDecoder) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/formatters/uplink/decoder | 
[**deviceRepositoryListBrands**](DeviceRepositoryApi.md#deviceRepositoryListBrands) | **GET** /dr/applications/{application_ids.application_id}/brands | 
[**deviceRepositoryListModels**](DeviceRepositoryApi.md#deviceRepositoryListModels) | **GET** /dr/applications/{application_ids.application_id}/brands/{brand_id}/models | 
[**deviceRepositoryListModels2**](DeviceRepositoryApi.md#deviceRepositoryListModels2) | **GET** /dr/applications/{application_ids.application_id}/models | 


<a name="deviceRepositoryGetBrand"></a>
# **deviceRepositoryGetBrand**
> V3EndDeviceBrand deviceRepositoryGetBrand(applicationIdsApplicationId, brandId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val brandId : kotlin.String = brandId_example // kotlin.String | Brand identifier, as defined in the Device Repository.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3EndDeviceBrand = apiInstance.deviceRepositoryGetBrand(applicationIdsApplicationId, brandId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryGetBrand")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryGetBrand")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **brandId** | **kotlin.String**| Brand identifier, as defined in the Device Repository. |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3EndDeviceBrand**](V3EndDeviceBrand.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryGetDownlinkDecoder"></a>
# **deviceRepositoryGetDownlinkDecoder**
> V3MessagePayloadDecoder deviceRepositoryGetDownlinkDecoder(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val versionIdsBrandId : kotlin.String = versionIdsBrandId_example // kotlin.String | 
val versionIdsModelId : kotlin.String = versionIdsModelId_example // kotlin.String | 
val versionIdsFirmwareVersion : kotlin.String = versionIdsFirmwareVersion_example // kotlin.String | 
val versionIdsBandId : kotlin.String = versionIdsBandId_example // kotlin.String | 
val versionIdsHardwareVersion : kotlin.String = versionIdsHardwareVersion_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3MessagePayloadDecoder = apiInstance.deviceRepositoryGetDownlinkDecoder(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryGetDownlinkDecoder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryGetDownlinkDecoder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **versionIdsBrandId** | **kotlin.String**|  |
 **versionIdsModelId** | **kotlin.String**|  |
 **versionIdsFirmwareVersion** | **kotlin.String**|  |
 **versionIdsBandId** | **kotlin.String**|  |
 **versionIdsHardwareVersion** | **kotlin.String**|  | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3MessagePayloadDecoder**](V3MessagePayloadDecoder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryGetDownlinkEncoder"></a>
# **deviceRepositoryGetDownlinkEncoder**
> V3MessagePayloadEncoder deviceRepositoryGetDownlinkEncoder(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val versionIdsBrandId : kotlin.String = versionIdsBrandId_example // kotlin.String | 
val versionIdsModelId : kotlin.String = versionIdsModelId_example // kotlin.String | 
val versionIdsFirmwareVersion : kotlin.String = versionIdsFirmwareVersion_example // kotlin.String | 
val versionIdsBandId : kotlin.String = versionIdsBandId_example // kotlin.String | 
val versionIdsHardwareVersion : kotlin.String = versionIdsHardwareVersion_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3MessagePayloadEncoder = apiInstance.deviceRepositoryGetDownlinkEncoder(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryGetDownlinkEncoder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryGetDownlinkEncoder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **versionIdsBrandId** | **kotlin.String**|  |
 **versionIdsModelId** | **kotlin.String**|  |
 **versionIdsFirmwareVersion** | **kotlin.String**|  |
 **versionIdsBandId** | **kotlin.String**|  |
 **versionIdsHardwareVersion** | **kotlin.String**|  | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3MessagePayloadEncoder**](V3MessagePayloadEncoder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryGetModel"></a>
# **deviceRepositoryGetModel**
> V3EndDeviceModel deviceRepositoryGetModel(applicationIdsApplicationId, brandId, modelId, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val brandId : kotlin.String = brandId_example // kotlin.String | Brand identifier, as defined in the Device Repository.
val modelId : kotlin.String = modelId_example // kotlin.String | Model identifier, as defined in the Device Repository.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3EndDeviceModel = apiInstance.deviceRepositoryGetModel(applicationIdsApplicationId, brandId, modelId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryGetModel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryGetModel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **brandId** | **kotlin.String**| Brand identifier, as defined in the Device Repository. |
 **modelId** | **kotlin.String**| Model identifier, as defined in the Device Repository. |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3EndDeviceModel**](V3EndDeviceModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryGetTemplate"></a>
# **deviceRepositoryGetTemplate**
> V3EndDeviceTemplate deviceRepositoryGetTemplate(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val versionIdsBrandId : kotlin.String = versionIdsBrandId_example // kotlin.String | 
val versionIdsModelId : kotlin.String = versionIdsModelId_example // kotlin.String | 
val versionIdsFirmwareVersion : kotlin.String = versionIdsFirmwareVersion_example // kotlin.String | 
val versionIdsBandId : kotlin.String = versionIdsBandId_example // kotlin.String | 
val versionIdsHardwareVersion : kotlin.String = versionIdsHardwareVersion_example // kotlin.String | 
try {
    val result : V3EndDeviceTemplate = apiInstance.deviceRepositoryGetTemplate(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryGetTemplate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryGetTemplate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **versionIdsBrandId** | **kotlin.String**|  |
 **versionIdsModelId** | **kotlin.String**|  |
 **versionIdsFirmwareVersion** | **kotlin.String**|  |
 **versionIdsBandId** | **kotlin.String**|  |
 **versionIdsHardwareVersion** | **kotlin.String**|  | [optional]

### Return type

[**V3EndDeviceTemplate**](V3EndDeviceTemplate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryGetUplinkDecoder"></a>
# **deviceRepositoryGetUplinkDecoder**
> V3MessagePayloadDecoder deviceRepositoryGetUplinkDecoder(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val versionIdsBrandId : kotlin.String = versionIdsBrandId_example // kotlin.String | 
val versionIdsModelId : kotlin.String = versionIdsModelId_example // kotlin.String | 
val versionIdsFirmwareVersion : kotlin.String = versionIdsFirmwareVersion_example // kotlin.String | 
val versionIdsBandId : kotlin.String = versionIdsBandId_example // kotlin.String | 
val versionIdsHardwareVersion : kotlin.String = versionIdsHardwareVersion_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3MessagePayloadDecoder = apiInstance.deviceRepositoryGetUplinkDecoder(applicationIdsApplicationId, versionIdsBrandId, versionIdsModelId, versionIdsFirmwareVersion, versionIdsBandId, versionIdsHardwareVersion, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryGetUplinkDecoder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryGetUplinkDecoder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **versionIdsBrandId** | **kotlin.String**|  |
 **versionIdsModelId** | **kotlin.String**|  |
 **versionIdsFirmwareVersion** | **kotlin.String**|  |
 **versionIdsBandId** | **kotlin.String**|  |
 **versionIdsHardwareVersion** | **kotlin.String**|  | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3MessagePayloadDecoder**](V3MessagePayloadDecoder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryListBrands"></a>
# **deviceRepositoryListBrands**
> V3ListEndDeviceBrandsResponse deviceRepositoryListBrands(applicationIdsApplicationId, limit, page, orderBy, search, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val orderBy : kotlin.String = orderBy_example // kotlin.String | Order (for pagination).
val search : kotlin.String = search_example // kotlin.String | Search for brands matching a query string.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ListEndDeviceBrandsResponse = apiInstance.deviceRepositoryListBrands(applicationIdsApplicationId, limit, page, orderBy, search, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryListBrands")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryListBrands")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **orderBy** | **kotlin.String**| Order (for pagination). | [optional]
 **search** | **kotlin.String**| Search for brands matching a query string. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ListEndDeviceBrandsResponse**](V3ListEndDeviceBrandsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryListModels"></a>
# **deviceRepositoryListModels**
> V3ListEndDeviceModelsResponse deviceRepositoryListModels(applicationIdsApplicationId, brandId, limit, page, orderBy, search, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val brandId : kotlin.String = brandId_example // kotlin.String | List end devices from a specific brand.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val orderBy : kotlin.String = orderBy_example // kotlin.String | Order end devices.
val search : kotlin.String = search_example // kotlin.String | List end devices matching a query string.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ListEndDeviceModelsResponse = apiInstance.deviceRepositoryListModels(applicationIdsApplicationId, brandId, limit, page, orderBy, search, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryListModels")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryListModels")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **brandId** | **kotlin.String**| List end devices from a specific brand. |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **orderBy** | **kotlin.String**| Order end devices. | [optional]
 **search** | **kotlin.String**| List end devices matching a query string. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ListEndDeviceModelsResponse**](V3ListEndDeviceModelsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deviceRepositoryListModels2"></a>
# **deviceRepositoryListModels2**
> V3ListEndDeviceModelsResponse deviceRepositoryListModels2(applicationIdsApplicationId, brandId, limit, page, orderBy, search, fieldMaskPaths)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DeviceRepositoryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val brandId : kotlin.String = brandId_example // kotlin.String | List end devices from a specific brand.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val orderBy : kotlin.String = orderBy_example // kotlin.String | Order end devices.
val search : kotlin.String = search_example // kotlin.String | List end devices matching a query string.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ListEndDeviceModelsResponse = apiInstance.deviceRepositoryListModels2(applicationIdsApplicationId, brandId, limit, page, orderBy, search, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DeviceRepositoryApi#deviceRepositoryListModels2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DeviceRepositoryApi#deviceRepositoryListModels2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **brandId** | **kotlin.String**| List end devices from a specific brand. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **orderBy** | **kotlin.String**| Order end devices. | [optional]
 **search** | **kotlin.String**| List end devices matching a query string. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ListEndDeviceModelsResponse**](V3ListEndDeviceModelsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

