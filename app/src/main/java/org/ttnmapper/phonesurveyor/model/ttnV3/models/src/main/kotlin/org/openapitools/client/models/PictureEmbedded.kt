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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param mimeType MIME type of the picture.
 * @param `data` Picture data. A data URI can be constructed as follows: `data:<mime_type>;base64,<data>`.
 */
@JsonClass(generateAdapter = true)
data class PictureEmbedded (

    /* MIME type of the picture. */
    @Json(name = "mime_type")
    val mimeType: kotlin.String? = null,

    /* Picture data. A data URI can be constructed as follows: `data:<mime_type>;base64,<data>`. */
    @Json(name = "data")
    val `data`: kotlin.ByteArray? = null

)

