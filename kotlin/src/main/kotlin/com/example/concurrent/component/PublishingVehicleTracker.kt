package com.example.concurrent.component

import com.example.concurrent.annotation.ThreadSafe
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@ThreadSafe
class PublishingVehicleTracker(
    private val locations: Map<String, SafePoint>,
    private val unmodifiedMap: Map<String, SafePoint>,
) {
    constructor(locations: Map<String, SafePoint>) : this (
        locations = ConcurrentHashMap(locations),
        unmodifiedMap = Collections.unmodifiableMap(locations)
    )

    fun getLocations(): Map<String, SafePoint> {
        return unmodifiedMap
    }

    fun getLocations(id: String): SafePoint {
        return locations[id] ?: throw IllegalArgumentException("해당하는 $id 가 없습니다")
    }

    fun setLocations(id: String, x: Int, y: Int) {
        if (!locations.containsKey(id)) {
            throw IllegalArgumentException("해당하는 $id 가 없습니다")
        }
        locations[id]!!.set(x, y)
    }
}
