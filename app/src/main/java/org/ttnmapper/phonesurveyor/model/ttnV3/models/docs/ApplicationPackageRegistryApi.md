# ApplicationPackageRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationPackageRegistryDeleteAssociation**](ApplicationPackageRegistryApi.md#applicationPackageRegistryDeleteAssociation) | **DELETE** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/packages/associations/{f_port} | DeleteAssociation removes the association on the FPort of the end device.
[**applicationPackageRegistryDeleteDefaultAssociation**](ApplicationPackageRegistryApi.md#applicationPackageRegistryDeleteDefaultAssociation) | **DELETE** /as/applications/{application_ids.application_id}/packages/associations/{f_port} | DeleteDefaultAssociation removes the default association on the FPort of the application.
[**applicationPackageRegistryGetAssociation**](ApplicationPackageRegistryApi.md#applicationPackageRegistryGetAssociation) | **GET** /as/applications/{ids.end_device_ids.application_ids.application_id}/devices/{ids.end_device_ids.device_id}/packages/associations/{ids.f_port} | GetAssociation returns the association registered on the FPort of the end device.
[**applicationPackageRegistryGetDefaultAssociation**](ApplicationPackageRegistryApi.md#applicationPackageRegistryGetDefaultAssociation) | **GET** /as/applications/{ids.application_ids.application_id}/packages/associations/{ids.f_port} | GetDefaultAssociation returns the default association registered on the FPort of the application.
[**applicationPackageRegistryList**](ApplicationPackageRegistryApi.md#applicationPackageRegistryList) | **GET** /as/applications/{application_ids.application_id}/devices/{device_id}/packages | List returns the available packages for the end device.
[**applicationPackageRegistryListAssociations**](ApplicationPackageRegistryApi.md#applicationPackageRegistryListAssociations) | **GET** /as/applications/{ids.application_ids.application_id}/devices/{ids.device_id}/packages/associations | ListAssociations returns all of the associations of the end device.
[**applicationPackageRegistryListDefaultAssociations**](ApplicationPackageRegistryApi.md#applicationPackageRegistryListDefaultAssociations) | **GET** /as/applications/{ids.application_id}/packages/associations | ListDefaultAssociations returns all of the default associations of the application.
[**applicationPackageRegistrySetAssociation**](ApplicationPackageRegistryApi.md#applicationPackageRegistrySetAssociation) | **PUT** /as/applications/{association.ids.end_device_ids.application_ids.application_id}/devices/{association.ids.end_device_ids.device_id}/packages/associations/{association.ids.f_port} | SetAssociation updates or creates the association on the FPort of the end device.
[**applicationPackageRegistrySetDefaultAssociation**](ApplicationPackageRegistryApi.md#applicationPackageRegistrySetDefaultAssociation) | **PUT** /as/applications/{default.ids.application_ids.application_id}/packages/associations/{default.ids.f_port} | SetDefaultAssociation updates or creates the default association on the FPort of the application.


<a name="applicationPackageRegistryDeleteAssociation"></a>
# **applicationPackageRegistryDeleteAssociation**
> kotlin.Any applicationPackageRegistryDeleteAssociation(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, fPort, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr)

DeleteAssociation removes the association on the FPort of the end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val endDeviceIdsApplicationIdsApplicationId : kotlin.String = endDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val endDeviceIdsDeviceId : kotlin.String = endDeviceIdsDeviceId_example // kotlin.String | 
val fPort : kotlin.Long = 789 // kotlin.Long | 
val endDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val endDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val endDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : kotlin.Any = apiInstance.applicationPackageRegistryDeleteAssociation(endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId, fPort, endDeviceIdsDevEui, endDeviceIdsJoinEui, endDeviceIdsDevAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryDeleteAssociation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryDeleteAssociation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **endDeviceIdsDeviceId** | **kotlin.String**|  |
 **fPort** | **kotlin.Long**|  |
 **endDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **endDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **endDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistryDeleteDefaultAssociation"></a>
# **applicationPackageRegistryDeleteDefaultAssociation**
> kotlin.Any applicationPackageRegistryDeleteDefaultAssociation(applicationIdsApplicationId, fPort)

DeleteDefaultAssociation removes the default association on the FPort of the application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fPort : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : kotlin.Any = apiInstance.applicationPackageRegistryDeleteDefaultAssociation(applicationIdsApplicationId, fPort)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryDeleteDefaultAssociation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryDeleteDefaultAssociation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fPort** | **kotlin.Long**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistryGetAssociation"></a>
# **applicationPackageRegistryGetAssociation**
> V3ApplicationPackageAssociation applicationPackageRegistryGetAssociation(idsEndDeviceIdsApplicationIdsApplicationId, idsEndDeviceIdsDeviceId, idsFPort, idsEndDeviceIdsDevEui, idsEndDeviceIdsJoinEui, idsEndDeviceIdsDevAddr, fieldMaskPaths)

GetAssociation returns the association registered on the FPort of the end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val idsEndDeviceIdsApplicationIdsApplicationId : kotlin.String = idsEndDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val idsEndDeviceIdsDeviceId : kotlin.String = idsEndDeviceIdsDeviceId_example // kotlin.String | 
val idsFPort : kotlin.Long = 789 // kotlin.Long | 
val idsEndDeviceIdsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val idsEndDeviceIdsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val idsEndDeviceIdsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationPackageAssociation = apiInstance.applicationPackageRegistryGetAssociation(idsEndDeviceIdsApplicationIdsApplicationId, idsEndDeviceIdsDeviceId, idsFPort, idsEndDeviceIdsDevEui, idsEndDeviceIdsJoinEui, idsEndDeviceIdsDevAddr, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryGetAssociation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryGetAssociation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsEndDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **idsEndDeviceIdsDeviceId** | **kotlin.String**|  |
 **idsFPort** | **kotlin.Long**|  |
 **idsEndDeviceIdsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **idsEndDeviceIdsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **idsEndDeviceIdsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationPackageAssociation**](V3ApplicationPackageAssociation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistryGetDefaultAssociation"></a>
# **applicationPackageRegistryGetDefaultAssociation**
> V3ApplicationPackageDefaultAssociation applicationPackageRegistryGetDefaultAssociation(idsApplicationIdsApplicationId, idsFPort, fieldMaskPaths)

GetDefaultAssociation returns the default association registered on the FPort of the application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val idsApplicationIdsApplicationId : kotlin.String = idsApplicationIdsApplicationId_example // kotlin.String | 
val idsFPort : kotlin.Long = 789 // kotlin.Long | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationPackageDefaultAssociation = apiInstance.applicationPackageRegistryGetDefaultAssociation(idsApplicationIdsApplicationId, idsFPort, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryGetDefaultAssociation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryGetDefaultAssociation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsApplicationIdsApplicationId** | **kotlin.String**|  |
 **idsFPort** | **kotlin.Long**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationPackageDefaultAssociation**](V3ApplicationPackageDefaultAssociation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistryList"></a>
# **applicationPackageRegistryList**
> V3ApplicationPackages applicationPackageRegistryList(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)

List returns the available packages for the end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val deviceId : kotlin.String = deviceId_example // kotlin.String | 
val devEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val joinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val devAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
try {
    val result : V3ApplicationPackages = apiInstance.applicationPackageRegistryList(applicationIdsApplicationId, deviceId, devEui, joinEui, devAddr)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **deviceId** | **kotlin.String**|  |
 **devEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **joinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **devAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]

### Return type

[**V3ApplicationPackages**](V3ApplicationPackages.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistryListAssociations"></a>
# **applicationPackageRegistryListAssociations**
> V3ApplicationPackageAssociations applicationPackageRegistryListAssociations(idsApplicationIdsApplicationId, idsDeviceId, idsDevEui, idsJoinEui, idsDevAddr, limit, page, fieldMaskPaths)

ListAssociations returns all of the associations of the end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val idsApplicationIdsApplicationId : kotlin.String = idsApplicationIdsApplicationId_example // kotlin.String | 
val idsDeviceId : kotlin.String = idsDeviceId_example // kotlin.String | 
val idsDevEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevEUI.
val idsJoinEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices).
val idsDevAddr : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | The LoRaWAN DevAddr.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page. Each page is ordered by the FPort.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationPackageAssociations = apiInstance.applicationPackageRegistryListAssociations(idsApplicationIdsApplicationId, idsDeviceId, idsDevEui, idsJoinEui, idsDevAddr, limit, page, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryListAssociations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryListAssociations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsApplicationIdsApplicationId** | **kotlin.String**|  |
 **idsDeviceId** | **kotlin.String**|  |
 **idsDevEui** | **kotlin.ByteArray**| The LoRaWAN DevEUI. | [optional]
 **idsJoinEui** | **kotlin.ByteArray**| The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). | [optional]
 **idsDevAddr** | **kotlin.ByteArray**| The LoRaWAN DevAddr. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. Each page is ordered by the FPort. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationPackageAssociations**](V3ApplicationPackageAssociations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistryListDefaultAssociations"></a>
# **applicationPackageRegistryListDefaultAssociations**
> V3ApplicationPackageDefaultAssociations applicationPackageRegistryListDefaultAssociations(idsApplicationId, limit, page, fieldMaskPaths)

ListDefaultAssociations returns all of the default associations of the application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val idsApplicationId : kotlin.String = idsApplicationId_example // kotlin.String | 
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page. Each page is ordered by the FPort.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3ApplicationPackageDefaultAssociations = apiInstance.applicationPackageRegistryListDefaultAssociations(idsApplicationId, limit, page, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryListDefaultAssociations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistryListDefaultAssociations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idsApplicationId** | **kotlin.String**|  |
 **limit** | **kotlin.Long**| Limit the number of results per page. Each page is ordered by the FPort. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3ApplicationPackageDefaultAssociations**](V3ApplicationPackageDefaultAssociations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationPackageRegistrySetAssociation"></a>
# **applicationPackageRegistrySetAssociation**
> V3ApplicationPackageAssociation applicationPackageRegistrySetAssociation(associationIdsEndDeviceIdsApplicationIdsApplicationId, associationIdsEndDeviceIdsDeviceId, associationIdsFPort, body)

SetAssociation updates or creates the association on the FPort of the end device.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val associationIdsEndDeviceIdsApplicationIdsApplicationId : kotlin.String = associationIdsEndDeviceIdsApplicationIdsApplicationId_example // kotlin.String | 
val associationIdsEndDeviceIdsDeviceId : kotlin.String = associationIdsEndDeviceIdsDeviceId_example // kotlin.String | 
val associationIdsFPort : kotlin.Long = 789 // kotlin.Long | 
val body : V3SetApplicationPackageAssociationRequest =  // V3SetApplicationPackageAssociationRequest | 
try {
    val result : V3ApplicationPackageAssociation = apiInstance.applicationPackageRegistrySetAssociation(associationIdsEndDeviceIdsApplicationIdsApplicationId, associationIdsEndDeviceIdsDeviceId, associationIdsFPort, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistrySetAssociation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistrySetAssociation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **associationIdsEndDeviceIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **associationIdsEndDeviceIdsDeviceId** | **kotlin.String**|  |
 **associationIdsFPort** | **kotlin.Long**|  |
 **body** | [**V3SetApplicationPackageAssociationRequest**](V3SetApplicationPackageAssociationRequest.md)|  |

### Return type

[**V3ApplicationPackageAssociation**](V3ApplicationPackageAssociation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationPackageRegistrySetDefaultAssociation"></a>
# **applicationPackageRegistrySetDefaultAssociation**
> V3ApplicationPackageDefaultAssociation applicationPackageRegistrySetDefaultAssociation(defaultIdsApplicationIdsApplicationId, defaultIdsFPort, body)

SetDefaultAssociation updates or creates the default association on the FPort of the application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationPackageRegistryApi()
val defaultIdsApplicationIdsApplicationId : kotlin.String = defaultIdsApplicationIdsApplicationId_example // kotlin.String | 
val defaultIdsFPort : kotlin.Long = 789 // kotlin.Long | 
val body : V3SetApplicationPackageDefaultAssociationRequest =  // V3SetApplicationPackageDefaultAssociationRequest | 
try {
    val result : V3ApplicationPackageDefaultAssociation = apiInstance.applicationPackageRegistrySetDefaultAssociation(defaultIdsApplicationIdsApplicationId, defaultIdsFPort, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationPackageRegistryApi#applicationPackageRegistrySetDefaultAssociation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationPackageRegistryApi#applicationPackageRegistrySetDefaultAssociation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **defaultIdsApplicationIdsApplicationId** | **kotlin.String**|  |
 **defaultIdsFPort** | **kotlin.Long**|  |
 **body** | [**V3SetApplicationPackageDefaultAssociationRequest**](V3SetApplicationPackageDefaultAssociationRequest.md)|  |

### Return type

[**V3ApplicationPackageDefaultAssociation**](V3ApplicationPackageDefaultAssociation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

