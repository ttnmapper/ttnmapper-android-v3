
# V3TxSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dataRate** | [**V3DataRate**](V3DataRate.md) |  |  [optional]
**codingRate** | **kotlin.String** | LoRa coding rate. |  [optional]
**frequency** | **kotlin.String** | Frequency (Hz). |  [optional]
**enableCrc** | **kotlin.Boolean** | Send a CRC in the packet; only on uplink; on downlink, CRC should not be enabled. |  [optional]
**timestamp** | **kotlin.Long** | Timestamp of the gateway concentrator when the uplink message was received, or when the downlink message should be transmitted (microseconds). On downlink, set timestamp to 0 and time to null to use immediate scheduling. |  [optional]
**time** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Time of the gateway when the uplink message was received, or when the downlink message should be transmitted. For downlink, this requires the gateway to have GPS time synchronization. |  [optional]
**downlink** | [**TxSettingsDownlink**](TxSettingsDownlink.md) |  |  [optional]



