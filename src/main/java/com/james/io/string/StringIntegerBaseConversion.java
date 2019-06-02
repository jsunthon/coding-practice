package com.james.io.string;

/**
 * Solution to problem 7.2 of EPI
 */
public class StringIntegerBaseConversion {

    public static String convert(String str, int fromBase, int toBase) {
        int decimal = convertToDecimal(str, fromBase);
        String res = convertToBase(decimal, toBase);

        if (decimal < 0) {
            return "-" + res;
        }
        return res;
    }

    private static int convertToDecimal(String str, int base) {
        boolean isNegative = str.startsWith("-");
        int x = 0;
        int baseFactor = 0;
        char c;
        for (int i = str.length() - 1; i >= 0; i--) {
            c = str.charAt(i);
            int digit =  Character.isDigit(c) ? c - '0' : c - 'A' + 10;
            x += digit * Math.pow(base, baseFactor++);
        }
        if (isNegative) {
            x = -x;
        }
        return x;
    }

    private static String convertToBase(int x, int base) {
        int mod = x % base;
        return x == 0 ? "" : convertToBase(x / base, base)
                + (char) (mod >= 10 ? mod + 'A' - 10 : '0' + mod);
    }
}
