package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.CreateRoversCommand
import com.marsrover.nasa.rover.application.CreateRovers
import com.marsrover.nasa.rover.application.GetAllRovers
import com.marsrover.nasa.rover.application.port.out.CreateRoversPortOut
import com.marsrover.nasa.rover.domain.CoordinatesXY
import com.marsrover.nasa.rover.domain.Direction
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverIdGeneratorPort

class CreateRoversUseCase(
    val getAllRovers: GetAllRovers,
    val createRoversPortOut: CreateRoversPortOut,
    val roverIdGenerator: RoverIdGeneratorPort
) :
    CreateRovers {
    override fun execute(command: CreateRoversCommand) {

        val count = command.roversCoordinatesXY.size
        if (count <= 0) error("Count must be positive")
        val oldRovers = getAllRovers.execute()
        val newRovers = mutableListOf<Rover>()

        for (coord in command.roversCoordinatesXY) {
            val newRoverCoord = CoordinatesXY(coord.x, coord.y)
            val safeOldRovers = oldRovers ?: emptyList()
            if (safeOldRovers.any { it.getCoordinatesXY() == newRoverCoord }) {
                println("Rover with coordinates $newRoverCoord already exists. Not added!")
                continue
            }

            val rover = Rover.of(roverIdGenerator, newRoverCoord, Direction.default()) //TODO: enter user Direction
            newRovers.add(rover)
            println("[CREATE ROVERS SERVICE] Добавлен ровер ${rover.roverId.value} Позиция: ${rover.getCoordinatesXY().x},${rover.getCoordinatesXY().y}. Направление: ${rover.getCoordinatesXY()}")
        }

        // save the created Rovers to DB
        createRoversPortOut.createRoversSave(newRovers)
    }
}