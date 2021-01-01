package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

@ExperimentalUnsignedTypes
data class TtnMapperGateway(
    @Json(name = "gtw_id")
    var GatewayId: String? = null,
    @Json(name = "gtw_eui")
    var GatewayEui: String? = null,
    @Json(name = "antenna_index")
    var AntennaIndex: UByte? = null,
    @Json(name = "time")
    var Time: Long? = null,
    @Json(name = "timestamp")
    var Timestamp: ULong? = null,
    @Json(name = "fine_timestamp")
    var FineTimestamp: ULong? = null,
    @Json(name = "fine_timestamp_encrypted")
    var FineTimestampEncrypted: List<Byte>? = null,
    @Json(name = "encrypted_fine_timestamp_key_id")
    var FineTimestampEncryptedKeyId: String? = null,
    @Json(name = "channel")
    var ChannelIndex: Int? = null,
    @Json(name = "rssi")
    var Rssi: Double? = null,
    @Json(name = "signal_rssi")
    var SignalRssi: Double? = null,
    @Json(name = "snr")
    var Snr: Double? = null,

    @Json(name = "latitude")
    var Latitude: Double? = null,
    @Json(name = "longitude")
    var Longitude: Double? = null,
    @Json(name = "altitude")
    var Altitude: Int? = null,
    @Json(name = "location_accuracy")
    var LocationAccuracy: Int? = null,

    // The source can be: gps, config, registry, ip_geolocation or unknown (unknown may be left out)
    // See TTNv3 proto definition for more info
    @Json(name = "location_source")
    var LocationSource: String? = null,
)
