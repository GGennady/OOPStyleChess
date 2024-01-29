package org.example

fun main() {
    var board = Board()
    board.setupDefaultPiecePositions()

    var renderer = BoardConsoleRenderer()
    renderer.render(board)
    val a: Int = 123
}