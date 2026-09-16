package com.bahmanm.persianutils

import java.time.LocalDate

class DateToWordSmokeTest extends munit.FunSuite {

  test("PersianDate toWords") {
    val date = PersianDate(1402, 1, 1)
    assertEquals(date.toWords, "یکم فروردین یک هزار و چهار‌صد و دو")
    assertEquals(DateToWord(date), "یکم فروردین یک هزار و چهار‌صد و دو")
    assertEquals(DateToWord.persian(1402, 1, 1), "یکم فروردین یک هزار و چهار‌صد و دو")
  }

  test("GregorianDate toWords") {
    val date = GregorianDate(2023, 3, 21)
    assertEquals(date.toWords, "بیست و یکم مارس دو هزار و بیست و سه")
    assertEquals(DateToWord(date), "بیست و یکم مارس دو هزار و بیست و سه")
    assertEquals(DateToWord.gregorian(2023, 3, 21), "بیست و یکم مارس دو هزار و بیست و سه")
    assertEquals(DateToWord.gregorian(LocalDate.of(2023, 3, 21)), "بیست و یکم مارس دو هزار و بیست و سه")
  }

}
