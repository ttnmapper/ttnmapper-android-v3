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

import org.openapitools.client.models.V3PHYVersion

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param bandId 
 * @param phyVersions 
 */
@JsonClass(generateAdapter = true)
data class GetPhyVersionsResponseVersionInfo (

    @Json(name = "band_id")
    val bandId: kotlin.String? = null,

    @Json(name = "phy_versions")
    val phyVersions: kotlin.collections.List<V3PHYVersion>? = null

)

