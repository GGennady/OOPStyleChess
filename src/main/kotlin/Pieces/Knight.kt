package org.example.Pieces

import org.example.Color
import org.example.Coordinates
import java.util.*

class Knight(color: Color, coordinates: Coordinates): Piece(color, coordinates) {
    override protected fun getPieceMoves(): Set<CoordinatesShift> {
        return setOf(
            CoordinatesShift(1, 2),
            CoordinatesShift(2, 1),

            CoordinatesShift(2, -1),
            CoordinatesShift(1, -2),

            CoordinatesShift(-2, -1),
            CoordinatesShift(-1, -2),

            CoordinatesShift(-2, 1),
            CoordinatesShift(-1, 2)
        )
    }
}