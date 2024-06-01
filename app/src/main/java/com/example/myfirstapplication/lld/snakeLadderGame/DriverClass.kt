package com.example.myfirstapplication.lld.snakeLadderGame

import com.example.myfirstapplication.lld.snakeLadderGame.gameService.SnakeAndLadderService
import com.example.myfirstapplication.lld.snakeLadderGame.models.Ladder
import com.example.myfirstapplication.lld.snakeLadderGame.models.Player
import com.example.myfirstapplication.lld.snakeLadderGame.models.Snake

fun main() {
    val snakeList = listOf(Snake(15, 6), Snake(23, 11), Snake(44, 39), Snake(78, 57), Snake(93, 28))
    val ladderList = listOf(Ladder(19, 36), Ladder(66, 89), Ladder(45, 78))
    val playerList = listOf(Player("Somu"), Player("Himanshi"))

    val snakeAndLadderService = SnakeAndLadderService(snakeList, ladderList, playerList).run {
        startGame()
    }
}