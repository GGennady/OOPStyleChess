package org.example

import java.util.Scanner

class InputCoordinates {
    private val scanner = Scanner(System.`in`)

    fun input(): Coordinates {
        while (true) {
            println("Please enter coordinates (example: a1)")
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
}