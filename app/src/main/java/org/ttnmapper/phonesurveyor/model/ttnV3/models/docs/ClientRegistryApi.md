# ClientRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clientRegistryCreate**](ClientRegistryApi.md#clientRegistryCreate) | **POST** /users/{collaborator.user_ids.user_id}/clients | Create a new OAuth client. This also sets the given organization or user as first collaborator with all possible rights.
[**clientRegistryCreate2**](ClientRegistryApi.md#clientRegistryCreate2) | **POST** /organizations/{collaborator.organization_ids.organization_id}/clients | Create a new OAuth client. This also sets the given organization or user as first collaborator with all possible rights.
[**clientRegistryDelete**](ClientRegistryApi.md#clientRegistryDelete) | **DELETE** /clients/{client_id} | Delete the OAuth client. This may not release the client ID for reuse.
[**clientRegistryGet**](ClientRegistryApi.md#clientRegistryGet) | **GET** /clients/{client_ids.client_id} | Get the OAuth client with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**clientRegistryList**](ClientRegistryApi.md#clientRegistryList) | **GET** /clients | List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**clientRegistryList2**](ClientRegistryApi.md#clientRegistryList2) | **GET** /users/{collaborator.user_ids.user_id}/clients | List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**clientRegistryList3**](ClientRegistryApi.md#clientRegistryList3) | **GET** /organizations/{collaborator.organization_ids.organization_id}/clients | List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**clientRegistryPurge**](ClientRegistryApi.md#clientRegistryPurge) | **DELETE** /clients/{client_id}/purge | Purge the client. This will release the client ID for reuse.
[**clientRegistryRestore**](ClientRegistryApi.md#clientRegistryRestore) | **POST** /clients/{client_id}/restore | Restore a recently deleted client.
[**clientRegistryUpdate**](ClientRegistryApi.md#clientRegistryUpdate) | **PUT** /clients/{client.ids.client_id} | Update the OAuth client, changing the fields specified by the field mask to the provided values.


<a name="clientRegistryCreate"></a>
# **clientRegistryCreate**
> V3Client clientRegistryCreate(collaboratorUserIdsUserId, body)

Create a new OAuth client. This also sets the given organization or user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3CreateClientRequest =  // V3CreateClientRequest | 
try {
    val result : V3Client = apiInstance.clientRegistryCreate(collaboratorUserIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3CreateClientRequest**](V3CreateClientRequest.md)|  |

### Return type

[**V3Client**](V3Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clientRegistryCreate2"></a>
# **clientRegistryCreate2**
> V3Client clientRegistryCreate2(collaboratorOrganizationIdsOrganizationId, body)

Create a new OAuth client. This also sets the given organization or user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val body : V3CreateClientRequest =  // V3CreateClientRequest | 
try {
    val result : V3Client = apiInstance.clientRegistryCreate2(collaboratorOrganizationIdsOrganizationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryCreate2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryCreate2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **body** | [**V3CreateClientRequest**](V3CreateClientRequest.md)|  |

### Return type

[**V3Client**](V3Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clientRegistryDelete"></a>
# **clientRegistryDelete**
> kotlin.Any clientRegistryDelete(clientId)

Delete the OAuth client. This may not release the client ID for reuse.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val clientId : kotlin.String = clientId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.clientRegistryDelete(clientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryGet"></a>
# **clientRegistryGet**
> V3Client clientRegistryGet(clientIdsClientId, fieldMaskPaths)

Get the OAuth client with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3Client = apiInstance.clientRegistryGet(clientIdsClientId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientIdsClientId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3Client**](V3Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryList"></a>
# **clientRegistryList**
> V3Clients clientRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted clients.
try {
    val result : V3Clients = apiInstance.clientRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. | [optional]
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted clients. | [optional]

### Return type

[**V3Clients**](V3Clients.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryList2"></a>
# **clientRegistryList2**
> V3Clients clientRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted clients.
try {
    val result : V3Clients = apiInstance.clientRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryList2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryList2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted clients. | [optional]

### Return type

[**V3Clients**](V3Clients.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryList3"></a>
# **clientRegistryList3**
> V3Clients clientRegistryList3(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted clients.
try {
    val result : V3Clients = apiInstance.clientRegistryList3(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryList3")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryList3")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. | [optional]
 **collaboratorUserIdsEmail** | **kotlin.String**| Secondary identifier, which can only be used in specific requests. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]
 **order** | **kotlin.String**| Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **deleted** | **kotlin.Boolean**| Only return recently deleted clients. | [optional]

### Return type

[**V3Clients**](V3Clients.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryPurge"></a>
# **clientRegistryPurge**
> kotlin.Any clientRegistryPurge(clientId)

Purge the client. This will release the client ID for reuse.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val clientId : kotlin.String = clientId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.clientRegistryPurge(clientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryPurge")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryPurge")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryRestore"></a>
# **clientRegistryRestore**
> kotlin.Any clientRegistryRestore(clientId)

Restore a recently deleted client.

Deployment configuration may specify if, and for how long after deletion, entities can be restored.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val clientId : kotlin.String = clientId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.clientRegistryRestore(clientId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryRestore")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryRestore")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientRegistryUpdate"></a>
# **clientRegistryUpdate**
> V3Client clientRegistryUpdate(clientIdsClientId, body)

Update the OAuth client, changing the fields specified by the field mask to the provided values.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ClientRegistryApi()
val clientIdsClientId : kotlin.String = clientIdsClientId_example // kotlin.String | 
val body : V3UpdateClientRequest =  // V3UpdateClientRequest | 
try {
    val result : V3Client = apiInstance.clientRegistryUpdate(clientIdsClientId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ClientRegistryApi#clientRegistryUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ClientRegistryApi#clientRegistryUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientIdsClientId** | **kotlin.String**|  |
 **body** | [**V3UpdateClientRequest**](V3UpdateClientRequest.md)|  |

### Return type

[**V3Client**](V3Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

