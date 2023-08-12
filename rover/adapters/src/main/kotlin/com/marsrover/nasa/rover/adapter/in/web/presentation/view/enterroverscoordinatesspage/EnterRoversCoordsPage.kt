package com.marsrover.nasa.rover.adapter.`in`.web.presentation.view.enterroverscoordinatesspage

import com.marsrover.nasa.rover.adapter.`in`.web.presentation.model.RoverPresentationDTO
import com.marsrover.nasa.rover.adapter.`in`.web.presentation.view.enterroverscountpage.bootstrapHeaderRenderEnterRoversCountPageViewCSS
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderCoordinatePage(rovers: List<RoverPresentationDTO>): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapHeaderRenderEnterRoversCountPageViewCSS()
            body {
                div(classes = "controller-container") {
                    h1 { +"Enter the coordinates for each rover:" }
                    form(action = "/set_coordinates", method = FormMethod.post) {
                        for (i in rovers.indices) {
                            label { +"Enter coordinates for Rover ${i + 1}: " }
                            div(classes = "row") {
                                div(classes = "col") {
                                    input(type = InputType.number, name = "coordinates") {
                                        value = rovers[i].x.toString()
                                    }
                                }
                                div(classes = "col") {
                                    input(type = InputType.number, name = "coordinates") {
                                        value = rovers[i].y.toString()
                                    }
                                }
                            }
                            br { }
                        }
                        div(classes = "button-group") {
                            a(classes = "btn btn-secondary", href = "/") { +"Back" }
                            button(classes = "btn btn-primary", type = ButtonType.submit) { +"Set Coordinates" }
                        }
                    }
                }
            }
        }.toString()