package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.controller.RoverWebController

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.platueapage.renderPlateauView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.roverscoordspage.renderCoordinatePage
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.startpage.renderStartPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class WebController {
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    @ResponseBody
    fun showStartPage(model: Model): String {
        return renderStartPage()
    }

    @RequestMapping(value = ["/roversCoordinates"], method = [RequestMethod.POST])
    @ResponseBody
    fun showCoordinatePage(@RequestParam count: Int, model: Model): String {
        return renderCoordinatePage(count)
    }

    @RequestMapping(value = ["/set_coordinates"], method = [RequestMethod.POST])
    @ResponseBody
    fun showPlateauPage(@RequestParam roverCoordinates: Map<String, String>, model: Model): String {
        val coordinates = roverCoordinates.entries
            .filter { it.key.startsWith("rover") }
            .groupBy(
                { it.key.substringBeforeLast('_') },
                { Pair(it.key.substringAfterLast('_'), it.value.toInt()) }
            )
            .values
            .mapNotNull { group ->
                val sortedGroup = group.sortedBy { it.first }
                if (sortedGroup.size == 2 && sortedGroup[0].first == "x" && sortedGroup[1].first == "y") {
                    sortedGroup[0].second to sortedGroup[1].second
                } else {
                    null
                }
            }
        return renderPlateauView(coordinates)
    }
}