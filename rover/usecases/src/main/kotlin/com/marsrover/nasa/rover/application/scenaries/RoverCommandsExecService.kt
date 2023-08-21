package com.marsrover.nasa.rover.application.scenaries

import arrow.core.Either
import com.marsrover.nasa.rover.domain.CommandResult
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverDriverErrors


class RoverCommandsExecService(
    private val rover: Rover,
    private val commandHistory: RoverCommandHistoryService,
    private val commandUndoUseCase: CommandUndoUseCase
) {
    enum class Command(val action: Rover.() -> Either<RoverDriverErrors, CommandResult>) {
      //  L(Rover::turnLeft),
    //    R(Rover::turnRight),
        M(Rover::moveForward);
     //   NOP(Rover::noOperation); //NOP - NO Operation (NOP)

        companion object {
            private val validCommandsSet = values().map { it.name.first() }.toHashSet()

            fun fromString(commands: String): List<Command> {
                return if (commands.all { it in validCommandsSet }) {
                    commands.map { valueOf(it.toString()) }
                } else {
                //    listOf(NOP)
                    listOf(M)
                }
            }
        }
    }

    private fun executeCommand(command: Command): Either<RoverDriverErrors, CommandResult> {
        val result = command.action.invoke(rover)
        return when(result) {
            is Either.Left -> {
                println("Command failed due to: ${result.value}")
                result
            }
            is Either.Right -> {
                commandHistory.addCommand(rover.roverId, command)
                commandUndoUseCase.addCommandToStack(command)
                result
            }
        }
    }

    fun executeCommands(commands: String) {
        val commandList = Command.fromString(commands)
        commandList.forEach { executeCommand(it) }
    }
}