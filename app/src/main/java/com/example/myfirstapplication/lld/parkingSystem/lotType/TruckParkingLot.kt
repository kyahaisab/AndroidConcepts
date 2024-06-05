package com.example.myfirstapplication.lld.parkingSystem.lotType

import com.example.myfirstapplication.lld.parkingSystem.enums.VehicleType
import com.example.myfirstapplication.lld.parkingSystem.models.VehicleParkingInfo

class TruckParkingLot(
    lotNumber: Int,
    parkingCapacity: Int,
    val vehicleParkingSpace: MutableList<VehicleParkingInfo> = mutableListOf()
) : ParkingLot(lotNumber, VehicleType.TRUCK, parkingCapacity)