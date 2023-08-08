package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscountpage

import kotlinx.html.*
import kotlinx.html.stream.appendHTML


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
                        input(type = InputType.number, name = "count") { min = "1"; max = "5"; required = true }
                        br
                        button(type = ButtonType.submit) { +"Start Exploration" }
                    }
                }
            }
        }.toString()


