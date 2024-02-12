package org.example

enum class File {
    A, B, C, D, E, F, G, H;

    companion object {
        fun fromChar(c: Char): File? {
            return try {
                File.valueOf(c.toString().uppercase())
            } catch (e: Exception) {
                null
            }
        }
    }
}