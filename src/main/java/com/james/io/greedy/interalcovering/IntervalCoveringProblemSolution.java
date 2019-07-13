package com.james.io.greedy.interalcovering;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 18.3 of EPI
 */
public class IntervalCoveringProblemSolution {

  public static List<Integer> getCoverTimes(List<Interval> intervals) {
    if (intervals.isEmpty()) {
      return Collections.emptyList();
    }
    intervals.sort((Interval i1, Interval i2) -> i1.end - i2.end);
    int lastVisitedTime = intervals.get(0).end;
    List<Integer> visited = Stream.of(lastVisitedTime).collect(Collectors.toList());
    for (Interval interval : intervals) {
      if (interval.start > lastVisitedTime) {
        lastVisitedTime = interval.end;
        visited.add(lastVisitedTime);
      }
    }
    return visited;
  }

  public static List<Integer> getCoverTimes(Integer[][] intervals) {
    if (intervals.length == 0) {
      return Collections.emptyList();
    }
    Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
    int choice = intervals[0][1];
    List<Integer> result = Stream.of(choice).collect(Collectors.toList());
    for (Integer[] interval : intervals) {
      if (interval[0] > choice) {
        choice = interval[1];
        result.add(choice);
      }
    }
    return result;
  }
}
