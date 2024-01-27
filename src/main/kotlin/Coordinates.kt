package org.example

class Coordinates (val file: File, val rank: Int) {

    // file = horizontal, rank = vertical

    // Methods "equals" and "hashCode" for to use own class as a hashmap key

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Coordinates

        if (file != other.file) return false
        if (rank != other.rank) return false

        return true
    }

    override fun hashCode(): Int {
        var result = file.hashCode()
        result = 31 * result + rank
        return result
    }
}