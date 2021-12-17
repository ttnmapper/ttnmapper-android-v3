# NsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**nsGenerateDevAddr**](NsApi.md#nsGenerateDevAddr) | **GET** /ns/dev_addr | GenerateDevAddr requests a device address assignment from the Network Server.
[**nsGetDefaultMACSettings**](NsApi.md#nsGetDefaultMACSettings) | **GET** /ns/default_mac_settings/{frequency_plan_id}/{lorawan_phy_version} | GetDefaultMACSettings retrieves the default MAC settings for a frequency plan.


<a name="nsGenerateDevAddr"></a>
# **nsGenerateDevAddr**
> V3GenerateDevAddrResponse nsGenerateDevAddr()

GenerateDevAddr requests a device address assignment from the Network Server.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsApi()
try {
    val result : V3GenerateDevAddrResponse = apiInstance.nsGenerateDevAddr()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsApi#nsGenerateDevAddr")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsApi#nsGenerateDevAddr")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3GenerateDevAddrResponse**](V3GenerateDevAddrResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="nsGetDefaultMACSettings"></a>
# **nsGetDefaultMACSettings**
> V3MACSettings nsGetDefaultMACSettings(frequencyPlanId, lorawanPhyVersion)

GetDefaultMACSettings retrieves the default MAC settings for a frequency plan.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NsApi()
val frequencyPlanId : kotlin.String = frequencyPlanId_example // kotlin.String | 
val lorawanPhyVersion : kotlin.String = lorawanPhyVersion_example // kotlin.String | 
try {
    val result : V3MACSettings = apiInstance.nsGetDefaultMACSettings(frequencyPlanId, lorawanPhyVersion)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NsApi#nsGetDefaultMACSettings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NsApi#nsGetDefaultMACSettings")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **frequencyPlanId** | **kotlin.String**|  |
 **lorawanPhyVersion** | **kotlin.String**|  | [enum: PHY_UNKNOWN, TS001_V1_0, TS001_V1_0_1, RP001_V1_0_2, RP001_V1_0_2_REV_B, RP001_V1_1_REV_A, RP001_V1_1_REV_B, RP001_V1_0_3_REV_A, RP002_V1_0_0, RP002_V1_0_1, RP002_V1_0_2, RP002_V1_0_3]

### Return type

[**V3MACSettings**](V3MACSettings.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

