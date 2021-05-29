package com.example.concurrent.component

import org.junit.jupiter.api.Test

internal class CounterTest {

    private val counter = Counter()

    @Test
    fun `count 사용하는거`() {
        val thread1 = ThreadCounter(counter, 1)
        val thread2 = ThreadCounter(counter, 2)

        thread1.start()
        thread2.start()

        while (counter.count < 20) {
            val count = counter.count
            println("client: $count")
        }
    }

    @Test
    fun test() {
        println("start")
        sync()
        println("end")

    }

    @Synchronized
    fun sync() {
        for (num in 1..30) {
            println(num)
        }
    }
}