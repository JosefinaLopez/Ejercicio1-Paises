package com.example.ejercicio1

data class Pais (
    val name:Name,
    val capital:List<String>,
    val flags:Flag)

data class Flag(
    val png:String,
    val alt:String
)
data class Name(
    val common:String
)

lateinit var listPaises:List<Pais>
