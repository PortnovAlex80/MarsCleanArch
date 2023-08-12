package com.marsrover.nasa.rover.adapter.`in`.terminal

interface UserInputOutputInterface {
    fun readUserInput(): String
    fun outputToUser(output: String)
}
