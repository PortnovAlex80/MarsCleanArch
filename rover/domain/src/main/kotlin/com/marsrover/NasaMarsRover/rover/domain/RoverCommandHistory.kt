package com.marsrover.NasaMarsRover.rover.domain

// глобальное хранилище истории команд для всех роверов
class RoverCommandHistory {
    private val commands: HashMap<RoverId, MutableList<Rover.Command>> = hashMapOf()

    fun addCommand(roverId: RoverId, command: Rover.Command) {
        commands.getOrPut(roverId) { mutableListOf() }.add(command)
    }

    fun getCommandHistory(roverId: RoverId): List<Rover.Command>? {
        return commands[roverId]
    }
}
