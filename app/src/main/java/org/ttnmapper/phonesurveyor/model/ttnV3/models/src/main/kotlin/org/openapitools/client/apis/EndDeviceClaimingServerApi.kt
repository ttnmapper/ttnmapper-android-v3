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
import org.openapitools.client.models.V3AuthorizeApplicationRequest
import org.openapitools.client.models.V3ClaimEndDeviceRequest
import org.openapitools.client.models.V3EndDeviceIdentifiers

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

class EndDeviceClaimingServerApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
    * Authorize the End Device Claiming Server to claim devices registered in the given application. The application identifiers are the source application, where the devices are registered before they are claimed. The API key is used to access the application, find the device, verify the claim request and delete the end device from the source application.
    * 
    * @param applicationIdsApplicationId  
    * @param body  
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceClaimingServerAuthorizeApplication(applicationIdsApplicationId: kotlin.String, body: V3AuthorizeApplicationRequest) : kotlin.Any {
        val localVarResponse = endDeviceClaimingServerAuthorizeApplicationWithHttpInfo(applicationIdsApplicationId = applicationIdsApplicationId, body = body)

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
    * Authorize the End Device Claiming Server to claim devices registered in the given application. The application identifiers are the source application, where the devices are registered before they are claimed. The API key is used to access the application, find the device, verify the claim request and delete the end device from the source application.
    * 
    * @param applicationIdsApplicationId  
    * @param body  
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceClaimingServerAuthorizeApplicationWithHttpInfo(applicationIdsApplicationId: kotlin.String, body: V3AuthorizeApplicationRequest) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = endDeviceClaimingServerAuthorizeApplicationRequestConfig(applicationIdsApplicationId = applicationIdsApplicationId, body = body)

        return request<V3AuthorizeApplicationRequest, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceClaimingServerAuthorizeApplication
    *
    * @param applicationIdsApplicationId  
    * @param body  
    * @return RequestConfig
    */
    fun endDeviceClaimingServerAuthorizeApplicationRequestConfig(applicationIdsApplicationId: kotlin.String, body: V3AuthorizeApplicationRequest) : RequestConfig<V3AuthorizeApplicationRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/edcs/applications/{application_ids.application_id}/authorize".replace("{"+"application_ids.application_id"+"}", "$applicationIdsApplicationId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Claims the end device by claim authentication code or QR code and transfers the device to the target application.
    * 
    * @param body  
    * @return V3EndDeviceIdentifiers
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceClaimingServerClaim(body: V3ClaimEndDeviceRequest) : V3EndDeviceIdentifiers {
        val localVarResponse = endDeviceClaimingServerClaimWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3EndDeviceIdentifiers
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
    * Claims the end device by claim authentication code or QR code and transfers the device to the target application.
    * 
    * @param body  
    * @return ApiInfrastructureResponse<V3EndDeviceIdentifiers?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceClaimingServerClaimWithHttpInfo(body: V3ClaimEndDeviceRequest) : ApiInfrastructureResponse<V3EndDeviceIdentifiers?> {
        val localVariableConfig = endDeviceClaimingServerClaimRequestConfig(body = body)

        return request<V3ClaimEndDeviceRequest, V3EndDeviceIdentifiers>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceClaimingServerClaim
    *
    * @param body  
    * @return RequestConfig
    */
    fun endDeviceClaimingServerClaimRequestConfig(body: V3ClaimEndDeviceRequest) : RequestConfig<V3ClaimEndDeviceRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/edcs/claim",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Unauthorize the End Device Claiming Server to claim devices in the given application. This reverts the authorization given with rpc AuthorizeApplication.
    * 
    * @param applicationId  
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceClaimingServerUnauthorizeApplication(applicationId: kotlin.String) : kotlin.Any {
        val localVarResponse = endDeviceClaimingServerUnauthorizeApplicationWithHttpInfo(applicationId = applicationId)

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
    * Unauthorize the End Device Claiming Server to claim devices in the given application. This reverts the authorization given with rpc AuthorizeApplication.
    * 
    * @param applicationId  
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun endDeviceClaimingServerUnauthorizeApplicationWithHttpInfo(applicationId: kotlin.String) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = endDeviceClaimingServerUnauthorizeApplicationRequestConfig(applicationId = applicationId)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation endDeviceClaimingServerUnauthorizeApplication
    *
    * @param applicationId  
    * @return RequestConfig
    */
    fun endDeviceClaimingServerUnauthorizeApplicationRequestConfig(applicationId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/edcs/applications/{application_id}/authorize".replace("{"+"application_id"+"}", "$applicationId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
