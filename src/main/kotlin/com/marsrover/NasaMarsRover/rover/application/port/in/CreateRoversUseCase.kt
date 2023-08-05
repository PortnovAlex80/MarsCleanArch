package com.marsrover.NasaMarsRover.rover.application.port.`in`

interface CreateRoversUseCase {
    fun execute(command: CreateRoversCommand)
}

data class CreateRoversCommand(val count: Int)