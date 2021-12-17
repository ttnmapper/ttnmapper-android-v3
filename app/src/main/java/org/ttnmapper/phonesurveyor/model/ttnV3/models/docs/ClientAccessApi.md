# ClientAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clientAccessGetCollaborator**](ClientAccessApi.md#clientAccessGetCollaborator) | **GET** /clients/{client_ids.client_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the client. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**clientAccessGetCollaborator2**](ClientAccessApi.md#clientAccessGetCollaborator2) | **GET** /clients/{client_ids.client_id}/collaborator/organization/{collaborator.organization_ids.organization_id} | Get the rights of a collaborator (member) of the client. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**clientAccessListCollaborators**](ClientAccessApi.md#clientAccessListCollaborators) | **GET** /clients/{client_ids.client_id}/collaborators | List the collaborators on this OAuth client.
[**clientAccessListRights**](ClientAccessApi.md#clientAccessListRights) | **GET** /clients/{client_id}/rights | List the rights the caller has on this application.
[**clientAccessSetCollaborator**](ClientAccessApi.md#clientAccessSetCollaborator) | **PUT** /clients/{client_ids.client_id}/collaborators | Set the rights of a collaborator (member) on the OAuth client. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.


<a name="clientAccessGetCollaborator"></a>
# **clientAccessGetCollaborator**
> V3GetCollaboratorResponse clientAccessGetCollaborator(clientIdsClientId, collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the client. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientAccessApi()
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.clientAccessGetCollaborator(clientIdsClientId, collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientAccessApi#clientAccessGetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientAccessApi#clientAccessGetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientIdsClientId** | **kotlin.String**|  |
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

<a name="clientAccessGetCollaborator2"></a>
# **clientAccessGetCollaborator2**
> V3GetCollaboratorResponse clientAccessGetCollaborator2(clientIdsClientId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the client. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientAccessApi()
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.clientAccessGetCollaborator2(clientIdsClientId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientAccessApi#clientAccessGetCollaborator2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientAccessApi#clientAccessGetCollaborator2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientIdsClientId** | **kotlin.String**|  |
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

<a name="clientAccessListCollaborators"></a>
# **clientAccessListCollaborators**
> V3Collaborators clientAccessListCollaborators(clientIdsClientId, limit, page)

List the collaborators on this OAuth client.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientAccessApi()
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3Collaborators = apiInstance.clientAccessListCollaborators(clientIdsClientId, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientAccessApi#clientAccessListCollaborators")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientAccessApi#clientAccessListCollaborators")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientIdsClientId** | **kotlin.String**|  |
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3Collaborators**](V3Collaborators.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientAccessListRights"></a>
# **clientAccessListRights**
> V3Rights clientAccessListRights(clientId)

List the rights the caller has on this application.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientAccessApi()
val clientId : kotlin.String = clientId_example // kotlin.String | 
try {
    val result : V3Rights = apiInstance.clientAccessListRights(clientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientAccessApi#clientAccessListRights")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientAccessApi#clientAccessListRights")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **kotlin.String**|  |

### Return type

[**V3Rights**](V3Rights.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientAccessSetCollaborator"></a>
# **clientAccessSetCollaborator**
> kotlin.Any clientAccessSetCollaborator(clientIdsClientId, body)

Set the rights of a collaborator (member) on the OAuth client. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientAccessApi()
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val body : V3SetClientCollaboratorRequest =  // V3SetClientCollaboratorRequest | 
try {
    val result : kotlin.Any = apiInstance.clientAccessSetCollaborator(clientIdsClientId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientAccessApi#clientAccessSetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientAccessApi#clientAccessSetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientIdsClientId** | **kotlin.String**|  |
 **body** | [**V3SetClientCollaboratorRequest**](V3SetClientCollaboratorRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

