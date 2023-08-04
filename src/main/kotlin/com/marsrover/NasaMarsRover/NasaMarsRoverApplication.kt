package com.marsrover.NasaMarsRover

import com.marsrover.NasaMarsRover.adapters.RoverInputAdapter
import com.marsrover.NasaMarsRover.ui.ConsoleUserInputOutput
import com.marsrover.NasaMarsRover.usecases.RoverService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NasaMarsRoverApplication

fun main(args: Array<String>) {

	runApplication<NasaMarsRoverApplication>(*args)

	val userInputOutput = ConsoleUserInputOutput()
	val roverInputAdapter = RoverInputAdapter(userInputOutput)
	val roverService = RoverService(roverInputAdapter)
	roverService.createRovers()
	System.exit(0)

}
