package com.marsrover.NasaMarsRover.rover.domain

import java.util.*

class CommandUndoManager {
    private val commandStack: Stack<RoverCommandExecutor.Command> = Stack()
    fun addCommandToStack(command: RoverCommandExecutor.Command) {
        commandStack.push(command)
    }
    fun undoLastCommand(): RoverCommandExecutor.Command? {
        return if (commandStack.isNotEmpty()) commandStack.pop() else null
    }
}