
# V3CUPSRedirection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**targetCupsUri** | **kotlin.String** | CUPS URI for LoRa Basics Station CUPS redirection. |  [optional]
**currentGatewayKey** | **kotlin.String** | The key set in the gateway to authenticate itself. |  [optional]
**targetCupsTrust** | **kotlin.ByteArray** | Optional PEM encoded CA Root certificate. If this field is empty, DCS will attempt to dial the Target CUPS server and fetch the CA. |  [optional]
**clientTls** | [**CUPSRedirectionClientTLS**](CUPSRedirectionClientTLS.md) |  |  [optional]
**authToken** | **kotlin.String** | The Device Claiming Server will fill this field with a The Things Stack API Key. |  [optional]



