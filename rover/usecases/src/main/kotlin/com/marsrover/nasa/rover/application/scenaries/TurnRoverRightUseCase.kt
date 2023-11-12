package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.TurnRoverRight
import com.marsrover.nasa.rover.application.UpdateRoverById
import com.marsrover.nasa.rover.domain.RoverId

class TurnRoverRightUseCase(private  val getRoverById: GetRoverById, private val updateRoverById: UpdateRoverById): TurnRoverRight {
    override fun execute(id: RoverId): Boolean {
        val rover = getRoverById.execute(id) ?: return false
        rover.turnRight()
        return updateRoverById.execute(id, rover)
    }
}