package com.marsrover.NasaMarsRover.rover.application

import com.marsrover.NasaMarsRover.rover.domain.Rover

class RoverCommandsExecutorService(
    private val rover: Rover,
    private val commandHistory: RoverCommandHistoryService,
    private val commandUndoService: CommandUndoService
) {
    enum class Command(val action: Rover.() -> Rover.CommandResult) {
        L(Rover::turnLeft),
        R(Rover::turnRight),
        M(Rover::moveForward),
        NOP(Rover::noOperation); //NOP - NO Operation (NOP)

        companion object {
            private val validCommandsSet = values().map { it.name.first() }.toHashSet()

            fun fromString(commands: String): List<Command> {
                return if (commands.all { it in validCommandsSet }) {
                    commands.map { valueOf(it.toString()) }
                } else {
                    listOf(NOP)
                }
            }
        }
    }

    private fun executeCommand(command: Command): Rover.CommandResult {
        val result = command.action.invoke(rover)
        if ( result == Rover.CommandResult.SUCCESS) {
            commandHistory.addCommand(rover.roverId, command)
            commandUndoService.addCommandToStack(command)
        }
        return result
    }

    fun executeCommands(commands: String) {
        val commandList = Command.fromString(commands)
        commandList.forEach { executeCommand(it) }
    }
}