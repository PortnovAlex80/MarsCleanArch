package com.marsrover.NasaMarsRover.rover.application

import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.NasaMarsRover.rover.application.port.out.CreateRoversPort
import com.marsrover.NasaMarsRover.rover.domain.CoordinatesXY
import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.rover.domain.RoverIdGeneratorPort

class CreateRoversService(val createRoversPort: CreateRoversPort, val roverIdGenerator: RoverIdGeneratorPort) :
    CreateRoversUseCase {
    override fun execute(command: CreateRoversCommand) {

        if (command.count <= 0) error("Count must be positive")

        val rovers = mutableListOf<Rover>()
        for (i in 1..command.count) {
            val rover = Rover.of(roverIdGenerator, CoordinatesXY.zeroPosition(), Direction.default())
            rovers.add(rover)
            println("Добавлен ровер ${rover.roverId.value} Позиция: ${rover.getCoordinatesXY().x},${rover.getCoordinatesXY().y}. Направление: ${rover.getCoordinatesXY()}")
        }

        // save the created Rovers to DB
        createRoversPort.createRovers(rovers)
    }
}