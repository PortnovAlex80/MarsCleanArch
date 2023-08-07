package com.marsrover.NasaMarsRover.rover.application

import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.NasaMarsRover.rover.application.port.out.CreateRoversPort
import com.marsrover.NasaMarsRover.rover.domain.RoverIdGeneratorPort
import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.CoordinatesXY
import com.marsrover.NasaMarsRover.rover.domain.Rover
import org.springframework.stereotype.Service

@Service
class CreateRoversService(val createRoversPort: CreateRoversPort, val roverIdGenerator: RoverIdGeneratorPort) :
    CreateRoversUseCase {
    override fun execute(command: CreateRoversCommand) {

        val rovers = mutableListOf<Rover>()

        for (i in 1..command.count) {
            val rover = Rover.of(roverIdGenerator, CoordinatesXY.zeroPosition(), Direction.default())
            rovers.add(rover)
            println("Добавлен ровер ${rover.roverId.value} Позиция: ${rover.coordinatesXY.x},${rover.coordinatesXY.y}. Направление: ${rover.direction}")
        }

        // save the created Rovers to DB
        createRoversPort.createRovers(rovers)
    }
}