package com.marsrover.NasaMarsRover.rover.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DirectionValueObjectTest {

    @Test
    fun `Is defaul Direction is NORTH`() {
        assertEquals(Direction.NORTH, Direction.default())
    }
    @Test
    fun `Is possible Direction contain NORTH SOUTH EAST WEST`() {
        Assertions.assertEquals("NORTH (N), SOUTH (S), EAST (E), WEST (W)", Direction.possibleDirections())
    }

    @Test
    fun `Is NORTN or N or n is valid`() {
        assertTrue(Direction.isValidInput("NORTH"))
        assertTrue(Direction.isValidInput("north"))
        assertTrue(Direction.isValidInput("N"))
        assertTrue(Direction.isValidInput("n"))
    }

    @Test
    fun `Is SOUTH or S or s is valid`() {
        assertTrue(Direction.isValidInput("SOUTH"))
        assertTrue(Direction.isValidInput("south"))
        assertTrue(Direction.isValidInput("S"))
        assertTrue(Direction.isValidInput("s"))
    }

    @Test
    fun `Is WEST or W or w is valid`() {
        assertTrue(Direction.isValidInput("WEST"))
        assertTrue(Direction.isValidInput("west"))
        assertTrue(Direction.isValidInput("W"))
        assertTrue(Direction.isValidInput("w"))
    }

    @Test
    fun `Is EAST or E or e is valid`() {
        assertTrue(Direction.isValidInput("EAST"))
        assertTrue(Direction.isValidInput("east"))
        assertTrue(Direction.isValidInput("E"))
        assertTrue(Direction.isValidInput("e"))
    }
}