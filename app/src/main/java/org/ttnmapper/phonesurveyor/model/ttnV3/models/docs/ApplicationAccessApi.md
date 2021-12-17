# ApplicationAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationAccessCreateAPIKey**](ApplicationAccessApi.md#applicationAccessCreateAPIKey) | **POST** /applications/{application_ids.application_id}/api-keys | Create an API key scoped to this application.
[**applicationAccessGetAPIKey**](ApplicationAccessApi.md#applicationAccessGetAPIKey) | **GET** /applications/{application_ids.application_id}/api-keys/{key_id} | Get a single API key of this application.
[**applicationAccessGetCollaborator**](ApplicationAccessApi.md#applicationAccessGetCollaborator) | **GET** /applications/{application_ids.application_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the application. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**applicationAccessGetCollaborator2**](ApplicationAccessApi.md#applicationAccessGetCollaborator2) | **GET** /applications/{application_ids.application_id}/collaborator/organization/{collaborator.organization_ids.organization_id} | Get the rights of a collaborator (member) of the application. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**applicationAccessListAPIKeys**](ApplicationAccessApi.md#applicationAccessListAPIKeys) | **GET** /applications/{application_ids.application_id}/api-keys | List the API keys for this application.
[**applicationAccessListCollaborators**](ApplicationAccessApi.md#applicationAccessListCollaborators) | **GET** /applications/{application_ids.application_id}/collaborators | List the collaborators on this application.
[**applicationAccessListRights**](ApplicationAccessApi.md#applicationAccessListRights) | **GET** /applications/{application_id}/rights | List the rights the caller has on this application.
[**applicationAccessSetCollaborator**](ApplicationAccessApi.md#applicationAccessSetCollaborator) | **PUT** /applications/{application_ids.application_id}/collaborators | Set the rights of a collaborator (member) on the application. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
[**applicationAccessUpdateAPIKey**](ApplicationAccessApi.md#applicationAccessUpdateAPIKey) | **PUT** /applications/{application_ids.application_id}/api-keys/{api_key.id} | Update the rights of an API key of the application. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.


<a name="applicationAccessCreateAPIKey"></a>
# **applicationAccessCreateAPIKey**
> V3APIKey applicationAccessCreateAPIKey(applicationIdsApplicationId, body)

Create an API key scoped to this application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3CreateApplicationAPIKeyRequest =  // V3CreateApplicationAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.applicationAccessCreateAPIKey(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessCreateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessCreateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3CreateApplicationAPIKeyRequest**](V3CreateApplicationAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationAccessGetAPIKey"></a>
# **applicationAccessGetAPIKey**
> V3APIKey applicationAccessGetAPIKey(applicationIdsApplicationId, keyId)

Get a single API key of this application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val keyId : kotlin.String = keyId_example // kotlin.String | Unique public identifier for the API key.
try {
    val result : V3APIKey = apiInstance.applicationAccessGetAPIKey(applicationIdsApplicationId, keyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessGetAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessGetAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **keyId** | **kotlin.String**| Unique public identifier for the API key. |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationAccessGetCollaborator"></a>
# **applicationAccessGetCollaborator**
> V3GetCollaboratorResponse applicationAccessGetCollaborator(applicationIdsApplicationId, collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the application. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.applicationAccessGetCollaborator(applicationIdsApplicationId, collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessGetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessGetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3GetCollaboratorResponse**](V3GetCollaboratorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationAccessGetCollaborator2"></a>
# **applicationAccessGetCollaborator2**
> V3GetCollaboratorResponse applicationAccessGetCollaborator2(applicationIdsApplicationId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the application. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.applicationAccessGetCollaborator2(applicationIdsApplicationId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessGetCollaborator2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessGetCollaborator2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3GetCollaboratorResponse**](V3GetCollaboratorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationAccessListAPIKeys"></a>
# **applicationAccessListAPIKeys**
> V3APIKeys applicationAccessListAPIKeys(applicationIdsApplicationId, limit, page)

List the API keys for this application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3APIKeys = apiInstance.applicationAccessListAPIKeys(applicationIdsApplicationId, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessListAPIKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessListAPIKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3APIKeys**](V3APIKeys.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationAccessListCollaborators"></a>
# **applicationAccessListCollaborators**
> V3Collaborators applicationAccessListCollaborators(applicationIdsApplicationId, limit, page)

List the collaborators on this application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3Collaborators = apiInstance.applicationAccessListCollaborators(applicationIdsApplicationId, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessListCollaborators")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessListCollaborators")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3Collaborators**](V3Collaborators.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationAccessListRights"></a>
# **applicationAccessListRights**
> V3Rights applicationAccessListRights(applicationId)

List the rights the caller has on this application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : V3Rights = apiInstance.applicationAccessListRights(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessListRights")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessListRights")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**V3Rights**](V3Rights.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationAccessSetCollaborator"></a>
# **applicationAccessSetCollaborator**
> kotlin.Any applicationAccessSetCollaborator(applicationIdsApplicationId, body)

Set the rights of a collaborator (member) on the application. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3SetApplicationCollaboratorRequest =  // V3SetApplicationCollaboratorRequest | 
try {
    val result : kotlin.Any = apiInstance.applicationAccessSetCollaborator(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessSetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessSetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3SetApplicationCollaboratorRequest**](V3SetApplicationCollaboratorRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationAccessUpdateAPIKey"></a>
# **applicationAccessUpdateAPIKey**
> V3APIKey applicationAccessUpdateAPIKey(applicationIdsApplicationId, apiKeyId, body)

Update the rights of an API key of the application. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationAccessApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val apiKeyId : kotlin.String = apiKeyId_example // kotlin.String | Immutable and unique public identifier for the API key. Generated by the Access Server.
val body : V3UpdateApplicationAPIKeyRequest =  // V3UpdateApplicationAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.applicationAccessUpdateAPIKey(applicationIdsApplicationId, apiKeyId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationAccessApi#applicationAccessUpdateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationAccessApi#applicationAccessUpdateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **apiKeyId** | **kotlin.String**| Immutable and unique public identifier for the API key. Generated by the Access Server. |
 **body** | [**V3UpdateApplicationAPIKeyRequest**](V3UpdateApplicationAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

