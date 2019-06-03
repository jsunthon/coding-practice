package com.james.io.string;

/**
 * Solution to 7.3 of EPI
 */
public class SpreadsheetColumnEncoding {

    private static final int BASE_26 = 26;

    public static void main(String[] args) {
        System.out.println('Z' - 'A');
    }

    public static int decode(String id) {
        int res = 0;
        for (char c : id.toCharArray()) {
            res = res * BASE_26 + (c - 'A' + 1);
        }
        return res;
    }
}
