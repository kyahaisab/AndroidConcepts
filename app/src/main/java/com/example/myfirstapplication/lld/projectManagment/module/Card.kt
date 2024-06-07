package com.example.myfirstapplication.lld.projectManagment.module

import com.example.myfirstapplication.lld.projectManagment.enums.PRIORITY

internal data class Card(
    val id: String,
    val name: String,
    var description: String,
    var assignedTo: User? = null,
    var priority: PRIORITY = PRIORITY.LOW
)