package com.marsrover.NasaMarsRover.domain.entities

import com.marsrover.NasaMarsRover.rover.application.port.out.RoverIdGeneratorPort
import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.Position
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.rover.domain.RoverId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicLong

class RoverTest {
    @Test
    fun testRoverInitialState() {
        val initialPosition = Position(5, 5)
        val initialDirection = Direction.NORTH
        val counter = AtomicLong(0)
        val roverId = RoverId(counter.incrementAndGet())
        val rover = Rover(roverId, initialPosition, initialDirection)

        assertEquals(initialPosition, rover.position)
        assertEquals(initialDirection, rover.direction)
    }
}