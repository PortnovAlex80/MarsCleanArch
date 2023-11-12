package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.Rover

interface GetAllRovers {
    fun execute(): List<Rover>?
}

