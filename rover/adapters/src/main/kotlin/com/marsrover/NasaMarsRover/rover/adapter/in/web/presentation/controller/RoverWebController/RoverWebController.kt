package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.controller.RoverWebController

import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.showroversonplatueapage.renderRoversOnPlateauView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscoordinatesspage.renderCoordinatePage
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.enterroverscountpage.renderEnterRoversCountPageView
import com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.showroversonopenmapspage.renderRoversOnOpenMapPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class RoverWebController {
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    @ResponseBody
    fun showStartPage(model: Model): String {
        return renderEnterRoversCountPageView()
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

        val roverCount = roverCoordinates.size / 2
//        return renderRoversOnPlateauView(coordinates, roverCount)
        return renderRoversOnOpenMapPage(coordinates, roverCount)
    }
}