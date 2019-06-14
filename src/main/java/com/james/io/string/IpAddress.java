package com.james.io.string;

import java.util.ArrayList;
import java.util.List;

/**
 * EPI 7.10
 */
public class IpAddress {

    public static List<String> genValidAddresses(String str) {
        final List<String> ipAddresses = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            String first = str.substring(0, i);
            if (isValidPart(first)) {
                for (int j = 1; i + j < str.length() && j < 4; j++) {
                    String second = str.substring(i, i + j);
                    if (isValidPart(second)) {
                        for (int k = 1; i + j + k < str.length() && k < 4; k++) {
                            String third = str.substring(i + j, i + j + k);
                            String fourth = str.substring(i + j + k);
                            if (isValidPart(third) && isValidPart(fourth)) {
                                ipAddresses.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return ipAddresses;
    }

    private static boolean isValidPart(String part) {
        if (part.length() > 3) {
            return false;
        }

        if (part.startsWith("0") && part.length() > 1) {
            return false;
        }

        int val = Integer.parseInt(part);

        return val >= 0 && val <= 255;
    }
}
