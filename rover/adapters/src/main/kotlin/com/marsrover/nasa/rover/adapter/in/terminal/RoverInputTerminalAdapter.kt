package com.marsrover.nasa.rover.adapter.`in`.terminal

import com.marsrover.nasa.rover.domain.Direction
import com.marsrover.nasa.rover.domain.CoordinatesXY

class RoverInputTerminalAdapter(private val userInputOutput: UserInputOutputInterface) {
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

    fun getRoverData(index: Int): Pair<CoordinatesXY, Direction>? {
        var roverData: Pair<CoordinatesXY, Direction>? = null
        var input: List<String>

        while (roverData == null) {

            userInputOutput.outputToUser("Enter initial position for rover $index in format 'X Y DIRECTION'. Possible directions are: ${Direction.possibleDirections()} . Or type 'exit' to quit:")
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
            val isDirectionValid = Direction.isValidInput(input[2])
            val direction = Direction.valueOf(input[2].uppercase())
            if (x == null || y == null || !isDirectionValid) {
                userInputOutput.outputToUser("Invalid data for rover. ${x} ${y} ${direction}")
            } else {

                roverData = Pair(CoordinatesXY(x, y), direction)
            }
        }

        return roverData
    }


}
