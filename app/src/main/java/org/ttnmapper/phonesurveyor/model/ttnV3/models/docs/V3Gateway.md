
# V3Gateway

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**Lorawanv3GatewayIdentifiers**](Lorawanv3GatewayIdentifiers.md) |  |  [optional]
**createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the gateway was created. This information is public and can be seen by any authenticated user in the network. |  [optional]
**updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the gateway was last updated. This information is public and can be seen by any authenticated user in the network. |  [optional]
**deletedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | When the gateway was deleted. This information is public and can be seen by any authenticated user in the network. |  [optional]
**name** | **kotlin.String** | The name of the gateway. This information is public and can be seen by any authenticated user in the network. |  [optional]
**description** | **kotlin.String** | A description for the gateway. This information is public and can be seen by any authenticated user in the network. |  [optional]
**attributes** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Key-value attributes for this gateway. Typically used for organizing gateways or for storing integration-specific data. |  [optional]
**contactInfo** | [**kotlin.collections.List&lt;V3ContactInfo&gt;**](V3ContactInfo.md) | Contact information for this gateway. Typically used to indicate who to contact with technical/security questions about the gateway. |  [optional]
**versionIds** | [**V3GatewayVersionIdentifiers**](V3GatewayVersionIdentifiers.md) |  |  [optional]
**gatewayServerAddress** | **kotlin.String** | The address of the Gateway Server to connect to. This information is public and can be seen by any authenticated user in the network if status_public is true. The typical format of the address is \&quot;scheme://host:port\&quot;. The scheme is optional. If the port is omitted, the normal port inference (with DNS lookup, otherwise defaults) is used. The connection shall be established with transport layer security (TLS). Custom certificate authorities may be configured out-of-band. |  [optional]
**autoUpdate** | **kotlin.Boolean** |  |  [optional]
**updateChannel** | **kotlin.String** |  |  [optional]
**frequencyPlanId** | **kotlin.String** | Frequency plan ID of the gateway. This information is public and can be seen by any authenticated user in the network. DEPRECATED: use frequency_plan_ids. This equals the first element of the frequency_plan_ids field. |  [optional]
**frequencyPlanIds** | **kotlin.collections.List&lt;kotlin.String&gt;** | Frequency plan IDs of the gateway. This information is public and can be seen by any authenticated user in the network. The first element equals the frequency_plan_id field. |  [optional]
**antennas** | [**kotlin.collections.List&lt;V3GatewayAntenna&gt;**](V3GatewayAntenna.md) | Antennas of the gateway. Location information of the antennas is public and can be seen by any authenticated user in the network if location_public&#x3D;true. |  [optional]
**statusPublic** | **kotlin.Boolean** | The status of this gateway may be publicly displayed. |  [optional]
**locationPublic** | **kotlin.Boolean** | The location of this gateway may be publicly displayed. |  [optional]
**scheduleDownlinkLate** | **kotlin.Boolean** | Enable server-side buffering of downlink messages. This is recommended for gateways using the Semtech UDP Packet Forwarder v2.x or older, as it does not feature a just-in-time queue. If enabled, the Gateway Server schedules the downlink message late to the gateway so that it does not overwrite previously scheduled downlink messages that have not been transmitted yet. |  [optional]
**enforceDutyCycle** | **kotlin.Boolean** | Enforcing gateway duty cycle is recommended for all gateways to respect spectrum regulations. Disable enforcing the duty cycle only in controlled research and development environments. |  [optional]
**downlinkPathConstraint** | [**V3DownlinkPathConstraint**](V3DownlinkPathConstraint.md) |  |  [optional]
**scheduleAnytimeDelay** | **kotlin.String** | Adjust the time that GS schedules class C messages in advance. This is useful for gateways that have a known high latency backhaul, like 3G and satellite. |  [optional]
**updateLocationFromStatus** | **kotlin.Boolean** | Update the location of this gateway from status messages. This only works for gateways connecting with authentication; gateways connected over UDP are not supported. |  [optional]
**lbsLnsSecret** | [**V3Secret**](V3Secret.md) |  |  [optional]
**claimAuthenticationCode** | [**V3GatewayClaimAuthenticationCode**](V3GatewayClaimAuthenticationCode.md) |  |  [optional]
**targetCupsUri** | **kotlin.String** | CUPS URI for LoRa Basics Station CUPS redirection. The CUPS Trust field will be automatically fetched from the cert chain presented by the target server. |  [optional]
**targetCupsKey** | [**V3Secret**](V3Secret.md) |  |  [optional]
**requireAuthenticatedConnection** | **kotlin.Boolean** | Require an authenticated gateway connection. This prevents the gateway from using the UDP protocol and requires authentication when using other protocols. |  [optional]
**lrfhss** | [**GatewayLRFHSS**](GatewayLRFHSS.md) |  |  [optional]
**disablePacketBrokerForwarding** | **kotlin.Boolean** |  |  [optional]



