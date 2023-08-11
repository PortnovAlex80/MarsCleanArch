package com.marsrover.NasaMarsRover.rover.application.port.out

import com.marsrover.NasaMarsRover.rover.domain.Rover

interface CreateRoversPortToSaveOut {
    fun createRoversSave(rovers: List<Rover>)
}