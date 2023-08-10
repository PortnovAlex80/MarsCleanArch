package com.marsrover.NasaMarsRover.rover.domain

import com.marsrover.NasaMarsRover.rover.domain.valueobjects.RoverId

interface RoverIdGeneratorPort {
    fun generate(): RoverId
}