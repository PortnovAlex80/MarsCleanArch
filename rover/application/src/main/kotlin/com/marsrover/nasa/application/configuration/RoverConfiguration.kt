package com.marsrover.nasa.application.configuration

import com.marsrover.nasa.rover.adapter.`in`.web.presentation.controller.RoverWebController.RoverWebController
import com.marsrover.nasa.rover.adapter.`in`.web.rest.controller.RoverRestController
import com.marsrover.nasa.rover.adapter.out.persistence.inmemory.InMemoryIncrementalRoverIdGeneratorAdapter
import com.marsrover.nasa.rover.adapter.out.persistence.inmemory.InMemoryRoverPersistenceAdapter

import com.marsrover.nasa.rover.application.CreateRoversService
import com.marsrover.nasa.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.nasa.rover.application.port.out.CreateRoversPortToSaveOut
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
    fun createRoversUseCase(createRoversPortToSaveOut: CreateRoversPortToSaveOut, roverIdGenerator: RoverIdGeneratorPort) =
        CreateRoversService(createRoversPortToSaveOut, roverIdGenerator)

    @Bean
    fun roverRestController(createRoversUseCase: CreateRoversUseCase) = RoverRestController(createRoversUseCase)

    @Bean
    fun roverWebController() = RoverWebController()
}