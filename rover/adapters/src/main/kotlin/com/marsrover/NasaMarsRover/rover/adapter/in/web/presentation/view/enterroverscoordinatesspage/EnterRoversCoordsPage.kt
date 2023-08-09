package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscoordinatesspage

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.model.RoverPresentationModel
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscountpage.bootstrapHeaderRenderEnterRoversCountPageViewCSS
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import kotlin.random.Random

fun renderCoordinatePage(rovers: List<RoverPresentationModel>): String =
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
                                    div(classes = "input-group") {
                                        div(classes = "input-group-prepend") {
                                            span(classes = "input-group-text") { +"Latitude" }
                                        }
                                        input(type = InputType.number, name = "rover${i+1}_x") {
                                            value = rovers[i].x.toString()
//                                            min = "-25.0"; max = "-24.0"; required = true
                                        }
                                    }
                                }
                                div(classes = "col") {
                                    div(classes = "input-group") {
                                        div(classes = "input-group-prepend") {
                                            span(classes = "input-group-text") { +"Longitude" }
                                        }
                                        input(type = InputType.number, name = "rover${i+1}_y") {
                                            value = rovers[i].y.toString()
//                                            min = "-70.0"; max = "-69.0"; required = true
                                        }
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



