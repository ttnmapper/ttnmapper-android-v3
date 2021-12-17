
# V3ApplicationWebhook

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3ApplicationWebhookIdentifiers**](V3ApplicationWebhookIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**baseUrl** | **kotlin.String** | Base URL to which the message&#39;s path is appended. |  [optional]
**headers** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | HTTP headers to use. |  [optional]
**format** | **kotlin.String** | The format to use for the body. Supported values depend on the Application Server configuration. |  [optional]
**templateIds** | [**V3ApplicationWebhookTemplateIdentifiers**](V3ApplicationWebhookTemplateIdentifiers.md) |  |  [optional]
**templateFields** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | The value of the fields used by the template. Maps field.id to the value. |  [optional]
**downlinkApiKey** | **kotlin.String** | The API key to be used for downlink queue operations. The field is provided for convenience reasons, and can contain API keys with additional rights (albeit this is discouraged). |  [optional]
**uplinkMessage** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**joinAccept** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**downlinkAck** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**downlinkNack** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**downlinkSent** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**downlinkFailed** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**downlinkQueued** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**downlinkQueueInvalidated** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**locationSolved** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]
**serviceData** | [**V3ApplicationWebhookMessage**](V3ApplicationWebhookMessage.md) |  |  [optional]



