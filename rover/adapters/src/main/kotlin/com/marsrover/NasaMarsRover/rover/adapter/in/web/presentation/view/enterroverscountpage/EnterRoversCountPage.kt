package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscountpage

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import kotlin.random.Random

fun renderEnterRoversCountPageView(): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapHeaderRenderEnterRoversCountPageViewCSS()
            body {
                div(classes = "controller-container") {
                    h1 { +"Welcome to Uncle Bob's Blessed Mars Rover Controller" }
                    p { +"Please enter the number of rovers you want to deploy:" }
                    form(action = "/roversCoordinates", method = FormMethod.post) {
                        val ROVERMAX = 20
                        val randomRoverCnt = Random.nextInt(1, ROVERMAX)
                        input(type = InputType.number, name = "count") {
                            value = randomRoverCnt.toString()
                            min = "1"; max = "7"; required = true } // 7 because it fit on on web page for test only
                        br
                        button(type = ButtonType.submit) { +"Start Exploration" }
                    }
                }
            }
        }.toString()



