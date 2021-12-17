package org.ttnmapper.phonesurveyor.utils

import android.util.Base64
import org.openapitools.client.models.V3ApplicationUp
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.SurveyorApp
import org.ttnmapper.phonesurveyor.model.TtnMapperGateway
import org.ttnmapper.phonesurveyor.model.TtnMapperUplinkMessage
import org.ttnmapper.phonesurveyor.model.chirpstack.UplinkEvent
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import org.ttnmapper.phonesurveyor.room.Link
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getDateForISO8601String
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.toEuiString
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.toNetIdString
import java.util.*

class ObjectCopy {

    @ExperimentalUnsignedTypes
    companion object {
        private val TAG = ObjectCopy::class.java.getName()


        fun copyTtnToLink(sessionStart: Date, source: TtnMapperUplinkMessage, gateway: TtnMapperGateway): Link {
            val link = Link(uid=0, Session = CommonFunctions.getISO8601StringForDate(sessionStart))

            link.AppID = source.AppID
            link.DevID = source.DevID
            link.DevEui = source.DevEui

            // Metadata
            link.Time = source.Time

            link.FPort = source.FPort?.toInt()
            link.FCnt = source.FCnt
            link.Frequency = source.Frequency?.toLong()
            link.Modulation = source.Modulation
            link.Bandwidth = source.Bandwidth?.toLong()
            link.SpreadingFactor = source.SpreadingFactor?.toInt()
            link.Bitrate = source.Bitrate?.toLong()
            link.CodingRate = source.CodingRate

            // Gateway
            link.GatewayId = gateway.GatewayId
            link.AntennaIndex = gateway.AntennaIndex?.toInt()
            link.GatewayTime = gateway.Time
            link.GatewayTimestamp = gateway.Timestamp?.toLong()
            link.FineTimestamp = gateway.FineTimestamp?.toLong()
            if(gateway.FineTimestampEncrypted != null) {
                link.FineTimestampEncrypted = Base64.encodeToString(gateway.FineTimestampEncrypted?.toByteArray(), Base64.DEFAULT)
            }
            link.FineTimestampEncryptedKeyId = gateway.FineTimestampEncryptedKeyId

            link.ChannelIndex = gateway.ChannelIndex
            link.Rssi = gateway.Rssi
            link.SignalRssi = gateway.SignalRssi
            link.Snr = gateway.Snr

            // Gateway Location Metadata
            link.GatewayLatitude = gateway.Latitude
            link.GatewayLongitude = gateway.Longitude
            link.GatewayAltitude = gateway.Altitude?.toDouble()
            link.GatewayLocationAccuracy = gateway.LocationAccuracy?.toDouble()
            link.GatewayLocationSource = gateway.LocationSource

            // Location
            link.Latitude = source.Latitude
            link.Longitude = source.Longitude
            link.Altitude = source.Altitude
            link.AccuracyMeters = source.AccuracyMeters
            link.Satellites = source.Satellites
            link.Hdop = source.Hdop
            link.AccuracySource = source.AccuracySource

            // Custom attributes for ttn mapper
            link.UserAgent = source.UserAgent
            link.UserId = source.UserId
            link.Experiment = source.Experiment

            return link
        }

        @ExperimentalUnsignedTypes
        fun ttnV2UplinkToTtnMapperUplink(source: TtnUplinkMessage): TtnMapperUplinkMessage {
            val dest = TtnMapperUplinkMessage()
            dest.AppID = source.appId
            dest.DevID = source.devId
            dest.DevEui = source.hardwareSerial

            if(source.metadata != null) {
                if (!source.metadata!!.time.isNullOrBlank()) {
                    dest.Time = getDateForISO8601String(source.metadata!!.time!!).time.times(1000000) //nanoseconds
                }
            }

            dest.FPort = source.fPort
            dest.FCnt = source.fCnt?.toLong()

            dest.Frequency = source.metadata?.frequency?.times(1000000)?.toLong() // Herz
            dest.Modulation = source.metadata?.modulation

            if (dest.Modulation == "LORA") {
                val drParts = source.metadata?.dataRate?.split("BW")
                if (drParts != null) {
                    if(drParts.size == 2) {
                        val bandwidth = drParts[1].toIntOrNull()
                        if (bandwidth != null) {
                            dest.Bandwidth = (bandwidth * 1000).toLong()
                        } // kHz to Hz
                        val sf = drParts[0].removePrefix("SF")
                        dest.SpreadingFactor = sf.toIntOrNull()
                    }
                }
            }

            if (dest.Modulation == "FSK") {
                dest.Bitrate = source.metadata?.bitrate?.toLong()
            }

            dest.CodingRate = source.metadata?.codingRate

            val gateways = mutableListOf<TtnMapperGateway>()

            source.metadata?.gateways?.forEach {
                if(it != null) {
                    val gateway = TtnMapperGateway()
                    gateway.GatewayId = it.gtwId
                    if (it.gtwId?.startsWith("eui-") == true) {
                        gateway.GatewayEui = it.gtwId!!.removePrefix("eui-").uppercase(Locale.ROOT)
                    }
                    gateway.AntennaIndex = it.antenna
                    if(!it.time.isNullOrBlank()) {
                        gateway.Time = getDateForISO8601String(it.time!!).time.times(1000000) //nanoseconds
                    }
                    gateway.Timestamp = it.timestamp
                    gateway.FineTimestamp = it.fineTimestamp
                    gateway.FineTimestampEncrypted = null
                    gateway.FineTimestampEncryptedKeyId = null
                    gateway.ChannelIndex = it.channel
                    gateway.Rssi = it.rssi
                    gateway.SignalRssi = null
                    gateway.Snr = it.snr
                    gateway.Latitude = it.latitude
                    gateway.Longitude = it.longitude
                    gateway.Altitude = it.altitude
                    gateway.LocationAccuracy = it.accuracy
                    gateway.LocationSource = it.source

                    gateways.add(gateway)
                }
            }

            dest.Gateways = gateways.toList()

            // Rest of the fields are filled in later and not copied from the source

//            Latitude: Double,
//            Longitude: Double,
//            Altitude: Double,
//            AccuracyMeters: Double,
//            Satellites: Int,
//            Hdop: Double,
//            AccuracySource: String,

//            Experiment: String,
//            UserId: String,
//            UserAgent: String,

            return dest
        }


        fun ttnV3UplinkToTtnMapperUplink(source: V3ApplicationUp): TtnMapperUplinkMessage {
            val dest = TtnMapperUplinkMessage()

            dest.NetworkId = "NS_TTS_V3://"+source.uplinkMessage?.networkIds?.tenantId + "@" + source.uplinkMessage?.networkIds?.netId?.toNetIdString()

            dest.AppID = source.endDeviceIds?.applicationIds?.applicationId
            dest.DevID = source.endDeviceIds?.deviceId

            if(source.endDeviceIds?.devEui?.toEuiString()?.length == 16) {
                dest.DevEui = source.endDeviceIds.devEui.toEuiString()
            }

            dest.Time = source.receivedAt?.toInstant()?.toEpochMilli()?.times(1000000) //nanoseconds
            dest.FPort = source.uplinkMessage?.fPort?.toInt() ?: 0
            dest.FCnt = source.uplinkMessage?.fCnt
            dest.Frequency = source.uplinkMessage?.settings?.frequency?.toLongOrNull()
            if(source.uplinkMessage?.settings?.dataRate?.lora != null) {
                dest.Modulation = "LORA"
                dest.Bandwidth = source.uplinkMessage.settings.dataRate.lora.bandwidth
                dest.SpreadingFactor = source.uplinkMessage.settings.dataRate.lora.spreadingFactor?.toInt()
            }
            if(source.uplinkMessage?.settings?.dataRate?.fsk != null) {
                dest.Modulation = "FSK"
                dest.Bitrate = source.uplinkMessage.settings.dataRate.fsk.bitRate
            }
            if(source.uplinkMessage?.settings?.dataRate?.lrfhss != null) {
                dest.Modulation = "LR_FHSS"
                dest.Bandwidth = source.uplinkMessage.settings.dataRate.lrfhss.operatingChannelWidth
                // TODO: grid step, code rate
            }
            dest.CodingRate = source.uplinkMessage?.settings?.codingRate

            val gateways = mutableListOf<TtnMapperGateway>()

            source.uplinkMessage?.rxMetadata?.forEach {
                val gateway = TtnMapperGateway()

                gateway.GatewayId = it.gatewayIds?.gatewayId
                println(it.gatewayIds?.eui?.toEuiString())
                gateway.GatewayEui = it.gatewayIds?.eui?.toEuiString()

                if (it.packetBroker != null) {
                    /*
                        ttsDomain = forwrder_tenant_id@forwarder_net_id // "ttn@000013"
                    */
                    val forwarderTenantId = it.packetBroker.forwarderTenantId
                    val forwarderNetId = it.packetBroker.forwarderNetId
                    if (forwarderTenantId == "ttnv2") {
                        gateway.NetworkId = "thethingsnetwork.org"
                    } else {
                        gateway.NetworkId = "NS_TTS_V3://"+forwarderTenantId + "@" + forwarderNetId?.toNetIdString()
                    }

                    /*
                        Use GatewayId and EUI if reported by PacketBroker
                    */
                    if (it.packetBroker.forwarderGatewayEui != null) {
                        gateway.GatewayEui = it.packetBroker.forwarderGatewayEui.toEuiString()
                    }
                    if (it.packetBroker.forwarderGatewayId != null) {
                        gateway.GatewayId = it.packetBroker.forwarderGatewayId
                    }

                } else {
                    gateway.NetworkId = dest.NetworkId
                }

                if (gateway.GatewayId == null) {
                    return@forEach
                }

                if (gateway.GatewayId.equals("packetbroker")) {
                    return@forEach // like a continue in a for loop
                }

                if (gateway.GatewayEui.isNullOrEmpty() && gateway.GatewayId!!.startsWith("eui-") && gateway.GatewayId!!.length == 20) {
                    var eui = gateway.GatewayId!!.removePrefix("eui-")
                    eui = eui.uppercase()
                    gateway.GatewayEui = eui
                }

                gateway.Timestamp = it.timestamp
                if(it.time != null) {
                    gateway.Time =
                        it.time.toInstant()?.toEpochMilli()?.times(1000000) //nanoseconds
                } else {
                    gateway.Time = System.currentTimeMillis() * 1000000
                }
                gateway.FineTimestamp = it.fineTimestamp?.toLongOrNull()
                gateway.FineTimestampEncrypted = it.encryptedFineTimestamp?.toString()
                gateway.FineTimestampEncryptedKeyId = it.encryptedFineTimestampKeyId

                gateway.ChannelIndex = it.channelIndex?.toInt()
                gateway.Rssi = it.rssi?.toDouble()
                gateway.SignalRssi = it.signalRssi?.toDouble()
                gateway.Snr = it.snr?.toDouble()

                gateway.AntennaIndex = it.antennaIndex?.toInt() ?: 0
                gateway.Latitude = it.location?.latitude ?: 0.0
                gateway.Longitude = it.location?.longitude ?: 0.0
                gateway.Altitude = it.location?.altitude ?: 0
                gateway.LocationAccuracy = it.location?.accuracy ?: 0
                if(it.location?.source != null) {
                    gateway.LocationSource = it.location.source.toString()
                }

                gateways.add(gateway)
            }

            dest.Gateways = gateways.toList()

            return dest
        }


        @ExperimentalUnsignedTypes
        fun ChirpStackUplinkToTtnMapperUplink(source: UplinkEvent): TtnMapperUplinkMessage {
            val dest = TtnMapperUplinkMessage()

            dest.Time = Date().time.times(1000000) // ms to ns

            dest.AppID = source.applicationName
            dest.DevID = source.deviceName
            dest.DevEui = source.devEUI?.uppercase(Locale.ROOT)

            dest.FPort = source.fPort
            dest.FCnt = source.fCnt?.toLong()

            dest.Frequency = source.txInfo?.frequency?.toLong()

            /*
            Assume EU868
            0 LoRa: SF12 / 125 kHz 250
            1 LoRa: SF11 / 125 kHz 440
            2 LoRa: SF10 / 125 kHz 980
            3 LoRa: SF9 / 125 kHz 1760
            4 LoRa: SF8 / 125 kHz 3125
            5 LoRa: SF7 / 125 kHz 5470
            6 LoRa: SF7 / 250 kHz 11000
            7 FSK: 50 kbps 50000
            */
            when (source.txInfo?.dr) {
                0 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 12
                    dest.Bandwidth = 125000
                }
                1 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 11
                    dest.Bandwidth = 125000
                }
                2 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 10
                    dest.Bandwidth = 125000
                }
                3 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 9
                    dest.Bandwidth = 125000
                }
                4 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 8
                    dest.Bandwidth = 125000
                }
                5 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 7
                    dest.Bandwidth = 125000
                }
                6 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 7
                    dest.Bandwidth = 250000
                }
                7 -> {
                    dest.Modulation = "FSK"
                    dest.Bitrate = 50000
                }
            }

            val gateways = mutableListOf<TtnMapperGateway>()

            source.rxInfo?.forEach {
                val gateway = TtnMapperGateway()

                if(!it.time.isNullOrBlank()) {
                    dest.Time = getDateForISO8601String(it.time!!).time.times(1000000) // ms to ns
                }

                if(it.gatewayID != null) {
                    gateway.GatewayId = "eui-" + it.gatewayID!!.lowercase(Locale.ROOT)
                }
                gateway.GatewayEui = it.gatewayID?.uppercase(Locale.ROOT)
                gateway.Description = it.name

                gateway.AntennaIndex = it.antenna
                if(!it.time.isNullOrBlank()) {
                    gateway.Time = getDateForISO8601String(it.time!!).time.times(1000000) //nanoseconds
                }
                gateway.ChannelIndex = it.channel
                gateway.Rssi = it.rssi?.toDouble()
                gateway.SignalRssi = null
                gateway.Snr = it.loRaSNR
                gateway.Latitude = it.location?.latitude
                gateway.Longitude = it.location?.longitude
                gateway.Altitude = it.location?.altitude?.toInt()
                gateway.LocationAccuracy = it.location?.accuracy
                gateway.LocationSource = it.location?.source

                gateways.add(gateway)
            }
            dest.Gateways = gateways

            return dest
        }

    }
}