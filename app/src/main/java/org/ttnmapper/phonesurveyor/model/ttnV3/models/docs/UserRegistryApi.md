# UserRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userRegistryCreate**](UserRegistryApi.md#userRegistryCreate) | **POST** /users | Register a new user. This method may be restricted by network settings.
[**userRegistryCreateTemporaryPassword**](UserRegistryApi.md#userRegistryCreateTemporaryPassword) | **POST** /users/{user_ids.user_id}/temporary_password | Create a temporary password that can be used for updating a forgotten password. The generated password is sent to the user&#39;s email address.
[**userRegistryDelete**](UserRegistryApi.md#userRegistryDelete) | **DELETE** /users/{user_id} | Delete the user. This may not release the user ID for reuse.
[**userRegistryGet**](UserRegistryApi.md#userRegistryGet) | **GET** /users/{user_ids.user_id} | Get the user with the given identifiers, selecting the fields given by the field mask. The method may return more or less fields, depending on the rights of the caller.
[**userRegistryList**](UserRegistryApi.md#userRegistryList) | **GET** /users | List users of the network. This method is typically restricted to admins only.
[**userRegistryPurge**](UserRegistryApi.md#userRegistryPurge) | **DELETE** /users/{user_id}/purge | Purge the user. This will release the user ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.
[**userRegistryRestore**](UserRegistryApi.md#userRegistryRestore) | **POST** /users/{user_id}/restore | Restore a recently deleted user.
[**userRegistryUpdate**](UserRegistryApi.md#userRegistryUpdate) | **PUT** /users/{user.ids.user_id} | Update the user, changing the fields specified by the field mask to the provided values. This method can not be used to change the password, see the UpdatePassword method for that.
[**userRegistryUpdatePassword**](UserRegistryApi.md#userRegistryUpdatePassword) | **PUT** /users/{user_ids.user_id}/password | Update the password of the user.


<a name="userRegistryCreate"></a>
# **userRegistryCreate**
> V3User userRegistryCreate(body)

Register a new user. This method may be restricted by network settings.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val body : V3CreateUserRequest =  // V3CreateUserRequest | 
try {
    val result : V3User = apiInstance.userRegistryCreate(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3CreateUserRequest**](V3CreateUserRequest.md)|  |

### Return type

[**V3User**](V3User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="userRegistryCreateTemporaryPassword"></a>
# **userRegistryCreateTemporaryPassword**
> kotlin.Any userRegistryCreateTemporaryPassword(userIdsUserId)

Create a temporary password that can be used for updating a forgotten password. The generated password is sent to the user&#39;s email address.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
try {
    val result : kotlin.Any = apiInstance.userRegistryCreateTemporaryPassword(userIdsUserId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryCreateTemporaryPassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryCreateTemporaryPassword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userRegistryDelete"></a>
# **userRegistryDelete**
> kotlin.Any userRegistryDelete(userId, email)

Delete the user. This may not release the user ID for reuse.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userId : kotlin.String = userId_example // kotlin.String | This ID shares namespace with organization IDs.
val email : kotlin.String = email_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.userRegistryDelete(userId, email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **email** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userRegistryGet"></a>
# **userRegistryGet**
> V3User userRegistryGet(userIdsUserId, userIdsEmail, fieldMaskPaths)

Get the user with the given identifiers, selecting the fields given by the field mask. The method may return more or less fields, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val userIdsEmail : kotlin.String = userIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3User = apiInstance.userRegistryGet(userIdsUserId, userIdsEmail, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **userIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3User**](V3User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userRegistryList"></a>
# **userRegistryList**
> V3Users userRegistryList(fieldMaskPaths, order, limit, page, deleted)

List users of the network. This method is typically restricted to admins only.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted users.
try {
    val result : V3Users = apiInstance.userRegistryList(fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

<a name="userRegistryPurge"></a>
# **userRegistryPurge**
> kotlin.Any userRegistryPurge(userId, email)

Purge the user. This will release the user ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userId : kotlin.String = userId_example // kotlin.String | This ID shares namespace with organization IDs.
val email : kotlin.String = email_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.userRegistryPurge(userId, email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryPurge")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryPurge")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **email** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userRegistryRestore"></a>
# **userRegistryRestore**
> kotlin.Any userRegistryRestore(userId)

Restore a recently deleted user.

Deployment configuration may specify if, and for how long after deletion, entities can be restored.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userId : kotlin.String = userId_example // kotlin.String | This ID shares namespace with organization IDs.
try {
    val result : kotlin.Any = apiInstance.userRegistryRestore(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryRestore")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryRestore")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**| This ID shares namespace with organization IDs. |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userRegistryUpdate"></a>
# **userRegistryUpdate**
> V3User userRegistryUpdate(userIdsUserId, body)

Update the user, changing the fields specified by the field mask to the provided values. This method can not be used to change the password, see the UpdatePassword method for that.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3UpdateUserRequest =  // V3UpdateUserRequest | 
try {
    val result : V3User = apiInstance.userRegistryUpdate(userIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3UpdateUserRequest**](V3UpdateUserRequest.md)|  |

### Return type

[**V3User**](V3User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="userRegistryUpdatePassword"></a>
# **userRegistryUpdatePassword**
> kotlin.Any userRegistryUpdatePassword(userIdsUserId, body)

Update the password of the user.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserRegistryApi()
val userIdsUserId : kotlin.String = userIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3UpdateUserPasswordRequest =  // V3UpdateUserPasswordRequest | 
try {
    val result : kotlin.Any = apiInstance.userRegistryUpdatePassword(userIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserRegistryApi#userRegistryUpdatePassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserRegistryApi#userRegistryUpdatePassword")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3UpdateUserPasswordRequest**](V3UpdateUserPasswordRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

