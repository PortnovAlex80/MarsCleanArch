package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.roverscoordspage

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderCoordinatePage(roverCount: Int): String =
    StringBuilder()
        .appendHTML()
        .html {
            body {
                div(classes = "controller-container") {
                    h1 { +"Enter the coordinates for each rover:" }
                    form(action = "/set_coordinates", method = FormMethod.post) {
                        for (i in 1..roverCount) {
                            label { +"Enter coordinates for Rover $i: " }
                            input(type = InputType.text, name = "rover${i}_coordinates") { required = true }
                            br { }
                        }
                        button(type = ButtonType.submit) { +"Set Coordinates" }
                    }
                }
            }
        }.toString()
