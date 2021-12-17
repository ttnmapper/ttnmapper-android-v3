# OAuthAuthorizationRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**oAuthAuthorizationRegistryDelete**](OAuthAuthorizationRegistryApi.md#oAuthAuthorizationRegistryDelete) | **DELETE** /users/{user_ids.user_id}/authorizations/{client_ids.client_id} | Delete (de-authorize) an OAuth client for the user.
[**oAuthAuthorizationRegistryDeleteToken**](OAuthAuthorizationRegistryApi.md#oAuthAuthorizationRegistryDeleteToken) | **DELETE** /users/{user_ids.user_id}/authorizations/{client_ids.client_id}/tokens/{id} | Delete (invalidate) an OAuth access token.
[**oAuthAuthorizationRegistryList**](OAuthAuthorizationRegistryApi.md#oAuthAuthorizationRegistryList) | **GET** /users/{user_ids.user_id}/authorizations | List OAuth clients that are authorized by the user.
[**oAuthAuthorizationRegistryListTokens**](OAuthAuthorizationRegistryApi.md#oAuthAuthorizationRegistryListTokens) | **GET** /users/{user_ids.user_id}/authorizations/{client_ids.client_id}/tokens | List OAuth access tokens issued to the OAuth client on behalf of the user.


<a name="oAuthAuthorizationRegistryDelete"></a>
# **oAuthAuthorizationRegistryDelete**
> kotlin.Any oAuthAuthorizationRegistryDelete(userIdsUserId, clientIdsClientId, userIdsEmail)

Delete (de-authorize) an OAuth client for the user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OAuthAuthorizationRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.oAuthAuthorizationRegistryDelete(userIdsUserId, clientIdsClientId, userIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **clientIdsClientId** | **kotlin.String**|  |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oAuthAuthorizationRegistryDeleteToken"></a>
# **oAuthAuthorizationRegistryDeleteToken**
> kotlin.Any oAuthAuthorizationRegistryDeleteToken(userIdsUserId, clientIdsClientId, id, userIdsEmail)

Delete (invalidate) an OAuth access token.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OAuthAuthorizationRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val id : kotlin.String = id_example // kotlin.String | 
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.oAuthAuthorizationRegistryDeleteToken(userIdsUserId, clientIdsClientId, id, userIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryDeleteToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryDeleteToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **clientIdsClientId** | **kotlin.String**|  |
 **id** | **kotlin.String**|  |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oAuthAuthorizationRegistryList"></a>
# **oAuthAuthorizationRegistryList**
> V3OAuthClientAuthorizations oAuthAuthorizationRegistryList(userIdsUserId, userIdsEmail, order, limit, page)

List OAuth clients that are authorized by the user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OAuthAuthorizationRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3OAuthClientAuthorizations = apiInstance.oAuthAuthorizationRegistryList(userIdsUserId, userIdsEmail, order, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3OAuthClientAuthorizations**](V3OAuthClientAuthorizations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="oAuthAuthorizationRegistryListTokens"></a>
# **oAuthAuthorizationRegistryListTokens**
> V3OAuthAccessTokens oAuthAuthorizationRegistryListTokens(userIdsUserId, clientIdsClientId, userIdsEmail, order, limit, page)

List OAuth access tokens issued to the OAuth client on behalf of the user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OAuthAuthorizationRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3OAuthAccessTokens = apiInstance.oAuthAuthorizationRegistryListTokens(userIdsUserId, clientIdsClientId, userIdsEmail, order, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryListTokens")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OAuthAuthorizationRegistryApi#oAuthAuthorizationRegistryListTokens")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **clientIdsClientId** | **kotlin.String**|  |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3OAuthAccessTokens**](V3OAuthAccessTokens.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

