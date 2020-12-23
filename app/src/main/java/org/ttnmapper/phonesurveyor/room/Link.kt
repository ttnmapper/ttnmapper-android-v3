package org.ttnmapper.phonesurveyor.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Link(
        @PrimaryKey(autoGenerate = true)
        val uid: Int = 0,

        @ColumnInfo(name = "app_id")
        var appId: String? = null, // jpm_sodaq_one
        @ColumnInfo(name = "dev_id")
        var devId: String? = null, // sodaq-one-v3-box
        @ColumnInfo(name = "hardware_serial")
        var hardwareSerial: String? = null, // 0004A30B00200CA5
        @ColumnInfo(name = "port")
        var fPort: Int? = null, // 1
        @ColumnInfo(name = "counter")
        var fCnt: Int? = null, // 347

        // Metadata
        @ColumnInfo(name = "time")
        var time: String? = null, // 2018-03-18T10:05:45.391032906Z
        @ColumnInfo(name = "frequency")
        var frequency: Double? = null, // 868.5
        @ColumnInfo(name = "modulation")
        var modulation: String? = null, // LORA
        @ColumnInfo(name = "data_rate")
        var dataRate: String? = null, // SF7BW125
        @ColumnInfo(name = "bit_rate")
        var bitrate: Int? = null,
        @ColumnInfo(name = "coding_rate")
        var codingRate: String? = null, // 4/5

        // Device Location Metadata
        @ColumnInfo(name = "dev_latitude")
        var devLatitude: Double? = null,
        @ColumnInfo(name = "dev_longitude")
        var devLongitude: Double? = null,
        @ColumnInfo(name = "dev_altitude")
        var devAltitude: Int? = null,
        @ColumnInfo(name = "dev_location_accuracy")
        var devLocationAccuracy: Int? = null,
        @ColumnInfo(name = "dev_location_source")
        var devLocationSource: String? = null,

        // If multiple gateways, store signal for strongest
        @ColumnInfo(name = "max_signal")
        var maxSignal: Double? = null,

        // Gateway
        @ColumnInfo(name = "gtw_id")
        var gtwId: String? = null, // eui-88c255fffe6dfb04
        @ColumnInfo(name = "antenna")
        var antenna: Int? = null,
        @ColumnInfo(name = "channel")
        var channel: Int? = null, // 2
        @ColumnInfo(name = "rssi")
        var rssi: Double? = null, // -95
        @ColumnInfo(name = "snr")
        var snr: Double? = null, // 6.8
        @ColumnInfo(name = "rf_chain")
        var rfChain: Int? = null, // 1

        // Gateway Location Metadata
        @ColumnInfo(name = "gtw_latitude")
        var gtwLatitude: Double? = null,
        @ColumnInfo(name = "gtw_longitude")
        var gtwLongitude: Double? = null,
        @ColumnInfo(name = "gtw_altitude")
        var gtwAltitude: Int? = null,
        @ColumnInfo(name = "gw_location_accuracy")
        var gtwLocationAccuracy: Int? = null,
        @ColumnInfo(name = "gw_location_source")
        var gtwLocationSource: String? = null,

        // Custom attributes for ttn mapper
        @ColumnInfo(name = "phone_lat")
        var phoneLat: Double? = null, // -34.0484124
        @ColumnInfo(name = "phone_lon")
        var phoneLon: Double? = null, // 18.8214014
        @ColumnInfo(name = "phone_alt")
        var phoneAlt: Double? = null, // 184.9958825503345
        @ColumnInfo(name = "phone_loc_acc")
        var phoneLocAcc: Double? = null, // 10
        @ColumnInfo(name = "phone_loc_provider")
        var phoneLocProvider: String? = null, // fused
        @ColumnInfo(name = "phone_loc_time")
        var phoneLocTime: Long? = null, // 2018-03-18T10:05:44Z
        @ColumnInfo(name = "phone_time")
        var phoneTime: String? = null, // 2018-03-18T10:05:44Z
        @ColumnInfo(name = "user_agent")
        var userAgent: String? = null, // Android7.0 App30:2018.03.04
        @ColumnInfo(name = "iid")
        var iid: String? = null, //some random number
        @ColumnInfo(name = "experiment")
        var experiment: String? = null // experiment name
)