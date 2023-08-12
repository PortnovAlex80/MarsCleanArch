package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

interface GetRoverById {
    fun execute(id: RoverId): Rover?
}