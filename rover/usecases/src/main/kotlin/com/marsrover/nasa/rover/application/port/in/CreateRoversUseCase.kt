package com.marsrover.nasa.rover.application.port.`in`

interface CreateRoversUseCase {
    fun execute(command: CreateRoversCommand)
}

data class CreateRoversCommand(val count: Int) {
    init {
        if (count <=0 ) error("Rover count must be positive")
    }
}