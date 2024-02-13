package org.example

import org.example.Pieces.Piece

fun main() {
    val board = Board()
    board.setupDefaultPiecePositions()

//    val renderer = BoardConsoleRenderer()
//    renderer.render(board)

//    val piece: Piece? = board.getPiece(coordinates = Coordinates(File.B, 1))
//    val availableMoveSquares: Set<Coordinates> = piece!!.getAvailableMoveSquares(board)

//    val coordinates = InputCoordinates().input()
//    println("coordinates = $coordinates")

//    val coordinates: Coordinates = InputCoordinates().inputPieceCoordinatesForColor(Color.WHITE, board)
//    println(coordinates)
    val game = Game(board).also {
        it.gameLoop(board)
    }

    val a: Int = 123
}