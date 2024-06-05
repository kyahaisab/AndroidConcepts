package com.example.myfirstapplication.lld.parkingSystem.lotType

import com.example.myfirstapplication.lld.parkingSystem.enums.VehicleType
import com.example.myfirstapplication.lld.parkingSystem.models.VehicleParkingInfo

class CarParkingLot(
    lotNumber: Int,
    parkingCapacity: Int,
    val vehicleParkingSpace: MutableList<VehicleParkingInfo> = mutableListOf()
) : ParkingLot(lotNumber, VehicleType.CAR, parkingCapacity)
