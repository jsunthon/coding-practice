package com.james.io.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 11.3 of EPI
 */
public class KSortedArray {

  public static List<Integer> sortKSorted(Iterable<Integer> iterable,
      int k) {
    final List<Integer> sorted = new ArrayList<>();
    final Iterator<Integer> iterator = iterable.iterator();
    final Queue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k && iterator.hasNext(); i++) {
      pq.offer(iterator.next());
    }
    while (!pq.isEmpty() && iterator.hasNext()) {
      pq.offer(iterator.next());
      sorted.add(pq.poll());
    }
    while (!pq.isEmpty()) {
      sorted.add(pq.poll());
    }
    return sorted;
  }
}
