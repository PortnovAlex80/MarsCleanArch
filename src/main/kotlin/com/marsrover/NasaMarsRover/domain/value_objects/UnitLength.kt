package com.marsrover.NasaMarsRover.domain.value_objects

data class UnitLength(val value: Int, val unit: UnitMeasurement)

// Enum UnitMeasurement
enum class UnitMeasurement {
    METERS,
    KILOMETERS,
    MILES
}