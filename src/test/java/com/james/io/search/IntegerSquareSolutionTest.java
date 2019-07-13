package com.james.io.search;

import org.junit.Assert;
import org.junit.Test;

public class IntegerSquareSolutionTest {

  @Test
  public void testSearchZero() {
    Assert.assertEquals(0, IntegerSquareSolution.searchIntegerSquareRoot(0));
  }

  @Test
  public void testSearchOne() {
    Assert.assertEquals(1, IntegerSquareSolution.searchIntegerSquareRoot(1));
  }

  @Test
  public void testSearchTwo() {
    Assert.assertEquals(1, IntegerSquareSolution.searchIntegerSquareRoot(2));
  }

  @Test
  public void testSearchThree() {
    Assert.assertEquals(1, IntegerSquareSolution.searchIntegerSquareRoot(3));
  }

  @Test
  public void testSearchSixteen() {
    Assert.assertEquals(4, IntegerSquareSolution.searchIntegerSquareRoot(16));
  }

  @Test
  public void testSearchZeroLogN() {
    Assert.assertEquals(0, IntegerSquareSolution.searchIntegerSquareRootLogN(0));
  }

  @Test
  public void testSearchOneLogN() {
    Assert.assertEquals(1, IntegerSquareSolution.searchIntegerSquareRootLogN(1));
  }

  @Test
  public void testSearchTwoLogN() {
    Assert.assertEquals(1, IntegerSquareSolution.searchIntegerSquareRootLogN(2));
  }

  @Test
  public void testSearchThreeLogN() {
    Assert.assertEquals(1, IntegerSquareSolution.searchIntegerSquareRootLogN(3));
  }

  @Test
  public void testSearchSixteenLogN() {
    Assert.assertEquals(4, IntegerSquareSolution.searchIntegerSquareRootLogN(16));
  }
}
