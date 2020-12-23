package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

data class TtnApplication(
        var id: String?,
        var name: String?,
        var euis: List<String?>?,
        var created: String,
        var rights: List<String?>?,
        var collaborators: List<Collaborator?>?,
        var access_keys: List<AccessKey?>?,

        var handlerId: String?,
        var mqttAddress: String?,
        var apiAddress: String?,
        var netAddress: String?,

        var devices: List<Device?>?
)

data class AccessKey(
        var name: String?,
        var rights: List<String?>?,
        var key: String?,
        @Json(name = "_id")
        var id: String?
)

data class Collaborator(
        var username: String?,
        var email: String?,
        var rights: List<String?>?
)

class TtnDevices(
        var devices: List<Device?>?
) {
    override fun toString(): String {
        var toReturn = ""
        devices?.forEach {
            toReturn += it.toString() + ", "
        }
        toReturn.trim(',')

        return toReturn
    }
}

class Device(
        var app_id: String?,
        var dev_id: String?,
        var lorawan_device: LorawanDevice?,
        var description: String?

) {
    override fun toString(): String = dev_id ?: "<dev_id not set>"
}

class LorawanDevice(
        var app_eui: String?,
        var dev_eui: String?,
        var app_id: String?,
        var dev_id: String?,
        var dev_addr: String?,
        var nwk_s_key: String?,
        var app_s_key: String?,
        var app_key: String?,
        var disable_f_cnt_check: Boolean? = false,
        var uses32_bit_f_cnt: Boolean? = false,
        var activation_constraints: String?
)