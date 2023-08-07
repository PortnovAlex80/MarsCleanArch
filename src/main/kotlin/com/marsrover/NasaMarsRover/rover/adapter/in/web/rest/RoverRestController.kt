package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.rest

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.platueapage.renderPlateauView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.startpage.renderStartPage
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversUseCase
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class RoverRestController(val createRoversUseCase: CreateRoversUseCase) {
    @PostMapping("/rovers")
    fun createRoversAmount(@RequestParam count: Int): ResponseEntity<String> {
        val createRoversCommand = CreateRoversCommand(count)
        println("From rovers page")
        createRoversUseCase.execute(createRoversCommand)
        return ResponseEntity.ok("Count rover is ${count}")
    }
}
