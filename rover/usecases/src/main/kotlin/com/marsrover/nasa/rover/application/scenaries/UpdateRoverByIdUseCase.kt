package com.marsrover.nasa.rover.application.scenaries

import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.UpdateRoverById
import com.marsrover.nasa.rover.application.port.out.UpdateRoverByIdPortOut
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

class UpdateRoverByIdUseCase(private val updateRoverByIdPortOut: UpdateRoverByIdPortOut) :
    UpdateRoverById {
    override fun execute(id: RoverId, rover: Rover): Boolean {
    //    val rover = getRoverById.execute(id) ?: return false // Does it need check?
        return updateRoverByIdPortOut.update(id, rover)
    }
}