package org.ttnmapper.phonesurveyor.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.ttnmapper.phonesurveyor.model.TTNMessage
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.copyPropsFrom

@Dao
interface LinkDao {
    @Query("SELECT COUNT(*) FROM link")
    fun getCount(): Int

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
        insertAll(*links.toTypedArray())
    }

    @Delete
    fun delete(link: Link)

    @Query("DELETE FROM link")
    fun deleteAll()
}