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
                            val randomX = Random.nextInt(1, 20)
                            val randomY = Random.nextInt(1, 20)
                            label { +"Enter coordinates for Rover $i: " }
                            div(classes = "row") {
                                div(classes = "col") {
                                    div(classes = "input-group") {
                                        div(classes = "input-group-prepend") {
                                            span(classes = "input-group-text") { +"X" }
                                        }
                                        input(type = InputType.number, name = "rover${i}_x") {
                                            value = randomX.toString()
                                            min = "1"; max = "100"; required = true
                                        }
                                    }
                                }
                                div(classes = "col") {
                                    div(classes = "input-group") {
                                        div(classes = "input-group-prepend") {
                                            span(classes = "input-group-text") { +"Y" }
                                        }
                                        input(type = InputType.number, name = "rover${i}_y") {
                                            value = randomY.toString()
                                            min = "1"; max = "100"; required = true
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



