package com.marsrover.nasa.rover.application.scenaries

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.MoveRoverForward
import com.marsrover.nasa.rover.application.UpdateRoverById
import com.marsrover.nasa.rover.domain.BusinessError
import com.marsrover.nasa.rover.domain.RoverId

class MoveRoverForwardUseCase(private val getRoverById: GetRoverById, private val updateRoverById: UpdateRoverById) :
    MoveRoverForward {
    override fun execute(id: RoverId): Either<UseCaseError, Unit> {
        val rover = getRoverById.execute(id) ?: return UseCaseError.RoverNotFount.left()
        val moveResult = rover.moveForward()
        if (moveResult.isLeft()) {
            println("Rover command fault ${moveResult.left()}")
            return UseCaseError.RoverOverheating.left()
        } else {
            println("Rover ${id} moved forward")
            updateRoverById.execute(id, rover).right()
            return Unit.right()
        }
    }
}

sealed class UseCaseError : BusinessError {
    object RoverNotFount : UseCaseError()
    object RoverOverheating: UseCaseError()

}