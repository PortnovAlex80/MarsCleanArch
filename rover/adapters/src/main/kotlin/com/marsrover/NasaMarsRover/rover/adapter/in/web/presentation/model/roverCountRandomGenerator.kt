package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.model

import kotlin.random.Random

enum class RoverConstants(val value: Int) {
    ROVER_MAX(6) //  TODO carry out to ENV
 }

fun roverCountRandomGenerator(): Int {
    val randomRoverCnt = Random.nextInt(1, RoverConstants.ROVER_MAX.value + 1)
    return randomRoverCnt
}