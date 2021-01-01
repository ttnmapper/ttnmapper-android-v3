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

import org.openapitools.client.models.Lorawanv3Location

import com.squareup.moshi.Json

/**
 * 
 * @param time 
 * @param bootTime 
 * @param versions 
 * @param antennaLocations 
 * @param ip IP addresses of this gateway. Repeated addresses can be used to communicate addresses of multiple interfaces (LAN, Public IP, ...).
 * @param metrics 
 * @param advanced 
 */

data class V3GatewayStatus (
    @Json(name = "time")
    val time: java.time.OffsetDateTime? = null,
    @Json(name = "boot_time")
    val bootTime: java.time.OffsetDateTime? = null,
    @Json(name = "versions")
    val versions: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,
    @Json(name = "antenna_locations")
    val antennaLocations: kotlin.collections.List<Lorawanv3Location>? = null,
    /* IP addresses of this gateway. Repeated addresses can be used to communicate addresses of multiple interfaces (LAN, Public IP, ...). */
    @Json(name = "ip")
    val ip: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "metrics")
    val metrics: kotlin.collections.Map<kotlin.String, kotlin.Float>? = null,
    @Json(name = "advanced")
    val advanced: kotlin.Any? = null
)
