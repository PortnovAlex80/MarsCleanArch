package com.marsrover.NasaMarsRover.rover.domain

import com.sun.source.tree.AssertTree
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import kotlin.reflect.jvm.internal.impl.incremental.components.Position

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


    class RoverIdFakeGenerator() : RoverIdGeneratorPort {
        override fun generate(): RoverId {
            return RoverId(1L)
        }

    }
}

