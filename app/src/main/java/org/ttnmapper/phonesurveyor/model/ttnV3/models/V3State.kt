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
* State enum defines states that an entity can be in.   - STATE_REQUESTED: Denotes that the entity has been requested and is pending review by an admin.  - STATE_APPROVED: Denotes that the entity has been reviewed and approved by an admin.  - STATE_REJECTED: Denotes that the entity has been reviewed and rejected by an admin.  - STATE_FLAGGED: Denotes that the entity has been flagged and is pending review by an admin.  - STATE_SUSPENDED: Denotes that the entity has been reviewed and suspended by an admin.
* Values: rEQUESTED,aPPROVED,rEJECTED,fLAGGED,sUSPENDED
*/

enum class V3State(val value: kotlin.String){


    @Json(name = "STATE_REQUESTED")
    rEQUESTED("STATE_REQUESTED"),


    @Json(name = "STATE_APPROVED")
    aPPROVED("STATE_APPROVED"),


    @Json(name = "STATE_REJECTED")
    rEJECTED("STATE_REJECTED"),


    @Json(name = "STATE_FLAGGED")
    fLAGGED("STATE_FLAGGED"),


    @Json(name = "STATE_SUSPENDED")
    sUSPENDED("STATE_SUSPENDED");



    /**
    This override toString avoids using the enum var name and uses the actual api value instead.
    In cases the var name and value are different, the client would send incorrect enums to the server.
    **/
    override fun toString(): String {
        return value
    }

}

