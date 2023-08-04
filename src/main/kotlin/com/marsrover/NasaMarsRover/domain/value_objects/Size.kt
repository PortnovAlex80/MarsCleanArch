package com.marsrover.NasaMarsRover.domain.value_objects

data class Size(val width: UnitLength, val height: UnitLength) {
    init {
        require(width.unit == height.unit) {
            "Units of measurement must be the same for width and height"
        }
    }
}