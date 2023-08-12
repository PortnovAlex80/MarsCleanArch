package com.marsrover.nasa.rover.adapter.out.persistence.inmemory

import com.marsrover.nasa.rover.application.port.out.CreateRoversPortToSaveOut
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

class InMemoryRoverPersistenceAdapter : CreateRoversPortToSaveOut {
    private val inMemoryStorage = mutableMapOf<RoverId, Rover>()
    override fun createRoversSave(rovers: List<Rover>) {
        for (rover in rovers) {
            inMemoryStorage.put(rover.roverId, rover)
        }
    }
}