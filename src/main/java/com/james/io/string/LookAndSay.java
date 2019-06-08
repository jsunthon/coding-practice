package com.james.io.string;

/**
 * 7.8 of EPI
 *
 * O(n*2^n), because there are n iterations, and each iteration
 * loops over at most 2^n times since the max len of a str would
 * be 2^n
 */
public class LookAndSay {

    public static String lookAndSay(int n) {
        String s = "1";
        int start = 1;
        while (start++ < n) {
            s = nextStr(s);
        }
        return s;
    }

    private static String nextStr(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            res.append(count);
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
