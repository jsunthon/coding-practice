package com.james.io.sort;

import static org.junit.Assert.assertEquals;

import com.james.io.sort.RenderCalendarSolution.Event;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class RenderCalendarSolutionTest {

  @Test
  public void testGetMaxConcurrentEvents() {
    int expectedMaxEvents = 3;
    assertEquals(expectedMaxEvents,
        RenderCalendarSolution.getMaxConcurrentEvents(getDefaultCalender()));
  }

  @Test
  public void testGetMaxConcurrentEventsEmpty() {
    assertEquals(0, RenderCalendarSolution.getMaxConcurrentEvents(Collections.emptyList()));
  }

  @Test
  public void testGetMaxConcurrentEventAllSimultaneous() {
    final Event event = new Event(23, 100);
    final List<Event> events = Collections.nCopies(10, event);
    assertEquals(events.size(), RenderCalendarSolution.getMaxConcurrentEvents(events));
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

    return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9);
  }
}
