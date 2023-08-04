package com.marsrover.NasaMarsRover.adapters

import com.marsrover.NasaMarsRover.domain.entities.Direction
import com.marsrover.NasaMarsRover.domain.entities.Position
import com.marsrover.NasaMarsRover.domain.entities.Rover
import com.marsrover.NasaMarsRover.usecases.CommandCenter
import com.marsrover.NasaMarsRover.usecases.interfaces.IRoverInitializer

class RoverInitializerAdapter (private val commandCenter: CommandCenter) : IRoverInitializer {
    override fun initializeRovers(roverData: List<Pair<Position, Direction>>): Boolean {
        for ((position, direction) in roverData) {
            val rover = Rover(position, direction)
            if (!commandCenter.addRover(rover)) {
                return false
            }
        }
        return true
    }
}