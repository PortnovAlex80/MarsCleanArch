package com.marsrover.nasa.rover.domain

data class CoordinatesXY(val x: Double, val y: Double) {
    init {
   //     require(isPositionValid(x, y)) { "Invalid position: must be non-negative" }
    }

    companion object {
        fun zeroPosition() = CoordinatesXY(0.0, 0.0)

    }
}
