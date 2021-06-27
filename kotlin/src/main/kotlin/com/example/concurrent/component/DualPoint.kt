package com.example.concurrent.component

import java.awt.Point

class DualPoint(
    var x: Int,
    var y: Int,
    var point: Point
) : Point(x, y) {
    init {
        var counter: Counter = Counter()
        counter.count = 1
    }
}