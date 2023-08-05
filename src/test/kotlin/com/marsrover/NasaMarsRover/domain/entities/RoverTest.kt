package com.marsrover.NasaMarsRover.domain.entities

import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.Position
import com.marsrover.NasaMarsRover.rover.domain.Rover
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RoverTest {
    @Test
    fun testRoverInitialState() {
        val initialPosition = Position(5, 5)
        val initialDirection = Direction.NORTH
        val rover = Rover(initialPosition, initialDirection)

        assertEquals(initialPosition, rover.position)
        assertEquals(initialDirection, rover.direction)
    }
}