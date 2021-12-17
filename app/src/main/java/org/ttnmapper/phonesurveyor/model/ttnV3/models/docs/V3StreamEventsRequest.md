
# V3StreamEventsRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**identifiers** | [**kotlin.collections.List&lt;V3EntityIdentifiers&gt;**](V3EntityIdentifiers.md) |  |  [optional]
**tail** | **kotlin.Long** | If greater than zero, this will return historical events, up to this maximum when the stream starts. If used in combination with \&quot;after\&quot;, the limit that is reached first, is used. The availability of historical events depends on server support and retention policy. |  [optional]
**after** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | If not empty, this will return historical events after the given time when the stream starts. If used in combination with \&quot;tail\&quot;, the limit that is reached first, is used. The availability of historical events depends on server support and retention policy. |  [optional]
**names** | **kotlin.collections.List&lt;kotlin.String&gt;** | If provided, this will filter events, so that only events with the given names are returned. Names can be provided as either exact event names (e.g. &#39;gs.up.receive&#39;), or as regular expressions (e.g. &#39;/^gs\\..+/&#39;). |  [optional]



