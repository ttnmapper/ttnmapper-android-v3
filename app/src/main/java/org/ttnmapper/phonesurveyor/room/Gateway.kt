package org.ttnmapper.phonesurveyor.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// https://ttnmapper.org/appapi/v3/gwdetails.php?gtwId=
// {"details":{"description":"Heatherpark (TTN Western Cape)","lat":-33.9546992,"lon":22.4345874,"last_heard":1608811130,"channels":0,"gwaddr":"eui-3133303748005c00"},"error":false}
@Entity
data class Gateway(
        @PrimaryKey(autoGenerate = true)
        val uid: Int = 0,

        val gtwId: String,
        var description: String? = null,
        var latitude: Double? = null,
        var longitude: Double? = null,
        var channels: Int? = null,

)
