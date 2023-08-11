package com.marsrover.NasaMarsRover.rover.application.port.`in`

import com.marsrover.NasaMarsRover.rover.application.RoverCommandsExecService
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.rover.domain.RoverId

interface ExecuteRoversCommandsUseCase {
    fun execute( roverId: RoverId, command: RoverCommandsExecService.Command) {

    }
}

