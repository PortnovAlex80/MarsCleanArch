package com.marsrover.NasaMarsRover.domain.entities

import com.marsrover.NasaMarsRover.domain.interfaces.IPlateauInterface
import com.marsrover.NasaMarsRover.domain.value_objects.Size

data class Plateau(override val size: Size): IPlateauInterface {

}

