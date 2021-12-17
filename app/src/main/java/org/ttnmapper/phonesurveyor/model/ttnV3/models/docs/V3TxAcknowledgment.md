
# V3TxAcknowledgment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**correlationIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Correlation IDs for the downlink message. Set automatically by the UDP and LBS frontends. For gRPC and the MQTT v3 frontends, the correlation IDs must match the ones of the downlink message the Tx acknowledgment message refers to. |  [optional]
**result** | [**TxAcknowledgmentResult**](TxAcknowledgmentResult.md) |  |  [optional]
**downlinkMessage** | [**V3DownlinkMessage**](V3DownlinkMessage.md) |  |  [optional]



