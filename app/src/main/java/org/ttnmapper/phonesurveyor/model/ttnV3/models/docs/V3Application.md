
# V3Application

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3ApplicationIdentifiers**](V3ApplicationIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the application was created. This information is public and can be seen by any authenticated user in the network. |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the application was last updated. This information is public and can be seen by any authenticated user in the network. |  [optional]
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the application was deleted. This information is public and can be seen by any authenticated user in the network. |  [optional]
**name** | **kotlin.String** | The name of the application. |  [optional]
**description** | **kotlin.String** | A description for the application. |  [optional]
**attributes** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Key-value attributes for this application. Typically used for organizing applications or for storing integration-specific data. |  [optional]
**contactInfo** | [**kotlin.collections.List&lt;V3ContactInfo&gt;**](V3ContactInfo.md) | Contact information for this application. Typically used to indicate who to contact with technical/security questions about the application. |  [optional]
**devEuiCounter** | **kotlin.Long** |  |  [optional]



