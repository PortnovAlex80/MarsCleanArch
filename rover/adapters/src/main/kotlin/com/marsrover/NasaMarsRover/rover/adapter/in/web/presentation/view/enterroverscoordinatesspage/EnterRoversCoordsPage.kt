package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscoordinatesspage

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscountpage.bootstrapHeaderRenderEnterRoversCountPageViewCSS
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import kotlin.random.Random

fun renderCoordinatePage(roverCount: Int): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapHeaderRenderEnterRoversCountPageViewCSS()
            body {
                div(classes = "controller-container") {
                    h1 { +"Enter the coordinates for each rover:" }
                    form(action = "/set_coordinates", method = FormMethod.post) {
                        for (i in 1..roverCount) {
                            val randomLatitude = Random.nextDouble(-25.0, -24.0)
                            val randomLongitude = Random.nextDouble(-70.0, -69.0)
                            label { +"Enter coordinates for Rover $i: " }
                            div(classes = "row") {
                                div(classes = "col") {
                                    div(classes = "input-group") {
                                        div(classes = "input-group-prepend") {
                                            span(classes = "input-group-text") { +"Latitude" }
                                        }
                                        input(type = InputType.number, name = "rover${i}_x") {
                                            value = randomLatitude.toString()
//                                            min = "-25.0"; max = "-24.0"; required = true
                                        }
                                    }
                                }
                                div(classes = "col") {
                                    div(classes = "input-group") {
                                        div(classes = "input-group-prepend") {
                                            span(classes = "input-group-text") { +"Longitude" }
                                        }
                                        input(type = InputType.number, name = "rover${i}_y") {
                                            value = randomLongitude.toString()
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



