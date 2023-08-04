package com.marsrover.NasaMarsRover.usecases.interfaces

interface ICommandProcessor {
    fun processCommands(input: String): Boolean
}