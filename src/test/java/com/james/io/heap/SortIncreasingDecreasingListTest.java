package com.james.io.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortIncreasingDecreasingListTest {

    @Test
    public void sortIncDec() {
        List<Integer> list = Arrays.asList(57, 131, 493, 294, 221, 339, 418, 452, 442, 190);
        List<Integer> expected = Arrays.asList(57, 131, 190, 221, 294, 339, 418, 442, 452, 493);
        assertEquals(expected, SortIncreasingDecreasingList.sortIncDec(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortIncDecEmpty() {
        assertEquals(Collections.emptyList(), SortIncreasingDecreasingList.sortIncDec(Collections.emptyList()));
    }

    @Test
    public void sortIncDecSingleton() {
        assertEquals(Collections.singletonList(1), SortIncreasingDecreasingList.sortIncDec(Collections.singletonList(1)));
    }

    @Test
    public void sortIncDecStrictlyIncr() {
        assertEquals(Arrays.asList(1, 2, 3), SortIncreasingDecreasingList.sortIncDec(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void sortIncDecStrictlyDecr() {
        assertEquals(Arrays.asList(1, 2, 3), SortIncreasingDecreasingList.sortIncDec(Arrays.asList(3, 2, 1)));
    }
}