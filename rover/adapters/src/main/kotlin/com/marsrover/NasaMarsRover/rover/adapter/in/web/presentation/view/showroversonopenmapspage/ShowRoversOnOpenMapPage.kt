package com.marsrover.NasaMarsRover.rover.adapter.`in`.web.presentation.view.showroversonopenmapspage

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderRoversOnOpenMapPage(roverCoordinates: List<Pair<Double, Double>>, roverCount: Int): String =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapShowRoversOnOpenMapPageCSS()
            body {
                div(classes = "controller-container") {
                    h1 { +"Mars Rover Controller" }
                    // Leaflet CSS
                    link {
                        rel = "stylesheet"
                        href = "https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
                    }

                    // Leaflet JS
                    script {
                        src = "https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
                    }
                    div {
                        id = "map"
                        style = "height: 400px; width: 100%;"
                    }
                    script {
                        unsafe {
                            +"""
                       var map = L.map('map').setView([-24.5, -69.5], 9); // центр пустыни Атакама

                       // Creating a Layer object
                       var layer = new L.TileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {
                           attribution: '&copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community'
                       });

                      // Adding layer to the map
                       map.addLayer(layer);
            
                       var roverCoordinates = ${roverCoordinates.toJsonString()};
                       
                       for(var i = 0; i < roverCoordinates.length; i++) {
                           var lat = roverCoordinates[i][0];
                           var lng = roverCoordinates[i][1];
            
                           // Creating a Marker
                           var marker = L.marker([lat, lng]);
            
                           // Adding popup to the marker
                           marker.bindPopup('Rover ' + (i + 1)).openPopup();
            
                           // Adding marker to the map
                           marker.addTo(map);
                       }

        """.trimIndent()
                        }
                    }

                    div(classes = "button-group") {
                        // For the "Confirm Rover Creation" button
                        form(action = "/confirm_rovers", method = FormMethod.post, classes = "d-inline-block") {
                            button(classes = "btn btn-primary", type = ButtonType.submit) { +"Confirm Rover Creation" }
                        }

                        // Spacer div to create a little gap between the two buttons
                        div(classes = "d-inline-block") {
                            style = "width: 10px;"
                        }

                        // For the "Back" button
                        form(action = "/roversCoordinates", method = FormMethod.post, classes = "d-inline-block") {
                            input(type = InputType.hidden, name = "count") { value = roverCount.toString() }
                            button(classes = "btn btn-secondary", type = ButtonType.submit) { +"Back" }
                        }
                    }
                    form(classes = "exit-button", action = "/exit", method = FormMethod.post) {
                        button(type = ButtonType.submit) { +"Exit Game" }
                    }
                }
            }
        }.toString()

fun List<Pair<Double, Double>>.toJsonString(): String {
    return joinToString(prefix = "[", postfix = "]") { "[${it.first}, ${it.second}]" }
}
