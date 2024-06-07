package com.example.myfirstapplication.lld.projectManagment.module

internal data class BoardList(
    val id: String,
    val name: String,
    val cards: MutableList<Card> = mutableListOf()
)