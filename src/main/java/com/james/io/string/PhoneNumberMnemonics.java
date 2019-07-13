package com.james.io.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 7.7 of EPI
 *
 * O(4^n) time because, we have a string of length N, and each char in that string can take on at
 * most one of 4 possible values.
 *
 * O(4^n) space because there are 4^n combinations
 */
public class PhoneNumberMnemonics {

  private PhoneNumberMnemonics() {
  }

  private static final String[] MNEMEONICS = new String[]{
      "0",
      "1",
      "ABC",
      "DEF",
      "GHI",
      "JKL",
      "MNO",
      "PQRS",
      "TUV",
      "WXYZ"
  };

  // START brute force
  public static List<String> getMnemonics(String phoneNo) {
    List<String> res = new ArrayList<>();
    helper(phoneNo, new char[phoneNo.length()], 0, res);
    return res;
  }

  private static void helper(String str, char[] curr, int currIndex, List<String> res) {
    if (currIndex < str.length()) {
      for (char c : MNEMEONICS[str.charAt(currIndex) - '0'].toCharArray()) {
        curr[currIndex] = c;
        helper(str, curr, currIndex + 1, res);
      }
    } else {
      res.add(new String(curr));
    }
  }
  // END brute force
}
