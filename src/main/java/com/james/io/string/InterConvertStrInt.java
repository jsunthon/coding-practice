package com.james.io.string;

/**
 * Custom solution to problem 7.1 of EPI
 */
public class InterConvertStrInt {

  public static int decodeInt(String s) {
    if (s == null || s.isEmpty()) {
      throw new IllegalArgumentException("Null or empty str");
    }
    int res = 0;
    int tens = 1;
    int currentCharInd;
    for (currentCharInd = s.length() - 1; currentCharInd > 0; currentCharInd--) {
      char c = s.charAt(currentCharInd);
      int val = c - '0';
      res += tens * val;
      tens *= 10;
    }
    char lastChar = s.charAt(currentCharInd);
    if (lastChar == '-') {
      return -1 * res;
    }
    return res + (tens * (lastChar - '0'));
  }

  public static String encodeStr(int i) {
    StringBuilder strBldr = new StringBuilder();
    boolean isNeg = i < 0;
    int mod;
    while (i != 0) {
      mod = Math.abs(i % 10);
      strBldr.insert(0, mod);
      i /= 10;
    }

    if (isNeg) {
      strBldr.insert(0, '-');
    }
    return strBldr.toString();
  }
}
