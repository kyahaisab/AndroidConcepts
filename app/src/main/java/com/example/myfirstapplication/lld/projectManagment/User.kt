package com.example.myfirstapplication.lld.projectManagment

import java.util.UUID

internal data class User(
    val userId: String = UUID.randomUUID().toString(),
    val email: String,
    val name: String
)