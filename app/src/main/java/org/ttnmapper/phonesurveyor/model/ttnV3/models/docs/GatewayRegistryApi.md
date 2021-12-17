# GatewayRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gatewayRegistryCreate**](GatewayRegistryApi.md#gatewayRegistryCreate) | **POST** /users/{collaborator.user_ids.user_id}/gateways | Create a new gateway. This also sets the given organization or user as first collaborator with all possible rights.
[**gatewayRegistryCreate2**](GatewayRegistryApi.md#gatewayRegistryCreate2) | **POST** /organizations/{collaborator.organization_ids.organization_id}/gateways | Create a new gateway. This also sets the given organization or user as first collaborator with all possible rights.
[**gatewayRegistryDelete**](GatewayRegistryApi.md#gatewayRegistryDelete) | **DELETE** /gateways/{gateway_id} | Delete the gateway. This may not release the gateway ID for reuse, but it does release the EUI.
[**gatewayRegistryGet**](GatewayRegistryApi.md#gatewayRegistryGet) | **GET** /gateways/{gateway_ids.gateway_id} | Get the gateway with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
[**gatewayRegistryList**](GatewayRegistryApi.md#gatewayRegistryList) | **GET** /gateways | List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**gatewayRegistryList2**](GatewayRegistryApi.md#gatewayRegistryList2) | **GET** /users/{collaborator.user_ids.user_id}/gateways | List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**gatewayRegistryList3**](GatewayRegistryApi.md#gatewayRegistryList3) | **GET** /organizations/{collaborator.organization_ids.organization_id}/gateways | List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
[**gatewayRegistryPurge**](GatewayRegistryApi.md#gatewayRegistryPurge) | **DELETE** /gateways/{gateway_id}/purge | Purge the gateway. This will release both gateway ID and EUI for reuse. The gateway owner is responsible for clearing data from any (external) integrations that may store and expose data by gateway ID.
[**gatewayRegistryRestore**](GatewayRegistryApi.md#gatewayRegistryRestore) | **POST** /gateways/{gateway_id}/restore | Restore a recently deleted gateway. This does not restore the EUI, as that was released when deleting the gateway.
[**gatewayRegistryUpdate**](GatewayRegistryApi.md#gatewayRegistryUpdate) | **PUT** /gateways/{gateway.ids.gateway_id} | Update the gateway, changing the fields specified by the field mask to the provided values.


<a name="gatewayRegistryCreate"></a>
# **gatewayRegistryCreate**
> V3Gateway gatewayRegistryCreate(collaboratorUserIdsUserId, body)

Create a new gateway. This also sets the given organization or user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val body : V3CreateGatewayRequest =  // V3CreateGatewayRequest | 
try {
    val result : V3Gateway = apiInstance.gatewayRegistryCreate(collaboratorUserIdsUserId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryCreate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorUserIdsUserId** | **kotlin.String**| This ID shares namespace with organization IDs. |
 **body** | [**V3CreateGatewayRequest**](V3CreateGatewayRequest.md)|  |

### Return type

[**V3Gateway**](V3Gateway.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gatewayRegistryCreate2"></a>
# **gatewayRegistryCreate2**
> V3Gateway gatewayRegistryCreate2(collaboratorOrganizationIdsOrganizationId, body)

Create a new gateway. This also sets the given organization or user as first collaborator with all possible rights.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val body : V3CreateGatewayRequest =  // V3CreateGatewayRequest | 
try {
    val result : V3Gateway = apiInstance.gatewayRegistryCreate2(collaboratorOrganizationIdsOrganizationId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryCreate2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryCreate2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **collaboratorOrganizationIdsOrganizationId** | **kotlin.String**| This ID shares namespace with user IDs. |
 **body** | [**V3CreateGatewayRequest**](V3CreateGatewayRequest.md)|  |

### Return type

[**V3Gateway**](V3Gateway.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="gatewayRegistryDelete"></a>
# **gatewayRegistryDelete**
> kotlin.Any gatewayRegistryDelete(gatewayId, eui)

Delete the gateway. This may not release the gateway ID for reuse, but it does release the EUI.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.gatewayRegistryDelete(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryDelete")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryGet"></a>
# **gatewayRegistryGet**
> V3Gateway gatewayRegistryGet(gatewayIdsGatewayId, gatewayIdsEui, fieldMaskPaths)

Get the gateway with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val gatewayIdsEui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
try {
    val result : V3Gateway = apiInstance.gatewayRegistryGet(gatewayIdsGatewayId, gatewayIdsEui, fieldMaskPaths)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **gatewayIdsEui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]
 **fieldMaskPaths** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The set of field mask paths. | [optional]

### Return type

[**V3Gateway**](V3Gateway.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryList"></a>
# **gatewayRegistryList**
> V3Gateways gatewayRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted gateways.
try {
    val result : V3Gateways = apiInstance.gatewayRegistryList(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryList")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted gateways. | [optional]

### Return type

[**V3Gateways**](V3Gateways.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryList2"></a>
# **gatewayRegistryList2**
> V3Gateways gatewayRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted gateways.
try {
    val result : V3Gateways = apiInstance.gatewayRegistryList2(collaboratorUserIdsUserId, collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryList2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryList2")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted gateways. | [optional]

### Return type

[**V3Gateways**](V3Gateways.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryList3"></a>
# **gatewayRegistryList3**
> V3Gateways gatewayRegistryList3(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)

List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val collaboratorOrganizationIdsOrganizationId : kotlin.String = collaboratorOrganizationIdsOrganizationId_example // kotlin.String | This ID shares namespace with user IDs.
val collaboratorUserIdsUserId : kotlin.String = collaboratorUserIdsUserId_example // kotlin.String | This ID shares namespace with organization IDs.
val collaboratorUserIdsEmail : kotlin.String = collaboratorUserIdsEmail_example // kotlin.String | Secondary identifier, which can only be used in specific requests.
val fieldMaskPaths : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The set of field mask paths.
val order : kotlin.String = order_example // kotlin.String | Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val deleted : kotlin.Boolean = true // kotlin.Boolean | Only return recently deleted gateways.
try {
    val result : V3Gateways = apiInstance.gatewayRegistryList3(collaboratorOrganizationIdsOrganizationId, collaboratorUserIdsUserId, collaboratorUserIdsEmail, fieldMaskPaths, order, limit, page, deleted)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryList3")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryList3")
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
 **deleted** | **kotlin.Boolean**| Only return recently deleted gateways. | [optional]

### Return type

[**V3Gateways**](V3Gateways.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryPurge"></a>
# **gatewayRegistryPurge**
> kotlin.Any gatewayRegistryPurge(gatewayId, eui)

Purge the gateway. This will release both gateway ID and EUI for reuse. The gateway owner is responsible for clearing data from any (external) integrations that may store and expose data by gateway ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
val eui : kotlin.ByteArray = BYTE_ARRAY_DATA_HERE // kotlin.ByteArray | Secondary identifier, which can only be used in specific requests.
try {
    val result : kotlin.Any = apiInstance.gatewayRegistryPurge(gatewayId, eui)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryPurge")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryPurge")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |
 **eui** | **kotlin.ByteArray**| Secondary identifier, which can only be used in specific requests. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryRestore"></a>
# **gatewayRegistryRestore**
> kotlin.Any gatewayRegistryRestore(gatewayId)

Restore a recently deleted gateway. This does not restore the EUI, as that was released when deleting the gateway.

Deployment configuration may specify if, and for how long after deletion, entities can be restored.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val gatewayId : kotlin.String = gatewayId_example // kotlin.String | 
try {
    val result : kotlin.Any = apiInstance.gatewayRegistryRestore(gatewayId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryRestore")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryRestore")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayId** | **kotlin.String**|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="gatewayRegistryUpdate"></a>
# **gatewayRegistryUpdate**
> V3Gateway gatewayRegistryUpdate(gatewayIdsGatewayId, body)

Update the gateway, changing the fields specified by the field mask to the provided values.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = GatewayRegistryApi()
val gatewayIdsGatewayId : kotlin.String = gatewayIdsGatewayId_example // kotlin.String | 
val body : V3UpdateGatewayRequest =  // V3UpdateGatewayRequest | 
try {
    val result : V3Gateway = apiInstance.gatewayRegistryUpdate(gatewayIdsGatewayId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GatewayRegistryApi#gatewayRegistryUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GatewayRegistryApi#gatewayRegistryUpdate")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gatewayIdsGatewayId** | **kotlin.String**|  |
 **body** | [**V3UpdateGatewayRequest**](V3UpdateGatewayRequest.md)|  |

### Return type

[**V3Gateway**](V3Gateway.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

