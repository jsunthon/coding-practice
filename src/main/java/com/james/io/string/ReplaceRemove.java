package com.james.io.string;

/**
 * EPI 7.4 Solution
 */
public class ReplaceRemove {

    private ReplaceRemove() {}

    public static int convert(int size, char[] chars) {
        int aCount = 0;
        int writeIdx = 0;
        char c;
        for (int i = 0; i < size; i++) {
            c = chars[i];
            if (c != 'b') {
                chars[writeIdx++] = c;
            }
            if (c == 'a') {
                aCount++;
            }
        }
        int currIdx = writeIdx - 1;
        writeIdx = writeIdx + aCount - 1;
        int finalSize = writeIdx + 1;
        while (currIdx >= 0) {
            c = chars[currIdx--];
            if (c == 'a') {
                chars[writeIdx--] = 'd';
                chars[writeIdx--] = 'd';
            } else {
                chars[writeIdx--] = c;
            }
        }
        return finalSize;
    }
}
