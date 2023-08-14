package com.marsrover.NasaMarsRover.rover.adapter.`in`.terminal

import com.marsrover.NasaMarsRover.rover.adapter.`in`.terminal.UserInputOutputInterface


class ConsoleUserInputOutput : UserInputOutputInterface {
    override fun readUserInput(): String {
        return readLine() ?: " "
    }

    override fun outputToUser(message: String) {
        println(message)
    }
}
