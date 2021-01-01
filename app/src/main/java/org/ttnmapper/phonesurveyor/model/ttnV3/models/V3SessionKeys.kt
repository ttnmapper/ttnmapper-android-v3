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

import org.openapitools.client.models.V3KeyEnvelope

import com.squareup.moshi.Json

/**
 * Session keys for a LoRaWAN session. Only the components for which the keys were meant, will have the key-encryption-key (KEK) to decrypt the individual keys.
 * @param sessionKeyId Join Server issued identifier for the session keys. This ID can be used to request the keys from the Join Server in case the are lost.
 * @param fNwkSIntKey 
 * @param sNwkSIntKey 
 * @param nwkSEncKey 
 * @param appSKey 
 */

data class V3SessionKeys (
    /* Join Server issued identifier for the session keys. This ID can be used to request the keys from the Join Server in case the are lost. */
    @Json(name = "session_key_id")
    val sessionKeyId: kotlin.ByteArray? = null,
    @Json(name = "f_nwk_s_int_key")
    val fNwkSIntKey: V3KeyEnvelope? = null,
    @Json(name = "s_nwk_s_int_key")
    val sNwkSIntKey: V3KeyEnvelope? = null,
    @Json(name = "nwk_s_enc_key")
    val nwkSEncKey: V3KeyEnvelope? = null,
    @Json(name = "app_s_key")
    val appSKey: V3KeyEnvelope? = null
)
