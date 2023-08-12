package com.marsrover.nasa.rover.application.port.`in`

import com.marsrover.nasa.rover.application.RoverCommandsExecService
import com.marsrover.nasa.rover.domain.RoverId

interface ExecuteRoversCommandsUseCase {
    fun execute( roverId: RoverId, command: RoverCommandsExecService.Command) {

    }
}

