package com.marsrover.NasaMarsRover.presentation.view

import kotlinx.html.*
import kotlinx.html.stream.appendHTML


fun renderStartPage(): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapHeader()
            body {
                div(classes = "controller-container") {
                    h1 { +"Welcome to Uncle Bob's Blessed Mars Rover Controller" }
                    p { +"Please enter the number of rovers you want to deploy:" }
                    form(action = "/start", method = FormMethod.post) {
                        input(type = InputType.number, name = "rovers") { min = "1"; max = "1"; required = true }
                        br
                        button(type = ButtonType.submit) { +"Start Exploration" }
                    }
                }
            }
        }.toString()



