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

import org.openapitools.client.models.V3Class
import org.openapitools.client.models.V3DataRateIndex
import org.openapitools.client.models.V3DownlinkPath
import org.openapitools.client.models.V3RxDelay
import org.openapitools.client.models.V3TxSchedulePriority

import com.squareup.moshi.Json

/**
 * TxRequest is a request for transmission. If sent to a roaming partner, this request is used to generate the DLMetadata Object (see Backend Interfaces 1.0, Table 22). If the gateway has a scheduler, this request is sent to the gateway, in the order of gateway_ids. Otherwise, the Gateway Server attempts to schedule the request and creates the TxSettings.
 * @param propertyClass 
 * @param downlinkPaths Downlink paths used to select a gateway for downlink. In class A, the downlink paths are required to only contain uplink tokens. In class B and C, the downlink paths may contain uplink tokens and fixed gateways antenna identifiers.
 * @param rx1Delay 
 * @param rx1DataRateIndex 
 * @param rx1Frequency Frequency (Hz) for Rx1.
 * @param rx2DataRateIndex 
 * @param rx2Frequency Frequency (Hz) for Rx2.
 * @param priority 
 * @param absoluteTime Time when the downlink message should be transmitted. This value is only valid for class C downlink; class A downlink uses uplink tokens and class B downlink is scheduled on ping slots. This requires the gateway to have GPS time sychronization. If the absolute time is not set, the first available time will be used that does not conflict or violate regional limitations.
 * @param frequencyPlanId Frequency plan ID from which the frequencies in this message are retrieved.
 * @param advanced 
 */

data class V3TxRequest (
    @Json(name = "class")
    val propertyClass: V3Class? = null,
    /* Downlink paths used to select a gateway for downlink. In class A, the downlink paths are required to only contain uplink tokens. In class B and C, the downlink paths may contain uplink tokens and fixed gateways antenna identifiers. */
    @Json(name = "downlink_paths")
    val downlinkPaths: kotlin.collections.List<V3DownlinkPath>? = null,
    @Json(name = "rx1_delay")
    val rx1Delay: V3RxDelay? = null,
    @Json(name = "rx1_data_rate_index")
    val rx1DataRateIndex: V3DataRateIndex? = null,
    /* Frequency (Hz) for Rx1. */
    @Json(name = "rx1_frequency")
    val rx1Frequency: kotlin.String? = null,
    @Json(name = "rx2_data_rate_index")
    val rx2DataRateIndex: V3DataRateIndex? = null,
    /* Frequency (Hz) for Rx2. */
    @Json(name = "rx2_frequency")
    val rx2Frequency: kotlin.String? = null,
    @Json(name = "priority")
    val priority: V3TxSchedulePriority? = null,
    /* Time when the downlink message should be transmitted. This value is only valid for class C downlink; class A downlink uses uplink tokens and class B downlink is scheduled on ping slots. This requires the gateway to have GPS time sychronization. If the absolute time is not set, the first available time will be used that does not conflict or violate regional limitations. */
    @Json(name = "absolute_time")
    val absoluteTime: java.time.OffsetDateTime? = null,
    /* Frequency plan ID from which the frequencies in this message are retrieved. */
    @Json(name = "frequency_plan_id")
    val frequencyPlanId: kotlin.String? = null,
    @Json(name = "advanced")
    val advanced: kotlin.Any? = null
)
