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
* Values: _1,_2,_4,_8,_16,_32,_64,_128,_256,_512,_1024,_2048,_4096,_8192,_16384,_32768
*/

enum class V3ADRAckDelayExponent(val value: kotlin.String){


    @Json(name = "ADR_ACK_DELAY_1")
    _1("ADR_ACK_DELAY_1"),


    @Json(name = "ADR_ACK_DELAY_2")
    _2("ADR_ACK_DELAY_2"),


    @Json(name = "ADR_ACK_DELAY_4")
    _4("ADR_ACK_DELAY_4"),


    @Json(name = "ADR_ACK_DELAY_8")
    _8("ADR_ACK_DELAY_8"),


    @Json(name = "ADR_ACK_DELAY_16")
    _16("ADR_ACK_DELAY_16"),


    @Json(name = "ADR_ACK_DELAY_32")
    _32("ADR_ACK_DELAY_32"),


    @Json(name = "ADR_ACK_DELAY_64")
    _64("ADR_ACK_DELAY_64"),


    @Json(name = "ADR_ACK_DELAY_128")
    _128("ADR_ACK_DELAY_128"),


    @Json(name = "ADR_ACK_DELAY_256")
    _256("ADR_ACK_DELAY_256"),


    @Json(name = "ADR_ACK_DELAY_512")
    _512("ADR_ACK_DELAY_512"),


    @Json(name = "ADR_ACK_DELAY_1024")
    _1024("ADR_ACK_DELAY_1024"),


    @Json(name = "ADR_ACK_DELAY_2048")
    _2048("ADR_ACK_DELAY_2048"),


    @Json(name = "ADR_ACK_DELAY_4096")
    _4096("ADR_ACK_DELAY_4096"),


    @Json(name = "ADR_ACK_DELAY_8192")
    _8192("ADR_ACK_DELAY_8192"),


    @Json(name = "ADR_ACK_DELAY_16384")
    _16384("ADR_ACK_DELAY_16384"),


    @Json(name = "ADR_ACK_DELAY_32768")
    _32768("ADR_ACK_DELAY_32768");



    /**
    This override toString avoids using the enum var name and uses the actual api value instead.
    In cases the var name and value are different, the client would send incorrect enums to the server.
    **/
    override fun toString(): String {
        return value
    }

}

