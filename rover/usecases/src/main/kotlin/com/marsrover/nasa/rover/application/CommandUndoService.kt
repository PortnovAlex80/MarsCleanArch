package com.marsrover.nasa.rover.application

import java.util.*

class CommandUndoService {
    private val commandStack: Stack<RoverCommandsExecService.Command> = Stack()
    fun addCommandToStack(command: RoverCommandsExecService.Command) {
        commandStack.push(command)
    }
    fun undoLastCommand(): RoverCommandsExecService.Command? {
        return if (commandStack.isNotEmpty()) commandStack.pop() else null
    }
}