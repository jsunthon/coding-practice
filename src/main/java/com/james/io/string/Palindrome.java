package com.james.io.string;

public class Palindrome {

  public static boolean isPalindrome(String s) {
    if (s == null) {
      throw new IllegalArgumentException("Null string");
    }

    if (s.isEmpty()) {
      return true;
    }

    int start = getFwdIdx(0, s);
    int end = getBkwdsIdx(s.length() - 1, s);

    while (start < end) {
      if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
        return false;
      }
      start = getFwdIdx(start + 1, s);
      end = getBkwdsIdx(end - 1, s);
    }

    return true;
  }

  private static int getFwdIdx(int start, String s) {
    while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) {
      start++;
    }
    return start;
  }

  private static int getBkwdsIdx(int end, String s) {
    while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) {
      end--;
    }
    return end;
  }
}
