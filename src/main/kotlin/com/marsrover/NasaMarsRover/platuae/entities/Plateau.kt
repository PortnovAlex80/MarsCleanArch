package com.marsrover.NasaMarsRover.platuae.entities

import com.marsrover.NasaMarsRover.platuae.interfaces.IPlateauInterface
import com.marsrover.NasaMarsRover.platuae.value_objects.Size

data class Plateau(override val size: Size): IPlateauInterface {

}

