package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.port.`in`.RoverExtractorPortIn
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

class GetRoverByIdUseCase(private val roverExtractorPortIn: RoverExtractorPortIn ): GetRoverById {
    override fun execute(id: RoverId): Rover? {
        println("GET BY ID ${roverExtractorPortIn.getRoverById(id)}")
        return roverExtractorPortIn.getRoverById(id)
    }
}