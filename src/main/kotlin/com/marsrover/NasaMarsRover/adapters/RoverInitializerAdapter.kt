package com.marsrover.NasaMarsRover.adapters

import com.marsrover.NasaMarsRover.rover.application.port.out.RoverIdGeneratorPort
import com.marsrover.NasaMarsRover.rover.domain.Direction
import com.marsrover.NasaMarsRover.rover.domain.Position
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.usecases.CommandCenter
import com.marsrover.NasaMarsRover.usecases.interfaces.IRoverInitializer

class RoverInitializerAdapter(
    private val roverIdGeneratorPort: RoverIdGeneratorPort,
    private val commandCenter: CommandCenter
) :
    IRoverInitializer {
    override fun initializeRovers(roverData: List<Pair<Position, Direction>>): Boolean {
        for ((position, direction) in roverData) {
            val rover = Rover.of(roverIdGeneratorPort, position, direction) // delete HOLE in create out factory!!!
            if (!commandCenter.addRover(rover)) {
                return false
            }
        }
        return true
    }
}