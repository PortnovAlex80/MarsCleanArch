package com.marsrover.nasa.rover.adapter.`in`.web.rest.controller

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.marsrover.nasa.rover.application.CreateRoversCommand
import com.marsrover.nasa.rover.application.CreateRovers
import com.marsrover.nasa.rover.application.GetAllRovers
import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.domain.CoordinatesXY
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RoverRestController(
    val createRoversUseCase: CreateRovers,
    val getAllRovers: GetAllRovers
//    val getRoverById: GetRoverById
) {


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

    @GetMapping("/rovers")
    fun getAllRovers(): List<Rover>? {
        return getAllRovers.execute()
    }

//    @GetMapping("/rovers/{id}")
//    fun getAllById(@RequestParam id: RoverId): Rover? {
//        return getRoverById.execute(id)
//    }
}

