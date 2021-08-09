package com.ondev.recycleviewincompose.data

import kotlin.random.Random

class DataProvider {
    fun provide(max: Int = 100000): List<Person> {
        val resulList = mutableListOf<Person>()
        (0 until max).forEach { _ ->
            resulList.add(Person(name = "Jhon Doe" + Random.nextInt(max)))
        }
        return resulList.toList()
    }
}