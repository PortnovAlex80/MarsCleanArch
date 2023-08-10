package com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory

import com.marsrover.NasaMarsRover.rover.domain.RoverIdGeneratorPort
import com.marsrover.NasaMarsRover.rover.domain.valueobjects.RoverId
import java.util.concurrent.atomic.AtomicLong

class InMemoryIncrementalRoverIdGeneratorAdapter : RoverIdGeneratorPort {

    private val counter = AtomicLong(0)

    override fun generate(): RoverId {
        return RoverId(counter.incrementAndGet())
    }
}