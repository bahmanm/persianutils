package com.bahmanm.persianutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class NumToWordJavaSmokeTest {

  private NumToWordJavaSmokeTest() {}

  public static void verify() {
    assertEquals("صفر", NumToWord.cardinal(0));
    assertEquals("صد", NumToWord.cardinal(100));
    assertEquals("دویست و سی و پنج", NumToWord.cardinal(235));
    assertEquals(
        "دویست و نود و نه میلیون و هفت\u200Cصد و نود و دو هزار و چهار\u200Cصد و پنجاه و هشت",
        NumToWord.cardinal(299792458L));

    assertEquals("صفرم", NumToWord.ordinal(0));
    assertEquals("یکم", NumToWord.ordinal(1));
    assertEquals("دوم", NumToWord.ordinal(2));
    assertEquals("سوم", NumToWord.ordinal(3));
    assertEquals("سی\u200Cام", NumToWord.ordinal(30));
    assertEquals("صدم", NumToWord.ordinal(100));
    assertEquals("دویست و سی و پنجم", NumToWord.ordinal(235));

    assertEquals("صد", NumToWord.apply(100));
    assertEquals("دویست و سی و پنج", NumToWord.apply(235L));
  }
}
