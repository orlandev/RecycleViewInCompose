package com.ondev.recycleviewincompose.data

data class Person(
    var name: String = "John Doe",
    val phone: String = "+53 54074127",
    val age: Int = 32,
    val workplace: String = "Inmersoft",
) {
    fun getAvatarUrl(): String {
        return "https://robohash.org/${name}"
    }
}
