package com.marsrover.nasa.rover.adapter.`in`.web.presentation.view.controlroversonopenmapspage

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.marsrover.nasa.rover.adapter.`in`.web.presentation.model.RoverPresentationDTO
import com.marsrover.nasa.rover.adapter.`in`.web.presentation.view.showroversonopenmapspage.bootstrapShowRoversOnOpenMapPageCSS
import com.marsrover.nasa.rover.domain.Rover
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderControlRoverOnMapPage(rovers: List<Rover>): String =
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

                    val roverCoordinatesJson = rovers.toCoordinatesJsonString()

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

                       // Define the custom icon
                           var roverIcon = L.icon({
                               iconUrl: 'https://img.icons8.com/?size=512&id=pg6uItOKXEQE&format=png', // Replace this with the path to your icon
                               iconSize: [30, 30], // size of the icon (You can adjust based on your icon's dimensions)
                               iconAnchor: [15, 15], // point of the icon which will correspond to marker's location
                               popupAnchor: [0, 0] // point from which the popup should open relative to the iconAnchor
                       });  
            
                       const rovers = $roverCoordinatesJson;
                       console.log(rovers)
                       
                        // Create a separate function to handle the marker creation and event binding
                        function createRoverMarker(id, lat, lng, icon) {
                            var marker = L.marker([lat, lng], {icon: icon});
                            marker.bindPopup('Rover ' + id).openPopup();
                            marker.addTo(map);
                        
                            // Add an event listener for the marker's click event
                            marker.on('click', function(e) {
                                selectedRoverId = id;
                            });
                        }
                        
                        var selectedRoverId = null; // this remains outside the loop as before
                        
                       
                       for(var i = 0; i < rovers.length; i++) {
                           var id = rovers[i].id
                           var lng = rovers[i].lat;
                           var lat = rovers[i].lng;          
                           // Creating a Marker
                           createRoverMarker(id, lat, lng, roverIcon); 
                       }

        """.trimIndent()
                        }
                    }

                                script {
                                    unsafe {
                                        +"""
                    function controlRover(direction) {
                        var selectedRoverId = getSelectedRoverId();
                        if (!selectedRoverId) {
                            alert('Please select a rover first!');
                            return;
                        }
            
                        var endpoint = "/rovers/" + selectedRoverId + "/" + direction;
                        fetch(endpoint, {
                            method: 'POST'
                        }).then(response => {
                            if (response.ok) {
                                alert('Rover moved successfully!');
                                // Here you may also wish to update the rover's position on the map.
                            } else {
                                alert('Failed to move the rover.');
                            }
                        });
                    }
            
                    function getSelectedRoverId() {
                        return selectedRoverId;
                    }
                    """.trimIndent()
                                    }
                                }

                    div(classes = "button-group") {

                        div(classes = "rover-control-buttons") {
                            button(classes = "btn btn-success", type = ButtonType.button) {
                                attributes["onclick"] = "controlRover('forward')"
                                +"Move Forward"
                            }
                            button(classes = "btn btn-info", type = ButtonType.button) {
                                attributes["onclick"] = "controlRover('left')"
                                +"Turn Left"
                            }
                            button(classes = "btn btn-info", type = ButtonType.button) {
                                attributes["onclick"] = "controlRover('right')"
                                +"Turn Right"
                            }
                        }


                        // Spacer div to create a little gap between the two buttons
                        div(classes = "d-inline-block") {
                            style = "width: 10px;"
                        }

                        // For the "Back" button
                        form(action = "/roversCoordinates", method = FormMethod.post, classes = "d-inline-block") {
                            input(type = InputType.hidden, name = "count") { value = rovers.size.toString() }
                            button(classes = "btn btn-secondary", type = ButtonType.submit) { +"Back" }
                        }
                    }
                    form(classes = "exit-button", action = "/exit", method = FormMethod.post) {
                        button(type = ButtonType.submit) { +"Exit Game" }
                    }
                }
            }
        }.toString()

fun List<RoverPresentationDTO>.toJsonString(): String {
    return joinToString(prefix = "[", postfix = "]") { "{ x: ${it.x}, y: ${it.y} }" }
}


// Convert the rovers list into a list of coordinates and then serialize it to JSON.
fun List<Rover>.toCoordinatesJsonString(): String {
    val coordinatesList = this.map { rover ->
        mapOf("id" to rover.roverId.value, "lat" to rover.getCoordinatesXY().y, "lng" to rover.getCoordinatesXY().x)
    }
    return jacksonObjectMapper().writeValueAsString(coordinatesList)
}


