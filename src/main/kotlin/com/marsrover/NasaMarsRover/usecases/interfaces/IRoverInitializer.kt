package com.marsrover.NasaMarsRover.usecases.interfaces

import com.marsrover.NasaMarsRover.domain.entities.Direction
import com.marsrover.NasaMarsRover.domain.entities.Position

interface IRoverInitializer {
    fun initializeRovers(roverData: List<Pair<Position, Direction>>): Boolean
}
