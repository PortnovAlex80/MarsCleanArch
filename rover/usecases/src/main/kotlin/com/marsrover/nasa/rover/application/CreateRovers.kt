package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.CoordinatesXY

interface CreateRovers {
    fun execute(command: CreateRoversCommand)
}

data class CreateRoversCommand(val roversCoordinatesXY: List<CoordinatesXY>) { // TODO "change off to TDO?
    init {
        if (roversCoordinatesXY.size <=0 ) error("Rover count must be positive")
    }
}