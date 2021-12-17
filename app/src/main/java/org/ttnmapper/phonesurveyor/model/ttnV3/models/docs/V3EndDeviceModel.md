
# V3EndDeviceModel

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**brandId** | **kotlin.String** | Brand identifier, as defined in the Device Repository. |  [optional]
**modelId** | **kotlin.String** | Model identifier, as defined in the Device Repository. |  [optional]
**name** | **kotlin.String** | Model name, as defined in the Device Repository. |  [optional]
**description** | **kotlin.String** | Model description. |  [optional]
**hardwareVersions** | [**kotlin.collections.List&lt;EndDeviceModelHardwareVersion&gt;**](EndDeviceModelHardwareVersion.md) | Available hardware versions. |  [optional]
**firmwareVersions** | [**kotlin.collections.List&lt;EndDeviceModelFirmwareVersion&gt;**](EndDeviceModelFirmwareVersion.md) | Available firmware versions. |  [optional]
**sensors** | **kotlin.collections.List&lt;kotlin.String&gt;** | List of sensors included in the device. |  [optional]
**dimensions** | [**EndDeviceModelDimensions**](EndDeviceModelDimensions.md) |  |  [optional]
**weight** | **kotlin.Float** | Device weight (gram). |  [optional]
**battery** | [**EndDeviceModelBattery**](EndDeviceModelBattery.md) |  |  [optional]
**operatingConditions** | [**EndDeviceModelOperatingConditions**](EndDeviceModelOperatingConditions.md) |  |  [optional]
**ipCode** | **kotlin.String** | Device IP rating code. |  [optional]
**keyProvisioning** | [**kotlin.collections.List&lt;V3KeyProvisioning&gt;**](V3KeyProvisioning.md) | Supported key provisioning methods. |  [optional]
**keySecurity** | [**V3KeySecurity**](V3KeySecurity.md) |  |  [optional]
**photos** | [**EndDeviceModelPhotos**](EndDeviceModelPhotos.md) |  |  [optional]
**videos** | [**EndDeviceModelVideos**](EndDeviceModelVideos.md) |  |  [optional]
**productUrl** | **kotlin.String** | Device information page URL. |  [optional]
**datasheetUrl** | **kotlin.String** | Device datasheet URL. |  [optional]
**resellers** | [**kotlin.collections.List&lt;EndDeviceModelReseller&gt;**](EndDeviceModelReseller.md) | Reseller URLs. |  [optional]
**compliances** | [**EndDeviceModelCompliances**](EndDeviceModelCompliances.md) |  |  [optional]
**additionalRadios** | **kotlin.collections.List&lt;kotlin.String&gt;** | List of any additional radios included in the device. |  [optional]



