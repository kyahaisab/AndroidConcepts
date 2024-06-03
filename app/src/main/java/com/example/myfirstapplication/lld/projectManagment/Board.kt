package com.example.myfirstapplication.lld.projectManagment

internal data class Board(
    val id: String,
    val name: String,
    var lists: MutableList<BoardList> = mutableListOf(),
    var members: MutableList<User> = mutableListOf(),
    val url: String,
    var privacy: PRIVACY = PRIVACY.PUBLIC
)