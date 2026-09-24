package com.bahmanm.persianutils

class NumToWordTest extends munit.FunSuite {

  // Cardinal tests
  test("cardinal: 0 should convert to صفر") {
    assertEquals(NumToWord.cardinal(0), "صفر")
  }

  test("cardinal: 5 should convert to پنج") {
    assertEquals(NumToWord.cardinal(5), "پنج")
  }

  test("cardinal: 15 should convert to پانزده") {
    assertEquals(NumToWord.cardinal(15), "پانزده")
  }

  test("cardinal: 220 should convert to دویست و بیست") {
    assertEquals(NumToWord.cardinal(220), "دویست و بیست")
  }

  test(
    "cardinal: 220,983 should convert to دویست و بیست هزار و نه‌صد و هشتاد و سه"
  ) {
    assertEquals(
      NumToWord.cardinal(220983),
      "دویست و بیست هزار و نه‌صد و هشتاد و سه"
    )
  }

  test("cardinal: 100,000 should convert to صد هزار") {
    assertEquals(NumToWord.cardinal(100000), "صد هزار")
  }

  test("cardinal: 100,000,000 should convert to صد میلیون") {
    assertEquals(NumToWord.cardinal(100000000), "صد میلیون")
  }

  test("cardinal: 100,000,000,000 should convert to صد میلیارد") {
    assertEquals(NumToWord.cardinal(100000000000L), "صد میلیارد")
  }

  test("cardinal: 100,000,000,000,000 should convert to صد هزار میلیارد") {
    assertEquals(NumToWord.cardinal(100000000000000L), "صد هزار میلیارد")
  }

  test(
    "cardinal: 100,000,233,000,110 should convert to صد هزار میلیارد و دویست و سی و سه میلیون و صد و ده"
  ) {
    assertEquals(
      NumToWord.cardinal(100000233000110L),
      "صد هزار میلیارد و دویست و سی و سه میلیون و صد و ده"
    )
  }

  // Ordinal tests
  test("ordinal: 0 should convert to صفرم") {
    assertEquals(NumToWord.ordinal(0), "صفرم")
  }

  test("ordinal: 1 should convert to یکم") {
    assertEquals(NumToWord.ordinal(1), "یکم")
  }

  test("ordinal: 2 should convert to دوم") {
    assertEquals(NumToWord.ordinal(2), "دوم")
  }

  test("ordinal: 3 should convert to سوم") {
    assertEquals(NumToWord.ordinal(3), "سوم")
  }

  test("ordinal: 4 should convert to چهارم") {
    assertEquals(NumToWord.ordinal(4), "چهارم")
  }

  test("ordinal: 5 should convert to پنجم") {
    assertEquals(NumToWord.ordinal(5), "پنجم")
  }

  test("ordinal: 9 should convert to نهم") {
    assertEquals(NumToWord.ordinal(9), "نهم")
  }

  test("ordinal: 10 should convert to دهم") {
    assertEquals(NumToWord.ordinal(10), "دهم")
  }

  test("ordinal: 11 should convert to یازدهم") {
    assertEquals(NumToWord.ordinal(11), "یازدهم")
  }

  test("ordinal: 13 should convert to سیزدهم") {
    assertEquals(NumToWord.ordinal(13), "سیزدهم")
  }

  test("ordinal: 15 should convert to پانزدهم") {
    assertEquals(NumToWord.ordinal(15), "پانزدهم")
  }

  test("ordinal: 19 should convert to نوزدهم") {
    assertEquals(NumToWord.ordinal(19), "نوزدهم")
  }

  test("ordinal: 20 should convert to بیستم") {
    assertEquals(NumToWord.ordinal(20), "بیستم")
  }

  test("ordinal: 21 should convert to بیست و یکم") {
    assertEquals(NumToWord.ordinal(21), "بیست و یکم")
  }

  test("ordinal: 22 should convert to بیست و دوم") {
    assertEquals(NumToWord.ordinal(22), "بیست و دوم")
  }

  test("ordinal: 23 should convert to بیست و سوم") {
    assertEquals(NumToWord.ordinal(23), "بیست و سوم")
  }

  test("ordinal: 30 should convert to سی‌ام") {
    assertEquals(NumToWord.ordinal(30), "سی\u200Cام")
  }

  test("ordinal: 31 should convert to سی و یکم") {
    assertEquals(NumToWord.ordinal(31), "سی و یکم")
  }

  test("ordinal: 33 should convert to سی و سوم") {
    assertEquals(NumToWord.ordinal(33), "سی و سوم")
  }

  test("ordinal: 100 should convert to صدم") {
    assertEquals(NumToWord.ordinal(100), "صدم")
  }

  test("ordinal: 103 should convert to صد و سوم") {
    assertEquals(NumToWord.ordinal(103), "صد و سوم")
  }

  test("ordinal: 130 should convert to صد و سی‌ام") {
    assertEquals(NumToWord.ordinal(130), "صد و سی\u200Cام")
  }

  test("ordinal: 220 should convert to دویست و بیستم") {
    assertEquals(NumToWord.ordinal(220), "دویست و بیستم")
  }

  test("ordinal: 235 should convert to دویست و سی و پنجم") {
    assertEquals(NumToWord.ordinal(235), "دویست و سی و پنجم")
  }

  test("ordinal: 300 should convert to سیصدم") {
    assertEquals(NumToWord.ordinal(300), "سیصدم")
  }

  test("ordinal: 1,000 should convert to یک هزارم") {
    assertEquals(NumToWord.ordinal(1000), "یک هزارم")
  }

  test("ordinal: 1,003 should convert to یک هزار و سوم") {
    assertEquals(NumToWord.ordinal(1003), "یک هزار و سوم")
  }

  test("ordinal: 1,030 should convert to یک هزار و سی‌ام") {
    assertEquals(NumToWord.ordinal(1030), "یک هزار و سی\u200Cام")
  }

  test("ordinal: 100,000 should convert to صد هزارم") {
    assertEquals(NumToWord.ordinal(100000), "صد هزارم")
  }

  test("ordinal: 1,000,000 should convert to یک میلیونم") {
    assertEquals(NumToWord.ordinal(1000000), "یک میلیونم")
  }

  test("ordinal: 100,000,000 should convert to صد میلیونم") {
    assertEquals(NumToWord.ordinal(100000000), "صد میلیونم")
  }

  test("ordinal: 100,000,000,000 should convert to صد میلیاردم") {
    assertEquals(NumToWord.ordinal(100000000000L), "صد میلیاردم")
  }

  // Deprecated apply backwards compatibility tests
  test("apply (deprecated): 0 should convert to صفر") {
    @scala.annotation.nowarn("cat=deprecation")
    def check(): Unit = {
      assertEquals(NumToWord(0), "صفر")
    }
    check()
  }

  test("apply (deprecated): 235 should convert to دویست و سی و پنج") {
    @scala.annotation.nowarn("cat=deprecation")
    def check(): Unit = {
      assertEquals(NumToWord(235), "دویست و سی و پنج")
    }
    check()
  }
}
