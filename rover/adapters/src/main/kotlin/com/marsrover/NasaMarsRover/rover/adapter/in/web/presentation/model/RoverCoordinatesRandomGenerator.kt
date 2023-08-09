package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.model

import kotlin.random.Random

fun roverCoordinatesRandomGeneratorForDefaultDemoTest(count: Int): List<RoverPresentationModel> {

    val rovers = mutableListOf<RoverPresentationModel>()

    for (i in 1..count) {
        val x = Random.nextDouble(-25.0, -24.0)
        val y = Random.nextDouble(-70.0, -69.0)
        rovers.add(RoverPresentationModel(i, Random.nextDouble(-25.0, -24.0), Random.nextDouble(-70.0, -69.0)))
    }
    return rovers
}