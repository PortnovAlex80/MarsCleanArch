package com.marsrover.nasa.rover.adapter.`in`.web.rest.controller

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.marsrover.nasa.rover.application.*
import com.marsrover.nasa.rover.domain.CoordinatesXY
import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class RoverRestController(
    val createRoversUseCase: CreateRovers,
    val getAllRovers: GetAllRovers,
    val getRoverById: GetRoverById,
    val turnRoverLeft: TurnRoverLeft,
    val turnRoverRight: TurnRoverRight
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

    @GetMapping("/rovers/{id}")
    fun getRoverById(@PathVariable id: String): Rover? {
        return getRoverById.execute(RoverId.fromStringToRoverId(id))
    }

    @GetMapping("/rovers/{id}/left")
    fun moveRoverToleft(@PathVariable id: String): Boolean {
        return turnRoverLeft.execute(RoverId.fromStringToRoverId(id))
    }

    @GetMapping("/rovers/{id}/right")
    fun moveRoverToRight(@PathVariable id: String): Boolean {
        return turnRoverRight.execute(RoverId.fromStringToRoverId(id))
    }
}

