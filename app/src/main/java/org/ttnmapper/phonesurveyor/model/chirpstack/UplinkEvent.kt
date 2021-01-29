package org.ttnmapper.phonesurveyor.model.chirpstack

import com.squareup.moshi.JsonClass

// {"applicationID":"1","applicationName":"test-application","deviceName":"test-device","devEUI":"0004a30b001c684f",
// "rxInfo":[{"gatewayID":"3133303748005c00","uplinkID":"43028b8a-b736-4713-82ee-4f351d13b671","name":"mikrotik","time":"2020-12-28T16:07:54.922898Z","rssi":-102,"loRaSNR":6.5,"location":{"latitude":-33.9586553,"longitude":22.441055499999997,"altitude":200}}],
// "txInfo":{"frequency":868100000,"dr":5},"adr":true,"fCnt":1232,"fPort":1,"data":"AA=="}

@JsonClass(generateAdapter = true)
class UplinkEvent {
    var applicationID: Long? = null
    var applicationName: String? = null
    var deviceName: String? = null
    var devEUI: String? = null
    var rxInfo: Array<UplinkRXInfo>? = null
    var txInfo: UplinkTXInfo? = null
    var adr: Boolean? = null
    var fCnt: Int? = null
    var fPort: Int? = null
    var data: String? = null
}