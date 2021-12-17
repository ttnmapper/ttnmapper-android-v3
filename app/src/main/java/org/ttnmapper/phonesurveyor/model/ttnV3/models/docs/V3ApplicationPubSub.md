
# V3ApplicationPubSub

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3ApplicationPubSubIdentifiers**](V3ApplicationPubSubIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**format** | **kotlin.String** | The format to use for the body. Supported values depend on the Application Server configuration. |  [optional]
**nats** | [**ApplicationPubSubNATSProvider**](ApplicationPubSubNATSProvider.md) |  |  [optional]
**mqtt** | [**ApplicationPubSubMQTTProvider**](ApplicationPubSubMQTTProvider.md) |  |  [optional]
**awsIot** | [**ApplicationPubSubAWSIoTProvider**](ApplicationPubSubAWSIoTProvider.md) |  |  [optional]
**baseTopic** | **kotlin.String** | Base topic name to which the messages topic is appended. |  [optional]
**downlinkPush** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkReplace** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**uplinkMessage** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**joinAccept** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkAck** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkNack** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkSent** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkFailed** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkQueued** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**downlinkQueueInvalidated** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**locationSolved** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]
**serviceData** | [**V3ApplicationPubSubMessage**](V3ApplicationPubSubMessage.md) |  |  [optional]



