package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.port.`in`.RoverExtractorPortIn
import com.marsrover.nasa.rover.application.GetAllRovers
import com.marsrover.nasa.rover.domain.Rover

class GetAllRoversUseCase(private val roverExtractorPortIn: RoverExtractorPortIn): GetAllRovers {
    override fun execute(): List<Rover>? {
        return roverExtractorPortIn.getAllRovers()
    }

}