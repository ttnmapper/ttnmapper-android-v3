package org.ttnmapper.phonesurveyor.model

data class MapLine(
        var startLatitude: Double,
        var startLongitude: Double,
        var endLatitude: Double,
        var endLongitude: Double,
        var colour: Long
)