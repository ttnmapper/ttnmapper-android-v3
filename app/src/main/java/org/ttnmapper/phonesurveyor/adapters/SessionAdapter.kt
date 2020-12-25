package org.ttnmapper.phonesurveyor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.databinding.SessionRowBinding
import org.ttnmapper.phonesurveyor.room.SessionLinkCount
import org.ttnmapper.phonesurveyor.ui.SessionRowClickListener


class SessionAdapter(private var sessionList: List<SessionLinkCount>, private val listener: SessionRowClickListener) : RecyclerView.Adapter<SessionAdapter.ViewHolder>() {

    // holder class to hold reference
    inner class ViewHolder(view: View, listener: SessionRowClickListener) : RecyclerView.ViewHolder(view) {
        val binding = SessionRowBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.session_row, parent, false), listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewSessionId.text = sessionList[position].session
        holder.binding.textViewLinkCount.text = "Link count: "+sessionList[position].count.toString()

        holder.binding.buttonExportSession.setOnClickListener { listener.onExportClicked(sessionList[position].session) }
        holder.binding.buttonDeleteSession.setOnClickListener { listener.onDeleteClicked(sessionList[position].session) }
    }

    override fun getItemCount(): Int {
        return sessionList.size
    }

    fun updateDataList(newSessionList: List<SessionLinkCount>) {
        sessionList = newSessionList
        notifyDataSetChanged()
    }
}