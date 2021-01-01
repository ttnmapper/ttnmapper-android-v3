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
*  - SOURCE_UNKNOWN: The source of the location is not known or not set.  - SOURCE_GPS: The location is determined by GPS.  - SOURCE_REGISTRY: The location is set in and updated from a registry.  - SOURCE_IP_GEOLOCATION: The location is estimated with IP geolocation.  - SOURCE_WIFI_RSSI_GEOLOCATION: The location is estimated with WiFi RSSI geolocation.  - SOURCE_BT_RSSI_GEOLOCATION: The location is estimated with BT/BLE RSSI geolocation.  - SOURCE_LORA_RSSI_GEOLOCATION: The location is estimated with LoRa RSSI geolocation.  - SOURCE_LORA_TDOA_GEOLOCATION: The location is estimated with LoRa TDOA geolocation.  - SOURCE_COMBINED_GEOLOCATION: The location is estimated by a combination of geolocation sources.
* Values: uNKNOWN,gPS,rEGISTRY,iPGEOLOCATION,wIFIRSSIGEOLOCATION,bTRSSIGEOLOCATION,lORARSSIGEOLOCATION,lORATDOAGEOLOCATION,cOMBINEDGEOLOCATION
*/

enum class V3LocationSource(val value: kotlin.String){


    @Json(name = "SOURCE_UNKNOWN")
    uNKNOWN("SOURCE_UNKNOWN"),


    @Json(name = "SOURCE_GPS")
    gPS("SOURCE_GPS"),


    @Json(name = "SOURCE_REGISTRY")
    rEGISTRY("SOURCE_REGISTRY"),


    @Json(name = "SOURCE_IP_GEOLOCATION")
    iPGEOLOCATION("SOURCE_IP_GEOLOCATION"),


    @Json(name = "SOURCE_WIFI_RSSI_GEOLOCATION")
    wIFIRSSIGEOLOCATION("SOURCE_WIFI_RSSI_GEOLOCATION"),


    @Json(name = "SOURCE_BT_RSSI_GEOLOCATION")
    bTRSSIGEOLOCATION("SOURCE_BT_RSSI_GEOLOCATION"),


    @Json(name = "SOURCE_LORA_RSSI_GEOLOCATION")
    lORARSSIGEOLOCATION("SOURCE_LORA_RSSI_GEOLOCATION"),


    @Json(name = "SOURCE_LORA_TDOA_GEOLOCATION")
    lORATDOAGEOLOCATION("SOURCE_LORA_TDOA_GEOLOCATION"),


    @Json(name = "SOURCE_COMBINED_GEOLOCATION")
    cOMBINEDGEOLOCATION("SOURCE_COMBINED_GEOLOCATION");



    /**
    This override toString avoids using the enum var name and uses the actual api value instead.
    In cases the var name and value are different, the client would send incorrect enums to the server.
    **/
    override fun toString(): String {
        return value
    }

}
