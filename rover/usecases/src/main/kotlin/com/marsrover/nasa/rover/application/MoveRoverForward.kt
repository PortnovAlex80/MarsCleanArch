package com.marsrover.nasa.rover.application

import arrow.core.Either
import com.marsrover.nasa.rover.application.scenaries.UseCaseError
import com.marsrover.nasa.rover.domain.RoverId

interface MoveRoverForward {
    fun execute(id: RoverId): Either<UseCaseError, Unit>
}