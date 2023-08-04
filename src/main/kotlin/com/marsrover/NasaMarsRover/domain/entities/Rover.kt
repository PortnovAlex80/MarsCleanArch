package com.marsrover.NasaMarsRover.domain.entities

import com.marsrover.NasaMarsRover.domain.interfaces.IRoverInterface

data class Position(val x: Int, val y: Int)

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

class Rover(override var position: Position, override var direction: Direction) : IRoverInterface {

    override fun moveForward(): Int {
        // Implement the logic of moving forward based on the current direction.
        return if (scan()) {
            // Implement the logic of moving forward based on the current direction.
            TODO("Move forward")
            0 // success
        } else {
            -1 // error
        }
    }

    override fun turnLeft() {
        // Implement the logic of turning left.
        TODO("Not implemented")
    }

    override fun turnRight() {
        // Implement the logic of turning right.
        TODO("Not implemented")
    }

    override fun scan(): Boolean {
        // Implement the logic of scanning the space in front of the Rover.
        // Return true if it is safe to move forward, false otherwise.
        TODO("Not implemented")
    }
}
