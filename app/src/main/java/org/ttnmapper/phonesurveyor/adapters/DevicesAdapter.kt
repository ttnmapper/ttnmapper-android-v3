package org.ttnmapper.phonesurveyor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate
import org.ttnmapper.phonesurveyor.model.ttnV2.Device

class DevicesAdapter(private val context: Context) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private class ViewHolder {
        lateinit var id: TextView
        lateinit var name: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val holder: ViewHolder

        if (convertView == null) {

            view = inflater.inflate(R.layout.list_item_application, parent, false)

            holder = ViewHolder()
            holder.id = view.findViewById(R.id.appID)
            holder.name = view.findViewById(R.id.appDescription)

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val textViewId = holder.id
        val textViewName = holder.name

        val device = getItem(position) as Device
        textViewId.text = device.dev_id
        textViewName.text = device.description

        return view
    }

    override fun getItem(position: Int): Any {
        return TtnLoginAggregate.selectedApplication?.devices?.get(position) as Any
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return TtnLoginAggregate.selectedApplication?.devices?.size ?: 0
    }

}