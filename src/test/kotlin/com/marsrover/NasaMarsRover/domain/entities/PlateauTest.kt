package com.marsrover.NasaMarsRover.domain.entities

import com.marsrover.NasaMarsRover.domain.value_objects.Size
import com.marsrover.NasaMarsRover.domain.value_objects.UnitLength
import com.marsrover.NasaMarsRover.domain.value_objects.UnitMeasurement
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
