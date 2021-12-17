
# V3PacketBrokerRoutingPolicyUplink

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**joinRequest** | **kotlin.Boolean** | Forward join-request messages. |  [optional]
**macData** | **kotlin.Boolean** | Forward uplink messages with FPort of 0. |  [optional]
**applicationData** | **kotlin.Boolean** | Forward uplink messages with FPort between 1 and 255. |  [optional]
**signalQuality** | **kotlin.Boolean** | Forward RSSI and SNR. |  [optional]
**localization** | **kotlin.Boolean** | Forward gateway location, RSSI, SNR and fine timestamp. |  [optional]



