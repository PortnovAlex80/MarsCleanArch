package com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory

import com.marsrover.NasaMarsRover.rover.domain.RoverId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicLong

class InMemoryIncrementalRoverIdGeneratorAdapterTest {
    private val counter = AtomicLong(0)

    @Test
    fun generate(): RoverId {
        return RoverId(counter.incrementAndGet())
    }
}