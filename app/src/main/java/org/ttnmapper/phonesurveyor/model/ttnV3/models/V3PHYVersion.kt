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
* Values: uNKNOWN,v10,v101,v102REVA,v102REVB,v11REVA,v11REVB,v103REVA
*/

enum class V3PHYVersion(val value: kotlin.String){


    @Json(name = "PHY_UNKNOWN")
    uNKNOWN("PHY_UNKNOWN"),


    @Json(name = "PHY_V1_0")
    v10("PHY_V1_0"),


    @Json(name = "PHY_V1_0_1")
    v101("PHY_V1_0_1"),


    @Json(name = "PHY_V1_0_2_REV_A")
    v102REVA("PHY_V1_0_2_REV_A"),


    @Json(name = "PHY_V1_0_2_REV_B")
    v102REVB("PHY_V1_0_2_REV_B"),


    @Json(name = "PHY_V1_1_REV_A")
    v11REVA("PHY_V1_1_REV_A"),


    @Json(name = "PHY_V1_1_REV_B")
    v11REVB("PHY_V1_1_REV_B"),


    @Json(name = "PHY_V1_0_3_REV_A")
    v103REVA("PHY_V1_0_3_REV_A");



    /**
    This override toString avoids using the enum var name and uses the actual api value instead.
    In cases the var name and value are different, the client would send incorrect enums to the server.
    **/
    override fun toString(): String {
        return value
    }

}
