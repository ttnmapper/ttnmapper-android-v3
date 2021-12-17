# OrganizationAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**organizationAccessCreateAPIKey**](OrganizationAccessApi.md#organizationAccessCreateAPIKey) | **POST** /organizations/{organization_ids.organization_id}/api-keys | Create an API key scoped to this organization. Organization API keys can give access to the organization itself, as well as any application, gateway and OAuth client this organization is a collaborator of.
[**organizationAccessGetAPIKey**](OrganizationAccessApi.md#organizationAccessGetAPIKey) | **GET** /organizations/{organization_ids.organization_id}/api-keys/{key_id} | Get a single API key of this organization.
[**organizationAccessGetCollaborator**](OrganizationAccessApi.md#organizationAccessGetCollaborator) | **GET** /organizations/{organization_ids.organization_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the organization. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**organizationAccessListAPIKeys**](OrganizationAccessApi.md#organizationAccessListAPIKeys) | **GET** /organizations/{organization_ids.organization_id}/api-keys | List the API keys for this organization.
[**organizationAccessListCollaborators**](OrganizationAccessApi.md#organizationAccessListCollaborators) | **GET** /organizations/{organization_ids.organization_id}/collaborators | List the collaborators on this organization.
[**organizationAccessListRights**](OrganizationAccessApi.md#organizationAccessListRights) | **GET** /organizations/{organization_id}/rights | List the rights the caller has on this organization.
[**organizationAccessSetCollaborator**](OrganizationAccessApi.md#organizationAccessSetCollaborator) | **PUT** /organizations/{organization_ids.organization_id}/collaborators | Set the rights of a collaborator (member) on the organization. Organization collaborators can get access to the organization itself, as well as any application, gateway and OAuth client this organization is a collaborator of. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
[**organizationAccessUpdateAPIKey**](OrganizationAccessApi.md#organizationAccessUpdateAPIKey) | **PUT** /organizations/{organization_ids.organization_id}/api-keys/{api_key.id} | Update the rights of an API key of the organization. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.


<a name="organizationAccessCreateAPIKey"></a>
# **organizationAccessCreateAPIKey**
> V3APIKey organizationAccessCreateAPIKey(organizationIdsOrganizationId, body)

Create an API key scoped to this organization. Organization API keys can give access to the organization itself, as well as any application, gateway and OAuth client this organization is a collaborator of.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val body : V3CreateOrganizationAPIKeyRequest =  // V3CreateOrganizationAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.organizationAccessCreateAPIKey(organizationIdsOrganizationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessCreateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessCreateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **body** | [**V3CreateOrganizationAPIKeyRequest**](V3CreateOrganizationAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="organizationAccessGetAPIKey"></a>
# **organizationAccessGetAPIKey**
> V3APIKey organizationAccessGetAPIKey(organizationIdsOrganizationId, keyId)

Get a single API key of this organization.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val keyId : kotlin.String = keyId_example // kotlin.String | Unique public identifier for the API key.
try {
    val result : V3APIKey = apiInstance.organizationAccessGetAPIKey(organizationIdsOrganizationId, keyId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessGetAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessGetAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **keyId** | **kotlin.String**| Unique public identifier for the API key. |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationAccessGetCollaborator"></a>
# **organizationAccessGetCollaborator**
> V3GetCollaboratorResponse organizationAccessGetCollaborator(organizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the organization. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.organizationAccessGetCollaborator(organizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessGetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessGetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3GetCollaboratorResponse**](V3GetCollaboratorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationAccessListAPIKeys"></a>
# **organizationAccessListAPIKeys**
> V3APIKeys organizationAccessListAPIKeys(organizationIdsOrganizationId, limit, page)

List the API keys for this organization.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3APIKeys = apiInstance.organizationAccessListAPIKeys(organizationIdsOrganizationId, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessListAPIKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessListAPIKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3APIKeys**](V3APIKeys.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationAccessListCollaborators"></a>
# **organizationAccessListCollaborators**
> V3Collaborators organizationAccessListCollaborators(organizationIdsOrganizationId, limit, page)

List the collaborators on this organization.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3Collaborators = apiInstance.organizationAccessListCollaborators(organizationIdsOrganizationId, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessListCollaborators")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessListCollaborators")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3Collaborators**](V3Collaborators.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationAccessListRights"></a>
# **organizationAccessListRights**
> V3Rights organizationAccessListRights(organizationId)

List the rights the caller has on this organization.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationId : kotlin.String = organizationId_example // kotlin.String | This ID shares namespace with user IDs.
try {
    val result : V3Rights = apiInstance.organizationAccessListRights(organizationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessListRights")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessListRights")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **kotlin.String**| This ID shares namespace with user IDs. |

### Return type

[**V3Rights**](V3Rights.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationAccessSetCollaborator"></a>
# **organizationAccessSetCollaborator**
> kotlin.Any organizationAccessSetCollaborator(organizationIdsOrganizationId, body)

Set the rights of a collaborator (member) on the organization. Organization collaborators can get access to the organization itself, as well as any application, gateway and OAuth client this organization is a collaborator of. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val body : V3SetOrganizationCollaboratorRequest =  // V3SetOrganizationCollaboratorRequest | 
try {
    val result : kotlin.Any = apiInstance.organizationAccessSetCollaborator(organizationIdsOrganizationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessSetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessSetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **body** | [**V3SetOrganizationCollaboratorRequest**](V3SetOrganizationCollaboratorRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="organizationAccessUpdateAPIKey"></a>
# **organizationAccessUpdateAPIKey**
> V3APIKey organizationAccessUpdateAPIKey(organizationIdsOrganizationId, apiKeyId, body)

Update the rights of an API key of the organization. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationAccessApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val apiKeyId : kotlin.String = apiKeyId_example // kotlin.String | Immutable and unique public identifier for the API key. Generated by the Access Server.
val body : V3UpdateOrganizationAPIKeyRequest =  // V3UpdateOrganizationAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.organizationAccessUpdateAPIKey(organizationIdsOrganizationId, apiKeyId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationAccessApi#organizationAccessUpdateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationAccessApi#organizationAccessUpdateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **apiKeyId** | **kotlin.String**| Immutable and unique public identifier for the API key. Generated by the Access Server. |
 **body** | [**V3UpdateOrganizationAPIKeyRequest**](V3UpdateOrganizationAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

