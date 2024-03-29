/**
 * The Things Stack for LoRaWAN v3 API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: version not set
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.apis

import org.openapitools.client.models.RuntimeError
import org.openapitools.client.models.V3CreateEndDeviceRequest
import org.openapitools.client.models.V3EndDevice
import org.openapitools.client.models.V3EndDevices
import org.openapitools.client.models.V3UpdateEndDeviceRequest

import org.openapitools.client.infrastructure.ApiClient
import org.openapitools.client.infrastructure.ApiInfrastructureResponse
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.ClientError
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.infrastructure.ServerError
import org.openapitools.client.infrastructure.MultiValueMap
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod
import org.openapitools.client.infrastructure.ResponseType
import org.openapitools.client.infrastructure.Success
import org.openapitools.client.infrastructure.toMultiValue

class EndDeviceRegistryApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
    * Create a new end device within an application.
    * After registering an end device, it also needs to be registered in the NsEndDeviceRegistry that is exposed by the Network Server, the AsEndDeviceRegistry that is exposed by the Application Server, and the JsEndDeviceRegistry that is exposed by the Join Server.
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param body  
    * @return V3EndDevice
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryCreate(endDeviceIdsApplicationIdsApplicationId: kotlin.String, body: V3CreateEndDeviceRequest) : V3EndDevice {
        val localVarResponse = endDeviceRegistryCreateWithHttpInfo(endDeviceIdsApplicationIdsApplicationId = endDeviceIdsApplicationIdsApplicationId, body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3EndDevice
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Create a new end device within an application.
    * After registering an end device, it also needs to be registered in the NsEndDeviceRegistry that is exposed by the Network Server, the AsEndDeviceRegistry that is exposed by the Application Server, and the JsEndDeviceRegistry that is exposed by the Join Server.
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param body  
    * @return ApiInfrastructureResponse<V3EndDevice?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryCreateWithHttpInfo(endDeviceIdsApplicationIdsApplicationId: kotlin.String, body: V3CreateEndDeviceRequest) : ApiInfrastructureResponse<V3EndDevice?> {
        val localVariableConfig = endDeviceRegistryCreateRequestConfig(endDeviceIdsApplicationIdsApplicationId = endDeviceIdsApplicationIdsApplicationId, body = body)

        return request<V3CreateEndDeviceRequest, V3EndDevice>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceRegistryCreate
    *
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param body  
    * @return RequestConfig
    */
    fun endDeviceRegistryCreateRequestConfig(endDeviceIdsApplicationIdsApplicationId: kotlin.String, body: V3CreateEndDeviceRequest) : RequestConfig<V3CreateEndDeviceRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/applications/{end_device.ids.application_ids.application_id}/devices".replace("{"+"end_device.ids.application_ids.application_id"+"}", "$endDeviceIdsApplicationIdsApplicationId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Delete the end device with the given IDs.
    * Before deleting an end device it first needs to be deleted from the NsEndDeviceRegistry, the AsEndDeviceRegistry and the JsEndDeviceRegistry. This is NOT done automatically.
    * @param applicationIdsApplicationId  
    * @param deviceId  
    * @param devEui The LoRaWAN DevEUI. (optional)
    * @param joinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). (optional)
    * @param devAddr The LoRaWAN DevAddr. (optional)
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryDelete(applicationIdsApplicationId: kotlin.String, deviceId: kotlin.String, devEui: kotlin.ByteArray?, joinEui: kotlin.ByteArray?, devAddr: kotlin.ByteArray?) : kotlin.Any {
        val localVarResponse = endDeviceRegistryDeleteWithHttpInfo(applicationIdsApplicationId = applicationIdsApplicationId, deviceId = deviceId, devEui = devEui, joinEui = joinEui, devAddr = devAddr)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Any
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Delete the end device with the given IDs.
    * Before deleting an end device it first needs to be deleted from the NsEndDeviceRegistry, the AsEndDeviceRegistry and the JsEndDeviceRegistry. This is NOT done automatically.
    * @param applicationIdsApplicationId  
    * @param deviceId  
    * @param devEui The LoRaWAN DevEUI. (optional)
    * @param joinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). (optional)
    * @param devAddr The LoRaWAN DevAddr. (optional)
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryDeleteWithHttpInfo(applicationIdsApplicationId: kotlin.String, deviceId: kotlin.String, devEui: kotlin.ByteArray?, joinEui: kotlin.ByteArray?, devAddr: kotlin.ByteArray?) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = endDeviceRegistryDeleteRequestConfig(applicationIdsApplicationId = applicationIdsApplicationId, deviceId = deviceId, devEui = devEui, joinEui = joinEui, devAddr = devAddr)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceRegistryDelete
    *
    * @param applicationIdsApplicationId  
    * @param deviceId  
    * @param devEui The LoRaWAN DevEUI. (optional)
    * @param joinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). (optional)
    * @param devAddr The LoRaWAN DevAddr. (optional)
    * @return RequestConfig
    */
    fun endDeviceRegistryDeleteRequestConfig(applicationIdsApplicationId: kotlin.String, deviceId: kotlin.String, devEui: kotlin.ByteArray?, joinEui: kotlin.ByteArray?, devAddr: kotlin.ByteArray?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (devEui != null) {
                    put("dev_eui", listOf(devEui.toString()))
                }
                if (joinEui != null) {
                    put("join_eui", listOf(joinEui.toString()))
                }
                if (devAddr != null) {
                    put("dev_addr", listOf(devAddr.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/applications/{application_ids.application_id}/devices/{device_id}".replace("{"+"application_ids.application_id"+"}", "$applicationIdsApplicationId").replace("{"+"device_id"+"}", "$deviceId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get the end device with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
    * 
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param endDeviceIdsDeviceId  
    * @param endDeviceIdsDevEui The LoRaWAN DevEUI. (optional)
    * @param endDeviceIdsJoinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). (optional)
    * @param endDeviceIdsDevAddr The LoRaWAN DevAddr. (optional)
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @return V3EndDevice
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryGet(endDeviceIdsApplicationIdsApplicationId: kotlin.String, endDeviceIdsDeviceId: kotlin.String, endDeviceIdsDevEui: kotlin.ByteArray?, endDeviceIdsJoinEui: kotlin.ByteArray?, endDeviceIdsDevAddr: kotlin.ByteArray?, fieldMaskPaths: kotlin.collections.List<kotlin.String>?) : V3EndDevice {
        val localVarResponse = endDeviceRegistryGetWithHttpInfo(endDeviceIdsApplicationIdsApplicationId = endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId = endDeviceIdsDeviceId, endDeviceIdsDevEui = endDeviceIdsDevEui, endDeviceIdsJoinEui = endDeviceIdsJoinEui, endDeviceIdsDevAddr = endDeviceIdsDevAddr, fieldMaskPaths = fieldMaskPaths)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3EndDevice
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Get the end device with the given identifiers, selecting the fields specified in the field mask. More or less fields may be returned, depending on the rights of the caller.
    * 
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param endDeviceIdsDeviceId  
    * @param endDeviceIdsDevEui The LoRaWAN DevEUI. (optional)
    * @param endDeviceIdsJoinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). (optional)
    * @param endDeviceIdsDevAddr The LoRaWAN DevAddr. (optional)
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @return ApiInfrastructureResponse<V3EndDevice?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryGetWithHttpInfo(endDeviceIdsApplicationIdsApplicationId: kotlin.String, endDeviceIdsDeviceId: kotlin.String, endDeviceIdsDevEui: kotlin.ByteArray?, endDeviceIdsJoinEui: kotlin.ByteArray?, endDeviceIdsDevAddr: kotlin.ByteArray?, fieldMaskPaths: kotlin.collections.List<kotlin.String>?) : ApiInfrastructureResponse<V3EndDevice?> {
        val localVariableConfig = endDeviceRegistryGetRequestConfig(endDeviceIdsApplicationIdsApplicationId = endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId = endDeviceIdsDeviceId, endDeviceIdsDevEui = endDeviceIdsDevEui, endDeviceIdsJoinEui = endDeviceIdsJoinEui, endDeviceIdsDevAddr = endDeviceIdsDevAddr, fieldMaskPaths = fieldMaskPaths)

        return request<Unit, V3EndDevice>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceRegistryGet
    *
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param endDeviceIdsDeviceId  
    * @param endDeviceIdsDevEui The LoRaWAN DevEUI. (optional)
    * @param endDeviceIdsJoinEui The LoRaWAN JoinEUI (AppEUI until LoRaWAN 1.0.3 end devices). (optional)
    * @param endDeviceIdsDevAddr The LoRaWAN DevAddr. (optional)
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @return RequestConfig
    */
    fun endDeviceRegistryGetRequestConfig(endDeviceIdsApplicationIdsApplicationId: kotlin.String, endDeviceIdsDeviceId: kotlin.String, endDeviceIdsDevEui: kotlin.ByteArray?, endDeviceIdsJoinEui: kotlin.ByteArray?, endDeviceIdsDevAddr: kotlin.ByteArray?, fieldMaskPaths: kotlin.collections.List<kotlin.String>?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (endDeviceIdsDevEui != null) {
                    put("end_device_ids.dev_eui", listOf(endDeviceIdsDevEui.toString()))
                }
                if (endDeviceIdsJoinEui != null) {
                    put("end_device_ids.join_eui", listOf(endDeviceIdsJoinEui.toString()))
                }
                if (endDeviceIdsDevAddr != null) {
                    put("end_device_ids.dev_addr", listOf(endDeviceIdsDevAddr.toString()))
                }
                if (fieldMaskPaths != null) {
                    put("field_mask.paths", toMultiValue(fieldMaskPaths.toList(), "multi"))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/applications/{end_device_ids.application_ids.application_id}/devices/{end_device_ids.device_id}".replace("{"+"end_device_ids.application_ids.application_id"+"}", "$endDeviceIdsApplicationIdsApplicationId").replace("{"+"end_device_ids.device_id"+"}", "$endDeviceIdsDeviceId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * List end devices in the given application. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
    * 
    * @param applicationIdsApplicationId  
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @param order Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. (optional)
    * @param limit Limit the number of results per page. (optional)
    * @param page Page number for pagination. 0 is interpreted as 1. (optional)
    * @return V3EndDevices
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryList(applicationIdsApplicationId: kotlin.String, fieldMaskPaths: kotlin.collections.List<kotlin.String>?, order: kotlin.String?, limit: kotlin.Long?, page: kotlin.Long?) : V3EndDevices {
        val localVarResponse = endDeviceRegistryListWithHttpInfo(applicationIdsApplicationId = applicationIdsApplicationId, fieldMaskPaths = fieldMaskPaths, order = order, limit = limit, page = page)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3EndDevices
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * List end devices in the given application. Similar to Get, this selects the fields given by the field mask. More or less fields may be returned, depending on the rights of the caller.
    * 
    * @param applicationIdsApplicationId  
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @param order Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. (optional)
    * @param limit Limit the number of results per page. (optional)
    * @param page Page number for pagination. 0 is interpreted as 1. (optional)
    * @return ApiInfrastructureResponse<V3EndDevices?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryListWithHttpInfo(applicationIdsApplicationId: kotlin.String, fieldMaskPaths: kotlin.collections.List<kotlin.String>?, order: kotlin.String?, limit: kotlin.Long?, page: kotlin.Long?) : ApiInfrastructureResponse<V3EndDevices?> {
        val localVariableConfig = endDeviceRegistryListRequestConfig(applicationIdsApplicationId = applicationIdsApplicationId, fieldMaskPaths = fieldMaskPaths, order = order, limit = limit, page = page)

        return request<Unit, V3EndDevices>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceRegistryList
    *
    * @param applicationIdsApplicationId  
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @param order Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. (optional)
    * @param limit Limit the number of results per page. (optional)
    * @param page Page number for pagination. 0 is interpreted as 1. (optional)
    * @return RequestConfig
    */
    fun endDeviceRegistryListRequestConfig(applicationIdsApplicationId: kotlin.String, fieldMaskPaths: kotlin.collections.List<kotlin.String>?, order: kotlin.String?, limit: kotlin.Long?, page: kotlin.Long?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (fieldMaskPaths != null) {
                    put("field_mask.paths", toMultiValue(fieldMaskPaths.toList(), "multi"))
                }
                if (order != null) {
                    put("order", listOf(order.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/applications/{application_ids.application_id}/devices".replace("{"+"application_ids.application_id"+"}", "$applicationIdsApplicationId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Update the end device, changing the fields specified by the field mask to the provided values.
    * 
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param endDeviceIdsDeviceId  
    * @param body  
    * @return V3EndDevice
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryUpdate(endDeviceIdsApplicationIdsApplicationId: kotlin.String, endDeviceIdsDeviceId: kotlin.String, body: V3UpdateEndDeviceRequest) : V3EndDevice {
        val localVarResponse = endDeviceRegistryUpdateWithHttpInfo(endDeviceIdsApplicationIdsApplicationId = endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId = endDeviceIdsDeviceId, body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3EndDevice
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Update the end device, changing the fields specified by the field mask to the provided values.
    * 
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param endDeviceIdsDeviceId  
    * @param body  
    * @return ApiInfrastructureResponse<V3EndDevice?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceRegistryUpdateWithHttpInfo(endDeviceIdsApplicationIdsApplicationId: kotlin.String, endDeviceIdsDeviceId: kotlin.String, body: V3UpdateEndDeviceRequest) : ApiInfrastructureResponse<V3EndDevice?> {
        val localVariableConfig = endDeviceRegistryUpdateRequestConfig(endDeviceIdsApplicationIdsApplicationId = endDeviceIdsApplicationIdsApplicationId, endDeviceIdsDeviceId = endDeviceIdsDeviceId, body = body)

        return request<V3UpdateEndDeviceRequest, V3EndDevice>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceRegistryUpdate
    *
    * @param endDeviceIdsApplicationIdsApplicationId  
    * @param endDeviceIdsDeviceId  
    * @param body  
    * @return RequestConfig
    */
    fun endDeviceRegistryUpdateRequestConfig(endDeviceIdsApplicationIdsApplicationId: kotlin.String, endDeviceIdsDeviceId: kotlin.String, body: V3UpdateEndDeviceRequest) : RequestConfig<V3UpdateEndDeviceRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/applications/{end_device.ids.application_ids.application_id}/devices/{end_device.ids.device_id}".replace("{"+"end_device.ids.application_ids.application_id"+"}", "$endDeviceIdsApplicationIdsApplicationId").replace("{"+"end_device.ids.device_id"+"}", "$endDeviceIdsDeviceId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
