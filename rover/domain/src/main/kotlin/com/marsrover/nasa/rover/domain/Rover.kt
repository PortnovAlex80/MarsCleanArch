package com.marsrover.nasa.rover.domain

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
        val x = coordinatesXY.x
        val y = coordinatesXY.y

        coordinatesXY = when (direction) {
            Direction.NORTH -> CoordinatesXY(x, y + 1)
            Direction.WEST -> CoordinatesXY(x - 1, y)
            Direction.SOUTH -> CoordinatesXY(x, y - 1)
            Direction.EAST -> CoordinatesXY(x + 1, y)
        }
        return CommandResult.SUCCESS
    }

    fun turnLeft(): CommandResult {
        // Implement the logic of turning left.

        direction = when (direction) {
            Direction.NORTH -> Direction.WEST
            Direction.WEST -> Direction.SOUTH
            Direction.SOUTH -> Direction.EAST
            Direction.EAST -> Direction.NORTH
        }
        return CommandResult.SUCCESS
    }

    fun turnRight(): CommandResult {
        // Implement the logic of turning right.

        direction = when (direction) {
            Direction.NORTH -> Direction.EAST
            Direction.WEST -> Direction.NORTH
            Direction.SOUTH -> Direction.WEST
            Direction.EAST -> Direction.SOUTH
        }
        return CommandResult.SUCCESS
    }

    // Scans the space in front of the rover to determine if it's safe to proceed.
    private fun scan(): Boolean {
        // For now, always returning true. This needs to be implemented based on rover's environment.
        return true // Return true if it is safe to move forward, false otherwise.
    }
}