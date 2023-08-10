package com.marsrover.NasaMarsRover.rover.domain

import java.util.*

class CommandUndoManager {
    private val commandStack: Stack<CommandExecutor.Command> = Stack()
    fun addCommandToStack(command: CommandExecutor.Command) {
        commandStack.push(command)
    }
    fun undoLastCommand(): CommandExecutor.Command? {
        return if (commandStack.isNotEmpty()) commandStack.pop() else null
    }
}