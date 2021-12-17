
# V3Client

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3ClientIdentifiers**](V3ClientIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the OAuth client was created. This information is public and can be seen by any authenticated user in the network. |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the OAuth client was last updated. This information is public and can be seen by any authenticated user in the network. |  [optional]
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the OAuth client was deleted. This information is public and can be seen by any authenticated user in the network. |  [optional]
**name** | **kotlin.String** | The name of the OAuth client. This information is public and can be seen by any authenticated user in the network. |  [optional]
**description** | **kotlin.String** | A description for the OAuth client. This information is public and can be seen by any authenticated user in the network. |  [optional]
**attributes** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Key-value attributes for this client. Typically used for organizing clients or for storing integration-specific data. |  [optional]
**contactInfo** | [**kotlin.collections.List&lt;V3ContactInfo&gt;**](V3ContactInfo.md) | Contact information for this client. Typically used to indicate who to contact with technical/security questions about the application. This information is public and can be seen by any authenticated user in the network. |  [optional]
**secret** | **kotlin.String** | The client secret is only visible to collaborators of the client. |  [optional]
**redirectUris** | **kotlin.collections.List&lt;kotlin.String&gt;** | The allowed redirect URIs against which authorization requests are checked. If the authorization request does not pass a redirect URI, the first one from this list is taken. This information is public and can be seen by any authenticated user in the network. |  [optional]
**logoutRedirectUris** | **kotlin.collections.List&lt;kotlin.String&gt;** | The allowed logout redirect URIs against which client initiated logout requests are checked. If the authorization request does not pass a redirect URI, the first one from this list is taken. This information is public and can be seen by any authenticated user in the network. |  [optional]
**state** | [**V3State**](V3State.md) |  |  [optional]
**stateDescription** | **kotlin.String** | A description for the state field. This field can only be modified by admins, and should typically only be updated when also updating &#x60;state&#x60;. |  [optional]
**skipAuthorization** | **kotlin.Boolean** | If set, the authorization page will be skipped. This information is public and can be seen by any authenticated user in the network. This field can only be modified by admins. |  [optional]
**endorsed** | **kotlin.Boolean** | If set, the authorization page will show endorsement. This information is public and can be seen by any authenticated user in the network. This field can only be modified by admins. |  [optional]
**grants** | [**kotlin.collections.List&lt;V3GrantType&gt;**](V3GrantType.md) | OAuth flows that can be used for the client to get a token. This information is public and can be seen by any authenticated user in the network. After a client is created, this field can only be modified by admins. |  [optional]
**rights** | [**kotlin.collections.List&lt;V3Right&gt;**](V3Right.md) | Rights denotes what rights the client will have access to. This information is public and can be seen by any authenticated user in the network. Users that previously authorized this client will have to re-authorize the client after rights are added to this list. |  [optional]



