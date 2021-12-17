# PbaApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pbaDeleteHomeNetworkDefaultGatewayVisibility**](PbaApi.md#pbaDeleteHomeNetworkDefaultGatewayVisibility) | **DELETE** /pba/home-networks/gateway-visibilities/default | Deletes the default gateway visibility. Deleting gateway visibilities requires administrative access.
[**pbaDeleteHomeNetworkDefaultRoutingPolicy**](PbaApi.md#pbaDeleteHomeNetworkDefaultRoutingPolicy) | **DELETE** /pba/home-networks/policies/default | Deletes the default routing policy. Deleting routing policies requires administrative access.
[**pbaDeleteHomeNetworkRoutingPolicy**](PbaApi.md#pbaDeleteHomeNetworkRoutingPolicy) | **DELETE** /pba/home-networks/policies/{net_id} | Delete the routing policy for the given Home Network. Deleting routing policies requires administrative access.
[**pbaDeleteHomeNetworkRoutingPolicy2**](PbaApi.md#pbaDeleteHomeNetworkRoutingPolicy2) | **DELETE** /pba/home-networks/policies/{net_id}/{tenant_id} | Delete the routing policy for the given Home Network. Deleting routing policies requires administrative access.
[**pbaDeregister**](PbaApi.md#pbaDeregister) | **DELETE** /pba/registration | Deregister from Packet Broker. Packet Broker deregistration requires administrative access. Packet Broker deregistration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.
[**pbaGetHomeNetworkDefaultGatewayVisibility**](PbaApi.md#pbaGetHomeNetworkDefaultGatewayVisibility) | **GET** /pba/home-networks/gateway-visibilities/default | Get the default gateway visibility. Getting gateway visibilities requires administrative access.
[**pbaGetHomeNetworkDefaultRoutingPolicy**](PbaApi.md#pbaGetHomeNetworkDefaultRoutingPolicy) | **GET** /pba/home-networks/policies/default | Get the default routing policy. Getting routing policies requires administrative access.
[**pbaGetHomeNetworkRoutingPolicy**](PbaApi.md#pbaGetHomeNetworkRoutingPolicy) | **GET** /pba/home-networks/policies/{net_id} | Get the routing policy for the given Home Network. Getting routing policies requires administrative access.
[**pbaGetHomeNetworkRoutingPolicy2**](PbaApi.md#pbaGetHomeNetworkRoutingPolicy2) | **GET** /pba/home-networks/policies/{net_id}/{tenant_id} | Get the routing policy for the given Home Network. Getting routing policies requires administrative access.
[**pbaGetInfo**](PbaApi.md#pbaGetInfo) | **GET** /pba/info | Get information about the Packet Broker registration. Viewing Packet Packet information requires administrative access.
[**pbaListForwarderRoutingPolicies**](PbaApi.md#pbaListForwarderRoutingPolicies) | **GET** /pba/forwarders/policies | List the routing policies that Forwarders configured with Packet Broker Agent as Home Network. Listing routing policies requires administrative access.
[**pbaListHomeNetworkRoutingPolicies**](PbaApi.md#pbaListHomeNetworkRoutingPolicies) | **GET** /pba/home-networks/policies | List the routing policies that Packet Broker Agent as Forwarder configured with Home Networks. Listing routing policies requires administrative access.
[**pbaListHomeNetworks**](PbaApi.md#pbaListHomeNetworks) | **GET** /pba/home-networks | List the listed home networks for which routing policies can be configured. Listing home networks requires administrative access.
[**pbaListNetworks**](PbaApi.md#pbaListNetworks) | **GET** /pba/networks | List all listed networks. Listing networks requires administrative access.
[**pbaRegister**](PbaApi.md#pbaRegister) | **PUT** /pba/registration | Register with Packet Broker. If no registration exists, it will be created. Any existing registration will be updated. Registration settings not in the request message are taken from Packet Broker Agent configuration and caller context. Packet Broker registration requires administrative access. Packet Broker registration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.
[**pbaRegister2**](PbaApi.md#pbaRegister2) | **POST** /pba/registration | Register with Packet Broker. If no registration exists, it will be created. Any existing registration will be updated. Registration settings not in the request message are taken from Packet Broker Agent configuration and caller context. Packet Broker registration requires administrative access. Packet Broker registration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.
[**pbaSetHomeNetworkDefaultGatewayVisibility**](PbaApi.md#pbaSetHomeNetworkDefaultGatewayVisibility) | **PUT** /pba/home-networks/gateway-visibilities/default | Set the default gateway visibility. Setting gateway visibilities requires administrative access.
[**pbaSetHomeNetworkDefaultGatewayVisibility2**](PbaApi.md#pbaSetHomeNetworkDefaultGatewayVisibility2) | **POST** /pba/home-networks/gateway-visibilities/default | Set the default gateway visibility. Setting gateway visibilities requires administrative access.
[**pbaSetHomeNetworkDefaultRoutingPolicy**](PbaApi.md#pbaSetHomeNetworkDefaultRoutingPolicy) | **PUT** /pba/home-networks/policies/default | Set the default routing policy. Setting routing policies requires administrative access.
[**pbaSetHomeNetworkDefaultRoutingPolicy2**](PbaApi.md#pbaSetHomeNetworkDefaultRoutingPolicy2) | **POST** /pba/home-networks/policies/default | Set the default routing policy. Setting routing policies requires administrative access.
[**pbaSetHomeNetworkRoutingPolicy**](PbaApi.md#pbaSetHomeNetworkRoutingPolicy) | **PUT** /pba/home-networks/policies/{home_network_id.net_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
[**pbaSetHomeNetworkRoutingPolicy2**](PbaApi.md#pbaSetHomeNetworkRoutingPolicy2) | **POST** /pba/home-networks/policies/{home_network_id.net_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
[**pbaSetHomeNetworkRoutingPolicy3**](PbaApi.md#pbaSetHomeNetworkRoutingPolicy3) | **PUT** /pba/home-networks/policies/{home_network_id.net_id}/{home_network_id.tenant_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
[**pbaSetHomeNetworkRoutingPolicy4**](PbaApi.md#pbaSetHomeNetworkRoutingPolicy4) | **POST** /pba/home-networks/policies/{home_network_id.net_id}/{home_network_id.tenant_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.


<a name="pbaDeleteHomeNetworkDefaultGatewayVisibility"></a>
# **pbaDeleteHomeNetworkDefaultGatewayVisibility**
> kotlin.Any pbaDeleteHomeNetworkDefaultGatewayVisibility()

Deletes the default gateway visibility. Deleting gateway visibilities requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
try {
    val result : kotlin.Any = apiInstance.pbaDeleteHomeNetworkDefaultGatewayVisibility()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaDeleteHomeNetworkDefaultGatewayVisibility")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaDeleteHomeNetworkDefaultGatewayVisibility")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaDeleteHomeNetworkDefaultRoutingPolicy"></a>
# **pbaDeleteHomeNetworkDefaultRoutingPolicy**
> kotlin.Any pbaDeleteHomeNetworkDefaultRoutingPolicy()

Deletes the default routing policy. Deleting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
try {
    val result : kotlin.Any = apiInstance.pbaDeleteHomeNetworkDefaultRoutingPolicy()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaDeleteHomeNetworkDefaultRoutingPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaDeleteHomeNetworkDefaultRoutingPolicy")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaDeleteHomeNetworkRoutingPolicy"></a>
# **pbaDeleteHomeNetworkRoutingPolicy**
> kotlin.Any pbaDeleteHomeNetworkRoutingPolicy(netId, tenantId)

Delete the routing policy for the given Home Network. Deleting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val netId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val tenantId : kotlin.String = tenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
try {
    val result : kotlin.Any = apiInstance.pbaDeleteHomeNetworkRoutingPolicy(netId, tenantId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaDeleteHomeNetworkRoutingPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaDeleteHomeNetworkRoutingPolicy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **netId** | **kotlin.Long**| LoRa Alliance NetID. |
 **tenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. | [optional]

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaDeleteHomeNetworkRoutingPolicy2"></a>
# **pbaDeleteHomeNetworkRoutingPolicy2**
> kotlin.Any pbaDeleteHomeNetworkRoutingPolicy2(netId, tenantId)

Delete the routing policy for the given Home Network. Deleting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val netId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val tenantId : kotlin.String = tenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
try {
    val result : kotlin.Any = apiInstance.pbaDeleteHomeNetworkRoutingPolicy2(netId, tenantId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaDeleteHomeNetworkRoutingPolicy2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaDeleteHomeNetworkRoutingPolicy2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **netId** | **kotlin.Long**| LoRa Alliance NetID. |
 **tenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaDeregister"></a>
# **pbaDeregister**
> kotlin.Any pbaDeregister()

Deregister from Packet Broker. Packet Broker deregistration requires administrative access. Packet Broker deregistration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
try {
    val result : kotlin.Any = apiInstance.pbaDeregister()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaDeregister")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaDeregister")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaGetHomeNetworkDefaultGatewayVisibility"></a>
# **pbaGetHomeNetworkDefaultGatewayVisibility**
> V3PacketBrokerDefaultGatewayVisibility pbaGetHomeNetworkDefaultGatewayVisibility()

Get the default gateway visibility. Getting gateway visibilities requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
try {
    val result : V3PacketBrokerDefaultGatewayVisibility = apiInstance.pbaGetHomeNetworkDefaultGatewayVisibility()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaGetHomeNetworkDefaultGatewayVisibility")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaGetHomeNetworkDefaultGatewayVisibility")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3PacketBrokerDefaultGatewayVisibility**](V3PacketBrokerDefaultGatewayVisibility.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaGetHomeNetworkDefaultRoutingPolicy"></a>
# **pbaGetHomeNetworkDefaultRoutingPolicy**
> V3PacketBrokerDefaultRoutingPolicy pbaGetHomeNetworkDefaultRoutingPolicy()

Get the default routing policy. Getting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
try {
    val result : V3PacketBrokerDefaultRoutingPolicy = apiInstance.pbaGetHomeNetworkDefaultRoutingPolicy()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaGetHomeNetworkDefaultRoutingPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaGetHomeNetworkDefaultRoutingPolicy")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3PacketBrokerDefaultRoutingPolicy**](V3PacketBrokerDefaultRoutingPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaGetHomeNetworkRoutingPolicy"></a>
# **pbaGetHomeNetworkRoutingPolicy**
> V3PacketBrokerRoutingPolicy pbaGetHomeNetworkRoutingPolicy(netId, tenantId)

Get the routing policy for the given Home Network. Getting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val netId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val tenantId : kotlin.String = tenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
try {
    val result : V3PacketBrokerRoutingPolicy = apiInstance.pbaGetHomeNetworkRoutingPolicy(netId, tenantId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaGetHomeNetworkRoutingPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaGetHomeNetworkRoutingPolicy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **netId** | **kotlin.Long**| LoRa Alliance NetID. |
 **tenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. | [optional]

### Return type

[**V3PacketBrokerRoutingPolicy**](V3PacketBrokerRoutingPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaGetHomeNetworkRoutingPolicy2"></a>
# **pbaGetHomeNetworkRoutingPolicy2**
> V3PacketBrokerRoutingPolicy pbaGetHomeNetworkRoutingPolicy2(netId, tenantId)

Get the routing policy for the given Home Network. Getting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val netId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val tenantId : kotlin.String = tenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
try {
    val result : V3PacketBrokerRoutingPolicy = apiInstance.pbaGetHomeNetworkRoutingPolicy2(netId, tenantId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaGetHomeNetworkRoutingPolicy2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaGetHomeNetworkRoutingPolicy2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **netId** | **kotlin.Long**| LoRa Alliance NetID. |
 **tenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. |

### Return type

[**V3PacketBrokerRoutingPolicy**](V3PacketBrokerRoutingPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaGetInfo"></a>
# **pbaGetInfo**
> V3PacketBrokerInfo pbaGetInfo()

Get information about the Packet Broker registration. Viewing Packet Packet information requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
try {
    val result : V3PacketBrokerInfo = apiInstance.pbaGetInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaGetInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaGetInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**V3PacketBrokerInfo**](V3PacketBrokerInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaListForwarderRoutingPolicies"></a>
# **pbaListForwarderRoutingPolicies**
> V3PacketBrokerRoutingPolicies pbaListForwarderRoutingPolicies(homeNetworkIdNetId, homeNetworkIdTenantId, limit, page)

List the routing policies that Forwarders configured with Packet Broker Agent as Home Network. Listing routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val homeNetworkIdNetId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val homeNetworkIdTenantId : kotlin.String = homeNetworkIdTenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3PacketBrokerRoutingPolicies = apiInstance.pbaListForwarderRoutingPolicies(homeNetworkIdNetId, homeNetworkIdTenantId, limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaListForwarderRoutingPolicies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaListForwarderRoutingPolicies")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **homeNetworkIdNetId** | **kotlin.Long**| LoRa Alliance NetID. | [optional]
 **homeNetworkIdTenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. | [optional]
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3PacketBrokerRoutingPolicies**](V3PacketBrokerRoutingPolicies.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaListHomeNetworkRoutingPolicies"></a>
# **pbaListHomeNetworkRoutingPolicies**
> V3PacketBrokerRoutingPolicies pbaListHomeNetworkRoutingPolicies(limit, page)

List the routing policies that Packet Broker Agent as Forwarder configured with Home Networks. Listing routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
try {
    val result : V3PacketBrokerRoutingPolicies = apiInstance.pbaListHomeNetworkRoutingPolicies(limit, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaListHomeNetworkRoutingPolicies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaListHomeNetworkRoutingPolicies")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]

### Return type

[**V3PacketBrokerRoutingPolicies**](V3PacketBrokerRoutingPolicies.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaListHomeNetworks"></a>
# **pbaListHomeNetworks**
> V3PacketBrokerNetworks pbaListHomeNetworks(limit, page, tenantIdContains, nameContains)

List the listed home networks for which routing policies can be configured. Listing home networks requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val tenantIdContains : kotlin.String = tenantIdContains_example // kotlin.String | Filter by tenant ID.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Filter by name.
try {
    val result : V3PacketBrokerNetworks = apiInstance.pbaListHomeNetworks(limit, page, tenantIdContains, nameContains)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaListHomeNetworks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaListHomeNetworks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **tenantIdContains** | **kotlin.String**| Filter by tenant ID. | [optional]
 **nameContains** | **kotlin.String**| Filter by name. | [optional]

### Return type

[**V3PacketBrokerNetworks**](V3PacketBrokerNetworks.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaListNetworks"></a>
# **pbaListNetworks**
> V3PacketBrokerNetworks pbaListNetworks(limit, page, withRoutingPolicy, tenantIdContains, nameContains)

List all listed networks. Listing networks requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val limit : kotlin.Long = 789 // kotlin.Long | Limit the number of results per page.
val page : kotlin.Long = 789 // kotlin.Long | Page number for pagination. 0 is interpreted as 1.
val withRoutingPolicy : kotlin.Boolean = true // kotlin.Boolean | If true, list only the Forwarders and Home Networks with whom a routing policy has been defined in either direction.
val tenantIdContains : kotlin.String = tenantIdContains_example // kotlin.String | Filter by tenant ID.
val nameContains : kotlin.String = nameContains_example // kotlin.String | Filter by name.
try {
    val result : V3PacketBrokerNetworks = apiInstance.pbaListNetworks(limit, page, withRoutingPolicy, tenantIdContains, nameContains)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaListNetworks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaListNetworks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **kotlin.Long**| Limit the number of results per page. | [optional]
 **page** | **kotlin.Long**| Page number for pagination. 0 is interpreted as 1. | [optional]
 **withRoutingPolicy** | **kotlin.Boolean**| If true, list only the Forwarders and Home Networks with whom a routing policy has been defined in either direction. | [optional]
 **tenantIdContains** | **kotlin.String**| Filter by tenant ID. | [optional]
 **nameContains** | **kotlin.String**| Filter by name. | [optional]

### Return type

[**V3PacketBrokerNetworks**](V3PacketBrokerNetworks.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pbaRegister"></a>
# **pbaRegister**
> V3PacketBrokerNetwork pbaRegister(body)

Register with Packet Broker. If no registration exists, it will be created. Any existing registration will be updated. Registration settings not in the request message are taken from Packet Broker Agent configuration and caller context. Packet Broker registration requires administrative access. Packet Broker registration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val body : V3PacketBrokerRegisterRequest =  // V3PacketBrokerRegisterRequest | 
try {
    val result : V3PacketBrokerNetwork = apiInstance.pbaRegister(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaRegister")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaRegister")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3PacketBrokerRegisterRequest**](V3PacketBrokerRegisterRequest.md)|  |

### Return type

[**V3PacketBrokerNetwork**](V3PacketBrokerNetwork.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaRegister2"></a>
# **pbaRegister2**
> V3PacketBrokerNetwork pbaRegister2(body)

Register with Packet Broker. If no registration exists, it will be created. Any existing registration will be updated. Registration settings not in the request message are taken from Packet Broker Agent configuration and caller context. Packet Broker registration requires administrative access. Packet Broker registration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val body : V3PacketBrokerRegisterRequest =  // V3PacketBrokerRegisterRequest | 
try {
    val result : V3PacketBrokerNetwork = apiInstance.pbaRegister2(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaRegister2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaRegister2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3PacketBrokerRegisterRequest**](V3PacketBrokerRegisterRequest.md)|  |

### Return type

[**V3PacketBrokerNetwork**](V3PacketBrokerNetwork.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkDefaultGatewayVisibility"></a>
# **pbaSetHomeNetworkDefaultGatewayVisibility**
> kotlin.Any pbaSetHomeNetworkDefaultGatewayVisibility(body)

Set the default gateway visibility. Setting gateway visibilities requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val body : V3SetPacketBrokerDefaultGatewayVisibilityRequest =  // V3SetPacketBrokerDefaultGatewayVisibilityRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkDefaultGatewayVisibility(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkDefaultGatewayVisibility")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkDefaultGatewayVisibility")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3SetPacketBrokerDefaultGatewayVisibilityRequest**](V3SetPacketBrokerDefaultGatewayVisibilityRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkDefaultGatewayVisibility2"></a>
# **pbaSetHomeNetworkDefaultGatewayVisibility2**
> kotlin.Any pbaSetHomeNetworkDefaultGatewayVisibility2(body)

Set the default gateway visibility. Setting gateway visibilities requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val body : V3SetPacketBrokerDefaultGatewayVisibilityRequest =  // V3SetPacketBrokerDefaultGatewayVisibilityRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkDefaultGatewayVisibility2(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkDefaultGatewayVisibility2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkDefaultGatewayVisibility2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3SetPacketBrokerDefaultGatewayVisibilityRequest**](V3SetPacketBrokerDefaultGatewayVisibilityRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkDefaultRoutingPolicy"></a>
# **pbaSetHomeNetworkDefaultRoutingPolicy**
> kotlin.Any pbaSetHomeNetworkDefaultRoutingPolicy(body)

Set the default routing policy. Setting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val body : V3SetPacketBrokerDefaultRoutingPolicyRequest =  // V3SetPacketBrokerDefaultRoutingPolicyRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkDefaultRoutingPolicy(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkDefaultRoutingPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkDefaultRoutingPolicy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3SetPacketBrokerDefaultRoutingPolicyRequest**](V3SetPacketBrokerDefaultRoutingPolicyRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkDefaultRoutingPolicy2"></a>
# **pbaSetHomeNetworkDefaultRoutingPolicy2**
> kotlin.Any pbaSetHomeNetworkDefaultRoutingPolicy2(body)

Set the default routing policy. Setting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val body : V3SetPacketBrokerDefaultRoutingPolicyRequest =  // V3SetPacketBrokerDefaultRoutingPolicyRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkDefaultRoutingPolicy2(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkDefaultRoutingPolicy2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkDefaultRoutingPolicy2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3SetPacketBrokerDefaultRoutingPolicyRequest**](V3SetPacketBrokerDefaultRoutingPolicyRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkRoutingPolicy"></a>
# **pbaSetHomeNetworkRoutingPolicy**
> kotlin.Any pbaSetHomeNetworkRoutingPolicy(homeNetworkIdNetId, body)

Set the routing policy for the given Home Network. Setting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val homeNetworkIdNetId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val body : V3SetPacketBrokerRoutingPolicyRequest =  // V3SetPacketBrokerRoutingPolicyRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkRoutingPolicy(homeNetworkIdNetId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **homeNetworkIdNetId** | **kotlin.Long**| LoRa Alliance NetID. |
 **body** | [**V3SetPacketBrokerRoutingPolicyRequest**](V3SetPacketBrokerRoutingPolicyRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkRoutingPolicy2"></a>
# **pbaSetHomeNetworkRoutingPolicy2**
> kotlin.Any pbaSetHomeNetworkRoutingPolicy2(homeNetworkIdNetId, body)

Set the routing policy for the given Home Network. Setting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val homeNetworkIdNetId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val body : V3SetPacketBrokerRoutingPolicyRequest =  // V3SetPacketBrokerRoutingPolicyRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkRoutingPolicy2(homeNetworkIdNetId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy2")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **homeNetworkIdNetId** | **kotlin.Long**| LoRa Alliance NetID. |
 **body** | [**V3SetPacketBrokerRoutingPolicyRequest**](V3SetPacketBrokerRoutingPolicyRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkRoutingPolicy3"></a>
# **pbaSetHomeNetworkRoutingPolicy3**
> kotlin.Any pbaSetHomeNetworkRoutingPolicy3(homeNetworkIdNetId, homeNetworkIdTenantId, body)

Set the routing policy for the given Home Network. Setting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val homeNetworkIdNetId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val homeNetworkIdTenantId : kotlin.String = homeNetworkIdTenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
val body : V3SetPacketBrokerRoutingPolicyRequest =  // V3SetPacketBrokerRoutingPolicyRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkRoutingPolicy3(homeNetworkIdNetId, homeNetworkIdTenantId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy3")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy3")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **homeNetworkIdNetId** | **kotlin.Long**| LoRa Alliance NetID. |
 **homeNetworkIdTenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. |
 **body** | [**V3SetPacketBrokerRoutingPolicyRequest**](V3SetPacketBrokerRoutingPolicyRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pbaSetHomeNetworkRoutingPolicy4"></a>
# **pbaSetHomeNetworkRoutingPolicy4**
> kotlin.Any pbaSetHomeNetworkRoutingPolicy4(homeNetworkIdNetId, homeNetworkIdTenantId, body)

Set the routing policy for the given Home Network. Setting routing policies requires administrative access.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = PbaApi()
val homeNetworkIdNetId : kotlin.Long = 789 // kotlin.Long | LoRa Alliance NetID.
val homeNetworkIdTenantId : kotlin.String = homeNetworkIdTenantId_example // kotlin.String | Tenant identifier if the registration leases DevAddr blocks from a NetID.
val body : V3SetPacketBrokerRoutingPolicyRequest =  // V3SetPacketBrokerRoutingPolicyRequest | 
try {
    val result : kotlin.Any = apiInstance.pbaSetHomeNetworkRoutingPolicy4(homeNetworkIdNetId, homeNetworkIdTenantId, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy4")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PbaApi#pbaSetHomeNetworkRoutingPolicy4")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **homeNetworkIdNetId** | **kotlin.Long**| LoRa Alliance NetID. |
 **homeNetworkIdTenantId** | **kotlin.String**| Tenant identifier if the registration leases DevAddr blocks from a NetID. |
 **body** | [**V3SetPacketBrokerRoutingPolicyRequest**](V3SetPacketBrokerRoutingPolicyRequest.md)|  |

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

