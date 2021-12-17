# EndDeviceRegistrySearchApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**endDeviceRegistrySearchSearchEndDevices**](EndDeviceRegistrySearchApi.md#endDeviceRegistrySearchSearchEndDevices) | **GET** /search/applications/{application_ids.application_id}/devices | Search for end devices in the given application that match the conditions specified in the request.


<a name="endDeviceRegistrySearchSearchEndDevices"></a>
# **endDeviceRegistrySearchSearchEndDevices**
> V3EndDevices endDeviceRegistrySearchSearchEndDevices(applicationIdsApplicationId, idContains, nameContains, descriptionContains, devEuiContains, joinEuiContains, devAddrContains, fieldMaskPaths, order, limit, page)

Search for end devices in the given application that match the conditions specified in the request.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EndDeviceRegistrySearchApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val idContains : kotlin.String = idContains_example // kotlin.String | Find end devices where the ID contains this substring.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Find end devices where the name contains this substring.
val descriptionContains : kotlin.String = descriptionContains_example // kotlin.String | Find end devices where the description contains this substring.
val devEuiContains : kotlin.String = devEuiContains_example // kotlin.String | Find end devices where the (hexadecimal) DevEUI contains this substring.
val joinEuiContains : kotlin.String = joinEuiContains_example // kotlin.String | Find end devices where the (hexadecimal) JoinEUI contains this substring.
val devAddrContains : kotlin.String = devAddrContains_example // kotlin.String | Find end devices where the (hexadecimal) DevAddr contains this substring.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3EndDevices = apiInstance.endDeviceRegistrySearchSearchEndDevices(applicationIdsApplicationId, idContains, nameContains, descriptionContains, devEuiContains, joinEuiContains, devAddrContains, fieldMaskPaths, order, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EndDeviceRegistrySearchApi#endDeviceRegistrySearchSearchEndDevices")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EndDeviceRegistrySearchApi#endDeviceRegistrySearchSearchEndDevices")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **idContains** | **kotlin.String**| Find end devices where the ID contains this substring. | [optional]
 **nameContains** | **kotlin.String**| Find end devices where the name contains this substring. | [optional]
 **descriptionContains** | **kotlin.String**| Find end devices where the description contains this substring. | [optional]
 **devEuiContains** | **kotlin.String**| Find end devices where the (hexadecimal) DevEUI contains this substring. | [optional]
 **joinEuiContains** | **kotlin.String**| Find end devices where the (hexadecimal) JoinEUI contains this substring. | [optional]
 **devAddrContains** | **kotlin.String**| Find end devices where the (hexadecimal) DevAddr contains this substring. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3EndDevices**](V3EndDevices.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

