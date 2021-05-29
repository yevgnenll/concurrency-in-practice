package com.example.concurrent.component

data class Counter(
    @get:Synchronized
    var count: Long = 0

) {
    @Synchronized
    fun increment(): Long {
        if (count == Long.MAX_VALUE) {
            throw IllegalArgumentException("count overflow")
        }
        return ++ count
    }
}