package com.james.io.string;

import static com.james.io.string.SpreadsheetColumnEncoding.decode;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpreadsheetColumnEncodingTest {

  @Test
  public void decode1() {
    String s = "AA";
    int expectedRes = 1 * (int) Math.pow(26, 1) + 1 * (int) Math.pow(26, 0);
    assertEquals(expectedRes, decode(s));
  }

  @Test
  public void decode2() {
    String s = "ZZ";
    int expectedRes = 26 * (int) Math.pow(26, 1) + 26 * (int) Math.pow(26, 0);
    assertEquals(expectedRes, decode(s));
  }

}