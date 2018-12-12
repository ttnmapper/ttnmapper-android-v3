package org.ttnmapper.phonesurveyor.model

import com.squareup.moshi.Json

data class TtnApplication(

        @field:Json(name = "id")
        var id: String?,
        @field:Json(name = "name")
        var name: String?,
        @field:Json(name = "euis")
        var euis: List<String?>?,
        @field:Json(name = "created")
        var created: String,
        @field:Json(name = "rights")
        var rights: List<String?>?,
        @field:Json(name = "collaborators")
        var collaborators: List<Collaborator?>?,
        @field:Json(name = "access_keys")
        var accessKeys: List<AccessKey?>?,

        var handlerId: String?,
        var mqttAddress: String?,
        var apiAddress: String?,
        var netAddress: String?,

        var devices: List<Device?>?
)

data class AccessKey(

        @field:Json(name = "name")
        var name: String?,
        @field:Json(name = "rights")
        var rights: List<String?>?,
        @field:Json(name = "key")
        var key: String?,
        @field:Json(name = "_id")
        var id: String

)

data class Collaborator(

        @field:Json(name = "username")
        var username: String?,
        @field:Json(name = "email")
        var email: String?,
        @field:Json(name = "rights")
        var rights: List<String?>?

)

class TtnDevices(
        @field:Json(name = "devices")
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

        @field:Json(name = "app_id")
        var appId: String?,
        @field:Json(name = "dev_id")
        var devId: String?,
        @field:Json(name = "lorawan_device")
        var lorawanDevice: LorawanDevice?,
        @field:Json(name = "description")
        var description: String?

) {
    override fun toString(): String = devId ?: "<dev_id not set>"
}

class LorawanDevice(

        @field:Json(name = "app_eui")
        var appEui: String?,
        @field:Json(name = "dev_eui")
        var devEui: String?,
        @field:Json(name = "app_id")
        var appId: String?,
        @field:Json(name = "dev_id")
        var devId: String?,
        @field:Json(name = "dev_addr")
        var devAddr: String?,
        @field:Json(name = "nwk_s_key")
        var nwkSKey: String?,
        @field:Json(name = "app_s_key")
        var appSKey: String?,
        @field:Json(name = "app_key")
        var appKey: String?,
        @field:Json(name = "disable_f_cnt_check")
        var isDisableFCntCheck: Boolean? = false,
        @field:Json(name = "uses32_bit_f_cnt")
        var isUses32BitFCnt: Boolean? = false,
        @field:Json(name = "activation_constraints")
        var activationConstraints: String?

)