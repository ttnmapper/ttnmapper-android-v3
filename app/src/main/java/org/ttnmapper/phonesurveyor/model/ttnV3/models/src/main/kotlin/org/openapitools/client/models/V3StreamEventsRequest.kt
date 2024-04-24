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

import org.openapitools.client.models.V3EntityIdentifiers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param identifiers 
 * @param tail If greater than zero, this will return historical events, up to this maximum when the stream starts. If used in combination with \"after\", the limit that is reached first, is used. The availability of historical events depends on server support and retention policy.
 * @param after If not empty, this will return historical events after the given time when the stream starts. If used in combination with \"tail\", the limit that is reached first, is used. The availability of historical events depends on server support and retention policy.
 * @param names If provided, this will filter events, so that only events with the given names are returned. Names can be provided as either exact event names (e.g. 'gs.up.receive'), or as regular expressions (e.g. '/^gs\\..+/').
 */
@JsonClass(generateAdapter = true)
data class V3StreamEventsRequest (

    @Json(name = "identifiers")
    val identifiers: kotlin.collections.List<V3EntityIdentifiers>? = null,

    /* If greater than zero, this will return historical events, up to this maximum when the stream starts. If used in combination with \"after\", the limit that is reached first, is used. The availability of historical events depends on server support and retention policy. */
    @Json(name = "tail")
    val tail: kotlin.Long? = null,

    /* If not empty, this will return historical events after the given time when the stream starts. If used in combination with \"tail\", the limit that is reached first, is used. The availability of historical events depends on server support and retention policy. */
    @Json(name = "after")
    val after: java.time.OffsetDateTime? = null,

    /* If provided, this will filter events, so that only events with the given names are returned. Names can be provided as either exact event names (e.g. 'gs.up.receive'), or as regular expressions (e.g. '/^gs\\..+/'). */
    @Json(name = "names")
    val names: kotlin.collections.List<kotlin.String>? = null

)
