package com.marsrover.nasa.rover.adapter.`in`.web.rest.controller

import com.marsrover.nasa.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.nasa.rover.application.port.`in`.CreateRoversUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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
