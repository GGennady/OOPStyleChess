package org.example.Pieces

import org.example.Board
import org.example.Color
import org.example.Coordinates

abstract class Piece(val color: Color, var coordinates: Coordinates) {
    fun getAvailableMoveSquares(board: Board): Set<Coordinates> {
        val result: MutableSet<Coordinates> = mutableSetOf() // MutableSet

        for(shift: CoordinatesShift in getPieceMoves()) {
            if (coordinates.canShift(shift)) {
                val newCoordinates = coordinates.shift(shift)

                if (isSquareAvailableForMove(newCoordinates, board)) {
                    result.add(newCoordinates)
                }
            }
        }
        return result
    }

    private fun isSquareAvailableForMove(coordinates: Coordinates, board: Board): Boolean {
        return board.isSquareEmpty(coordinates) || board.getPiece(coordinates)!!.color != color
    }

    protected abstract fun getPieceMoves(): Set<CoordinatesShift>
}