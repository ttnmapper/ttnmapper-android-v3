package org.ttnmapper.phonesurveyor.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_stats.*
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.aggregates.MapAggregate
import org.ttnmapper.phonesurveyor.model.TTNMessage


class StatsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onResume() {
        super.onResume()

        updateStats()
    }

    /*
    Warning: When this function is called the labels might not be inited yet, so chekc for null on all of them
     */
    fun updateStats() {
        val ttnMessage = AppAggregate.lastTTNMessage

        total_gtws?.text = MapAggregate.seenGateways.size.toString()
        total_pkts?.text = AppAggregate.numberOfPacketsRx.toString()

        var gatewayCount = 0
        var maxRssi: Double = 0.0
        var maxSnr: Double = 0.0
        var gtwId: String = ""

        ttnMessage?.metadata?.gateways?.forEach {
            gatewayCount++

            gtwId = it?.gtwId ?: "<unknown>"

            if (it?.rssi != null) {
                if (maxRssi == 0.0 || it.rssi!! > maxRssi) {
                    maxRssi = it.rssi!!
                }
            }

            if (it?.snr != null) {
                if (maxSnr == 0.0 || it.snr!! > maxSnr) {
                    maxSnr = it.snr!!
                }
            }
        }

        if (ttnMessage?.metadata?.time != null) {
            last_pkt_time?.text = ttnMessage.metadata?.time.toString()
        }

        if (gatewayCount == 1) {
            last_pkt_gtws_label?.text = "Gateway ID"
            last_pkt_gtws?.text = gtwId
        } else {
            last_pkt_gtws_label?.text = "Number of gateways"
            last_pkt_gtws?.text = gatewayCount.toString()
        }

        if (maxRssi != 0.0) {
            last_pkt_rssi_max?.text = maxRssi.toString()
        } else {
            last_pkt_rssi_max?.text = ""
        }

        if (maxSnr != 0.0) {
            last_pkt_snr_max?.text = maxSnr.toString()
        } else {
            last_pkt_snr_max?.text = ""
        }

        if (ttnMessage?.metadata?.frequency != null) {
            last_pkt_freq?.text = ttnMessage.metadata?.frequency?.toString()
        } else {
            last_pkt_freq?.text = ""
        }

        if (ttnMessage?.metadata?.dataRate != null) {
            last_pkt_datarate?.text = ttnMessage.metadata?.dataRate?.toString()
        } else {
            last_pkt_datarate?.text = ""
        }
    }
}
