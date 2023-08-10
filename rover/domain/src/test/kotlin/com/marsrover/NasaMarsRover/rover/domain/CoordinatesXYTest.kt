package com.marsrover.NasaMarsRover.rover.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CoordinatesXYTest {
    @Test
    fun `When pass negative x,y values then throw error`() {

        assertThrows<IllegalArgumentException> {
            CoordinatesXY(-1, 0)
        }
        assertThrows<IllegalArgumentException> {
            CoordinatesXY(0, -10)
        }
    }
}