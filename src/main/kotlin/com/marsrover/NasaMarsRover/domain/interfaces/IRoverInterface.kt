package com.marsrover.NasaMarsRover.domain.interfaces

import com.marsrover.NasaMarsRover.domain.entities.Direction
import com.marsrover.NasaMarsRover.domain.entities.Position

interface IRoverInterface {
    var position: Position
    var direction: Direction
    fun moveForward(): Int
    fun turnLeft()
    fun turnRight()
    fun scan(): Boolean
}
