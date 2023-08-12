package com.marsrover.nasa.rover.domain

data class RoverId(val value: Long) {
    companion object {
        fun fromStringToRoverId(id: String): RoverId {
            val longFromString = id.toLong()
            return RoverId(longFromString)
        }
    }
}


