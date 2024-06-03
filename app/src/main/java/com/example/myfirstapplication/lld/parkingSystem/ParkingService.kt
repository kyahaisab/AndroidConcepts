package com.example.myfirstapplication.lld.parkingSystem

import com.example.myfirstapplication.lld.parkingSystem.enums.Color
import com.example.myfirstapplication.lld.parkingSystem.enums.VehicleType
import com.example.myfirstapplication.lld.parkingSystem.lotType.BikeParkingLot
import com.example.myfirstapplication.lld.parkingSystem.lotType.CarParkingLot
import com.example.myfirstapplication.lld.parkingSystem.lotType.TruckParkingLot
import com.example.myfirstapplication.lld.parkingSystem.models.Ticket
import com.example.myfirstapplication.lld.parkingSystem.models.Vehicle
import com.example.myfirstapplication.lld.parkingSystem.models.VehicleParkingInfo

class ParkingService {
    private var parking: MutableList<ParkingFloor> = mutableListOf()
    private var isParkingSystemCreated: Boolean = false

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


    private fun addParkingFloor(
        numberOfCarParkingLot: Int = DEFAULT_CAR_PARKING_LOT,
        numberOfBikeParkingLot: Int = DEFAULT_BIKE_PARKING_LOT,
        numberOfTruckParkingLot: Int = DEFAULT_TRUCK_PARKING_LOT
    ) {
        val carParkingLotList = addCarParkingLotInFloor(numberOfCarParkingLot)
        val bikeParkingLotList = addBikeParkingLotInFloor(numberOfBikeParkingLot)
        val truckParkingLotList = addTruckParkingLotInFloor(numberOfTruckParkingLot)
        val currentNumberOfFloors = parking.size

        parking.add(
            ParkingFloor(
                currentNumberOfFloors,
                carParkingLotList,
                truckParkingLotList,
                bikeParkingLotList
            )
        )
    }

    fun parkCar(registrationNumber: String, color: Color): VehicleParkingInfo? {
        val emptySpaceForCar = findEmptyFloorForCarParking()
        val emptyFloorNumber = emptySpaceForCar.first
        val emptySlotNumber = emptySpaceForCar.second

        if (emptySlotNumber == -1 || emptyFloorNumber == -1) return null

        val carVehicle = Vehicle(registrationNumber, color, VehicleType.CAR)
        val carTicket = Ticket(floorNo = emptyFloorNumber, slotNo = emptySlotNumber)
        val parkingInfo = VehicleParkingInfo(carVehicle, carTicket)

        parking[emptyFloorNumber].carParkingLotList[emptySlotNumber].vehicleParkingSpace.add(
            parkingInfo
        )
        return parkingInfo
    }

    fun unParkCar(vehicleParkingInfo: VehicleParkingInfo): Boolean {
        val requiredFloor = vehicleParkingInfo.vehicleTicket.floorNo
        val requiredSlot = vehicleParkingInfo.vehicleTicket.slotNo
        var isCarPresent = false;
        for (car in parking[requiredFloor].carParkingLotList[requiredSlot].vehicleParkingSpace) {
            if (car.vehicleTicket.parkingLotID == vehicleParkingInfo.vehicleTicket.parkingLotID) {
                isCarPresent = true
                break
            }
        }
        parking[requiredFloor].carParkingLotList[requiredSlot].vehicleParkingSpace.remove(
            vehicleParkingInfo
        )
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
                    carParkingLotNumber = parking[floor].carParkingLotList[carParkingLot].slotNumber
                    println("floor and slot: $floorNumber and $carParkingLotNumber")
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
        for (slot in 0..<noOfLots) {
            bikeParkingLotList.add(BikeParkingLot(slot, DEFAULT_BIKE_PARKING_SPACE_IN_LOT))
        }
        return bikeParkingLotList
    }

    private fun addCarParkingLotInFloor(noOfLots: Int): MutableList<CarParkingLot> {
        val carParkingLotList = mutableListOf<CarParkingLot>()
        for (slot in 0..<noOfLots) {
            carParkingLotList.add(CarParkingLot(slot, DEFAULT_CAR_PARKING_SPACE_IN_LOT))
        }
        return carParkingLotList
    }

    private fun addTruckParkingLotInFloor(noOfLots: Int): MutableList<TruckParkingLot> {
        val truckParkingLotList = mutableListOf<TruckParkingLot>()
        for (slot in 0..<noOfLots) {
            truckParkingLotList.add(TruckParkingLot(slot, DEFAULT_TRUCK_PARKING_SPACE_IN_LOT))
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