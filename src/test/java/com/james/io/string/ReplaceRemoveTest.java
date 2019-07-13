package com.james.io.string;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReplaceRemoveTest {

  private static final char LITTLE_A = 'a';
  private static final char LITTLE_B = 'b';
  private static final char LITTLE_C = 'c';
  private static final char LITTLE_D = 'd';

  @Test
  public void convert1() {
    char[] chars = new char[5];
    chars[0] = LITTLE_A;
    chars[1] = LITTLE_B;
    chars[2] = LITTLE_A;
    chars[3] = LITTLE_C;

    assertEquals(5, ReplaceRemove.convert(4, chars));

    char[] expectedChars = new char[]{LITTLE_D, LITTLE_D, LITTLE_D, LITTLE_D, LITTLE_C};

    assertArrayEquals(expectedChars, chars);
  }

  @Test
  public void convert2() {
    char[] chars = new char[7];
    chars[0] = LITTLE_A;
    chars[1] = LITTLE_C;
    chars[2] = LITTLE_A;
    chars[3] = LITTLE_A;

    assertEquals(7, ReplaceRemove.convert(4, chars));

    char[] expectedChars = new char[]{LITTLE_D, LITTLE_D, LITTLE_C, LITTLE_D, LITTLE_D, LITTLE_D,
        LITTLE_D};

    assertArrayEquals(expectedChars, chars);
  }

}
