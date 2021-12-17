# GatewayAccessApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gatewayAccessCreateAPIKey**](GatewayAccessApi.md#gatewayAccessCreateAPIKey) | **POST** /gateways/{gateway_ids.gateway_id}/api-keys | Create an API key scoped to this gateway.
[**gatewayAccessGetAPIKey**](GatewayAccessApi.md#gatewayAccessGetAPIKey) | **GET** /gateways/{gateway_ids.gateway_id}/api-keys/{key_id} | Get a single API key of this gateway.
[**gatewayAccessGetCollaborator**](GatewayAccessApi.md#gatewayAccessGetCollaborator) | **GET** /gateways/{gateway_ids.gateway_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the gateway. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**gatewayAccessGetCollaborator2**](GatewayAccessApi.md#gatewayAccessGetCollaborator2) | **GET** /gateways/{gateway_ids.gateway_id}/collaborator/organization/{collaborator.organization_ids.organization_id} | Get the rights of a collaborator (member) of the gateway. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.
[**gatewayAccessListAPIKeys**](GatewayAccessApi.md#gatewayAccessListAPIKeys) | **GET** /gateways/{gateway_ids.gateway_id}/api-keys | List the API keys for this gateway.
[**gatewayAccessListCollaborators**](GatewayAccessApi.md#gatewayAccessListCollaborators) | **GET** /gateways/{gateway_ids.gateway_id}/collaborators | List the collaborators on this gateway.
[**gatewayAccessListRights**](GatewayAccessApi.md#gatewayAccessListRights) | **GET** /gateways/{gateway_id}/rights | List the rights the caller has on this gateway.
[**gatewayAccessSetCollaborator**](GatewayAccessApi.md#gatewayAccessSetCollaborator) | **PUT** /gateways/{gateway_ids.gateway_id}/collaborators | Set the rights of a collaborator (member) on the gateway. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
[**gatewayAccessUpdateAPIKey**](GatewayAccessApi.md#gatewayAccessUpdateAPIKey) | **PUT** /gateways/{gateway_ids.gateway_id}/api-keys/{api_key.id} | Update the rights of an API key of the gateway. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.


<a name="gatewayAccessCreateAPIKey"></a>
# **gatewayAccessCreateAPIKey**
> V3APIKey gatewayAccessCreateAPIKey(gatewayIdsGatewayId, body)

Create an API key scoped to this gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val body : V3CreateGatewayAPIKeyRequest =  // V3CreateGatewayAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.gatewayAccessCreateAPIKey(gatewayIdsGatewayId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessCreateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessCreateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **body** | [**V3CreateGatewayAPIKeyRequest**](V3CreateGatewayAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gatewayAccessGetAPIKey"></a>
# **gatewayAccessGetAPIKey**
> V3APIKey gatewayAccessGetAPIKey(gatewayIdsGatewayId, keyId, gatewayIdsEui)

Get a single API key of this gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val keyId : kotlin.String = keyId_example // kotlin.String | Unique public identifier for the API key.
val gatewayIdsEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3APIKey = apiInstance.gatewayAccessGetAPIKey(gatewayIdsGatewayId, keyId, gatewayIdsEui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessGetAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessGetAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **keyId** | **kotlin.String**| Unique public identifier for the API key. |
 **gatewayIdsEui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayAccessGetCollaborator"></a>
# **gatewayAccessGetCollaborator**
> V3GetCollaboratorResponse gatewayAccessGetCollaborator(gatewayIdsGatewayId, collaboratorUserIdsUserId, gatewayIdsEui, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the gateway. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val gatewayIdsEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.gatewayAccessGetCollaborator(gatewayIdsGatewayId, collaboratorUserIdsUserId, gatewayIdsEui, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessGetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessGetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **gatewayIdsEui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3GetCollaboratorResponse**](V3GetCollaboratorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayAccessGetCollaborator2"></a>
# **gatewayAccessGetCollaborator2**
> V3GetCollaboratorResponse gatewayAccessGetCollaborator2(gatewayIdsGatewayId, collaboratorOrganizationIdsOrganizationId, gatewayIdsEui, collaboratorUserIdsUserId, collaboratorUserIdsEmail)

Get the rights of a collaborator (member) of the gateway. Pseudo-rights in the response (such as the \&quot;_ALL\&quot; right) are not expanded.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val gatewayIdsEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3GetCollaboratorResponse = apiInstance.gatewayAccessGetCollaborator2(gatewayIdsGatewayId, collaboratorOrganizationIdsOrganizationId, gatewayIdsEui, collaboratorUserIdsUserId, collaboratorUserIdsEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessGetCollaborator2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessGetCollaborator2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **gatewayIdsEui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3GetCollaboratorResponse**](V3GetCollaboratorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayAccessListAPIKeys"></a>
# **gatewayAccessListAPIKeys**
> V3APIKeys gatewayAccessListAPIKeys(gatewayIdsGatewayId, gatewayIdsEui, limit, page)

List the API keys for this gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val gatewayIdsEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3APIKeys = apiInstance.gatewayAccessListAPIKeys(gatewayIdsGatewayId, gatewayIdsEui, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessListAPIKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessListAPIKeys")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **gatewayIdsEui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3APIKeys**](V3APIKeys.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayAccessListCollaborators"></a>
# **gatewayAccessListCollaborators**
> V3Collaborators gatewayAccessListCollaborators(gatewayIdsGatewayId, gatewayIdsEui, limit, page)

List the collaborators on this gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val gatewayIdsEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3Collaborators = apiInstance.gatewayAccessListCollaborators(gatewayIdsGatewayId, gatewayIdsEui, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessListCollaborators")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessListCollaborators")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **gatewayIdsEui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3Collaborators**](V3Collaborators.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayAccessListRights"></a>
# **gatewayAccessListRights**
> V3Rights gatewayAccessListRights(gatewayId, eui)

List the rights the caller has on this gateway.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : V3Rights = apiInstance.gatewayAccessListRights(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessListRights")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessListRights")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**V3Rights**](V3Rights.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayAccessSetCollaborator"></a>
# **gatewayAccessSetCollaborator**
> kotlin.Any gatewayAccessSetCollaborator(gatewayIdsGatewayId, body)

Set the rights of a collaborator (member) on the gateway. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val body : V3SetGatewayCollaboratorRequest =  // V3SetGatewayCollaboratorRequest | 
try {
    val result : kotlin.Any = apiInstance.gatewayAccessSetCollaborator(gatewayIdsGatewayId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessSetCollaborator")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessSetCollaborator")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **body** | [**V3SetGatewayCollaboratorRequest**](V3SetGatewayCollaboratorRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gatewayAccessUpdateAPIKey"></a>
# **gatewayAccessUpdateAPIKey**
> V3APIKey gatewayAccessUpdateAPIKey(gatewayIdsGatewayId, apiKeyId, body)

Update the rights of an API key of the gateway. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayAccessApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val apiKeyId : kotlin.String = apiKeyId_example // kotlin.String | Immutable and unique public identifier for the API key. Generated by the Access Server.
val body : V3UpdateGatewayAPIKeyRequest =  // V3UpdateGatewayAPIKeyRequest | 
try {
    val result : V3APIKey = apiInstance.gatewayAccessUpdateAPIKey(gatewayIdsGatewayId, apiKeyId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayAccessApi#gatewayAccessUpdateAPIKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayAccessApi#gatewayAccessUpdateAPIKey")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **apiKeyId** | **kotlin.String**| Immutable and unique public identifier for the API key. Generated by the Access Server. |
 **body** | [**V3UpdateGatewayAPIKeyRequest**](V3UpdateGatewayAPIKeyRequest.md)|  |

### Return type

[**V3APIKey**](V3APIKey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

