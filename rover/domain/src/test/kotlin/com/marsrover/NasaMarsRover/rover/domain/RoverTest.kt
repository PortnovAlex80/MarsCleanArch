package com.marsrover.NasaMarsRover.rover.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoverTest {

    @Test
    fun `Rover turn Left from NORTH to WEST`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.NORTH)
        // When
        rover.turnLeft()
        // Then
        assertEquals(Direction.WEST, rover.getDirection())
    }

    @Test
    fun `Rover turn Left from WEST to SOUTH`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.WEST)
        // When
        rover.turnLeft()
        // Then
        assertEquals(Direction.SOUTH, rover.getDirection())
    }

    @Test
    fun `Rover turn Left from SOUTH to EAST`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.SOUTH)
        // When
        rover.turnLeft()
        // Then
        assertEquals(Direction.EAST, rover.getDirection())
    }

    @Test
    fun `Rover turn Left from EAST to NORTH`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.EAST)
        // When
        rover.turnLeft()
        // Then
        assertEquals(Direction.NORTH, rover.getDirection())
    }

    @Test
    fun `Rover turn Right from WEST to NORTH`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.WEST)
        // When
        rover.turnRight()
        // Then
        assertEquals(Direction.NORTH, rover.getDirection())
    }

    @Test
    fun `Rover turn Right from NORTH to EAST`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.NORTH)
        // When
        rover.turnRight()
        // Then
        assertEquals(Direction.EAST, rover.getDirection())
    }

    @Test
    fun `Rover turn Right from EAST to SOUTH`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.EAST)
        // When
        rover.turnRight()
        // Then
        assertEquals(Direction.SOUTH, rover.getDirection())
    }

    @Test
    fun `Rover turn Right from SOUTH to WEST`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.SOUTH)
        // When
        rover.turnRight()
        // Then
        assertEquals(Direction.WEST, rover.getDirection())
    }

    @Test
    fun `Rover move forward from 0,0 to 0,1 Direction is NORTH`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.NORTH)
        // When
        rover.moveForward()
        // Then
        assertEquals(CoordinatesXY(0,1), rover.getCoordinatesXY())
    }

    @Test
    fun `Rover move forward from 0,0 to 1,0 Direction is EAST`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY.zeroPosition(), Direction.EAST)
        // When
        rover.moveForward()
        // Then
        assertEquals(CoordinatesXY(1,0), rover.getCoordinatesXY())
    }

    @Test
    fun `Rover move forward from 1,1 to 1,0 Direction is SOUTH`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY(1,1), Direction.SOUTH)
        // When
        rover.moveForward()
        // Then
        assertEquals(CoordinatesXY(1,0), rover.getCoordinatesXY())
    }

    @Test
    fun `Rover move forward from 1,1 to 0,1 Direction is WEST`() {
        // Given
        val rover = Rover.of(RoverIdFakeGenerator(), CoordinatesXY(1,1), Direction.WEST)
        // When
        rover.moveForward()
        // Then
        assertEquals(CoordinatesXY(0,1), rover.getCoordinatesXY())
    }

    class RoverIdFakeGenerator() : RoverIdGeneratorPort {
        override fun generate(): RoverId {
            return RoverId(1L)
        }
    }
}

