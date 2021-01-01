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

import org.openapitools.client.models.V3ContactInfo
import org.openapitools.client.models.V3EntityIdentifiers

import com.squareup.moshi.Json

/**
 * 
 * @param id 
 * @param token 
 * @param entity 
 * @param contactInfo 
 * @param createdAt 
 * @param expiresAt 
 */

data class Lorawanv3ContactInfoValidation (
    @Json(name = "id")
    val id: kotlin.String? = null,
    @Json(name = "token")
    val token: kotlin.String? = null,
    @Json(name = "entity")
    val entity: V3EntityIdentifiers? = null,
    @Json(name = "contact_info")
    val contactInfo: kotlin.collections.List<V3ContactInfo>? = null,
    @Json(name = "created_at")
    val createdAt: java.time.OffsetDateTime? = null,
    @Json(name = "expires_at")
    val expiresAt: java.time.OffsetDateTime? = null
)
