package com.marsrover.nasa.rover.adapter.`in`.web.rest.controller

import arrow.core.Either
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.marsrover.nasa.rover.application.*
import com.marsrover.nasa.rover.application.scenaries.UseCaseError
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
    val turnRoverRight: TurnRoverRight,
    val moveRoverForward: MoveRoverForward
) {


    val objectMapper = jacksonObjectMapper()

    @PostMapping(API_V1_CREATE_ROVERS)
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

    @GetMapping(API_V1_GET_ALL_ROVERS)
    fun getAllRovers(): List<Rover>? {
        return getAllRovers.execute()
    }

    @GetMapping(API_V1_GET_ROVER_BY_ID)
    fun getRoverById(@PathVariable id: String): Rover? {
        return getRoverById.execute(RoverId.fromStringToRoverId(id))
    }

    @PostMapping(API_V1_MOVE_ROVER_LEFT)
    fun moveRoverToLeft(@PathVariable id: String): Boolean {
        return turnRoverLeft.execute(RoverId.fromStringToRoverId(id))
    }

    @PostMapping(API_V1_MOVE_ROVER_RIGHT)
    fun moveRoverToRight(@PathVariable id: String): Boolean {
        return turnRoverRight.execute(RoverId.fromStringToRoverId(id))
    }

    @PostMapping(API_V1_MOVE_ROVER_FORWARD)
    fun moveRoverForward(@PathVariable id: String): Either<UseCaseError, Unit> {
        return moveRoverForward.execute(RoverId.fromStringToRoverId(id))
    }
}

