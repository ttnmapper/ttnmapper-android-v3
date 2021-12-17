# EventsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**eventsFindRelated**](EventsApi.md#eventsFindRelated) | **GET** /events/related | 
[**eventsStream**](EventsApi.md#eventsStream) | **POST** /events | Stream live events, optionally with a tail of historical events (depending on server support and retention policy). Events may arrive out-of-order.


<a name="eventsFindRelated"></a>
# **eventsFindRelated**
> V3FindRelatedEventsResponse eventsFindRelated(correlationId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EventsApi()
val correlationId : kotlin.String = correlationId_example // kotlin.String | 
try {
    val result : V3FindRelatedEventsResponse = apiInstance.eventsFindRelated(correlationId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EventsApi#eventsFindRelated")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EventsApi#eventsFindRelated")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **correlationId** | **kotlin.String**|  | [optional]

### Return type

[**V3FindRelatedEventsResponse**](V3FindRelatedEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="eventsStream"></a>
# **eventsStream**
> StreamResultOfV3Event eventsStream(body)

Stream live events, optionally with a tail of historical events (depending on server support and retention policy). Events may arrive out-of-order.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = EventsApi()
val body : V3StreamEventsRequest =  // V3StreamEventsRequest | 
try {
    val result : StreamResultOfV3Event = apiInstance.eventsStream(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EventsApi#eventsStream")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EventsApi#eventsStream")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V3StreamEventsRequest**](V3StreamEventsRequest.md)|  |

### Return type

[**StreamResultOfV3Event**](StreamResultOfV3Event.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

