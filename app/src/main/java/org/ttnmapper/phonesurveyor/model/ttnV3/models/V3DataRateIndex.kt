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
* Values: _0,_1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13,_14,_15
*/

enum class V3DataRateIndex(val value: kotlin.String){


    @Json(name = "DATA_RATE_0")
    _0("DATA_RATE_0"),


    @Json(name = "DATA_RATE_1")
    _1("DATA_RATE_1"),


    @Json(name = "DATA_RATE_2")
    _2("DATA_RATE_2"),


    @Json(name = "DATA_RATE_3")
    _3("DATA_RATE_3"),


    @Json(name = "DATA_RATE_4")
    _4("DATA_RATE_4"),


    @Json(name = "DATA_RATE_5")
    _5("DATA_RATE_5"),


    @Json(name = "DATA_RATE_6")
    _6("DATA_RATE_6"),


    @Json(name = "DATA_RATE_7")
    _7("DATA_RATE_7"),


    @Json(name = "DATA_RATE_8")
    _8("DATA_RATE_8"),


    @Json(name = "DATA_RATE_9")
    _9("DATA_RATE_9"),


    @Json(name = "DATA_RATE_10")
    _10("DATA_RATE_10"),


    @Json(name = "DATA_RATE_11")
    _11("DATA_RATE_11"),


    @Json(name = "DATA_RATE_12")
    _12("DATA_RATE_12"),


    @Json(name = "DATA_RATE_13")
    _13("DATA_RATE_13"),


    @Json(name = "DATA_RATE_14")
    _14("DATA_RATE_14"),


    @Json(name = "DATA_RATE_15")
    _15("DATA_RATE_15");



    /**
    This override toString avoids using the enum var name and uses the actual api value instead.
    In cases the var name and value are different, the client would send incorrect enums to the server.
    **/
    override fun toString(): String {
        return value
    }

}

