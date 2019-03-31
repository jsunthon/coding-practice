package com.james.io.greedy.scheduletask;

import com.james.io.greedy.scheduletask.ScheduleTaskSolution.Assignment;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ScheduleTaskSolutionTest {

    @Test
    public void testGetScheduleEmpty() {
        assertTrue(ScheduleTaskSolution.getSchedule(Collections.emptyList()).isEmpty());
    }

    @Test
    public void testGetScheduleOk() {
        final List<Integer> tasks = Stream.of(5, 2, 1, 6, 4, 4).collect(Collectors.toList());
        final Assignment assignment1 = new Assignment(1, 6);
        final Assignment assignment2 = new Assignment(2, 5);
        final Assignment assignment3 = new Assignment(4, 4);
        final List<Assignment> expectedAssignments = Stream.of(assignment1, assignment2, assignment3).collect(Collectors.toList());
        assertEquals(expectedAssignments, ScheduleTaskSolution.getSchedule(tasks));
    }
}
