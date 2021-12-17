# ApplicationRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**applicationRegistryCreate**](ApplicationRegistryApi.md#applicationRegistryCreate) | **POST** /users/{collaborator.user_ids.user_id}/applications | Create a new application. This also sets the given organization or user as first collaborator with all possible rights.
[**applicationRegistryCreate2**](ApplicationRegistryApi.md#applicationRegistryCreate2) | **POST** /organizations/{collaborator.organization_ids.organization_id}/applications | Create a new application. This also sets the given organization or user as first collaborator with all possible rights.
[**applicationRegistryDelete**](ApplicationRegistryApi.md#applicationRegistryDelete) | **DELETE** /applications/{application_id} | Delete the application. This may not release the application ID for reuse. All end devices must be deleted from the application before it can be deleted.
[**applicationRegistryGet**](ApplicationRegistryApi.md#applicationRegistryGet) | **GET** /applications/{application_ids.application_id} | Get the application with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**applicationRegistryIssueDevEUI**](ApplicationRegistryApi.md#applicationRegistryIssueDevEUI) | **POST** /applications/{application_id}/dev-eui | Request DevEUI from the configured address block for a device inside the application. The maximum number of DevEUI&#39;s issued per application can be configured.
[**applicationRegistryList**](ApplicationRegistryApi.md#applicationRegistryList) | **GET** /applications | List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**applicationRegistryList2**](ApplicationRegistryApi.md#applicationRegistryList2) | **GET** /users/{collaborator.user_ids.user_id}/applications | List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**applicationRegistryList3**](ApplicationRegistryApi.md#applicationRegistryList3) | **GET** /organizations/{collaborator.organization_ids.organization_id}/applications | List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**applicationRegistryPurge**](ApplicationRegistryApi.md#applicationRegistryPurge) | **DELETE** /applications/{application_id}/purge | Purge the application. This will release the application ID for reuse. All end devices must be deleted from the application before it can be deleted. The application owner is responsible for clearing data from any (external) integrations that may store and expose data by application ID
[**applicationRegistryRestore**](ApplicationRegistryApi.md#applicationRegistryRestore) | **POST** /applications/{application_id}/restore | Restore a recently deleted application.
[**applicationRegistryUpdate**](ApplicationRegistryApi.md#applicationRegistryUpdate) | **PUT** /applications/{application.ids.application_id} | Update the application, changing the fields specified by the field mask to the provided values.


<a name="applicationRegistryCreate"></a>
# **applicationRegistryCreate**
> V3Application applicationRegistryCreate(collaboratorUserIdsUserId, body)

Create a new application. This also sets the given organization or user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3CreateApplicationRequest =  // V3CreateApplicationRequest | 
try {
    val result : V3Application = apiInstance.applicationRegistryCreate(collaboratorUserIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3CreateApplicationRequest**](V3CreateApplicationRequest.md)|  |

### Return type

[**V3Application**](V3Application.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationRegistryCreate2"></a>
# **applicationRegistryCreate2**
> V3Application applicationRegistryCreate2(collaboratorOrganizationIdsOrganizationId, body)

Create a new application. This also sets the given organization or user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val body : V3CreateApplicationRequest =  // V3CreateApplicationRequest | 
try {
    val result : V3Application = apiInstance.applicationRegistryCreate2(collaboratorOrganizationIdsOrganizationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryCreate2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryCreate2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **body** | [**V3CreateApplicationRequest**](V3CreateApplicationRequest.md)|  |

### Return type

[**V3Application**](V3Application.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="applicationRegistryDelete"></a>
# **applicationRegistryDelete**
> kotlin.Any applicationRegistryDelete(applicationId)

Delete the application. This may not release the application ID for reuse. All end devices must be deleted from the application before it can be deleted.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.applicationRegistryDelete(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryGet"></a>
# **applicationRegistryGet**
> V3Application applicationRegistryGet(applicationIdsApplicationId, fieldMaskPaths)

Get the application with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3Application = apiInstance.applicationRegistryGet(applicationIdsApplicationId, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3Application**](V3Application.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryIssueDevEUI"></a>
# **applicationRegistryIssueDevEUI**
> V3IssueDevEUIResponse applicationRegistryIssueDevEUI(applicationId)

Request DevEUI from the configured address block for a device inside the application. The maximum number of DevEUI&#39;s issued per application can be configured.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : V3IssueDevEUIResponse = apiInstance.applicationRegistryIssueDevEUI(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryIssueDevEUI")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryIssueDevEUI")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**V3IssueDevEUIResponse**](V3IssueDevEUIResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryList"></a>
# **applicationRegistryList**
> V3Applications applicationRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted applications.
try {
    val result : V3Applications = apiInstance.applicationRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryList")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted applications. | [optional]

### Return type

[**V3Applications**](V3Applications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryList2"></a>
# **applicationRegistryList2**
> V3Applications applicationRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted applications.
try {
    val result : V3Applications = apiInstance.applicationRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryList2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryList2")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted applications. | [optional]

### Return type

[**V3Applications**](V3Applications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryList3"></a>
# **applicationRegistryList3**
> V3Applications applicationRegistryList3(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted applications.
try {
    val result : V3Applications = apiInstance.applicationRegistryList3(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryList3")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryList3")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted applications. | [optional]

### Return type

[**V3Applications**](V3Applications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryPurge"></a>
# **applicationRegistryPurge**
> kotlin.Any applicationRegistryPurge(applicationId)

Purge the application. This will release the application ID for reuse. All end devices must be deleted from the application before it can be deleted. The application owner is responsible for clearing data from any (external) integrations that may store and expose data by application ID

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.applicationRegistryPurge(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryPurge")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryPurge")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryRestore"></a>
# **applicationRegistryRestore**
> kotlin.Any applicationRegistryRestore(applicationId)

Restore a recently deleted application.

Deployment configuration may specify if, and for how long after deletion, entities can be restored.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val applicationId : kotlin.String = applicationId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.applicationRegistryRestore(applicationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryRestore")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryRestore")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="applicationRegistryUpdate"></a>
# **applicationRegistryUpdate**
> V3Application applicationRegistryUpdate(applicationIdsApplicationId, body)

Update the application, changing the fields specified by the field mask to the provided values.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ApplicationRegistryApi()
val applicationIdsApplicationId : kotlin.String = applicationIdsApplicationId_example // kotlin.String | 
val body : V3UpdateApplicationRequest =  // V3UpdateApplicationRequest | 
try {
    val result : V3Application = apiInstance.applicationRegistryUpdate(applicationIdsApplicationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ApplicationRegistryApi#applicationRegistryUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ApplicationRegistryApi#applicationRegistryUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **applicationIdsApplicationId** | **kotlin.String**|  |
 **body** | [**V3UpdateApplicationRequest**](V3UpdateApplicationRequest.md)|  |

### Return type

[**V3Application**](V3Application.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

