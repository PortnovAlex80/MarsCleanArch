package com.marsrover.NasaMarsRover.rover.domain

data class Position(val x: Int, val y: Int) {
    companion object {
        fun zeroPosition() = Position(0, 0)
    }
}