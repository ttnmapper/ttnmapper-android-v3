package org.ttnmapper.phonesurveyor.room

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase.CONFLICT_REPLACE
import androidx.core.database.getDoubleOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getDateForISO8601String


val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {

        // Rename old database
        database.execSQL("ALTER TABLE Link RENAME TO Link_old;")

        // Create new database, using create query copied from schema json file
        database.execSQL("CREATE TABLE IF NOT EXISTS `Link` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Session` TEXT NOT NULL, `AppID` TEXT, `DevID` TEXT, `DevEui` TEXT, `Time` INTEGER, `FPort` INTEGER, `FCnt` INTEGER, `Frequency` INTEGER, `Modulation` TEXT, `Bandwidth` INTEGER, `SpreadingFactor` INTEGER, `Bitrate` INTEGER, `CodingRate` TEXT, `GatewayId` TEXT, `GatewayEui` TEXT, `AntennaIndex` INTEGER, `GatewayTime` INTEGER, `GatewayTimestamp` INTEGER, `FineTimestamp` INTEGER, `FineTimestampEncrypted` TEXT, `FineTimestampEncryptedKeyId` TEXT, `ChannelIndex` INTEGER, `Rssi` REAL, `SignalRssi` REAL, `Snr` REAL, `GatewayLatitude` REAL, `GatewayLongitude` REAL, `GatewayAltitude` REAL, `GatewayLocationAccuracy` REAL, `GatewayLocationSource` TEXT, `Latitude` REAL, `Longitude` REAL, `Altitude` REAL, `AccuracyMeters` REAL, `Satellites` INTEGER, `Hdop` REAL, `AccuracySource` TEXT, `Experiment` TEXT, `UserId` TEXT, `UserAgent` TEXT)")
        database.execSQL("CREATE INDEX IF NOT EXISTS `index_Link_Session` ON `Link` (`Session`)")

        // Iterate old table, convert data, and insert into new table
        val cursor = database.query("SELECT * FROM Link_old")
        while(cursor.moveToNext()) {
            // V1: session, appId, devId, hardwareSerial, fPort, fCnt, time, frequency, modulation, dataRate, bitrate, codingRate, devLatitude, devLongitude, devAltitude, devLocationAccuracy, devLocationSource, maxSignal, gtwId, antenna, channel, rssi, snr, rfChain, gtwLatitude, gtwLongitude, gtwAltitude, gtwLocationAccuracy, gtwLocationSource, phoneLat, phoneLon, phoneAlt, phoneLocAcc, phoneLocProvider, phoneLocTime, phoneTime, userAgent, iid, experiment
            // V2: Session, AppID, DevID, DevEui, Time, FPort, FCnt, Frequency, Modulation, Bandwidth, SpreadingFactor, Bitrate, CodingRate, GatewayId, GatewayEui, AntennaIndex, GatewayTime, GatewayTimestamp, FineTimestamp, FineTimestampEncrypted, FineTimestampEncryptedKeyId, ChannelIndex, Rssi, SignalRssi, Snr, GatewayLatitude, GatewayLongitude, GatewayAltitude, GatewayLocationAccuracy, GatewayLocationSource, Latitude, Longitude, Altitude, AccuracyMeters, Satellites, Hdop, AccuracySource, Experiment, UserId, UserAgent

            val contentValues = ContentValues()
            contentValues.put("Session", cursor.getString(cursor.getColumnIndexOrThrow("session")))
            contentValues.put("AppID", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("appId")))
            contentValues.put("DevID", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("devId")))
            contentValues.put("DevEui", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("hardwareSerial")))
            contentValues.put("FPort", cursor.getIntOrNull(cursor.getColumnIndexOrThrow("fPort")))
            contentValues.put("FCnt", cursor.getIntOrNull(cursor.getColumnIndexOrThrow("fCnt"))?.toLong())
            contentValues.put("Frequency", (cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("frequency"))?.times(1000000))?.toLong())
            val modulation = cursor.getStringOrNull(cursor.getColumnIndexOrThrow("modulation"))
            contentValues.put("Modulation", modulation)
            contentValues.put("Bitrate", cursor.getIntOrNull(cursor.getColumnIndexOrThrow("bitrate"))?.toLong())
            contentValues.put("CodingRate", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("codingRate")))

            contentValues.put("GatewayId", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("gtwId")))
            contentValues.put("AntennaIndex", cursor.getIntOrNull(cursor.getColumnIndexOrThrow("antenna")))
            contentValues.put("ChannelIndex", cursor.getIntOrNull(cursor.getColumnIndexOrThrow("channel")))
            contentValues.put("Rssi", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("rssi")))
            contentValues.put("Snr", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("snr")))
            contentValues.put("GatewayLatitude", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("gtwLatitude")))
            contentValues.put("GatewayLongitude", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("gtwLongitude")))
            contentValues.put("GatewayAltitude", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("gtwAltitude")))
            contentValues.put("GatewayLocationAccuracy", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("gtwLocationAccuracy")))
            contentValues.put("GatewayLocationSource", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("gtwLocationSource")))

            contentValues.put("Latitude", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("phoneLat")))
            contentValues.put("Longitude", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("phoneLon")))
            contentValues.put("Altitude", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("phoneAlt")))
            contentValues.put("AccuracyMeters", cursor.getDoubleOrNull(cursor.getColumnIndexOrThrow("phoneLocAcc")))
            contentValues.put("AccuracySource", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("phoneLocProvider")))
            contentValues.put("UserAgent", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("userAgent")))
            contentValues.put("UserId", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("iid")))
            contentValues.put("Experiment", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("experiment")))

            contentValues.put("Time", cursor.getStringOrNull(cursor.getColumnIndexOrThrow("time"))?.let { getDateForISO8601String(it).time })

            val drParts = cursor.getStringOrNull(cursor.getColumnIndexOrThrow("dataRate"))?.split("BW")
            if (drParts != null) {
                if(drParts.size == 2) {
                    val bandwidth = drParts[1].toIntOrNull()
                    if (bandwidth != null) {
                        contentValues.put("Bandwidth", (bandwidth * 1000).toLong())
                    } // kHz to Hz
                    val sf = drParts[0].removePrefix("SF")
                    contentValues.put("SpreadingFactor", sf.toIntOrNull())
                }
            }

            database.insert("Link", CONFLICT_REPLACE, contentValues)
        }

        // And finally delete the old version of the table
        database.execSQL("DROP TABLE Link_old;")

        // No need to migrate gateway table
    }
}