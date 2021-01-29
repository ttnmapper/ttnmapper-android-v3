package org.ttnmapper.phonesurveyor

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Test
import org.openapitools.client.models.V3ApplicationUp
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import org.ttnmapper.phonesurveyor.model.ttnV3.OffsetDateTimeAdapter

class TestJsonParsing {
    @Test
    fun TestParseTtnV2() {
        val inputString = listOf(
                """
                    {"app_id":"ttn_mapper_wa","dev_id":"ttn_mapper_01","hardware_serial":"0004A30B001BB1C8","port":3,"counter":101,"payload_raw":"yq5Gg+Z2/+0B","payload_fields":{"altitude":-19,"hdop":0.1,"latitude":52.50991478621452,"longitude":5.484720795435919},"metadata":{"time":"2021-01-12T16:25:50.911765357Z","frequency":867.5,"modulation":"LORA","data_rate":"SF7BW125","airtime":56576000,"coding_rate":"4/5","gateways":[{"gtw_id":"eui-b827ebfffefdb27f","timestamp":1143648212,"time":"2021-01-12T16:25:50.902834Z","channel":5,"rssi":-70,"snr":8.2,"rf_chain":0,"latitude":52.50971,"longitude":5.48471,"altitude":-8},{"gtw_id":"eui-dca632fffe005838","timestamp":1329362748,"time":"","channel":5,"rssi":-81,"snr":8.5,"rf_chain":0}]}}
                """.trimIndent(),
                """
                    {"app_id":"ttn_mapper_wa","dev_id":"ttn_mapper_01","hardware_serial":"0004A30B001BB1C8","port":3,"counter":100,"payload_raw":"yq5Gg+Z2/+0B","payload_fields":{"altitude":-19,"hdop":0.1,"latitude":52.50991478621452,"longitude":5.484720795435919},"metadata":{"time":"2021-01-12T16:25:45.355391227Z","frequency":867.3,"modulation":"LORA","data_rate":"SF7BW125","airtime":56576000,"coding_rate":"4/5","gateways":[{"gtw_id":"eui-dca632fffe005838","timestamp":1323805915,"time":"","channel":4,"rssi":-81,"snr":9.5,"rf_chain":0},{"gtw_id":"eui-b827ebfffefdb27f","timestamp":1138091387,"time":"2021-01-12T16:25:45.343808Z","channel":4,"rssi":-70,"snr":9.8,"rf_chain":0,"latitude":52.50971,"longitude":5.48471,"altitude":-8}]}}
                """.trimIndent(),
                """
                    {"app_id":"ttn_mapper_wa","dev_id":"ttn_mapper_01","hardware_serial":"0004A30B001BB1C8","port":3,"counter":105,"payload_raw":"yq5Gg+Z2/+0B","payload_fields":{"altitude":-19,"hdop":0.1,"latitude":52.50991478621452,"longitude":5.484720795435919},"metadata":{"time":"2021-01-12T16:26:17.435731005Z","frequency":868.3,"modulation":"LORA","data_rate":"SF7BW125","airtime":56576000,"coding_rate":"4/5","gateways":[{"gtw_id":"eui-b827ebfffefdb27f","timestamp":1170165307,"time":"2021-01-12T16:26:17.421904Z","channel":1,"rssi":-71,"snr":9,"rf_chain":0,"latitude":52.50971,"longitude":5.48471,"altitude":-8}]}}
                """.trimIndent()
        )
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        inputString.forEach {
            val jsonAdapter = moshi.adapter(TtnUplinkMessage::class.java)
            val ttnMessage = jsonAdapter.fromJson(it)

            if (ttnMessage == null) {
                System.out.println("V2 Message not parsed")
                return
            } else {
                System.out.println("V2 Parsed")
            }
        }
    }

    @Test
    fun TestParseTtsV3() {
        val inputString = listOf(
                """
                    {"end_device_ids":{"device_id":"dev-adeunis","application_ids":{"application_id":"app-adeunis-field-testing"},"dev_eui":"0018B20000022799","join_eui":"70B3D57ED00372AB","dev_addr":"019DE693"},"correlation_ids":["as:up:01EW5T9A9BENX9GBJSKTE4K12Z","gs:conn:01EW0YGGS4ERVW35R534VE7TBY","gs:up:host:01EW0YGGSD36BYXE0J0P640RFY","gs:uplink:01EW5T9A2N313QWHMAF30BB6FB","ns:uplink:01EW5T9A2P6SAMTPJKDRBQC4SQ","rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01EW5T9A2PNARTSYE49F6FRP6B"],"received_at":"2021-01-16T14:41:16.587539527Z","uplink_message":{"session_key_id":"AXcG0Y5w5hQbCPqDloJsBg==","f_port":1,"f_cnt":1354,"frm_payload":"nxFQUzZgAEREUDhKSw/uMwc=","decoded_payload":{"altitude":0,"battery":4078,"downlink":75,"latitude":50.889433333333336,"longitude":4.740833333333333,"rssi":-51,"sats":8,"snr":7,"temperature":17,"uplink":74},"rx_metadata":[{"gateway_ids":{"gateway_id":"dingnet-gw-ucll-2","eui":"1DEE161B2852537B"},"timestamp":2036135331,"rssi":-69,"channel_rssi":-69,"snr":10.2,"uplink_token":"Ch8KHQoRZGluZ25ldC1ndy11Y2xsLTISCB3uFhsoUlN7EKPr88oHGgwIjPaLgAYQ+N6IsgEguIn+mKHMJA=="}],"settings":{"data_rate":{"lora":{"bandwidth":125000,"spreading_factor":7}},"data_rate_index":5,"coding_rate":"4/5","frequency":"868100000","timestamp":2036135331},"received_at":"2021-01-16T14:41:16.374448376Z","consumed_airtime":"0.071936s"}}
                """.trimIndent()
        )
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(OffsetDateTimeAdapter())
                .build()

        inputString.forEach {
            val jsonAdapter = moshi.adapter(V3ApplicationUp::class.java)
            val ttnMessage = jsonAdapter.fromJson(it)

            if (ttnMessage == null) {
                System.out.println("V3 Message not parsed")
                return
            } else {
                System.out.println("V3 Parsed")
            }
        }
    }
}