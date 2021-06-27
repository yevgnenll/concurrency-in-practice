package com.example.concurrent.component

import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.HashMap

class DelegatingVehicleTracker(
    private val locations: ConcurrentHashMap<String, Point>,
    private val unmodifiableMap: Map<String, Point> = Collections.unmodifiableMap(locations)
) {
    constructor(locations: ConcurrentHashMap<String, Point>) : this(locations, Collections.unmodifiableMap(locations))

    fun getLocations(): Map<String, Point> {
        return unmodifiableMap
    }

    fun getFixedLocations(): Map<String, Point> {
        return Collections.unmodifiableMap(HashMap(locations))
    }

    fun getLocations(id: String): Point {
        return locations[id] ?: throw IllegalArgumentException("해당 id는 없습니다 $id")
    }

    fun setLocation(id: String, x: Int, y: Int) {
        locations.replace(id, Point(x, y)) ?: throw IllegalArgumentException("해당 id는 없습니다 $id")
    }

}