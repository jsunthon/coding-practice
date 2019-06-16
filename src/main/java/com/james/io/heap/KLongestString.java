package com.james.io.heap;

import java.util.*;


/**
 * Intro of EPI ch 11
 */
public class KLongestString {

    public static List<String> getKLongest(int k, Iterator<String> iter) {
        if (k < 1) {
            throw new IllegalArgumentException("K must be greater than or equal to 1");
        }

        final PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        while (iter.hasNext()) {
            String next = iter.next();

            if (pq.size() < k) {
                pq.offer(next);
            } else if (next.length() > pq.peek().length()) {
                pq.poll();
                pq.offer(next);
            }
        }

        return new ArrayList<>(pq);
    }
}
