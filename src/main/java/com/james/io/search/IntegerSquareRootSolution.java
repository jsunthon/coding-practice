package com.james.io.search;

public class IntegerSquareRootSolution {

    public static int searchIntegerSquareRoot(int k) {
        int i = 0;

        while (Math.pow(i, 2) < k) {
            if (Math.pow(i + 1, 2) > k) {
                break;
            }
            i++;
        }

        return i;
    }
}
