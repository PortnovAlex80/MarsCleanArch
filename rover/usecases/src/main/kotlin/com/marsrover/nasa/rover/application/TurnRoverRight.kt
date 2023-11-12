package com.marsrover.nasa.rover.application

import com.marsrover.nasa.rover.domain.RoverId

interface TurnRoverRight {
    fun execute(id: RoverId): Boolean
}