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
import java.text.SimpleDateFormat
import java.util.*


class StatsFragment : Fragment() {

    private val TAG = StatsFragment::class.java.getName()

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        // Inflate the layout for this fragment
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
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

        binding.totalPkts.text = AppAggregate.numberOfPacketsRx.toString()
        binding.totalGtwsSeen.text = AppAggregate.seenGateways.size.toString()
        binding.totalGtwsMapped.text = MapAggregate.mappedGateways.size.toString()

        var gatewayCount = 0
        var maxRssi: Double = 0.0
        var maxSnr: Double = 0.0
        var gtwIds: String = ""

        ttnMessage?.Gateways?.forEach {
            gatewayCount++

            val gtwId = it.GatewayId ?: "<unknown>"
            if(gtwIds.isEmpty()) {
                gtwIds = gtwId
            } else {
                gtwIds += "\n" + gtwId
            }

            if (it.Rssi != null) {
                if (maxRssi == 0.0 || it.Rssi!! > maxRssi) {
                    maxRssi = it.Rssi!!
                }
            }

            if (it.Snr != null) {
                if (maxSnr == 0.0 || it.Snr!! > maxSnr) {
                    maxSnr = it.Snr!!
                }
            }
        }

        if (ttnMessage?.Time != null) {
            val tz = TimeZone.getTimeZone("UTC")
            val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'") // Quoted "Z" to indicate UTC, no timezone offset
            df.setTimeZone(tz)
            binding.lastPktTime.text = df.format(Date(ttnMessage.Time!! / 1000000))
        }

        binding.lastPktGtwsLabel.text = "Gateway IDs"
        binding.lastPktGtws.text = gtwIds

        if (maxRssi != 0.0) {
            binding.lastPktRssiMax.text = maxRssi.toString() + " dBm"
        } else {
            binding.lastPktRssiMax.text = ""
        }

        if (maxSnr != 0.0) {
            binding.lastPktSnrMax.text = maxSnr.toString() + " dB"
        } else {
            binding.lastPktSnrMax.text = ""
        }

        val freqMhz = ttnMessage?.Frequency?.toDouble()?.div(1000000)
        if (freqMhz != null) {
            binding.lastPktFreq.text = freqMhz.toString() + " MHz"
        }

        if(ttnMessage?.SpreadingFactor != null && ttnMessage.Bandwidth != null) {
            binding.lastPktDatarate.text = "SF" + ttnMessage.SpreadingFactor.toString() + "BW" + (ttnMessage.Bandwidth?.div(1000)).toString()
        }
    }
}
