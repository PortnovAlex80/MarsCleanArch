package com.marsrover.NasaMarsRover.usecases.interfaces

import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.Position

interface IRoverInitializer {
    fun initializeRovers(roverData: List<Pair<Position, Direction>>): Boolean
}
