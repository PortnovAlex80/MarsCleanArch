package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.platueapage

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderPlateauView(roverCoordinates: List<Pair<Int, Int>>): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapPalteauPageCSS()
            body {
                div(classes = "controller-container") {
                    h1 { +"Mars Rover Controller" }
                    div(classes = "grid-container") {
                        (0..19).forEach { i ->
                            div {
                                (0..19).forEach { j ->
                                    div(classes = if (roverCoordinates.contains(Pair(i+1, j+1))) "grid-item rover" else "grid-item") {
                                        // Добавьте логику для установки класса "rover", если нужно
                                    }
                                }
                            }
                        }
                    }
                    form(classes = "button-group", action = "/confirm_rovers", method = FormMethod.post) {
                        button(classes = "btn btn-primary", type = ButtonType.submit) { +"Confirm Rover Creation" }
                        a(classes = "btn btn-secondary", href="/set_coordinates") { +"Back" }
                    }
                    form(classes = "exit-button", action = "/exit", method = FormMethod.post) {
                        button(type = ButtonType.submit) { +"Exit Game" }
                    }
                }
            }
        }.toString()