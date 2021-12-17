# UserSessionRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userSessionRegistryDelete**](UserSessionRegistryApi.md#userSessionRegistryDelete) | **DELETE** /users/{user_ids.user_id}/sessions/{session_id} | Delete (revoke) the given user session.
[**userSessionRegistryList**](UserSessionRegistryApi.md#userSessionRegistryList) | **GET** /users/{user_ids.user_id}/sessions | List the active sessions for the given user.


<a name="userSessionRegistryDelete"></a>
# **userSessionRegistryDelete**
> kotlin.Any userSessionRegistryDelete(userIdsUserId, sessionId, userIdsEmail)

Delete (revoke) the given user session.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserSessionRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val sessionId : kotlin.String = sessionId_example // kotlin.String | 
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.userSessionRegistryDelete(userIdsUserId, sessionId, userIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserSessionRegistryApi#userSessionRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserSessionRegistryApi#userSessionRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **sessionId** | **kotlin.String**|  |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userSessionRegistryList"></a>
# **userSessionRegistryList**
> V3UserSessions userSessionRegistryList(userIdsUserId, userIdsEmail, order, limit, page)

List the active sessions for the given user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserSessionRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3UserSessions = apiInstance.userSessionRegistryList(userIdsUserId, userIdsEmail, order, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserSessionRegistryApi#userSessionRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserSessionRegistryApi#userSessionRegistryList")
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

[**V3UserSessions**](V3UserSessions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

