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

/**
 * 
 *
 * Values: oTHER,eMAIL,pHONE
 */

enum class V3ContactMethod(val value: kotlin.String) {

    @Json(name = "CONTACT_METHOD_OTHER")
    oTHER("CONTACT_METHOD_OTHER"),

    @Json(name = "CONTACT_METHOD_EMAIL")
    eMAIL("CONTACT_METHOD_EMAIL"),

    @Json(name = "CONTACT_METHOD_PHONE")
    pHONE("CONTACT_METHOD_PHONE");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is V3ContactMethod) "$data" else null

        /**
         * Returns a valid [V3ContactMethod] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): V3ContactMethod? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

