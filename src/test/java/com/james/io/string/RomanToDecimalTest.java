package com.james.io.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToDecimalTest {

    @Test
    public void romanToDecimalException() {
        String s = "LIX";
        assertEquals(59, RomanToDecimal.romanToDecimal(s));
    }

    @Test
    public void romanToDecimalNoException1() {
        String s = "LVIIII";
        assertEquals(59, RomanToDecimal.romanToDecimal(s));
    }

    @Test
    public void romanToDecimalNoException2() {
        String s = "XXXXXIIIIIIIII";
        assertEquals(59, RomanToDecimal.romanToDecimal(s));
    }


}