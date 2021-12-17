
# V3User

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3UserIdentifiers**](V3UserIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the user was created. This information is public and can be seen by any authenticated user in the network. |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the user was last updated. This information is public and can be seen by any authenticated user in the network. |  [optional]
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the user was deleted. This information is public and can be seen by any authenticated user in the network. |  [optional]
**name** | **kotlin.String** | The name of the user. This information is public and can be seen by any authenticated user in the network. |  [optional]
**description** | **kotlin.String** | A description for the user. This information is public and can be seen by any authenticated user in the network. |  [optional]
**attributes** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Key-value attributes for this users. Typically used for storing integration-specific data. |  [optional]
**contactInfo** | [**kotlin.collections.List&lt;V3ContactInfo&gt;**](V3ContactInfo.md) | Contact information for this user. Typically used to indicate who to contact with security/billing questions about the user. |  [optional]
**primaryEmailAddress** | **kotlin.String** | Primary email address that can be used for logging in. This address is not public, use contact_info for that. |  [optional]
**primaryEmailAddressValidatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the primary email address was validated. Note that email address validation is not required on all networks. |  [optional]
**password** | **kotlin.String** | The password field is only considered when creating a user. It is not returned on API calls, and can not be updated by updating the User. See the UpdatePassword method of the UserRegistry service for more information. |  [optional]
**passwordUpdatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**requirePasswordUpdate** | **kotlin.Boolean** |  |  [optional]
**state** | [**V3State**](V3State.md) |  |  [optional]
**stateDescription** | **kotlin.String** | A description for the state field. This field can only be modified by admins, and should typically only be updated when also updating &#x60;state&#x60;. |  [optional]
**admin** | **kotlin.Boolean** | This user is an admin. This information is public and can be seen by any authenticated user in the network. This field can only be modified by other admins. |  [optional]
**temporaryPassword** | **kotlin.String** | The temporary password can only be used to update a user&#39;s password; never returned on API calls. It is not returned on API calls, and can not be updated by updating the User. See the CreateTemporaryPassword method of the UserRegistry service for more information. |  [optional]
**temporaryPasswordCreatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**temporaryPasswordExpiresAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**profilePicture** | [**V3Picture**](V3Picture.md) |  |  [optional]



