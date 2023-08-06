package com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory

import com.marsrover.NasaMarsRover.rover.application.port.out.RoverIdGeneratorPort
import com.marsrover.NasaMarsRover.rover.domain.RoverId
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class InMemoryIncrementalRoverIdGeneratorAdapter : RoverIdGeneratorPort {

    private val counter = AtomicLong(0)

    override fun generate(): RoverId {
        return RoverId(counter.incrementAndGet())
    }
}