package org.ttnmapper.phonesurveyor.utils

import android.util.Base64
import org.openapitools.client.models.V3ApplicationUp
import org.ttnmapper.phonesurveyor.model.TtnMapperGateway
import org.ttnmapper.phonesurveyor.model.TtnMapperUplinkMessage
import org.ttnmapper.phonesurveyor.model.chirpstack.UplinkEvent
import org.ttnmapper.phonesurveyor.model.ttnV2.GatewayMetadata
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import org.ttnmapper.phonesurveyor.room.Link
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getDateForISO8601String
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
            link.FineTimestampEncrypted = Base64.encodeToString(gateway.FineTimestampEncrypted?.toByteArray(), Base64.DEFAULT)
            link.FineTimestampEncryptedKeyId = gateway.FineTimestampEncryptedKeyId

            link.ChannelIndex = gateway.ChannelIndex
            link.Rssi = gateway.Rssi
            link.SignalRssi = gateway.SignalRssi
            link.Snr = gateway.Snr

            // Gateway Location Metadata
            link.GatewayLatitude = gateway.Latitude
            link.GatewayLongitude = gateway.Longitude
            link.GatewayAltitude = gateway.Altitude
            link.GatewayLocationAccuracy = gateway.LocationAccuracy
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

            dest.Time = source.metadata?.time?.let { getDateForISO8601String(it).time }?.times(1000000) //nanoseconds

            dest.FPort = source.fPort?.toUByte()
            dest.FCnt = source.fCnt?.toLong()

            dest.Frequency = (source.metadata?.frequency?.times(1000000))?.toULong() //Herz
            dest.Modulation = source.metadata?.modulation

            if (dest.Modulation == "LORA") {
                val drParts = source.metadata?.dataRate?.split("BW")
                if (drParts != null) {
                    if(drParts.size == 2) {
                        val bandwidth = drParts[1].toIntOrNull()
                        if (bandwidth != null) {
                            dest.Bandwidth = (bandwidth * 1000).toULong()
                        } // kHz to Hz
                        val sf = drParts[0].removePrefix("SF")
                        dest.SpreadingFactor = sf.toUByteOrNull()
                    }
                }
            }

            if (dest.Modulation == "FSK") {
                dest.Bitrate = source.metadata?.bitrate?.toULong()
            }

            dest.CodingRate = source.metadata?.codingRate

            val gateways = mutableListOf<TtnMapperGateway>()

            source.metadata?.gateways?.forEach {
                if(it != null) {
                    val gateway = TtnMapperGateway()
                    gateway.GatewayId = it.gtwId
                    if (it.gtwId?.startsWith("eui-") == true) {
                        gateway.GatewayEui = it.gtwId!!.removePrefix("eui-").toUpperCase(Locale.ROOT)
                    }
                    gateway.AntennaIndex = it.antenna?.toUByte()
                    if(it.time != null) {
                        gateway.Time = getDateForISO8601String(it.time!!).time.times(1000000) //nanoseconds
                    }
                    gateway.Timestamp = it.timestamp?.toULong()
                    gateway.FineTimestamp = it.fineTimestamp?.toULong()
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
            // TODO
            return dest
        }


        @ExperimentalUnsignedTypes
        fun ChirpStackUplinkToTtnMapperUplink(source: UplinkEvent): TtnMapperUplinkMessage {
            val dest = TtnMapperUplinkMessage()

            dest.AppID = source.applicationName
            dest.DevID = source.deviceName
            dest.DevEui = source.devEUI

            dest.FPort = source.fPort?.toUByte()
            dest.FCnt = source.fCnt?.toLong()

            dest.Frequency = source.txInfo?.frequency?.toULong()

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
                    dest.SpreadingFactor = 12u
                    dest.Bandwidth = 125000u
                }
                1 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 11u
                    dest.Bandwidth = 125000u
                }
                2 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 10u
                    dest.Bandwidth = 125000u
                }
                3 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 9u
                    dest.Bandwidth = 125000u
                }
                4 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 8u
                    dest.Bandwidth = 125000u
                }
                5 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 7u
                    dest.Bandwidth = 125000u
                }
                6 -> {
                    dest.Modulation = "LORA"
                    dest.SpreadingFactor = 7u
                    dest.Bandwidth = 250000u
                }
                7 -> {
                    dest.Modulation = "FSK"
                    dest.Bitrate = 50000u
                }
            }

            val gateways = mutableListOf<TtnMapperGateway>()

            source.rxInfo?.forEach {
                val gateway = TtnMapperGateway()
                if(it.gatewayID != null) {
                    gateway.GatewayId = "eui-" + it.gatewayID!!.toLowerCase(Locale.ROOT)
                }
                gateway.GatewayEui = it.gatewayID?.toUpperCase(Locale.ROOT)
                gateway.AntennaIndex = it.antenna?.toUByte()
                if(it.time != null) {
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

            return dest
        }

    }
}

/*
{
   "applicationID":"1",
   "applicationName":"test-application",
   "deviceName":"test-device",
   "devEUI":"0004a30b001c684f",
   "rxInfo":[
      {
         "gatewayID":"3133303748005c00",
         "uplinkID":"aca88e64-7c09-4866-9da9-828003110996",
         "name":"mikrotik",
         "time":"2020-12-28T12:00:10.947155Z",
         "rssi":-104,
         "loRaSNR":5.25,
         "location":{
            "latitude":-33.9586553,
            "longitude":22.441055499999997,
            "altitude":200
         }
      }
   ],
   "txInfo":{
      "frequency":868500000,
      "dr":5
   },
   "adr":true,
   "fCnt":23,
   "fPort":1,
   "data":"AA=="
}
 */