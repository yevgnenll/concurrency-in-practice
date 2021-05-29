package com.example.concurrent.component

import com.example.concurrent.annotation.ThreadSafe
import java.util.*

@ThreadSafe
class ListHelper<E>(
    var list: List<E> = Collections.synchronizedList(ArrayList())
) {
    @Synchronized
    fun putIfAbsent(x: E): Boolean {
        synchronized(list) {
            if (!list.contains(x)) {
                list.plus(x)
                return true
            }
            return false
        }
    }
}