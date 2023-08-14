package com.marsrover.NasaMarsRover.rover.adapter.`in`.terminal

interface UserInputOutputInterface {
    fun readUserInput(): String
    fun outputToUser(output: String)
}
