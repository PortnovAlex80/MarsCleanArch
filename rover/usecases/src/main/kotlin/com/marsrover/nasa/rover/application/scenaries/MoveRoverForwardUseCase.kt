package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.MoveRoverForward
import com.marsrover.nasa.rover.application.UpdateRoverById
import com.marsrover.nasa.rover.domain.RoverId

class MoveRoverForwardUseCase(private val getRoverById: GetRoverById, private val updateRoverById: UpdateRoverById) :
    MoveRoverForward {
    override fun execute(id: RoverId): Boolean {
        val rover = getRoverById.execute(id) ?: return false
        rover.moveForward()
        println("Rover ${id} moved forward")
        return updateRoverById.execute(id, rover)
    }
}