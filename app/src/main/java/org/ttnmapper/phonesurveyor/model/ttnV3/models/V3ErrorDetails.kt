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

import org.openapitools.client.models.ProtobufAny

import com.squareup.moshi.Json

/**
 * Error details that are communicated over gRPC (and HTTP) APIs. The messages (for translation) are stored as \"error:<namespace>:<name>\".
 * @param namespace Namespace of the error (typically the package name in The Things Stack).
 * @param name Name of the error.
 * @param messageFormat The default (fallback) message format that should be used for the error. This is also used if the client does not have a translation for the error.
 * @param attributes Attributes that should be filled into the message format. Any extra attributes can be displayed as error details.
 * @param correlationId The correlation ID of the error can be used to correlate the error to stack traces the network may (or may not) store about recent errors.
 * @param cause 
 * @param code The status code of the error.
 * @param details The details of the error.
 */

data class V3ErrorDetails (
    /* Namespace of the error (typically the package name in The Things Stack). */
    @Json(name = "namespace")
    val namespace: kotlin.String? = null,
    /* Name of the error. */
    @Json(name = "name")
    val name: kotlin.String? = null,
    /* The default (fallback) message format that should be used for the error. This is also used if the client does not have a translation for the error. */
    @Json(name = "message_format")
    val messageFormat: kotlin.String? = null,
    /* Attributes that should be filled into the message format. Any extra attributes can be displayed as error details. */
    @Json(name = "attributes")
    val attributes: kotlin.Any? = null,
    /* The correlation ID of the error can be used to correlate the error to stack traces the network may (or may not) store about recent errors. */
    @Json(name = "correlation_id")
    val correlationId: kotlin.String? = null,
    @Json(name = "cause")
    val cause: V3ErrorDetails? = null,
    /* The status code of the error. */
    @Json(name = "code")
    val code: kotlin.Long? = null,
    /* The details of the error. */
    @Json(name = "details")
    val details: kotlin.collections.List<ProtobufAny>? = null
)

