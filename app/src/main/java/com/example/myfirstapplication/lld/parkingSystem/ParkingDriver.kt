package com.example.myfirstapplication.lld.parkingSystem

import com.example.myfirstapplication.lld.parkingSystem.enums.Color

fun main() {
    val parkingService = ParkingService()
    parkingService.run {
        createParkingSystem(10)
        //showAvailableParkingSpaceInAllFloors()
        val mercedesCar = parkCar("UP70 2312", Color.RED)
        val astonMartinCar = parkCar("MN23 4520", Color.GREY)
        if (astonMartinCar != null) {
            println("${astonMartinCar.vehicleTicket.floorNo}")
        }
        println("$mercedesCar")
        showAvailableParkingSpaceInAllFloors()
        if (mercedesCar != null) {
            unParkCar(mercedesCar)
        }
    }
}