package com.marsrover.NasaMarsRover.rover.domain

// глобальное хранилище истории команд для всех роверов
class RoverCommandHistory {
    private val commands: HashMap<RoverId, MutableList<RoverCommandExecutor.Command>> = hashMapOf()

    fun addCommand(roverId: RoverId, command: RoverCommandExecutor.Command) {
        commands.getOrPut(roverId) { mutableListOf() }.add(command)
    }

    fun getCommandHistory(roverId: RoverId): List<RoverCommandExecutor.Command>? {
        return commands[roverId]
    }
}


