package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.controller.RoverWebController

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.platueapage.renderPlateauView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.startpage.renderStartPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class WebController {
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    @ResponseBody
    fun showStartPage(model: Model): String {
        return renderStartPage()
    }

    @RequestMapping(value = ["/start"], method = [RequestMethod.GET])
    @ResponseBody
    fun showPlateauForm(model: Model): String {
        return renderPlateauView()
    }
}