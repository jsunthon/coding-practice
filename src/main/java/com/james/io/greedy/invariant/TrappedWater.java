package com.james.io.greedy.invariant;

import java.util.List;

/**
 * Problem 18.7 of EPI: Find Pair that traps the maximum amount of water
 */
public class TrappedWater {
    public static class Pair {
        int left;
        int right;
        int max;

        public Pair() {}

        public Pair(int left, int right, int max)  {
            this.left = left;
            this.right = right;
            this.max = max;
        }
    }

    public static Pair getMaxPair(List<Integer> tank) {
        int start = 0;
        int end = tank.size() - 1;
        Pair maxPair = new Pair();
        while (start < end) {

            int waterAmt = (end - start) * Math.min(tank.get(start), tank.get(end));
            if (waterAmt > maxPair.max) {
                maxPair = new Pair(start, end, waterAmt);
            }

            if (tank.get(start) < tank.get(end)) {
                start++;
            } else if (tank.get(start).equals(tank.get(end))) {
                start++;
                end--;
            } else {
                end--;
            }
        }
        return maxPair;
    }
}
