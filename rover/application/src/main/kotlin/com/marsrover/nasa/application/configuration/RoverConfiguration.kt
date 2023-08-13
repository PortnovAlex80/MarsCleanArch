package com.marsrover.nasa.application.configuration

import com.marsrover.nasa.rover.adapter.`in`.web.presentation.controller.RoverWebController.RoverWebController
import com.marsrover.nasa.rover.adapter.`in`.web.rest.controller.RoverRestController
import com.marsrover.nasa.rover.adapter.out.persistence.inmemory.InMemoryIncrementalRoverIdGeneratorAdapter
import com.marsrover.nasa.rover.adapter.out.persistence.inmemory.InMemoryRoverPersistenceAdapter
import com.marsrover.nasa.rover.application.*
import com.marsrover.nasa.rover.application.port.`in`.RoverExtractorPortIn

import com.marsrover.nasa.rover.application.port.out.CreateRoversPortOut
import com.marsrover.nasa.rover.application.port.out.UpdateRoverByIdPortOut
import com.marsrover.nasa.rover.application.scenaries.*
import com.marsrover.nasa.rover.domain.RoverIdGeneratorPort

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableAutoConfiguration
@EnableWebMvc

class RoverConfiguration {
    @Bean
    fun roverIdGeneratorPort() = InMemoryIncrementalRoverIdGeneratorAdapter()

    @Bean
    fun createRoversPort() = InMemoryRoverPersistenceAdapter()

    @Bean
    fun createRoversUseCase(createRoversPortOut: CreateRoversPortOut, roverIdGenerator: RoverIdGeneratorPort) =
        CreateRoversUseCase(createRoversPortOut, roverIdGenerator)

    @Bean
    fun getAllRoversUseCase(roverExtractorPortIn: RoverExtractorPortIn): GetAllRovers =
        GetAllRoversUseCase(roverExtractorPortIn)

    @Bean
    fun getRoverByIdUseCase(roverExtractorPortIn: RoverExtractorPortIn): GetRoverById =
        GetRoverByIdUseCase(roverExtractorPortIn)


    @Bean
    fun updateRoverById(updateRoverByIdPortOut: UpdateRoverByIdPortOut) = UpdateRoverByIdUseCase(updateRoverByIdPortOut)
    @Bean
    fun turnRoverLeftUseCase(getRoverById: GetRoverById, updateRoverById: UpdateRoverById): TurnRoverLeft = TurnRoverLeftUseCase(getRoverById,updateRoverById)
    @Bean
    fun turnRoverRightUseCase(getRoverById: GetRoverById, updateRoverById: UpdateRoverById): TurnRoverRight = TurnRoverRightUseCase(getRoverById,updateRoverById)
    @Bean
    fun moveRoverForwardUseCase(getRoverById: GetRoverById, updateRoverById: UpdateRoverById): MoveRoverForward = MoveRoverForwardUseCase(getRoverById, updateRoverById)

    @Bean
    fun roverRestController(
        createRoversUseCase: CreateRovers,
        getAllRovers: GetAllRovers,
        getRoverById: GetRoverById,
        leftRoverById: TurnRoverLeft,
        turnRoverRight: TurnRoverRight,
        moveRoverForward: MoveRoverForward
    ) = RoverRestController(createRoversUseCase, getAllRovers, getRoverById, leftRoverById, turnRoverRight, moveRoverForward)

    @Bean
    fun roverWebController() = RoverWebController()
}