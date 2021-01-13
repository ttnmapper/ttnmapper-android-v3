package org.ttnmapper.phonesurveyor

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Test
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage

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
            val jsonAdapter = moshi.adapter<TtnUplinkMessage>(TtnUplinkMessage::class.java)
            val ttnMessage = jsonAdapter.fromJson(it)

            if (ttnMessage == null) {
                System.out.println("V2 Message not parsed")
                return
            } else {
                System.out.println("V2 Parsed")
            }
        }
    }
}