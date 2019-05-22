package com.james.io.stackandqueue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RpnSumTest {

    @Test
    public void testSum1() {
        String expr = "3,4,+,2,x,1,+";
        int expected = ((3 + 4) * 2) + 1;
        assertEquals(15, new RpnSum().sum(expr));
    }

    @Test
    public void testSum2() {
        String expr = "1,1,+,-2,x";
        int expected = (1 + 1) * -2;
        assertEquals(expected, new RpnSum().sum(expr));
    }

    @Test
    public void testSum3() {
        String expr = "-641,6,/,28,/";
        int expected = (-641 / 6) / 28;
        assertEquals(expected, new RpnSum().sum(expr));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMalformedRpn() {
        String expr = "-641,6,@,1,/";
        new RpnSum().sum(expr);
    }
}
