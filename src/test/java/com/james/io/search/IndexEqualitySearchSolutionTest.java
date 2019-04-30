package com.james.io.search;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IndexEqualitySearchSolutionTest {

    @Test
    public void testSearchIndexEqualsWithNoDuplicate() {
        List<Integer> list = Arrays.asList(-2, 0, 2, 3, 6, 7, 9);
        Assert.assertEquals(3, IndexEqualitySearchSolution.searchIndexEqualsWithNoDuplicate(list));
    }

    @Test
    public void testSearchIndexEqualsWithDuplicate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6, 7);
        int res = IndexEqualitySearchSolution.searchIndexEqualsWithDuplicate(list);
        Assert.assertTrue(res == 5 || res == 6);
    }

    @Ignore
    @Test
    public void testSearchIndexEqualsWithAllDuplicate() {
        List<Integer> list = Collections.nCopies(5, 5);
        Assert.assertEquals(5, IndexEqualitySearchSolution.searchIndexEqualsWithDuplicate(list));
    }

    @Test
    public void testSearchIndexEqualsWithDuplicateNotExists() {
        List<Integer> list = Arrays.asList(-2, -1, 0, 0, 2, 2, 3);
        Assert.assertEquals(-1, IndexEqualitySearchSolution.searchIndexEqualsWithDuplicate(list));
    }
}
