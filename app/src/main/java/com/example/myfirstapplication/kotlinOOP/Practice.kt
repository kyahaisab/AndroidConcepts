package com.example.myfirstapplication.kotlinOOP

class Managers private constructor() {
    companion object {
        private var INSTANCE: Managers? = null

        @Synchronized
        fun getInstance(): Managers {
            if (INSTANCE == null)
                INSTANCE = Managers()
            return INSTANCE as Managers
        }
    }
}