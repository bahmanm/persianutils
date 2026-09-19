package com.bahmanm.persianutils

class TextSanitiserTest extends munit.FunSuite {

  // Default configuration tests
  test("default: Arabic Kaf should convert to Persian Keheh") {
    assertEquals(TextSanitiser.sanitise("كتاب"), "کتاب")
    assertEquals(TextSanitiser.sanitise("بانك"), "بانک")
  }

  test("default: Arabic Yeh variants should convert to Persian Yeh") {
    assertEquals(TextSanitiser.sanitise("علي"), "علی")
    assertEquals(TextSanitiser.sanitise("موسى"), "موسی")
    assertEquals(TextSanitiser.sanitise("پياده"), "پیاده")
  }

  test("default: Arabic Heh variants should convert to Persian Heh") {
    assertEquals(TextSanitiser.sanitise("ھمه"), "همه")
    assertEquals(TextSanitiser.sanitise("دائرة"), "دائره")
    assertEquals(TextSanitiser.sanitise("خانۀ"), "خانهٔ")
  }

  test("default: Kashida / Tatweel should be removed") {
    assertEquals(TextSanitiser.sanitise("تـــــست"), "تست")
    assertEquals(TextSanitiser.sanitise("ایـــــران"), "ایران")
  }

  test("default: ASCII and Eastern Arabic digits should convert to Persian digits") {
    assertEquals(TextSanitiser.sanitise("0123456789"), "۰۱۲۳۴۵۶۷۸۹")
    assertEquals(TextSanitiser.sanitise("٠١٢٣٤٥٦٧٨٩"), "۰۱۲۳۴۵۶۷۸۹")
    assertEquals(
      TextSanitiser.sanitise("سال 1403 و سال ١٤٠٣"),
      "سال ۱۴۰۳ و سال ۱۴۰۳"
    )
  }

  test("default: punctuation marks should convert to Persian equivalents") {
    assertEquals(TextSanitiser.sanitise("سلام, چطوری?"), "سلام، چطوری؟")
    assertEquals(TextSanitiser.sanitise("گزینه اول; گزینه دوم"), "گزینه اول؛ گزینه دوم")
  }

  test("default: spacing and ZWNJ should be cleaned") {
    assertEquals(TextSanitiser.sanitise("سلام    جهان"), "سلام جهان")
    assertEquals(TextSanitiser.sanitise("سلام\u00A0جهان"), "سلام جهان")
    assertEquals(TextSanitiser.sanitise("می\u200C\u200Cروم"), "می\u200Cروم")
    assertEquals(TextSanitiser.sanitise("کتاب \u200C ها"), "کتاب\u200Cها")
    assertEquals(TextSanitiser.sanitise("کتاب\u200C ها"), "کتاب\u200Cها")
    assertEquals(TextSanitiser.sanitise("کتاب \u200Cها"), "کتاب\u200Cها")
    assertEquals(TextSanitiser.sanitise("می \u200C روم"), "می\u200Cروم")
    assertEquals(TextSanitiser.sanitise("کتاب   \u200C  \u200C   ها"), "کتاب\u200Cها")
    assertEquals(TextSanitiser.sanitise("کتاب\t\u200C\tها"), "کتاب\u200Cها")
    assertEquals(TextSanitiser.sanitise("  \u200Cسلام جهان\u200C  "), "سلام جهان")
    assertEquals(
      TextSanitiser.sanitise("سلام\u200B\u200Dجهان\u00AD"),
      "سلام جهان"
    )
  }

  test("default: diacritics should be preserved by default") {
    val input = "کِتابِ مَن، مُعَلِّمْ"
    assertEquals(TextSanitiser.sanitise(input), input)
  }

  // Custom configuration tests
  test("custom: standardiseCharacters = false") {
    val config = SanitiserConfig(
      standardiseCharacters = false,
      cleanSpacing = false,
      removeTatweel = false,
      standardiseDigits = false,
      standardisePunctuation = false
    )
    assertEquals(TextSanitiser.sanitise("كتاب علي", config), "كتاب علي")
  }

  test("custom: removeTatweel = false") {
    val config = SanitiserConfig(removeTatweel = false)
    assertEquals(TextSanitiser.sanitise("تــــست", config), "تــــست")
  }

  test("custom: standardiseDigits = false") {
    val config = SanitiserConfig(standardiseDigits = false)
    assertEquals(TextSanitiser.sanitise("123 و ٤٥٦", config), "123 و ٤٥٦")
  }

  test("custom: standardisePunctuation = false") {
    val config = SanitiserConfig(standardisePunctuation = false)
    assertEquals(TextSanitiser.sanitise("سلام, چطور?", config), "سلام, چطور?")
  }

  test("custom: removeDiacritics = true") {
    val config = SanitiserConfig(removeDiacritics = true)
    assertEquals(
      TextSanitiser.sanitise("کِتابِ مَن، مُعَلِّمْ", config),
      "کتاب من، معلم"
    )
  }

  test("custom: cleanSpacing = false") {
    val config = SanitiserConfig(
      standardiseCharacters = false,
      cleanSpacing = false,
      removeTatweel = false,
      standardiseDigits = false,
      standardisePunctuation = false
    )
    val input = "  می\u200C\u200Cروم   "
    assertEquals(TextSanitiser.sanitise(input, config), input)
  }

  // Edge cases
  test("edge cases: empty and null inputs") {
    assertEquals(TextSanitiser.sanitise(""), "")
    assertEquals(TextSanitiser.sanitise(null), "")
  }

  test("edge cases: whitespace and ZWNJ only") {
    assertEquals(TextSanitiser.sanitise("   \u200C\u200C   "), "")
  }

  test("edge cases: multiline strings") {
    val input = "  خط اول   \n  خط دوم\u200C  "
    val expected = "خط اول\nخط دوم"
    assertEquals(TextSanitiser.sanitise(input), expected)
  }

  test("edge cases: Windows CRLF multiline") {
    val input = "  خط اول  \r\n  خط دوم  "
    val expected = "خط اول\r\nخط دوم"
    assertEquals(TextSanitiser.sanitise(input), expected)
  }

}
