package com.marsrover.NasaMarsRover.application.configuration

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.controller.RoverWebController.RoverWebController
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.rest.controller.RoverRestController
import com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory.InMemoryIncrementalRoverIdGeneratorAdapter
import com.marsrover.NasaMarsRover.rover.adapter.out.persistence.inmemory.InMemoryRoverPersistenceAdapter
import com.marsrover.NasaMarsRover.rover.application.CreateRoversService
import com.marsrover.NasaMarsRover.rover.application.port.`in`.CreateRoversUseCase
import com.marsrover.NasaMarsRover.rover.application.port.out.CreateRoversPort
import com.marsrover.NasaMarsRover.rover.domain.RoverIdGeneratorPort
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableAutoConfiguration
@EnableWebMvc

class RoverConfiguration {
    @Bean
    fun inMemoryIncrementalRoverIdGeneratorAdapter() = InMemoryIncrementalRoverIdGeneratorAdapter()

    @Bean
    fun inMemoryRoverPersistenceAdapter() = InMemoryRoverPersistenceAdapter()

    @Bean
    fun createRoversService(createRoversPort: CreateRoversPort, roverIdGenerator: RoverIdGeneratorPort) =
        CreateRoversService(createRoversPort, roverIdGenerator)

    @Bean
    fun roverRestController(createRoversUseCase: CreateRoversUseCase) = RoverRestController(createRoversUseCase)

    @Bean

    fun roverWebController() = RoverWebController()
}