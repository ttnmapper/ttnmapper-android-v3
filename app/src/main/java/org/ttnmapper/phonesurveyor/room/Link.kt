package org.ttnmapper.phonesurveyor.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Link(
        @PrimaryKey(autoGenerate = true)
        val uid: Int = 0,

        var session: String = "",

        var appId: String? = null, // jpm_sodaq_one
        var devId: String? = null, // sodaq-one-v3-box
        var hardwareSerial: String? = null, // 0004A30B00200CA5
        var fPort: Int? = null, // 1
        var fCnt: Int? = null, // 347

        // Metadata
        var time: String? = null, // 2018-03-18T10:05:45.391032906Z
        var frequency: Double? = null, // 868.5
        var modulation: String? = null, // LORA
        var dataRate: String? = null, // SF7BW125
        var bitrate: Int? = null,
        var codingRate: String? = null, // 4/5

        // Device Location Metadata
        var devLatitude: Double? = null,
        var devLongitude: Double? = null,
        var devAltitude: Int? = null,
        var devLocationAccuracy: Int? = null,
        var devLocationSource: String? = null,

        // If multiple gateways, store signal for strongest
        var maxSignal: Double? = null,

        // Gateway
        var gtwId: String? = null, // eui-88c255fffe6dfb04
        var antenna: Int? = null,
        var channel: Int? = null, // 2
        var rssi: Double? = null, // -95
        var snr: Double? = null, // 6.8
        var rfChain: Int? = null, // 1

        // Gateway Location Metadata
        var gtwLatitude: Double? = null,
        var gtwLongitude: Double? = null,
        var gtwAltitude: Int? = null,
        var gtwLocationAccuracy: Int? = null,
        var gtwLocationSource: String? = null,

        // Custom attributes for ttn mapper
        var phoneLat: Double? = null, // -34.0484124
        var phoneLon: Double? = null, // 18.8214014
        var phoneAlt: Double? = null, // 184.9958825503345
        var phoneLocAcc: Double? = null, // 10
        var phoneLocProvider: String? = null, // fused
        var phoneLocTime: String? = null, // 2018-03-18T10:05:44Z
        var phoneTime: String? = null, // 2018-03-18T10:05:44Z
        var userAgent: String? = null, // Android7.0 App30:2018.03.04
        var iid: String? = null, //some random number
        var experiment: String? = null // experiment name
)