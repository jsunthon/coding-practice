package com.james.io.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringIntegerBaseConversionTest {

  @Test
  public void testConvert() {
    assertEquals("1A7",
        StringIntegerBaseConversion.convert("615", 7, 13));
  }
}
