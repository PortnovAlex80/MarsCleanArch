package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.RoverId

interface TurnRoverLeft {
    fun execute(id: RoverId): Boolean
}