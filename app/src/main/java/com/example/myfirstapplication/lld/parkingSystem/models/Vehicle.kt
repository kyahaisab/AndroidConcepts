package com.example.myfirstapplication.lld.parkingSystem.models

import com.example.myfirstapplication.lld.parkingSystem.enums.Color
import com.example.myfirstapplication.lld.parkingSystem.enums.VehicleType

class Vehicle(
    val registrationNo: String,
    val color: Color = Color.WHITE,
    val vehicleType: VehicleType = VehicleType.BIKE
)