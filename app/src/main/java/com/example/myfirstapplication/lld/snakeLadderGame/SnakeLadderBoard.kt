package com.example.myfirstapplication.lld.snakeLadderGame

class SnakeLadderBoard(val boardSize: Int) {
    // <PlayerId, currentPosition>
    lateinit var playerPiece: HashMap<String, Int>

    // <Head, Tail>
    lateinit var snakes: HashMap<Int, Int>

    // <Start, End>
    lateinit var ladders: HashMap<Int, Int>
}