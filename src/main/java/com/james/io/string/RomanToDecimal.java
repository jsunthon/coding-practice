package com.james.io.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom solution to 7.9 of EPI
 */
public class RomanToDecimal {

  enum Roman {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    int val;

    Roman(int val) {
      this.val = val;
    }

    boolean isExceptional(Roman other) {
      if (this.equals(Roman.I) && (other.equals(V) || other.equals(X))) {
        return true;
      } else if (this.equals(Roman.X) && (other.equals(L) || other.equals(C))) {
        return true;
      } else if (this.equals(C) && (other.equals(D) || other.equals(M))) {
        return true;
      } else {
        return false;
      }
    }

    static Roman fromChar(char c) {
      return Roman.valueOf(String.valueOf(c));
    }
  }

  // O(n) time, where n is the length of the roman num string
  // O(1) space
  public static int romanToDecimal(String romanNum) {
    int res = 0;
    for (int i = 0; i < romanNum.length(); i++) {
      Roman currValue = Roman.fromChar(romanNum.charAt(i));
      if (i < romanNum.length() - 1) {
        Roman nextValue = Roman.fromChar(romanNum.charAt(i + 1));
        if (currValue.isExceptional(nextValue)) {
          res += (nextValue.val - currValue.val);
          i++;
        } else {
          res += currValue.val;
        }
      } else {
        res += currValue.val;
      }
    }
    return res;
  }

  /**
   * EPI, O(n) time solution, assume a valid romanNum of len >= 1
   */
  public static int romanToDecimalEpi(String romanNum) {
    Map<Character, Integer> romanMap = new HashMap<>();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    int res = 0;

    res += romanMap.get(romanNum.charAt(romanNum.length() - 1));

    for (int i = romanNum.length() - 2; i >= 0; i--) {
      int currValue = romanMap.get(romanNum.charAt(i));
      int nextValue = romanMap.get(romanNum.charAt(i + 1));
      if (currValue < nextValue) {
        res -= currValue;
      } else {
        res += currValue;
      }
    }

    return res;
  }
}
