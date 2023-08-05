package com.marsrover.NasaMarsRover.domain.value_objects

data class UnitLength(val value: Int, val unit: UnitMeasurement) {
    init {
        if (value < 0) {
            error("Unit lenght cannot be negative")
        }
    }
}

// Enum UnitMeasurement
enum class UnitMeasurement {
    METERS,
    KILOMETERS,
    MILES
}

// add validation -- error policy