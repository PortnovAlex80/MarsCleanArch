package com.marsrover.nasa.rover.adapter.`in`.web.presentation.model

import com.marsrover.nasa.rover.domain.Rover
import com.marsrover.nasa.rover.domain.RoverId

data class RoverPresentationDTO(
    val roverTemporaryId: RoverId,
    val x: Double,
    val y: Double
) {
    companion object {
        fun fromCoordinatesToRoverPresentationDTO(coordinates: List<Double>): List<RoverPresentationDTO> {
            return coordinates.chunked(2).mapIndexed { index, coordList ->
                RoverPresentationDTO(
                    roverTemporaryId = RoverId.fromStringToRoverId((index + 1).toString()),
                    x = coordList[0],
                    y = coordList[1]
                )
            }
        }

        private fun fromRoversToCoordinatesPresentationDTO(rovers: List<Rover>): List<RoverPresentationDTO> {
            return rovers.mapIndexed { index, rover ->
                RoverPresentationDTO(
                    roverTemporaryId = rover.roverId,
                    x = rover.getCoordinatesXY().x,
                    y = rover.getCoordinatesXY().y
                )
            }
        }

        fun roversToString(rovers: List<Rover>): String {
            val roverDTOs = fromRoversToCoordinatesPresentationDTO(rovers)
            return roverDTOs.joinToString(separator = "\n") { it.toString() }
        }

    }

    override fun toString(): String {
        return "Rover $roverTemporaryId: ($x, $y)"
    }
}


