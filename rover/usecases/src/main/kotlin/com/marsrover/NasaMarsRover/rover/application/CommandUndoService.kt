package com.marsrover.NasaMarsRover.rover.application

import java.util.*

class CommandUndoService {
    private val commandStack: Stack<RoverCommandsExecutorService.Command> = Stack()
    fun addCommandToStack(command: RoverCommandsExecutorService.Command) {
        commandStack.push(command)
    }
    fun undoLastCommand(): RoverCommandsExecutorService.Command? {
        return if (commandStack.isNotEmpty()) commandStack.pop() else null
    }
}