package com.james.io.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    @Test
    public void isPalindrome1() {
        String s = "A man, a plan, a canal, Panama.";
        assertTrue(Palindrome.isPalindrome(s));
    }

    @Test
    public void isPalindrome7() {
        String s = "Able was I, ere I saw Elba!";
        assertTrue(Palindrome.isPalindrome(s));
    }

    @Test
    public void isPalindrome2() {
        String s = "!,@ab";
        assertFalse(Palindrome.isPalindrome(s));
    }

    @Test
    public void isPalindrome3() {
        String s = "abba";
        assertTrue(Palindrome.isPalindrome(s));
    }

    @Test
    public void isPalindrome4() {
        String s = "a!!cc,a";
        assertTrue(Palindrome.isPalindrome(s));
    }

    @Test
    public void isPalindrome5() {
        String s = "a!!c,a";
        assertTrue(Palindrome.isPalindrome(s));
    }

    @Test
    public void isPalindrome() {
        String s = "Ray a Ray";
        assertFalse(Palindrome.isPalindrome(s));
    }
}