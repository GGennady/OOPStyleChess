package org.example

import org.example.Pieces.Piece

class Game(board: Board) {

    private val renderer = BoardConsoleRenderer()

    fun gameLoop(board: Board) {
        var isWhiteToMove: Boolean = true
        while (true) {
            // render
            renderer.render(board)

            // read input data
            val sourceCoordinates: Coordinates = InputCoordinates().inputPieceCoordinatesForColor(if (isWhiteToMove) Color.WHITE else Color.BLACK , board)

            val piece: Piece? = board.getPiece(sourceCoordinates)
            val availableMoveSquares: Set<Coordinates> = piece!!.getAvailableMoveSquares(board)

            val targetCoordinates: Coordinates = InputCoordinates().inputAvailableSquare(availableMoveSquares)

            // make move
            board.movePiece(sourceCoordinates, targetCoordinates)

            // pass move
            isWhiteToMove =! isWhiteToMove
        }
    }
}