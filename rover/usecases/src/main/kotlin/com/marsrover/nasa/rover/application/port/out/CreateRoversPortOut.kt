package com.marsrover.nasa.rover.application.port.out

import com.marsrover.nasa.rover.domain.Rover

interface CreateRoversPortOut {
    fun createRoversSave(rovers: List<Rover>)
}