package com.marsrover.nasa.rover.application.port.`in`

import com.marsrover.nasa.rover.domain.CoordinatesXY

interface CreateRoversUseCase {
    fun execute(command: CreateRoversCommand)
}

data class CreateRoversCommand(val roversCoordinatesXY: List<CoordinatesXY>) { // TODO "change off to TDO?
    init {
        if (roversCoordinatesXY.size <=0 ) error("Rover count must be positive")
    }
}