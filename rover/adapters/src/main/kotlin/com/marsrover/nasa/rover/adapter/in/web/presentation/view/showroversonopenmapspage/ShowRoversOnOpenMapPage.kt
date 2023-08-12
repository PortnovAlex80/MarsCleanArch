package com.marsrover.nasa.rover.adapter.`in`.web.presentation.view.showroversonopenmapspage

import com.marsrover.nasa.rover.adapter.`in`.web.presentation.model.RoverPresentationDTO
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun renderRoversOnOpenMapPage(rovers: List<RoverPresentationDTO>): String =
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

                       // Define the custom icon
                           var roverIcon = L.icon({
                               iconUrl: 'https://img.icons8.com/?size=512&id=pg6uItOKXEQE&format=png', // Replace this with the path to your icon
                               iconSize: [30, 30], // size of the icon (You can adjust based on your icon's dimensions)
                               iconAnchor: [15, 15], // point of the icon which will correspond to marker's location
                               popupAnchor: [0, 0] // point from which the popup should open relative to the iconAnchor
                       });  
            
                       var roverCoordinates = ${rovers.toJsonString()};
                                     
                       for(var i = 0; i < roverCoordinates.length; i++) {
                           var lat = roverCoordinates[i].x;
                           var lng = roverCoordinates[i].y;
            
                           // Creating a Marker
                           //var marker1 = L.marker([lat, lng]);
                           
                           // Creating a Marker with the custom icon
                           var marker = L.marker([lat, lng], {icon: roverIcon});                        
            
                           // Adding popup to the marker
                           marker.bindPopup('Rover ' + (i + 1)).openPopup();
//                           marker1.bindPopup('Rover ' + (i + 1)).openPopup();
            
                           // Adding marker to the map
                           marker.addTo(map);
//                           marker1.addTo(map);
                       }

        """.trimIndent()
                        }
                    }
                    // rovers create from listener
                    script {
                        unsafe {
                            +"""
        document.addEventListener('DOMContentLoaded', function() {
            var form = document.getElementById('confirmRoversCreateForm');
            
            if(form) {
                form.addEventListener('submit', function(event) {
                    event.preventDefault();  // Stop the form from submitting the usual way

                    var formData = new FormData(event.target);

                    fetch(event.target.action, {
                        method: 'POST',
                        body: formData
                    }).then(response => {
                        if (response.ok) {
                            console.log('Rovers count sent successfully!');
                        } else {
                            console.error('Failed to send rovers count.');
                        }
                    });
                });
            } else {
                console.error('Form not found!');
            }
        });
        """.trimIndent()
                        }
                    }


                    div(classes = "button-group") {
                        // For the "Confirm Rover Creation" button
                        form(action = "/rovers", method = FormMethod.post, classes = "d-inline-block") {
                            attributes["id"] = "confirmRoversCreateForm"
                            // Hidden input field with the rover count
                            input(type = InputType.hidden, name = "count") {
                                value = rovers.size.toString()  // assuming rovers is accessible here
                            }

                            button(classes = "btn btn-primary", type = ButtonType.submit) { +"Confirm Rover Creation" }
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