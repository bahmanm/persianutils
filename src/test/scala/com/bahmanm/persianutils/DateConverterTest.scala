package com.bahmanm.persianutils

import java.time.LocalDate
import com.bahmanm.persianutils.DateConverter._

class DateConverterTest extends munit.FunSuite {

  test("Feb 29th, 2012 should equal 10om Esfand 1390") {
    assertEquals(gregorianToPersian(SimpleDate(2012, 2, 29)), SimpleDate(1390, 12, 10))
  }

  test("Feb 29th, 3292 should equal to 11om Esfand 2670") {
    assertEquals(gregorianToPersian(SimpleDate(3292, 2, 29)), SimpleDate(2670, 12, 11))
  }

  test("30om Esfand 1391 should equal March 20th, 2013") {
    assertEquals(persianToGregorian(SimpleDate(1391, 12, 30)), SimpleDate(2013, 3, 20))
  }

  test("30om Esfand 1453 should equal March 20th, 2075") {
    assertEquals(persianToGregorian(SimpleDate(1453, 12, 30)), SimpleDate(2075, 3, 20))
  }

  test("11om Day 1346 should equal January 1st, 1968") {
    assertEquals(persianToGregorian(SimpleDate(1346, 10, 11)), SimpleDate(1968, 1, 1))
  }

  test("Jan 1st, 1968 should equal 11om Day 1346") {
    assertEquals(gregorianToPersian(SimpleDate(1968, 1, 1)), SimpleDate(1346, 10, 11))
  }

  test("Jan 2nd, 1968 should equal 12om Day 1346") {
    assertEquals(gregorianToPersian(SimpleDate(1968, 1, 2)), SimpleDate(1346, 10, 12))
  }

  test("Jan 1st, 1996 should equal 11om Day 1374") {
    assertEquals(gregorianToPersian(SimpleDate(1996, 1, 1)), SimpleDate(1374, 10, 11))
  }

  test("March 20th, 2030 should equal 30om Esfand 1408") {
    assertEquals(gregorianToPersian(SimpleDate(2030, 3, 20)), SimpleDate(1408, 12, 30))
  }

  test("Strongly typed GregorianDate to PersianDate conversion") {
    val gDate = GregorianDate(2012, 2, 29)
    val pDate = gregorianToPersian(gDate)
    assertEquals(pDate, PersianDate(1390, 12, 10))
  }

  test("Strongly typed PersianDate to GregorianDate conversion") {
    val pDate = PersianDate(1391, 12, 30)
    val gDate = persianToGregorian(pDate)
    assertEquals(gDate, GregorianDate(2013, 3, 20))
  }

  test("Strongly typed date string parsing") {
    assertEquals(PersianDate("1392/09/24"), PersianDate(1392, 9, 24))
    assertEquals(GregorianDate("2013/12/15"), GregorianDate(2013, 12, 15))
  }

  test("GregorianDate to and from java.time.LocalDate") {
    val localDate = LocalDate.of(2012, 2, 29)
    val gDate = GregorianDate(localDate)
    assertEquals(gDate, GregorianDate(2012, 2, 29))
    assertEquals(gDate.asLocalDate, localDate)
  }

  test("PersianDate to and from java.time.LocalDate") {
    val localDate = LocalDate.of(2012, 2, 29)
    val pDate = PersianDate(localDate)
    assertEquals(pDate, PersianDate(1390, 12, 10))
    assertEquals(pDate.asLocalDate, localDate)

    val pDate2 = PersianDate(1391, 12, 30)
    assertEquals(pDate2.asLocalDate, LocalDate.of(2013, 3, 20))
    assertEquals(PersianDate(LocalDate.of(2013, 3, 20)), pDate2)
  }

  test("DateConverter.gregorianToPersian with java.time.LocalDate") {
    val localDate = LocalDate.of(2012, 2, 29)
    val pDate = gregorianToPersian(localDate)
    assertEquals(pDate, PersianDate(1390, 12, 10))
  }

  test("SimpleDate to and from java.time.LocalDate") {
    val localDate = LocalDate.of(2012, 2, 29)
    val sDate = SimpleDate(localDate)
    assertEquals(sDate, SimpleDate(2012, 2, 29))
    assertEquals(sDate.asLocalDate, localDate)
  }

  test("Backwards compatibility: deprecated java.util.Date conversions") {
    val sDate = SimpleDate(2012, 2, 29)
    val utilDate = sDate.asDate
    val recreated = SimpleDate(utilDate)
    assertEquals(recreated, sDate)
  }

}
