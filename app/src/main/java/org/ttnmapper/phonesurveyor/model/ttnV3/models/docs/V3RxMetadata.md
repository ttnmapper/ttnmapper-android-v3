
# V3RxMetadata

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**gatewayIds** | [**Lorawanv3GatewayIdentifiers**](Lorawanv3GatewayIdentifiers.md) |  |  [optional]
**packetBroker** | [**V3PacketBrokerMetadata**](V3PacketBrokerMetadata.md) |  |  [optional]
**antennaIndex** | **kotlin.Long** |  |  [optional]
**time** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  [optional]
**timestamp** | **kotlin.Long** | Gateway concentrator timestamp when the Rx finished (microseconds). |  [optional]
**fineTimestamp** | **kotlin.String** | Gateway&#39;s internal fine timestamp when the Rx finished (nanoseconds). |  [optional]
**encryptedFineTimestamp** | **kotlin.ByteArray** | Encrypted gateway&#39;s internal fine timestamp when the Rx finished (nanoseconds). |  [optional]
**encryptedFineTimestampKeyId** | **kotlin.String** |  |  [optional]
**rssi** | **kotlin.Float** | Received signal strength indicator (dBm). This value equals &#x60;channel_rssi&#x60;. |  [optional]
**signalRssi** | **kotlin.Float** | Received signal strength indicator of the signal (dBm). |  [optional]
**channelRssi** | **kotlin.Float** | Received signal strength indicator of the channel (dBm). |  [optional]
**rssiStandardDeviation** | **kotlin.Float** | Standard deviation of the RSSI during preamble. |  [optional]
**snr** | **kotlin.Float** | Signal-to-noise ratio (dB). |  [optional]
**frequencyOffset** | **kotlin.String** | Frequency offset (Hz). |  [optional]
**location** | [**Lorawanv3Location**](Lorawanv3Location.md) |  |  [optional]
**downlinkPathConstraint** | [**V3DownlinkPathConstraint**](V3DownlinkPathConstraint.md) |  |  [optional]
**uplinkToken** | **kotlin.ByteArray** | Uplink token to be included in the Tx request in class A downlink; injected by gateway, Gateway Server or fNS. |  [optional]
**channelIndex** | **kotlin.Long** | Index of the gateway channel that received the message. |  [optional]
**hoppingWidth** | **kotlin.Long** | Hopping width; a number describing the number of steps of the LR-FHSS grid. |  [optional]
**frequencyDrift** | **kotlin.Int** | Frequency drift in Hz between start and end of an LR-FHSS packet (signed). |  [optional]
**advanced** | [**kotlin.Any**](.md) |  |  [optional]



