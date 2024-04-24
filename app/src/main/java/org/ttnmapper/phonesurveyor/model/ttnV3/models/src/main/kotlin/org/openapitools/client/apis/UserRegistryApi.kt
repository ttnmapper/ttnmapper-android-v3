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
import org.openapitools.client.models.V3CreateUserRequest
import org.openapitools.client.models.V3UpdateUserPasswordRequest
import org.openapitools.client.models.V3UpdateUserRequest
import org.openapitools.client.models.V3User
import org.openapitools.client.models.V3Users

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

class UserRegistryApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
    * Register a new user. This method may be restricted by network settings.
    * 
    * @param body  
    * @return V3User
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryCreate(body: V3CreateUserRequest) : V3User {
        val localVarResponse = userRegistryCreateWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3User
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
    * Register a new user. This method may be restricted by network settings.
    * 
    * @param body  
    * @return ApiInfrastructureResponse<V3User?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryCreateWithHttpInfo(body: V3CreateUserRequest) : ApiInfrastructureResponse<V3User?> {
        val localVariableConfig = userRegistryCreateRequestConfig(body = body)

        return request<V3CreateUserRequest, V3User>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryCreate
    *
    * @param body  
    * @return RequestConfig
    */
    fun userRegistryCreateRequestConfig(body: V3CreateUserRequest) : RequestConfig<V3CreateUserRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/users",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Create a temporary password that can be used for updating a forgotten password. The generated password is sent to the user&#39;s email address.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryCreateTemporaryPassword(userIdsUserId: kotlin.String) : kotlin.Any {
        val localVarResponse = userRegistryCreateTemporaryPasswordWithHttpInfo(userIdsUserId = userIdsUserId)

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
    * Create a temporary password that can be used for updating a forgotten password. The generated password is sent to the user&#39;s email address.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryCreateTemporaryPasswordWithHttpInfo(userIdsUserId: kotlin.String) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = userRegistryCreateTemporaryPasswordRequestConfig(userIdsUserId = userIdsUserId)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryCreateTemporaryPassword
    *
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @return RequestConfig
    */
    fun userRegistryCreateTemporaryPasswordRequestConfig(userIdsUserId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/users/{user_ids.user_id}/temporary_password".replace("{"+"user_ids.user_id"+"}", "$userIdsUserId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Delete the user. This may not release the user ID for reuse.
    * 
    * @param userId This ID shares namespace with organization IDs. 
    * @param email Secondary identifier, which can only be used in specific requests. (optional)
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryDelete(userId: kotlin.String, email: kotlin.String?) : kotlin.Any {
        val localVarResponse = userRegistryDeleteWithHttpInfo(userId = userId, email = email)

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
    * Delete the user. This may not release the user ID for reuse.
    * 
    * @param userId This ID shares namespace with organization IDs. 
    * @param email Secondary identifier, which can only be used in specific requests. (optional)
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryDeleteWithHttpInfo(userId: kotlin.String, email: kotlin.String?) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = userRegistryDeleteRequestConfig(userId = userId, email = email)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryDelete
    *
    * @param userId This ID shares namespace with organization IDs. 
    * @param email Secondary identifier, which can only be used in specific requests. (optional)
    * @return RequestConfig
    */
    fun userRegistryDeleteRequestConfig(userId: kotlin.String, email: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (email != null) {
                    put("email", listOf(email.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/users/{user_id}".replace("{"+"user_id"+"}", "$userId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Get the user with the given identifiers, selecting the fields given by the field mask. The method may return more or less fields, depending on the rights of the caller.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param userIdsEmail Secondary identifier, which can only be used in specific requests. (optional)
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @return V3User
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryGet(userIdsUserId: kotlin.String, userIdsEmail: kotlin.String?, fieldMaskPaths: kotlin.collections.List<kotlin.String>?) : V3User {
        val localVarResponse = userRegistryGetWithHttpInfo(userIdsUserId = userIdsUserId, userIdsEmail = userIdsEmail, fieldMaskPaths = fieldMaskPaths)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3User
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
    * Get the user with the given identifiers, selecting the fields given by the field mask. The method may return more or less fields, depending on the rights of the caller.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param userIdsEmail Secondary identifier, which can only be used in specific requests. (optional)
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @return ApiInfrastructureResponse<V3User?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryGetWithHttpInfo(userIdsUserId: kotlin.String, userIdsEmail: kotlin.String?, fieldMaskPaths: kotlin.collections.List<kotlin.String>?) : ApiInfrastructureResponse<V3User?> {
        val localVariableConfig = userRegistryGetRequestConfig(userIdsUserId = userIdsUserId, userIdsEmail = userIdsEmail, fieldMaskPaths = fieldMaskPaths)

        return request<Unit, V3User>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryGet
    *
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param userIdsEmail Secondary identifier, which can only be used in specific requests. (optional)
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @return RequestConfig
    */
    fun userRegistryGetRequestConfig(userIdsUserId: kotlin.String, userIdsEmail: kotlin.String?, fieldMaskPaths: kotlin.collections.List<kotlin.String>?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (userIdsEmail != null) {
                    put("user_ids.email", listOf(userIdsEmail.toString()))
                }
                if (fieldMaskPaths != null) {
                    put("field_mask.paths", toMultiValue(fieldMaskPaths.toList(), "multi"))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/users/{user_ids.user_id}".replace("{"+"user_ids.user_id"+"}", "$userIdsUserId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * List users of the network. This method is typically restricted to admins only.
    * 
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @param order Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. (optional)
    * @param limit Limit the number of results per page. (optional)
    * @param page Page number for pagination. 0 is interpreted as 1. (optional)
    * @param deleted Only return recently deleted users. (optional)
    * @return V3Users
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryList(fieldMaskPaths: kotlin.collections.List<kotlin.String>?, order: kotlin.String?, limit: kotlin.Long?, page: kotlin.Long?, deleted: kotlin.Boolean?) : V3Users {
        val localVarResponse = userRegistryListWithHttpInfo(fieldMaskPaths = fieldMaskPaths, order = order, limit = limit, page = page, deleted = deleted)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3Users
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
    * List users of the network. This method is typically restricted to admins only.
    * 
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @param order Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. (optional)
    * @param limit Limit the number of results per page. (optional)
    * @param page Page number for pagination. 0 is interpreted as 1. (optional)
    * @param deleted Only return recently deleted users. (optional)
    * @return ApiInfrastructureResponse<V3Users?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryListWithHttpInfo(fieldMaskPaths: kotlin.collections.List<kotlin.String>?, order: kotlin.String?, limit: kotlin.Long?, page: kotlin.Long?, deleted: kotlin.Boolean?) : ApiInfrastructureResponse<V3Users?> {
        val localVariableConfig = userRegistryListRequestConfig(fieldMaskPaths = fieldMaskPaths, order = order, limit = limit, page = page, deleted = deleted)

        return request<Unit, V3Users>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryList
    *
    * @param fieldMaskPaths The set of field mask paths. (optional)
    * @param order Order the results by this field path (must be present in the field mask). Default ordering is by ID. Prepend with a minus (-) to reverse the order. (optional)
    * @param limit Limit the number of results per page. (optional)
    * @param page Page number for pagination. 0 is interpreted as 1. (optional)
    * @param deleted Only return recently deleted users. (optional)
    * @return RequestConfig
    */
    fun userRegistryListRequestConfig(fieldMaskPaths: kotlin.collections.List<kotlin.String>?, order: kotlin.String?, limit: kotlin.Long?, page: kotlin.Long?, deleted: kotlin.Boolean?) : RequestConfig<Unit> {
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
                if (deleted != null) {
                    put("deleted", listOf(deleted.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/users",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Purge the user. This will release the user ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.
    * 
    * @param userId This ID shares namespace with organization IDs. 
    * @param email Secondary identifier, which can only be used in specific requests. (optional)
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryPurge(userId: kotlin.String, email: kotlin.String?) : kotlin.Any {
        val localVarResponse = userRegistryPurgeWithHttpInfo(userId = userId, email = email)

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
    * Purge the user. This will release the user ID for reuse. The user is responsible for clearing data from any (external) integrations that may store and expose data by user or organization ID.
    * 
    * @param userId This ID shares namespace with organization IDs. 
    * @param email Secondary identifier, which can only be used in specific requests. (optional)
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryPurgeWithHttpInfo(userId: kotlin.String, email: kotlin.String?) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = userRegistryPurgeRequestConfig(userId = userId, email = email)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryPurge
    *
    * @param userId This ID shares namespace with organization IDs. 
    * @param email Secondary identifier, which can only be used in specific requests. (optional)
    * @return RequestConfig
    */
    fun userRegistryPurgeRequestConfig(userId: kotlin.String, email: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (email != null) {
                    put("email", listOf(email.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/users/{user_id}/purge".replace("{"+"user_id"+"}", "$userId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Restore a recently deleted user.
    * Deployment configuration may specify if, and for how long after deletion, entities can be restored.
    * @param userId This ID shares namespace with organization IDs. 
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryRestore(userId: kotlin.String) : kotlin.Any {
        val localVarResponse = userRegistryRestoreWithHttpInfo(userId = userId)

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
    * Restore a recently deleted user.
    * Deployment configuration may specify if, and for how long after deletion, entities can be restored.
    * @param userId This ID shares namespace with organization IDs. 
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryRestoreWithHttpInfo(userId: kotlin.String) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = userRegistryRestoreRequestConfig(userId = userId)

        return request<Unit, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryRestore
    *
    * @param userId This ID shares namespace with organization IDs. 
    * @return RequestConfig
    */
    fun userRegistryRestoreRequestConfig(userId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/users/{user_id}/restore".replace("{"+"user_id"+"}", "$userId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Update the user, changing the fields specified by the field mask to the provided values. This method can not be used to change the password, see the UpdatePassword method for that.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param body  
    * @return V3User
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryUpdate(userIdsUserId: kotlin.String, body: V3UpdateUserRequest) : V3User {
        val localVarResponse = userRegistryUpdateWithHttpInfo(userIdsUserId = userIdsUserId, body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as V3User
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
    * Update the user, changing the fields specified by the field mask to the provided values. This method can not be used to change the password, see the UpdatePassword method for that.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param body  
    * @return ApiInfrastructureResponse<V3User?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryUpdateWithHttpInfo(userIdsUserId: kotlin.String, body: V3UpdateUserRequest) : ApiInfrastructureResponse<V3User?> {
        val localVariableConfig = userRegistryUpdateRequestConfig(userIdsUserId = userIdsUserId, body = body)

        return request<V3UpdateUserRequest, V3User>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryUpdate
    *
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param body  
    * @return RequestConfig
    */
    fun userRegistryUpdateRequestConfig(userIdsUserId: kotlin.String, body: V3UpdateUserRequest) : RequestConfig<V3UpdateUserRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/users/{user.ids.user_id}".replace("{"+"user.ids.user_id"+"}", "$userIdsUserId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Update the password of the user.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param body  
    * @return kotlin.Any
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryUpdatePassword(userIdsUserId: kotlin.String, body: V3UpdateUserPasswordRequest) : kotlin.Any {
        val localVarResponse = userRegistryUpdatePasswordWithHttpInfo(userIdsUserId = userIdsUserId, body = body)

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
    * Update the password of the user.
    * 
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param body  
    * @return ApiInfrastructureResponse<kotlin.Any?>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun userRegistryUpdatePasswordWithHttpInfo(userIdsUserId: kotlin.String, body: V3UpdateUserPasswordRequest) : ApiInfrastructureResponse<kotlin.Any?> {
        val localVariableConfig = userRegistryUpdatePasswordRequestConfig(userIdsUserId = userIdsUserId, body = body)

        return request<V3UpdateUserPasswordRequest, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
    * To obtain the request config of the operation userRegistryUpdatePassword
    *
    * @param userIdsUserId This ID shares namespace with organization IDs. 
    * @param body  
    * @return RequestConfig
    */
    fun userRegistryUpdatePasswordRequestConfig(userIdsUserId: kotlin.String, body: V3UpdateUserPasswordRequest) : RequestConfig<V3UpdateUserPasswordRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/users/{user_ids.user_id}/password".replace("{"+"user_ids.user_id"+"}", "$userIdsUserId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}