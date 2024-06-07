package com.example.myfirstapplication.lld.parkingSystem

import com.example.myfirstapplication.lld.parkingSystem.enums.Color
import com.example.myfirstapplication.lld.parkingSystem.enums.VehicleType
import com.example.myfirstapplication.lld.parkingSystem.lotType.BikeParkingLot
import com.example.myfirstapplication.lld.parkingSystem.lotType.CarParkingLot
import com.example.myfirstapplication.lld.parkingSystem.lotType.TruckParkingLot
import com.example.myfirstapplication.lld.parkingSystem.models.Ticket
import com.example.myfirstapplication.lld.parkingSystem.models.Vehicle
import com.example.myfirstapplication.lld.parkingSystem.models.VehicleParkingInfo

internal class ParkingService {
    private var parking: MutableList<ParkingFloor> = mutableListOf()

    /**
     * Creates the entire parking system with the specified number of floors and parking lots for different vehicle types.
     *
     * @param noOfFloors The number of floors in the parking system.
     * @param numberOfCarParkingLot The number of car parking lots per floor. Defaults to DEFAULT_CAR_PARKING_LOT.
     * @param numberOfBikeParkingLot The number of bike parking lots per floor. Defaults to DEFAULT_BIKE_PARKING_LOT.
     * @param numberOfTruckParkingLot The number of truck parking lots per floor. Defaults to DEFAULT_TRUCK_PARKING_LOT.
     */
    fun createParkingSystem(
        noOfFloors: Int,
        numberOfCarParkingLot: Int = DEFAULT_CAR_PARKING_LOT,
        numberOfBikeParkingLot: Int = DEFAULT_BIKE_PARKING_LOT,
        numberOfTruckParkingLot: Int = DEFAULT_TRUCK_PARKING_LOT
    ) {
        for (floor in 0..<noOfFloors) {
            addParkingFloor(numberOfCarParkingLot, numberOfBikeParkingLot, numberOfTruckParkingLot)
        }
    }

    /**
     * Adds a parking floor to the parking system with the specified number of parking lots for different vehicle types.
     *
     * @param numberOfCarParkingLot The number of car parking lots on this floor. Defaults to DEFAULT_CAR_PARKING_LOT.
     * @param numberOfBikeParkingLot The number of bike parking lots on this floor. Defaults to DEFAULT_BIKE_PARKING_LOT.
     * @param numberOfTruckParkingLot The number of truck parking lots on this floor. Defaults to DEFAULT_TRUCK_PARKING_LOT.
     */
    fun addParkingFloor(
        numberOfCarParkingLot: Int = DEFAULT_CAR_PARKING_LOT,
        numberOfBikeParkingLot: Int = DEFAULT_BIKE_PARKING_LOT,
        numberOfTruckParkingLot: Int = DEFAULT_TRUCK_PARKING_LOT
    ) {
        val carParkingLotsInFloor = addCarParkingLotInFloor(numberOfCarParkingLot)
        val bikeParkingLotsInFloor = addBikeParkingLotInFloor(numberOfBikeParkingLot)
        val truckParkingLotsInFloor = addTruckParkingLotInFloor(numberOfTruckParkingLot)
        val currentFloorToBeAdded = parking.size

        parking.add(
            ParkingFloor(
                currentFloorToBeAdded,
                carParkingLotsInFloor,
                truckParkingLotsInFloor,
                bikeParkingLotsInFloor
            )
        )
    }

    /**
     * Parks a car in the parking facility.
     *
     * @param registrationNumber The registration number of the car to be parked.
     * @param color The color of the car to be parked.
     * @return VehicleParkingInfo The parking information of the parked vehicle, or null if no space is available.
     *
     * @author Shiv Sagar Singh
     * @note do the same code for bike and truck parking
     */
    fun parkCar(registrationNumber: String, color: Color): VehicleParkingInfo? {
        val emptySpaceForCar = findEmptyFloorForCarParking()
        val emptyFloorNumber = emptySpaceForCar.first
        val emptyLotNumber = emptySpaceForCar.second

        if (emptyLotNumber == -1 || emptyFloorNumber == -1) return null

        val carVehicle = Vehicle(registrationNumber, color, VehicleType.CAR)
        val carTicket = Ticket(floorNo = emptyFloorNumber, lotNo = emptyLotNumber)
        val parkingInfo = VehicleParkingInfo(carVehicle, carTicket)

        parking[emptyFloorNumber].carParkingLotList[emptyLotNumber].vehicleParkingSpace.add(
            parkingInfo
        )
        return parkingInfo
    }

    fun unParkCar(vehicleParkingInfo: VehicleParkingInfo): Boolean {
        val requiredFloor = vehicleParkingInfo.vehicleTicket.floorNo
        val requiredSlot = vehicleParkingInfo.vehicleTicket.lotNo
        var isCarPresent = false;
        for (car in parking[requiredFloor].carParkingLotList[requiredSlot].vehicleParkingSpace) {
            if (car.vehicleTicket.parkingLotID == vehicleParkingInfo.vehicleTicket.parkingLotID) {
                parking[requiredFloor].carParkingLotList[requiredSlot].vehicleParkingSpace.remove(
                    vehicleParkingInfo
                )
                isCarPresent = true
                break
            }
        }
        return isCarPresent
    }

    fun showAvailableParkingSpaceInAllFloors() {
        for (floorNumber in 0..<parking.size) {
            var totalCarParkingSpaceInCurrentFloor = 0
            var totalBikeParkingSpaceInCurrentFloor = 0
            var totalTruckParkingSpaceInCurrentFloor = 0

            for (currentLot in 0..<parking[floorNumber].carParkingLotList.size) {
                totalCarParkingSpaceInCurrentFloor += DEFAULT_CAR_PARKING_SPACE_IN_LOT - parking[floorNumber].carParkingLotList[currentLot].vehicleParkingSpace.size
            }
            for (currentLot in 0..<parking[floorNumber].bikeParkingLotList.size) {
                totalBikeParkingSpaceInCurrentFloor += DEFAULT_BIKE_PARKING_SPACE_IN_LOT - parking[floorNumber].bikeParkingLotList[currentLot].vehicleParkingSpace.size
            }
            for (currentLot in 0..<parking[floorNumber].truckParkingLotList.size) {
                totalTruckParkingSpaceInCurrentFloor += DEFAULT_TRUCK_PARKING_SPACE_IN_LOT - parking[floorNumber].truckParkingLotList[currentLot].vehicleParkingSpace.size
            }
            println("Floor No: $floorNumber")
            println("Bike parking space in this floor: $totalBikeParkingSpaceInCurrentFloor")
            println("Car parking space in this floor: $totalCarParkingSpaceInCurrentFloor")
            println("Truck parking space in this floor: $totalTruckParkingSpaceInCurrentFloor")
        }
    }

    // ************************ Private function Tasks ************************

    private fun findEmptyFloorForCarParking(): Pair<Int, Int> {
        var floorNumber: Int = -1
        var carParkingLotNumber: Int = -1
        var isSpaceFound: Boolean = false
        for (floor in 0..<parking.size) {
            for (carParkingLot in 0..<parking[floor].carParkingLotList.size) {
                if (parking[floor].carParkingLotList[carParkingLot].vehicleParkingSpace.size < DEFAULT_CAR_PARKING_SPACE_IN_LOT) {
                    floorNumber = parking[floor].floorNo
                    carParkingLotNumber = parking[floor].carParkingLotList[carParkingLot].lotNumber
                    isSpaceFound = true
                    break
                }
            }
            if (isSpaceFound) break
        }
        return Pair(floorNumber, carParkingLotNumber)
    }

    private fun addBikeParkingLotInFloor(noOfLots: Int): MutableList<BikeParkingLot> {
        val bikeParkingLotList = mutableListOf<BikeParkingLot>()
        for (lot in 0..<noOfLots) {
            bikeParkingLotList.add(BikeParkingLot(lot, DEFAULT_BIKE_PARKING_SPACE_IN_LOT))
        }
        return bikeParkingLotList
    }

    private fun addCarParkingLotInFloor(noOfLots: Int): MutableList<CarParkingLot> {
        val carParkingLotList = mutableListOf<CarParkingLot>()
        for (lot in 0..<noOfLots) {
            carParkingLotList.add(CarParkingLot(lot, DEFAULT_CAR_PARKING_SPACE_IN_LOT))
        }
        return carParkingLotList
    }

    private fun addTruckParkingLotInFloor(noOfLots: Int): MutableList<TruckParkingLot> {
        val truckParkingLotList = mutableListOf<TruckParkingLot>()
        for (lot in 0..<noOfLots) {
            truckParkingLotList.add(TruckParkingLot(lot, DEFAULT_TRUCK_PARKING_SPACE_IN_LOT))
        }
        return truckParkingLotList
    }


    companion object {
        const val DEFAULT_CAR_PARKING_SPACE_IN_LOT = 15
        const val DEFAULT_BIKE_PARKING_SPACE_IN_LOT = 20
        const val DEFAULT_TRUCK_PARKING_SPACE_IN_LOT = 10

        const val DEFAULT_CAR_PARKING_LOT = 2
        const val DEFAULT_BIKE_PARKING_LOT = 4
        const val DEFAULT_TRUCK_PARKING_LOT = 1
    }
}