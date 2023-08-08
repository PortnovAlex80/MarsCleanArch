package com.marsrover.NasaMarsRover.rover.application.port.out

interface CreateRoversPort {
    fun createRovers(rovers: List<Rover>)
}