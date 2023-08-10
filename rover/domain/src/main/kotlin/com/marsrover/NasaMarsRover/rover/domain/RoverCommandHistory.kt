package com.marsrover.NasaMarsRover.rover.domain

import com.marsrover.NasaMarsRover.rover.domain.valueobjects.RoverId

// глобальное хранилище истории команд для всех роверов
class RoverCommandHistory {
    private val commands: HashMap<RoverId, MutableList<CommandExecutor.Command>> = hashMapOf()

    fun addCommand(roverId: RoverId, command: CommandExecutor.Command) {
        commands.getOrPut(roverId) { mutableListOf() }.add(command)
    }

    fun getCommandHistory(roverId: RoverId): List<CommandExecutor.Command>? {
        return commands[roverId]
    }
}


