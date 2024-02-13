package org.example

import org.example.Pieces.Piece
import java.util.Scanner

class InputCoordinates {
    private val scanner = Scanner(System.`in`)

    private fun input(): Coordinates {
        while (true) {
            // println("Please enter coordinates (example: a1)")
            val line = scanner.nextLine()

            if (line.length != 2) {
                println("Invalid format")
                continue
            }

            val fileChar: Char = line[0]
            val rankChar: Char = line[1]

            if (!Character.isLetter(fileChar)) {
                println("Invalid format")
                continue
            }

            if (!Character.isDigit(rankChar)) {
                println("Invalid format")
                continue
            }

            val rank = Character.getNumericValue(rankChar)
            if (rank < 1 || rank > 8) {
                println("Invalid format")
                continue
            }
            val file = File.fromChar(fileChar)
            if (file == null) {
                println("Invalid format")
                continue
            }
            return Coordinates(file, rank)
        }
    }

    fun inputPieceCoordinatesForColor(color: Color, board: Board): Coordinates {
        while (true) {
            println("Enter coordinates for a piece to move.")
            val coordinates: Coordinates = input()

            if(board.isSquareEmpty(coordinates)) {
                println("Empty square")
                continue
            }
            val piece: Piece? = board.getPiece(coordinates)
            if (piece?.color != color) {
                println("Wrong color")
                continue
            }

            val availableMoveSquares: Set<Coordinates> = piece.getAvailableMoveSquares(board)
            if (availableMoveSquares.isEmpty()) {
                println("Blocked piece")
                continue
            }
            return coordinates
        }
    }

    fun inputAvailableSquare(coordinates: Set<Coordinates>): Coordinates {
        while (true) {
            println("Enter your move for selected piece")
            val input: Coordinates = input()

            if (!coordinates.contains(input)) {
                println("Non-available square")
                continue
            }
            return input
        }
    }
}