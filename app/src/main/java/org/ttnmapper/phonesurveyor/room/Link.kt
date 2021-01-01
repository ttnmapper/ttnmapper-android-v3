package org.ttnmapper.phonesurveyor.room

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = arrayOf(Index(value = ["Session"])))
data class Link(
        @PrimaryKey(autoGenerate = true)
        val uid: Int = 0,

        var Session: String = "",

        var AppID:  String? = null,
        var DevID:  String? = null,
        var DevEui: String? = null,

        var Time: Long? = null,

        var FPort: Int? = null,
        var FCnt:  Long? = null,

        var Frequency: Long? = null,
        var Modulation: String? = null,
        var Bandwidth: Long? = null,
        var SpreadingFactor: Int? = null,
        var Bitrate: Long? = null,
        var CodingRate: String? = null,

        // Gateway
        var GatewayId: String? = null,
        var GatewayEui: String? = null,
        var AntennaIndex: Int? = null,
        var GatewayTime: Long? = null,
        var GatewayTimestamp: Long? = null,
        var FineTimestamp: Long? = null,
        var FineTimestampEncrypted: String? = null,
        var FineTimestampEncryptedKeyId: String? = null,
        var ChannelIndex: Int? = null,
        var Rssi: Double? = null,
        var SignalRssi: Double? = null,
        var Snr: Double? = null,
        var GatewayLatitude: Double? = null,
        var GatewayLongitude: Double? = null,
        var GatewayAltitude: Double? = null,
        var GatewayLocationAccuracy: Double? = null,
        var GatewayLocationSource: String? = null,

        var Latitude: Double? = null,
        var Longitude: Double? = null,
        var Altitude: Double? = null,
        var AccuracyMeters: Double? = null,
        var Satellites: Int? = null,
        var Hdop: Double? = null,
        var AccuracySource: String? = null,

        var Experiment: String? = null,
        var UserId: String? = null,
        var UserAgent: String? = null,
)