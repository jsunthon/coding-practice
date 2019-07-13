package com.james.io.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 11.1 of EPI
 */
public class MergedKSortedLists {

  private static class ArrayEntry {

    int val;
    int arrayIndex;
    int arrayOfArraysIndex;

    private ArrayEntry(int val, int arrayIndex, int arrayOfArraysIndex) {
      this.val = val;
      this.arrayIndex = arrayIndex;
      this.arrayOfArraysIndex = arrayOfArraysIndex;
    }
  }

  // O(n log k) time, O(n) space for the final result, but requires n additional k space.
  public static List<Integer> mergeLists(List<List<Integer>> lists) {
    Queue<ArrayEntry> pq = new PriorityQueue<>(lists.size(),
        (entry1, entry2) -> Integer.compare(entry1.val, entry2.val));

    for (int i = 0; i < lists.size(); i++) {
      if (!lists.get(i).isEmpty()) {
        pq.add(new ArrayEntry(lists.get(i).get(0), 0, i));
      }
    }

    List<Integer> mergedLists = new ArrayList<>();
    ArrayEntry currEntry;
    while (!pq.isEmpty()) {
      currEntry = pq.poll();
      mergedLists.add(currEntry.val);

      if (currEntry.arrayIndex < lists.get(currEntry.arrayOfArraysIndex).size() - 1) {
        pq.offer(new ArrayEntry(lists.get(currEntry.arrayOfArraysIndex)
            .get(currEntry.arrayIndex + 1), currEntry.arrayIndex + 1,
            currEntry.arrayOfArraysIndex));
      }
    }

    return mergedLists;
  }
}
