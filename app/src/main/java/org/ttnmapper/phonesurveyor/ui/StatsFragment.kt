package org.ttnmapper.phonesurveyor.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.aggregates.MapAggregate
import org.ttnmapper.phonesurveyor.databinding.FragmentStatsBinding


class StatsFragment : Fragment() {

    private val TAG = StatsFragment::class.java.getName()

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

        if(_binding == null) {
            Log.w(TAG, "Binding is null, so fragment does not exist")
            return
        }

        binding.totalGtws.text = MapAggregate.seenGateways.size.toString()
        binding.totalPkts.text = AppAggregate.numberOfPacketsRx.toString()

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
            binding.lastPktTime.text = ttnMessage.metadata?.time.toString()
        }

        if (gatewayCount == 1) {
            binding.lastPktGtwsLabel.text = "Gateway ID"
            binding.lastPktGtws.text = gtwId
        } else {
            binding.lastPktGtwsLabel.text = "Number of gateways"
            binding.lastPktGtws.text = gatewayCount.toString()
        }

        if (maxRssi != 0.0) {
            binding.lastPktRssiMax.text = maxRssi.toString()
        } else {
            binding.lastPktRssiMax.text = ""
        }

        if (maxSnr != 0.0) {
            binding.lastPktSnrMax.text = maxSnr.toString()
        } else {
            binding.lastPktSnrMax.text = ""
        }

        if (ttnMessage?.metadata?.frequency != null) {
            binding.lastPktFreq.text = ttnMessage.metadata?.frequency?.toString()
        } else {
            binding.lastPktFreq.text = ""
        }

        if (ttnMessage?.metadata?.dataRate != null) {
            binding.lastPktDatarate.text = ttnMessage.metadata?.dataRate?.toString()
        } else {
            binding.lastPktDatarate.text = ""
        }
    }
}
