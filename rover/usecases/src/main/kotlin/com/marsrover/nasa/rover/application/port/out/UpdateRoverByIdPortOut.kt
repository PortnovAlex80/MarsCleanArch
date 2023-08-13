package com.marsrover.nasa.rover.application.port.out

import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

interface UpdateRoverByIdPortOut {
    fun update(id: RoverId, rover: Rover): Boolean
}