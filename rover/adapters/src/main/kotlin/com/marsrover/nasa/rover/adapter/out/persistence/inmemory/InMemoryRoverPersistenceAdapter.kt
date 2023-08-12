package com.marsrover.nasa.rover.adapter.out.persistence.inmemory

import com.marsrover.nasa.rover.application.port.out.CreateRoversPortOut
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

class InMemoryRoverPersistenceAdapter : CreateRoversPortOut {
    private val inMemoryStorage = mutableMapOf<RoverId, Rover>()
    override fun createRoversSave(rovers: List<Rover>) {
        for (rover in rovers) {
            inMemoryStorage.put(rover.roverId, rover)
        }
    }
    override fun readRovers(): List<Rover> {
        return inMemoryStorage.values.toList()
    }
}