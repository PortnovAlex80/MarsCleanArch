package com.marsrover.NasaMarsRover.usecases

import com.marsrover.NasaMarsRover.adapters.RoverInputAdapter
import com.marsrover.NasaMarsRover.domain.entities.Direction
import com.marsrover.NasaMarsRover.domain.entities.Position

class RoverService(private val roverInputAdapter: RoverInputAdapter) {
    fun createRovers(): List<Pair<Position, Direction>> {
        val numberOfRovers = roverInputAdapter.getNumberOfRovers()
        val rovers = mutableListOf<Pair<Position, Direction>>()

        for (i in 1..numberOfRovers) {
            val roverData = roverInputAdapter.getRoverData(i)
            if (roverData != null) {
                rovers.add(roverData)
                val (position, direction) = roverData
                println("Добавлен ровер №$i. Позиция: ${position.x},${position.y}. Направление: $direction")
            }
        }

        println("Созданы роверы:")
        rovers.forEachIndexed { index, (position, direction) ->
            println("Ровер номер ${index + 1}: Позиция: ${position.x},${position.y}, Направление: $direction")
        }

        return rovers
    }
}