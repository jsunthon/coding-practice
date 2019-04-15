package com.james.io.greedy.invariant;

import java.util.List;

// problem 18.5 of EPI
// find an element that occurs more than 1/2 the amount of time
// doesn't need to use brute force hash map T: O(n), S: O(n)
// can use mathemtics to get T: O(n), S: O(1)
public class MajorityElement {
    public static String findMajority(List<String> sequence) {
        String majority = "";
        int count = 0;
        // once count goes down to 0, the majority element gets discarded
        // and is initialized to the current variable
        for (String s : sequence) {
            if (count == 0) {
                majority = s;
                count = 1;
            } else if (s.equals(majority)) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
