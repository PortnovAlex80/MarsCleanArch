package com.marsrover.nasa.rover.domain


import arrow.core.Either
import arrow.core.left
import arrow.core.right
import kotlin.random.Random

class Rover(
    val roverId: RoverId, private var coordinatesXY: CoordinatesXY, private var direction: Direction
) {
    fun getCoordinatesXY(): CoordinatesXY = coordinatesXY
    fun getDirection(): Direction = direction

    companion object {
        fun of(
            roverIdGeneratorPort: RoverIdGeneratorPort, coordinatesXY: CoordinatesXY, direction: Direction
        ) = Rover(roverIdGeneratorPort.generate(), coordinatesXY, direction)
    }

    // Imitate random overheating, obstacles, and low power
    private fun imitateRandomEvents(): Either<RoverErrors, CommandResult> {

        return when (Random.nextInt(1, 11)) { // Generates a random number between 1 and 10
            1 -> RoverErrors.LeftDriverOverheatingError.left()  // 1 in 10 chance of overheating
            2 -> RoverErrors.RightDriverOverheatungError.left() // 1 in 10 chance of overheating
            3 -> RoverErrors.ObstacleOnRouteError.left()        // 1 in 10 chance of an obstacle
            4 -> RoverErrors.LowPowerError.left()               // 1 in 10 chance of low power
            else -> CommandResult.SUCCESS.right()
        }
    }

    fun noOperation(): CommandResult {
        println("Commands arent valid. Do nothing") // TODO "logger"
        return CommandResult.SUCCESS
    }

    // Moves the rover forward based on its current direction.
// Moves the rover forward based on its current direction.
    fun moveForward(): Either<RoverErrors, CommandResult> {

        val randomEventResult = imitateRandomEvents()
        if (randomEventResult.isLeft()) {
            return randomEventResult
        }

        // If it's safe to move forward, proceed. Otherwise, return FAILURE.
        val x = coordinatesXY.x
        val y = coordinatesXY.y
        val delta = 1000 / 111320.0 // for lat
        val deltaLng = 1000 / (111320.0 * Math.cos(Math.toRadians(y)))

        coordinatesXY = when (direction) {
            Direction.NORTH -> CoordinatesXY(x, y + delta)
            Direction.WEST -> CoordinatesXY(x - deltaLng, y)
            Direction.SOUTH -> CoordinatesXY(x, y - delta)
            Direction.EAST -> CoordinatesXY(x + deltaLng, y)
        }
        return CommandResult.SUCCESS.right()
    }

    fun turnLeft(): CommandResult { // maybe make private?
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

enum class CommandResult {
    SUCCESS, FAILURE
}

sealed class RoverErrors : BusinessError {
    object CountMustBePositiveError : RoverErrors()
    object LowPowerError : RoverErrors()
    object LeftDriverOverheatingError : RoverErrors()
    object RightDriverOverheatungError : RoverErrors()
    object ObstacleOnRouteError : RoverErrors()
}

interface BusinessError