package org.ttnmapper.phonesurveyor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate
import org.ttnmapper.phonesurveyor.model.TtnApplication

class ApplicationsAdapter(private val context: Context) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private class ViewHolder {
        lateinit var id: TextView
        lateinit var name: TextView
        lateinit var handler: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val holder: ViewHolder

        if (convertView == null) {

            view = inflater.inflate(R.layout.list_item_application, parent, false)

            holder = ViewHolder()
            holder.id = view.findViewById(R.id.appID)
            holder.name = view.findViewById(R.id.appDescription)
            holder.handler = view.findViewById(R.id.appHandler)

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val textViewId = holder.id
        val textViewName = holder.name
        val textViewHandler = holder.handler

        val application = getItem(position) as TtnApplication
        textViewId.text = application.id
        textViewName.text = application.name
        textViewHandler.text = application.handlerId

        return view
    }

    override fun getItem(position: Int): Any {
        return TtnLoginAggregate.ttnApplications!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return TtnLoginAggregate.ttnApplications?.size ?: 0
    }

}