package com.marsrover.NasaMarsRover.rover.domain

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;
    companion object {
        fun possibleDirections(): String {
            return values().joinToString(", ") { "${it.name} (${it.name.first()})" }
        }

        fun default() = Direction.NORTH
    }
}