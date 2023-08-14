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

        fun isValidInput(input: String): Boolean {
            return values().any { it.name == input.uppercase() || it.name.first() == input.uppercase().first() }
        }

        fun default() = Direction.NORTH
    }
}