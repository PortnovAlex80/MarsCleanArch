package com.marsrover.NasaMarsRover.adapters

import com.marsrover.NasaMarsRover.adapters.interfaces.UserInputOutputInterface
import com.marsrover.NasaMarsRover.domain.entities.Direction
import com.marsrover.NasaMarsRover.domain.entities.Position

class RoverInputAdapter(private val userInputOutput: UserInputOutputInterface) {
    fun getNumberOfRovers(): Int {
        var numberOfRovers: Int? = null
        var input: String

        while (numberOfRovers == null || numberOfRovers < 1) {
            userInputOutput.outputToUser("Enter number of rovers or type 'exit' to quit:")
            input = userInputOutput.readUserInput()

            if (input.equals("exit", ignoreCase = true)) {
                userInputOutput.outputToUser("Exiting the program.")
                System.exit(0)
            }

            numberOfRovers = input.toIntOrNull()

            if (numberOfRovers == null || numberOfRovers < 1) {
                userInputOutput.outputToUser("Invalid number of rovers. Please enter a positive integer.")
            }
        }

        userInputOutput.outputToUser("Number of rovers is ${numberOfRovers}")
        return numberOfRovers
    }

    fun getRoverData(index: Int): Pair<Position, Direction>? {
        var roverData: Pair<Position, Direction>? = null
        var input: List<String>

        while (roverData == null) {
            val directionsHelper = Direction.values().joinToString(", ") { "${it.name} (${it.name.first()})" }
            userInputOutput.outputToUser("Enter initial position for rover $index in format 'X Y DIRECTION'. Possible directions are: $directionsHelper. Or type 'exit' to quit:")
            input = userInputOutput.readUserInput().split(' ')

            if (input.size == 1 && input[0].equals("exit", ignoreCase = true)) {
                userInputOutput.outputToUser("Exiting the program.")
                System.exit(0)
            }

            if (input.size != 3) {
                userInputOutput.outputToUser("Invalid input for rover. Please enter 'X Y DIRECTION'.")
                continue
            }

            val x = input[0].toIntOrNull()
            val y = input[1].toIntOrNull()
            val direction = validateDirection(input[2])

            if (x == null || y == null || direction == null) {
                userInputOutput.outputToUser("Invalid data for rover. ${x} ${y} ${direction}")
            } else {
                roverData = Position(x, y) to direction
            }
        }

        return roverData
    }

    private fun validateDirection(dir: String): Direction? {
        return try {
            Direction.values().firstOrNull { it.name.startsWith(dir.toUpperCase()) }
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}
