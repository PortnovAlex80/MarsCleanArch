package com.marsrover.NasaMarsRover.presentation.controller

import com.marsrover.NasaMarsRover.presentation.model.RoverForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute
import com.marsrover.NasaMarsRover.usecases.RoverService

@Controller
class RoverController() {

    @GetMapping("/")
    fun showForm(model: Model): String {
        model.addAttribute("roverForm", RoverForm())
        return "roverForm"
    }

}
