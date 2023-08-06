package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.rest

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.renderPlateauView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.renderStartPage
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversUseCase
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class RoverRestController(val createRoversUseCase: CreateRoversUseCase) {

    @GetMapping("/")
    //enter rover amount
    fun showForm(model: Model): String {
        return renderStartPage()
    }

    //     enter rover coordinates
    @PostMapping("/start")
    fun showPlateauForm(model: Model): String {
        return renderPlateauView()
    }

    @PostMapping("/rovers")
    fun createRoversAmount(@RequestParam count: Int): ResponseEntity<String> {
        val createRoversCommand = CreateRoversCommand(count)
        createRoversUseCase.execute(createRoversCommand)
        println("hi")

        return ResponseEntity.ok("Count rover is ${count}")
    }
}
