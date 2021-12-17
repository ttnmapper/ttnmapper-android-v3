
# V3ClaimEndDeviceRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authenticatedIdentifiers** | [**V3ClaimEndDeviceRequestAuthenticatedIdentifiers**](V3ClaimEndDeviceRequestAuthenticatedIdentifiers.md) |  |  [optional]
**qrCode** | **kotlin.ByteArray** | Raw QR code contents. |  [optional]
**targetApplicationIds** | [**V3ApplicationIdentifiers**](V3ApplicationIdentifiers.md) |  |  [optional]
**targetDeviceId** | **kotlin.String** | End device ID of the target end device. If empty, use the source device ID. |  [optional]
**targetNetworkServerAddress** | **kotlin.String** | The address of the Network Server where the device will be registered. If set and if the source device is currently registered on a Network Server, settings will be transferred. If not set, the device shall not be registered on a Network Server. |  [optional]
**targetNetworkServerKekLabel** | **kotlin.String** | The KEK label of the Network Server to use for wrapping network session keys. |  [optional]
**targetApplicationServerAddress** | **kotlin.String** | The address of the Application Server where the device will be registered. If set and if the source device is currently registered on an Application Server, settings will be transferred. If not set, the device shall not be registered on an Application Server. |  [optional]
**targetApplicationServerKekLabel** | **kotlin.String** | The KEK label of the Application Server to use for wrapping the application session key. |  [optional]
**targetApplicationServerId** | **kotlin.String** | The AS-ID of the Application Server to use. |  [optional]
**targetNetId** | **kotlin.ByteArray** | Home NetID. |  [optional]
**invalidateAuthenticationCode** | **kotlin.Boolean** | If set, invalidate the authentication code with which the device gets claimed. This prohibits subsequent claiming requests. |  [optional]



