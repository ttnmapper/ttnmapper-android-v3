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

import org.openapitools.client.models.V3Client
import org.openapitools.client.models.V3OrganizationOrUserIdentifiers

import com.squareup.moshi.Json

/**
 * 
 * @param client 
 * @param collaborator 
 */

data class V3CreateClientRequest (
    @Json(name = "client")
    val client: V3Client? = null,
    @Json(name = "collaborator")
    val collaborator: V3OrganizationOrUserIdentifiers? = null
)

