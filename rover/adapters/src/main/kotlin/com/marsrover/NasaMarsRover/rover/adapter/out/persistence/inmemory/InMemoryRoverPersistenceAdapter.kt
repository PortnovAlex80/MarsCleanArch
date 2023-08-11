package com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory

import com.marsrover.NasaMarsRover.rover.application.port.out.CreateRoversPortToSaveOut
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.rover.domain.RoverId

class InMemoryRoverPersistenceAdapter : CreateRoversPortToSaveOut {
    private val inMemoryStorage = mutableMapOf<RoverId, Rover>()
    override fun createRoversSave(rovers: List<Rover>) {
        for (rover in rovers) {
            inMemoryStorage.put(rover.roverId, rover)
        }
    }
}