package org.example

import org.example.Pieces.Piece

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
                val coordinates = Coordinates(file, rank)
                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates)
                } else line += getPieceSprite(board.getPiece(coordinates)!!)
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
            result = ANSI_BLACK_SQUARE_BACKGROUND + result
        } else result = ANSI_WHITE_SQUARE_BACKGROUND + result

        return result
    }

    private fun getSpriteForEmptySquare(coordinates: Coordinates): String {
        return colorizeSprite("   ", Color.WHITE, Board().isSquareDark(coordinates))
    }

    private fun selectUnicodeSpriteForPiece(piece: Piece): String {
        when(piece::class.simpleName) {
            "Pawn" -> return "♟"
            "Knight" -> return "♞"
            "Bishop" -> return "♝"
            "Rook" -> return "♜"
            "Queen" -> return "♛"
            "King" -> return "♚"
        }
        return ""
    }

    private fun getPieceSprite(piece: Piece): String {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board().isSquareDark(piece.coordinates))
    }
}