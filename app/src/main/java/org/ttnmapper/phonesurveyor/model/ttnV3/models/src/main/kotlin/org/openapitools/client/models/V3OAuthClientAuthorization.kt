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

import org.openapitools.client.models.V3ClientIdentifiers
import org.openapitools.client.models.V3Right
import org.openapitools.client.models.V3UserIdentifiers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param userIds 
 * @param clientIds 
 * @param rights 
 * @param createdAt 
 * @param updatedAt 
 */
@JsonClass(generateAdapter = true)
data class V3OAuthClientAuthorization (

    @Json(name = "user_ids")
    val userIds: V3UserIdentifiers? = null,

    @Json(name = "client_ids")
    val clientIds: V3ClientIdentifiers? = null,

    @Json(name = "rights")
    val rights: kotlin.collections.List<V3Right>? = null,

    @Json(name = "created_at")
    val createdAt: java.time.OffsetDateTime? = null,

    @Json(name = "updated_at")
    val updatedAt: java.time.OffsetDateTime? = null

)
