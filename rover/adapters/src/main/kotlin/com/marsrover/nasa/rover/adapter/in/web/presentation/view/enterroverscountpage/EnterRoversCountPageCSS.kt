package com.marsrover.nasa.rover.adapter.`in`.web.presentation.view.enterroverscountpage

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.style

fun HTML.bootstrapHeaderRenderEnterRoversCountPageViewCSS() {
    head {
        link(rel = "stylesheet", href = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css")
        style {
            +"""
                    .controller-container {
                      width: 420px;
                      margin: 0 auto;
                      text-align: center;
                    }
                    .grid-container {
                      display: grid;
                      grid-template-columns: repeat(20, 20px);
                      grid-gap: 1px;
                      margin: 10px 0;
                    }
                    .grid-item {
                      width: 20px;
                      height: 20px;
                      background-color: #f0f0f0;
                      border: 1px solid #d4d4d4;
                    }
                    .button-group {
                      display: flex;
                      justify-content: space-between;
                      margin: 5px 0;
                    }
                    .button-group button {
                      flex: 1;
                      margin: 0 2px;
                    }
                    .exit-button {
                      display: block;
                      margin: 5px auto;
                    }
                    """
        }
    }
}


