package com.james.io.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringIntegerBaseConversionTest {

    @Test
    public void testConvert() {
        assertEquals("1A7",
                StringIntegerBaseConversion.convert("615", 7, 13));
    }
}
