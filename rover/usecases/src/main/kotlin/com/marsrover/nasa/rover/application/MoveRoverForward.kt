package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.RoverId

interface MoveRoverForward {
    fun execute(id: RoverId): Boolean
}