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
import org.openapitools.client.models.V3MQTTConnectionInfo

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

class GtwGsApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
    * Get connection information to connect an MQTT gateway.
    * 
    * @param gatewayId  
    * @param eui Secondary identifier, which can only be used in specific requests. (optional)
    * @return V3MQTTConnectionInfo
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun gtwGsGetMQTTConnectionInfo(gatewayId: kotlin.String, eui: kotlin.ByteArray?) : V3MQTTConnectionInfo {
        val localVarResponse = gtwGsGetMQTTConnectionInfoWithHttpInfo(gatewayId = gatewayId, eui = eui)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3MQTTConnectionInfo
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
    * Get connection information to connect an MQTT gateway.
    * 
    * @param gatewayId  
    * @param eui Secondary identifier, which can only be used in specific requests. (optional)
    * @return ApiInfrastructureResponse<V3MQTTConnectionInfo?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun gtwGsGetMQTTConnectionInfoWithHttpInfo(gatewayId: kotlin.String, eui: kotlin.ByteArray?) : ApiInfrastructureResponse<V3MQTTConnectionInfo?> {
        val localVariableConfig = gtwGsGetMQTTConnectionInfoRequestConfig(gatewayId = gatewayId, eui = eui)

        return request<Unit, V3MQTTConnectionInfo>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation gtwGsGetMQTTConnectionInfo
    *
    * @param gatewayId  
    * @param eui Secondary identifier, which can only be used in specific requests. (optional)
    * @return RequestConfig
    */
    fun gtwGsGetMQTTConnectionInfoRequestConfig(gatewayId: kotlin.String, eui: kotlin.ByteArray?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (eui != null) {
                    put("eui", listOf(eui.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/gs/gateways/{gateway_id}/mqtt-connection-info".replace("{"+"gateway_id"+"}", "$gatewayId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get legacy connection information to connect a The Things Network Stack V2 MQTT gateway.
    * 
    * @param gatewayId  
    * @param eui Secondary identifier, which can only be used in specific requests. (optional)
    * @return V3MQTTConnectionInfo
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun gtwGsGetMQTTV2ConnectionInfo(gatewayId: kotlin.String, eui: kotlin.ByteArray?) : V3MQTTConnectionInfo {
        val localVarResponse = gtwGsGetMQTTV2ConnectionInfoWithHttpInfo(gatewayId = gatewayId, eui = eui)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3MQTTConnectionInfo
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
    * Get legacy connection information to connect a The Things Network Stack V2 MQTT gateway.
    * 
    * @param gatewayId  
    * @param eui Secondary identifier, which can only be used in specific requests. (optional)
    * @return ApiInfrastructureResponse<V3MQTTConnectionInfo?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun gtwGsGetMQTTV2ConnectionInfoWithHttpInfo(gatewayId: kotlin.String, eui: kotlin.ByteArray?) : ApiInfrastructureResponse<V3MQTTConnectionInfo?> {
        val localVariableConfig = gtwGsGetMQTTV2ConnectionInfoRequestConfig(gatewayId = gatewayId, eui = eui)

        return request<Unit, V3MQTTConnectionInfo>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation gtwGsGetMQTTV2ConnectionInfo
    *
    * @param gatewayId  
    * @param eui Secondary identifier, which can only be used in specific requests. (optional)
    * @return RequestConfig
    */
    fun gtwGsGetMQTTV2ConnectionInfoRequestConfig(gatewayId: kotlin.String, eui: kotlin.ByteArray?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (eui != null) {
                    put("eui", listOf(eui.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/gs/gateways/{gateway_id}/mqttv2-connection-info".replace("{"+"gateway_id"+"}", "$gatewayId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
