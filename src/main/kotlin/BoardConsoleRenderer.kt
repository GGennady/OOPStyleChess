package org.example

class BoardConsoleRenderer {
    fun render(board: Board) {
        for(rank in 8 downTo 1) {
            for(file in File.entries) println(file.toString() + rank.toString())
        }
    }
}