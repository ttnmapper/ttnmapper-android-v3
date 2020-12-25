package org.ttnmapper.phonesurveyor.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.ttnmapper.phonesurveyor.model.TTNMessage
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.copyTtnToLink
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

    @Query("SELECT session, COUNT(*) AS count FROM link GROUP BY session")
    fun getSessions(): List<SessionLinkCount>

    @Query("SELECT * FROM link")
    fun getAll(): List<Link>

    @Query("SELECT * FROM link WHERE uid IN (:linkIds)")
    fun loadAllByIds(linkIds: IntArray): List<Link>

    @Query("SELECT * FROM link WHERE gtwId LIKE :gtwId")
    fun findByGateway(gtwId: String): Link

    @Insert
    fun insertAll(vararg links: Link)

    fun insertTtnMessage(sessionStart: Date, ttnMessage: TTNMessage) {
        val links: MutableList<Link> = mutableListOf()

        for (gateway in ttnMessage.metadata?.gateways.orEmpty()) {
            val link = copyTtnToLink(sessionStart, ttnMessage, gateway!!)
            links.add(link)
        }
        insertAll(*links.toTypedArray())
    }

    @Delete
    fun delete(link: Link)

    @Query("DELETE FROM link WHERE session = :sessionId")
    fun deleteSession(sessionId: String)

    @Query("DELETE FROM link")
    fun deleteAll()
}

class SessionLinkCount {
    var session: String = ""
    var count = 0
}