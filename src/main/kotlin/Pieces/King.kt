package org.example.Pieces

import org.example.Color
import org.example.Coordinates

class King(color: Color, coordinates: Coordinates): Piece(color, coordinates) {
    protected override fun getPieceMoves(): Set<CoordinatesShift> {
        return emptySet()
    }
}