package com.marsrover.nasa.rover.application.port.`in`

import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

interface RoverExtractorPortIn {
    fun getAllRovers(): List<Rover>?
    fun getRoverById(id: RoverId): Rover?
}