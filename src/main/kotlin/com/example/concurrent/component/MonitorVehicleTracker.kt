package com.example.concurrent.component

import com.example.concurrent.annotation.ThreadSafe

@ThreadSafe
class MonitorVehicleTracker(
    @get:Synchronized
    private val locations: Map<String, MutablePoint>
) {

    @Synchronized
    fun getLocation(): Map<String, MutablePoint> {
        return deepCopy(locations)
    }

    @Synchronized
    fun getLocation(id: String): MutablePoint? {
        return locations[id]
    }

    @Synchronized
    fun setLocation(id: String, x: Int, y: Int) {
        var loc: MutablePoint? = locations[id] ?: throw IllegalArgumentException("해당하는 id가 없음 $id")
        loc!!.x = x
        loc!!.y = y
    }

    companion object {
        fun deepCopy(m: Map<String, MutablePoint>): Map<String, MutablePoint> {
            var result: Map<String, MutablePoint> = HashMap()
            for (key: String in m.keys) {
                result.plus(Pair(key, m[key]))
            }
            return result
        }
    }
}