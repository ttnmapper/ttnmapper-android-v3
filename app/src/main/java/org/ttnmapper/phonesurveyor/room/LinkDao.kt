package org.ttnmapper.phonesurveyor.room

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.model.TTNMessage
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.copyPropsFrom
import java.util.*

@Dao
interface LinkDao {
    @Query("SELECT * FROM link")
    fun getAll(): List<Link>

    @Query("SELECT * FROM link WHERE uid IN (:linkIds)")
    fun loadAllByIds(linkIds: IntArray): List<Link>

    @Query("SELECT * FROM link WHERE gtw_id LIKE :gtwId")
    fun findByGateway(gtwId: String): Link

    @Insert
    fun insertAll(vararg links: Link)

    fun insertTtnMessage(ttnMessage: TTNMessage) {
        val links: MutableList<Link> = mutableListOf()

        for (gateway in ttnMessage.metadata?.gateways.orEmpty()) {
            val link = Link()

            link.copyPropsFrom(ttnMessage)
            link.copyPropsFrom(ttnMessage.metadata!!)
            link.copyPropsFrom(gateway!!)

            links.add(link)
        }
        Log.e("LinkDao", links.toString())
    }

    @Delete
    fun delete(link: Link)
}