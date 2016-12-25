/**
 * This file is part of PersianUtils.
 *
 * CREDITS:
 *   All the credits go to Mr. Kazimierz M. Borkowski for his
 *   priceless article:
 *     The Persian calendar for 3000 years
 *     http://www.astro.uni.torun.pl/~kb/Papers/EMP/PersianC-EMP.htm
 */
package com.bahmanm.persianutils

class InvalidDateException extends Exception {}

/**
 * @author Bahman Movaqar (Bahman AT BahmanM.com)
 */
object DateConverter {

  /**
   * A simple date representation used in DateConverter. It can represent a date in any calendar.
   */
  case class SimpleDate(year: Int, month: Int, day: Int) {

    override def toString = year + "/" + month + "/" + day

    def asDate = {
      import java.util.Calendar

      val c = Calendar.getInstance()
      c.set(Calendar.YEAR, year)
      c.set(Calendar.MONTH, month-1)
      c.set(Calendar.DAY_OF_MONTH, day)
      c.getTime
    }

  }

  object SimpleDate {

    def apply(date: String) = {
      val re = new scala.util.matching.Regex(
          """(\d\d\d\d)/(\d\d)/(\d\d)""",
          "year", "month", "day")
      try {
        val re(year, month, day) = date
        new SimpleDate(year.toInt, month.toInt, day.toInt)
      } catch {
        case _ : Throwable =>
          throw new InvalidDateException()
      }
    }

    def apply(date: java.util.Date) = {
      new SimpleDate(date.getYear + 1900, date.getMonth + 1,
          date.getDate)
    }

  }

  /**
   * Converts a Persian (a.k.a Jalali) date to Gregorian date.
   * @param date Persian date as SimpleDate
   * @return Gregorian date as SimpleDate
   */
  def persianToGregorian(date: SimpleDate) = {
    val jDay = persianDateToJulianDay(date)
    julianDayToGregorianDate(jDay)
  }

  /**
   * Converts a Gregorian date to Persian (a.k.a Jalali) date.
   * @param date Gregorian date as SimpleDate
   * @return Persian date as SimpleDate
   */
  def gregorianToPersian(date: SimpleDate) = {
    val jDay = gregorianDateToJulianDay(date)
    julianDayToPersianDate(jDay)
  }

  private case class PersianYearInfo(leap: Int, gYear: Int, marchDay: Int)

  private def persianDateToJulianDay(date: SimpleDate) = {
    val info = persianYearInfo(date.year)
    gregorianDateToJulianDay(SimpleDate(info.gYear, 3, info.marchDay)) +
      (date.month - 1) * 31 - date.month / 7 *
      (date.month - 7) + date.day - 1
  }

  private def gregorianDateToJulianDay(date: SimpleDate) = {
    val x = (date.year + (date.month - 8) / 6 + 100100) *
      1461 / 4 + (153 * ((date.month + 9) % 12) + 2) / 5 +
      date.day - 34840408
    x - (date.year + 100100 + (date.month - 8) / 6) /
      100 * 3 / 4 + 752
  }

  private def julianDayToGregorianDate(day: Int) = {
    val j = 4 * day + 139361631 +
      (4 * day + 183187720) / 146097 * 3 / 4 * 4 - 3908
    val i = (j % 1461) / 4 * 5 + 308
    val d = (i % 153) / 5 + 1
    val m = (i / 153 % 12) + 1
    val y = j / 1461 - 100100 + (8 - m) / 6
    SimpleDate(y, m, d)
  }

  private def julianDayToPersianDate(day: Int) = {
    val gDate = julianDayToGregorianDate(day)
    val pYear = gDate.year - 621
    val info = persianYearInfo(pYear)
    val jDay1Farvardin = gregorianDateToJulianDay(
      SimpleDate(info.gYear, 3, info.marchDay))
    val daysPassed = day - jDay1Farvardin
    if (daysPassed >= 0)
      if (daysPassed <= 185)
        SimpleDate(pYear, (1 + daysPassed / 31), (daysPassed % 31) + 1)
      else {
        val daysPassed1 = daysPassed - 186
        SimpleDate(pYear, (7 + daysPassed1 / 30), (daysPassed1 % 30) + 1)
      }
    else {
      val daysPassed1 = daysPassed + 179 + (if (info.leap == 1) 1 else 0)
      SimpleDate(pYear - 1, (7 + daysPassed1 / 30), (daysPassed1 % 30) + 1)
    }
  }

  private def persianYearInfo(pYear: Int) = {
    val breaks = Seq(-61, 9, 38, 199, 426, 686, 756, 818, 1111,
      1181, 1210, 1635, 2060, 2097, 2192, 2262, 2324, 2394,
      2456, 3178) filter { x => x <= pYear }
    val gYear = pYear + 621
    val gLeaps = gYear / 4 - (gYear / 100 + 1) * 3 / 4 - 150
    val (pLeaps, remainingBreaks) = computePersianLeaps(-14, breaks, 0, pYear)
    val n = computeN(breaks(0), remainingBreaks, pYear)
    val marchDay = 20 + pLeaps - gLeaps
    val leap1 = (((n + 1) % 33) - 1) % 4
    val leap = if (leap1 == -1) 4 else leap1
    PersianYearInfo(leap, gYear, marchDay)
  }

  private def computeN(initialBreak: Int, breaks: Seq[Int], pYear: Int): Int = {
    if (breaks.length < 1)
      pYear - initialBreak
    else {
      val n = pYear - initialBreak
      val delta = breaks(0) - initialBreak
      if ((delta - n) < 6)
        n - delta + (((delta + 4) / 33) * 33)
      else
        n
    }
  }

  private def computePersianLeaps(accResult: Int, breaks: Seq[Int],
                                  previousDelta: Int, pYear: Int): (Int, Seq[Int]) = {
    if (pYear < breaks.head)
      (breaks.head, breaks)
    else if (breaks.length < 2) {
      val n = pYear - breaks.head
      val accResult1 = accResult + n / 33 * 8 + ((n % 33) + 3) / 4
      if ((previousDelta % 33) == 4 && (previousDelta - n == 4))
        (accResult1 + 1, breaks)
      else
        (accResult1, breaks)
    } else {
      val delta = breaks(1) - breaks(0)
      val accResult1 = accResult + delta / 33 * 8 + (delta % 33) / 4
      computePersianLeaps(accResult1, breaks.drop(1), delta, pYear)
    }
  }

}
