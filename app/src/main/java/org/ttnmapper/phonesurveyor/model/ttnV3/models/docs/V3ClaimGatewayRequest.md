
# V3ClaimGatewayRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authenticatedIdentifiers** | [**V3ClaimGatewayRequestAuthenticatedIdentifiers**](V3ClaimGatewayRequestAuthenticatedIdentifiers.md) |  |  [optional]
**qrCode** | **kotlin.ByteArray** |  |  [optional]
**collaborator** | [**V3OrganizationOrUserIdentifiers**](V3OrganizationOrUserIdentifiers.md) |  |  [optional]
**targetGatewayId** | **kotlin.String** | Gateway ID for the target gateway. This must be a unique value. If this is not set, the target ID for the target gateway will be set to &#x60;&lt;gateway-eui&gt;&#x60;. |  [optional]
**targetGatewayServerAddress** | **kotlin.String** | Target Gateway Server Address for the target gateway. |  [optional]
**cupsRedirection** | [**V3CUPSRedirection**](V3CUPSRedirection.md) |  |  [optional]
**targetFrequencyPlanId** | **kotlin.String** | Frequency plan ID of the target gateway. This equals the first element of the frequency_plan_ids field. |  [optional]



