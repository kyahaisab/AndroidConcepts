package com.example.myfirstapplication.lld.snakeLadderGame.gameService

import kotlin.random.Random

object DiceService {
    fun rollDice(): Int {
        Thread.sleep(100)
        return Random.nextInt(1, 6)
    }
}