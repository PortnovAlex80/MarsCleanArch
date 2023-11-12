package com.marsrover.nasa.rover.adapter.out.persistence.inmemory

import com.marsrover.nasa.rover.domain.RoverIdGeneratorPort
import com.marsrover.nasa.rover.domain.RoverId
import java.util.concurrent.atomic.AtomicLong

class InMemoryIncrementalRoverIdGeneratorAdapter : RoverIdGeneratorPort {

    private val counter = AtomicLong(0)

    override fun generate(): RoverId {
        return RoverId(counter.incrementAndGet())
    }
}