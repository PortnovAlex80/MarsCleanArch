package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.showroversonplatueapage

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderRoversOnPlateauView(roverCoordinates: List<Pair<Int, Int>>, roverCount: Int): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapShowRoversOnPlateauPageCSS()
            body {
                div(classes = "controller-container") {
                    h1 { +"Mars Rover Controller" }
                    div(classes = "grid-container") {
                        (0..19).forEach { i ->
                            div {
                                (0..19).forEach { j ->
                                    div(
                                        classes = if (roverCoordinates.contains(
                                                Pair(
                                                    i + 1,
                                                    j + 1
                                                )
                                            )
                                        ) "grid-item rover" else "grid-item"
                                    ) {
                                        // Добавьте логику для установки класса "rover", если нужно
                                    }
                                }
                            }
                        }
                    }

                    div(classes = "button-group") {
                        // For the "Confirm Rover Creation" button
                        form(action = "/confirm_rovers", method = FormMethod.post, classes = "d-inline-block") {
                            button(classes = "btn btn-primary", type = ButtonType.submit) { +"Confirm Rover Creation" }
                        }

                        // Spacer div to create a little gap between the two buttons
                        div(classes = "d-inline-block") {
                            style = "width: 10px;"
                        }

                        // For the "Back" button
                        form(action = "/roversCoordinates", method = FormMethod.post, classes = "d-inline-block") {
                            input(type = InputType.hidden, name = "count") { value = roverCount.toString() }
                            button(classes = "btn btn-secondary", type = ButtonType.submit) { +"Back" }
                        }
                    }
                    form(classes = "exit-button", action = "/exit", method = FormMethod.post) {
                        button(type = ButtonType.submit) { +"Exit Game" }
                    }
                }
            }
        }.toString()