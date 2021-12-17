
# V3PacketBrokerGateway

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**V3PacketBrokerGatewayGatewayIdentifiers**](V3PacketBrokerGatewayGatewayIdentifiers.md) |  |  [optional]
**contactInfo** | [**kotlin.collections.List&lt;V3ContactInfo&gt;**](V3ContactInfo.md) |  |  [optional]
**antennas** | [**kotlin.collections.List&lt;V3GatewayAntenna&gt;**](V3GatewayAntenna.md) |  |  [optional]
**statusPublic** | **kotlin.Boolean** |  |  [optional]
**locationPublic** | **kotlin.Boolean** |  |  [optional]
**frequencyPlanIds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional]
**updateLocationFromStatus** | **kotlin.Boolean** |  |  [optional]
**online** | **kotlin.Boolean** |  |  [optional]
**rxRate** | **kotlin.Float** | Received packets rate (number of packets per hour). This field gets updated when a value is set. |  [optional]
**txRate** | **kotlin.Float** | Transmitted packets rate (number of packets per hour). This field gets updated when a value is set. |  [optional]



