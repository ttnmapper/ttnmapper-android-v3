# UserInvitationRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userInvitationRegistryDelete**](UserInvitationRegistryApi.md#userInvitationRegistryDelete) | **DELETE** /invitations | Delete (revoke) a user invitation.
[**userInvitationRegistryList**](UserInvitationRegistryApi.md#userInvitationRegistryList) | **GET** /invitations | List the invitations the caller has sent.
[**userInvitationRegistrySend**](UserInvitationRegistryApi.md#userInvitationRegistrySend) | **POST** /invitations | Invite a user to join the network.


<a name="userInvitationRegistryDelete"></a>
# **userInvitationRegistryDelete**
> kotlin.Any userInvitationRegistryDelete(email)

Delete (revoke) a user invitation.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserInvitationRegistryApi()
val email : kotlin.String = email_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.userInvitationRegistryDelete(email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserInvitationRegistryApi#userInvitationRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserInvitationRegistryApi#userInvitationRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userInvitationRegistryList"></a>
# **userInvitationRegistryList**
> V3Invitations userInvitationRegistryList(limit, page)

List the invitations the caller has sent.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserInvitationRegistryApi()
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3Invitations = apiInstance.userInvitationRegistryList(limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserInvitationRegistryApi#userInvitationRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserInvitationRegistryApi#userInvitationRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3Invitations**](V3Invitations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userInvitationRegistrySend"></a>
# **userInvitationRegistrySend**
> Lorawanv3Invitation userInvitationRegistrySend(body)

Invite a user to join the network.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserInvitationRegistryApi()
val body : V3SendInvitationRequest =  // V3SendInvitationRequest | 
try {
    val result : Lorawanv3Invitation = apiInstance.userInvitationRegistrySend(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserInvitationRegistryApi#userInvitationRegistrySend")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserInvitationRegistryApi#userInvitationRegistrySend")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3SendInvitationRequest**](V3SendInvitationRequest.md)|  |

### Return type

[**Lorawanv3Invitation**](Lorawanv3Invitation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

