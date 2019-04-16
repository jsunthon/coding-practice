package com.james.io.greedy.invariant;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumGasTest {

    @Test
    public void testGetAmpleExistsOriginalOrder() {
        List<Integer> gallons = Stream.of(50, 20, 5, 30, 25, 10, 10).collect(Collectors.toList());
        List<Integer> distances = Stream.of(900, 600, 200, 400, 600, 200).collect(Collectors.toList());
        Assert.assertEquals(3, SumGas.getAmple(gallons, distances));
    }

    @Test
    public void testGetAmpleExistsCustomOrder() {
        List<Integer> gallons = Stream.of(30, 20, 5, 50, 25, 10, 10).collect(Collectors.toList());
        List<Integer> distances = Stream.of(200, 600, 900, 400, 600, 200).collect(Collectors.toList());
        Assert.assertEquals(3, SumGas.getAmple(gallons, distances));
    }
}
