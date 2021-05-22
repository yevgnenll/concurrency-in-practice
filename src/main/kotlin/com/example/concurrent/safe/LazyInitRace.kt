package com.example.concurrent.safe

import com.example.concurrent.annotation.NotThreadSafe

@NotThreadSafe
class LazyInitRace {
    lateinit var instance: ExpensiveObject

    fun instance(): ExpensiveObject {
        if (instance == null) {
            instance = ExpensiveObject()
        }
        return instance
    }
}