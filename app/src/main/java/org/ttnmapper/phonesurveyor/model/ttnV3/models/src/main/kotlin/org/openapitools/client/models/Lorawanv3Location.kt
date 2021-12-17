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

import org.openapitools.client.models.V3LocationSource

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param latitude The North–South position (degrees; -90 to +90), where 0 is the equator, North pole is positive, South pole is negative.
 * @param longitude The East-West position (degrees; -180 to +180), where 0 is the Prime Meridian (Greenwich), East is positive , West is negative.
 * @param altitude The altitude (meters), where 0 is the mean sea level.
 * @param accuracy The accuracy of the location (meters).
 * @param source 
 */
@JsonClass(generateAdapter = true)
data class Lorawanv3Location (

    /* The North–South position (degrees; -90 to +90), where 0 is the equator, North pole is positive, South pole is negative. */
    @Json(name = "latitude")
    val latitude: kotlin.Double? = null,

    /* The East-West position (degrees; -180 to +180), where 0 is the Prime Meridian (Greenwich), East is positive , West is negative. */
    @Json(name = "longitude")
    val longitude: kotlin.Double? = null,

    /* The altitude (meters), where 0 is the mean sea level. */
    @Json(name = "altitude")
    val altitude: kotlin.Int? = null,

    /* The accuracy of the location (meters). */
    @Json(name = "accuracy")
    val accuracy: kotlin.Int? = null,

    @Json(name = "source")
    val source: V3LocationSource? = V3LocationSource.uNKNOWN

)

