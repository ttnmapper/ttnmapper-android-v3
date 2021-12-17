# org.openapitools.client - Kotlin client library for The Things Stack for LoRaWAN v3 API

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AppAsApi* | [**appAsDecodeDownlink**](docs/AppAsApi.md#appasdecodedownlink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/decode | 
*AppAsApi* | [**appAsDecodeUplink**](docs/AppAsApi.md#appasdecodeuplink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/up/decode | 
*AppAsApi* | [**appAsDownlinkQueueList**](docs/AppAsApi.md#appasdownlinkqueuelist) | **GET** /as/applications/{application_ids.application_id}/devices/{device_id}/down | List the items currently in the downlink queue.
*AppAsApi* | [**appAsDownlinkQueuePush**](docs/AppAsApi.md#appasdownlinkqueuepush) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/push | Push downlink messages to the end of the downlink queue.
*AppAsApi* | [**appAsDownlinkQueueReplace**](docs/AppAsApi.md#appasdownlinkqueuereplace) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/replace | Replace the entire downlink queue with the specified messages. This can also be used to empty the queue by specifying no messages.
*AppAsApi* | [**appAsEncodeDownlink**](docs/AppAsApi.md#appasencodedownlink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/down/encode | 
*AppAsApi* | [**appAsGetMQTTConnectionInfo**](docs/AppAsApi.md#appasgetmqttconnectioninfo) | **GET** /as/applications/{application_id}/mqtt-connection-info | Get connection information to connect an MQTT client.
*AppAsApi* | [**appAsSimulateUplink**](docs/AppAsApi.md#appassimulateuplink) | **POST** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/up/simulate | Simulate an upstream message. This can be used to test integrations.
*ApplicationAccessApi* | [**applicationAccessCreateAPIKey**](docs/ApplicationAccessApi.md#applicationaccesscreateapikey) | **POST** /applications/{application_ids.application_id}/api-keys | Create an API key scoped to this application.
*ApplicationAccessApi* | [**applicationAccessGetAPIKey**](docs/ApplicationAccessApi.md#applicationaccessgetapikey) | **GET** /applications/{application_ids.application_id}/api-keys/{key_id} | Get a single API key of this application.
*ApplicationAccessApi* | [**applicationAccessGetCollaborator**](docs/ApplicationAccessApi.md#applicationaccessgetcollaborator) | **GET** /applications/{application_ids.application_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the application. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*ApplicationAccessApi* | [**applicationAccessGetCollaborator2**](docs/ApplicationAccessApi.md#applicationaccessgetcollaborator2) | **GET** /applications/{application_ids.application_id}/collaborator/organization/{collaborator.organization_ids.organization_id} | Get the rights of a collaborator (member) of the application. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*ApplicationAccessApi* | [**applicationAccessListAPIKeys**](docs/ApplicationAccessApi.md#applicationaccesslistapikeys) | **GET** /applications/{application_ids.application_id}/api-keys | List the API keys for this application.
*ApplicationAccessApi* | [**applicationAccessListCollaborators**](docs/ApplicationAccessApi.md#applicationaccesslistcollaborators) | **GET** /applications/{application_ids.application_id}/collaborators | List the collaborators on this application.
*ApplicationAccessApi* | [**applicationAccessListRights**](docs/ApplicationAccessApi.md#applicationaccesslistrights) | **GET** /applications/{application_id}/rights | List the rights the caller has on this application.
*ApplicationAccessApi* | [**applicationAccessSetCollaborator**](docs/ApplicationAccessApi.md#applicationaccesssetcollaborator) | **PUT** /applications/{application_ids.application_id}/collaborators | Set the rights of a collaborator (member) on the application. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
*ApplicationAccessApi* | [**applicationAccessUpdateAPIKey**](docs/ApplicationAccessApi.md#applicationaccessupdateapikey) | **PUT** /applications/{application_ids.application_id}/api-keys/{api_key.id} | Update the rights of an API key of the application. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.
*ApplicationActivationSettingRegistryApi* | [**applicationActivationSettingRegistryDelete**](docs/ApplicationActivationSettingRegistryApi.md#applicationactivationsettingregistrydelete) | **DELETE** /js/applications/{application_ids.application_id}/settings | Delete deletes application activation settings.
*ApplicationActivationSettingRegistryApi* | [**applicationActivationSettingRegistryGet**](docs/ApplicationActivationSettingRegistryApi.md#applicationactivationsettingregistryget) | **GET** /js/applications/{application_ids.application_id}/settings | Get returns application activation settings.
*ApplicationActivationSettingRegistryApi* | [**applicationActivationSettingRegistrySet**](docs/ApplicationActivationSettingRegistryApi.md#applicationactivationsettingregistryset) | **POST** /js/applications/{application_ids.application_id}/settings | Set creates or updates application activation settings.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryDeleteAssociation**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrydeleteassociation) | **DELETE** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/packages/associations/{f_port} | DeleteAssociation removes the association on the FPort of the end device.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryDeleteDefaultAssociation**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrydeletedefaultassociation) | **DELETE** /as/applications/{application_ids.application_id}/packages/associations/{f_port} | DeleteDefaultAssociation removes the default association on the FPort of the application.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryGetAssociation**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrygetassociation) | **GET** /as/applications/{ids.end_device_ids.application_ids.application_id}/devices/{ids.end_device_ids.device_id}/packages/associations/{ids.f_port} | GetAssociation returns the association registered on the FPort of the end device.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryGetDefaultAssociation**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrygetdefaultassociation) | **GET** /as/applications/{ids.application_ids.application_id}/packages/associations/{ids.f_port} | GetDefaultAssociation returns the default association registered on the FPort of the application.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryList**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrylist) | **GET** /as/applications/{application_ids.application_id}/devices/{device_id}/packages | List returns the available packages for the end device.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryListAssociations**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrylistassociations) | **GET** /as/applications/{ids.application_ids.application_id}/devices/{ids.device_id}/packages/associations | ListAssociations returns all of the associations of the end device.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistryListDefaultAssociations**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrylistdefaultassociations) | **GET** /as/applications/{ids.application_id}/packages/associations | ListDefaultAssociations returns all of the default associations of the application.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistrySetAssociation**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrysetassociation) | **PUT** /as/applications/{association.ids.end_device_ids.application_ids.application_id}/devices/{association.ids.end_device_ids.device_id}/packages/associations/{association.ids.f_port} | SetAssociation updates or creates the association on the FPort of the end device.
*ApplicationPackageRegistryApi* | [**applicationPackageRegistrySetDefaultAssociation**](docs/ApplicationPackageRegistryApi.md#applicationpackageregistrysetdefaultassociation) | **PUT** /as/applications/{default.ids.application_ids.application_id}/packages/associations/{default.ids.f_port} | SetDefaultAssociation updates or creates the default association on the FPort of the application.
*ApplicationPubSubRegistryApi* | [**applicationPubSubRegistryDelete**](docs/ApplicationPubSubRegistryApi.md#applicationpubsubregistrydelete) | **DELETE** /as/pubsub/{application_ids.application_id}/{pub_sub_id} | 
*ApplicationPubSubRegistryApi* | [**applicationPubSubRegistryGet**](docs/ApplicationPubSubRegistryApi.md#applicationpubsubregistryget) | **GET** /as/pubsub/{ids.application_ids.application_id}/{ids.pub_sub_id} | 
*ApplicationPubSubRegistryApi* | [**applicationPubSubRegistryGetFormats**](docs/ApplicationPubSubRegistryApi.md#applicationpubsubregistrygetformats) | **GET** /as/pubsub-formats | 
*ApplicationPubSubRegistryApi* | [**applicationPubSubRegistryList**](docs/ApplicationPubSubRegistryApi.md#applicationpubsubregistrylist) | **GET** /as/pubsub/{application_ids.application_id} | 
*ApplicationPubSubRegistryApi* | [**applicationPubSubRegistrySet**](docs/ApplicationPubSubRegistryApi.md#applicationpubsubregistryset) | **PUT** /as/pubsub/{pubsub.ids.application_ids.application_id}/{pubsub.ids.pub_sub_id} | 
*ApplicationPubSubRegistryApi* | [**applicationPubSubRegistrySet2**](docs/ApplicationPubSubRegistryApi.md#applicationpubsubregistryset2) | **POST** /as/pubsub/{pubsub.ids.application_ids.application_id} | 
*ApplicationRegistryApi* | [**applicationRegistryCreate**](docs/ApplicationRegistryApi.md#applicationregistrycreate) | **POST** /users/{collaborator.user_ids.user_id}/applications | Create a new application. This also sets the given organization or user as first collaborator with all possible rights.
*ApplicationRegistryApi* | [**applicationRegistryCreate2**](docs/ApplicationRegistryApi.md#applicationregistrycreate2) | **POST** /organizations/{collaborator.organization_ids.organization_id}/applications | Create a new application. This also sets the given organization or user as first collaborator with all possible rights.
*ApplicationRegistryApi* | [**applicationRegistryDelete**](docs/ApplicationRegistryApi.md#applicationregistrydelete) | **DELETE** /applications/{application_id} | Delete the application. This may not release the application ID for reuse. All end devices must be deleted from the application before it can be deleted.
*ApplicationRegistryApi* | [**applicationRegistryGet**](docs/ApplicationRegistryApi.md#applicationregistryget) | **GET** /applications/{application_ids.application_id} | Get the application with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*ApplicationRegistryApi* | [**applicationRegistryIssueDevEUI**](docs/ApplicationRegistryApi.md#applicationregistryissuedeveui) | **POST** /applications/{application_id}/dev-eui | Request DevEUI from the configured address block for a device inside the application. The maximum number of DevEUI's issued per application can be configured.
*ApplicationRegistryApi* | [**applicationRegistryList**](docs/ApplicationRegistryApi.md#applicationregistrylist) | **GET** /applications | List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*ApplicationRegistryApi* | [**applicationRegistryList2**](docs/ApplicationRegistryApi.md#applicationregistrylist2) | **GET** /users/{collaborator.user_ids.user_id}/applications | List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*ApplicationRegistryApi* | [**applicationRegistryList3**](docs/ApplicationRegistryApi.md#applicationregistrylist3) | **GET** /organizations/{collaborator.organization_ids.organization_id}/applications | List applications where the given user or organization is a direct collaborator. If no user or organization is given, this returns the applications the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*ApplicationRegistryApi* | [**applicationRegistryPurge**](docs/ApplicationRegistryApi.md#applicationregistrypurge) | **DELETE** /applications/{application_id}/purge | Purge the application. This will release the application ID for reuse. All end devices must be deleted from the application before it can be deleted. The application owner is responsible for clearing data from any (external) integrations that may store and expose data by application ID
*ApplicationRegistryApi* | [**applicationRegistryRestore**](docs/ApplicationRegistryApi.md#applicationregistryrestore) | **POST** /applications/{application_id}/restore | Restore a recently deleted application.
*ApplicationRegistryApi* | [**applicationRegistryUpdate**](docs/ApplicationRegistryApi.md#applicationregistryupdate) | **PUT** /applications/{application.ids.application_id} | Update the application, changing the fields specified by the field mask to the provided values.
*ApplicationUpStorageApi* | [**applicationUpStorageGetStoredApplicationUp**](docs/ApplicationUpStorageApi.md#applicationupstoragegetstoredapplicationup) | **GET** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/packages/storage/{type} | Returns a stream of application messages that have been stored in the database.
*ApplicationUpStorageApi* | [**applicationUpStorageGetStoredApplicationUp2**](docs/ApplicationUpStorageApi.md#applicationupstoragegetstoredapplicationup2) | **GET** /as/applications/{application_ids.application_id}/packages/storage/{type} | Returns a stream of application messages that have been stored in the database.
*ApplicationUpStorageApi* | [**applicationUpStorageGetStoredApplicationUpCount**](docs/ApplicationUpStorageApi.md#applicationupstoragegetstoredapplicationupcount) | **GET** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}/packages/storage/{type}/count | Returns how many application messages have been stored in the database for an application or end device.
*ApplicationUpStorageApi* | [**applicationUpStorageGetStoredApplicationUpCount2**](docs/ApplicationUpStorageApi.md#applicationupstoragegetstoredapplicationupcount2) | **GET** /as/applications/{application_ids.application_id}/packages/storage/{type}/count | Returns how many application messages have been stored in the database for an application or end device.
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistryDelete**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistrydelete) | **DELETE** /as/webhooks/{application_ids.application_id}/{webhook_id} | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistryGet**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistryget) | **GET** /as/webhooks/{ids.application_ids.application_id}/{ids.webhook_id} | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistryGetFormats**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistrygetformats) | **GET** /as/webhook-formats | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistryGetTemplate**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistrygettemplate) | **GET** /as/webhook-templates/{ids.template_id} | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistryList**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistrylist) | **GET** /as/webhooks/{application_ids.application_id} | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistryListTemplates**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistrylisttemplates) | **GET** /as/webhook-templates | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistrySet**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistryset) | **PUT** /as/webhooks/{webhook.ids.application_ids.application_id}/{webhook.ids.webhook_id} | 
*ApplicationWebhookRegistryApi* | [**applicationWebhookRegistrySet2**](docs/ApplicationWebhookRegistryApi.md#applicationwebhookregistryset2) | **POST** /as/webhooks/{webhook.ids.application_ids.application_id} | 
*AsApi* | [**asDeleteLink**](docs/AsApi.md#asdeletelink) | **DELETE** /as/applications/{application_id}/link | Delete the link between the Application Server and Network Server for the specified application.
*AsApi* | [**asGetConfiguration**](docs/AsApi.md#asgetconfiguration) | **GET** /as/configuration | 
*AsApi* | [**asGetLink**](docs/AsApi.md#asgetlink) | **GET** /as/applications/{application_ids.application_id}/link | Get a link configuration from the Application Server to Network Server. This only contains the configuration. Use GetLinkStats to view statistics and any link errors.
*AsApi* | [**asGetLinkStats**](docs/AsApi.md#asgetlinkstats) | **GET** /as/applications/{application_id}/link/stats | GetLinkStats returns the link statistics. This call returns a NotFound error code if there is no link for the given application identifiers. This call returns the error code of the link error if linking to a Network Server failed.
*AsApi* | [**asSetLink**](docs/AsApi.md#assetlink) | **PUT** /as/applications/{application_ids.application_id}/link | Set a link configuration from the Application Server a Network Server. This call returns immediately after setting the link configuration; it does not wait for a link to establish. To get link statistics or errors, use GetLinkStats. Note that there can only be one Application Server instance linked to a Network Server for a given application at a time.
*AsEndDeviceRegistryApi* | [**asEndDeviceRegistryDelete**](docs/AsEndDeviceRegistryApi.md#asenddeviceregistrydelete) | **DELETE** /as/applications/{application_ids.application_id}/devices/{device_id} | Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.
*AsEndDeviceRegistryApi* | [**asEndDeviceRegistryGet**](docs/AsEndDeviceRegistryApi.md#asenddeviceregistryget) | **GET** /as/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.
*AsEndDeviceRegistryApi* | [**asEndDeviceRegistrySet**](docs/AsEndDeviceRegistryApi.md#asenddeviceregistryset) | **PUT** /as/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Set creates or updates the device.
*AsEndDeviceRegistryApi* | [**asEndDeviceRegistrySet2**](docs/AsEndDeviceRegistryApi.md#asenddeviceregistryset2) | **POST** /as/applications/{end_device.ids.application_ids.application_id}/devices | Set creates or updates the device.
*ClientAccessApi* | [**clientAccessGetCollaborator**](docs/ClientAccessApi.md#clientaccessgetcollaborator) | **GET** /clients/{client_ids.client_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the client. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*ClientAccessApi* | [**clientAccessGetCollaborator2**](docs/ClientAccessApi.md#clientaccessgetcollaborator2) | **GET** /clients/{client_ids.client_id}/collaborator/organization/{collaborator.organization_ids.organization_id} | Get the rights of a collaborator (member) of the client. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*ClientAccessApi* | [**clientAccessListCollaborators**](docs/ClientAccessApi.md#clientaccesslistcollaborators) | **GET** /clients/{client_ids.client_id}/collaborators | List the collaborators on this OAuth client.
*ClientAccessApi* | [**clientAccessListRights**](docs/ClientAccessApi.md#clientaccesslistrights) | **GET** /clients/{client_id}/rights | List the rights the caller has on this application.
*ClientAccessApi* | [**clientAccessSetCollaborator**](docs/ClientAccessApi.md#clientaccesssetcollaborator) | **PUT** /clients/{client_ids.client_id}/collaborators | Set the rights of a collaborator (member) on the OAuth client. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
*ClientRegistryApi* | [**clientRegistryCreate**](docs/ClientRegistryApi.md#clientregistrycreate) | **POST** /users/{collaborator.user_ids.user_id}/clients | Create a new OAuth client. This also sets the given organization or user as first collaborator with all possible rights.
*ClientRegistryApi* | [**clientRegistryCreate2**](docs/ClientRegistryApi.md#clientregistrycreate2) | **POST** /organizations/{collaborator.organization_ids.organization_id}/clients | Create a new OAuth client. This also sets the given organization or user as first collaborator with all possible rights.
*ClientRegistryApi* | [**clientRegistryDelete**](docs/ClientRegistryApi.md#clientregistrydelete) | **DELETE** /clients/{client_id} | Delete the OAuth client. This may not release the client ID for reuse.
*ClientRegistryApi* | [**clientRegistryGet**](docs/ClientRegistryApi.md#clientregistryget) | **GET** /clients/{client_ids.client_id} | Get the OAuth client with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*ClientRegistryApi* | [**clientRegistryList**](docs/ClientRegistryApi.md#clientregistrylist) | **GET** /clients | List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*ClientRegistryApi* | [**clientRegistryList2**](docs/ClientRegistryApi.md#clientregistrylist2) | **GET** /users/{collaborator.user_ids.user_id}/clients | List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*ClientRegistryApi* | [**clientRegistryList3**](docs/ClientRegistryApi.md#clientregistrylist3) | **GET** /organizations/{collaborator.organization_ids.organization_id}/clients | List OAuth clients where the given user or organization is a direct collaborator. If no user or organization is given, this returns the OAuth clients the caller has access to. Similar to Get, this selects the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*ClientRegistryApi* | [**clientRegistryPurge**](docs/ClientRegistryApi.md#clientregistrypurge) | **DELETE** /clients/{client_id}/purge | Purge the client. This will release the client ID for reuse.
*ClientRegistryApi* | [**clientRegistryRestore**](docs/ClientRegistryApi.md#clientregistryrestore) | **POST** /clients/{client_id}/restore | Restore a recently deleted client.
*ClientRegistryApi* | [**clientRegistryUpdate**](docs/ClientRegistryApi.md#clientregistryupdate) | **PUT** /clients/{client.ids.client_id} | Update the OAuth client, changing the fields specified by the field mask to the provided values.
*ConfigurationApi* | [**configurationGetPhyVersions**](docs/ConfigurationApi.md#configurationgetphyversions) | **GET** /configuration/phy-versions | Returns a list of supported LoRaWAN PHY Versions for the given Band ID.
*ConfigurationApi* | [**configurationListFrequencyPlans**](docs/ConfigurationApi.md#configurationlistfrequencyplans) | **GET** /configuration/frequency-plans | 
*ContactInfoRegistryApi* | [**contactInfoRegistryRequestValidation**](docs/ContactInfoRegistryApi.md#contactinforegistryrequestvalidation) | **POST** /contact_info/validation | Request validation for the non-validated contact info for the given entity.
*ContactInfoRegistryApi* | [**contactInfoRegistryValidate**](docs/ContactInfoRegistryApi.md#contactinforegistryvalidate) | **PATCH** /contact_info/validation | Validate confirms a contact info validation.
*DeviceRepositoryApi* | [**deviceRepositoryGetBrand**](docs/DeviceRepositoryApi.md#devicerepositorygetbrand) | **GET** /dr/applications/{application_ids.application_id}/brands/{brand_id} | 
*DeviceRepositoryApi* | [**deviceRepositoryGetDownlinkDecoder**](docs/DeviceRepositoryApi.md#devicerepositorygetdownlinkdecoder) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/formatters/downlink/decoder | 
*DeviceRepositoryApi* | [**deviceRepositoryGetDownlinkEncoder**](docs/DeviceRepositoryApi.md#devicerepositorygetdownlinkencoder) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/formatters/downlink/encoder | 
*DeviceRepositoryApi* | [**deviceRepositoryGetModel**](docs/DeviceRepositoryApi.md#devicerepositorygetmodel) | **GET** /dr/applications/{application_ids.application_id}/brands/{brand_id}/models/{model_id} | 
*DeviceRepositoryApi* | [**deviceRepositoryGetTemplate**](docs/DeviceRepositoryApi.md#devicerepositorygettemplate) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/template | 
*DeviceRepositoryApi* | [**deviceRepositoryGetUplinkDecoder**](docs/DeviceRepositoryApi.md#devicerepositorygetuplinkdecoder) | **GET** /dr/applications/{application_ids.application_id}/brands/{version_ids.brand_id}/models/{version_ids.model_id}/{version_ids.firmware_version}/{version_ids.band_id}/formatters/uplink/decoder | 
*DeviceRepositoryApi* | [**deviceRepositoryListBrands**](docs/DeviceRepositoryApi.md#devicerepositorylistbrands) | **GET** /dr/applications/{application_ids.application_id}/brands | 
*DeviceRepositoryApi* | [**deviceRepositoryListModels**](docs/DeviceRepositoryApi.md#devicerepositorylistmodels) | **GET** /dr/applications/{application_ids.application_id}/brands/{brand_id}/models | 
*DeviceRepositoryApi* | [**deviceRepositoryListModels2**](docs/DeviceRepositoryApi.md#devicerepositorylistmodels2) | **GET** /dr/applications/{application_ids.application_id}/models | 
*EndDeviceClaimingServerApi* | [**endDeviceClaimingServerAuthorizeApplication**](docs/EndDeviceClaimingServerApi.md#enddeviceclaimingserverauthorizeapplication) | **POST** /edcs/applications/{application_ids.application_id}/authorize | Authorize the End Device Claiming Server to claim devices registered in the given application. The application identifiers are the source application, where the devices are registered before they are claimed. The API key is used to access the application, find the device, verify the claim request and delete the end device from the source application.
*EndDeviceClaimingServerApi* | [**endDeviceClaimingServerClaim**](docs/EndDeviceClaimingServerApi.md#enddeviceclaimingserverclaim) | **POST** /edcs/claim | Claims the end device by claim authentication code or QR code and transfers the device to the target application.
*EndDeviceClaimingServerApi* | [**endDeviceClaimingServerUnauthorizeApplication**](docs/EndDeviceClaimingServerApi.md#enddeviceclaimingserverunauthorizeapplication) | **DELETE** /edcs/applications/{application_id}/authorize | Unauthorize the End Device Claiming Server to claim devices in the given application. This reverts the authorization given with rpc AuthorizeApplication.
*EndDeviceQRCodeGeneratorApi* | [**endDeviceQRCodeGeneratorGenerate**](docs/EndDeviceQRCodeGeneratorApi.md#enddeviceqrcodegeneratorgenerate) | **POST** /qr-codes/end-devices | Generates a QR code.
*EndDeviceQRCodeGeneratorApi* | [**endDeviceQRCodeGeneratorGetFormat**](docs/EndDeviceQRCodeGeneratorApi.md#enddeviceqrcodegeneratorgetformat) | **GET** /qr-codes/end-devices/formats/{format_id} | Return the QR code format.
*EndDeviceQRCodeGeneratorApi* | [**endDeviceQRCodeGeneratorListFormats**](docs/EndDeviceQRCodeGeneratorApi.md#enddeviceqrcodegeneratorlistformats) | **GET** /qr-codes/end-devices/formats | Returns the supported formats.
*EndDeviceRegistryApi* | [**endDeviceRegistryCreate**](docs/EndDeviceRegistryApi.md#enddeviceregistrycreate) | **POST** /applications/{end_device.ids.application_ids.application_id}/devices | Create a new end device within an application.
*EndDeviceRegistryApi* | [**endDeviceRegistryDelete**](docs/EndDeviceRegistryApi.md#enddeviceregistrydelete) | **DELETE** /applications/{application_ids.application_id}/devices/{device_id} | Delete the end device with the given IDs.
*EndDeviceRegistryApi* | [**endDeviceRegistryGet**](docs/EndDeviceRegistryApi.md#enddeviceregistryget) | **GET** /applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get the end device with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*EndDeviceRegistryApi* | [**endDeviceRegistryList**](docs/EndDeviceRegistryApi.md#enddeviceregistrylist) | **GET** /applications/{application_ids.application_id}/devices | List end devices in the given application. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*EndDeviceRegistryApi* | [**endDeviceRegistryUpdate**](docs/EndDeviceRegistryApi.md#enddeviceregistryupdate) | **PUT** /applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Update the end device, changing the fields specified by the field mask to the provided values.
*EndDeviceRegistrySearchApi* | [**endDeviceRegistrySearchSearchEndDevices**](docs/EndDeviceRegistrySearchApi.md#enddeviceregistrysearchsearchenddevices) | **GET** /search/applications/{application_ids.application_id}/devices | Search for end devices in the given application that match the conditions specified in the request.
*EndDeviceTemplateConverterApi* | [**endDeviceTemplateConverterConvert**](docs/EndDeviceTemplateConverterApi.md#enddevicetemplateconverterconvert) | **POST** /edtc/convert | Converts the binary data to a stream of end device templates.
*EndDeviceTemplateConverterApi* | [**endDeviceTemplateConverterListFormats**](docs/EndDeviceTemplateConverterApi.md#enddevicetemplateconverterlistformats) | **GET** /edtc/formats | Returns the configured formats to convert from.
*EntityAccessApi* | [**entityAccessAuthInfo**](docs/EntityAccessApi.md#entityaccessauthinfo) | **GET** /auth_info | AuthInfo returns information about the authentication that is used on the request.
*EntityRegistrySearchApi* | [**entityRegistrySearchSearchApplications**](docs/EntityRegistrySearchApi.md#entityregistrysearchsearchapplications) | **GET** /search/applications | Search for applications that match the conditions specified in the request. Non-admin users will only match applications that they have rights on.
*EntityRegistrySearchApi* | [**entityRegistrySearchSearchClients**](docs/EntityRegistrySearchApi.md#entityregistrysearchsearchclients) | **GET** /search/clients | Search for OAuth clients that match the conditions specified in the request. Non-admin users will only match OAuth clients that they have rights on.
*EntityRegistrySearchApi* | [**entityRegistrySearchSearchGateways**](docs/EntityRegistrySearchApi.md#entityregistrysearchsearchgateways) | **GET** /search/gateways | Search for gateways that match the conditions specified in the request. Non-admin users will only match gateways that they have rights on.
*EntityRegistrySearchApi* | [**entityRegistrySearchSearchOrganizations**](docs/EntityRegistrySearchApi.md#entityregistrysearchsearchorganizations) | **GET** /search/organizations | Search for organizations that match the conditions specified in the request. Non-admin users will only match organizations that they have rights on.
*EntityRegistrySearchApi* | [**entityRegistrySearchSearchUsers**](docs/EntityRegistrySearchApi.md#entityregistrysearchsearchusers) | **GET** /search/users | Search for users that match the conditions specified in the request. This is only available to admin users.
*EventsApi* | [**eventsFindRelated**](docs/EventsApi.md#eventsfindrelated) | **GET** /events/related | 
*EventsApi* | [**eventsStream**](docs/EventsApi.md#eventsstream) | **POST** /events | Stream live events, optionally with a tail of historical events (depending on server support and retention policy). Events may arrive out-of-order.
*GatewayAccessApi* | [**gatewayAccessCreateAPIKey**](docs/GatewayAccessApi.md#gatewayaccesscreateapikey) | **POST** /gateways/{gateway_ids.gateway_id}/api-keys | Create an API key scoped to this gateway.
*GatewayAccessApi* | [**gatewayAccessGetAPIKey**](docs/GatewayAccessApi.md#gatewayaccessgetapikey) | **GET** /gateways/{gateway_ids.gateway_id}/api-keys/{key_id} | Get a single API key of this gateway.
*GatewayAccessApi* | [**gatewayAccessGetCollaborator**](docs/GatewayAccessApi.md#gatewayaccessgetcollaborator) | **GET** /gateways/{gateway_ids.gateway_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the gateway. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*GatewayAccessApi* | [**gatewayAccessGetCollaborator2**](docs/GatewayAccessApi.md#gatewayaccessgetcollaborator2) | **GET** /gateways/{gateway_ids.gateway_id}/collaborator/organization/{collaborator.organization_ids.organization_id} | Get the rights of a collaborator (member) of the gateway. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*GatewayAccessApi* | [**gatewayAccessListAPIKeys**](docs/GatewayAccessApi.md#gatewayaccesslistapikeys) | **GET** /gateways/{gateway_ids.gateway_id}/api-keys | List the API keys for this gateway.
*GatewayAccessApi* | [**gatewayAccessListCollaborators**](docs/GatewayAccessApi.md#gatewayaccesslistcollaborators) | **GET** /gateways/{gateway_ids.gateway_id}/collaborators | List the collaborators on this gateway.
*GatewayAccessApi* | [**gatewayAccessListRights**](docs/GatewayAccessApi.md#gatewayaccesslistrights) | **GET** /gateways/{gateway_id}/rights | List the rights the caller has on this gateway.
*GatewayAccessApi* | [**gatewayAccessSetCollaborator**](docs/GatewayAccessApi.md#gatewayaccesssetcollaborator) | **PUT** /gateways/{gateway_ids.gateway_id}/collaborators | Set the rights of a collaborator (member) on the gateway. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
*GatewayAccessApi* | [**gatewayAccessUpdateAPIKey**](docs/GatewayAccessApi.md#gatewayaccessupdateapikey) | **PUT** /gateways/{gateway_ids.gateway_id}/api-keys/{api_key.id} | Update the rights of an API key of the gateway. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.
*GatewayClaimingServerApi* | [**gatewayClaimingServerAuthorizeGateway**](docs/GatewayClaimingServerApi.md#gatewayclaimingserverauthorizegateway) | **POST** /gcls/gateways/{gateway_ids.gateway_id}/authorize | AuthorizeGateway allows a gateway to be claimed.
*GatewayClaimingServerApi* | [**gatewayClaimingServerClaim**](docs/GatewayClaimingServerApi.md#gatewayclaimingserverclaim) | **POST** /gcls/claim | Claims a gateway by claim authentication code or QR code and transfers the gateway to the target user.
*GatewayClaimingServerApi* | [**gatewayClaimingServerUnauthorizeGateway**](docs/GatewayClaimingServerApi.md#gatewayclaimingserverunauthorizegateway) | **DELETE** /gcls/gateways/{gateway_id}/authorize | UnauthorizeGateway prevents a gateway from being claimed.
*GatewayRegistryApi* | [**gatewayRegistryCreate**](docs/GatewayRegistryApi.md#gatewayregistrycreate) | **POST** /users/{collaborator.user_ids.user_id}/gateways | Create a new gateway. This also sets the given organization or user as first collaborator with all possible rights.
*GatewayRegistryApi* | [**gatewayRegistryCreate2**](docs/GatewayRegistryApi.md#gatewayregistrycreate2) | **POST** /organizations/{collaborator.organization_ids.organization_id}/gateways | Create a new gateway. This also sets the given organization or user as first collaborator with all possible rights.
*GatewayRegistryApi* | [**gatewayRegistryDelete**](docs/GatewayRegistryApi.md#gatewayregistrydelete) | **DELETE** /gateways/{gateway_id} | Delete the gateway. This may not release the gateway ID for reuse, but it does release the EUI.
*GatewayRegistryApi* | [**gatewayRegistryGet**](docs/GatewayRegistryApi.md#gatewayregistryget) | **GET** /gateways/{gateway_ids.gateway_id} | Get the gateway with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*GatewayRegistryApi* | [**gatewayRegistryList**](docs/GatewayRegistryApi.md#gatewayregistrylist) | **GET** /gateways | List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*GatewayRegistryApi* | [**gatewayRegistryList2**](docs/GatewayRegistryApi.md#gatewayregistrylist2) | **GET** /users/{collaborator.user_ids.user_id}/gateways | List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*GatewayRegistryApi* | [**gatewayRegistryList3**](docs/GatewayRegistryApi.md#gatewayregistrylist3) | **GET** /organizations/{collaborator.organization_ids.organization_id}/gateways | List gateways where the given user or organization is a direct collaborator. If no user or organization is given, this returns the gateways the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*GatewayRegistryApi* | [**gatewayRegistryPurge**](docs/GatewayRegistryApi.md#gatewayregistrypurge) | **DELETE** /gateways/{gateway_id}/purge | Purge the gateway. This will release both gateway ID and EUI for reuse. The gateway owner is responsible for clearing data from any (external) integrations that may store and expose data by gateway ID.
*GatewayRegistryApi* | [**gatewayRegistryRestore**](docs/GatewayRegistryApi.md#gatewayregistryrestore) | **POST** /gateways/{gateway_id}/restore | Restore a recently deleted gateway. This does not restore the EUI, as that was released when deleting the gateway.
*GatewayRegistryApi* | [**gatewayRegistryUpdate**](docs/GatewayRegistryApi.md#gatewayregistryupdate) | **PUT** /gateways/{gateway.ids.gateway_id} | Update the gateway, changing the fields specified by the field mask to the provided values.
*GsApi* | [**gsGetGatewayConnectionStats**](docs/GsApi.md#gsgetgatewayconnectionstats) | **GET** /gs/gateways/{gateway_id}/connection/stats | Get statistics about the current gateway connection to the Gateway Server. This is not persisted between reconnects.
*GtwGsApi* | [**gtwGsGetMQTTConnectionInfo**](docs/GtwGsApi.md#gtwgsgetmqttconnectioninfo) | **GET** /gs/gateways/{gateway_id}/mqtt-connection-info | Get connection information to connect an MQTT gateway.
*GtwGsApi* | [**gtwGsGetMQTTV2ConnectionInfo**](docs/GtwGsApi.md#gtwgsgetmqttv2connectioninfo) | **GET** /gs/gateways/{gateway_id}/mqttv2-connection-info | Get legacy connection information to connect a The Things Network Stack V2 MQTT gateway.
*IsApi* | [**isGetConfiguration**](docs/IsApi.md#isgetconfiguration) | **GET** /is/configuration | Get the configuration of the Identity Server. The response is typically used to enable or disable features in a user interface.
*JsApi* | [**jsGetJoinEUIPrefixes**](docs/JsApi.md#jsgetjoineuiprefixes) | **GET** /js/join_eui_prefixes | Request the JoinEUI prefixes that are configured for this Join Server.
*JsEndDeviceRegistryApi* | [**jsEndDeviceRegistryDelete**](docs/JsEndDeviceRegistryApi.md#jsenddeviceregistrydelete) | **DELETE** /js/applications/{application_ids.application_id}/devices/{device_id} | Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.
*JsEndDeviceRegistryApi* | [**jsEndDeviceRegistryGet**](docs/JsEndDeviceRegistryApi.md#jsenddeviceregistryget) | **GET** /js/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.
*JsEndDeviceRegistryApi* | [**jsEndDeviceRegistryProvision**](docs/JsEndDeviceRegistryApi.md#jsenddeviceregistryprovision) | **PUT** /js/applications/{application_ids.application_id}/provision-devices | This rpc is deprecated; use EndDeviceTemplateConverter service instead. TODO: Remove (https://github.com/TheThingsNetwork/lorawan-stack/issues/999)
*JsEndDeviceRegistryApi* | [**jsEndDeviceRegistrySet**](docs/JsEndDeviceRegistryApi.md#jsenddeviceregistryset) | **PUT** /js/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Set creates or updates the device.
*JsEndDeviceRegistryApi* | [**jsEndDeviceRegistrySet2**](docs/JsEndDeviceRegistryApi.md#jsenddeviceregistryset2) | **POST** /js/applications/{end_device.ids.application_ids.application_id}/devices | Set creates or updates the device.
*NsApi* | [**nsGenerateDevAddr**](docs/NsApi.md#nsgeneratedevaddr) | **GET** /ns/dev_addr | GenerateDevAddr requests a device address assignment from the Network Server.
*NsApi* | [**nsGetDefaultMACSettings**](docs/NsApi.md#nsgetdefaultmacsettings) | **GET** /ns/default_mac_settings/{frequency_plan_id}/{lorawan_phy_version} | GetDefaultMACSettings retrieves the default MAC settings for a frequency plan.
*NsEndDeviceRegistryApi* | [**nsEndDeviceRegistryDelete**](docs/NsEndDeviceRegistryApi.md#nsenddeviceregistrydelete) | **DELETE** /ns/applications/{application_ids.application_id}/devices/{device_id} | Delete deletes the device that matches the given identifiers. If there are multiple matches, an error will be returned.
*NsEndDeviceRegistryApi* | [**nsEndDeviceRegistryGet**](docs/NsEndDeviceRegistryApi.md#nsenddeviceregistryget) | **GET** /ns/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | Get returns the device that matches the given identifiers. If there are multiple matches, an error will be returned.
*NsEndDeviceRegistryApi* | [**nsEndDeviceRegistryResetFactoryDefaults**](docs/NsEndDeviceRegistryApi.md#nsenddeviceregistryresetfactorydefaults) | **PATCH** /ns/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id} | ResetFactoryDefaults resets device state to factory defaults.
*NsEndDeviceRegistryApi* | [**nsEndDeviceRegistrySet**](docs/NsEndDeviceRegistryApi.md#nsenddeviceregistryset) | **PUT** /ns/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id} | Set creates or updates the device.
*NsEndDeviceRegistryApi* | [**nsEndDeviceRegistrySet2**](docs/NsEndDeviceRegistryApi.md#nsenddeviceregistryset2) | **POST** /ns/applications/{end_device.ids.application_ids.application_id}/devices | Set creates or updates the device.
*OAuthAuthorizationRegistryApi* | [**oAuthAuthorizationRegistryDelete**](docs/OAuthAuthorizationRegistryApi.md#oauthauthorizationregistrydelete) | **DELETE** /users/{user_ids.user_id}/authorizations/{client_ids.client_id} | Delete (de-authorize) an OAuth client for the user.
*OAuthAuthorizationRegistryApi* | [**oAuthAuthorizationRegistryDeleteToken**](docs/OAuthAuthorizationRegistryApi.md#oauthauthorizationregistrydeletetoken) | **DELETE** /users/{user_ids.user_id}/authorizations/{client_ids.client_id}/tokens/{id} | Delete (invalidate) an OAuth access token.
*OAuthAuthorizationRegistryApi* | [**oAuthAuthorizationRegistryList**](docs/OAuthAuthorizationRegistryApi.md#oauthauthorizationregistrylist) | **GET** /users/{user_ids.user_id}/authorizations | List OAuth clients that are authorized by the user.
*OAuthAuthorizationRegistryApi* | [**oAuthAuthorizationRegistryListTokens**](docs/OAuthAuthorizationRegistryApi.md#oauthauthorizationregistrylisttokens) | **GET** /users/{user_ids.user_id}/authorizations/{client_ids.client_id}/tokens | List OAuth access tokens issued to the OAuth client on behalf of the user.
*OrganizationAccessApi* | [**organizationAccessCreateAPIKey**](docs/OrganizationAccessApi.md#organizationaccesscreateapikey) | **POST** /organizations/{organization_ids.organization_id}/api-keys | Create an API key scoped to this organization. Organization API keys can give access to the organization itself, as well as any application, gateway and OAuth client this organization is a collaborator of.
*OrganizationAccessApi* | [**organizationAccessGetAPIKey**](docs/OrganizationAccessApi.md#organizationaccessgetapikey) | **GET** /organizations/{organization_ids.organization_id}/api-keys/{key_id} | Get a single API key of this organization.
*OrganizationAccessApi* | [**organizationAccessGetCollaborator**](docs/OrganizationAccessApi.md#organizationaccessgetcollaborator) | **GET** /organizations/{organization_ids.organization_id}/collaborator/user/{collaborator.user_ids.user_id} | Get the rights of a collaborator (member) of the organization. Pseudo-rights in the response (such as the \"_ALL\" right) are not expanded.
*OrganizationAccessApi* | [**organizationAccessListAPIKeys**](docs/OrganizationAccessApi.md#organizationaccesslistapikeys) | **GET** /organizations/{organization_ids.organization_id}/api-keys | List the API keys for this organization.
*OrganizationAccessApi* | [**organizationAccessListCollaborators**](docs/OrganizationAccessApi.md#organizationaccesslistcollaborators) | **GET** /organizations/{organization_ids.organization_id}/collaborators | List the collaborators on this organization.
*OrganizationAccessApi* | [**organizationAccessListRights**](docs/OrganizationAccessApi.md#organizationaccesslistrights) | **GET** /organizations/{organization_id}/rights | List the rights the caller has on this organization.
*OrganizationAccessApi* | [**organizationAccessSetCollaborator**](docs/OrganizationAccessApi.md#organizationaccesssetcollaborator) | **PUT** /organizations/{organization_ids.organization_id}/collaborators | Set the rights of a collaborator (member) on the organization. Organization collaborators can get access to the organization itself, as well as any application, gateway and OAuth client this organization is a collaborator of. This method can also be used to delete the collaborator, by giving them no rights. The caller is required to have all assigned or/and removed rights.
*OrganizationAccessApi* | [**organizationAccessUpdateAPIKey**](docs/OrganizationAccessApi.md#organizationaccessupdateapikey) | **PUT** /organizations/{organization_ids.organization_id}/api-keys/{api_key.id} | Update the rights of an API key of the organization. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.
*OrganizationRegistryApi* | [**organizationRegistryCreate**](docs/OrganizationRegistryApi.md#organizationregistrycreate) | **POST** /users/{collaborator.user_ids.user_id}/organizations | Create a new organization. This also sets the given user as first collaborator with all possible rights.
*OrganizationRegistryApi* | [**organizationRegistryDelete**](docs/OrganizationRegistryApi.md#organizationregistrydelete) | **DELETE** /organizations/{organization_id} | Delete the organization. This may not release the organization ID for reuse.
*OrganizationRegistryApi* | [**organizationRegistryGet**](docs/OrganizationRegistryApi.md#organizationregistryget) | **GET** /organizations/{organization_ids.organization_id} | Get the organization with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
*OrganizationRegistryApi* | [**organizationRegistryList**](docs/OrganizationRegistryApi.md#organizationregistrylist) | **GET** /organizations | List organizations where the given user or organization is a direct collaborator. If no user or organization is given, this returns the organizations the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*OrganizationRegistryApi* | [**organizationRegistryList2**](docs/OrganizationRegistryApi.md#organizationregistrylist2) | **GET** /users/{collaborator.user_ids.user_id}/organizations | List organizations where the given user or organization is a direct collaborator. If no user or organization is given, this returns the organizations the caller has access to. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
*OrganizationRegistryApi* | [**organizationRegistryPurge**](docs/OrganizationRegistryApi.md#organizationregistrypurge) | **DELETE** /organizations/{organization_id}/purge | Purge the organization. This will release the organization ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.
*OrganizationRegistryApi* | [**organizationRegistryRestore**](docs/OrganizationRegistryApi.md#organizationregistryrestore) | **POST** /organizations/{organization_id}/restore | Restore a recently deleted organization.
*OrganizationRegistryApi* | [**organizationRegistryUpdate**](docs/OrganizationRegistryApi.md#organizationregistryupdate) | **PUT** /organizations/{organization.ids.organization_id} | Update the organization, changing the fields specified by the field mask to the provided values.
*PbaApi* | [**pbaDeleteHomeNetworkDefaultGatewayVisibility**](docs/PbaApi.md#pbadeletehomenetworkdefaultgatewayvisibility) | **DELETE** /pba/home-networks/gateway-visibilities/default | Deletes the default gateway visibility. Deleting gateway visibilities requires administrative access.
*PbaApi* | [**pbaDeleteHomeNetworkDefaultRoutingPolicy**](docs/PbaApi.md#pbadeletehomenetworkdefaultroutingpolicy) | **DELETE** /pba/home-networks/policies/default | Deletes the default routing policy. Deleting routing policies requires administrative access.
*PbaApi* | [**pbaDeleteHomeNetworkRoutingPolicy**](docs/PbaApi.md#pbadeletehomenetworkroutingpolicy) | **DELETE** /pba/home-networks/policies/{net_id} | Delete the routing policy for the given Home Network. Deleting routing policies requires administrative access.
*PbaApi* | [**pbaDeleteHomeNetworkRoutingPolicy2**](docs/PbaApi.md#pbadeletehomenetworkroutingpolicy2) | **DELETE** /pba/home-networks/policies/{net_id}/{tenant_id} | Delete the routing policy for the given Home Network. Deleting routing policies requires administrative access.
*PbaApi* | [**pbaDeregister**](docs/PbaApi.md#pbaderegister) | **DELETE** /pba/registration | Deregister from Packet Broker. Packet Broker deregistration requires administrative access. Packet Broker deregistration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.
*PbaApi* | [**pbaGetHomeNetworkDefaultGatewayVisibility**](docs/PbaApi.md#pbagethomenetworkdefaultgatewayvisibility) | **GET** /pba/home-networks/gateway-visibilities/default | Get the default gateway visibility. Getting gateway visibilities requires administrative access.
*PbaApi* | [**pbaGetHomeNetworkDefaultRoutingPolicy**](docs/PbaApi.md#pbagethomenetworkdefaultroutingpolicy) | **GET** /pba/home-networks/policies/default | Get the default routing policy. Getting routing policies requires administrative access.
*PbaApi* | [**pbaGetHomeNetworkRoutingPolicy**](docs/PbaApi.md#pbagethomenetworkroutingpolicy) | **GET** /pba/home-networks/policies/{net_id} | Get the routing policy for the given Home Network. Getting routing policies requires administrative access.
*PbaApi* | [**pbaGetHomeNetworkRoutingPolicy2**](docs/PbaApi.md#pbagethomenetworkroutingpolicy2) | **GET** /pba/home-networks/policies/{net_id}/{tenant_id} | Get the routing policy for the given Home Network. Getting routing policies requires administrative access.
*PbaApi* | [**pbaGetInfo**](docs/PbaApi.md#pbagetinfo) | **GET** /pba/info | Get information about the Packet Broker registration. Viewing Packet Packet information requires administrative access.
*PbaApi* | [**pbaListForwarderRoutingPolicies**](docs/PbaApi.md#pbalistforwarderroutingpolicies) | **GET** /pba/forwarders/policies | List the routing policies that Forwarders configured with Packet Broker Agent as Home Network. Listing routing policies requires administrative access.
*PbaApi* | [**pbaListHomeNetworkRoutingPolicies**](docs/PbaApi.md#pbalisthomenetworkroutingpolicies) | **GET** /pba/home-networks/policies | List the routing policies that Packet Broker Agent as Forwarder configured with Home Networks. Listing routing policies requires administrative access.
*PbaApi* | [**pbaListHomeNetworks**](docs/PbaApi.md#pbalisthomenetworks) | **GET** /pba/home-networks | List the listed home networks for which routing policies can be configured. Listing home networks requires administrative access.
*PbaApi* | [**pbaListNetworks**](docs/PbaApi.md#pbalistnetworks) | **GET** /pba/networks | List all listed networks. Listing networks requires administrative access.
*PbaApi* | [**pbaRegister**](docs/PbaApi.md#pbaregister) | **PUT** /pba/registration | Register with Packet Broker. If no registration exists, it will be created. Any existing registration will be updated. Registration settings not in the request message are taken from Packet Broker Agent configuration and caller context. Packet Broker registration requires administrative access. Packet Broker registration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.
*PbaApi* | [**pbaRegister2**](docs/PbaApi.md#pbaregister2) | **POST** /pba/registration | Register with Packet Broker. If no registration exists, it will be created. Any existing registration will be updated. Registration settings not in the request message are taken from Packet Broker Agent configuration and caller context. Packet Broker registration requires administrative access. Packet Broker registration is only supported for tenants and requires Packet Broker Agent to be configured with NetID level authentication. Use rpc GetInfo and check register_enabled to check whether this rpc is enabled.
*PbaApi* | [**pbaSetHomeNetworkDefaultGatewayVisibility**](docs/PbaApi.md#pbasethomenetworkdefaultgatewayvisibility) | **PUT** /pba/home-networks/gateway-visibilities/default | Set the default gateway visibility. Setting gateway visibilities requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkDefaultGatewayVisibility2**](docs/PbaApi.md#pbasethomenetworkdefaultgatewayvisibility2) | **POST** /pba/home-networks/gateway-visibilities/default | Set the default gateway visibility. Setting gateway visibilities requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkDefaultRoutingPolicy**](docs/PbaApi.md#pbasethomenetworkdefaultroutingpolicy) | **PUT** /pba/home-networks/policies/default | Set the default routing policy. Setting routing policies requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkDefaultRoutingPolicy2**](docs/PbaApi.md#pbasethomenetworkdefaultroutingpolicy2) | **POST** /pba/home-networks/policies/default | Set the default routing policy. Setting routing policies requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkRoutingPolicy**](docs/PbaApi.md#pbasethomenetworkroutingpolicy) | **PUT** /pba/home-networks/policies/{home_network_id.net_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkRoutingPolicy2**](docs/PbaApi.md#pbasethomenetworkroutingpolicy2) | **POST** /pba/home-networks/policies/{home_network_id.net_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkRoutingPolicy3**](docs/PbaApi.md#pbasethomenetworkroutingpolicy3) | **PUT** /pba/home-networks/policies/{home_network_id.net_id}/{home_network_id.tenant_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
*PbaApi* | [**pbaSetHomeNetworkRoutingPolicy4**](docs/PbaApi.md#pbasethomenetworkroutingpolicy4) | **POST** /pba/home-networks/policies/{home_network_id.net_id}/{home_network_id.tenant_id} | Set the routing policy for the given Home Network. Setting routing policies requires administrative access.
*UserAccessApi* | [**userAccessCreateAPIKey**](docs/UserAccessApi.md#useraccesscreateapikey) | **POST** /users/{user_ids.user_id}/api-keys | Create an API key scoped to this user. User API keys can give access to the user itself, as well as any organization, application, gateway and OAuth client this user is a collaborator of.
*UserAccessApi* | [**userAccessCreateLoginToken**](docs/UserAccessApi.md#useraccesscreatelogintoken) | **POST** /users/{user_ids.user_id}/login-tokens | Create a login token that can be used for a one-time login as a user.
*UserAccessApi* | [**userAccessGetAPIKey**](docs/UserAccessApi.md#useraccessgetapikey) | **GET** /users/{user_ids.user_id}/api-keys/{key_id} | Get a single API key of this user.
*UserAccessApi* | [**userAccessListAPIKeys**](docs/UserAccessApi.md#useraccesslistapikeys) | **GET** /users/{user_ids.user_id}/api-keys | List the API keys for this user.
*UserAccessApi* | [**userAccessListRights**](docs/UserAccessApi.md#useraccesslistrights) | **GET** /users/{user_id}/rights | List the rights the caller has on this user.
*UserAccessApi* | [**userAccessUpdateAPIKey**](docs/UserAccessApi.md#useraccessupdateapikey) | **PUT** /users/{user_ids.user_id}/api-keys/{api_key.id} | Update the rights of an API key of the user. This method can also be used to delete the API key, by giving it no rights. The caller is required to have all assigned or/and removed rights.
*UserInvitationRegistryApi* | [**userInvitationRegistryDelete**](docs/UserInvitationRegistryApi.md#userinvitationregistrydelete) | **DELETE** /invitations | Delete (revoke) a user invitation.
*UserInvitationRegistryApi* | [**userInvitationRegistryList**](docs/UserInvitationRegistryApi.md#userinvitationregistrylist) | **GET** /invitations | List the invitations the caller has sent.
*UserInvitationRegistryApi* | [**userInvitationRegistrySend**](docs/UserInvitationRegistryApi.md#userinvitationregistrysend) | **POST** /invitations | Invite a user to join the network.
*UserRegistryApi* | [**userRegistryCreate**](docs/UserRegistryApi.md#userregistrycreate) | **POST** /users | Register a new user. This method may be restricted by network settings.
*UserRegistryApi* | [**userRegistryCreateTemporaryPassword**](docs/UserRegistryApi.md#userregistrycreatetemporarypassword) | **POST** /users/{user_ids.user_id}/temporary_password | Create a temporary password that can be used for updating a forgotten password. The generated password is sent to the user's email address.
*UserRegistryApi* | [**userRegistryDelete**](docs/UserRegistryApi.md#userregistrydelete) | **DELETE** /users/{user_id} | Delete the user. This may not release the user ID for reuse.
*UserRegistryApi* | [**userRegistryGet**](docs/UserRegistryApi.md#userregistryget) | **GET** /users/{user_ids.user_id} | Get the user with the given identifiers, selecting the fields given by the field mask. The method may return more or less fields, depending on the rights of the caller.
*UserRegistryApi* | [**userRegistryList**](docs/UserRegistryApi.md#userregistrylist) | **GET** /users | List users of the network. This method is typically restricted to admins only.
*UserRegistryApi* | [**userRegistryPurge**](docs/UserRegistryApi.md#userregistrypurge) | **DELETE** /users/{user_id}/purge | Purge the user. This will release the user ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.
*UserRegistryApi* | [**userRegistryRestore**](docs/UserRegistryApi.md#userregistryrestore) | **POST** /users/{user_id}/restore | Restore a recently deleted user.
*UserRegistryApi* | [**userRegistryUpdate**](docs/UserRegistryApi.md#userregistryupdate) | **PUT** /users/{user.ids.user_id} | Update the user, changing the fields specified by the field mask to the provided values. This method can not be used to change the password, see the UpdatePassword method for that.
*UserRegistryApi* | [**userRegistryUpdatePassword**](docs/UserRegistryApi.md#userregistryupdatepassword) | **PUT** /users/{user_ids.user_id}/password | Update the password of the user.
*UserSessionRegistryApi* | [**userSessionRegistryDelete**](docs/UserSessionRegistryApi.md#usersessionregistrydelete) | **DELETE** /users/{user_ids.user_id}/sessions/{session_id} | Delete (revoke) the given user session.
*UserSessionRegistryApi* | [**userSessionRegistryList**](docs/UserSessionRegistryApi.md#usersessionregistrylist) | **GET** /users/{user_ids.user_id}/sessions | List the active sessions for the given user.


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.AWSIoTProviderAccessKey](docs/AWSIoTProviderAccessKey.md)
 - [org.openapitools.client.models.AWSIoTProviderAssumeRole](docs/AWSIoTProviderAssumeRole.md)
 - [org.openapitools.client.models.AWSIoTProviderDefaultIntegration](docs/AWSIoTProviderDefaultIntegration.md)
 - [org.openapitools.client.models.ApplicationDownlinkClassBC](docs/ApplicationDownlinkClassBC.md)
 - [org.openapitools.client.models.ApplicationPubSubAWSIoTProvider](docs/ApplicationPubSubAWSIoTProvider.md)
 - [org.openapitools.client.models.ApplicationPubSubMQTTProvider](docs/ApplicationPubSubMQTTProvider.md)
 - [org.openapitools.client.models.ApplicationPubSubNATSProvider](docs/ApplicationPubSubNATSProvider.md)
 - [org.openapitools.client.models.AsConfigurationPubSub](docs/AsConfigurationPubSub.md)
 - [org.openapitools.client.models.AuthInfoResponseAPIKeyAccess](docs/AuthInfoResponseAPIKeyAccess.md)
 - [org.openapitools.client.models.CUPSRedirectionClientTLS](docs/CUPSRedirectionClientTLS.md)
 - [org.openapitools.client.models.CompliancesCompliance](docs/CompliancesCompliance.md)
 - [org.openapitools.client.models.ConcentratorConfigFSKChannel](docs/ConcentratorConfigFSKChannel.md)
 - [org.openapitools.client.models.ConcentratorConfigLBTConfiguration](docs/ConcentratorConfigLBTConfiguration.md)
 - [org.openapitools.client.models.ConcentratorConfigLoRaStandardChannel](docs/ConcentratorConfigLoRaStandardChannel.md)
 - [org.openapitools.client.models.EndDeviceModelBattery](docs/EndDeviceModelBattery.md)
 - [org.openapitools.client.models.EndDeviceModelCompliances](docs/EndDeviceModelCompliances.md)
 - [org.openapitools.client.models.EndDeviceModelDimensions](docs/EndDeviceModelDimensions.md)
 - [org.openapitools.client.models.EndDeviceModelFirmwareVersion](docs/EndDeviceModelFirmwareVersion.md)
 - [org.openapitools.client.models.EndDeviceModelHardwareVersion](docs/EndDeviceModelHardwareVersion.md)
 - [org.openapitools.client.models.EndDeviceModelOperatingConditions](docs/EndDeviceModelOperatingConditions.md)
 - [org.openapitools.client.models.EndDeviceModelPhotos](docs/EndDeviceModelPhotos.md)
 - [org.openapitools.client.models.EndDeviceModelReseller](docs/EndDeviceModelReseller.md)
 - [org.openapitools.client.models.EndDeviceModelVideos](docs/EndDeviceModelVideos.md)
 - [org.openapitools.client.models.EventAuthentication](docs/EventAuthentication.md)
 - [org.openapitools.client.models.FirmwareVersionProfile](docs/FirmwareVersionProfile.md)
 - [org.openapitools.client.models.GatewayConnectionStatsRoundTripTimes](docs/GatewayConnectionStatsRoundTripTimes.md)
 - [org.openapitools.client.models.GatewayConnectionStatsSubBand](docs/GatewayConnectionStatsSubBand.md)
 - [org.openapitools.client.models.GatewayLRFHSS](docs/GatewayLRFHSS.md)
 - [org.openapitools.client.models.GatewayRadioTxConfiguration](docs/GatewayRadioTxConfiguration.md)
 - [org.openapitools.client.models.GenerateEndDeviceQRCodeRequestImage](docs/GenerateEndDeviceQRCodeRequestImage.md)
 - [org.openapitools.client.models.GetPhyVersionsResponseVersionInfo](docs/GetPhyVersionsResponseVersionInfo.md)
 - [org.openapitools.client.models.IsConfigurationEndDevicePicture](docs/IsConfigurationEndDevicePicture.md)
 - [org.openapitools.client.models.IsConfigurationProfilePicture](docs/IsConfigurationProfilePicture.md)
 - [org.openapitools.client.models.IsConfigurationUserRegistration](docs/IsConfigurationUserRegistration.md)
 - [org.openapitools.client.models.IsConfigurationUserRegistrationContactInfoValidation](docs/IsConfigurationUserRegistrationContactInfoValidation.md)
 - [org.openapitools.client.models.IsConfigurationUserRegistrationInvitation](docs/IsConfigurationUserRegistrationInvitation.md)
 - [org.openapitools.client.models.IsConfigurationUserRights](docs/IsConfigurationUserRights.md)
 - [org.openapitools.client.models.Lorawanv3BoolValue](docs/Lorawanv3BoolValue.md)
 - [org.openapitools.client.models.Lorawanv3ContactInfoValidation](docs/Lorawanv3ContactInfoValidation.md)
 - [org.openapitools.client.models.Lorawanv3GatewayIdentifiers](docs/Lorawanv3GatewayIdentifiers.md)
 - [org.openapitools.client.models.Lorawanv3Invitation](docs/Lorawanv3Invitation.md)
 - [org.openapitools.client.models.Lorawanv3Location](docs/Lorawanv3Location.md)
 - [org.openapitools.client.models.Lorawanv3Message](docs/Lorawanv3Message.md)
 - [org.openapitools.client.models.MACCommandADRParamSetupReq](docs/MACCommandADRParamSetupReq.md)
 - [org.openapitools.client.models.MACCommandBeaconFreqAns](docs/MACCommandBeaconFreqAns.md)
 - [org.openapitools.client.models.MACCommandBeaconFreqReq](docs/MACCommandBeaconFreqReq.md)
 - [org.openapitools.client.models.MACCommandBeaconTimingAns](docs/MACCommandBeaconTimingAns.md)
 - [org.openapitools.client.models.MACCommandDLChannelAns](docs/MACCommandDLChannelAns.md)
 - [org.openapitools.client.models.MACCommandDLChannelReq](docs/MACCommandDLChannelReq.md)
 - [org.openapitools.client.models.MACCommandDevStatusAns](docs/MACCommandDevStatusAns.md)
 - [org.openapitools.client.models.MACCommandDeviceModeConf](docs/MACCommandDeviceModeConf.md)
 - [org.openapitools.client.models.MACCommandDeviceModeInd](docs/MACCommandDeviceModeInd.md)
 - [org.openapitools.client.models.MACCommandDeviceTimeAns](docs/MACCommandDeviceTimeAns.md)
 - [org.openapitools.client.models.MACCommandDutyCycleReq](docs/MACCommandDutyCycleReq.md)
 - [org.openapitools.client.models.MACCommandForceRejoinReq](docs/MACCommandForceRejoinReq.md)
 - [org.openapitools.client.models.MACCommandLinkADRAns](docs/MACCommandLinkADRAns.md)
 - [org.openapitools.client.models.MACCommandLinkADRReq](docs/MACCommandLinkADRReq.md)
 - [org.openapitools.client.models.MACCommandLinkCheckAns](docs/MACCommandLinkCheckAns.md)
 - [org.openapitools.client.models.MACCommandNewChannelAns](docs/MACCommandNewChannelAns.md)
 - [org.openapitools.client.models.MACCommandNewChannelReq](docs/MACCommandNewChannelReq.md)
 - [org.openapitools.client.models.MACCommandPingSlotChannelAns](docs/MACCommandPingSlotChannelAns.md)
 - [org.openapitools.client.models.MACCommandPingSlotChannelReq](docs/MACCommandPingSlotChannelReq.md)
 - [org.openapitools.client.models.MACCommandPingSlotInfoReq](docs/MACCommandPingSlotInfoReq.md)
 - [org.openapitools.client.models.MACCommandRejoinParamSetupAns](docs/MACCommandRejoinParamSetupAns.md)
 - [org.openapitools.client.models.MACCommandRejoinParamSetupReq](docs/MACCommandRejoinParamSetupReq.md)
 - [org.openapitools.client.models.MACCommandRekeyConf](docs/MACCommandRekeyConf.md)
 - [org.openapitools.client.models.MACCommandRekeyInd](docs/MACCommandRekeyInd.md)
 - [org.openapitools.client.models.MACCommandResetConf](docs/MACCommandResetConf.md)
 - [org.openapitools.client.models.MACCommandResetInd](docs/MACCommandResetInd.md)
 - [org.openapitools.client.models.MACCommandRxParamSetupAns](docs/MACCommandRxParamSetupAns.md)
 - [org.openapitools.client.models.MACCommandRxParamSetupReq](docs/MACCommandRxParamSetupReq.md)
 - [org.openapitools.client.models.MACCommandRxTimingSetupReq](docs/MACCommandRxTimingSetupReq.md)
 - [org.openapitools.client.models.MACCommandTxParamSetupReq](docs/MACCommandTxParamSetupReq.md)
 - [org.openapitools.client.models.MACStateDataRateRange](docs/MACStateDataRateRange.md)
 - [org.openapitools.client.models.MACStateDataRateRanges](docs/MACStateDataRateRanges.md)
 - [org.openapitools.client.models.MACStateJoinAccept](docs/MACStateJoinAccept.md)
 - [org.openapitools.client.models.MQTTProviderQoS](docs/MQTTProviderQoS.md)
 - [org.openapitools.client.models.OperatingConditionsLimits](docs/OperatingConditionsLimits.md)
 - [org.openapitools.client.models.PictureEmbedded](docs/PictureEmbedded.md)
 - [org.openapitools.client.models.ProtobufAny](docs/ProtobufAny.md)
 - [org.openapitools.client.models.ProtobufFieldMask](docs/ProtobufFieldMask.md)
 - [org.openapitools.client.models.ProtobufNullValue](docs/ProtobufNullValue.md)
 - [org.openapitools.client.models.ProvidersStatus](docs/ProvidersStatus.md)
 - [org.openapitools.client.models.ProvisionEndDevicesRequestIdentifiersFromData](docs/ProvisionEndDevicesRequestIdentifiersFromData.md)
 - [org.openapitools.client.models.ProvisionEndDevicesRequestIdentifiersList](docs/ProvisionEndDevicesRequestIdentifiersList.md)
 - [org.openapitools.client.models.ProvisionEndDevicesRequestIdentifiersRange](docs/ProvisionEndDevicesRequestIdentifiersRange.md)
 - [org.openapitools.client.models.PubSubProviders](docs/PubSubProviders.md)
 - [org.openapitools.client.models.RuntimeError](docs/RuntimeError.md)
 - [org.openapitools.client.models.RuntimeStreamError](docs/RuntimeStreamError.md)
 - [org.openapitools.client.models.StreamResultOfV3ApplicationUp](docs/StreamResultOfV3ApplicationUp.md)
 - [org.openapitools.client.models.StreamResultOfV3EndDevice](docs/StreamResultOfV3EndDevice.md)
 - [org.openapitools.client.models.StreamResultOfV3EndDeviceTemplate](docs/StreamResultOfV3EndDeviceTemplate.md)
 - [org.openapitools.client.models.StreamResultOfV3Event](docs/StreamResultOfV3Event.md)
 - [org.openapitools.client.models.TxAcknowledgmentResult](docs/TxAcknowledgmentResult.md)
 - [org.openapitools.client.models.TxSettingsDownlink](docs/TxSettingsDownlink.md)
 - [org.openapitools.client.models.UserRegistrationAdminApproval](docs/UserRegistrationAdminApproval.md)
 - [org.openapitools.client.models.UserRegistrationPasswordRequirements](docs/UserRegistrationPasswordRequirements.md)
 - [org.openapitools.client.models.V3ADRAckDelayExponent](docs/V3ADRAckDelayExponent.md)
 - [org.openapitools.client.models.V3ADRAckDelayExponentValue](docs/V3ADRAckDelayExponentValue.md)
 - [org.openapitools.client.models.V3ADRAckLimitExponent](docs/V3ADRAckLimitExponent.md)
 - [org.openapitools.client.models.V3ADRAckLimitExponentValue](docs/V3ADRAckLimitExponentValue.md)
 - [org.openapitools.client.models.V3APIKey](docs/V3APIKey.md)
 - [org.openapitools.client.models.V3APIKeys](docs/V3APIKeys.md)
 - [org.openapitools.client.models.V3AggregatedDutyCycle](docs/V3AggregatedDutyCycle.md)
 - [org.openapitools.client.models.V3AggregatedDutyCycleValue](docs/V3AggregatedDutyCycleValue.md)
 - [org.openapitools.client.models.V3AppSKeyResponse](docs/V3AppSKeyResponse.md)
 - [org.openapitools.client.models.V3Application](docs/V3Application.md)
 - [org.openapitools.client.models.V3ApplicationActivationSettings](docs/V3ApplicationActivationSettings.md)
 - [org.openapitools.client.models.V3ApplicationDownlink](docs/V3ApplicationDownlink.md)
 - [org.openapitools.client.models.V3ApplicationDownlinkFailed](docs/V3ApplicationDownlinkFailed.md)
 - [org.openapitools.client.models.V3ApplicationDownlinks](docs/V3ApplicationDownlinks.md)
 - [org.openapitools.client.models.V3ApplicationIdentifiers](docs/V3ApplicationIdentifiers.md)
 - [org.openapitools.client.models.V3ApplicationInvalidatedDownlinks](docs/V3ApplicationInvalidatedDownlinks.md)
 - [org.openapitools.client.models.V3ApplicationJoinAccept](docs/V3ApplicationJoinAccept.md)
 - [org.openapitools.client.models.V3ApplicationLink](docs/V3ApplicationLink.md)
 - [org.openapitools.client.models.V3ApplicationLinkStats](docs/V3ApplicationLinkStats.md)
 - [org.openapitools.client.models.V3ApplicationLocation](docs/V3ApplicationLocation.md)
 - [org.openapitools.client.models.V3ApplicationPackage](docs/V3ApplicationPackage.md)
 - [org.openapitools.client.models.V3ApplicationPackageAssociation](docs/V3ApplicationPackageAssociation.md)
 - [org.openapitools.client.models.V3ApplicationPackageAssociationIdentifiers](docs/V3ApplicationPackageAssociationIdentifiers.md)
 - [org.openapitools.client.models.V3ApplicationPackageAssociations](docs/V3ApplicationPackageAssociations.md)
 - [org.openapitools.client.models.V3ApplicationPackageDefaultAssociation](docs/V3ApplicationPackageDefaultAssociation.md)
 - [org.openapitools.client.models.V3ApplicationPackageDefaultAssociationIdentifiers](docs/V3ApplicationPackageDefaultAssociationIdentifiers.md)
 - [org.openapitools.client.models.V3ApplicationPackageDefaultAssociations](docs/V3ApplicationPackageDefaultAssociations.md)
 - [org.openapitools.client.models.V3ApplicationPackages](docs/V3ApplicationPackages.md)
 - [org.openapitools.client.models.V3ApplicationPubSub](docs/V3ApplicationPubSub.md)
 - [org.openapitools.client.models.V3ApplicationPubSubFormats](docs/V3ApplicationPubSubFormats.md)
 - [org.openapitools.client.models.V3ApplicationPubSubIdentifiers](docs/V3ApplicationPubSubIdentifiers.md)
 - [org.openapitools.client.models.V3ApplicationPubSubMessage](docs/V3ApplicationPubSubMessage.md)
 - [org.openapitools.client.models.V3ApplicationPubSubs](docs/V3ApplicationPubSubs.md)
 - [org.openapitools.client.models.V3ApplicationServiceData](docs/V3ApplicationServiceData.md)
 - [org.openapitools.client.models.V3ApplicationUp](docs/V3ApplicationUp.md)
 - [org.openapitools.client.models.V3ApplicationUplink](docs/V3ApplicationUplink.md)
 - [org.openapitools.client.models.V3ApplicationWebhook](docs/V3ApplicationWebhook.md)
 - [org.openapitools.client.models.V3ApplicationWebhookFormats](docs/V3ApplicationWebhookFormats.md)
 - [org.openapitools.client.models.V3ApplicationWebhookIdentifiers](docs/V3ApplicationWebhookIdentifiers.md)
 - [org.openapitools.client.models.V3ApplicationWebhookMessage](docs/V3ApplicationWebhookMessage.md)
 - [org.openapitools.client.models.V3ApplicationWebhookTemplate](docs/V3ApplicationWebhookTemplate.md)
 - [org.openapitools.client.models.V3ApplicationWebhookTemplateField](docs/V3ApplicationWebhookTemplateField.md)
 - [org.openapitools.client.models.V3ApplicationWebhookTemplateIdentifiers](docs/V3ApplicationWebhookTemplateIdentifiers.md)
 - [org.openapitools.client.models.V3ApplicationWebhookTemplateMessage](docs/V3ApplicationWebhookTemplateMessage.md)
 - [org.openapitools.client.models.V3ApplicationWebhookTemplates](docs/V3ApplicationWebhookTemplates.md)
 - [org.openapitools.client.models.V3ApplicationWebhooks](docs/V3ApplicationWebhooks.md)
 - [org.openapitools.client.models.V3Applications](docs/V3Applications.md)
 - [org.openapitools.client.models.V3AsConfiguration](docs/V3AsConfiguration.md)
 - [org.openapitools.client.models.V3AuthInfoResponse](docs/V3AuthInfoResponse.md)
 - [org.openapitools.client.models.V3AuthorizeApplicationRequest](docs/V3AuthorizeApplicationRequest.md)
 - [org.openapitools.client.models.V3AuthorizeGatewayRequest](docs/V3AuthorizeGatewayRequest.md)
 - [org.openapitools.client.models.V3CFList](docs/V3CFList.md)
 - [org.openapitools.client.models.V3CFListType](docs/V3CFListType.md)
 - [org.openapitools.client.models.V3CUPSRedirection](docs/V3CUPSRedirection.md)
 - [org.openapitools.client.models.V3ClaimEndDeviceRequest](docs/V3ClaimEndDeviceRequest.md)
 - [org.openapitools.client.models.V3ClaimEndDeviceRequestAuthenticatedIdentifiers](docs/V3ClaimEndDeviceRequestAuthenticatedIdentifiers.md)
 - [org.openapitools.client.models.V3ClaimGatewayRequest](docs/V3ClaimGatewayRequest.md)
 - [org.openapitools.client.models.V3ClaimGatewayRequestAuthenticatedIdentifiers](docs/V3ClaimGatewayRequestAuthenticatedIdentifiers.md)
 - [org.openapitools.client.models.V3Class](docs/V3Class.md)
 - [org.openapitools.client.models.V3Client](docs/V3Client.md)
 - [org.openapitools.client.models.V3ClientIdentifiers](docs/V3ClientIdentifiers.md)
 - [org.openapitools.client.models.V3Clients](docs/V3Clients.md)
 - [org.openapitools.client.models.V3Collaborator](docs/V3Collaborator.md)
 - [org.openapitools.client.models.V3Collaborators](docs/V3Collaborators.md)
 - [org.openapitools.client.models.V3ConcentratorConfig](docs/V3ConcentratorConfig.md)
 - [org.openapitools.client.models.V3ConcentratorConfigChannel](docs/V3ConcentratorConfigChannel.md)
 - [org.openapitools.client.models.V3ContactInfo](docs/V3ContactInfo.md)
 - [org.openapitools.client.models.V3ContactMethod](docs/V3ContactMethod.md)
 - [org.openapitools.client.models.V3ContactType](docs/V3ContactType.md)
 - [org.openapitools.client.models.V3ConvertEndDeviceTemplateRequest](docs/V3ConvertEndDeviceTemplateRequest.md)
 - [org.openapitools.client.models.V3CreateApplicationAPIKeyRequest](docs/V3CreateApplicationAPIKeyRequest.md)
 - [org.openapitools.client.models.V3CreateApplicationRequest](docs/V3CreateApplicationRequest.md)
 - [org.openapitools.client.models.V3CreateClientRequest](docs/V3CreateClientRequest.md)
 - [org.openapitools.client.models.V3CreateEndDeviceRequest](docs/V3CreateEndDeviceRequest.md)
 - [org.openapitools.client.models.V3CreateGatewayAPIKeyRequest](docs/V3CreateGatewayAPIKeyRequest.md)
 - [org.openapitools.client.models.V3CreateGatewayRequest](docs/V3CreateGatewayRequest.md)
 - [org.openapitools.client.models.V3CreateLoginTokenResponse](docs/V3CreateLoginTokenResponse.md)
 - [org.openapitools.client.models.V3CreateOrganizationAPIKeyRequest](docs/V3CreateOrganizationAPIKeyRequest.md)
 - [org.openapitools.client.models.V3CreateOrganizationRequest](docs/V3CreateOrganizationRequest.md)
 - [org.openapitools.client.models.V3CreateUserAPIKeyRequest](docs/V3CreateUserAPIKeyRequest.md)
 - [org.openapitools.client.models.V3CreateUserRequest](docs/V3CreateUserRequest.md)
 - [org.openapitools.client.models.V3CryptoServicePayloadRequest](docs/V3CryptoServicePayloadRequest.md)
 - [org.openapitools.client.models.V3CryptoServicePayloadResponse](docs/V3CryptoServicePayloadResponse.md)
 - [org.openapitools.client.models.V3DLSettings](docs/V3DLSettings.md)
 - [org.openapitools.client.models.V3DataRate](docs/V3DataRate.md)
 - [org.openapitools.client.models.V3DataRateIndex](docs/V3DataRateIndex.md)
 - [org.openapitools.client.models.V3DataRateIndexValue](docs/V3DataRateIndexValue.md)
 - [org.openapitools.client.models.V3DataRateOffset](docs/V3DataRateOffset.md)
 - [org.openapitools.client.models.V3DataRateOffsetValue](docs/V3DataRateOffsetValue.md)
 - [org.openapitools.client.models.V3DecodeDownlinkRequest](docs/V3DecodeDownlinkRequest.md)
 - [org.openapitools.client.models.V3DecodeDownlinkResponse](docs/V3DecodeDownlinkResponse.md)
 - [org.openapitools.client.models.V3DecodeUplinkRequest](docs/V3DecodeUplinkRequest.md)
 - [org.openapitools.client.models.V3DecodeUplinkResponse](docs/V3DecodeUplinkResponse.md)
 - [org.openapitools.client.models.V3DecodedMessagePayload](docs/V3DecodedMessagePayload.md)
 - [org.openapitools.client.models.V3DevAddrPrefix](docs/V3DevAddrPrefix.md)
 - [org.openapitools.client.models.V3DeviceEIRP](docs/V3DeviceEIRP.md)
 - [org.openapitools.client.models.V3DeviceEIRPValue](docs/V3DeviceEIRPValue.md)
 - [org.openapitools.client.models.V3DownlinkMessage](docs/V3DownlinkMessage.md)
 - [org.openapitools.client.models.V3DownlinkPath](docs/V3DownlinkPath.md)
 - [org.openapitools.client.models.V3DownlinkPathConstraint](docs/V3DownlinkPathConstraint.md)
 - [org.openapitools.client.models.V3DownlinkQueueRequest](docs/V3DownlinkQueueRequest.md)
 - [org.openapitools.client.models.V3EncodeDownlinkRequest](docs/V3EncodeDownlinkRequest.md)
 - [org.openapitools.client.models.V3EncodeDownlinkResponse](docs/V3EncodeDownlinkResponse.md)
 - [org.openapitools.client.models.V3EncodedMessagePayload](docs/V3EncodedMessagePayload.md)
 - [org.openapitools.client.models.V3EndDevice](docs/V3EndDevice.md)
 - [org.openapitools.client.models.V3EndDeviceAuthenticationCode](docs/V3EndDeviceAuthenticationCode.md)
 - [org.openapitools.client.models.V3EndDeviceBrand](docs/V3EndDeviceBrand.md)
 - [org.openapitools.client.models.V3EndDeviceIdentifiers](docs/V3EndDeviceIdentifiers.md)
 - [org.openapitools.client.models.V3EndDeviceModel](docs/V3EndDeviceModel.md)
 - [org.openapitools.client.models.V3EndDeviceTemplate](docs/V3EndDeviceTemplate.md)
 - [org.openapitools.client.models.V3EndDeviceTemplateFormat](docs/V3EndDeviceTemplateFormat.md)
 - [org.openapitools.client.models.V3EndDeviceTemplateFormats](docs/V3EndDeviceTemplateFormats.md)
 - [org.openapitools.client.models.V3EndDeviceVersionIdentifiers](docs/V3EndDeviceVersionIdentifiers.md)
 - [org.openapitools.client.models.V3EndDevices](docs/V3EndDevices.md)
 - [org.openapitools.client.models.V3EntityIdentifiers](docs/V3EntityIdentifiers.md)
 - [org.openapitools.client.models.V3ErrorDetails](docs/V3ErrorDetails.md)
 - [org.openapitools.client.models.V3Event](docs/V3Event.md)
 - [org.openapitools.client.models.V3FCtrl](docs/V3FCtrl.md)
 - [org.openapitools.client.models.V3FHDR](docs/V3FHDR.md)
 - [org.openapitools.client.models.V3FSKDataRate](docs/V3FSKDataRate.md)
 - [org.openapitools.client.models.V3FindRelatedEventsResponse](docs/V3FindRelatedEventsResponse.md)
 - [org.openapitools.client.models.V3FrequencyPlanDescription](docs/V3FrequencyPlanDescription.md)
 - [org.openapitools.client.models.V3FrequencyValue](docs/V3FrequencyValue.md)
 - [org.openapitools.client.models.V3Gateway](docs/V3Gateway.md)
 - [org.openapitools.client.models.V3GatewayAntenna](docs/V3GatewayAntenna.md)
 - [org.openapitools.client.models.V3GatewayAntennaIdentifiers](docs/V3GatewayAntennaIdentifiers.md)
 - [org.openapitools.client.models.V3GatewayAntennaPlacement](docs/V3GatewayAntennaPlacement.md)
 - [org.openapitools.client.models.V3GatewayClaimAuthenticationCode](docs/V3GatewayClaimAuthenticationCode.md)
 - [org.openapitools.client.models.V3GatewayConnectionStats](docs/V3GatewayConnectionStats.md)
 - [org.openapitools.client.models.V3GatewayDown](docs/V3GatewayDown.md)
 - [org.openapitools.client.models.V3GatewayRadio](docs/V3GatewayRadio.md)
 - [org.openapitools.client.models.V3GatewayStatus](docs/V3GatewayStatus.md)
 - [org.openapitools.client.models.V3GatewayVersionIdentifiers](docs/V3GatewayVersionIdentifiers.md)
 - [org.openapitools.client.models.V3Gateways](docs/V3Gateways.md)
 - [org.openapitools.client.models.V3GenerateDevAddrResponse](docs/V3GenerateDevAddrResponse.md)
 - [org.openapitools.client.models.V3GenerateEndDeviceQRCodeRequest](docs/V3GenerateEndDeviceQRCodeRequest.md)
 - [org.openapitools.client.models.V3GenerateQRCodeResponse](docs/V3GenerateQRCodeResponse.md)
 - [org.openapitools.client.models.V3GetAsConfigurationResponse](docs/V3GetAsConfigurationResponse.md)
 - [org.openapitools.client.models.V3GetCollaboratorResponse](docs/V3GetCollaboratorResponse.md)
 - [org.openapitools.client.models.V3GetIsConfigurationResponse](docs/V3GetIsConfigurationResponse.md)
 - [org.openapitools.client.models.V3GetPhyVersionsResponse](docs/V3GetPhyVersionsResponse.md)
 - [org.openapitools.client.models.V3GetStoredApplicationUpCountResponse](docs/V3GetStoredApplicationUpCountResponse.md)
 - [org.openapitools.client.models.V3GrantType](docs/V3GrantType.md)
 - [org.openapitools.client.models.V3Invitations](docs/V3Invitations.md)
 - [org.openapitools.client.models.V3IsConfiguration](docs/V3IsConfiguration.md)
 - [org.openapitools.client.models.V3IssueDevEUIResponse](docs/V3IssueDevEUIResponse.md)
 - [org.openapitools.client.models.V3JoinAcceptPayload](docs/V3JoinAcceptPayload.md)
 - [org.openapitools.client.models.V3JoinEUIPrefix](docs/V3JoinEUIPrefix.md)
 - [org.openapitools.client.models.V3JoinEUIPrefixes](docs/V3JoinEUIPrefixes.md)
 - [org.openapitools.client.models.V3JoinRequestPayload](docs/V3JoinRequestPayload.md)
 - [org.openapitools.client.models.V3JoinRequestType](docs/V3JoinRequestType.md)
 - [org.openapitools.client.models.V3JoinResponse](docs/V3JoinResponse.md)
 - [org.openapitools.client.models.V3KeyEnvelope](docs/V3KeyEnvelope.md)
 - [org.openapitools.client.models.V3KeyProvisioning](docs/V3KeyProvisioning.md)
 - [org.openapitools.client.models.V3KeySecurity](docs/V3KeySecurity.md)
 - [org.openapitools.client.models.V3LRFHSSDataRate](docs/V3LRFHSSDataRate.md)
 - [org.openapitools.client.models.V3ListEndDeviceBrandsResponse](docs/V3ListEndDeviceBrandsResponse.md)
 - [org.openapitools.client.models.V3ListEndDeviceModelsResponse](docs/V3ListEndDeviceModelsResponse.md)
 - [org.openapitools.client.models.V3ListFrequencyPlansResponse](docs/V3ListFrequencyPlansResponse.md)
 - [org.openapitools.client.models.V3LoRaDataRate](docs/V3LoRaDataRate.md)
 - [org.openapitools.client.models.V3LocationSource](docs/V3LocationSource.md)
 - [org.openapitools.client.models.V3MACCommand](docs/V3MACCommand.md)
 - [org.openapitools.client.models.V3MACCommandIdentifier](docs/V3MACCommandIdentifier.md)
 - [org.openapitools.client.models.V3MACParameters](docs/V3MACParameters.md)
 - [org.openapitools.client.models.V3MACParametersChannel](docs/V3MACParametersChannel.md)
 - [org.openapitools.client.models.V3MACPayload](docs/V3MACPayload.md)
 - [org.openapitools.client.models.V3MACSettings](docs/V3MACSettings.md)
 - [org.openapitools.client.models.V3MACState](docs/V3MACState.md)
 - [org.openapitools.client.models.V3MACStateJoinRequest](docs/V3MACStateJoinRequest.md)
 - [org.openapitools.client.models.V3MACVersion](docs/V3MACVersion.md)
 - [org.openapitools.client.models.V3MHDR](docs/V3MHDR.md)
 - [org.openapitools.client.models.V3MQTTConnectionInfo](docs/V3MQTTConnectionInfo.md)
 - [org.openapitools.client.models.V3MType](docs/V3MType.md)
 - [org.openapitools.client.models.V3Major](docs/V3Major.md)
 - [org.openapitools.client.models.V3MessagePayloadDecoder](docs/V3MessagePayloadDecoder.md)
 - [org.openapitools.client.models.V3MessagePayloadDecoderExample](docs/V3MessagePayloadDecoderExample.md)
 - [org.openapitools.client.models.V3MessagePayloadEncoder](docs/V3MessagePayloadEncoder.md)
 - [org.openapitools.client.models.V3MessagePayloadEncoderExample](docs/V3MessagePayloadEncoderExample.md)
 - [org.openapitools.client.models.V3MessagePayloadFormatters](docs/V3MessagePayloadFormatters.md)
 - [org.openapitools.client.models.V3Minor](docs/V3Minor.md)
 - [org.openapitools.client.models.V3NetworkIdentifiers](docs/V3NetworkIdentifiers.md)
 - [org.openapitools.client.models.V3NwkSKeysResponse](docs/V3NwkSKeysResponse.md)
 - [org.openapitools.client.models.V3OAuthAccessToken](docs/V3OAuthAccessToken.md)
 - [org.openapitools.client.models.V3OAuthAccessTokens](docs/V3OAuthAccessTokens.md)
 - [org.openapitools.client.models.V3OAuthClientAuthorization](docs/V3OAuthClientAuthorization.md)
 - [org.openapitools.client.models.V3OAuthClientAuthorizations](docs/V3OAuthClientAuthorizations.md)
 - [org.openapitools.client.models.V3Organization](docs/V3Organization.md)
 - [org.openapitools.client.models.V3OrganizationIdentifiers](docs/V3OrganizationIdentifiers.md)
 - [org.openapitools.client.models.V3OrganizationOrUserIdentifiers](docs/V3OrganizationOrUserIdentifiers.md)
 - [org.openapitools.client.models.V3Organizations](docs/V3Organizations.md)
 - [org.openapitools.client.models.V3PHYVersion](docs/V3PHYVersion.md)
 - [org.openapitools.client.models.V3PacketBrokerDefaultGatewayVisibility](docs/V3PacketBrokerDefaultGatewayVisibility.md)
 - [org.openapitools.client.models.V3PacketBrokerDefaultRoutingPolicy](docs/V3PacketBrokerDefaultRoutingPolicy.md)
 - [org.openapitools.client.models.V3PacketBrokerDevAddrBlock](docs/V3PacketBrokerDevAddrBlock.md)
 - [org.openapitools.client.models.V3PacketBrokerGateway](docs/V3PacketBrokerGateway.md)
 - [org.openapitools.client.models.V3PacketBrokerGatewayGatewayIdentifiers](docs/V3PacketBrokerGatewayGatewayIdentifiers.md)
 - [org.openapitools.client.models.V3PacketBrokerGatewayVisibility](docs/V3PacketBrokerGatewayVisibility.md)
 - [org.openapitools.client.models.V3PacketBrokerInfo](docs/V3PacketBrokerInfo.md)
 - [org.openapitools.client.models.V3PacketBrokerMetadata](docs/V3PacketBrokerMetadata.md)
 - [org.openapitools.client.models.V3PacketBrokerNetwork](docs/V3PacketBrokerNetwork.md)
 - [org.openapitools.client.models.V3PacketBrokerNetworkIdentifier](docs/V3PacketBrokerNetworkIdentifier.md)
 - [org.openapitools.client.models.V3PacketBrokerNetworks](docs/V3PacketBrokerNetworks.md)
 - [org.openapitools.client.models.V3PacketBrokerRegisterRequest](docs/V3PacketBrokerRegisterRequest.md)
 - [org.openapitools.client.models.V3PacketBrokerRouteHop](docs/V3PacketBrokerRouteHop.md)
 - [org.openapitools.client.models.V3PacketBrokerRoutingPolicies](docs/V3PacketBrokerRoutingPolicies.md)
 - [org.openapitools.client.models.V3PacketBrokerRoutingPolicy](docs/V3PacketBrokerRoutingPolicy.md)
 - [org.openapitools.client.models.V3PacketBrokerRoutingPolicyDownlink](docs/V3PacketBrokerRoutingPolicyDownlink.md)
 - [org.openapitools.client.models.V3PacketBrokerRoutingPolicyUplink](docs/V3PacketBrokerRoutingPolicyUplink.md)
 - [org.openapitools.client.models.V3PayloadFormatter](docs/V3PayloadFormatter.md)
 - [org.openapitools.client.models.V3Picture](docs/V3Picture.md)
 - [org.openapitools.client.models.V3PingSlotPeriod](docs/V3PingSlotPeriod.md)
 - [org.openapitools.client.models.V3PingSlotPeriodValue](docs/V3PingSlotPeriodValue.md)
 - [org.openapitools.client.models.V3PowerState](docs/V3PowerState.md)
 - [org.openapitools.client.models.V3ProvisionEndDevicesRequest](docs/V3ProvisionEndDevicesRequest.md)
 - [org.openapitools.client.models.V3QRCodeFormat](docs/V3QRCodeFormat.md)
 - [org.openapitools.client.models.V3QRCodeFormats](docs/V3QRCodeFormats.md)
 - [org.openapitools.client.models.V3RejoinCountExponent](docs/V3RejoinCountExponent.md)
 - [org.openapitools.client.models.V3RejoinPeriodExponent](docs/V3RejoinPeriodExponent.md)
 - [org.openapitools.client.models.V3RejoinRequestPayload](docs/V3RejoinRequestPayload.md)
 - [org.openapitools.client.models.V3RejoinRequestType](docs/V3RejoinRequestType.md)
 - [org.openapitools.client.models.V3RejoinTimeExponent](docs/V3RejoinTimeExponent.md)
 - [org.openapitools.client.models.V3ResetAndGetEndDeviceRequest](docs/V3ResetAndGetEndDeviceRequest.md)
 - [org.openapitools.client.models.V3Right](docs/V3Right.md)
 - [org.openapitools.client.models.V3Rights](docs/V3Rights.md)
 - [org.openapitools.client.models.V3RootKeys](docs/V3RootKeys.md)
 - [org.openapitools.client.models.V3RxDelay](docs/V3RxDelay.md)
 - [org.openapitools.client.models.V3RxDelayValue](docs/V3RxDelayValue.md)
 - [org.openapitools.client.models.V3RxMetadata](docs/V3RxMetadata.md)
 - [org.openapitools.client.models.V3ScheduleDownlinkResponse](docs/V3ScheduleDownlinkResponse.md)
 - [org.openapitools.client.models.V3Secret](docs/V3Secret.md)
 - [org.openapitools.client.models.V3SendInvitationRequest](docs/V3SendInvitationRequest.md)
 - [org.openapitools.client.models.V3Session](docs/V3Session.md)
 - [org.openapitools.client.models.V3SessionKeys](docs/V3SessionKeys.md)
 - [org.openapitools.client.models.V3SetApplicationActivationSettingsRequest](docs/V3SetApplicationActivationSettingsRequest.md)
 - [org.openapitools.client.models.V3SetApplicationCollaboratorRequest](docs/V3SetApplicationCollaboratorRequest.md)
 - [org.openapitools.client.models.V3SetApplicationLinkRequest](docs/V3SetApplicationLinkRequest.md)
 - [org.openapitools.client.models.V3SetApplicationPackageAssociationRequest](docs/V3SetApplicationPackageAssociationRequest.md)
 - [org.openapitools.client.models.V3SetApplicationPackageDefaultAssociationRequest](docs/V3SetApplicationPackageDefaultAssociationRequest.md)
 - [org.openapitools.client.models.V3SetApplicationPubSubRequest](docs/V3SetApplicationPubSubRequest.md)
 - [org.openapitools.client.models.V3SetApplicationWebhookRequest](docs/V3SetApplicationWebhookRequest.md)
 - [org.openapitools.client.models.V3SetClientCollaboratorRequest](docs/V3SetClientCollaboratorRequest.md)
 - [org.openapitools.client.models.V3SetEndDeviceRequest](docs/V3SetEndDeviceRequest.md)
 - [org.openapitools.client.models.V3SetGatewayCollaboratorRequest](docs/V3SetGatewayCollaboratorRequest.md)
 - [org.openapitools.client.models.V3SetOrganizationCollaboratorRequest](docs/V3SetOrganizationCollaboratorRequest.md)
 - [org.openapitools.client.models.V3SetPacketBrokerDefaultGatewayVisibilityRequest](docs/V3SetPacketBrokerDefaultGatewayVisibilityRequest.md)
 - [org.openapitools.client.models.V3SetPacketBrokerDefaultRoutingPolicyRequest](docs/V3SetPacketBrokerDefaultRoutingPolicyRequest.md)
 - [org.openapitools.client.models.V3SetPacketBrokerRoutingPolicyRequest](docs/V3SetPacketBrokerRoutingPolicyRequest.md)
 - [org.openapitools.client.models.V3State](docs/V3State.md)
 - [org.openapitools.client.models.V3StreamEventsRequest](docs/V3StreamEventsRequest.md)
 - [org.openapitools.client.models.V3TxAcknowledgment](docs/V3TxAcknowledgment.md)
 - [org.openapitools.client.models.V3TxRequest](docs/V3TxRequest.md)
 - [org.openapitools.client.models.V3TxSchedulePriority](docs/V3TxSchedulePriority.md)
 - [org.openapitools.client.models.V3TxSettings](docs/V3TxSettings.md)
 - [org.openapitools.client.models.V3UpdateApplicationAPIKeyRequest](docs/V3UpdateApplicationAPIKeyRequest.md)
 - [org.openapitools.client.models.V3UpdateApplicationRequest](docs/V3UpdateApplicationRequest.md)
 - [org.openapitools.client.models.V3UpdateClientRequest](docs/V3UpdateClientRequest.md)
 - [org.openapitools.client.models.V3UpdateEndDeviceRequest](docs/V3UpdateEndDeviceRequest.md)
 - [org.openapitools.client.models.V3UpdateGatewayAPIKeyRequest](docs/V3UpdateGatewayAPIKeyRequest.md)
 - [org.openapitools.client.models.V3UpdateGatewayRequest](docs/V3UpdateGatewayRequest.md)
 - [org.openapitools.client.models.V3UpdateOrganizationAPIKeyRequest](docs/V3UpdateOrganizationAPIKeyRequest.md)
 - [org.openapitools.client.models.V3UpdateOrganizationRequest](docs/V3UpdateOrganizationRequest.md)
 - [org.openapitools.client.models.V3UpdatePacketBrokerGatewayResponse](docs/V3UpdatePacketBrokerGatewayResponse.md)
 - [org.openapitools.client.models.V3UpdateUserAPIKeyRequest](docs/V3UpdateUserAPIKeyRequest.md)
 - [org.openapitools.client.models.V3UpdateUserPasswordRequest](docs/V3UpdateUserPasswordRequest.md)
 - [org.openapitools.client.models.V3UpdateUserRequest](docs/V3UpdateUserRequest.md)
 - [org.openapitools.client.models.V3UplinkMessage](docs/V3UplinkMessage.md)
 - [org.openapitools.client.models.V3User](docs/V3User.md)
 - [org.openapitools.client.models.V3UserIdentifiers](docs/V3UserIdentifiers.md)
 - [org.openapitools.client.models.V3UserSession](docs/V3UserSession.md)
 - [org.openapitools.client.models.V3UserSessions](docs/V3UserSessions.md)
 - [org.openapitools.client.models.V3Users](docs/V3Users.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
