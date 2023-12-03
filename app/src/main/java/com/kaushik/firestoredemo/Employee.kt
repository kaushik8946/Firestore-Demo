package com.kaushik.firestoredemo

data class Employee(
    var id: String = "",
    val name: String = "",
    val job: String = "",
    val address: Address = Address()
)

data class Address(
    val street: String = "",
    var city: String = ""
)