package com.james.io.sort;

import com.james.io.sort.RenderCalendarSolution.Event;
import org.junit.Test;

import java.util.List;

public class RenderCalendarSolutionTest {

    @Test
    public void testFindMaxConcurrentEvents() {

    }

    private List<Event> getDefaultCalender() {
        Event e1 = new Event(1, 5);
        Event e2 = new Event(2, 7);
        Event e3 = new Event(4, 5);
        Event e4 = new Event(6, 10);
        Event e5 = new Event(8, 9);
        Event e6 = new Event(9, 17);
        Event e7 = new Event(11, 13);
        Event e8 = new Event(12, 15);
        Event e9 = new Event(14, 15);
    }
}
