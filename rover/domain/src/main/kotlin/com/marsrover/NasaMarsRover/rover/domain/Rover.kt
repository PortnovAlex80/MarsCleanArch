package com.marsrover.NasaMarsRover.rover.domain

import java.util.*


class Rover(
    val roverId: RoverId,
    private var coordinatesXY: CoordinatesXY,
    private var direction: Direction
) {

    fun getCoordinatesXY(): CoordinatesXY = coordinatesXY
    fun getDirection(): Direction = direction

    companion object {
        fun of(
            roverIdGeneratorPort: RoverIdGeneratorPort,
            coordinatesXY: CoordinatesXY,
            direction: Direction
        ) =
            Rover(roverIdGeneratorPort.generate(), coordinatesXY, direction)
    }

    data class RoverPosition(val coordinatesXY: CoordinatesXY, val direction: Direction)

    private val roverCommandHistory = RoverCommandHistory()

    private fun addCommandToHistory(command: Command) {
        roverCommandHistory.addCommand(roverId, command)
    }
    // Stack для функции "отмена"
    private val commandStack: Stack<Command> = Stack()
    fun undoLastCommand() {
        if (commandStack.isNotEmpty()) {
            val lastCommand = commandStack.pop()
            TODO("Implement undo for $lastCommand")
        }
    }

    // Выполнение команды
    private fun executeCommand(command: Command) {
        command.action.invoke(this)
        addCommandToHistory(command)
        commandStack.push(command)
    }

    fun executeCommands(commands: List<Command>) {
        commands.forEach { executeCommand(it) }
    }

    enum class Command(val action: Rover.() -> Unit) {
        L(Rover::turnLeft),
        R(Rover::turnRight),
        M(Rover::moveForward),
        NOP(Rover::noOperation); //NOP - NO Operation (NOP)

        companion object {
            // HashSet use example. (or Set it's the same in this case).
            // Cache of valid command characters to avoid repeated computations.
            private val validCommandsSet = values().map { it.name.first() }.toHashSet()

            // Convert a string of commands into a list of Command enums.
            // If any command in the string is invalid, NOP is returned.
            fun fromString(commands: String): List<Command> {
                return if (commands.all { it in validCommandsSet }) {
                    commands.map { valueOf(it.toString()) }
                } else {
                    listOf(NOP)
                }
            }
        }
    }

    enum class CommandResult {
        SUCCESS,
        FAILURE
    }

    fun noOperation() {
        println("Commands arent valid. Do nothing") // TODO "logger"
    }

    // Moves the rover forward based on its current direction.
    fun moveForward(): CommandResult {
        // If it's safe to move forward, proceed. Otherwise, return FAILURE.
        return if (scan()) {
            TODO("Move forward")
            CommandResult.SUCCESS
        } else {
            CommandResult.FAILURE
        }
    }

    fun turnLeft() {
        // Implement the logic of turning left.
        TODO("Not implemented")
    }

    fun turnRight() {
        // Implement the logic of turning right.
        TODO("Not implemented")
    }

    // Scans the space in front of the rover to determine if it's safe to proceed.
    fun scan(): Boolean {
        // For now, always returning true. This needs to be implemented based on rover's environment.
        return true // Return true if it is safe to move forward, false otherwise.
    }
}
