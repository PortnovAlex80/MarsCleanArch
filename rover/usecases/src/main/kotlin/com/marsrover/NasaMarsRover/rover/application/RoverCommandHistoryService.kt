package com.marsrover.NasaMarsRover.rover.application

import com.marsrover.NasaMarsRover.rover.domain.RoverId

class RoverCommandHistoryService {
    private val commands: HashMap<RoverId, MutableList<RoverCommandsExecutorService.Command>> = hashMapOf()

    fun addCommand(roverId: RoverId, command: RoverCommandsExecutorService.Command) {
        commands.getOrPut(roverId) { mutableListOf() }.add(command)
    }

    fun getCommandHistory(roverId: RoverId): List<RoverCommandsExecutorService.Command>? {
        return commands[roverId]
    }
}