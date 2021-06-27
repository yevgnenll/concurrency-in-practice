package com.example.concurrent.component

class ImprovedList<T>(
    private val list: List<T> = ArrayList(),
) : List<T> {

    @Synchronized
    fun putIfAbsent(x: T): Boolean {
        if (!list.contains(x)) {
            list.plus(x)
            return true
        }
        return false
    }

    @get:Synchronized
    override val size: Int
        get() = list.size

    @Synchronized
    override fun contains(element: T): Boolean {
        return list.contains(element)
    }

    @Synchronized
    override fun containsAll(elements: Collection<T>): Boolean {
        return list.containsAll(elements)
    }

    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: T): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: T): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<T> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<T> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<T> {
        TODO("Not yet implemented")
    }
}