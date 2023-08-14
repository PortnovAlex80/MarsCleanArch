package com.marsrover.NasaMarsRover.rover.application.port.out

import com.marsrover.NasaMarsRover.rover.domain.Rover

interface CreateRoversPort {
    fun createRovers(rovers: List<Rover>)
}