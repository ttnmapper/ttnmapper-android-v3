# EntityRegistrySearchApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**entityRegistrySearchSearchApplications**](EntityRegistrySearchApi.md#entityRegistrySearchSearchApplications) | **GET** /search/applications | Search for applications that match the conditions specified in the request. Non-admin users will only match applications that they have rights on.
[**entityRegistrySearchSearchClients**](EntityRegistrySearchApi.md#entityRegistrySearchSearchClients) | **GET** /search/clients | Search for OAuth clients that match the conditions specified in the request. Non-admin users will only match OAuth clients that they have rights on.
[**entityRegistrySearchSearchGateways**](EntityRegistrySearchApi.md#entityRegistrySearchSearchGateways) | **GET** /search/gateways | Search for gateways that match the conditions specified in the request. Non-admin users will only match gateways that they have rights on.
[**entityRegistrySearchSearchOrganizations**](EntityRegistrySearchApi.md#entityRegistrySearchSearchOrganizations) | **GET** /search/organizations | Search for organizations that match the conditions specified in the request. Non-admin users will only match organizations that they have rights on.
[**entityRegistrySearchSearchUsers**](EntityRegistrySearchApi.md#entityRegistrySearchSearchUsers) | **GET** /search/users | Search for users that match the conditions specified in the request. This is only available to admin users.


<a name="entityRegistrySearchSearchApplications"></a>
# **entityRegistrySearchSearchApplications**
> V3Applications entityRegistrySearchSearchApplications(idContains, nameContains, descriptionContains, fieldMaskPaths, order, limit, page, deleted)

Search for applications that match the conditions specified in the request. Non-admin users will only match applications that they have rights on.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EntityRegistrySearchApi()
val idContains : kotlin.String = idContains_example // kotlin.String | Find applications where the ID contains this substring.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Find applications where the name contains this substring.
val descriptionContains : kotlin.String = descriptionContains_example // kotlin.String | Find applications where the description contains this substring.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted applications.
try {
    val result : V3Applications = apiInstance.entityRegistrySearchSearchApplications(idContains, nameContains, descriptionContains, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchApplications")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchApplications")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idContains** | **kotlin.String**| Find applications where the ID contains this substring. | [optional]
 **nameContains** | **kotlin.String**| Find applications where the name contains this substring. | [optional]
 **descriptionContains** | **kotlin.String**| Find applications where the description contains this substring. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted applications. | [optional]

### Return type

[**V3Applications**](V3Applications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entityRegistrySearchSearchClients"></a>
# **entityRegistrySearchSearchClients**
> V3Clients entityRegistrySearchSearchClients(idContains, nameContains, descriptionContains, state, fieldMaskPaths, order, limit, page, deleted)

Search for OAuth clients that match the conditions specified in the request. Non-admin users will only match OAuth clients that they have rights on.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EntityRegistrySearchApi()
val idContains : kotlin.String = idContains_example // kotlin.String | Find OAuth clients where the ID contains this substring.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Find OAuth clients where the name contains this substring.
val descriptionContains : kotlin.String = descriptionContains_example // kotlin.String | Find OAuth clients where the description contains this substring.
val state : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Find OAuth clients where the state is any of these states.   - STATE_REQUESTED: Denotes that the entity has been requested and is pending review by an admin.  - STATE_APPROVED: Denotes that the entity has been reviewed and approved by an admin.  - STATE_REJECTED: Denotes that the entity has been reviewed and rejected by an admin.  - STATE_FLAGGED: Denotes that the entity has been flagged and is pending review by an admin.  - STATE_SUSPENDED: Denotes that the entity has been reviewed and suspended by an admin.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted OAuth clients.
try {
    val result : V3Clients = apiInstance.entityRegistrySearchSearchClients(idContains, nameContains, descriptionContains, state, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchClients")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchClients")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idContains** | **kotlin.String**| Find OAuth clients where the ID contains this substring. | [optional]
 **nameContains** | **kotlin.String**| Find OAuth clients where the name contains this substring. | [optional]
 **descriptionContains** | **kotlin.String**| Find OAuth clients where the description contains this substring. | [optional]
 **state** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Find OAuth clients where the state is any of these states.   - STATE_REQUESTED: Denotes that the entity has been requested and is pending review by an admin.  - STATE_APPROVED: Denotes that the entity has been reviewed and approved by an admin.  - STATE_REJECTED: Denotes that the entity has been reviewed and rejected by an admin.  - STATE_FLAGGED: Denotes that the entity has been flagged and is pending review by an admin.  - STATE_SUSPENDED: Denotes that the entity has been reviewed and suspended by an admin. | [optional] [enum: STATE_REQUESTED, STATE_APPROVED, STATE_REJECTED, STATE_FLAGGED, STATE_SUSPENDED]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted OAuth clients. | [optional]

### Return type

[**V3Clients**](V3Clients.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entityRegistrySearchSearchGateways"></a>
# **entityRegistrySearchSearchGateways**
> V3Gateways entityRegistrySearchSearchGateways(idContains, nameContains, descriptionContains, euiContains, fieldMaskPaths, order, limit, page, deleted)

Search for gateways that match the conditions specified in the request. Non-admin users will only match gateways that they have rights on.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EntityRegistrySearchApi()
val idContains : kotlin.String = idContains_example // kotlin.String | Find gateways where the ID contains this substring.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Find gateways where the name contains this substring.
val descriptionContains : kotlin.String = descriptionContains_example // kotlin.String | Find gateways where the description contains this substring.
val euiContains : kotlin.String = euiContains_example // kotlin.String | Find gateways where the (hexadecimal) EUI contains this substring.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted gateways.
try {
    val result : V3Gateways = apiInstance.entityRegistrySearchSearchGateways(idContains, nameContains, descriptionContains, euiContains, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchGateways")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchGateways")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idContains** | **kotlin.String**| Find gateways where the ID contains this substring. | [optional]
 **nameContains** | **kotlin.String**| Find gateways where the name contains this substring. | [optional]
 **descriptionContains** | **kotlin.String**| Find gateways where the description contains this substring. | [optional]
 **euiContains** | **kotlin.String**| Find gateways where the (hexadecimal) EUI contains this substring. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted gateways. | [optional]

### Return type

[**V3Gateways**](V3Gateways.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entityRegistrySearchSearchOrganizations"></a>
# **entityRegistrySearchSearchOrganizations**
> V3Organizations entityRegistrySearchSearchOrganizations(idContains, nameContains, descriptionContains, fieldMaskPaths, order, limit, page, deleted)

Search for organizations that match the conditions specified in the request. Non-admin users will only match organizations that they have rights on.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EntityRegistrySearchApi()
val idContains : kotlin.String = idContains_example // kotlin.String | Find organizations where the ID contains this substring.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Find organizations where the name contains this substring.
val descriptionContains : kotlin.String = descriptionContains_example // kotlin.String | Find organizations where the description contains this substring.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted organizations.
try {
    val result : V3Organizations = apiInstance.entityRegistrySearchSearchOrganizations(idContains, nameContains, descriptionContains, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchOrganizations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchOrganizations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idContains** | **kotlin.String**| Find organizations where the ID contains this substring. | [optional]
 **nameContains** | **kotlin.String**| Find organizations where the name contains this substring. | [optional]
 **descriptionContains** | **kotlin.String**| Find organizations where the description contains this substring. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted organizations. | [optional]

### Return type

[**V3Organizations**](V3Organizations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entityRegistrySearchSearchUsers"></a>
# **entityRegistrySearchSearchUsers**
> V3Users entityRegistrySearchSearchUsers(idContains, nameContains, descriptionContains, state, fieldMaskPaths, order, limit, page, deleted)

Search for users that match the conditions specified in the request. This is only available to admin users.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EntityRegistrySearchApi()
val idContains : kotlin.String = idContains_example // kotlin.String | Find users where the ID contains this substring.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Find users where the name contains this substring.
val descriptionContains : kotlin.String = descriptionContains_example // kotlin.String | Find users where the description contains this substring.
val state : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Find users where the state is any of these states.   - STATE_REQUESTED: Denotes that the entity has been requested and is pending review by an admin.  - STATE_APPROVED: Denotes that the entity has been reviewed and approved by an admin.  - STATE_REJECTED: Denotes that the entity has been reviewed and rejected by an admin.  - STATE_FLAGGED: Denotes that the entity has been flagged and is pending review by an admin.  - STATE_SUSPENDED: Denotes that the entity has been reviewed and suspended by an admin.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted users.
try {
    val result : V3Users = apiInstance.entityRegistrySearchSearchUsers(idContains, nameContains, descriptionContains, state, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EntityRegistrySearchApi#entityRegistrySearchSearchUsers")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idContains** | **kotlin.String**| Find users where the ID contains this substring. | [optional]
 **nameContains** | **kotlin.String**| Find users where the name contains this substring. | [optional]
 **descriptionContains** | **kotlin.String**| Find users where the description contains this substring. | [optional]
 **state** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Find users where the state is any of these states.   - STATE_REQUESTED: Denotes that the entity has been requested and is pending review by an admin.  - STATE_APPROVED: Denotes that the entity has been reviewed and approved by an admin.  - STATE_REJECTED: Denotes that the entity has been reviewed and rejected by an admin.  - STATE_FLAGGED: Denotes that the entity has been flagged and is pending review by an admin.  - STATE_SUSPENDED: Denotes that the entity has been reviewed and suspended by an admin. | [optional] [enum: STATE_REQUESTED, STATE_APPROVED, STATE_REJECTED, STATE_FLAGGED, STATE_SUSPENDED]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted users. | [optional]

### Return type

[**V3Users**](V3Users.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

