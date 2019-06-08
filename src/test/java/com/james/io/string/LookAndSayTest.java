package com.james.io.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LookAndSayTest {

    @Test
    public void lookAndSayOne() {
        assertEquals("1", LookAndSay.lookAndSay(1));
    }

    @Test
    public void lookAndSayTwo() {
        assertEquals("11", LookAndSay.lookAndSay(2));
    }

    @Test
    public void lookAndSaySeven() {
        assertEquals("13112221", LookAndSay.lookAndSay(7));
    }
}