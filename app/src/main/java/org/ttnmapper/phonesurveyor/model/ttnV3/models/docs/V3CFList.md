
# V3CFList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**V3CFListType**](V3CFListType.md) |  |  [optional]
**freq** | **kotlin.collections.List&lt;kotlin.Long&gt;** | Frequencies to be broadcasted, in hecto-Hz. These values are broadcasted as 24 bits unsigned integers. This field should not contain default values. |  [optional]
**chMasks** | **kotlin.collections.List&lt;kotlin.Boolean&gt;** | ChMasks controlling the channels to be used. Length of this field must be equal to the amount of uplink channels defined by the selected frequency plan. |  [optional]



