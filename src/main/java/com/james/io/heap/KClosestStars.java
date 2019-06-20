package com.james.io.heap;

import java.util.*;

/**
 * 11.4 of EPI
 * <p>
 * O(n log k) time
 * O(k) space
 */
public class KClosestStars {

    private KClosestStars() {
    }

    static class Point implements Comparable<Point> {
        double x;
        double y;
        double z;

        Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        private double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Point other) {
            return Double.compare(distance(), other.distance());
        }
    }

    static List<Point> kClosest(List<Point> points,
                                int k) {
        if (points == null || k <= 0) {
            throw new IllegalArgumentException("Points cannot be null and k cannot be less than 1");
        }
        if (points.isEmpty()) {
            return Collections.emptyList();
        }
        Queue<Point> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for (Point point : points) {
            if (pq.size() < k) {
                pq.add(point);
            } else if (pq.peek().compareTo(point) > 0) {
                pq.remove();
                pq.add(point);
            }
        }
        List<Point> closestPts = new ArrayList<>(pq);
        Collections.sort(closestPts);
        return closestPts;
    }
}
