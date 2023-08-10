package com.marsrover.NasaMarsRover.rover.domain

import com.marsrover.NasaMarsRover.rover.domain.valueobjects.CoordinatesXY
import com.marsrover.NasaMarsRover.rover.domain.valueobjects.Direction
import com.marsrover.NasaMarsRover.rover.domain.valueobjects.RoverId

class Rover(
    val roverId: RoverId,
    private var coordinatesXY: CoordinatesXY,
    private var direction: Direction
) {
    fun getCoordinatesXY(): CoordinatesXY = coordinatesXY
    fun getDirection(): Direction = direction

    companion object {
        fun of(
            roverIdGeneratorPort: RoverIdGeneratorPort,
            coordinatesXY: CoordinatesXY,
            direction: Direction
        ) =
            Rover(roverIdGeneratorPort.generate(), coordinatesXY, direction)
    }

    enum class CommandResult {
        SUCCESS,
        FAILURE
    }

    fun noOperation(): CommandResult {
        println("Commands arent valid. Do nothing") // TODO "logger"
        return CommandResult.SUCCESS
    }

    // Moves the rover forward based on its current direction.
    fun moveForward(): CommandResult {
        // If it's safe to move forward, proceed. Otherwise, return FAILURE.
        return if (scan()) {
            TODO("Move forward")
            CommandResult.SUCCESS
        } else {
            CommandResult.FAILURE
        }
    }

    fun turnLeft(): CommandResult {
        // Implement the logic of turning left.
        try {
            TODO("Not implemented")
            return CommandResult.SUCCESS
        } catch (e: Exception) {
            // Log or handle the exception
            return CommandResult.FAILURE
        }
    }

    fun turnRight(): CommandResult {
        // Implement the logic of turning right.
        try {
            TODO("Not implemented")
            return CommandResult.SUCCESS
        } catch (e: Exception) {
            // Log or handle the exception
            return CommandResult.FAILURE
        }
    }

    // Scans the space in front of the rover to determine if it's safe to proceed.
    private fun scan(): Boolean {
        // For now, always returning true. This needs to be implemented based on rover's environment.
        return true // Return true if it is safe to move forward, false otherwise.
    }
}