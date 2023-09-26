package com.example.wordcounter

class WordCounter {
    companion object {
        fun countWords(text: String): Int {
            // Split the text into words using spaces, commas, and full stops as delimiters
            val words = text.split("[\\s,\\.]".toRegex())
                .filter { it.isNotBlank() } // Filter out empty strings
            return words.size
        }

        fun countCharacters(text: String): Int {
            // Implement character counting logic here
            return text.length
        }
    }
}
