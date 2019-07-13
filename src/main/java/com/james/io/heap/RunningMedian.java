package com.james.io.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 11.5 of EPI; log n time to output the median at the time of each of n inserts
 */
public class RunningMedian {

  private static final int INITIAL_CAPACITY = 16;

  public static List<Double> genMedians(Iterator<Integer> iterator) {
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(INITIAL_CAPACITY, Collections.reverseOrder());
    List<Double> medians = new ArrayList<>();
    Integer next;
    while (iterator.hasNext()) {
      next = iterator.next();

      if (minHeap.isEmpty()) {
        minHeap.add(next);
      } else {
        if (next >= minHeap.peek()) {
          minHeap.add(next);
        } else {
          maxHeap.add(next);
        }
      }

      if (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.add(minHeap.remove());
      } else if (maxHeap.size() > minHeap.size()) {
        minHeap.add(maxHeap.remove());
      }

      // if the sizes are equal, get the avg of the peeks
      // else, return the top of the min heap
      if (minHeap.size() == maxHeap.size()) {
        medians.add((minHeap.peek() + maxHeap.peek()) / 2.0);
      } else {
        medians.add((double) minHeap.peek());
      }
    }

    return medians;
  }
}
