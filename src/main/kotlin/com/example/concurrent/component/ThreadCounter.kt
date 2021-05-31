package com.example.concurrent.component

class ThreadCounter(
    private val counter: Counter,
    private val threadNumber: Int,
) : Thread() {

    override fun run() {
        for (num in 1..10) {
            val count: Long = counter.increment()
            val get: Long = counter.count
            println("Thread-$threadNumber: $count, get: $get")
        }
    }
}