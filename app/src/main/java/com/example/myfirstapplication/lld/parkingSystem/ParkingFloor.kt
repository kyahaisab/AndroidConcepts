package com.example.myfirstapplication.lld.parkingSystem

import com.example.myfirstapplication.lld.parkingSystem.lotType.BikeParkingLot
import com.example.myfirstapplication.lld.parkingSystem.lotType.CarParkingLot
import com.example.myfirstapplication.lld.parkingSystem.lotType.TruckParkingLot

class ParkingFloor(
    val floorNo: Int,
    val carParkingLotList: MutableList<CarParkingLot>,
    val truckParkingLotList: MutableList<TruckParkingLot>,
    val bikeParkingLotList: MutableList<BikeParkingLot>
)