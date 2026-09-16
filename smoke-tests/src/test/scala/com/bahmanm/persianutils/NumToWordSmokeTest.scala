package com.bahmanm.persianutils

class NumToWordSmokeTest extends munit.FunSuite {

  test("cardinal numbers") {
    assertEquals(NumToWord.cardinal(0), "صفر")
    assertEquals(NumToWord.cardinal(100), "صد")
    assertEquals(NumToWord.cardinal(235), "دویست و سی و پنج")
    assertEquals(
      NumToWord.cardinal(299792458L),
      "دویست و نود و نه میلیون و هفت\u200Cصد و نود و دو هزار و چهار\u200Cصد و پنجاه و هشت"
    )
  }

  test("ordinal numbers") {
    assertEquals(NumToWord.ordinal(0), "صفرم")
    assertEquals(NumToWord.ordinal(1), "یکم")
    assertEquals(NumToWord.ordinal(2), "دوم")
    assertEquals(NumToWord.ordinal(3), "سوم")
    assertEquals(NumToWord.ordinal(30), "سی\u200Cام")
    assertEquals(NumToWord.ordinal(100), "صدم")
    assertEquals(NumToWord.ordinal(235), "دویست و سی و پنجم")
  }

  test("deprecated apply backward compatibility") {
    @annotation.nowarn("cat=deprecation")
    val res1 = NumToWord(100)
    assertEquals(res1, "صد")

    @annotation.nowarn("cat=deprecation")
    val res2 = NumToWord(235L)
    assertEquals(res2, "دویست و سی و پنج")
  }

}
