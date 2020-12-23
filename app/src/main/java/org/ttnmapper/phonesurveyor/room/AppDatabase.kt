package org.ttnmapper.phonesurveyor.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getDateForISO8601String
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getISO8601StringForMillis
import java.util.*

@Database(entities = arrayOf(Link::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun linkDao(): LinkDao
}