package org.ttnmapper.phonesurveyor.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GatewayDao {
    @Query("SELECT * FROM gateway WHERE gtwId LIKE :gtwId")
    fun findGateway(gtwId: String): Gateway

    @Insert
    fun insertAll(vararg gateway: Gateway)

    @Query("DELETE FROM gateway")
    fun deleteAll()
}