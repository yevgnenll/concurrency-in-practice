package com.example.concurrent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConcurrentApplication

fun main(args: Array<String>) {
    runApplication<ConcurrentApplication>(*args)
}
