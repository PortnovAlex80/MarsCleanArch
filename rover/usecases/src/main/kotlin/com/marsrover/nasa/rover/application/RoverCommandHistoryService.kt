package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.RoverId

class RoverCommandHistoryService {
    private val commands: HashMap<RoverId, MutableList<RoverCommandsExecService.Command>> = hashMapOf()

    fun addCommand(roverId: RoverId, command: RoverCommandsExecService.Command) {
        commands.getOrPut(roverId) { mutableListOf() }.add(command)
    }

    fun getCommandHistory(roverId: RoverId): List<RoverCommandsExecService.Command>? {
        return commands[roverId]
    }
}