package com.example.myfirstapplication.di

import kotlin.concurrent.thread

class AstonMartinCar {
    // We are manually creating objects
    private var wheels: AlloyWheels = AlloyWheels()
    private var engine: EngineGT49 = EngineGT49()

    fun drivingCar() {
        engine.startEngine()
        wheels.releaseBreaks()
    }

    /*
    Note:
    1. Car class is not testable, bcz it creates engine and wheel objects inside, which may have other dependencies
    2. Code is not extensible, say we want to change engine, that's not possible in this case
    3. Single responsibility is violates, as car class is doing driving as well, its not car job but of driver
    4. Lifetime of object (Resuability), when our car class will destroy then our engine class will destroy, also we cannot use this
       engine in other car.
     */
}

// There we are providing wheels and engine, this is correct way
// DI: All required objects will be provided from outside and need not to prepare by itself, this is called constructor injection
class LamborghiniCar(private val alloyWheels: AlloyWheels, private val engineGT49: Engine) {
    fun drivingCar() {
        (engineGT49 as EngineGT49).startEngine()
        alloyWheels.releaseBreaks()
    }
}

// This is to demonstrate field injection
class MaserratiCar {
    public lateinit var engine: Engine

    fun drivingCar() {
        (engine as EngineGT49).startEngine()
    }
}

class AlloyWheels {
    fun releaseBreaks() {
        println("Rolling...")
    }
}

class EngineGT49 : Engine {
    fun startEngine() {
        thread(start = true, isDaemon = true) {
            println("Spark initiated")
            Thread.sleep(1000)
            println("Engine Started")
        }.join()
    }
}

fun main() {
    val astonMartinCar = AstonMartinCar().also {
        it.drivingCar()
    }
    // This is constructor injection
    val lamborghiniCar = LamborghiniCar(AlloyWheels(), EngineGT49()).let {
        it.drivingCar()
        it
    }

    val MaseratiCar = MaserratiCar().run {
        engine = EngineGT49() // This is called field injection
        this
    }
    MaseratiCar.drivingCar()
}

interface Engine