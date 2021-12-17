# OrganizationRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**organizationRegistryCreate**](OrganizationRegistryApi.md#organizationRegistryCreate) | **POST** /users/{collaborator.user_ids.user_id}/organizations | Create a new organization. This also sets the given user as first collaborator with all possible rights.
[**organizationRegistryDelete**](OrganizationRegistryApi.md#organizationRegistryDelete) | **DELETE** /organizations/{organization_id} | Delete the organization. This may not release the organization ID for reuse.
[**organizationRegistryGet**](OrganizationRegistryApi.md#organizationRegistryGet) | **GET** /organizations/{organization_ids.organization_id} | Get the organization with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**organizationRegistryList**](OrganizationRegistryApi.md#organizationRegistryList) | **GET** /organizations | List organizations where the given user or organization is a direct collaborator. If no user or organization is given, this returns the organizations the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**organizationRegistryList2**](OrganizationRegistryApi.md#organizationRegistryList2) | **GET** /users/{collaborator.user_ids.user_id}/organizations | List organizations where the given user or organization is a direct collaborator. If no user or organization is given, this returns the organizations the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**organizationRegistryPurge**](OrganizationRegistryApi.md#organizationRegistryPurge) | **DELETE** /organizations/{organization_id}/purge | Purge the organization. This will release the organization ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.
[**organizationRegistryRestore**](OrganizationRegistryApi.md#organizationRegistryRestore) | **POST** /organizations/{organization_id}/restore | Restore a recently deleted organization.
[**organizationRegistryUpdate**](OrganizationRegistryApi.md#organizationRegistryUpdate) | **PUT** /organizations/{organization.ids.organization_id} | Update the organization, changing the fields specified by the field mask to the provided values.


<a name="organizationRegistryCreate"></a>
# **organizationRegistryCreate**
> V3Organization organizationRegistryCreate(collaboratorUserIdsUserId, body)

Create a new organization. This also sets the given user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3CreateOrganizationRequest =  // V3CreateOrganizationRequest | 
try {
    val result : V3Organization = apiInstance.organizationRegistryCreate(collaboratorUserIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3CreateOrganizationRequest**](V3CreateOrganizationRequest.md)|  |

### Return type

[**V3Organization**](V3Organization.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="organizationRegistryDelete"></a>
# **organizationRegistryDelete**
> kotlin.Any organizationRegistryDelete(organizationId)

Delete the organization. This may not release the organization ID for reuse.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val organizationId : kotlin.String = organizationId_example // kotlin.String | This ID shares namespace with user IDs.
try {
    val result : kotlin.Any = apiInstance.organizationRegistryDelete(organizationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **kotlin.String**| This ID shares namespace with user IDs. |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationRegistryGet"></a>
# **organizationRegistryGet**
> V3Organization organizationRegistryGet(organizationIdsOrganizationId, fieldMaskPaths)

Get the organization with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3Organization = apiInstance.organizationRegistryGet(organizationIdsOrganizationId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3Organization**](V3Organization.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationRegistryList"></a>
# **organizationRegistryList**
> V3Organizations organizationRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List organizations where the given user or organization is a direct collaborator. If no user or organization is given, this returns the organizations the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted organizations.
try {
    val result : V3Organizations = apiInstance.organizationRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryList")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted organizations. | [optional]

### Return type

[**V3Organizations**](V3Organizations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationRegistryList2"></a>
# **organizationRegistryList2**
> V3Organizations organizationRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List organizations where the given user or organization is a direct collaborator. If no user or organization is given, this returns the organizations the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted organizations.
try {
    val result : V3Organizations = apiInstance.organizationRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryList2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryList2")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted organizations. | [optional]

### Return type

[**V3Organizations**](V3Organizations.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationRegistryPurge"></a>
# **organizationRegistryPurge**
> kotlin.Any organizationRegistryPurge(organizationId)

Purge the organization. This will release the organization ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val organizationId : kotlin.String = organizationId_example // kotlin.String | This ID shares namespace with user IDs.
try {
    val result : kotlin.Any = apiInstance.organizationRegistryPurge(organizationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryPurge")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryPurge")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **kotlin.String**| This ID shares namespace with user IDs. |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationRegistryRestore"></a>
# **organizationRegistryRestore**
> kotlin.Any organizationRegistryRestore(organizationId)

Restore a recently deleted organization.

Deployment configuration may specify if, and for how long after deletion, entities can be restored.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val organizationId : kotlin.String = organizationId_example // kotlin.String | This ID shares namespace with user IDs.
try {
    val result : kotlin.Any = apiInstance.organizationRegistryRestore(organizationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryRestore")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryRestore")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **kotlin.String**| This ID shares namespace with user IDs. |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="organizationRegistryUpdate"></a>
# **organizationRegistryUpdate**
> V3Organization organizationRegistryUpdate(organizationIdsOrganizationId, body)

Update the organization, changing the fields specified by the field mask to the provided values.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = OrganizationRegistryApi()
val organizationIdsOrganizationId : kotlin.String = organizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val body : V3UpdateOrganizationRequest =  // V3UpdateOrganizationRequest | 
try {
    val result : V3Organization = apiInstance.organizationRegistryUpdate(organizationIdsOrganizationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrganizationRegistryApi#organizationRegistryUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrganizationRegistryApi#organizationRegistryUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **body** | [**V3UpdateOrganizationRequest**](V3UpdateOrganizationRequest.md)|  |

### Return type

[**V3Organization**](V3Organization.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

