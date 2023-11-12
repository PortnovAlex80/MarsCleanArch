package com.marsrover.nasa.rover.adapter.out.persistence.inmemory

import com.marsrover.nasa.rover.application.port.`in`.RoverExtractorPortIn
import com.marsrover.nasa.rover.application.port.out.CreateRoversPortOut
import com.marsrover.nasa.rover.application.port.out.UpdateRoverByIdPortOut
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

class InMemoryRoverPersistenceAdapter : CreateRoversPortOut, RoverExtractorPortIn, UpdateRoverByIdPortOut {
    private val inMemoryStorage = mutableMapOf<RoverId, Rover>()
    override fun createRoversSave(rovers: List<Rover>) {
        for (rover in rovers) {
            inMemoryStorage.put(rover.roverId, rover)
        }
    }

    override fun getRoverById(id: RoverId): Rover? {
        return inMemoryStorage[id]
    }

    override fun getAllRovers(): List<Rover>? {
        return inMemoryStorage.values.toList()
    }

    override fun update(id: RoverId, rover: Rover): Boolean {
        return if (inMemoryStorage.containsKey(id)) {
            inMemoryStorage[id] = rover
            true
        } else {
            false
        }
    }
}