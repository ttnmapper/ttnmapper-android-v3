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
 * 
 * @param key The unencrypted AES key.
 * @param kekLabel The label of the RFC 3394 key-encryption-key (KEK) that was used to encrypt the key.
 * @param encryptedKey 
 */

data class V3KeyEnvelope (
    /* The unencrypted AES key. */
    @Json(name = "key")
    val key: kotlin.ByteArray? = null,
    /* The label of the RFC 3394 key-encryption-key (KEK) that was used to encrypt the key. */
    @Json(name = "kek_label")
    val kekLabel: kotlin.String? = null,
    @Json(name = "encrypted_key")
    val encryptedKey: kotlin.ByteArray? = null
)
