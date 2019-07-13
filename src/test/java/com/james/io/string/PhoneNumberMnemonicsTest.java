package com.james.io.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class PhoneNumberMnemonicsTest {

  @Test
  public void getMnemonicsManyChar() {
    String s = "2276696";
    List<String> subRes = Arrays.asList("ACRONYM", "ABPOMZN");
    assertTrue(PhoneNumberMnemonics.getMnemonics(s).containsAll(subRes));
  }

  @Test
  public void getMnemonicsSingleChar() {
    String s = "2";
    List<String> subRes = Arrays.asList("A", "B", "C");
    assertEquals(subRes, PhoneNumberMnemonics.getMnemonics(s));
  }

  @Test
  public void getMnemonicsNoChar() {
    assertEquals(Collections.singletonList(""), PhoneNumberMnemonics.getMnemonics(""));
  }
}