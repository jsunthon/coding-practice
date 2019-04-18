package com.james.io.greedy.invariant;

import com.james.io.greedy.invariant.TrappedWater.Pair;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TrappedWaterTest {

    @Test
    public void getMaxPair() {
        List<Integer> tank = Stream.of(1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1).collect(Collectors.toList());
        Pair maxPair = TrappedWater.getMaxPair(tank);
        assertEquals(4, maxPair.left);
        assertEquals(16, maxPair.right);
        assertEquals(48, maxPair.max);
    }
}
