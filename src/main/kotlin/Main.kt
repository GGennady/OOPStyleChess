package org.example

import org.example.Pieces.Piece

fun main() {
    var board = Board()
    board.setupDefaultPiecePositions()

    var renderer = BoardConsoleRenderer()
    renderer.render(board)

    val piece: Piece? = board.getPiece(coordinates = Coordinates(File.B, 1))
    val avaliableMoveSquares: Set<Coordinates> = piece!!.getAvailableMoveSquares(board)

//    val coordinates = InputCoordinates().input()
//    println("coordinates = $coordinates")

    val a: Int = 123
}