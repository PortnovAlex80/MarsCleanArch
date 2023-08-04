package com.marsrover.NasaMarsRover.usecases

import com.marsrover.NasaMarsRover.domain.entities.Position
import com.marsrover.NasaMarsRover.domain.interfaces.IPlateauInterface
import com.marsrover.NasaMarsRover.domain.interfaces.IRoverInterface

enum class RoverCommand {
    MOVE_FORWARD,
    TURN_LEFT,
    TURN_RIGHT
}

class CommandCenter(private val plateau: IPlateauInterface) {

    private val rovers: MutableList<IRoverInterface> = mutableListOf()

    fun addRover(rover: IRoverInterface): Boolean {
        // Возможно, стоит добавить проверку на то, что ровер помещается на плато
        if (isPositionAvailable(rover.position)) {
            rovers.add(rover)
            return true
        }
        return false
    }

    private fun isPositionAvailable(position: Position): Boolean {
        return rovers.none { it.position == position }
    }

    fun executeCommand(rover: IRoverInterface, command: RoverCommand) {
        when (command) {
            RoverCommand.MOVE_FORWARD -> {
                val status = rover.moveForward()
                // Check status and handle errors if necessary
            }

            RoverCommand.TURN_LEFT -> rover.turnLeft()
            RoverCommand.TURN_RIGHT -> rover.turnRight()
        }
    }

    // Здесь будут другие методы для управления роверами
}
