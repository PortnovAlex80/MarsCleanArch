package com.marsrover.NasaMarsRover.presentation.view

import kotlinx.html.*
import kotlinx.html.stream.appendHTML


fun renderDetailedView(): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapHeader()
            body {
                div(classes = "controller-container") {
                    h1 { +"Mars Rover Controller" }
                    div(classes = "grid-container") {
                        (0..19).forEach { i ->
                            div {
                                (0..19).forEach { j ->
                                    div(classes = "grid-item") {
                                        // Добавьте логику для установки класса "rover", если нужно
                                    }
                                }
                            }
                        }
                    }
                    div(classes = "button-group") {
                        form(action = "/left", method = FormMethod.post) {
                            button(type = ButtonType.submit) { +"Left" }
                            input(type = InputType.hidden, name = "direction") { value = "left" }
                        }
                        form(action = "/move", method = FormMethod.post) {
                            button(type = ButtonType.submit) { +"Forward" }
                            input(type = InputType.hidden, name = "direction") { value = "forward" }
                        }
                        form(action = "/right", method = FormMethod.post) {
                            button(type = ButtonType.submit) { +"Right" }
                            input(type = InputType.hidden, name = "direction") { value = "right" }
                        }
                    }
                    form(classes = "exit-button", action = "/exit", method = FormMethod.post) {
                        button(type = ButtonType.submit) { +"Exit Game" }
                    }
                }
            }
        }.toString()

