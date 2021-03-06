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

enum class V3AggregatedDutyCycle(val value: kotlin.String){


    @Json(name = "DUTY_CYCLE_1")
    _1("DUTY_CYCLE_1"),


    @Json(name = "DUTY_CYCLE_2")
    _2("DUTY_CYCLE_2"),


    @Json(name = "DUTY_CYCLE_4")
    _4("DUTY_CYCLE_4"),


    @Json(name = "DUTY_CYCLE_8")
    _8("DUTY_CYCLE_8"),


    @Json(name = "DUTY_CYCLE_16")
    _16("DUTY_CYCLE_16"),


    @Json(name = "DUTY_CYCLE_32")
    _32("DUTY_CYCLE_32"),


    @Json(name = "DUTY_CYCLE_64")
    _64("DUTY_CYCLE_64"),


    @Json(name = "DUTY_CYCLE_128")
    _128("DUTY_CYCLE_128"),


    @Json(name = "DUTY_CYCLE_256")
    _256("DUTY_CYCLE_256"),


    @Json(name = "DUTY_CYCLE_512")
    _512("DUTY_CYCLE_512"),


    @Json(name = "DUTY_CYCLE_1024")
    _1024("DUTY_CYCLE_1024"),


    @Json(name = "DUTY_CYCLE_2048")
    _2048("DUTY_CYCLE_2048"),


    @Json(name = "DUTY_CYCLE_4096")
    _4096("DUTY_CYCLE_4096"),


    @Json(name = "DUTY_CYCLE_8192")
    _8192("DUTY_CYCLE_8192"),


    @Json(name = "DUTY_CYCLE_16384")
    _16384("DUTY_CYCLE_16384"),


    @Json(name = "DUTY_CYCLE_32768")
    _32768("DUTY_CYCLE_32768");



    /**
    This override toString avoids using the enum var name and uses the actual api value instead.
    In cases the var name and value are different, the client would send incorrect enums to the server.
    **/
    override fun toString(): String {
        return value
    }

}

