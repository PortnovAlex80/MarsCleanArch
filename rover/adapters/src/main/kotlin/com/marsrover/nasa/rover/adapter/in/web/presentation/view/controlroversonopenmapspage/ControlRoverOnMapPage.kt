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
        var map = new L.map('map')
        map.setView([-24.5, -69.5], 9); // центр пустыни Атакама
        var markers = {};


        // Creating a Layer object
        var layer = new L.TileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {
            attribution: '&copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community'
        });
        map.addLayer(layer);

        // Define the custom icon
        var roverIcon = L.icon({
            iconUrl: 'https://img.icons8.com/?size=512&id=pg6uItOKXEQE&format=png',
            iconSize: [30, 30],
            iconAnchor: [15, 15],
            popupAnchor: [0, 0]
        });
        
        const rovers = $roverCoordinatesJson;
        console.log(rovers);

        // Rover marker creation function
        function createRoverMarker(id, lat, lng, icon) {
            var marker = L.marker([lat, lng], {icon: icon});
            marker.bindPopup('Rover ' + id).openPopup();
            marker.addTo(map);
            markers[id] = marker;

            marker.on('click', function(e) {
                selectedRoverId = id;
            });
        }
        
        var selectedRoverId = null;
        
        for(var i = 0; i < rovers.length; i++) {
            var id = rovers[i].id
            var lng = rovers[i].lat;
            var lat = rovers[i].lng;          
            createRoverMarker(id, lat, lng, roverIcon); 
        }

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
                    console.log('Rover moved successfully!');
                    var event = new Event('roverMoved');
                    document.dispatchEvent(event);
                } else {
                    alert('Failed to move the rover.');
                }
            });
        }

        function getSelectedRoverId() {
            return selectedRoverId;
        }

        function updateRoversPositions() {
            fetch("/rovers")
            .then(response => response.json())
            .then(data => {
                data.forEach(rover => {
                var id = rover.roverId.value;
                var lat = rover.coordinatesXY.x;
                var lng = rover.coordinatesXY.y;
                console.log("INSIDE Update rover's position id = "+ id)
          console.log("INSIDE Update rover's position lat = "+ lat)
                    markerUpdate(id, lat, lng);
                });
            })
            .catch(error => {
                console.error('Error fetching rovers:', error);
            });
        }
        
        function markerUpdate(id, lat, lng) {
        var marker = markers[id];
          console.log("INSIDE Update marker's position "+ marker)
          console.log("INSIDE Update marker's position id = "+ id)
          console.log("INSIDE Update marker's position lat = "+ lat)
          
          
            if (marker) {
                var newPosition = new L.LatLng(lat, lng);
                marker.setLatLng(newPosition).update();  // Update marker's position 
                console.log("Update marker's position ")
            }
        }

        // Listener for custom roverMoved event
        document.addEventListener('roverMoved', function() {
            // Call a function to fetch new rover positions and update the markers.
            updateRoversPositions();
            
        });
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


