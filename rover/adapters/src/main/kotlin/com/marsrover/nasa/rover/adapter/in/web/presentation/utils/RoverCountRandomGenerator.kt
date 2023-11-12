package com.marsrover.nasa.rover.adapter.`in`.web.presentation.utils

import kotlin.random.Random

enum class RoverConstants(val value: Int) {
    ROVER_MAX(6) //  TODO carry out to ENV
 }

fun roverCountRandomGeneratorForDefaultDemoTest(): Int {
    val randomRoverCnt = Random.nextInt(1, RoverConstants.ROVER_MAX.value + 1)
    return randomRoverCnt
}