package com.marsrover.nasa.rover.adapter.`in`.terminal


class ConsoleUserInputOutput : UserInputOutputInterface {
    override fun readUserInput(): String {
        return readLine() ?: " "
    }

    override fun outputToUser(message: String) {
        println(message)
    }
}
