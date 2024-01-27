package org.example

class Board {
    val pieces = mutableMapOf<Coordinates, Piece>()

    fun setPiece(piece: Piece, coordinates: Coordinates) {
        piece.coordinates = coordinates
        pieces[coordinates] = piece
    }

    fun setupDefaultPiecePositions() {

    }
}