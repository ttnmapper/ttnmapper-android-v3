# UserAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userAccessCreateAPIKey**](UserAccessApi.md#userAccessCreateAPIKey) | **POST** /users/{user_ids.user_id}/api-keys | Create an API key scoped to this user. User API keys can give access to the user itself, as well as any organization, application, gateway and OAuth client this user is a collaborator of.
[**userAccessCreateLoginToken**](UserAccessApi.md#userAccessCreateLoginToken) | **POST** /users/{user_ids.user_id}/login-tokens | Create a login token that can be used for a one-time login as a user.
[**userAccessGetAPIKey**](UserAccessApi.md#userAccessGetAPIKey) | **GET** /users/{user_ids.user_id}/api-keys/{key_id} | Get a single API key of this user.
[**userAccessListAPIKeys**](UserAccessApi.md#userAccessListAPIKeys) | **GET** /users/{user_ids.user_id}/api-keys | List the API keys for this user.
[**userAccessListRights**](UserAccessApi.md#userAccessListRights) | **GET** /users/{user_id}/rights | List the rights the caller has on this user.
[**userAccessUpdateAPIKey**](UserAccessApi.md#userAccessUpdateAPIKey) | **PUT** /users/{user_ids.user_id}/api-keys/{api_key.id} | Update the rights of an API key of the user. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.


<a name="userAccessCreateAPIKey"></a>
# **userAccessCreateAPIKey**
> V3APIKey userAccessCreateAPIKey(userIdsUserId, body)

Create an API key scoped to this user. User API keys can give access to the user itself, as well as any organization, application, gateway and OAuth client this user is a collaborator of.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserAccessApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3CreateUserAPIKeyRequest =  // V3CreateUserAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.userAccessCreateAPIKey(userIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserAccessApi#userAccessCreateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserAccessApi#userAccessCreateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3CreateUserAPIKeyRequest**](V3CreateUserAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="userAccessCreateLoginToken"></a>
# **userAccessCreateLoginToken**
> V3CreateLoginTokenResponse userAccessCreateLoginToken(userIdsUserId)

Create a login token that can be used for a one-time login as a user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserAccessApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
try {
    val result : V3CreateLoginTokenResponse = apiInstance.userAccessCreateLoginToken(userIdsUserId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserAccessApi#userAccessCreateLoginToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserAccessApi#userAccessCreateLoginToken")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |

### Return type

[**V3CreateLoginTokenResponse**](V3CreateLoginTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userAccessGetAPIKey"></a>
# **userAccessGetAPIKey**
> V3APIKey userAccessGetAPIKey(userIdsUserId, keyId, userIdsEmail)

Get a single API key of this user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserAccessApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val keyId : kotlin.String = keyId_example // kotlin.String | Unique public identifier for the API key.
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3APIKey = apiInstance.userAccessGetAPIKey(userIdsUserId, keyId, userIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserAccessApi#userAccessGetAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserAccessApi#userAccessGetAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **keyId** | **kotlin.String**| Unique public identifier for the API key. |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userAccessListAPIKeys"></a>
# **userAccessListAPIKeys**
> V3APIKeys userAccessListAPIKeys(userIdsUserId, userIdsEmail, limit, page)

List the API keys for this user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserAccessApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3APIKeys = apiInstance.userAccessListAPIKeys(userIdsUserId, userIdsEmail, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserAccessApi#userAccessListAPIKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserAccessApi#userAccessListAPIKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3APIKeys**](V3APIKeys.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userAccessListRights"></a>
# **userAccessListRights**
> V3Rights userAccessListRights(userId, email)

List the rights the caller has on this user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserAccessApi()
val userId : kotlin.String = userId_example // kotlin.String | This ID shares namespace with organization IDs.
val email : kotlin.String = email_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3Rights = apiInstance.userAccessListRights(userId, email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserAccessApi#userAccessListRights")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserAccessApi#userAccessListRights")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **email** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3Rights**](V3Rights.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userAccessUpdateAPIKey"></a>
# **userAccessUpdateAPIKey**
> V3APIKey userAccessUpdateAPIKey(userIdsUserId, apiKeyId, body)

Update the rights of an API key of the user. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserAccessApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val apiKeyId : kotlin.String = apiKeyId_example // kotlin.String | Immutable and unique public identifier for the API key. Generated by the Access Server.
val body : V3UpdateUserAPIKeyRequest =  // V3UpdateUserAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.userAccessUpdateAPIKey(userIdsUserId, apiKeyId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserAccessApi#userAccessUpdateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserAccessApi#userAccessUpdateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **apiKeyId** | **kotlin.String**| Immutable and unique public identifier for the API key. Generated by the Access Server. |
 **body** | [**V3UpdateUserAPIKeyRequest**](V3UpdateUserAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

