package org.example

import org.example.Pieces.Pawn
import org.example.Pieces.Piece

class Board {
    val pieces = mutableMapOf<Coordinates, Piece>()

    fun setPiece(coordinates: Coordinates, piece: Piece) {
        piece.coordinates = coordinates
        pieces[coordinates] = piece
    }

    fun setupDefaultPiecePositions() {
        for(file: File in File.entries) {
            setPiece(Coordinates(file, 2), Pawn(Color.WHITE, Coordinates(file, 2)))
            setPiece(Coordinates(file, 7), Pawn(Color.BLACK, Coordinates(file, 7)))
        }
    }
    fun isSquareDark(coordinates: Coordinates): Boolean {
        return ((((coordinates.file.ordinal + 1) + coordinates.rank)% 2) == 0)
    }
}