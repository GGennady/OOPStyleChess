package org.example

import org.example.Pieces.*

class Board {
    val pieces = mutableMapOf<Coordinates, Piece>()

    fun setPiece(coordinates: Coordinates, piece: Piece) {
        piece.coordinates = coordinates
        pieces[coordinates] = piece
    }

    fun isSquareEmpty(coordinates: Coordinates): Boolean {
        return !pieces.containsKey(coordinates)
    }

    fun getPiece(coordinates: Coordinates): Piece? {
        return pieces.get(coordinates)
    }

    fun setupDefaultPiecePositions() {
        for(file: File in File.entries) {
            setPiece(Coordinates(file, 2), Pawn(Color.WHITE, Coordinates(file, 2)))
            setPiece(Coordinates(file, 7), Pawn(Color.BLACK, Coordinates(file, 7)))
        }
        setPiece(Coordinates(File.A, 1), Rook(Color.WHITE, Coordinates(File.A, 1)))
        setPiece(Coordinates(File.H, 1), Rook(Color.WHITE, Coordinates(File.H, 1)))
        setPiece(Coordinates(File.A, 8), Rook(Color.BLACK, Coordinates(File.A, 8)))
        setPiece(Coordinates(File.H, 8), Rook(Color.BLACK, Coordinates(File.H, 8)))

        setPiece(Coordinates(File.B, 1), Knight(Color.WHITE, Coordinates(File.B, 1)))
        setPiece(Coordinates(File.G, 1), Knight(Color.WHITE, Coordinates(File.G, 1)))
        setPiece(Coordinates(File.B, 8), Knight(Color.BLACK, Coordinates(File.B, 8)))
        setPiece(Coordinates(File.G, 8), Knight(Color.BLACK, Coordinates(File.G, 8)))

        setPiece(Coordinates(File.C, 1), Bishop(Color.WHITE, Coordinates(File.C, 1)))
        setPiece(Coordinates(File.F, 1), Bishop(Color.WHITE, Coordinates(File.F, 1)))
        setPiece(Coordinates(File.C, 8), Bishop(Color.BLACK, Coordinates(File.C, 8)))
        setPiece(Coordinates(File.F, 8), Bishop(Color.BLACK, Coordinates(File.F, 8)))

        setPiece(Coordinates(File.D, 1), Queen(Color.WHITE, Coordinates(File.D, 1)))
        setPiece(Coordinates(File.D, 8), Queen(Color.BLACK, Coordinates(File.D, 8)))

        setPiece(Coordinates(File.E, 1), King(Color.WHITE, Coordinates(File.E, 1)))
        setPiece(Coordinates(File.E, 8), King(Color.BLACK, Coordinates(File.E, 8)))
    }
    fun isSquareDark(coordinates: Coordinates): Boolean {
        return ((((coordinates.file.ordinal + 1) + coordinates.rank)% 2) == 0)
    }
}