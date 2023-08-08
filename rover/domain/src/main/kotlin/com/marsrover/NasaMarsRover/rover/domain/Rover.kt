package com.marsrover.NasaMarsRover.rover.domain

class Rover(
    val roverId: RoverId,
    var coordinatesXY: CoordinatesXY,
    var direction: Direction
) {

    companion object {
        fun of(
            roverIdGeneratorPort: RoverIdGeneratorPort,
            coordinatesXY: CoordinatesXY,
            direction: Direction
        ) =
            Rover(roverIdGeneratorPort.generate(), coordinatesXY, direction)
    }

    fun moveForward(): Int {
        // Implement the logic of moving forward based on the current direction.
        return if (scan()) {
            // Implement the logic of moving forward based on the current direction.
            TODO("Move forward")
            0 // success
        } else {
            -1 // error
        }
    }

    fun turnLeft() {
        // Implement the logic of turning left.
        TODO("Not implemented")
    }

    fun turnRight() {
        // Implement the logic of turning right.
        TODO("Not implemented")
    }

    fun scan(): Boolean {
        // Implement the logic of scanning the space in front of the Rover.
        // Return true if it is safe to move forward, false otherwise.
        TODO("Not implemented")
    }
}
