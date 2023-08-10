package com.marsrover.NasaMarsRover.rover.domain.valueobjects

data class CoordinatesXY(val x: Int, val y: Int) {
    init {
        require(isPositionValid(x, y)) { "Invalid position: must be non-negative" }
    }

    companion object {
        fun zeroPosition() = CoordinatesXY(0, 0)

        fun isPositionValid(x: Int, y: Int): Boolean {
            return x >= 0 && y >= 0
        }
    }
}
