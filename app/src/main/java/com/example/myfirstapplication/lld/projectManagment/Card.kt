package com.example.myfirstapplication.lld.projectManagment

internal data class Card(
    val id: String,
    val name: String,
    var description: String,
    var assignedTo: User? = null,
    var priority: PRIORITY = PRIORITY.LOW
)