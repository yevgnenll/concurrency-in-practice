package com.example.concurrent.component

import com.example.concurrent.annotation.NotThreadSafe

@NotThreadSafe
class MutablePoint(
    var x: Int = 0,
    var y: Int = 0
) {
    constructor(point: MutablePoint): this() {
        x = point.x
        y = point.y
    }
}