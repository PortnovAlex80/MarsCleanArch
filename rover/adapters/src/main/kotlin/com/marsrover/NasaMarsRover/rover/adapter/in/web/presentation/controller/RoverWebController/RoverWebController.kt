package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.controller.RoverWebController

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.model.*
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscoordinatesspage.renderCoordinatePage
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscountpage.renderEnterRoversCountPageView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.showroversonopenmapspage.renderRoversOnOpenMapPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class RoverWebController {
    @RequestMapping(value = ["/"], method = [RequestMethod.GET]) // TODO Make URL to CONST and ENV
    @ResponseBody
    fun showStartPage(model: Model): String {
        return renderEnterRoversCountPageView(
            RoverConstants.ROVER_MAX.value,
            roverCountRandomGeneratorForDefaultDemoTest()
        )
    }

    @RequestMapping(value = ["/roversCoordinates"], method = [RequestMethod.POST]) // TODO Make URL to CONST and ENV
    @ResponseBody
    fun showCoordinatePage(@RequestParam count: Int, model: Model): String {
        return renderCoordinatePage(roverCoordinatesRandomGeneratorForDefaultDemoTest(count))
    }

    @PostMapping("/set_coordinates") // TODO Make URL to CONST and ENV
    @ResponseBody
    fun showPlateauPage(@RequestParam coordinates: List<Double>, model: Model): String {
        return renderRoversOnOpenMapPage(RoverPresentationDTO.fromCoordinatesToRovers(coordinates))
    }
}