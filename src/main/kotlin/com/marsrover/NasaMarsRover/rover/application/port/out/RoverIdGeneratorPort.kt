package com.marsrover.NasaMarsRover.rover.application.port.out

import com.marsrover.NasaMarsRover.rover.domain.RoverId

interface RoverIdGeneratorPort {
    fun generate(): RoverId
}