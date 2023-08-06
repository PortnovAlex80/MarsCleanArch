package com.marsrover.NasaMarsRover.platuae.entities

import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.CoordinatesXY
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.rover.domain.RoverId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicLong

class RoverTest {
    @Test
    fun testRoverInitialState() {
        val initialCoordinatesXY = CoordinatesXY(5, 5)
        val initialDirection = Direction.NORTH
        val counter = AtomicLong(0)
        val roverId = RoverId(counter.incrementAndGet())
        val rover = Rover(roverId, initialCoordinatesXY, initialDirection)

        assertEquals(initialCoordinatesXY, rover.coordinatesXY)
        assertEquals(initialDirection, rover.direction)
    }
}