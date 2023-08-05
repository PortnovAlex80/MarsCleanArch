package com.marsrover.NasaMarsRover.rover.application

import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.NasaMarsRover.rover.application.port.out.CreateRoversPort
import com.marsrover.NasaMarsRover.rover.application.port.out.RoverIdGeneratorPort
import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.Position
import com.marsrover.NasaMarsRover.rover.domain.Rover

class CreateRoversService(val createRoversPort: CreateRoversPort, val roverIdGenerator: RoverIdGeneratorPort) :
    CreateRoversUseCase {
    override fun execute(command: CreateRoversCommand) {

        val rovers = mutableListOf<Rover>()

        for (i in 1..command.count) {
            val rover = Rover.of(roverIdGenerator, Position.zeroPosition(), Direction.default())
            rovers.add(rover)
            println("Добавлен ровер №$i. Позиция: ${rover.position.x},${rover.position.y}. Направление: ${rover.direction}")
        }

        createRoversPort.createRovers(rovers)

    }
}

