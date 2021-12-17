package org.ttnmapper.phonesurveyor

import android.util.Base64
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Before
import org.junit.Test
import org.openapitools.client.models.V3ApplicationUp
import org.ttnmapper.phonesurveyor.model.chirpstack.UplinkEvent
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import org.ttnmapper.phonesurveyor.model.ttnV3.OffsetDateTimeAdapter
import org.ttnmapper.phonesurveyor.utils.ObjectCopy

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
//                .add(KotlinJsonAdapterFactory())
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
        // mosquitto_sub -v -d -h "eu1.cloud.thethings.network" -p 1883 -u "izinto-globalsat-lt100@ttn" -P "NNSXS.NTE5KQZR7GDWIUSTC5YICHHCGXQF4HSYRQ6IKYY.BAPAR7Z6Q7G5MVB2KY4UFXRBACFORNWGSBYW2GN4ITTVO4LGFGNQ" -t "#"
        // mosquitto_sub -v -d -h "eu1.cloud.thethings.network" -p 1883 -u "jpm-crickets@ttn" -P "NNSXS.FWOKZ3X3BKGRBE37PFJM6ZMA4NFIRWMNUY7A7ZA.UXTK532WLGNVIT6HV5TI6U62PRNMUQLZMMIIZB7EENTKNM6ILG2Q" -t "#"
        val inputString = listOf(
                """
                    {"end_device_ids":{"device_id":"dev-adeunis","application_ids":{"application_id":"app-adeunis-field-testing"},"dev_eui":"0018B20000022799","join_eui":"70B3D57ED00372AB","dev_addr":"019DE693"},"correlation_ids":["as:up:01EW5T9A9BENX9GBJSKTE4K12Z","gs:conn:01EW0YGGS4ERVW35R534VE7TBY","gs:up:host:01EW0YGGSD36BYXE0J0P640RFY","gs:uplink:01EW5T9A2N313QWHMAF30BB6FB","ns:uplink:01EW5T9A2P6SAMTPJKDRBQC4SQ","rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01EW5T9A2PNARTSYE49F6FRP6B"],"received_at":"2021-01-16T14:41:16.587539527Z","uplink_message":{"session_key_id":"AXcG0Y5w5hQbCPqDloJsBg==","f_port":1,"f_cnt":1354,"frm_payload":"nxFQUzZgAEREUDhKSw/uMwc=","decoded_payload":{"altitude":0,"battery":4078,"downlink":75,"latitude":50.889433333333336,"longitude":4.740833333333333,"rssi":-51,"sats":8,"snr":7,"temperature":17,"uplink":74},"rx_metadata":[{"gateway_ids":{"gateway_id":"dingnet-gw-ucll-2","eui":"1DEE161B2852537B"},"timestamp":2036135331,"rssi":-69,"channel_rssi":-69,"snr":10.2,"uplink_token":"Ch8KHQoRZGluZ25ldC1ndy11Y2xsLTISCB3uFhsoUlN7EKPr88oHGgwIjPaLgAYQ+N6IsgEguIn+mKHMJA=="}],"settings":{"data_rate":{"lora":{"bandwidth":125000,"spreading_factor":7}},"data_rate_index":5,"coding_rate":"4/5","frequency":"868100000","timestamp":2036135331},"received_at":"2021-01-16T14:41:16.374448376Z","consumed_airtime":"0.071936s"}}
                """.trimIndent(),
                """
                    {"end_device_ids":{"device_id":"rfsee-lorawan-tester-01","application_ids":{"application_id":"rfsee-lorawan-tester"},"dev_eui":"0018B20000021613","join_eui":"0018B24441524632","dev_addr":"260BBE8B"},"correlation_ids":["as:up:01EXCGY37GJ1EW9NY949XZ52K3","gs:conn:01EX1XQE3WY9RX8XXVJRTNM4MV","gs:up:host:01EX1XQE45EGB312YQV05GX05D","gs:uplink:01EXCGY30TMKK2WYS7XA19XS6Q","ns:uplink:01EXCGY30WV93RHTQ9V3NQC014","rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01EXCGY30V7YCW0K1DSPWV9TNK","rpc:/ttn.lorawan.v3.NsAs/HandleUplink:01EXCGY37F2ZFC7KQ9WDYTNW7G"],"received_at":"2021-01-31T15:28:14.577192435Z","uplink_message":{"session_key_id":"AXdZDvMXnxiWj6OLkN6KOg==","f_port":1,"f_cnt":1,"frm_payload":"jhQAAA7K","decoded_payload":{"battery_level":3786,"dl_counter":0,"payload":"8E1400000ECA","temperature":20,"ul_counter":0},"rx_metadata":[{"gateway_ids":{"gateway_id":"rfsee-dev-gateway-01","eui":"AF5EE01293673410"},"time":"2021-01-31T15:28:14.338848Z","timestamp":3500029692,"rssi":-76,"channel_rssi":-76,"snr":9,"uplink_token":"CiIKIAoUcmZzZWUtZGV2LWdhdGV3YXktMDESCK9e4BKTZzQQEPzt+IQNGgwIjpnbgAYQgamArQEg4JCb0O7vUA==","channel_index":7},{"gateway_ids":{"gateway_id":"ttn-apeldoorn-kadaster","eui":"0031552048001A06"},"timestamp":2124460052,"rssi":-111,"channel_rssi":-111,"snr":6.5,"location":{"latitude":52.211792995963776,"longitude":5.962387025356293,"altitude":65,"source":"SOURCE_REGISTRY"},"uplink_token":"CiQKIgoWdHRuLWFwZWxkb29ybi1rYWRhc3RlchIIADFVIEgAGgYQlOCC9QcaDAiOmduABhDc0r22ASCgnL+d6t5y","channel_index":7},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCGY312XJNS06KQZZ1WRNWX","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-2","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:28:14.370456915Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-8nrzc","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.377316519Z","sender_name":"router-dataplane-56fc9fb8fd-8nrzc","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.396791236Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:28:14.338852Z","rssi":-120,"channel_rssi":-120,"snr":-5.5,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU1RKbGJURkdUbGR3V2xGNlVsTlhWa3AwWld4T1ZFbHBkMmxrUjBadVNXcHZhVnBYYUZwVk1FVXhWVVU1TTFsNlVsQmtNM0J3VlZkU2RWcFZUblZrZVVvNUxtbEVRV2xvTUZWclEwaEVaak5EYmw5UFVFVklabWN1TkhCNlRYWmtjVzFpWW1weGNWZFlUaTQzWlU0M1NVSlNXa1J5UWxoSloxSlpWQzB3VmxKcmFscERRekZVVm5kQk5sQjFWRVp5T0dSbWRFZG9URkpmYVd0M1dUbDFibUZVZEhCcVNqWlJWM2d4ZUY5MmIzVm9hRkF6WldJd2FHY3lORzA1YzNNNFpGRTBWMFZrWTJSWWNqZHVhalpFTkZOSWRHeExaR1EzYmpacVF6WnlRMUV6U1ZadVJYQkNOMnB5WjJkd1ptUkJiakpIWDBVMVRTMUZiek56WW5OS01FeDJjWGMxYUZCNGIzTXVMWGx1TlZkQlkzVlZkakZtVXpOamMxSmhUWE5oUVE9PSIsImEiOnsiZm5pZCI6IjAwMDAxMyIsImZ0aWQiOiJ0dG4iLCJmY2lkIjoidHRuLXYyLWV1LTIifX0="},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCGY321255V98JJW0EZG194","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-4","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:28:14.401429388Z","sender_address":"52.169.150.138","receiver_name":"router-dataplane-56fc9fb8fd-8nrzc","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.407063222Z","sender_name":"router-dataplane-56fc9fb8fd-8nrzc","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.412983972Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:28:10.338843Z","rssi":-94,"channel_rssi":-94,"snr":8.8,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU1RSUFdGWm1ZMnRXY1ZwVVFtbGpiVnBoVlVkR2RrbHBkMmxrUjBadVNXcHZhVTVyTVZOTlZHUjZVekkxZWxveU1URlNSa1pFVEZob1IxVnVXVEphZVVvNUxtVnFhM1JQUlhOTmNsSTJXRUZ6Y1VwbFVtdGhRMUV1VUdFdFdrODNOazVNTXpWME1VZDFSaTUxYUZOa1RsOWpkbVpYUkRSQlZFWnhVbmQzUzBKVVFXSm9Xa2czYmpSRWQwaFhjM2RXY1RKb1owWk9PRGxhYzBKZmN6Sm1URTVXWTNaTVZEWm9hMmQ2T0RCUFNGTlVVVmxTZFZSTVdDMXFRV041ZWxBMlRWOVRNVXc1ZWsxdVZGRkZSMUJxTFVkU1JtSkpVRE5JTm5CemFGVkRNMFk1TTFWQldWQXdiWGxwTlZWVVNFRTBOVWhyUVcwM1MzQTRSVnAxTlRkV2QzQjZhMUJ1VGxKelVUVlBSMWhmV1dKVFIwdExUbmhYTGw5emVFb3pSVW94TTB3elltOHdWbkJvWmpSNFQxRT0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRuIiwiZmNpZCI6InR0bi12Mi1ldS00In19"},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCGY32BMTNEG2392EGWZDEW","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-1","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:28:14.411992139Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.446946888Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.469090821Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:28:14.349978923Z","rssi":-27,"channel_rssi":-27,"snr":9.75,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU2pOV01VcHJZWHBaZVZreE9VUmtWR2hHWTBoV00wbHBkMmxrUjBadVNXcHZhV0V6VmpGTmEwcFBWa1pzZFZWcVpISmtSRnBTVVZoR1RtTXdaelZSVTBvNUxuWkdkVTFpTkc1ME1UVktNRWRyWVZjM1JUZEZiM2N1Y1ZwUFNIUnBVa041U0ZaUmVFSjNRUzVQWlhvM2RsTk5NbWRtYW5WZmJITk5XVzlEUms1V01FWlZXbVYyV1hnMVJWSlZaV2h6WlhaRFpESTRaRGhPTjNSME9YZFJTWFIzWkdWdllYUlJXRUpzV21WbmRHRmlUMlJLTXpKdFdIRmtaREp2YWtsdk5UbHVZMjkwWm1aWWNGRnNUamRCTjB0WFRuTmpabXc1WlhWVGRIQldkMjFsVEhSUldpMVhNVmhZWjBobFRFTXRjVUo0TW1zeE0zZE9ibTlUU20wMWNGaGtjMUozYURoV1lWa3lja3BSZGtkaWVHRllkR2xuTGtSamEyTmlaRWRFWTJwTGVrVlZkRkpWU1U1VFlsRT0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRuIiwiZmNpZCI6InR0bi12Mi1ldS0xIn19"},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCGY320DKVX0TESS6M9A8KP","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-2","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:28:14.400851587Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.407023935Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.413047267Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:28:14.338844338Z","rssi":-39,"channel_rssi":-39,"snr":8.75,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU2xoVGJVWlZVVzFzVUU1VmVIVlhWRXBhVGtSS1JVbHBkMmxrUjBadVNXcHZhVk5XYUZST2EyZ3pUMFpPYVdGVlVrdFZWVkkwVkRGak5WZFljSFphZVVvNUxteFBNMUpNTkVzd05qSjZRamxsT0VWRE5GcEhVMmN1UmtGblgxcHdWbkpHUmt4eUxYZEdUQzV4VVdaeWIwTkNUbWhxV1RKZlJXSXhaR0ZPZVdrMWJWcERhSFJYT0RjeFZGOXpjRkphVmpCUFYyOVViRjlxTldJeGRqRnZTVkpXTFZwSk5VbFpaMXBLVVVSMFJrZG9NbkZLYTI5R1dsaFVRamRsVlZoVk5IZ3dUVFl4UkdoU1gxcHpOV1p6ZVV4M2RGQlRXRVZHV0daUFpqbGZNbkZrV2pGbVJHbENhMGxHY25sdmQyVmplRlJvVWxsUlYweGxVMDlUWmtWbWNrOWZObEo1WkVOSVFTNWxNRGxtZFhWVlRFeDZTWFZUZFMxWGMyZFhURk5uIiwiYSI6eyJmbmlkIjoiMDAwMDEzIiwiZnRpZCI6InR0biIsImZjaWQiOiJ0dG4tdjItZXUtMiJ9fQ=="},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCGY340K7DNHG7PKVSE4X32","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-2","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:28:14.464428515Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-8nrzc","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.474835228Z","sender_name":"router-dataplane-56fc9fb8fd-8nrzc","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.478006276Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:28:14Z","rssi":-36,"channel_rssi":-36,"snr":9.75,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU21oT00yeFlWRVZPZVdWRk9ETk9hbVJQVWxac1lVbHBkMmxrUjBadVNXcHZhV1JGVmxwbGF6Vk1WREpHU2xkcWFHMWxSekZDVFhwV1VVMHdWa1JWVTBvNUxtcG9VV3RZVmpONVltZFZSME5YVDNORk5sbG5hVUV1YUU1R1RFMWFMWEl4TkZwNFRYaENTUzVqZDIxcVZWaHlRa1ZOWHpnelUwTjZaMFZoVjBNMlFYSjVkVWgzZWpSV01uaEZOazAyTUVGZlFXcDNObTVPVVRSd1RqaFhUREpzUTI5bFZYRnRja0paUkhka2RGOVFYM1ZDYVZWV04yVlJiME40UkhwM2JYWjZVMUpIV1ZWeU1VZEtjRzVtUVdRNVdYUkpUMFZzV0hac1owaDBhbTVEWWw5bGNIWklUREZ5T0hoRVZteEdiakpCYVd0dWRsSmxhVFZaYzFGbFUwZFpMa0ZuY2tacE9VZDVUbGMyZFZsMWNFZDBTSGxGTldjPSIsImEiOnsiZm5pZCI6IjAwMDAxMyIsImZ0aWQiOiJ0dG4iLCJmY2lkIjoidHRuLXYyLWV1LTIifX0="},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCGY32DZ3MKVBV2JET53TSA","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-4","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:28:14.413762921Z","sender_address":"52.169.150.138","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.461409123Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-fg4tp","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:28:14.470687894Z","sender_name":"router-56fb7bcf99-fg4tp","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"rssi":-111,"channel_rssi":-111,"snr":6.5,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU2xKbGJVWnpZVlZzTWxnelFsUlJWWGQ0V0RJeFNrbHBkMmxrUjBadVNXcHZhVko2YUZoVFYzQlZZMFJvUTFSRlpHaFJNVnB4WWtkNGVtTnVVbGhSVTBvNUxraGpRbTA1ZFRsc1ZVNHdWMDV0TFdKVVMwUm5abWN1ZGtkS1FYTk5YMVZtVDFadU4wbGhkUzVNYTI1NmExQm9iV05hU2xWSU16Sk1TRkJqVDA1WE5HVnJPVWc1UzI5SFFXcEpUbk5hVFRkM05UZ3plVU5rTlRaUmJ6WnJXbXhmZEVOU1dqUlFWRkptZFZkd1dXRkpaRmN3TTNaSFRUVk1kRTE2U2xVMVpHZGtUM1V6V0hKQmEyWjFjMFJFWVRKeVRsUmtaVWxqYkZSRmFsWlZNblZrV0d0NGJsSnRXRTV4TVdSM2NXTk5hMmhWYjJoQ04ySnhObVZXYm5KdFp6ZHBUblEwV1VkMVNUWnpZMWczUlZwSVdsRjBUSFJQTGpaeGNDMTFWekp4VGxwbGFIaGtVamt4ZVhaclZVRT0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRuIiwiZmNpZCI6InR0bi12Mi1ldS00In19"}],"settings":{"data_rate":{"lora":{"bandwidth":125000,"spreading_factor":7}},"data_rate_index":5,"coding_rate":"4/5","frequency":"867900000","timestamp":3500029692,"time":"2021-01-31T15:28:14.338848Z"},"received_at":"2021-01-31T15:28:14.364156560Z","confirmed":true,"consumed_airtime":"0.051456s"}}
                """.trimIndent(),
                """
                    {"end_device_ids":{"device_id":"rfsee-lorawan-tester-01","application_ids":{"application_id":"rfsee-lorawan-tester"},"dev_eui":"0018B20000021613","join_eui":"0018B24441524632","dev_addr":"260BBE8B"},"correlation_ids":["as:up:01EXCH3H696YD4A5WC54Y8CAS2","gs:conn:01EX1XQE3WY9RX8XXVJRTNM4MV","gs:up:host:01EX1XQE45EGB312YQV05GX05D","gs:uplink:01EXCH3GZKAB2NCQK2GW8DSR42","ns:uplink:01EXCH3GZNPKPQZD7KBWT6QTKW","rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01EXCH3GZNQQ76WW8F6W027063","rpc:/ttn.lorawan.v3.NsAs/HandleUplink:01EXCH3H66EKMR9CM6W93VRC3Q"],"received_at":"2021-01-31T15:31:12.713986158Z","uplink_message":{"session_key_id":"AXdZDvMXnxiWj6OLkN6KOg==","f_port":1,"f_cnt":2,"frm_payload":"vxZSEmmQAFWQEDcBAQ7HTwc=","decoded_payload":{"battery_level":3783,"dl_counter":1,"gps_quality":"Poor","hdop":3,"lat":52.21165,"lati_hemisphere":"North","latitude":52.21165,"latitude_dmm":"N 52°12.699","lon":5.9835,"long_hemisphere":"East","longitude":5.9835,"longitude_dmm":"E 005°59.01","payload":"BF1652126990005590103701010EC74F07","rssi_dl":-79,"sats":7,"snr_dl":7,"temperature":22,"trigger":"pushbutton","ul_counter":1},"rx_metadata":[{"gateway_ids":{"gateway_id":"rfsee-dev-gateway-01","eui":"AF5EE01293673410"},"time":"2021-01-31T15:31:12.471248Z","timestamp":3678161924,"rssi":-81,"channel_rssi":-81,"snr":8,"uplink_token":"CiIKIAoUcmZzZWUtZGV2LWdhdGV3YXktMDESCK9e4BKTZzQQEISY8dkNGgwIwJrbgAYQ6NOc7gEgoN+jnIb1UA==","channel_index":5},{"gateway_ids":{"gateway_id":"ttn-apeldoorn-kadaster","eui":"0031552048001A06"},"timestamp":2302592444,"rssi":-93,"channel_rssi":-93,"snr":8,"location":{"latitude":52.211792995963776,"longitude":5.962387025356293,"altitude":65,"source":"SOURCE_REGISTRY"},"uplink_token":"CiQKIgoWdHRuLWFwZWxkb29ybi1rYWRhc3RlchIIADFVIEgAGgYQvIv7yQgaDAjAmtuABhCwv/f9ASDgzNHpgeRy","channel_index":5},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCH3H0RMVG6WXS3XDMKQTQ7","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-1","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:31:12.536860581Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.539340261Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.542997080Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:31:12.482182979Z","rssi":-35,"channel_rssi":-35,"snr":6.75,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU20xVWJYQXpZakpvWVZOSGIzaE9SVkp3VDFkNE5VbHBkMmxrUjBadVNXcHZhV0pIVVhwVVZsSmFXV3BzUTJKWFdsRlVSVTVLV1cxcmVsZFdRbmxWVTBvNUxreHZZazlyZFRoZlprVjJSR1IxZGpBdGRERkRTRUV1WW14MGNIcGhRVXR5TVVkT2MzTkxTQzR3YzIwM1JuQmFUME5FUTFJNE5GbEhaR3RuWmxSV1JteERUVWhMU0ZGVlpYZ3pURzlNT0ZaMlpHTllTbXhaWmxaTFIycHJORWQzWlRSUFFrTjFUVjlxYkVwdmIwaDFVRWxHVjFobGJVWjNhMEpJUjBGMFprMUxVVGRuY213MmMzRkxOa1pPVW1wM1gwRkpPVU5FVEhKWVoydEhXRmN4T0UwMlRVcGxXVGxYTWs4eFUwUm5RbnA1ZWxwa2RHczVjSEY0TTB4Mk9EWnphbEo0ZFVaM1QwdzFja2x6ZVU5bVZWRklibFpVTGxReldIaGtTMUExVFhZeGFWOWhNa05sVnkxTmRIYz0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRuIiwiZmNpZCI6InR0bi12Mi1ldS0xIn19"},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCH3H0R1P072WN3SEQE5DBD","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-4","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:31:12.536102492Z","sender_address":"52.169.150.138","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.538835708Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-fg4tp","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.546854847Z","sender_name":"router-56fb7bcf99-fg4tp","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"rssi":-93,"channel_rssi":-93,"snr":8,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU2taamJIQm9XVzVSTTJSSWJGWk9ia1pxWVVaS2QwbHBkMmxrUjBadVNXcHZhVll6Vm05V2JGcERUVE5LVDFsdVVuSk5SM1JLVkVaT1RsWkhkelJWVTBvNUxtbGtaRUpWTWtZM2RFbzViRmRPUVVScWVHNTZjWGN1TlZWdlRXUkJOV1JLVldvMGEzaHVNaTV1YkUxZlZUVlpMVlZDWm1KSWFGUTRZME13ZGpGU05YSjFjbVpDYVVveldVWlFkMGh1WldzelVFRk9VSFEzUWxRd1QyMVRSVzF3TTNkNmNuaDZZM1Z4Y1RRek9TMWtNR1Z2YlROV1UyMXNOWFY0U1ZsblNGaHNiVmh5UXpVeFFXWmxOMDlOUjA5cFRXNXdNM0ZUZWpSRGJVa3hSVlpmVUY5U1RHWnFjQzFyZEdSZlYyWnRVbWhSZUZobU0ycHpjM040VWtaaFJtVm1VazlRTjBOdVZFMUJWV2h3T1U5UlVqWTBNRTlWTG1SbFpVTTBTMHR4VUVKd2EyOUNaVXAxYjNSUlVsRT0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRuIiwiZmNpZCI6InR0bi12Mi1ldS00In19"},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCH3GZBR9PNXTB2AM0FDRXH","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-2","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:31:12.491720139Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-8nrzc","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.500618825Z","sender_name":"router-dataplane-56fc9fb8fd-8nrzc","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.503113785Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:31:12.471253Z","rssi":-111,"channel_rssi":-111,"snr":5.25,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU210WmJFSkxaRlZHZW1SVk1YUmFWV3hQVlVkV05FbHBkMmxrUjBadVNXcHZhVlY2VVhwU1V6RTBVekExZUUxc1l6RlNhelI1WkVSa2NtTXpiRXRWVTBvNUxtSTVha1V0UkRoVGN6SmhkMFpyYjBOT1pFUXdOVkV1ZUdoSVkwOWpabmxXWjFNM2FEbE9NaTVRVTNCcFRqbDRPVWxvVGxNelNUVlJTMXBqVVRoMGRXMHhObWxZVEcxcGR6TkxVMFpYY0doMFVtNHhlRFZ4YVRSMVVVdE9iRUZvU25KU2RFWjRXRXBsUzJkbFowZFlYek56YnpOWlgxbDRWMmxZVWxSRGREaFRNbkJ2T0dOaVExVm9TazFyWkdkUVlXdFpOMjVRZDNad09WZFVjVk5HUVRoSU4xVnliMjF3ZUdoa2VYRk1XVzFZZG1zeFNra3lOa3hMWDNwSVJHUm9lbkUyYTFVM2RYTXVjMU41VjAxTlduaDZPVFJHVUhkV1pVRlNjbVU0UVE9PSIsImEiOnsiZm5pZCI6IjAwMDAxMyIsImZ0aWQiOiJ0dG4iLCJmY2lkIjoidHRuLXYyLWV1LTIifX0="},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCH3H1Y7FWSK0PKVFQMWCXK","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-2","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:31:12.574654655Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.579582629Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.582030914Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:31:12Z","rssi":-49,"channel_rssi":-49,"snr":8.25,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU25Sa00wSmhVMVpLTkZWdVJrZFVlbWhvVkRCd1IwbHBkMmxrUjBadVNXcHZhVmx1VG5wVGEwNHpZVzVXYm1SSGREUlRWM1JYVFROV1ZtRnNaSFZrZVVvNUxtMU9aVFZLYzFoQ2JUTXpSMWQwUTFaWGJta3daRkV1TTJ0SFFTMWllRWR3WTFKSFpFTnBUaTV4Vm5kUVVrNUlNRzlKUmpoamQwTkpRVXhJVFZKdU1EZERURkZaUmtkZlFUWktOamhZVFVoTVUwVklPRzFvYkVOSFJtbE9MVlY0YTJFeU1HTm9NekZmUTNGUU0zRkVTemd6UmtoTWJFZFplVFJMT0U1cVpVbG1OMU55YnpaVE0yVlhSVkJwVFVseFNFWmpNMFphYm5rdE9HUndTM001TkVZeU5rWlpZMVpIZG5WRGVXcHVhbXR5UldGa2EyMUZOUzFuZHpaSFNGZEZMamgyTjNSQlYwRkhUbWxtWWxodFJFTkRORXB0Y1hjPSIsImEiOnsiZm5pZCI6IjAwMDAxMyIsImZ0aWQiOiJ0dG4iLCJmY2lkIjoidHRuLXYyLWV1LTIifX0="},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCH3GZSTHT33J8NQX2D26VG","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-4","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:31:12.505743716Z","sender_address":"52.169.150.138","receiver_name":"router-dataplane-56fc9fb8fd-8nrzc","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.515026598Z","sender_name":"router-dataplane-56fc9fb8fd-8nrzc","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-fg4tp","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.520332489Z","sender_name":"router-56fb7bcf99-fg4tp","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:31:08.471249Z","rssi":-82,"channel_rssi":-82,"snr":8.2,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU1hsWmJXeFBVVE5LU0dWck9YUlpNbXhvVVc1a2VVbHBkMmxrUjBadVNXcHZhV1ZFYkZKVlZVVjRWa1prZFZSV2F6UlRibFoxVjBVeGVtRkVRbGRrZVVvNUxsOUxNbVZDTFRCNlgxVlZVMkp3Y21KT2JHeFdjR2N1WDA1aldVbEtabFl0YzJOVFlrdDVSUzVHVkd0b1NHSjRlbmR5V0dKSk0wMDBNV051UnpVdFdqZHljVmt4Y2xGRVRGVldTRlZXUVZZNGNYUlhNMFpoZUVNNU1qSlFlRTQxVlRkTFEzaEdTMXA1TUVoRFkzVXRjMVF6UVRnemNWQTBTbFUxWlROUWNtSkVWRGhpVkhkdk5ubGllSFJtYzNodVYzRlVjVmhpZVRrNU5UazFTVEpTV0dsalN6UkVXbkZOWDFSamJtSlROazE2YUdjNWFqZGZZMnhSZDNkb2VuTktSbmRFT0dGQmRVeFRiblZZUnpadExWWjNjREpVTGxoeWJFTmhiVlEzYzJsaVdtWktiRVJyTjI1R1dGRT0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRuIiwiZmNpZCI6InR0bi12Mi1ldS00In19"},{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01EXCH3GZK58HDQ6CW6VNVGR4H","forwarder_net_id":"000013","forwarder_tenant_id":"ttn","forwarder_cluster_id":"ttn-v2-eu-2","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-01-31T15:31:12.499977204Z","sender_address":"52.169.73.251","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.503147189Z","sender_name":"router-dataplane-56fc9fb8fd-d9wh4","sender_address":"kafkapb://router?topic=forwarder_uplink","receiver_name":"router-56fb7bcf99-tfjlx","receiver_agent":"pbrouter/1.2.0-rc.1 go/1.15.6 linux/amd64"},{"received_at":"2021-01-31T15:31:12.506475428Z","sender_name":"router-56fb7bcf99-tfjlx","sender_address":"kafkapb://ttn-eu1?topic=deliver_000013.ttn.ttn-eu1_uplink","receiver_name":"router-dataplane-56fc9fb8fd-d9wh4","receiver_agent":"pbdataplane/1.2.0-rc.1 go/1.15.6 linux/amd64"}]},"time":"2021-01-31T15:31:12.471243471Z","rssi":-55,"channel_rssi":-55,"snr":7.75,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU2pCVWEwcHZZMGRLUzFwSE1YZGtNVXB5WkRKd2FVbHBkMmxrUjBadVNXcHZhVkpzVGsxT1IzUnJWRmhyZEZOSVNtWmphM0JaVVd0R1ExZFlUa2xSVTBvNUxqTjZiR2hoYVZWV01IQk5aMU55WkVkT05USlBWRkV1VUVzek1uRktVRE0xUldFMlZtSjBTQzVPVTJwQ1RGbEJXRkZHUlRWVGVtMUNUMlV4ZFcxM1NsZHZhRGxKVEVWaFNrZFJiVXR1WVdGNmVIcDVXSFpKWW5wNlNHUndjVzVFVmpSbk5YRmpXRUprVjJsd1ZFRlJZVUV3ZFdsbVVVSnhiM0pXUjJoclZGcEhZa3hOYlRFMk9YUnRhRFZqUlhSUmRYQXRRVkpHTkhNMGFFOTZkMmhST1hSck1HSnNibDgxYUdSVE1URmpiR2hXUzNsNVFVOTJaamxTTVhZd2EyNVBWR2RRUTA1eGR5NXpTVzE0ZFMxT1oyMHhhM1JXVEc0dE9GTldkM1ZCIiwiYSI6eyJmbmlkIjoiMDAwMDEzIiwiZnRpZCI6InR0biIsImZjaWQiOiJ0dG4tdjItZXUtMiJ9fQ=="}],"settings":{"data_rate":{"lora":{"bandwidth":125000,"spreading_factor":7}},"data_rate_index":5,"coding_rate":"4/5","frequency":"867500000","timestamp":3678161924,"time":"2021-01-31T15:31:12.471248Z"},"received_at":"2021-01-31T15:31:12.501557886Z","confirmed":true,"consumed_airtime":"0.071936s"}}
                """.trimIndent(),
            // v3/izinto-globalsat-lt100@ttn/devices/eui-000db5360a6b366c/up
                """  
                    {"end_device_ids":{"device_id":"eui-000db5360a6b366c","application_ids":{"application_id":"izinto-globalsat-lt100"},"dev_eui":"000DB5360A6B366C","join_eui":"0000000000010203","dev_addr":"260B7FD2"},"correlation_ids":["as:up:01F9K0VXR63JJR5SPS3YQPY78N","ns:uplink:01F9K0VXHE79S1P0R1C3XXJ1R7","pba:conn:up:01F993JG9D87TPJHFQRPC5AE7N","pba:uplink:01F9K0VXH37W7AATGT8G1RQC3S","rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01F9K0VXHED81HSTWCBPYBNAXK","rpc:/ttn.lorawan.v3.NsAs/HandleUplink:01F9K0VXR5YC9ARXA53TC6NNNT"],"received_at":"2021-07-02T07:10:29.127370414Z","uplink_message":{"session_key_id":"AXpmDKc/yUU7Q47Kk7eqwQ==","f_port":2,"f_cnt":1,"frm_payload":"AAYF/fnkMQFWUpk=","decoded_payload":{"battery":5,"gps_status":0,"gps_valid":0,"latitude":-33.954767,"longitude":22.434457,"message_type":6},"rx_metadata":[{"gateway_ids":{"gateway_id":"packetbroker"},"packet_broker":{"message_id":"01F9K0VXH37W7AATGT8G1RQC3S","forwarder_net_id":"000013","forwarder_tenant_id":"ttnv2","forwarder_cluster_id":"ttn-v2-eu-3","home_network_net_id":"000013","home_network_tenant_id":"ttn","home_network_cluster_id":"ttn-eu1","hops":[{"received_at":"2021-07-02T07:10:28.899411207Z","sender_address":"40.113.68.198","receiver_name":"router-dataplane-55c876b6f6-dmjsg","receiver_agent":"pbdataplane/1.6.1 go/1.16.5 linux/amd64"},{"received_at":"2021-07-02T07:10:28.903247631Z","sender_name":"router-dataplane-55c876b6f6-dmjsg","sender_address":"forwarder_uplink","receiver_name":"router-79f7b6658f-n6925","receiver_agent":"pbrouter/1.6.1 go/1.16.5 linux/amd64"},{"received_at":"2021-07-02T07:10:28.909286458Z","sender_name":"router-79f7b6658f-n6925","sender_address":"deliver.000013_ttn_ttn-eu1.uplink","receiver_name":"router-dataplane-55c876b6f6-dmjsg","receiver_agent":"pbdataplane/1.6.1 go/1.16.5 linux/amd64"}]},"time":"2021-07-02T07:10:17.188226Z","rssi":-47,"channel_rssi":-47,"snr":11,"uplink_token":"eyJnIjoiWlhsS2FHSkhZMmxQYVVwQ1RWUkpORkl3VGs1VE1XTnBURU5LYkdKdFRXbFBhVXBDVFZSSk5GSXdUazVKYVhkcFlWaFphVTlwU25SWGJUVmFZV3RzUzFGcldURk9NRVp3VlZac1NrbHBkMmxrUjBadVNXcHZhV0pWU2tWaVIwWlVaVVprV2xWRVZqRlhSbHBHVWxSRmVWUkZaRUpSVTBvNUxtbFpjME4xWVZSWU9YUXpka3BqTFRnMVkwbEtlbmN1Y1dSNlNUVm9VV3MyVDBOUWNsZHJWeTR3ZGxsWVdqQnFVMDkyVUdnd2QzVXdXa3R5Y3pCQ2JFcDFVVmhzWjNsM09HdDRTVUZYVkV4SlVHZ3RXbFY0YW10UGFTMXpkVWRDTnkxTlJsUlhVVEJGVDNwUGJYZHpkV2x0WnpnMVEwRTFhRzE0TTB0UGRYTkJVVkZzVVV4c1YxQnNiRzFtWlZFeFpWTTJYMXBDTTJwWk5uVnNXRTFGVlcxTVYxSjZRMlE0UVRZeE1YWktNVTF5V205NWQyWlRVVjlITVdSSk9IaFFTVEJyV2xSbVJFbE9jRXBsWW1wSWFreHNiRVJrTGs5Tk5uY3lhekJWTWpWU2IwbEpkMHRFYVY5NmFWRT0iLCJhIjp7ImZuaWQiOiIwMDAwMTMiLCJmdGlkIjoidHRudjIiLCJmY2lkIjoidHRuLXYyLWV1LTMifX0="}],"settings":{"data_rate":{"lora":{"bandwidth":125000,"spreading_factor":12}},"coding_rate":"4/5","frequency":"867300000"},"received_at":"2021-07-02T07:10:28.910738416Z","consumed_airtime":"1.482752s"}}
                """.trimIndent(),
            """
                {"end_device_ids":{"device_id":"cricket-002","application_ids":{"application_id":"jpm-crickets"},"dev_addr":"260BEAC2"},"correlation_ids":["as:up:01FPD44VX5JBK3M9CWPKQVBVCB","gs:conn:01FP57XXKFMQD9JTFHVC17GG94","gs:up:host:01FP57XXKPQ23DEKRGRKYSM7HY","gs:uplink:01FPD44VPFCYECGJ9SKB8PGSBN","ns:uplink:01FPD44VPHPJHGM2N013JSH8W8","rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01FPD44VPHA6STQ4DEWE33YEMB","rpc:/ttn.lorawan.v3.NsAs/HandleUplink:01FPD44VX4KWH7RGRP1RKQ4YES"],"received_at":"2021-12-08T13:36:24.998294048Z","uplink_message":{"f_cnt":37121,"rx_metadata":[{"gateway_ids":{"gateway_id":"eui-60c5a8fffe71a964","eui":"60C5A8FFFE71A964"},"timestamp":2488393588,"rssi":-64,"channel_rssi":-64,"snr":9,"location":{"latitude":-33.936644228282525,"longitude":18.87102216482163,"altitude":190,"source":"SOURCE_REGISTRY"},"uplink_token":"CiIKIAoUZXVpLTYwYzVhOGZmZmU3MWE5NjQSCGDFqP/+calkEPS+x6IJGgwI2OnCjQYQvNTF9QIgoLrD/rWRPA==","channel_index":6}],"settings":{"data_rate":{"lora":{"bandwidth":125000,"spreading_factor":7}},"coding_rate":"4/5","frequency":"868300000","timestamp":2488393588},"received_at":"2021-12-08T13:36:24.785388931Z","consumed_airtime":"0.041216s","network_ids":{"net_id":"000013","tenant_id":"ttn","cluster_id":"ttn-eu1"}}}
            """.trimIndent(),
            """
                {
      "@type":"type.googleapis.com/ttn.lorawan.v3.ApplicationUp",
      "end_device_ids":{
         "device_id":"jfmateos-geocaching-05",
         "application_ids":{
            "application_id":"jfmateos-ttnmapper"
         },
         "dev_eui":"00D45D10573B2B53",
         "dev_addr":"26013A0E"
      },
      "correlation_ids":[
         "as:up:01FQ4ERQC1WBMNPKMY6JW1HTZY",
         "gs:conn:01FNXTRBGYRW5SYT80NRZZ8WMS",
         "gs:up:host:01FNXTRBHJG39JT2XNY5GS7JTJ",
         "gs:uplink:01FQ4ERQ5D4CXQTE3RVXYS6MRQ",
         "ns:uplink:01FQ4ERQ5EWYQQ5DYVA3N1C0XD",
         "rpc:/ttn.lorawan.v3.GsNs/HandleUplink:01FQ4ERQ5EPW23TGJAVX4P0D0F",
         "rpc:/ttn.lorawan.v3.NsAs/HandleUplink:01FQ4ERQC0KG0YAPM6C317BQXP"
      ],
      "received_at":"2021-12-17T15:04:33.411001490Z",
      "uplink_message":{
         "f_port":8,
         "f_cnt":1,
         "frm_payload":"AQIBFg==",
         "rx_metadata":[
            {
               "gateway_ids":{
                  "gateway_id":"jfmateos-rak831",
                  "eui":"B827EBFFFE8D9794"
               },
               "timestamp":2837542516,
               "rssi":-111,
               "channel_rssi":-111,
               "snr":3.8,
               "location":{
                  "latitude":40.373927371497,
                  "longitude":-3.7317764124003943,
                  "source":"SOURCE_REGISTRY"
               },
               "uplink_token":"Ch0KGwoPamZtYXRlb3MtcmFrODMxEgi4J+v//o2XlBD07IXJChoLCIHO8o0GEJmDl14goOra1crIpwI=",
               "channel_index":7
            },
            {
               "gateway_ids":{
                  "gateway_id":"ttnmad-carabanchel",
                  "eui":"3436323839001B00"
               },
               "time":"2021-12-17T15:04:31.562493Z",
               "timestamp":1179076218,
               "rssi":-109,
               "channel_rssi":-109,
               "snr":-4.25,
               "location":{
                  "latitude":40.370456495585564,
                  "longitude":-3.748582029605026,
                  "altitude":687,
                  "source":"SOURCE_REGISTRY"
               },
               "uplink_token":"CiAKHgoSdHRubWFkLWNhcmFiYW5jaGVsEgg0NjI4OQAbABD6jJ2yBBoLCIHO8o0GEMzB4WIgkJmts6jfPyoMCP/N8o0GEMjsm4wC",
               "channel_index":7
            }
         ],
         "settings":{
            "data_rate":{
               "lora":{
                  "bandwidth":125000,
                  "spreading_factor":7
               }
            },
            "coding_rate":"4/5",
            "frequency":"867900000",
            "timestamp":2837542516
         },
         "received_at":"2021-12-17T15:04:33.198494410Z",
         "consumed_airtime":"0.051456s",
         "network_ids":{
            "net_id":"000013",
            "tenant_id":"ttn",
            "cluster_id":"ttn-eu1"
         }
      }
   }
            """.trimIndent()
        )
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .add(OffsetDateTimeAdapter())
            .add(org.ttnmapper.phonesurveyor.model.ttnV3.TtsByteArrayAdapter)
            .build()

        inputString.forEach {
            val jsonAdapter = moshi.adapter(V3ApplicationUp::class.java)
            val ttnMessage = jsonAdapter.fromJson(it)

            if (ttnMessage == null) {
                System.out.println("V3 Message not parsed")
                return
            } else {
                System.out.println("V3 Parsed")
                System.out.println(ttnMessage)

                val ttnMapperUplinkMessage = ObjectCopy.ttnV3UplinkToTtnMapperUplink(ttnMessage)

                print(ttnMapperUplinkMessage)
            }
        }
    }



    @Test
    fun TestParseChirpstack() {
        val inputString = listOf(
                """
                    {
   "applicationID":"1",
   "applicationName":"test-application",
   "deviceName":"test-device",
   "devEUI":"0004a30b001c684f",
   "rxInfo":[
      {
         "gatewayID":"3133303748005c00",
         "uplinkID":"37e0cc8f-a9f2-4ed2-bf0f-c408d272113d",
         "name":"mikrotik",
         "time":"2021-01-02T08:08:46.776009Z",
         "rssi":-89,
         "loRaSNR":7.5,
         "location":{
            "latitude":-33.9586553,
            "longitude":22.441055499999997,
            "altitude":200
         }
      }
   ],
   "txInfo":{
      "frequency":867100000,
      "dr":5
   },
   "adr":false,
   "fCnt":0,
   "fPort":1,
   "data":"AA=="
}
                """.trimIndent()
        )
        val moshi = Moshi.Builder()
//                .add(KotlinJsonAdapterFactory())
                .add(OffsetDateTimeAdapter())
                .build()

        inputString.forEach {
            val jsonAdapter = moshi.adapter(UplinkEvent::class.java)
            val ttnMessage = jsonAdapter.fromJson(it)

            if (ttnMessage == null) {
                System.out.println("Chirp Message not parsed")
                return
            } else {
                System.out.println("Chirp Parsed")
            }
        }
    }
}