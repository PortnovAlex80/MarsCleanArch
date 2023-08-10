package com.marsrover.NasaMarsRover.rover.domain

class Rover(
    val roverId: RoverId,
    private var coordinatesXY: CoordinatesXY,
    private var direction: Direction,
    private val commandHistory: MutableList<Command> = mutableListOf()
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

    // Добавление команды в историю
    private fun addCommandToHistory(command: Command) {
        commandHistory.add(command)
    }

    // Выполнение команды
    private fun executeCommand(command: Command) {
        command.action.invoke(this)
        addCommandToHistory(command)
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
            // Cache of valid command characters to avoid repeated computations.
            private val validCommandsChars = values().map { it.name.first() }.toSet()

            // Convert a string of commands into a list of Command enums.
            // If any command in the string is invalid, NOP is returned.
            fun fromString(commands: String): List<Command> {
                return if (commands.all { it in validCommandsChars }) {
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
