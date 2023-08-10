package com.marsrover.NasaMarsRover.application

import com.marsrover.NasaMarsRover.application.configuration.RoverConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NasaMarsRoverApplication

fun main(args: Array<String>) {

	runApplication<RoverConfiguration>(*args)
}