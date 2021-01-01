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

        ttnMessage?.Gateways?.forEach {
            gatewayCount++

            gtwId = it?.GatewayId ?: "<unknown>"

            if (it?.Rssi != null) {
                if (maxRssi == 0.0 || it.Rssi!! > maxRssi) {
                    maxRssi = it.Rssi!!
                }
            }

            if (it?.Snr != null) {
                if (maxSnr == 0.0 || it.Snr!! > maxSnr) {
                    maxSnr = it.Snr!!
                }
            }
        }

        if (ttnMessage?.Time != null) {
            binding.lastPktTime.text = ttnMessage.Time.toString()
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

            binding.lastPktFreq.text = ttnMessage?.Frequency.toString()

            binding.lastPktDatarate.text = ttnMessage?.SpreadingFactor.toString()
    }
}
