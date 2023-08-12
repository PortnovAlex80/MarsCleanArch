package com.marsrover.nasa.rover.domain

interface RoverIdGeneratorPort {
    fun generate(): RoverId
}