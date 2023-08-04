package com.marsrover.NasaMarsRover.ui

import com.marsrover.NasaMarsRover.adapters.interfaces.UserInputOutputInterface


class ConsoleUserInputOutput : UserInputOutputInterface {
    override fun readUserInput(): String {
        return readLine() ?: " "
    }

    override fun outputToUser(message: String) {
        println(message)
    }
}
