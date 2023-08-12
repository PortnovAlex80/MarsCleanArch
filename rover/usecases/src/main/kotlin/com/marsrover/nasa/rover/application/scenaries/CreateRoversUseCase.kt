package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.nasa.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.nasa.rover.application.port.out.CreateRoversPortOut
import com.marsrover.nasa.rover.domain.CoordinatesXY
import com.marsrover.nasa.rover.domain.Direction
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverIdGeneratorPort

class CreateRoversUseCase(
    val createRoversPortOut: CreateRoversPortOut,
    val roverIdGenerator: RoverIdGeneratorPort
) :
    CreateRoversUseCase {
    override fun execute(command: CreateRoversCommand) {

        val count = command.roversCoordinatesXY.size
        if (count <= 0) error("Count must be positive")

        val rovers = mutableListOf<Rover>()
        for (i in 0 until count) {
            val rover = Rover.of(roverIdGenerator, CoordinatesXY(command.roversCoordinatesXY[i].x,
                command.roversCoordinatesXY[i].y) ,
                Direction.default()) //TODO `enter user Direction`
            rovers.add(rover)
            println("[CREATE ROVERS SERVICE] Добавлен ровер ${rover.roverId.value} Позиция: ${rover.getCoordinatesXY().x},${rover.getCoordinatesXY().y}. Направление: ${rover.getCoordinatesXY()}")
        }

        // save the created Rovers to DB
        createRoversPortOut.createRoversSave(rovers)
    }
}