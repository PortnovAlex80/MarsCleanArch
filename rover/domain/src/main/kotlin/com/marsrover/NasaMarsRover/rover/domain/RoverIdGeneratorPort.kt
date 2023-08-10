package com.marsrover.NasaMarsRover.rover.domain

interface RoverIdGeneratorPort {
    fun generate(): RoverId
}