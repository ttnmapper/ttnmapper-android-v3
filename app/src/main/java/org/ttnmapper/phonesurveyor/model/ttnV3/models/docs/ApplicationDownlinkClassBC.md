
# ApplicationDownlinkClassBC

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**gateways** | [**kotlin.collections.List&lt;V3GatewayAntennaIdentifiers&gt;**](V3GatewayAntennaIdentifiers.md) | Possible gateway identifiers and antenna index to use for this downlink message. The Network Server selects one of these gateways for downlink, based on connectivity, signal quality, channel utilization and an available slot. If none of the gateways can be selected, the downlink message fails. If empty, a gateway and antenna is selected automatically from the gateways seen in recent uplinks. |  [optional]
**absoluteTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Absolute time when the downlink message should be transmitted. This requires the gateway to have GPS time synchronization. If the time is in the past or if there is a scheduling conflict, the downlink message fails. If null, the time is selected based on slot availability. This is recommended in class B mode. |  [optional]



