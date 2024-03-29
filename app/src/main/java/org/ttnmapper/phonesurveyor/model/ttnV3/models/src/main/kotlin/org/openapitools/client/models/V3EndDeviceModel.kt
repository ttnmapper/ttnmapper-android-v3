/**
 * The Things Stack for LoRaWAN v3 API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: version not set
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models

import org.openapitools.client.models.EndDeviceModelBattery
import org.openapitools.client.models.EndDeviceModelCompliances
import org.openapitools.client.models.EndDeviceModelDimensions
import org.openapitools.client.models.EndDeviceModelFirmwareVersion
import org.openapitools.client.models.EndDeviceModelHardwareVersion
import org.openapitools.client.models.EndDeviceModelOperatingConditions
import org.openapitools.client.models.EndDeviceModelPhotos
import org.openapitools.client.models.EndDeviceModelReseller
import org.openapitools.client.models.EndDeviceModelVideos
import org.openapitools.client.models.V3KeyProvisioning
import org.openapitools.client.models.V3KeySecurity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param brandId Brand identifier, as defined in the Device Repository.
 * @param modelId Model identifier, as defined in the Device Repository.
 * @param name Model name, as defined in the Device Repository.
 * @param description Model description.
 * @param hardwareVersions Available hardware versions.
 * @param firmwareVersions Available firmware versions.
 * @param sensors List of sensors included in the device.
 * @param dimensions 
 * @param weight Device weight (gram).
 * @param battery 
 * @param operatingConditions 
 * @param ipCode Device IP rating code.
 * @param keyProvisioning Supported key provisioning methods.
 * @param keySecurity 
 * @param photos 
 * @param videos 
 * @param productUrl Device information page URL.
 * @param datasheetUrl Device datasheet URL.
 * @param resellers Reseller URLs.
 * @param compliances 
 * @param additionalRadios List of any additional radios included in the device.
 */
@JsonClass(generateAdapter = true)
data class V3EndDeviceModel (

    /* Brand identifier, as defined in the Device Repository. */
    @Json(name = "brand_id")
    val brandId: kotlin.String? = null,

    /* Model identifier, as defined in the Device Repository. */
    @Json(name = "model_id")
    val modelId: kotlin.String? = null,

    /* Model name, as defined in the Device Repository. */
    @Json(name = "name")
    val name: kotlin.String? = null,

    /* Model description. */
    @Json(name = "description")
    val description: kotlin.String? = null,

    /* Available hardware versions. */
    @Json(name = "hardware_versions")
    val hardwareVersions: kotlin.collections.List<EndDeviceModelHardwareVersion>? = null,

    /* Available firmware versions. */
    @Json(name = "firmware_versions")
    val firmwareVersions: kotlin.collections.List<EndDeviceModelFirmwareVersion>? = null,

    /* List of sensors included in the device. */
    @Json(name = "sensors")
    val sensors: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "dimensions")
    val dimensions: EndDeviceModelDimensions? = null,

    /* Device weight (gram). */
    @Json(name = "weight")
    val weight: kotlin.Float? = null,

    @Json(name = "battery")
    val battery: EndDeviceModelBattery? = null,

    @Json(name = "operating_conditions")
    val operatingConditions: EndDeviceModelOperatingConditions? = null,

    /* Device IP rating code. */
    @Json(name = "ip_code")
    val ipCode: kotlin.String? = null,

    /* Supported key provisioning methods. */
    @Json(name = "key_provisioning")
    val keyProvisioning: kotlin.collections.List<V3KeyProvisioning>? = null,

    @Json(name = "key_security")
    val keySecurity: V3KeySecurity? = V3KeySecurity.uNKNOWN,

    @Json(name = "photos")
    val photos: EndDeviceModelPhotos? = null,

    @Json(name = "videos")
    val videos: EndDeviceModelVideos? = null,

    /* Device information page URL. */
    @Json(name = "product_url")
    val productUrl: kotlin.String? = null,

    /* Device datasheet URL. */
    @Json(name = "datasheet_url")
    val datasheetUrl: kotlin.String? = null,

    /* Reseller URLs. */
    @Json(name = "resellers")
    val resellers: kotlin.collections.List<EndDeviceModelReseller>? = null,

    @Json(name = "compliances")
    val compliances: EndDeviceModelCompliances? = null,

    /* List of any additional radios included in the device. */
    @Json(name = "additional_radios")
    val additionalRadios: kotlin.collections.List<kotlin.String>? = null

)

