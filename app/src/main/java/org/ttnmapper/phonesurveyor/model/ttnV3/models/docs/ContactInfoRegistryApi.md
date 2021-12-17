# ContactInfoRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**contactInfoRegistryRequestValidation**](ContactInfoRegistryApi.md#contactInfoRegistryRequestValidation) | **POST** /contact_info/validation | Request validation for the non-validated contact info for the given entity.
[**contactInfoRegistryValidate**](ContactInfoRegistryApi.md#contactInfoRegistryValidate) | **PATCH** /contact_info/validation | Validate confirms a contact info validation.


<a name="contactInfoRegistryRequestValidation"></a>
# **contactInfoRegistryRequestValidation**
> Lorawanv3ContactInfoValidation contactInfoRegistryRequestValidation(body)

Request validation for the non-validated contact info for the given entity.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ContactInfoRegistryApi()
val body : V3EntityIdentifiers =  // V3EntityIdentifiers | 
try {
    val result : Lorawanv3ContactInfoValidation = apiInstance.contactInfoRegistryRequestValidation(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactInfoRegistryApi#contactInfoRegistryRequestValidation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactInfoRegistryApi#contactInfoRegistryRequestValidation")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3EntityIdentifiers**](V3EntityIdentifiers.md)|  |

### Return type

[**Lorawanv3ContactInfoValidation**](Lorawanv3ContactInfoValidation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="contactInfoRegistryValidate"></a>
# **contactInfoRegistryValidate**
> kotlin.Any contactInfoRegistryValidate(body)

Validate confirms a contact info validation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ContactInfoRegistryApi()
val body : Lorawanv3ContactInfoValidation =  // Lorawanv3ContactInfoValidation | 
try {
    val result : kotlin.Any = apiInstance.contactInfoRegistryValidate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ContactInfoRegistryApi#contactInfoRegistryValidate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ContactInfoRegistryApi#contactInfoRegistryValidate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Lorawanv3ContactInfoValidation**](Lorawanv3ContactInfoValidation.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

