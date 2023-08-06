package com.marsrover.NasaMarsRover.platuae.entities

import com.marsrover.NasaMarsRover.platuae.value_objects.Size
import com.marsrover.NasaMarsRover.platuae.value_objects.UnitLength
import com.marsrover.NasaMarsRover.platuae.value_objects.UnitMeasurement
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlateauTest {
    @Test
    fun testPlateauSize() {
        val size = Size(UnitLength(10, UnitMeasurement.METERS), UnitLength(20, UnitMeasurement.METERS))
        val Plateau = Plateau(size)
        assertEquals(size, Plateau.size)
    }
}
