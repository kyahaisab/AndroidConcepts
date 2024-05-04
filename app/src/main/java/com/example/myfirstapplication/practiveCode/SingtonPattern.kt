package com.example.myfirstapplication.practiveCode

class SingletonExperiment private constructor() {

    companion object {
        private var instance: SingletonExperiment? = null

        // Now this function is synchronised, i.e if two thread simultaneously try to access it, it will give same instance
        @Synchronized
        fun getInstance(): SingletonExperiment {
            if (instance == null) instance = SingletonExperiment()
            return instance as SingletonExperiment
        }
    }
}

//Same as above and thread safe as well
object Manager {
    init {
        println("New singleton")
    }
}

fun main() {
    // Will through error as its constructor is private
    //val single1= SingletonExperiment()


    val single3 = SingletonExperiment.getInstance()
    val single4 = SingletonExperiment.getInstance()

    println(single3)
    println(single4)

    // Another way to crate singlton
    println(Manager) // first time it call init then it uses same instance
    println(Manager)

}