package com.bahmanm.persianutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TextSanitiserJavaSmokeTest {

  private TextSanitiserJavaSmokeTest() {}

  public static void verify() {
    SanitiserConfig defaultConfig = new SanitiserConfig();
    assertEquals(
        "کتاب علی ۱۲۳ و ۱۴۰۳، تست؟",
        TextSanitiser.sanitise("  كتاب علي 123 و ١٤٠٣, تست?  ", defaultConfig));

    SanitiserConfig customConfig =
        new SanitiserConfig(
            true, // standardiseCharacters
            false, // cleanSpacing
            true, // removeTatweel
            false, // standardiseDigits
            false, // standardisePunctuation
            true // removeDiacritics
            );
    assertEquals(
        "  کتاب علی 123?  ",
        TextSanitiser.sanitise("  كِتابِ علي 123?  ", customConfig));
  }
}
