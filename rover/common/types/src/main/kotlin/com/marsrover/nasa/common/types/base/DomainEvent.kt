package com.marsrover.nasa.common.types.base

import java.time.OffsetDateTime
import java.util.*

open class DomainEvent protected constructor() {
    val id = EventId.generate()
    val created = OffsetDateTime.now()
}

data class EventId internal constructor(val value: UUID) {
    companion object {
        fun generate(): EventId = EventId(UUID.randomUUID())
    }
}
