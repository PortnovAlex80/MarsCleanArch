package com.marsrover.nasa.rover.adapter.`in`.web.presentation.utils

import com.marsrover.nasa.rover.adapter.`in`.web.presentation.model.RoverPresentationDTO
import com.marsrover.nasa.rover.domain.RoverId
import kotlin.random.Random

fun roverCoordinatesRandomGeneratorForDefaultDemoTest(count: Int): List<RoverPresentationDTO> {

    val rovers = mutableListOf<RoverPresentationDTO>()

    for (i in 1..count) {
        val x = Random.nextDouble(-25.0, -24.0)
        val y = Random.nextDouble(-70.0, -69.0)
        rovers.add(RoverPresentationDTO(RoverId.fromStringToRoverId(i.toString()), Random.nextDouble(-25.0, -24.0), Random.nextDouble(-70.0, -69.0)))
    }
    return rovers
}