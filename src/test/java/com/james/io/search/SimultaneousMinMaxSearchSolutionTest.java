package com.james.io.search;

import com.james.io.search.model.MinMax;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SimultaneousMinMaxSearchSolutionTest {

    @Test
    public void searchMinMax() {
        final List<Integer> list = Arrays.asList(3, 2, 5, 1, 2, 4);

        assertEquals(new MinMax(1, 5),
                SimultaneousMinMaxSearchSolution.searchMinMax(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchMinMaxEmptyListThrowException() {
        SimultaneousMinMaxSearchSolution.searchMinMax(Collections.emptyList());
    }

    @Test
    public void searchMinMaxSingleton() {
        final int num = 100024;

        assertEquals(new MinMax(num, num),
                SimultaneousMinMaxSearchSolution.searchMinMax(Collections.singletonList(num)));
    }

    @Test
    public void searchMinMaxUniformDuplicate() {
        final int num = 10;
        final List<Integer> list = Collections.nCopies(1000, num);

        assertEquals(new MinMax(num, num),
                SimultaneousMinMaxSearchSolution.searchMinMax(list));
    }

}