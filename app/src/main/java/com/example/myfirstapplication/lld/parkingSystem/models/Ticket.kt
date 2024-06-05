package com.example.myfirstapplication.lld.parkingSystem.models

import java.util.UUID

class Ticket(
    val parkingLotID: String = UUID.randomUUID().toString(),
    val floorNo: Int,
    val lotNo: Int
)