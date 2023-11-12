package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.TurnRoverLeft
import com.marsrover.nasa.rover.application.UpdateRoverById
import com.marsrover.nasa.rover.domain.RoverId

class TurnRoverLeftUseCase(private val getRoverById: GetRoverById, private val updateRoverById: UpdateRoverById) :
    TurnRoverLeft {

    override fun execute(id: RoverId): Boolean {
        val rover = getRoverById.execute(id) ?: return false
        rover.turnLeft()
        println("Rover ${rover.roverId} turn left")
        return updateRoverById.execute(id, rover)
    }
}