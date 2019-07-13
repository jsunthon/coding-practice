package com.james.io.string;

/**
 * EPI 7.6
 */
public class ReverseSentenceWords {

  public static void reverse(char[] chars) {
    reverse(chars, 0, chars.length - 1);
    int start = 0;
    int end = find(chars, start);
    while (start <= end && start < chars.length) {
      reverse(chars, start, end);
      start = end + 2;
      end = find(chars, start);
    }
  }

  private static void reverse(char[] chars, int start, int end) {
    while (start < end) {
      char temp = chars[start];
      chars[start] = chars[end];
      chars[end] = temp;
      start++;
      end--;
    }
  }

  private static int find(char[] chars, int start) {
    int end = start;
    while (end < chars.length - 1 && chars[end + 1] != ' ') {
      end++;
    }
    return end;
  }
}
