
# V3Organization

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3OrganizationIdentifiers**](V3OrganizationIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the organization was created. This information is public and can be seen by any authenticated user in the network. |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the organization was last updated. This information is public and can be seen by any authenticated user in the network. |  [optional]
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the organization was deleted. This information is public and can be seen by any authenticated user in the network. |  [optional]
**name** | **kotlin.String** | The name of the organization. This information is public and can be seen by any authenticated user in the network. |  [optional]
**description** | **kotlin.String** | A description for the organization. |  [optional]
**attributes** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Key-value attributes for this organization. Typically used for organizing organizations or for storing integration-specific data. |  [optional]
**contactInfo** | [**kotlin.collections.List&lt;V3ContactInfo&gt;**](V3ContactInfo.md) | Contact information for this organization. Typically used to indicate who to contact with security/billing questions about the organization. |  [optional]



