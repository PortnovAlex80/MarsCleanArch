package com.marsrover.nasa.rover.adapter.`in`.web.presentation.model

data class RoverPresentationDTO(
    val roverTemporaryId: Int,
    val x: Double,
    val y: Double
) {
    companion object {
        fun fromCoordinatesToRoverPresentationDTO(coordinates: List<Double>): List<RoverPresentationDTO> {
            return coordinates.chunked(2).mapIndexed { index, coordList ->
                RoverPresentationDTO(
                    roverTemporaryId = index + 1,
                    x = coordList[0],
                    y = coordList[1]
                )
            }
        }
    }
}

