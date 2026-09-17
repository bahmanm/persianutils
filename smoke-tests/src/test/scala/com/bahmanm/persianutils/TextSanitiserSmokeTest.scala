package com.bahmanm.persianutils

class TextSanitiserSmokeTest extends munit.FunSuite {

  test("default sanitisation") {
    val input = "  كتاب علي 123 و ١٤٠٣, تست?  "
    val expected = "کتاب علی ۱۲۳ و ۱۴۰۳، تست؟"
    assertEquals(TextSanitiser.sanitise(input), expected)
  }

  test("custom configuration") {
    val config = SanitiserConfig(
      standardiseCharacters = true,
      cleanSpacing = false,
      removeTatweel = true,
      standardiseDigits = false,
      standardisePunctuation = false,
      removeDiacritics = true
    )
    val input = "  كِتابِ علي 123?  "
    val expected = "  کتاب علی 123?  "
    assertEquals(TextSanitiser.sanitise(input, config), expected)
  }

}
