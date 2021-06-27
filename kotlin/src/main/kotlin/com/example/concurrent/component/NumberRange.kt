package com.example.concurrent.component

import java.util.concurrent.atomic.AtomicInteger

class NumberRange(
    private val lower: AtomicInteger = AtomicInteger(0),
    private val upper: AtomicInteger = AtomicInteger(0),
) {

    fun setLower(i: Int) {
        // 안전하지 않은 비교문
        if (i > upper.get()) {
            throw IllegalArgumentException("$i 를 upper 보다 높게 만들 수 없습니다")
        }
        lower.set(i)
    }

    fun setUpper(i: Int) {
        if (i < lower.get()) {
            throw IllegalArgumentException("$i 를 lower 보다 낮게 만들수 없습니다")
        }
    }

    fun isInRange(i: Int): Boolean {
        return (i >= lower.get() && i <= upper.get())
    }
}