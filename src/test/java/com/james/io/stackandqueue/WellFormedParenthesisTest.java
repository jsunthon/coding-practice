package com.james.io.stackandqueue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WellFormedParenthesisTest {

  @Test
  public void testIsWellFormedNull() {
    assertFalse(WellFormedParenthesis.isWellFormed(null));
  }

  @Test
  public void testIsWellFormedEmpty() {
    assertFalse(WellFormedParenthesis.isWellFormed(""));
  }

  @Test
  public void testIsWellFormedSingle() {
    assertFalse(WellFormedParenthesis.isWellFormed("{"));
  }

  @Test
  public void testIsWellFormed1() {
    String s = "[()[]{()()";
    assertFalse(WellFormedParenthesis.isWellFormed(s));
  }

  @Test
  public void testIsWellFormed2() {
    String s = "[({{([([[]])])}})]";
    assertTrue(WellFormedParenthesis.isWellFormed(s));
  }

  @Test
  public void testIsWellFormed3() {
    String s = "[({})]";
    assertTrue(WellFormedParenthesis.isWellFormed(s));
  }

  @Test
  public void testIsWellFormed4() {
    String s = "[({])]";
    assertFalse(WellFormedParenthesis.isWellFormed(s));
  }

  @Test
  public void testIsWellFormed5() {
    String s = "[][][][][][]()(){}{}()[]";
    assertTrue(WellFormedParenthesis.isWellFormed(s));
  }

  @Test
  public void testIsWellFormed6() {
    String s = "[{()}]()[]";
    assertTrue(WellFormedParenthesis.isWellFormed(s));
  }

}
