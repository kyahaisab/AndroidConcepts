package com.example.myfirstapplication.lld.parkingSystem.lotType

import com.example.myfirstapplication.lld.parkingSystem.enums.VehicleType
import com.example.myfirstapplication.lld.parkingSystem.models.VehicleParkingInfo

class CarParkingLot(
    slotNumber: Int,
    parkingCapacity: Int,
    val vehicleParkingSpace: MutableList<VehicleParkingInfo> = mutableListOf()
) : ParkingLot(slotNumber, VehicleType.CAR, parkingCapacity)
