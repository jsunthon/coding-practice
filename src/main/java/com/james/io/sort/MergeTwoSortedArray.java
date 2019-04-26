package com.james.io.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom solution for problem 14.1 of EPI
 */
public class MergeTwoSortedArray {

    private MergeTwoSortedArray() {}

    public static List<Integer> merge(List<Integer> a,
                                      List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int curr;
        for (int i = 0; i < a.size(); i++) {
            curr = a.get(i);
            boolean validIndex = i == 0 || curr != a.get(i - 1);
            if (validIndex && isValidInList(b, curr)) {
                res.add(curr);
            }
        }
        return res;
    }

    private static boolean isValidInList(List<Integer> list, int value) {
        return isValidInList(list, value, 0, list.size() - 1);
    }

    private static boolean isValidInList(List<Integer> list, int value, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = (low + high) / 2;

        if (value > list.get(mid)) {
            return isValidInList(list, value, mid + 1, high);
        } else if (value == list.get(mid)) {
            return true;
        } else {
            return isValidInList(list, value, low, mid - 1);
        }
    }
}
