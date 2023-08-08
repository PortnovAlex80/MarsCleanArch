package com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory

import com.marsrover.NasaMarsRover.rover.application.port.out.CreateRoversPort
import com.marsrover.NasaMarsRover.rover.domain.Rover
import com.marsrover.NasaMarsRover.rover.domain.RoverId
import org.springframework.stereotype.Service

class InMemoryRoverPersistenceAdapter : CreateRoversPort {
    private val inMemoryStorage = mutableMapOf<RoverId, Rover>()
    override fun createRovers(rovers: List<Rover>) {
        for (rover in rovers) {
            inMemoryStorage.put(rover.roverId, rover)
        }
    }
}