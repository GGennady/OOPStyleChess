package org.example

class Game {

    val renderer = BoardConsoleRenderer()

    fun gameLoop(board: Board) {
        var isWhiteToMove: Boolean = true
        while (true) {
            // render
            renderer.render(board)
            // read input data
            // make move
            // pass move
            isWhiteToMove =! isWhiteToMove
        }
    }
}