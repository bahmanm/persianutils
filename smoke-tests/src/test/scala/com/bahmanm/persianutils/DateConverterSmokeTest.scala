package com.bahmanm.persianutils

import java.time.LocalDate

class DateConverterSmokeTest extends munit.FunSuite {

  test("Persian to Gregorian conversion") {
    val pDate = PersianDate(1402, 1, 1)
    val gDate = DateConverter.persianToGregorian(pDate)
    assertEquals(gDate, GregorianDate(2023, 3, 21))
  }

  test("Gregorian to Persian conversion") {
    val gDate = GregorianDate(2023, 3, 21)
    val pDate = DateConverter.gregorianToPersian(gDate)
    assertEquals(pDate, PersianDate(1402, 1, 1))
  }

  test("String initialisation") {
    val pDate = PersianDate("1402/09/24")
    assertEquals(pDate, PersianDate(1402, 9, 24))
    val gDate = DateConverter.persianToGregorian(pDate)
    assertEquals(gDate, GregorianDate(2023, 12, 15))
  }

  test("java.time.LocalDate bridging") {
    val pDate = PersianDate(1402, 1, 1)
    val localDate: LocalDate = pDate.asLocalDate
    assertEquals(localDate, LocalDate.of(2023, 3, 21))

    val gDate = GregorianDate(2023, 3, 21)
    assertEquals(gDate.asLocalDate, LocalDate.of(2023, 3, 21))
  }

}
