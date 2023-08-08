package com.marsrover.NasaMarsRover.rover.domain

import com.marsrover.NasaMarsRover.rover.domain.RoverId

interface RoverIdGeneratorPort {
    fun generate(): RoverId
}