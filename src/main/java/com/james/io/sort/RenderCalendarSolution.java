package com.james.io.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution tpb problem 14.4 of EPI
 */
public class RenderCalendarSolution {

  public static class Event {

    public int start;
    public int end;

    public Event(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  private static class EndPoint implements Comparable<EndPoint> {

    private int time;
    private boolean isStart;

    private EndPoint(int time, boolean isStart) {
      this.time = time;
      this.isStart = isStart;
    }

    @Override
    public int compareTo(EndPoint other) {
      if (time != other.time) {
        return Integer.compare(time, other.time);
      }

      return isStart && !other.isStart ? -1 : !isStart
          && other.isStart ? 1 : 0;
    }
  }

  /**
   * O(n log n) time, O(n) space
   */
  public static int getMaxConcurrentEvents(List<Event> events) {
    final List<EndPoint> endPoints = new ArrayList<>();

    for (Event event : events) {
      endPoints.add(new EndPoint(event.start, true));
      endPoints.add(new EndPoint(event.end, false));
    }

    Collections.sort(endPoints);

    int maxConcurrentEvents = 0;
    int localConcurrentEvents = 0;

    for (EndPoint endpoint : endPoints) {
      if (endpoint.isStart) {
        localConcurrentEvents++;
        maxConcurrentEvents = Math.max(maxConcurrentEvents, localConcurrentEvents);
      } else {
        localConcurrentEvents--;
      }
    }

    return maxConcurrentEvents;
  }
}
