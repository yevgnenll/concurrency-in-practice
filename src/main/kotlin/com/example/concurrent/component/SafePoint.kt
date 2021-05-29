package com.example.concurrent.component

import com.example.concurrent.annotation.ThreadSafe

@ThreadSafe
class SafePoint(
    private var x: Int,
    private var y: Int
) {

    constructor(a: Array<Int>) : this (x = a[0], y = a[1])
    constructor(safePoint: SafePoint) : this (x = safePoint.x, y = safePoint.y)

    @Synchronized
    fun get(): Array<Int> {
        return arrayOf(x, y)
    }

    @Synchronized
    fun set(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

}