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

import org.openapitools.client.models.Lorawanv3ContactInfoValidation
import org.openapitools.client.models.RuntimeError
import org.openapitools.client.models.V3EntityIdentifiers

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

class ContactInfoRegistryApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
    * Request validation for the non-validated contact info for the given entity.
    * 
    * @param body  
    * @return Lorawanv3ContactInfoValidation
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun contactInfoRegistryRequestValidation(body: V3EntityIdentifiers) : Lorawanv3ContactInfoValidation {
        val localVarResponse = contactInfoRegistryRequestValidationWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Lorawanv3ContactInfoValidation
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
    * Request validation for the non-validated contact info for the given entity.
    * 
    * @param body  
    * @return ApiInfrastructureResponse<Lorawanv3ContactInfoValidation?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun contactInfoRegistryRequestValidationWithHttpInfo(body: V3EntityIdentifiers) : ApiInfrastructureResponse<Lorawanv3ContactInfoValidation?> {
        val localVariableConfig = contactInfoRegistryRequestValidationRequestConfig(body = body)

        return request<V3EntityIdentifiers, Lorawanv3ContactInfoValidation>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation contactInfoRegistryRequestValidation
    *
    * @param body  
    * @return RequestConfig
    */
    fun contactInfoRegistryRequestValidationRequestConfig(body: V3EntityIdentifiers) : RequestConfig<V3EntityIdentifiers> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/contact_info/validation",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Validate confirms a contact info validation.
    * 
    * @param body  
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun contactInfoRegistryValidate(body: Lorawanv3ContactInfoValidation) : kotlin.Any {
        val localVarResponse = contactInfoRegistryValidateWithHttpInfo(body = body)

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
    * Validate confirms a contact info validation.
    * 
    * @param body  
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun contactInfoRegistryValidateWithHttpInfo(body: Lorawanv3ContactInfoValidation) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = contactInfoRegistryValidateRequestConfig(body = body)

        return request<Lorawanv3ContactInfoValidation, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation contactInfoRegistryValidate
    *
    * @param body  
    * @return RequestConfig
    */
    fun contactInfoRegistryValidateRequestConfig(body: Lorawanv3ContactInfoValidation) : RequestConfig<Lorawanv3ContactInfoValidation> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PATCH,
            path = "/contact_info/validation",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
