package org.ttnmapper.phonesurveyor.model.chirpstack

// "rxInfo":[{"gatewayID":"3133303748005c00","uplinkID":"43028b8a-b736-4713-82ee-4f351d13b671",
// "name":"mikrotik","time":"2020-12-28T16:07:54.922898Z","rssi":-102,"loRaSNR":6.5,"location":{"latitude":-33.9586553,"longitude":22.441055499999997,"altitude":200}}],
class UplinkRXInfo {
    var gatewayID: String? = null
    var uplinkID: String? = null
    var name: String? = null
    var time: String? = null
    var time_since_gps_epoch: Long? = null
    var rssi: Int? = null
    var loRaSNR: Double? = null
    var channel: Int? = null
    var board: Int? = null
    var antenna: Int? = null
    var location: Location? = null
}