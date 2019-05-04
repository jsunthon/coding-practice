package com.james.io.search;

import org.junit.Assert;
import org.junit.Test;

public class IntegerSquareRootSolutionTest {

    @Test
    public void testSearchZero() {
        Assert.assertEquals(0, IntegerSquareRootSolution.searchIntegerSquareRoot(0));
    }

    @Test
    public void testSearchOne() {
        Assert.assertEquals(1, IntegerSquareRootSolution.searchIntegerSquareRoot(1));
    }

    @Test
    public void testSearchTwo() {
        Assert.assertEquals(1, IntegerSquareRootSolution.searchIntegerSquareRoot(2));
    }

    @Test
    public void testSearchThree() {
        Assert.assertEquals(1, IntegerSquareRootSolution.searchIntegerSquareRoot(3));
    }

    @Test
    public void testSearchSixteen() {
        Assert.assertEquals(4, IntegerSquareRootSolution.searchIntegerSquareRoot(16));
    }
}
