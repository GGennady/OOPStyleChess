package org.example

class BoardConsoleRenderer {

    val ANSI_RESET: String = "\u001B[0m"
    val ANSI_WHITE_PIECE_COLOR: String = "\u001B[97m"
    val ANSI_BLACK_PIECE_COLOR: String = "\u001B[30m"
    val ANSI_WHITE_SQUARE_BACKGROUND: String = "\u001B[47m"
    val ANSI_BLACK_SQUARE_BACKGROUND: String = "\u001B[0;100m"

    fun render(board: Board) {
        for(rank in 8 downTo 1) {
            var line: String = ""
            for(file in File.entries) {
                //println(file.toString() + rank.toString())
                line += getSpriteForEmptySquare(coordinates = Coordinates(file, rank))
            }
            line += ANSI_RESET
            println(line)
        }
    }

    private fun colorizeSprite(sprite: String, pieceColor: Color, isSquareDark: Boolean): String {

        // format(ansi colors) = background color + font color + text

        var result: String = sprite

        if(pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result
        } else result = ANSI_BLACK_PIECE_COLOR + result

        if(isSquareDark) {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result
        } else result = ANSI_BLACK_SQUARE_BACKGROUND + result

        return result
    }

    private fun getSpriteForEmptySquare(coordinates: Coordinates): String {
        return colorizeSprite("   ", Color.WHITE, Board().isSquareDark(coordinates))
    }
}