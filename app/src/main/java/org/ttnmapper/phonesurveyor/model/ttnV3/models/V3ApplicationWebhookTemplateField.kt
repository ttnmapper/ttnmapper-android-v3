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


import com.squareup.moshi.Json

/**
 * ApplicationWebhookTemplateField represents a custom field that needs to be filled by the user in order to use the template. A field can be an API key, an username or password, or any custom platform specific field (such as region). The fields are meant to be replaced inside the URLs and headers when the webhook is created.
 * @param id 
 * @param name 
 * @param description 
 * @param secret Secret decides if the field should be shown in plain-text or should stay hidden.
 * @param defaultValue 
 */

data class V3ApplicationWebhookTemplateField (
    @Json(name = "id")
    val id: kotlin.String? = null,
    @Json(name = "name")
    val name: kotlin.String? = null,
    @Json(name = "description")
    val description: kotlin.String? = null,
    /* Secret decides if the field should be shown in plain-text or should stay hidden. */
    @Json(name = "secret")
    val secret: kotlin.Boolean? = null,
    @Json(name = "default_value")
    val defaultValue: kotlin.String? = null
)

