package com.james.io.greedy.minwaitingtime;


import java.util.Collections;
import java.util.List;

/**
 * Solution for problem 18.2, minimum waiting times
 */
public class MinimumWaitingTimeSolution {

  public static int getMinimumWaitingTime(List<Integer> waitingTimes) {
    Collections.sort(waitingTimes);
    int minWaitingTime = 0;
    int numOfQueriesRemaining = 0;
    for (int i = 0; i < waitingTimes.size(); i++) {
      numOfQueriesRemaining = waitingTimes.size() - (i
          + 1); // i = 0, size = 4 -> 4 - (1) - > 3 ; i = 1 -> 4 - (1 + 1) = 2..
      minWaitingTime += waitingTimes.get(i) * numOfQueriesRemaining;
    }
    return minWaitingTime;
  }
}
