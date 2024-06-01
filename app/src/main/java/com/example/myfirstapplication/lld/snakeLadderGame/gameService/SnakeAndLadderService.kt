package com.example.myfirstapplication.lld.snakeLadderGame.gameService

import com.example.myfirstapplication.lld.snakeLadderGame.SnakeLadderBoard
import com.example.myfirstapplication.lld.snakeLadderGame.models.Ladder
import com.example.myfirstapplication.lld.snakeLadderGame.models.Player
import com.example.myfirstapplication.lld.snakeLadderGame.models.Snake
import java.util.LinkedList
import java.util.Queue

class SnakeAndLadderService(snakes: List<Snake>, ladders: List<Ladder>, players: List<Player>) {
    private lateinit var snakeLadderBoard: SnakeLadderBoard
    private var numberOfPlayers: Int = DEFAULT_NUMBER_OF_PLAYERS
    private var playerRotor: Queue<String> = LinkedList()
    private var numberOfDice: Int = DEFAULT_NUMBER_OF_DICE

    init {
        setSnakeLadderBoard(snakes, ladders, players)
    }

    fun startGame() {
        do {
            playerRotor.poll()?.let {
                playNextMove(it)
                if (hasPlayerReachedEnd(it)) {
                    println("Wow player with ID $it won the game")
                } else playerRotor.add(it)
            }
        } while (!isGameCompleted())
    }

    private fun playNextMove(playerId: String) {
        val diceNumber = getNumberOnDice()

        val currentPosition = snakeLadderBoard.playerPiece[playerId]
        val newPosition: Int =
            findNewPositionThroughSnakesAndLadders(currentPosition!! + diceNumber)!!
        if (newPosition > snakeLadderBoard.boardSize)
            snakeLadderBoard.playerPiece[playerId] = currentPosition
        else snakeLadderBoard.playerPiece[playerId] = newPosition
        println("Player $playerId rolled dice: $diceNumber, so new position is $newPosition")
    }

    private fun getNumberOnDice(): Int {
        var totalNumbersOnDice: Int = 0
        for (roll in 1..numberOfDice) {
            totalNumbersOnDice += DiceService.rollDice()
        }
        return totalNumbersOnDice
    }

    private fun findNewPositionThroughSnakesAndLadders(
        expectedNewPosition: Int
    ): Int? {
        return if (snakeLadderBoard.snakes.contains(expectedNewPosition)) {
            snakeLadderBoard.snakes[expectedNewPosition]
        } else if (snakeLadderBoard.ladders.contains(expectedNewPosition)) {
            snakeLadderBoard.ladders[expectedNewPosition]
        } else {
            expectedNewPosition
        }

    }

    private fun setSnakeLadderBoard(
        snakes: List<Snake>,
        ladders: List<Ladder>,
        players: List<Player>
    ) {
        snakeLadderBoard = SnakeLadderBoard(DEFAULT_BOARD_SIZE)
        setSnakes(snakes)
        setLadders(ladders)
        setPlayer(players)
    }

    private fun setLadders(ladders: List<Ladder>) {
        snakeLadderBoard.ladders = HashMap()
        for (ladder in ladders) {
            snakeLadderBoard.ladders[ladder.start] = ladder.end
        }
    }

    private fun setSnakes(snakes: List<Snake>) {
        snakeLadderBoard.snakes = HashMap()
        for (snake in snakes) {
            snakeLadderBoard.snakes[snake.start] = snake.end
        }
    }

    private fun setPlayer(players: List<Player>) {
        this.numberOfPlayers = players.size
        snakeLadderBoard.playerPiece = HashMap()
        for (player in players) {
            snakeLadderBoard.playerPiece[player.id] = 0
            playerRotor.add(player.id)
        }
    }

    private fun setNumberOfDice(numberOfDice: Int) {
        this.numberOfDice = numberOfDice
    }

    companion object {
        const val DEFAULT_BOARD_SIZE = 100
        const val DEFAULT_NUMBER_OF_PLAYERS = 2
        const val DEFAULT_NUMBER_OF_DICE = 1
    }

    private fun isGameCompleted(): Boolean {
        return playerRotor.size != numberOfPlayers
    }

    private fun hasPlayerReachedEnd(playerId: String): Boolean {
        return snakeLadderBoard.playerPiece[playerId] == snakeLadderBoard.boardSize
    }
}