package com.marsrover.nasa.application.configuration

import com.marsrover.nasa.rover.adapter.`in`.web.presentation.controller.RoverWebController.RoverWebController
import com.marsrover.nasa.rover.adapter.`in`.web.rest.controller.RoverRestController
import com.marsrover.nasa.rover.adapter.out.persistence.inmemory.InMemoryIncrementalRoverIdGeneratorAdapter
import com.marsrover.nasa.rover.adapter.out.persistence.inmemory.InMemoryRoverPersistenceAdapter
import com.marsrover.nasa.rover.application.CreateRovers
import com.marsrover.nasa.rover.application.GetAllRovers
import com.marsrover.nasa.rover.application.GetRoverById
import com.marsrover.nasa.rover.application.port.`in`.RoverExtractorPortIn

import com.marsrover.nasa.rover.application.port.out.CreateRoversPortOut
import com.marsrover.nasa.rover.application.scenaries.CreateRoversUseCase
import com.marsrover.nasa.rover.application.scenaries.GetAllRoversUseCase
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
    fun roverRestController(
        createRoversUseCase: CreateRovers,
        getAllRovers: GetAllRovers,
    ) = RoverRestController(createRoversUseCase, getAllRovers)

    @Bean
    fun roverWebController() = RoverWebController()
}