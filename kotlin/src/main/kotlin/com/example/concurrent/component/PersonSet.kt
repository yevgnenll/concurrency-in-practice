package com.example.concurrent.component

class PersonSet(
    private val mySet: HashSet<Person>
) {
    @Synchronized
    fun addPerson(p: Person) {
        mySet.add(p)
    }

    @Synchronized
    fun containsPerson(p: Person): Boolean {
        return mySet.contains(p)
    }
}