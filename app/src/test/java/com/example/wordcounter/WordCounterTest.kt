package com.example.wordcounter

import org.junit.Assert.assertEquals
import org.junit.Test

class WordCounterTest {

    @Test
    fun countWords_withText_returnsCorrectWordCount() {
        val text = "Hello, world! This is a sentence."
        val expectedCount = 6
        assertEquals(expectedCount, WordCounter.countWords(text))
    }

    @Test
    fun countWords_withEmptyString_returnsZero() {
        val text = ""
        val expectedCount = 0
        assertEquals(expectedCount, WordCounter.countWords(text))
    }

    @Test
    fun countWords_withMultipleSpaces_returnsCorrectWordCount() {
        val text = "Hello,   world!  This   is a    sentence."
        val expectedCount = 6
        assertEquals(expectedCount, WordCounter.countWords(text))
    }

    @Test
    fun countCharacters_withText_returnsCharacterCountExcludingWhitespace() {
        val text = "Hello, world!"
        val expectedCount = 13
        assertEquals(expectedCount, WordCounter.countCharacters(text))
    }

    @Test
    fun countCharacters_withEmptyString_returnsZero() {
        val text = ""
        val expectedCount = 0
        assertEquals(expectedCount, WordCounter.countCharacters(text))
    }
}