package com.james.io.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterConvertStrIntTest {

    @Test
    public void testDecodeInt() {
        String s = "123";
        assertEquals(123, InterConvertStrInt.decodeInt(s));
    }

    @Test
    public void testDecodeNegativeInt() {
        String s = "-123";
        assertEquals(-123, InterConvertStrInt.decodeInt(s));
    }

    @Test
    public void testEncodeStr() {
        int i = 123;
        assertEquals("123", InterConvertStrInt.encodeStr(i));
    }

    @Test
    public void testEncodeNegativeStr() {
        int i = -123;
        assertEquals("-123", InterConvertStrInt.encodeStr(i));
    }
}
