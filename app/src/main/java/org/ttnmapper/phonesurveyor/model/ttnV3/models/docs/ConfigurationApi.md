# ConfigurationApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**configurationGetPhyVersions**](ConfigurationApi.md#configurationGetPhyVersions) | **GET** /configuration/phy-versions | Returns a list of supported LoRaWAN PHY Versions for the given Band ID.
[**configurationListFrequencyPlans**](ConfigurationApi.md#configurationListFrequencyPlans) | **GET** /configuration/frequency-plans | 


<a name="configurationGetPhyVersions"></a>
# **configurationGetPhyVersions**
> V3GetPhyVersionsResponse configurationGetPhyVersions(bandId)

Returns a list of supported LoRaWAN PHY Versions for the given Band ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ConfigurationApi()
val bandId : kotlin.String = bandId_example // kotlin.String | Optional Band ID to filter the results. If unused, all supported Bands and their versions are returned.
try {
    val result : V3GetPhyVersionsResponse = apiInstance.configurationGetPhyVersions(bandId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigurationApi#configurationGetPhyVersions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigurationApi#configurationGetPhyVersions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bandId** | **kotlin.String**| Optional Band ID to filter the results. If unused, all supported Bands and their versions are returned. | [optional]

### Return type

[**V3GetPhyVersionsResponse**](V3GetPhyVersionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="configurationListFrequencyPlans"></a>
# **configurationListFrequencyPlans**
> V3ListFrequencyPlansResponse configurationListFrequencyPlans(baseFrequency)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ConfigurationApi()
val baseFrequency : kotlin.Long = 789 // kotlin.Long | Optional base frequency in MHz for hardware support (433, 470, 868 or 915).
try {
    val result : V3ListFrequencyPlansResponse = apiInstance.configurationListFrequencyPlans(baseFrequency)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigurationApi#configurationListFrequencyPlans")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigurationApi#configurationListFrequencyPlans")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **baseFrequency** | **kotlin.Long**| Optional base frequency in MHz for hardware support (433, 470, 868 or 915). | [optional]

### Return type

[**V3ListFrequencyPlansResponse**](V3ListFrequencyPlansResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

