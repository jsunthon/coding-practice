package com.james.io.string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseSentenceWordsTest {

    @Test
    public void testReverseEmptySentence() {
        char[] input = "".toCharArray();
        ReverseSentenceWords.reverse(input);
        assertArrayEquals(new char[0], input);
    }

    @Test
    public void testReverseSingleLetterSentence() {
        char[] input = "s".toCharArray();
        ReverseSentenceWords.reverse(input);
        assertArrayEquals(new char[]{'s'}, input);
    }

    @Test
    public void testReverseSingleWordSentence() {
        char[] input = "Ana".toCharArray();
        ReverseSentenceWords.reverse(input);
        assertArrayEquals(new char[]{'A', 'n', 'a'}, input);
    }

    @Test
    public void testReverseSentence1() {
        char[] input = "Alice likes Bob".toCharArray();
        ReverseSentenceWords.reverse(input);
        assertArrayEquals(new char[]{'B', 'o', 'b', ' ', 'l', 'i', 'k', 'e', 's', ' ', 'A', 'l', 'i', 'c', 'e'}, input);
    }

    @Test
    public void testReverseSentence2() {
        char[] input = "Alice l".toCharArray();
        ReverseSentenceWords.reverse(input);
        assertArrayEquals(new char[]{'l', ' ', 'A', 'l', 'i', 'c', 'e'}, input);
    }
}
