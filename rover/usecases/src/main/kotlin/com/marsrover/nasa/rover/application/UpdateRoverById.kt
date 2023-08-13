package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

interface UpdateRoverById {
    fun execute(id: RoverId, rover: Rover): Boolean
}