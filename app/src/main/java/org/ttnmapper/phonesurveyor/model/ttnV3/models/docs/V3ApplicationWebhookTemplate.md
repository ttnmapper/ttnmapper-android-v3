
# V3ApplicationWebhookTemplate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3ApplicationWebhookTemplateIdentifiers**](V3ApplicationWebhookTemplateIdentifiers.md) |  |  [optional]
**name** | **kotlin.String** |  |  [optional]
**description** | **kotlin.String** |  |  [optional]
**logoUrl** | **kotlin.String** |  |  [optional]
**infoUrl** | **kotlin.String** |  |  [optional]
**documentationUrl** | **kotlin.String** |  |  [optional]
**baseUrl** | **kotlin.String** | The base URL of the template. Can contain template fields, in RFC 6570 format. |  [optional]
**headers** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | The HTTP headers used by the template. Both the key and the value can contain template fields. |  [optional]
**format** | **kotlin.String** |  |  [optional]
**fields** | [**kotlin.collections.List&lt;V3ApplicationWebhookTemplateField&gt;**](V3ApplicationWebhookTemplateField.md) |  |  [optional]
**createDownlinkApiKey** | **kotlin.Boolean** | Control the creation of the downlink queue operations API key. |  [optional]
**uplinkMessage** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**joinAccept** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**downlinkAck** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**downlinkNack** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**downlinkSent** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**downlinkFailed** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**downlinkQueued** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**downlinkQueueInvalidated** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**locationSolved** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]
**serviceData** | [**V3ApplicationWebhookTemplateMessage**](V3ApplicationWebhookTemplateMessage.md) |  |  [optional]



