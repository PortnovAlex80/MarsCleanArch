package com.marsrover.nasa.rover.application.scenaries

import java.util.*

class CommandUndoUseCase {
    private val commandStack: Stack<RoverCommandsExecService.Command> = Stack()
    fun addCommandToStack(command: RoverCommandsExecService.Command) {
        commandStack.push(command)
    }
    fun undoLastCommand(): RoverCommandsExecService.Command? {
        return if (commandStack.isNotEmpty()) commandStack.pop() else null
    }
}