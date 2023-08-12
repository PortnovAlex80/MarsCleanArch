package com.marsrover.nasa.rover.application.port.out

import com.marsrover.nasa.rover.domain.Rover

interface CreateRoversPortToSaveOut {
    fun createRoversSave(rovers: List<Rover>)
}