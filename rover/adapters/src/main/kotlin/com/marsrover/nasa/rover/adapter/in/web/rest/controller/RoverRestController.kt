package com.marsrover.nasa.rover.adapter.`in`.web.rest.controller

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.marsrover.nasa.rover.adapter.`in`.web.presentation.model.RoverPresentationDTO
import com.marsrover.nasa.rover.application.port.`in`.CreateRoversCommand
import com.marsrover.nasa.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.nasa.rover.domain.CoordinatesXY
import com.marsrover.nasa.rover.domain.Rover
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RoverRestController(val createRoversUseCase: CreateRoversUseCase) {
    val objectMapper = jacksonObjectMapper()
    @PostMapping("/rovers")
    fun createRoversAmount(@RequestBody listOfRoversCoordinatesXY: String): ResponseEntity<String> { //TODO 'need refactoring'

        val rootNode: JsonNode = objectMapper.readTree(listOfRoversCoordinatesXY)
        val roversNode = rootNode.get("rovers")

        val roversCoords = mutableListOf<CoordinatesXY>()

        roversNode.forEach { roverNode ->
            val x = roverNode.get("x").asDouble()
            val y = roverNode.get("y").asDouble()
            roversCoords.add(CoordinatesXY(x, y))
        }

        val createRoversCommand = CreateRoversCommand(roversCoords)
        createRoversUseCase.execute(createRoversCommand)

        return ResponseEntity.ok("${roversCoords.size} rovers created successfully")
    }
}

//

