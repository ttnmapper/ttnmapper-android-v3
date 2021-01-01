package org.ttnmapper.phonesurveyor.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.ttnmapper.phonesurveyor.model.TtnMapperUplinkMessage
import org.ttnmapper.phonesurveyor.utils.ObjectCopy.Companion.copyTtnToLink
import java.util.*

@Dao
interface LinkDao {
    @Query("SELECT COUNT(*) FROM link")
    fun getCount(): Int

    @Query("SELECT COUNT(DISTINCT(session)) FROM link")
    fun getSessionCount(): Int

//    @Query("SELECT DISTINCT(session) FROM link")
//    fun getSessionIDs(): List<String>
//
//    @Query("SELECT COUNT(*) FROM link WHERE session = :sessionId")
//    fun getLinkCountForSession(sessionId: String)

    @Query("SELECT Session, COUNT(*) AS count FROM link GROUP BY Session")
    fun getSessions(): List<SessionLinkCount>

    @Query("SELECT * FROM link")
    fun getAll(): List<Link>

    @Query("SELECT * FROM link WHERE uid IN (:linkIds)")
    fun loadAllByIds(linkIds: IntArray): List<Link>

    @Query("SELECT * FROM link WHERE GatewayId LIKE :gtwId")
    fun findByGateway(gtwId: String): Link

    @Insert
    fun insertAll(vararg links: Link)

    fun insertTtnMessage(sessionStart: Date, ttnMessage: TtnMapperUplinkMessage) {
        val links: MutableList<Link> = mutableListOf()

        for (gateway in ttnMessage.Gateways.orEmpty()) {
            val link = copyTtnToLink(sessionStart, ttnMessage, gateway!!)
            links.add(link)
        }
        insertAll(*links.toTypedArray())
    }

    @Delete
    fun delete(link: Link)

    @Query("DELETE FROM link WHERE Session = :sessionId")
    fun deleteSession(sessionId: String)

    @Query("DELETE FROM link")
    fun deleteAll()
}

class SessionLinkCount {
    var Session: String = ""
    var count = 0
}