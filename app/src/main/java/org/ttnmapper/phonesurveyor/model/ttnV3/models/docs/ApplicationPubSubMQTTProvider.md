
# ApplicationPubSubMQTTProvider

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**serverUrl** | **kotlin.String** |  |  [optional]
**clientId** | **kotlin.String** |  |  [optional]
**username** | **kotlin.String** |  |  [optional]
**password** | **kotlin.String** |  |  [optional]
**subscribeQos** | [**MQTTProviderQoS**](MQTTProviderQoS.md) |  |  [optional]
**publishQos** | [**MQTTProviderQoS**](MQTTProviderQoS.md) |  |  [optional]
**useTls** | **kotlin.Boolean** |  |  [optional]
**tlsCa** | **kotlin.ByteArray** | The server Root CA certificate. PEM formatted. |  [optional]
**tlsClientCert** | **kotlin.ByteArray** | The client certificate. PEM formatted. |  [optional]
**tlsClientKey** | **kotlin.ByteArray** | The client private key. PEM formatted. |  [optional]
**headers** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | HTTP headers to use on MQTT-over-Websocket connections. |  [optional]



