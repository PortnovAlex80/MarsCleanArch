package com.marsrover.nasa.application

import com.marsrover.nasa.application.configuration.RoverConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NasaMarsRoverApplication

fun main(args: Array<String>) {
	runApplication<RoverConfiguration>(*args)
}