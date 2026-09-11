package com.bahmanm.persianutils

class NumToWordTest extends munit.FunSuite {

  test("0 should convert to صفر") {
    assertEquals(NumToWord(0), "صفر")
  }

  test("5 should convert to پنج") {
    assertEquals(NumToWord(5), "پنج")
  }

  test("15 should convert to پانزده") {
    assertEquals(NumToWord(15), "پانزده")
  }

  test("220 should convert to دویست و بیست") {
    assertEquals(NumToWord(220), "دویست و بیست")
  }

  test("220,983 should convert to دویست و بیست هزار و نه‌صد و هشتاد و سه") {
    assertEquals(NumToWord(220983), "دویست و بیست هزار و نه‌صد و هشتاد و سه")
  }

  test("100,000 should convert to صد هزار") {
    assertEquals(NumToWord(100000), "صد هزار")
  }

  test("100,000,000 should convert to صد میلیون") {
    assertEquals(NumToWord(100000000), "صد میلیون")
  }

  test("100,000,000,000 should convert to صد میلیارد") {
    assertEquals(NumToWord(100000000000L), "صد میلیارد")
  }

  test("100,000,000,000,000 should convert to صد هزار میلیارد") {
    assertEquals(NumToWord(100000000000000L), "صد هزار میلیارد")
  }

  test("100,000,233,000,110 should convert to صد هزار میلیارد و دویست و سی و سه میلیون و صد و ده") {
    assertEquals(NumToWord(100000233000110L), "صد هزار میلیارد و دویست و سی و سه میلیون و صد و ده")
  }
}
