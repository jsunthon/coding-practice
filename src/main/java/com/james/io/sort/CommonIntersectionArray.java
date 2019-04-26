package com.james.io.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom solution for problem 14.1 of EPI
 */
public class CommonIntersectionArray {

    private CommonIntersectionArray() {}

    public static List<Integer> getIntersection(List<Integer> a,
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

    public static List<Integer> getIntersectionEpi(List<Integer> list1,
                                                   List<Integer> list2) {
        final List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int list1Curr;
        int list2Curr;
        while (i < list1.size() && j < list2.size()) {
            list1Curr = list1.get(i);
            list2Curr = list2.get(j);
            boolean elementsAreSame = list1Curr == list2Curr;
            boolean haveNotSeenThemPrior = i == 0 || list1Curr != list1.get(i - 1);
            if (elementsAreSame && haveNotSeenThemPrior) {
                res.add(list1Curr);
                i++;
                j++;
            } else if (list1Curr < list2Curr) {
                i++;
            } else {
                j++;
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
