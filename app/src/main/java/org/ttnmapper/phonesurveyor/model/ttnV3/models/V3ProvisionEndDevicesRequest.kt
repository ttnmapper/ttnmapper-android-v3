/**
* The Things Stack for LoRaWAN v3 API
* No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
*
* The version of the OpenAPI document: version not set
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package org.openapitools.client.models

import org.openapitools.client.models.ProvisionEndDevicesRequestIdentifiersFromData
import org.openapitools.client.models.ProvisionEndDevicesRequestIdentifiersList
import org.openapitools.client.models.ProvisionEndDevicesRequestIdentifiersRange
import org.openapitools.client.models.V3ApplicationIdentifiers

import com.squareup.moshi.Json

/**
 * 
 * @param applicationIds 
 * @param provisionerId ID of the provisioner service as configured in the Join Server.
 * @param provisioningData Vendor-specific provisioning data.
 * @param list 
 * @param range 
 * @param fromData 
 */

data class V3ProvisionEndDevicesRequest (
    @Json(name = "application_ids")
    val applicationIds: V3ApplicationIdentifiers? = null,
    /* ID of the provisioner service as configured in the Join Server. */
    @Json(name = "provisioner_id")
    val provisionerId: kotlin.String? = null,
    /* Vendor-specific provisioning data. */
    @Json(name = "provisioning_data")
    val provisioningData: kotlin.ByteArray? = null,
    @Json(name = "list")
    val list: ProvisionEndDevicesRequestIdentifiersList? = null,
    @Json(name = "range")
    val range: ProvisionEndDevicesRequestIdentifiersRange? = null,
    @Json(name = "from_data")
    val fromData: ProvisionEndDevicesRequestIdentifiersFromData? = null
)

