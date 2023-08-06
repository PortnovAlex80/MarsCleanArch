package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view

import kotlinx.html.*
import kotlinx.html.stream.appendHTML


fun renderPlateauView(): String =
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
                                    div(classes = "grid-item") {
                                        // Добавьте логику для установки класса "rover", если нужно
                                    }
                                }
                            }
                        }
                    }
                    form(classes = "coordinate-form") {
                        div {
                            label { +"X Coordinate:" }
                            input(classes = "coordinate-input short-input", type = InputType.number, name = "x") {
                                min = "0"; max = "19"; required = true
                            }
                        }
                        div {
                            label { +"Y Coordinate:" }
                            input(classes = "coordinate-input short-input", type = InputType.number, name = "y") {
                                min = "0"; max = "19"; required = true
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