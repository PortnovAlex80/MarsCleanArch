package com.marsrover.NasaMarsRover.presentation.controller

import com.marsrover.NasaMarsRover.presentation.view.renderPlateauView
import com.marsrover.NasaMarsRover.presentation.view.renderStartPage
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RoverController() {

    @GetMapping("/")
    fun showForm(model: Model): String {
        return renderStartPage()
    }

    @PostMapping("/start")
    fun showPlateauForm(model: Model): String {
        return renderPlateauView()
    }
}
